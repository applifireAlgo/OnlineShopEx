Ext.define('Onlineshopping.view.chartbuilder.viewchart.ChartMainView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Onlineshopping.view.chartbuilder.viewchart.ChartMainController',
	             'Onlineshopping.view.chartbuilder.leftpanel.LeftPanelView',
			     'Onlineshopping.view.chartbuilder.chartpanel.ChartPanelView',
			     'Onlineshopping.view.chartbuilder.rightpanel.RightPanelView',
			     'Ext.tab.Panel',
			     'Onlineshopping.view.chartbuilder.chartjsonsource.ChartJsonSourceView'
			    ],
	xtype : 'apps-chartview',
	controller : 'chartmaincontroller',
	layout : {
		type : 'border'
	},
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	},
	items: [
	    	{	    			            	
	    		xtype: 'left-panel',
	    		reference:'ref-left-panel'
	    	},
	    	{
		        region:'center',
		        tabPosition:'bottom',
		        itemId :'topTabId',
		        xtype:'tabpanel',
		        /*tbar: [
		        	    //'->',
		        	    {
		        	       xtype:'textfield',
		        	       fieldLabel:'Report Name ',
		        	       itemId:'report-name',
		        	       emptyText:'Enter Report Name',
		        	       allowBlank:false
		        	    }        	          
	    		],  */			   
	    		items:[
	    			    {
	    			        title:'Chart',
	    			        xtype:'chart-panel',
	    			        tabId:1,
	    			        style:'background:#f6f6f6;',
	    			     },
	    			    {
	    			        title:'Source',
	    			        xtype:'source-view',
	    			        tabId:2,
	    			        style:'background:#f6f6f6;',
	    			    }
	    	    ],
	    		listeners:{
	    			       		tabchange :'onTabChange'
	    		}
	    	},    			            
	    	{
	    		xtype:'right-panel',
	    		reference:'ref-right-panel'
	    	}   
	],//panel item ends
	buttons:[
				{
				    text:'Save Chart',
				    icon:'images/greenFlopy_save.png',
				    handler:'onSaveChartClick'
				 },
	   		     {
	    			text:'Save As Template',
	    			icon:'images/greenFlopy_save.png',
	    			handler:'onSaveTemplateClick'
	    		 }
	]
});
