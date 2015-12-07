Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.OrderPreViewController', {
     extend: 'Onlineshopping.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.OrderPreViewController',
     onorderProcessclick: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/OrderProcessingBzServiceWS/orderProcessing',
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
     },
     onpaymentclick: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: '',
               method: '',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (!responseData.response.success) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
                    var component = Ext.create('Onlineshopping.onlineshopping.web.shop.view.retail.PaymentProcessing');
                    component.closable = true;
                    scope.sender.controller.addTab(component);
                    component.controller.setData(responseData.response.data);
               },
               failure: function(response, scope) {
                    responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               }
          }, scope);
     }
});