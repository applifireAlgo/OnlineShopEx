Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.CartMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CartMainController",
     "restURL": "/Cart",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.CartModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.CartMainController", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel", "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.CartViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Cart",
               "name": "CartTreeContainer",
               "itemId": "CartTreeContainer",
               "restURL": "/Cart",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CartTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "userId",
                         "itemId": "userId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "User Id",
                         "fieldId": "FA2181C7-21E5-428A-A1AA-734E104FB047",
                         "restURL": "User",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                         }
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "CartViewModel",
                    "xtype": "form",
                    "displayName": "Cart",
                    "title": "Cart",
                    "name": "Cart",
                    "itemId": "Cart",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cartId",
                         "itemId": "cartId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "cartId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "cartId<font color='red'> *<\/font>",
                         "fieldId": "16ABFB96-671D-455D-A6AA-36FB94ECA07B",
                         "hidden": true,
                         "value": "",
                         "bindable": "cartId",
                         "bind": "{cartId}"
                    }, {
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3F4D2027-1FAD-4B5F-8F7D-0829C585CF12",
                         "restURL": "Item",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel"
                         },
                         "bindable": "itemId",
                         "bind": "{itemId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "quantity",
                         "itemId": "quantity",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Quantity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8BB3D32B-C0BE-459D-A43B-244FF1D1481C",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "quantity",
                         "bind": "{quantity}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemUnitPrice",
                         "itemId": "itemUnitPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Unit Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Unit Price",
                         "fieldId": "1EB2F120-02E4-4525-AE35-4C33818437EB",
                         "minValue": "0",
                         "maxValue": "99999999",
                         "bindable": "itemUnitPrice",
                         "bind": "{itemUnitPrice}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemSubTotal",
                         "itemId": "itemSubTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sub Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sub Total",
                         "fieldId": "E869113B-07E8-43E1-9C53-FCEC7B3C8D7B",
                         "minValue": "0",
                         "maxValue": "9999999",
                         "bindable": "itemSubTotal",
                         "bind": "{itemSubTotal}",
                         "columnWidth": 0.5
                    }, {
                         "name": "userId",
                         "itemId": "userId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "User Id",
                         "fieldId": "FA2181C7-21E5-428A-A1AA-734E104FB047",
                         "restURL": "User",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                         },
                         "bindable": "userId",
                         "bind": "{userId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "27E19C7E-C550-42CC-90EE-A22A8DCFDC7F",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 204,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 204,
                              "customId": 991
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 204,
                              "customId": 992,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 204,
                              "customId": 993,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Cart",
                    "title": "Details Grid",
                    "name": "CartGrid",
                    "itemId": "CartGrid",
                    "restURL": "/Cart",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "cartId",
                         "dataIndex": "cartId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Item",
                         "dataIndex": "itemId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Quantity",
                         "dataIndex": "quantity",
                         "flex": 1
                    }, {
                         "header": "Unit Price",
                         "dataIndex": "itemUnitPrice",
                         "flex": 1
                    }, {
                         "header": "Sub Total",
                         "dataIndex": "itemSubTotal",
                         "flex": 1
                    }, {
                         "header": "User Id",
                         "dataIndex": "userId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "CartViewModel",
               "xtype": "form",
               "displayName": "Cart",
               "title": "Cart",
               "name": "Cart",
               "itemId": "Cart",
               "bodyPadding": 10,
               "items": [{
                    "name": "cartId",
                    "itemId": "cartId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "cartId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "cartId<font color='red'> *<\/font>",
                    "fieldId": "16ABFB96-671D-455D-A6AA-36FB94ECA07B",
                    "hidden": true,
                    "value": "",
                    "bindable": "cartId",
                    "bind": "{cartId}"
               }, {
                    "name": "itemId",
                    "itemId": "itemId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3F4D2027-1FAD-4B5F-8F7D-0829C585CF12",
                    "restURL": "Item",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel"
                    },
                    "bindable": "itemId",
                    "bind": "{itemId}",
                    "columnWidth": 0.5
               }, {
                    "name": "quantity",
                    "itemId": "quantity",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Quantity",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Quantity<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8BB3D32B-C0BE-459D-A43B-244FF1D1481C",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "quantity",
                    "bind": "{quantity}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemUnitPrice",
                    "itemId": "itemUnitPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Unit Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Unit Price",
                    "fieldId": "1EB2F120-02E4-4525-AE35-4C33818437EB",
                    "minValue": "0",
                    "maxValue": "99999999",
                    "bindable": "itemUnitPrice",
                    "bind": "{itemUnitPrice}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemSubTotal",
                    "itemId": "itemSubTotal",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Sub Total",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Sub Total",
                    "fieldId": "E869113B-07E8-43E1-9C53-FCEC7B3C8D7B",
                    "minValue": "0",
                    "maxValue": "9999999",
                    "bindable": "itemSubTotal",
                    "bind": "{itemSubTotal}",
                    "columnWidth": 0.5
               }, {
                    "name": "userId",
                    "itemId": "userId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "User Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "User Id",
                    "fieldId": "FA2181C7-21E5-428A-A1AA-734E104FB047",
                    "restURL": "User",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.authentication.UserModel"
                    },
                    "bindable": "userId",
                    "bind": "{userId}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "27E19C7E-C550-42CC-90EE-A22A8DCFDC7F",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 204,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 204,
                         "customId": 991
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 204,
                         "customId": 992,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 204,
                         "customId": 993,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});