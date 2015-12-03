Ext.define('AM.store.Menus',{
    extend: 'Ext.data.TreeStore',
    requires: 'AM.model.Menu',
 	model: 'AM.model.Menu',
 	autoLoad: true,
 	proxy: {
        type: 'ajax',
        url: 'app/store/manager.json',
        reader: {
            type: 'json',
            successProperty: 'success'
        }
    } 
});
