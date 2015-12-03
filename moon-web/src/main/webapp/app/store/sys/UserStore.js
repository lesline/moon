Ext.define('AM.store.sys.UserStore', {
    extend: 'Ext.data.Store',
    model: 'AM.model.sys.User',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'rest/user/users.json',
            update: 'rest/user/updateUsers.json'
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