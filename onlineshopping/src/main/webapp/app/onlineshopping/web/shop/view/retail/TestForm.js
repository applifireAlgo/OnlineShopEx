Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.TestForm', {
     "xtype": "testForm",
     "items": [{
          "xtype": "fieldset",
          "items": [{
               "xtype": "textfield",
               "fieldLabel": "First Name",
               "margin": 5,
               "bindable": "firstName",
               "name": "firstName",
               "itemId": "molhnki",
               "bind": "{firstName}"
          }, {
               "xtype": "textfield",
               "fieldLabel": "Last Name",
               "margin": 5,
               "bindable": "lastName",
               "name": "lastName",
               "itemId": "afflhdi",
               "bind": "{lastName}"
          }, {
               "xtype": "combo",
               "name": "countryId",
               "margin": 5,
               "bindable": "countryId",
               "typeAhead": true,
               "queryMode": "local",
               "minChars": 1,
               "fieldLabel": "Country",
               "displayField": "countryName",
               "valueField": "countryId",
               "itemId": "jeoaghi",
               "store": {
                    "model": "Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel",
                    "autoLoad": true,
                    "autoSync": true,
                    "sorters": [{
                         "property": "countryName",
                         "direction": "ASC"
                    }],
                    "proxy": {
                         "type": "ajax",
                         "url": "secure/Country/findAll",
                         "actionMethods": {
                              "read": "GET"
                         },
                         "headers": {
                              "Content-Type": "application/json"
                         },
                         "extraParams": {},
                         "reader": {
                              "type": "json",
                              "rootProperty": "response.data"
                         }
                    }
               },
               "listeners": {
                    "change": "oncountryIdchange"
               },
               "bind": "{countryId}"
          }, {
               "xtype": "combo",
               "name": "stateId",
               "margin": 5,
               "bindable": "stateId",
               "typeAhead": true,
               "queryMode": "local",
               "minChars": 1,
               "fieldLabel": "State",
               "displayField": "stateName",
               "valueField": "stateId",
               "itemId": "lehpbbi",
               "isRelatedWith": "ddlffci",
               "bind": "{stateId}"
          }, {
               "xtype": "datefields",
               "fieldLabel": "Date of birth",
               "name": "dob",
               "bindable": "dob",
               "margin": 5,
               "itemId": "flddkki",
               "bind": "{dob}"
          }],
          "margin": 5,
          "autoScroll": true,
          "toggleOnTitleClick": true,
          "itemId": "mnbkfli",
          "dockedItems": [],
          "title": "User Details"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "pfokpii",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "tbfill",
               "itemId": "bapikai"
          }, {
               "xtype": "button",
               "text": "Reset",
               "isResetButton": true,
               "margin": 5,
               "name": "reset",
               "itemId": "ickflli",
               "listeners": {
                    "click": "onresetclick"
               }
          }],
          "itemId": "hccaici",
          "dockedItems": []
     }],
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.TestFormController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.TestFormViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.TestFormModel", "Onlineshopping.view.fw.component.DateFields"],
     "extend": "Ext.form.Panel",
     "viewModel": "TestFormViewModel",
     "controller": "TestFormController"
});