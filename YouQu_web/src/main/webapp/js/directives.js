/**
 * INSPINIA - Responsive Admin Theme
 *
 * Main directives.js file
 * Define directives for used plugin
 *
 *
 *
 */


/**
 * pageTitle - Directive for set Page title - mata title
 */
function pageTitle($rootScope, $timeout) {
    return {
        link: function(scope, element) {
            var listener = function(event, toState, toParams, fromState, fromParams) {
                // Default title - load on Dashboard 1
                var title = 'YouQu ADMIN';
                // Create your own title pattern
                if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle;
                $timeout(function() {
                    element.text(title);
                });
            };
            $rootScope.$on('$stateChangeStart', listener);
        }
    }
}

/**
 * sideNavigation - Directive for run metsiMenu on sidebar navigation
 */
function sideNavigation($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element) {
            // Call the metsiMenu plugin and plug it to sidebar navigation
            $timeout(function(){
                element.metisMenu();

            });

            // Colapse menu in mobile mode after click on element
            var menuElement = $('#side-menu a:not([href$="\\#"])');
            menuElement.click(function(){
                if ($(window).width() < 769) {
                    $("body").toggleClass("mini-navbar");
                }
            });

            // Enable initial fixed sidebar
            if ($("body").hasClass('fixed-sidebar')) {
                var sidebar = element.parent();
                sidebar.slimScroll({
                    height: '100%',
                    railOpacity: 0.9,
                });
            }
        }
    };
}



/**
 * minimalizaSidebar - Directive for minimalize sidebar
*/
function minimalizaSidebar($timeout) {
    return {
        restrict: 'A',
        template: '<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="" ng-click="minimalize()"><i class="fa fa-bars"></i></a>',
        controller: function ($scope, $element) {
            $scope.minimalize = function () {
                $("body").toggleClass("mini-navbar");
                if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small')) {
                    // Hide menu in order to smoothly turn on when maximize menu
                    $('#side-menu').hide();
                    // For smoothly turn on menu
                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(400);
                        }, 200);
                } else if ($('body').hasClass('fixed-sidebar')){
                    $('#side-menu').hide();
                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(400);
                        }, 100);
                } else {
                    // Remove all inline style from jquery fadeIn function to reset menu state
                    $('#side-menu').removeAttr('style');
                }
            }
        }
    };
}




/**
 * landingScrollspy - Directive for scrollspy in landing page
 */
function landingScrollspy(){
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.scrollspy({
                target: '.navbar-fixed-top',
                offset: 80
            });
        }
    }
}



/**
 * passwordMeter - Directive for jQuery Password Strength Meter
 */
function passwordMeter() {
    return {
        restrict: 'A',
        scope: {
            pwOptions: '='
        },
        link: function (scope, element, attrs) {
            scope.$watch(scope.pwOptions, function(){
                render();
            });
            var render = function () {
                $(element).pwstrength(scope.pwOptions);
            };
        }
    }
}

/**
 * 分页
 * @returns {{restrict: string, templateUrl: string, scope: {tableParam: string}, link: link}}
 */
function pagePagination() {
    return {
        restrict: 'E',          //作用于标签
        templateUrl: '/views/common/pagination',
        scope: {
             tableParam: '='    //双向绑定
        },
        link: function ($scope) {
            //当前页数
            $scope.currentPage = $scope.tableParam.count();
            //点击页面跳转
            $scope.changePage = function (currentPage) {
                $scope.tableParam.page(currentPage);
            }
        }
    }
}

function userInfoButton() {
    return {
        restrict: 'E',  //作用于标签
        scope: {
            row:'@',isStart:'&',isReset:'&',isChange:'&'
        },
        template:'<div>'+'<button class="btn btn-xs" ng-class="{\'btn-primary\':thisRow.isApply == 1,\'btn-danger\':thisRow.isApply == 0}" ng-click="isStart(thisRow)" style="margin: 0 0 0 10px">{{thisRow.isApply == 1 ? \'启用\' : \'禁用\'}}</button>'+
                 '<button class="btn btn-xs btn-info" style="margin: 0 0 0 10px" ng-click="isReset(thisRow)">重置</button>'+
                 '<button class="btn btn-xs btn-warning" style="margin: 0 0 0 10px" ng-click="isChange(thisRow)">修改</button>'+
                '</div>',
        link:function ($scope) {
            $scope.thisRow = angular.fromJson($scope.row);
        }
    }
}

/**
 *
 * Pass all functions into module
 */
angular
    .module('inspinia')
    .directive('pageTitle', pageTitle)
    .directive('sideNavigation', sideNavigation)
    .directive('minimalizaSidebar', minimalizaSidebar)
    .directive('landingScrollspy', landingScrollspy)
    .directive('passwordMeter', passwordMeter)
    .directive('pagePagination',pagePagination)
    .directive('userInfoButton',userInfoButton);
