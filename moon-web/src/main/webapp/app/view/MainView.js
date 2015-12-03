/**
 *主界面布局
 */
Ext.define('AM.view.MainView', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.mainView',
    layout: 'border', //border布局
    items: [{
        xtype: 'panel',
        id: 'mainTop',
        height: 50,
        border: 0,
        bodyStyle: {
            //background: 'url(skin/images/bn.jpg) no-repeat #3793d2'
            background:'#3793d2'
        },
        region: 'north',
        layout: 'border',
        items: [{
            xtype: 'container',
            region: 'center',
            layout: {
                type: 'hbox',
                align: 'middle'
            },
            padding: '0 0 0 10',
            items: {
                xtype: 'component',
                style: {
                    fontWeight: 'bold',
                    fontSize: '20px',
                    color: '#FFFFFF'
                },
                html: ''
            }

        }, {
            xtype: 'panel',
            region: 'east',
            bodyStyle: {
                //background: 'url(skin/images/bn.jpg) no-repeat #3793d2',
                background:'#3793d2'
            },
            width: 400,
            border: 0,
            defaults: {
                margin: '0 10 0 0'
            },
            layout: {
                type: 'hbox',
                pack: 'end',
                align: 'middle'
            },
            items: [{
                xtype: 'button',
                iconCls: 'key',
                text: '修改密码',
                handler: function () {

                    var mwin = Ext.create('Ext.window.Window', {
                        title: '修改密码',
                        height: 180,
                        width: 325,
                        layout: 'column',
                        buttonAlign: 'center',
                        items: [{
                            xtype: 'fieldcontainer',
                            layout: 'column',
                            items: [{
                                margin: '10 0 5 0',
                                xtype: 'textfield',
                                fieldLabel: '<span style="color:red">*</span>旧密码',//TODO 自动生成及规则
                                id: 'bm_old_password',
                                inputType: 'password',
                                columnWidth: 2 / 3,
                                allowBlank: false,
                                tooltip: '旧密码不能为空'
                            }]
                        }, {
                            xtype: 'fieldcontainer',
                            layout: 'column',
                            items: [{
                                margin: '0 0 5 0',
                                xtype: 'textfield',
                                inputType: 'password',
                                fieldLabel: '<span style="color:red">*</span>新密码',
                                id: 'bm_new_password_1',
                                columnWidth: 2 / 3,
                                maxLength: 40,
                                maxLengthText: '长度超过40个字符',
                                allowBlank: false,
                                tooltip: '新密码不能为空'
                            }]
                        }, {
                            xtype: 'fieldcontainer',
                            layout: 'column',
                            items: [{
                                margin: '0 0 5 0',
                                xtype: 'textfield',
                                inputType: 'password',
                                fieldLabel: '<span style="color:red">*</span>验证新密码',
                                id: 'bm_new_password_2',
                                columnWidth: 2 / 3,
                                maxLength: 40,
                                maxLengthText: '长度超过40个字符',
                                allowBlank: false,
                                tooltip: '验证新密码不能为空',
                                validator: function (value) {
                                    if (value !== Ext.getCmp('bm_new_password_1').getValue()) {
                                        return '两次新密码不相同';
                                    } else {
                                        return true;
                                    }
                                }
                            }]
                        }],
                        buttons: [{
                            text: '提交',
                            handler: function (/*btn*/) {
                                var old_password = Ext.getCmp('bm_old_password').getValue();
                                var new_password = Ext.getCmp('bm_new_password_1').getValue();
                                var new_password2 = Ext.getCmp('bm_new_password_2').getValue();
                                if (new_password !== new_password2) {
                                    Ext.MessageBox.alert('提示', '两次新密码不相同');
                                    return;
                                }
                                var url = 'rest/login/modifyPass.do';
                                Ext.Ajax.request({
                                    url: url,
                                    params: {old_password: old_password, new_password: new_password},
                                    success: function (result) {
                                        if (result.responseText === '修改成功') {
                                            mwin.close();
                                        }
                                        Ext.MessageBox.alert('提示', result.responseText);

                                    }
                                });
                            }
                        }, {
                            text: '取消',
                            handler: function (/*btn*/) {
                                mwin.close();
                            }
                        }]
                    }).show();

                }
            }]
        }]
    }, {
        xtype: 'container',
        height: 18,
        region: 'south',
        padding: '0 10',
        layout: {
            type: 'hbox',
            align: 'middle'
        },
        defaults: {
            style: {
                color: '#FFFFFF'
            }
        },
        items: [{
            xtype: 'component',
            html: '&nbsp;lesline'
        }]
    }, {
        xtype: 'panel',
        id: 'sysMenu',
        title: '功能导航',
        width: 240,
        //iconCls : 'box',
        collapsible: true, //是否可以折叠
        layout: 'accordion',
        layoutConfig: {
            animate: true,   //开启默认动画效果
            titleCollapse: true,    //设置为点击整个标题栏都可以收缩
            activeOnTop: true   //展开的面板总是在最顶层
        },
        split: true,
        region: 'west'

    }, {
        xtype: 'tabpanel',
        id: 'mainTabPanel',
        activeTab: 0,
        margins: '2 0 0 0',
        region: 'center',
        autoDestroy: false,


        split: true,
        items: [{
            title: '起始页',
            iconCls: 'home',
            xtype: 'panel',
            defaults: {
                margin: 50,
                width: '90%'
            }

        }]
    }]
});


