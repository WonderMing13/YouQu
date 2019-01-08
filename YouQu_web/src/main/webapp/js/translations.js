/**
 *  angular-template 翻译模板
 *
 */
function config($translateProvider) {
    $translateProvider
        .translations('zh_CN', {
            HOME_STATISTICS: '首页统计',
            SYSTEM_LOG: '系统日志',
            SYSTEM_CONSTANT: '系统常量',
            SYSTEM_USER: '用户管理',
            LANGUAGE: '语言选择'
        })
        .translations('en', {
            HOME_STATISTICS: 'Home_Statistics',
            SYSTEM_LOG: 'System_Log',
            SYSTEM_CONSTANT: 'System_Constant',
            SYSTEM_USER: 'System_User',
            LANGUAGE: 'Language'
        });
    $translateProvider.preferredLanguage('zh_CN');
}

angular
    .module('inspinia')
    .config(config);
