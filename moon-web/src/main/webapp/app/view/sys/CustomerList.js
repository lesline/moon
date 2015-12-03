Ext.define('AM.view.sys.CustomerList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.customerlist',
    //title: 'All Customer',
    store: 'sys.CustomerStore',
    viewConfig: {
        loadMask: true
    },
    tbar: {
        layout: {
            type: 'vbox',
            align: 'left'
        },
        defaults: {
            padding: '5px 0',
            border: false
        },
        defaultType: 'toolbar',
        items: [
            {
                defaults: {
                    labelWidth: 60,
                    labelStyle: 'text-align: left',
                    margin: '0 5'
                },
                items: [
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Name',
                        emptyText: 'Name',
                        itemId: 'name'
                    }
                    ,
                    {
                        xtype: 'button',
                        action: 'query',
                        iconCls: button.SEARCH,
                        text: '搜索',
                        width: 80
                    },
                    {
                        xtype: 'button',
                        action: 'exportExcel',
                        iconCls: button.SEARCH,
                        text: '导出excel',
                        width: 100
                    }

                    /*  ,
                     {
                     xtype: 'combo',
                     fieldLabel: '账户类型',
                     store: Ext.create('Ext.data.Store', {
                     fields: ['value', 'name'],
                     data: [
                     {"value": "", "name": "全部"},
                     {"value": "00", "name": "内部用户"},
                     {"value": "01", "name": "投资方"},
                     {"value": "02", "name": "借款方"},
                     {"value": "03", "name": "标的户"}
                     ]
                     }),
                     id: 'settle_cost_accountType_ID',
                     itemId: 'accountType',
                     value: '',
                     editable: false,
                     displayField: 'name',
                     valueField: 'value'
                     }*/
                ]
            }
        ]
    },

    forceFit: true,
    autoScroll: true,
    initComponent: function () {

        this.columns = [
            {header: 'Name', dataIndex: 'name', flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
        var me = this;
        me.store.on('beforeload', me.storeBeforeLoad, me);

    },

    bbar: {
        xtype: 'pagingtoolbar',
        store: 'sys.CustomerStore',
        displayInfo: true,
        displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
        emptyMsg: '无数据'
    },
    storeBeforeLoad: function (store) {
        var me = this,
            name = me.down('#name').getValue();

        var params = {
            name: name
        };
        Ext.apply(store.proxy.extraParams, params);
    }
});