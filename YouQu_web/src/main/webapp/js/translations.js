/**
 *  angular-template 翻译模板
 *
 */
function config($translateProvider) {
    $translateProvider
        .translations('zh_CN', {
            HOME_STATISTICS: '首页统计',
            SYSTEM_MANAGER: '系统管理',
            SYSTEM_LOG: '系统日志',
            SYSTEM_CONSTANT: '系统常量',
            SYSTEM_USER_MANAGER: '用户管理',
            SYSTEM_USER_INFO: '用户信息',
            SYSTEM_UER_ROLE: '用户角色',
            SYSTEM_ORDER_INFO_MANAGER: '订单管理',
            SYSTEM_ORDER_INFO: '订单信息',
            SYSTEM_MERCHANT_INFO_MANAGER: '商品管理',
            SYSTEM_MERCHANT_INFO: '商品信息',
            LANGUAGE: '语言选择'
        })
        .translations('en', {
            HOME_STATISTICS: 'Home_Statistics',
            SYSTEM_MANAGER: 'System_Manager',
            SYSTEM_LOG: 'System_Log',
            SYSTEM_CONSTANT: 'System_Constant',
            SYSTEM_USER_MANAGER: 'System_User_Manager',
            SYSTEM_USER_INFO: 'System_User_Info',
            SYSTEM_USER_ROLE: 'System_User_Role',
            SYSTEM_ORDER_INFO_MANAGER: 'System_Order_Info_Manager',
            SYSTEM_ORDER_INFO: 'System_Order_Info',
            SYSTEM_MERCHANT_INFO_MANAGER: 'System_Merchant_Info_Manager',
            SYSTEM_MERCHANT_INFO: 'System_Merchant_Info',
            LANGUAGE: 'Language'
        });
    $translateProvider.preferredLanguage('zh_CN');
    $translateProvider.useSanitizeValueStrategy('escape');
}

angular
    .module('inspinia')
    .config(config);
