Ext.define('Onlineshopping.view.databrowsercalendar.DBCalendar', {
	extend : 'Onlineshopping.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Onlineshopping.view.databrowsercalendar.DBCalendarController',
	             'Onlineshopping.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
