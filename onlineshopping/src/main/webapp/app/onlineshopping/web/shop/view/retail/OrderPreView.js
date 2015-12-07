Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.OrderPreView', {
     "xtype": "orderPreView",
     "name": "order",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "orderItem",
          "items": [],
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "433376FB-0805-414C-A243-4C85E70BD5E2",
               "uiClass": "Onlineshopping.onlineshopping.web.shop.view.retail.CartItem",
               "uiType": 2,
               "url": "secure/FetchCartItemServiceWS/fetchCartItem",
               "requestMethodType": "POST"
          },
          "padding": 0,
          "margin": 5,
          "itemId": "hbglpni",
          "dockedItems": []
     }],
     "border": true,
     "title": "Order ",
     "margin": 5,
     "itemId": "kpeconi",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "tbfill",
               "itemId": "hobhjli"
          }, {
               "xtype": "button",
               "name": "orderProcess",
               "text": "Confirm Order",
               "margin": 5,
               "itemId": "niibhgi",
               "listeners": {
                    "click": "onorderProcessclick"
               }
          }, {
               "xtype": "tbfill",
               "itemId": "hhbjiii"
          }, {
               "xtype": "button",
               "text": "Paymnet",
               "isLinkBtn": true,
               "margin": 5,
               "name": "payment",
               "itemId": "ngcnmhi",
               "listeners": {
                    "click": "onpaymentclick"
               }
          }],
          "itemId": "hhhhcai",
          "dockedItems": [],
          "title": "Process Order"
     }],
     "extend": "Ext.form.Panel",
     "layout": "fit",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.OrderPreViewController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.OrderPreViewViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.OrderPreViewModel", "Onlineshopping.view.fw.component.ListViewBaseView"],
     "viewModel": "OrderPreViewViewModel",
     "controller": "OrderPreViewController"
});