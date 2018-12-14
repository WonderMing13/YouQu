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
                     console.log(response);
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

angular
    .module('inspinia')
    .service('httpClient',httpClient);



