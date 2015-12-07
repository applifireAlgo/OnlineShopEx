Ext.define('Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "product",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "brand",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "category",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "item",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemStock",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "itemPrice",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "itemIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});