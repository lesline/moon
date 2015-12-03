Ext.define('AM.controller.sys.CustomerController', {
    extend: 'Ext.app.Controller',
    stores: ['sys.CustomerStore'],
    models: ['sys.Customer'],
    views: ['sys.CustomerList'],
    getMainView: function () {
        return this.getView('sys.CustomerList');
    },

    refs: [{
        ref: 'customer',
        selector: 'customerlist'
    }],
    init: function () {
        this.control({
            // 查询
            'customerlist button[action=query]': {
                click: this.query
            }
            //'userlist button[action=exportExcel]': {
            //    click: function () {
            //        AM.CommonFunc.exportExcel('costView', 'rest/settleCost/exportExcel');
            //    }
            //}

        });
    },
    query: function (btn) {
        this.getCustomer().getStore().loadPage(1);

    }
});