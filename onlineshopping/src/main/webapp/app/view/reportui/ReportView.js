Ext.define('Onlineshopping.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Onlineshopping.view.reportui.querycriteria.QueryCriteriaView',
			'Onlineshopping.view.reportui.datachart.DataChartViewTab',
			'Onlineshopping.view.reportui.datachart.DataChartViewPanel',
			'Onlineshopping.view.reportui.ReportViewController' ,
			'Onlineshopping.view.fw.MainDataPointPanel',
			'Onlineshopping.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
