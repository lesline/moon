/*
 * application启动时立刻加载的常量文件，定义系统中使用重复度较高的组件，或函数
 * author：Niu Xiaoyu
 * date: 2015/917
 * */
Ext.namespace('AM.util.CommonFunc', 'AM.CommonFunc');

/**
 * 显示错误信息
 * @param {Object} msg   错误内容
 * @param {Object} title  窗口标题
 */
AM.CommonFunc.alertError = function(msg,title) {
    Ext.Msg.show({
        title : title || '错误提示',
        msg : msg || '与服务器通讯失败！',
        //width : 400,
        icon : Ext.MessageBox.ERROR,
        buttons : Ext.MessageBox.OK
    });
};

/**
 * 导出excel文件
 * @param view
 * @param url
 */
AM.CommonFunc.exportExcel=function (view, url) {

    var comp = Ext.ComponentQuery.query(view)[0];

    var totalCount = comp.store.totalCount;
    if (totalCount > 10000) {
        Ext.MessageBox.alert("excel导数", "导出行数超过一万笔,请分批导出!");
        return;
    }

    var columnsArray = comp.columns;
    var columnsObject = [];
    Ext.Array.forEach(columnsArray, function (str, index, array) { //单纯的遍历数组
        if (str.dataIndex) {
            if(str.excelDisplay===true){
                columnsObject.push({text: str.text, dataIndex: str.dataIndex, format: str.format});
            }else {
                if (str.hidden !== true) {
                    columnsObject.push({text: str.text, dataIndex: str.dataIndex, format: str.format});
                }
            }
        }
    });
    //列信息
    var columsStrs = Ext.JSON.encode(columnsObject);

    //查询条件
    var queryParams = comp.store.proxy.extraParams;
    var queryStrs = Ext.JSON.encode(queryParams);

    var url = url;
    url = url + "?columsStrs=" + encodeURI(encodeURI(columsStrs)) + "&queryStrs=" + encodeURI(encodeURI(queryStrs));
    // window.location.href=url;
    window.open(url);
};