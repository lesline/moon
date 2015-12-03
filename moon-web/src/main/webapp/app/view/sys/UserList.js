Ext.define('AM.view.sys.UserList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.userlist',
    title: 'All Users',
    // we no longer define the Users store in the `initComponent` method
    store: 'sys.UserStore',
    initComponent: function() {

        this.columns = [
            {header: 'Name',  dataIndex: 'name',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }
});