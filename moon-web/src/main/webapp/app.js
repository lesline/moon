var wr = {};
wr.version = 1.0;
//全局配置
wr.winStyle = {buttonAlign: 'center'};
//定义 AM
var AM = wr;

//启动程序
Ext.onReady(function () {
    // load app
    loadApp();
});


/**
 * app  入口程序
 */
var loadApp = function () {
    Ext.application({
        name: 'AM',      //程序名称
        appFolder: 'app',  //程序文件目录
        requires: [
            'AM.util.CommonFunc'
        ],
        controllers: ['MainController']  //main控制器
    });
};


//Ext.application({
//    requires: ['Ext.container.Viewport'],
//    name: 'AM',
//    appFolder: 'app',
//
//
//    controllers: [
//        //'Users'
//        'MainController'
//    ],
//});

//launch: function () {
//    Ext.create('Ext.container.Viewport', {
//        layout: 'fit',
//        items: {
//            xtype: 'userlist'
//        }
//    });
//}

//launch: function() {
//    Ext.create('Ext.container.Viewport', {
//        layout: 'fit',
//        items: [
//            {
//                xtype: 'panel',
//                title: 'Users',
//                html : 'List of users will go here'
//            }
//        ]
//    });
//}
