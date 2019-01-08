/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider) {
    // Configure Idle settings
    IdleProvider.idle(5); // in seconds
    IdleProvider.timeout(120); // in seconds
    // 初始启动页面
    $urlRouterProvider.otherwise("/dashboards/dashboard");
    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider
        //首页
        .state('dashboards', {
            abstract: true,
            url: "/dashboards",
            templateUrl: "views/common/content.html"
        })
        .state('dashboards.dashboard', {
            url: "/dashboard",
            templateUrl: "views/dashboard.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js' ]
                        },
                        {
                            serie: true,
                            files: ['js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js', 'js/plugins/jvectormap/jquery-jvectormap-2.0.2.css']
                        },
                        {
                            serie: true,
                            files: ['js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        },
                        {
                            name: 'ui.checkbox',
                            files: ['js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        //系统日志
        .state('base_view',{
            abstract:true,
            url: "/system",
            templateUrl: "views/common/content.html"
        })
        .state('base_view.systemLog',{
            url: "/systemLog",
            templateUrl: "views/systemLog/systemlog.html"
        })
        //系统常量
        .state('second_view',{
            abstract:true,
            url: "/first",
            templateUrl: "views/common/content.html"
        })
        .state('base_view.systemConstant',{
            url: "/systemConstant",
            templateUrl: "views/systemConstant/systemconstant.html"
        })
        //用户管理
        .state('third_view',{
            abstract:true,
            url: "/second",
            templateUrl: "views/common/content.html"
        })
        .state('third_view.systemUser',{
            url: "/systemUser",
            templateUrl: "views/systemUser/systemuser.html"
        })

}
angular
    .module('inspinia')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
