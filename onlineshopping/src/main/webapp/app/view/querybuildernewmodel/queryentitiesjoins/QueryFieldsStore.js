Ext.define('Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
