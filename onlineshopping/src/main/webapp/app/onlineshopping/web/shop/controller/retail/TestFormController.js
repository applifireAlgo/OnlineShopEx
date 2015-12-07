Ext.define('Onlineshopping.onlineshopping.web.shop.controller.retail.TestFormController', {
     extend: 'Onlineshopping.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.TestFormController',
     oncountryIdchange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {
               findKey: newValue
          };
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/State/findByCountryId',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    var lehpbbi = scope.sender.down('#lehpbbi');
                    scope.sender.controller.setstateIdData(responseData, lehpbbi);
               },
               failure: function(response, scope) {}
          }, scope);
     },
     setstateIdData: function(responseData, element) {
          responseData = responseData.response.data;
          var store = Ext.create('Ext.data.Store', {
               fields: ['stateId', 'stateName'],
               data: responseData
          });
          element.setStore(store);
          element.valueField = 'stateId';
          element.displayField = 'stateName';
          element.getStore().sort('stateName', 'ASC');
     },
     onresetclick: function(me, e, eOpts) {
          var form = me.up('form');
          form.reset();
     }
});