/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider,$qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
    IdleProvider.idle(5);
    IdleProvider.timeout(120);
    $urlRouterProvider.otherwise("/content/statistic/statistics");
    $ocLazyLoadProvider.config({
        debug: false
    });

    $stateProvider
        //基础
        .state('content',{
            abstract:true,
            url: "/content",
            templateUrl: "views/common/content.html",
            resolve:{
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie:true,
                            name: 'toaster',
                            files: ['js/plugins/angular-toaster/toaster.min.js', 'css/plugins/angular-toaster/toaster.min.css']
                        }
                    ]);
                }
            }
        })
        //首页
        .state('content.statistic',{
            abstract:true,
            url: "/statistic",
            templateUrl: "views/common/base_view.html"
        })
        .state('content.statistic.statistics',{
            url: "/statistics",
            templateUrl: "views/systemStatistics/statistics.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js' ]
                        },
                        {
                            name: 'ui.checkbox',
                            files: ['js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        //系统管理
        .state('content.system',{
            abstract:true,
            url: "/system",
            templateUrl: "views/common/base_view.html"
        })
        .state('content.system.systemLog',{
            url: "/systemLog",
            templateUrl: "views/systemLog/systemLog.html"
        })
        .state('content.system.systemConstant',{
            url: "/systemConstant",
            templateUrl: "views/systemConstant/systemConstant.html"
        })
        //用户管理
        .state('content.user',{
            abstract:true,
            url: "/user",
            templateUrl: "views/common/base_view.html"
        })
        .state('content.user.system',{
            url: "/systemUser",
            templateUrl: "views/systemUser/systemUser.html"
        })
        .state('content.user.systemRole',{
            url: "/systemRole",
            templateUrl: "views/systemUser/systemRole.html"
        })
        //订单管理
        .state('content.order',{
            abstract:true,
            url: "/order",
            templateUrl: "views/common/base_view.html"
        })
        .state('content.order.systemOrderInfo',{
            url: "/orderInfo",
            templateUrl: "views/systemOrderInfo/orderInfo.html"
        })
        //商品管理
        .state('content.merchant',{
            abstract:true,
            url: "/merchant",
            templateUrl: "views/common/base_view.html"
        })
        .state('content.merchant.systemMerchantInfo',{
            url: "/merchantInfo",
            templateUrl: "views/systemMerchantInfo/merchantInfo.html"
        })
}
angular
    .module('inspinia')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
