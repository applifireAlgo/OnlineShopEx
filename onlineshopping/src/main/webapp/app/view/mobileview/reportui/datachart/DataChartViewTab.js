Ext.define('Onlineshopping.view.mobileview.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Onlineshopping.view.mobileview.reportui.datachart.DataChartTController',
			'Onlineshopping.view.mobileview.reportui.datachart.datagrid.DataGridView','Onlineshopping.view.mobileview.reportui.datachart.chart.ChartTabView','Onlineshopping.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});