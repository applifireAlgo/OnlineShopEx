Ext.define('Onlineshopping.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Onlineshopping.view.art.masterform.MasterFormModel','Onlineshopping.view.art.masterform.MasterFormViewModel','Onlineshopping.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	