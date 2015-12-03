Ext.define('AM.store.sys.CustomerStore', {
    extend: 'Ext.data.Store',
    model: 'AM.model.sys.Customer',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'rest/customer/customers.json'
        },
        actionMethods: {
            read: 'POST'
        },
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount',
            messageProperty: 'message'
        },
        limitParam: 'pageSize'
    }


});