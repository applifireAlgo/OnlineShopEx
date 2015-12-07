Ext.define('Onlineshopping.onlineshopping.shared.shop.model.retail.CartItemModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "itemIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "item",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "unitPrice",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "quantity",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "subTotal",
          "type": "int",
          "defaultValue": ""
     }]
});