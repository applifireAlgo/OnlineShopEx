Ext.define('Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Onlineshopping.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
