Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.CartPartialController', {
     extend: 'Onlineshopping.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.CartPartialController',
     onsaveclick: function(me, e, eOpts) {
          var jsonData = {};
          jsonData.itemId = this.view.down('#foogmdi').getValue();
          jsonData.quantity = this.view.down('#phmhbji').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Cart/',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               },
               failure: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               }
          }, scope);
     }
});