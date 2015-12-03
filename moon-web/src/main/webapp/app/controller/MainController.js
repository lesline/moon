/**
 *主 controller ，登录界面过后看见的界面
 *
 * 所有逻辑代码都在这里写
 */
Ext.define('AM.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: [
        'MainView'
    ]
    ,
    init: function () {
        //显示主界面
        var view = this.getView('MainView').create(), self = this;
        //添加加载菜单事件
        view.addEvents({
            afterrender: self.loadMenuResources(Ext.getCmp('sysMenu'))
        });
    },
    //根据权限加载菜单
    loadMenuResources: function (view) {
        var menuArray = [];
        var _self = this;
        menuArray.push({
            title: "交易",
            xtype: 'panel',
            menulv1: 'true',
            autoScroll: true,
            items: {
                xtype: 'treepanel',
                rootVisible: false,
                lines: false,
                border: false,
                autoScroll: 'none',
                store: Ext.create('AM.store.Menus'),
                listeners: {
                    itemclick: function (view, record, item, index, e, eOpts) {   //选择菜单事件
                        _self.createController(record);
                    }
                }
            }
        });
        view.add(menuArray);
    },

    createController: function (record) {
        var _self = AM.app.getController('MainController');
        var tabId = record.get('id');
        var className = record.get('url');
        var modelName = record.get('text');

        if (typeof(tabId) == 'undefined' || tabId == null || tabId == '') {
            return;
        }

        //加载 controller;
        try {
            var modelController = _self.getController(className),
                tabPanel = Ext.getCmp('mainTabPanel'),
                contentView = Ext.getCmp(tabId);
            console.info(tabId + "|" + contentView);
            if (contentView) {
                if (!tabPanel.getComponent(tabId)) {
                    tabPanel.add(contentView);
                }
                tabPanel.setActiveTab(contentView);
            } else {
                if (modelController.getMainView) {
                    var infoMainView = modelController.getMainView.apply(modelController, arguments);
                    contentView = tabPanel.add({
                        id: tabId,
                        title: modelName,
                        closable: true,
                        closeAction: 'hide',
                        layout: 'fit',
                        //iconCls: record.get('iconCls'),
                        items: infoMainView

                    });
                    tabPanel.setActiveTab(contentView);

                }
            }
        } catch (err) {
            Ext.MessageBox.show({
                title: '提示',
                msg: '网络错误:【' + modelName + '】功能加载失败！',
                icon: Ext.MessageBox.ERROR,
                buttons: Ext.Msg.OK
            });
        }
    }

});
