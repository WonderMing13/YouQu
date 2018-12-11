/**
 *  angular-template 翻译模板
 *
 */
function config($translateProvider) {
    $translateProvider
        .translations('zh_CN', {
            HOME_STATISTICS: '交易',
            LANGUAGE: '语言选择'
        })
        .translations('en', {
            HOME_STATISTICS: 'Home_Statistics',
            LANGUAGE: 'Language'
        });
    $translateProvider.preferredLanguage('zh_CN');
}

angular
    .module('inspinia')
    .config(config)
