/**
 * Created with IntelliJ IDEA.
 * @author: 王德明
 * @Date: 2018/12/11
 * @Time: 14:19
 * @Project: youqu
 * @Package:
 */

/**
 *  封装http post操作
 *  angularJs 基于XMLHttpRequest封装$http的异步操作
 *  data: *
 *  url: String
 *  Content-Type: application/json
 *  $q封装返回的数据为promise对象,promise是一个异步的对象
 *  reject:阻止错误相当于throw
 * @param $http
 * @param $q
 * @param toaster
 * @returns {{getData: (function(*=, *=): *)}}
 */
function httpClient($http,$q,toaster) {
     return {
         getData:function (url,data) {
             var defered = $q.defer();
             $http.post(url,data)
                 .then(function successCallback(response) {
                    defered.resolve(response.data);
             },function errorCallback(response) {
                 if (response.status < 200 || response.status > 299) {
                     toaster.pop({
                         type: 'error',
                         title: '异常错误',
                         body: '请呼叫Wonder！'
                     });
                 }
                 defered.reject(response);
             });
             return defered.promise;
         }
     }
}

function csvExp() {
    return {
        /*
         * obj是一个对象，其中包含有：
         * ## data 是导出的具体数据
         * ## fileName 是导出时保存的文件名称 是string格式
         * ## showLabel 表示是否显示表头 默认显示 是布尔格式
         * ## columns 是表头对象，且title和key必须一一对应，包含有
              title:[], // 表头展示的文字
              key:[], // 获取数据的Key
              formatter: function() // 自定义设置当前数据的 传入(key, value)
         */
        export: function (obj) {
            if (obj['data'].length !== 0) {
                var bw = this.browser();
                if (bw['ie'] < 9) return; // IE9以下的
                var data = obj['data'],
                    ShowLabel = typeof obj['showLabel'] === 'undefined' ? true : obj['showLabel'],
                    fileName = (obj['fileName'] || 'UserExport') + '.csv',
                    columns = obj['columns'] || {
                        title: [],
                        key: [],
                        formatter: undefined
                    };
                ShowLabel = typeof ShowLabel === 'undefined' ? true : ShowLabel;
                var row = "", CSV = '', key;
                // 如果要现实表头文字
                if (ShowLabel) {
                    // 如果有传入自定义的表头文字
                    if (columns.title.length) {
                        columns.title.map(function (n) {
                            row += n + ',';
                        });
                    } else {
                        // 如果没有，就直接取数据第一条的对象的属性
                        for (key in data[0]) row += key + ',';
                    }
                    row = row.slice(0, -1); // 删除最后一个,号，即a,b, => a,b
                    CSV += row + '\r\n'; // 添加换行符号
                }
                // 具体的数据处理
                data.map(function (n) {
                    row = '';
                    // 如果存在自定义key值
                    if (columns.key.length) {
                        columns.key.map(function (m) {
                            row += '"' + (typeof columns.formatter === 'function' ? columns.formatter(m, n[m]) || n[m] : n[m]) + '\t",';
                        });
                    } else {
                        for (key in n) {
                            row += '"' + (typeof columns.formatter === 'function' ? columns.formatter(key, n[key]) || n[key] : n[key]) + '\t",';
                        }
                    }
                    row.slice(0, row.length - 1); // 删除最后一个,
                    CSV += row + '\r\n'; // 添加换行符号
                });
                if (!CSV) return;
                this.SaveAs(fileName, CSV);
                return true;
            }
            return false;
        },
        SaveAs: function (fileName, csvData) {
            var bw = this.browser();
            if (!bw['edge'] || !bw['ie']) {
                var alink = document.createElement("a");
                alink.id = "linkDwnldLink";
                alink.href = this.getDownloadUrl(csvData);
                document.body.appendChild(alink);
                var linkDom = document.getElementById('linkDwnldLink');
                linkDom.setAttribute('download', fileName);
                linkDom.click();
                document.body.removeChild(linkDom);
            } else if (bw['ie'] >= 10 || bw['edge'] === 'edge') {
                var _utf = "\uFEFF";
                var _csvData = new Blob([_utf + csvData], {
                    type: 'text/csv;charset=UTF-8'
                });
                navigator.msSaveBlob(_csvData, fileName);
            } else {
                var oWin = window.top.open("about:blank", "_blank");
                oWin.document.write('sep=,\r\n' + csvData);
                oWin.document.close();
                oWin.document.execCommand('SaveAs', true, fileName);
                oWin.close();
            }
        },
        getDownloadUrl: function (csvData) {
            var _utf = "\uFEFF"; // 为了使Excel以utf-8的编码模式，同时也是解决中文乱码的问题
            if (window.Blob && window.URL && window.URL.createObjectURL) {
                csvData = new Blob([_utf + csvData], {
                    type: 'text/csv;charset=UTF-8'
                });
                return URL.createObjectURL(csvData);
            }
            // return 'data:attachment/csv;charset=utf-8,' + _utf + encodeURIComponent(csvData);
        },
        browser: function () {
            var Sys = {};
            var ua = navigator.userAgent.toLowerCase();
            var s;
            (s = ua.indexOf('edge') !== -1 ? Sys.edge = 'edge' : ua.match(/rv:([\d.]+)\) like gecko/)) ? Sys.ie = s[1] :
                (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
                    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
                        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
                            (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                                (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
            return Sys;
        }
    }
}

angular
    .module('inspinia')
    .service('httpClient',httpClient)
    .service('csvExp',csvExp);



