
function MainCtrl($scope,$state) {

    /**
     * tags - Used as advanced forms view in input tag control
     */
    this.tags = [
        {text: 'Amsterdam'},
        {text: 'Washington'},
        {text: 'Sydney'},
        {text: 'Cairo'},
        {text: 'Beijing'}
    ];

    /**
     * states - Data used in Advanced Form view for Chosen plugin
     */
    this.states = [
        'Alabama',
        'Alaska',
        'Arizona',
        'Arkansas',
        'California',
        'Colorado',
        'Connecticut',
        'Delaware',
        'Florida',
        'Georgia',
        'Hawaii',
        'Idaho',
        'Illinois',
        'Indiana',
        'Iowa',
        'Kansas',
        'Kentucky',
        'Louisiana',
        'Maine',
        'Maryland',
        'Massachusetts',
        'Michigan',
        'Minnesota',
        'Mississippi',
        'Missouri',
        'Montana',
        'Nebraska',
        'Nevada',
        'New Hampshire',
        'New Jersey',
        'New Mexico',
        'New York',
        'North Carolina',
        'North Dakota',
        'Ohio',
        'Oklahoma',
        'Oregon',
        'Pennsylvania',
        'Rhode Island',
        'South Carolina',
        'South Dakota',
        'Tennessee',
        'Texas',
        'Utah',
        'Vermont',
        'Virginia',
        'Washington',
        'West Virginia',
        'Wisconsin',
        'Wyoming'
    ];

    /**
     * check's - Few variables for checkbox input used in iCheck plugin. Only for demo purpose
     */
    this.maxSize = 5;

    /**
     * groups - used for Collapse panels in Tabs and Panels view
     */
    this.groups = [
        {
            title: 'Dynamic Group Header - 1',
            content: 'Dynamic Group Body - 1'
        },
        {
            title: 'Dynamic Group Header - 2',
            content: 'Dynamic Group Body - 2'
        }
    ];

    /**
     * alerts - used for dynamic alerts in Notifications and Tooltips view
     */
    this.alerts = [
        {type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.'},
        {type: 'success', msg: 'Well done! You successfully read this important alert message.'},
        {type: 'info', msg: 'OK, You are done a great job man.'}
    ];

    $scope.stateReload = function (stateName) {
            $state.reload(stateName);
    }
};

/**
 * dashboardFlotTwo - simple controller for data
 * for Flot chart in Dashboard view
 */
function dashboardFlotTwo() {

    var data1 = [
        [gd(2012, 1, 1), 7],
        [gd(2012, 1, 2), 6],
        [gd(2012, 1, 3), 4],
        [gd(2012, 1, 4), 8],
        [gd(2012, 1, 5), 9],
        [gd(2012, 1, 6), 7],
        [gd(2012, 1, 7), 5],
        [gd(2012, 1, 8), 4],
        [gd(2012, 1, 9), 7],
        [gd(2012, 1, 10), 8],
        [gd(2012, 1, 11), 9],
        [gd(2012, 1, 12), 6],
        [gd(2012, 1, 13), 4],
        [gd(2012, 1, 14), 5],
        [gd(2012, 1, 15), 11],
        [gd(2012, 1, 16), 8],
        [gd(2012, 1, 17), 8],
        [gd(2012, 1, 18), 11],
        [gd(2012, 1, 19), 11],
        [gd(2012, 1, 20), 6],
        [gd(2012, 1, 21), 6],
        [gd(2012, 1, 22), 8],
        [gd(2012, 1, 23), 11],
        [gd(2012, 1, 24), 13],
        [gd(2012, 1, 25), 7],
        [gd(2012, 1, 26), 9],
        [gd(2012, 1, 27), 9],
        [gd(2012, 1, 28), 8],
        [gd(2012, 1, 29), 5],
        [gd(2012, 1, 30), 8],
        [gd(2012, 1, 31), 25]
    ];

    var data2 = [
        [gd(2012, 1, 1), 800],
        [gd(2012, 1, 2), 500],
        [gd(2012, 1, 3), 600],
        [gd(2012, 1, 4), 700],
        [gd(2012, 1, 5), 500],
        [gd(2012, 1, 6), 456],
        [gd(2012, 1, 7), 800],
        [gd(2012, 1, 8), 589],
        [gd(2012, 1, 9), 467],
        [gd(2012, 1, 10), 876],
        [gd(2012, 1, 11), 689],
        [gd(2012, 1, 12), 700],
        [gd(2012, 1, 13), 500],
        [gd(2012, 1, 14), 600],
        [gd(2012, 1, 15), 700],
        [gd(2012, 1, 16), 786],
        [gd(2012, 1, 17), 345],
        [gd(2012, 1, 18), 888],
        [gd(2012, 1, 19), 888],
        [gd(2012, 1, 20), 888],
        [gd(2012, 1, 21), 987],
        [gd(2012, 1, 22), 444],
        [gd(2012, 1, 23), 999],
        [gd(2012, 1, 24), 567],
        [gd(2012, 1, 25), 786],
        [gd(2012, 1, 26), 666],
        [gd(2012, 1, 27), 888],
        [gd(2012, 1, 28), 900],
        [gd(2012, 1, 29), 178],
        [gd(2012, 1, 30), 555],
        [gd(2012, 1, 31), 993]
    ];


    var dataset = [
        {
            label: "Number of orders",
            grow: {stepMode: "linear"},
            data: data2,
            color: "#1ab394",
            bars: {
                show: true,
                align: "center",
                barWidth: 24 * 60 * 60 * 600,
                lineWidth: 0
            }

        },
        {
            label: "Payments",
            grow: {stepMode: "linear"},
            data: data1,
            yaxis: 2,
            color: "#1C84C6",
            lines: {
                lineWidth: 1,
                show: true,
                fill: true,
                fillColor: {
                    colors: [
                        {
                            opacity: 0.2
                        },
                        {
                            opacity: 0.2
                        }
                    ]
                }
            }
        }
    ];


    var options = {
        grid: {
            hoverable: true,
            clickable: true,
            tickColor: "#d5d5d5",
            borderWidth: 0,
            color: '#d5d5d5'
        },
        colors: ["#1ab394", "#464f88"],
        tooltip: true,
        xaxis: {
            mode: "time",
            tickSize: [3, "day"],
            tickLength: 0,
            axisLabel: "Date",
            axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Arial',
            axisLabelPadding: 10,
            color: "#d5d5d5"
        },
        yaxes: [
            {
                position: "left",
                max: 1070,
                color: "#d5d5d5",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Arial',
                axisLabelPadding: 3
            },
            {
                position: "right",
                color: "#d5d5d5",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: ' Arial',
                axisLabelPadding: 67
            }
        ],
        legend: {
            noColumns: 1,
            labelBoxBorderColor: "#d5d5d5",
            position: "nw"
        }

    };

    function gd(year, month, day) {
        return new Date(year, month - 1, day).getTime();
    }

    /**
     * Definition of variables
     * Flot chart
     */
    this.flotData = dataset;
    this.flotOptions = options;
}


function translateCtrl($translate, $scope) {
    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
        $scope.language = langKey;
    };
}

//系统日志
function systemLogCtrl(NgTableParams,httpClient,$scope,$uibModal) {
    //双向绑定搜索域
    $scope.pageSearch = {};
    //获取系统日志信息
    $scope.systemLogTable = new NgTableParams({},{
        getData: function (params) {
            angular.element('.ibox-content').addClass('sk-loading');
            return httpClient.getData('/systemLog/getSystemLogList',{
                params:{
                    pageNum:params.page(),
                    pageCount:params.count(),
                    pageSearchString:angular.toJson($scope.pageSearch)
                }
            }).then(function (value) {
                    params.total(value.total);
                    angular.element('.ibox-content').removeClass('sk-loading');
                    return value.resultData;
            });
        }
    });
    //日历开始时间
    $scope.openStartOptions = function () {
        $scope.startOptions = true;
    };
    //最大开始时间
    $scope.startDateOptions = {
        maxDate: new Date()
    };
    //日历结束时间
    $scope.openEndOptions = function () {
        $scope.endOptions = true;
    };
    $scope.disableEndFlag = true;
    //最大结束时间
    $scope.endDateOptions = {
        maxDate: new Date(),
        minDate: undefined
    };
    //选择校验日历
    $scope.format = 'yyyy-MM-dd';
    //开始时间选择
    $scope.$watch('pageSearch.startTime',function (newVal) {
        if (newVal !== undefined && newVal != null) {
            $scope.endDateOptions.minDate = $scope.pageSearch.startTime;
            $scope.disableEndFlag = false;
        }else{
            $scope.disableEndFlag = true;
        }
    });
    //结束时间选择
    $scope.$watch('pageSearch.endTime',function (newVal) {
        if (newVal !== undefined && newVal != null) {
            $scope.startDateOptions.maxDate = $scope.pageSearch.endTime;
        }
    });
    //重置方法
    $scope.reset = function () {
        $scope.pageSearch = {};
        $scope.systemLogTable.page(1);
        $scope.systemLogTable.reload();
    };
    //查询方法
    $scope.search = function () {
        $scope.systemLogTable.page(1);
        $scope.systemLogTable.reload();
    };
    //查看异常方法
    $scope.viewException = function (exceptionInfo) {
        var modalInstance = $uibModal.open({
            templateUrl:'/views/systemConfig/systemLogModal',
            controller: 'systemLogModalCtrl',
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            keyboard: true,
            size: 'lg',
            resolve: {
                exceptionInfo:function () {
                    return exceptionInfo;
                }
            }
        });
    };
}

//系统日志modal
function systemLogModalCtrl($scope,exceptionInfo,$uibModalInstance) {
    //双向绑定
    $scope.exceptionInfo = exceptionInfo;
    //取消操作
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    }
}

//系统常量
function systemConstantCtrl($scope,NgTableParams,httpClient) {
    $scope.systemConstantTable = new NgTableParams({},{
        getData:function (params) {
            return httpClient.getData('/systemLog/getSystem',{
                params:{
                    pageNum:params.page(),
                    pageCount:params.count()
                }
            }).then(function (value) {
                params.total(value.total);
                angular.element('.ibox-content').removeClass('sk-loading');
                return value.resultData;
            });
        } 
    });
}

//用户信息
function systemUserCtrl($scope,NgTableParams,httpClient) {
    //双向绑定搜索域
    $scope.pageSearch = {};
    //同步获取用户信息
    httpClient.getData('/systemUser/getAllSystemUser').then(function (value) {
        console.log(value);
        for (var i = 0; i < value.length; i++){
            value[i]['roleName'] = '';
            for (var j = 0; j < value[i].userRoleList.length; j++){
                value[i]['roleName'] += value[i].userRoleList[j].roleName;
                if (j !== value[i].userRoleList.length - 1) {
                    value[i]['roleName'] += '，';
                }
            }
        }
        $scope.systemUserTable = new NgTableParams({},{
            dataset:value
        });
    });
}

function systemRoleCtrl() {

}

function systemOrderInfoCtrl() {

}

function systemMerchantInfoCtrl() {

}
/**
 *
 * Pass all functions into module
 */
angular
    .module('inspinia')
    .controller('MainCtrl', MainCtrl)
    .controller('dashboardFlotTwo', dashboardFlotTwo)
    .controller('translateCtrl',translateCtrl)
    .controller('systemLogCtrl',systemLogCtrl)
    .controller('systemLogModalCtrl',systemLogModalCtrl)
    .controller('systemConstantCtrl',systemConstantCtrl)
    .controller('systemUserCtrl',systemUserCtrl)
    .controller('systemRoleCtrl',systemRoleCtrl)
    .controller('systemOrderInfoCtrl',systemOrderInfoCtrl)
    .controller('systemMerchantInfoCtrl',systemMerchantInfoCtrl);

