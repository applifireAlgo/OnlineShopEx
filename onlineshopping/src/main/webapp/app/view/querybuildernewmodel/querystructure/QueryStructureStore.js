Ext.define('Onlineshopping.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopping.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Onlineshopping.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
