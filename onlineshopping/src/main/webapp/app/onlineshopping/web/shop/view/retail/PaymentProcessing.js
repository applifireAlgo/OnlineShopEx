Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.PaymentProcessing', {
     "xtype": "paymentProcessing",
     "name": "payment",
     "items": [{
          "xtype": "numberfield",
          "fieldLabel": "Amount",
          "name": "amount",
          "margin": 5,
          "bindable": "amount",
          "title": "Amount",
          "itemId": "nckkedi",
          "isRelatedWith": "nekiegi",
          "bind": "{amount}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Account Holder Name",
          "margin": 5,
          "bindable": "ccHolderName",
          "name": "ccHolderName",
          "title": "Account Holder Name",
          "itemId": "higknei",
          "bind": "{ccHolderName}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Credit Card No",
          "margin": 5,
          "bindable": "creditCardNo",
          "name": "creditCardNo",
          "title": "Credit Card No",
          "itemId": "eoalnoi",
          "bind": "{creditCardNo}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Customer",
          "margin": 5,
          "bindable": "customerId",
          "name": "customerId",
          "title": "Customer",
          "itemId": "opcchoi",
          "bind": "{customerId}"
     }, {
          "xtype": "textfield",
          "fieldLabel": "CVV ",
          "margin": 5,
          "bindable": "cvvNo",
          "name": "cvvNo",
          "title": "CVV ",
          "itemId": "mpmfldi",
          "bind": "{cvvNo}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Exp Month",
          "name": "expiryMonth",
          "margin": 5,
          "bindable": "expiryMonth",
          "title": "Exp Month",
          "itemId": "dgppeji",
          "bind": "{expiryMonth}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Exp Year",
          "name": "expiryYear",
          "margin": 5,
          "bindable": "expiryYear",
          "title": "Exp Year",
          "itemId": "cdajoli",
          "bind": "{expiryYear}"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Payment Processing",
     "margin": 5,
     "itemId": "daeegfi",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "button",
               "name": "Payment",
               "text": "Submit",
               "margin": 5,
               "isSubmitBtn": true,
               "itemId": "ceffgki",
               "listeners": {
                    "click": "onPaymentclick"
               }
          }],
          "itemId": "mhbfnii",
          "dockedItems": []
     }],
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onpaymentafterrender",
          "scope": "controller"
     },
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.PaymentProcessingController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.PaymentProcessingViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.PaymentProcessingModel"],
     "viewModel": "PaymentProcessingViewModel",
     "controller": "PaymentProcessingController"
});