Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.CartPartial', {
     "xtype": "cartPartial",
     "name": "Panel",
     "items": [{
          "xtype": "hiddenfield",
          "fieldLabel": "itemId",
          "bindable": "itemId",
          "margin": 5,
          "name": "itemId",
          "title": "itemId",
          "itemId": "foogmdi",
          "bind": "{itemId}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Product",
          "margin": 5,
          "bindable": "product",
          "name": "product",
          "title": "Product",
          "itemId": "deocemi",
          "bind": "{product}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Brand",
          "margin": 5,
          "bindable": "brand",
          "name": "brand",
          "title": "Brand",
          "itemId": "aahgdpi",
          "bind": "{brand}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Category",
          "margin": 5,
          "bindable": "category",
          "name": "category",
          "title": "Category",
          "itemId": "npeaiji",
          "bind": "{category}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Item",
          "margin": 5,
          "bindable": "item",
          "name": "item",
          "title": "Item",
          "itemId": "fapioni",
          "bind": "{item}"
     }, {
          "xtype": "image",
          "name": "itemIcon",
          "height": 100,
          "width": 100,
          "border": true,
          "margin": 5,
          "bindable": "{src:'itemIcon'}",
          "itemId": "akmfboi",
          "bind": {
               "src": "{itemIcon}"
          }
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Quantity",
          "name": "quantity",
          "margin": 5,
          "bindable": "quantity",
          "title": "Quantity",
          "itemId": "phmhbji",
          "bind": "{quantity}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Price",
          "name": "itemPrice",
          "margin": 5,
          "bindable": "itemPrice",
          "title": "Price",
          "itemId": "bmnanbi",
          "bind": "{itemPrice}"
     }, {
          "xtype": "button",
          "name": "save",
          "text": "Add To Cart",
          "margin": 5,
          "itemId": "abefmdi",
          "listeners": {
               "click": "onsaveclick"
          }
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Item",
     "isPartialUI": true,
     "itemId": "fadikni",
     "dockedItems": [],
     "extend": "Ext.panel.Panel",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.CartPartialController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.CartPartialViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.CartPartialModel"],
     "viewModel": "CartPartialViewModel",
     "controller": "CartPartialController"
});