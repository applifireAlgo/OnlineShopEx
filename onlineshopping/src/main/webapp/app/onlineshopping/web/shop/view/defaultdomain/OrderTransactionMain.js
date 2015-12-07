Ext.define('Onlineshopping.onlineshopping.web.shop.view.defaultdomain.OrderTransactionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "OrderTransactionMainController",
     "restURL": "/OrderTransaction",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.defaultdomain.OrderTransactionModel", "Onlineshopping.onlineshopping.web.shop.controller.defaultdomain.OrderTransactionMainController", "Onlineshopping.onlineshopping.shared.shop.model.retail.OrderMainModel", "Onlineshopping.onlineshopping.shared.shop.viewmodel.defaultdomain.OrderTransactionViewModel"],
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
               "displayName": "OrderTransaction",
               "name": "OrderTransactionTreeContainer",
               "itemId": "OrderTransactionTreeContainer",
               "restURL": "/OrderTransaction",
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
                    "itemId": "OrderTransactionTree",
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
                    "items": []
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
                    "viewModel": "OrderTransactionViewModel",
                    "xtype": "form",
                    "displayName": "OrderTransaction",
                    "title": "OrderTransaction",
                    "name": "OrderTransaction",
                    "itemId": "OrderTransaction",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "orderId",
                         "itemId": "orderId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "OrderId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "OrderId<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A189EC1A-26A1-49A3-86FA-F7952B44CBB1",
                         "restURL": "OrderMain",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.OrderMainModel"
                         },
                         "bindable": "orderId",
                         "bind": "{orderId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "transactionId",
                         "itemId": "transactionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "transactionId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "transactionId<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F1CB38FA-27C7-4B3C-8E63-2B903A729DFE",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "transactionId",
                         "bind": "{transactionId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "transactionStatus",
                         "itemId": "transactionStatus",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "transactionStatus",
                         "margin": "5 5 5 5",
                         "fieldLabel": "transactionStatus<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "32762A26-C5BD-4572-AE6C-60C98A86F883",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "transactionStatus",
                         "bind": "{transactionStatus}",
                         "columnWidth": 0.5
                    }, {
                         "name": "statusMsg",
                         "itemId": "statusMsg",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "statusMsg",
                         "margin": "5 5 5 5",
                         "fieldLabel": "statusMsg<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B2F2210A-64B4-497E-BEFB-DC9916AA2597",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "statusMsg",
                         "bind": "{statusMsg}",
                         "columnWidth": 0.5
                    }, {
                         "name": "mapId",
                         "itemId": "mapId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "mapId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "mapId<font color='red'> *<\/font>",
                         "fieldId": "F3425C16-0E04-4218-8D57-CB5D2AF82118",
                         "hidden": true,
                         "value": "",
                         "bindable": "mapId",
                         "bind": "{mapId}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "97B2CA54-3379-40C0-9E6A-AA9453F0D40E",
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
                         "customId": 342,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 342,
                              "customId": 931
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 342,
                              "customId": 932,
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
                              "parentId": 342,
                              "customId": 933,
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
                    "displayName": "OrderTransaction",
                    "title": "Details Grid",
                    "name": "OrderTransactionGrid",
                    "itemId": "OrderTransactionGrid",
                    "restURL": "/OrderTransaction",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "OrderId",
                         "dataIndex": "orderId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "transactionId",
                         "dataIndex": "transactionId",
                         "flex": 1
                    }, {
                         "header": "transactionStatus",
                         "dataIndex": "transactionStatus",
                         "flex": 1
                    }, {
                         "header": "statusMsg",
                         "dataIndex": "statusMsg",
                         "flex": 1
                    }, {
                         "header": "mapId",
                         "dataIndex": "mapId",
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
               "viewModel": "OrderTransactionViewModel",
               "xtype": "form",
               "displayName": "OrderTransaction",
               "title": "OrderTransaction",
               "name": "OrderTransaction",
               "itemId": "OrderTransaction",
               "bodyPadding": 10,
               "items": [{
                    "name": "orderId",
                    "itemId": "orderId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "OrderId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "OrderId<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A189EC1A-26A1-49A3-86FA-F7952B44CBB1",
                    "restURL": "OrderMain",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.retail.OrderMainModel"
                    },
                    "bindable": "orderId",
                    "bind": "{orderId}",
                    "columnWidth": 0.5
               }, {
                    "name": "transactionId",
                    "itemId": "transactionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "transactionId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "transactionId<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F1CB38FA-27C7-4B3C-8E63-2B903A729DFE",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "transactionId",
                    "bind": "{transactionId}",
                    "columnWidth": 0.5
               }, {
                    "name": "transactionStatus",
                    "itemId": "transactionStatus",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "transactionStatus",
                    "margin": "5 5 5 5",
                    "fieldLabel": "transactionStatus<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "32762A26-C5BD-4572-AE6C-60C98A86F883",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "transactionStatus",
                    "bind": "{transactionStatus}",
                    "columnWidth": 0.5
               }, {
                    "name": "statusMsg",
                    "itemId": "statusMsg",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "statusMsg",
                    "margin": "5 5 5 5",
                    "fieldLabel": "statusMsg<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B2F2210A-64B4-497E-BEFB-DC9916AA2597",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "statusMsg",
                    "bind": "{statusMsg}",
                    "columnWidth": 0.5
               }, {
                    "name": "mapId",
                    "itemId": "mapId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "mapId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "mapId<font color='red'> *<\/font>",
                    "fieldId": "F3425C16-0E04-4218-8D57-CB5D2AF82118",
                    "hidden": true,
                    "value": "",
                    "bindable": "mapId",
                    "bind": "{mapId}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "97B2CA54-3379-40C0-9E6A-AA9453F0D40E",
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
                    "customId": 342,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 342,
                         "customId": 931
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 342,
                         "customId": 932,
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
                         "parentId": 342,
                         "customId": 933,
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