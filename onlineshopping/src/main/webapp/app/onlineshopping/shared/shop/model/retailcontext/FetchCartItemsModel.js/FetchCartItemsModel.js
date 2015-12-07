Ext.define('Onlineshopping.onlineshopping.shared.shop.model.retailcontext.FetchCartItemsModel.FetchCartItemsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "quantity",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "itemUnitPrice",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "itemSubTotal",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "item",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemIcon",
          "type": "string",
          "defaultValue": ""
     }]
});