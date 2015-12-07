Ext.define('Onlineshopping.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Onlineshopping.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Onlineshopping.view.mobileview.reportui.datachart.DataChartViewTab',
			'Onlineshopping.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Onlineshopping.view.mobileview.reportui.ReportViewController' ,
			'Onlineshopping.view.mobileview.fw.DataPointPanel',
			'Onlineshopping.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
