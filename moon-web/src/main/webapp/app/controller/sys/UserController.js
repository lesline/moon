Ext.define('AM.controller.sys.UserController', {
    extend: 'Ext.app.Controller',
    stores: ['sys.UserStore'],
    models: ['sys.User'],
    views: [
        'sys.UserList',
        'sys.UserEdit'
    ],
    getMainView: function () {
        return this.getView('sys.UserList');
    },

    init: function () {
        this.control({
            'userlist': {
                itemdblclick: this.editUser
            },
            'useredit button[action=save]': {
                click: this.updateUser
            }
        });
    },

    editUser: function (grid, record) {
        var view = Ext.widget('useredit');
        view.down('form').loadRecord(record);
    },
    updateUser: function (button) {
        var win = button.up('window'),
            form = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        // synchronize the store after editing the record
        this.getUsersStore().sync();
    }
});