Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.PaymentProcessingController', {
     extend: 'Onlineshopping.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.PaymentProcessingController',
}, onpaymentafterrender: function(me, eOpts) {
     var jsonData = {
          findKey: value
     };
     var scope = this.getView();
     Ext.Ajax.request({
          url: 'secure/FetchOrderTotalBzServiceWS/fetchOrderTotal',
          method: 'POST',
          sender: scope,
          jsonData: jsonData,
          me: me,
          success: function(response, scope) {
               var nckkedi = scope.sender.down('#nckkedi');
               var responseData = Ext.JSON.decode(response.responseText);
               scope.sender.controller.setamountData(responseData, nckkedi);
          },
          failure: function(response, scope) {}
     }, scope);
},
};, onPaymentclick: function(me, e, eOpts) {
     var jsonData = this.getData(this.view);
     var scope = this.getView();
     Ext.Ajax.request({
          url: 'secure/PaymentTranExBzServiceWS/paymentTranProcessing',
          method: 'POST',
          sender: scope,
          jsonData: jsonData,
          me: me,
          success: function(response, scope) {
               responseData = Ext.JSON.decode(response.responseText);
               Ext.Msg.alert('Server Response', responseData.response.message);
               scope.sender.reset();
          },
          failure: function(response, scope) {
               responseData = Ext.JSON.decode(response.responseText);
               Ext.Msg.alert('Server Response', responseData.response.message);
          }
     }, scope);
}
});