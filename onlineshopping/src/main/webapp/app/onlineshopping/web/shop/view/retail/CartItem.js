Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.CartItem', {
     "xtype": "cartItem",
     "items": [{
          "xtype": "image",
          "name": "itemIcon",
          "height": 100,
          "width": 100,
          "border": true,
          "margin": 5,
          "bindable": "{src:'{itemIcon}'}",
          "itemId": "ehghlni",
          "bind": {
               "src": "{itemIcon}"
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "Item",
          "margin": 5,
          "bindable": "item",
          "name": "item",
          "itemId": "cdhccci",
          "bind": "{item}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Price",
          "name": "itemUnitPrice",
          "margin": 5,
          "bindable": "unitPrice",
          "text": "Price",
          "fieldName": "unitPrice",
          "displayName": "Price",
          "widget": "numberfield",
          "min": "0",
          "max": "99999999",
          "isField": true,
          "itemId": "lcakggi",
          "bind": "{itemUnitPrice}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Quantity",
          "name": "quantity",
          "margin": 5,
          "bindable": "quantity",
          "text": "Quantity",
          "fieldName": "quantity",
          "displayName": "Quantity",
          "widget": "numberfield",
          "min": "0",
          "max": "99999999",
          "isField": true,
          "itemId": "kngbgoi",
          "bind": "{quantity}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Sub Total",
          "name": "itemSubTotal",
          "margin": 5,
          "bindable": "subTotal",
          "text": "Sub Total",
          "fieldName": "subTotal",
          "displayName": "Sub Total",
          "widget": "numberfield",
          "min": "0",
          "max": "99999999",
          "isField": true,
          "itemId": "mdliiji",
          "bind": "{itemSubTotal}"
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "itemId": "poidlfi",
     "dockedItems": [],
     "extend": "Ext.panel.Panel",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.CartItemController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.CartItemViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.CartItemModel"],
     "viewModel": "CartItemViewModel",
     "controller": "CartItemController"
});