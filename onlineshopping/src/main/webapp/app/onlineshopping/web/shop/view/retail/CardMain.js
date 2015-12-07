Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.CardMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CardMainController",
     "restURL": "/Card",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.CardModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.CardMainController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.CardViewModel"],
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
               "displayName": "Card ",
               "name": "CardTreeContainer",
               "itemId": "CardTreeContainer",
               "restURL": "/Card",
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
                    "itemId": "CardTree",
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
                    "viewModel": "CardViewModel",
                    "xtype": "form",
                    "displayName": "Card ",
                    "title": "Card ",
                    "name": "Card",
                    "itemId": "Card",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cardId",
                         "itemId": "cardId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Card Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Card Id<font color='red'> *<\/font>",
                         "fieldId": "13DACA53-CB54-4B1B-AA61-4D24E55DE977",
                         "hidden": true,
                         "value": "",
                         "bindable": "cardId",
                         "bind": "{cardId}"
                    }, {
                         "name": "cardNo",
                         "itemId": "cardNo",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Card No",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Card No<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "71BD7C67-E351-45F0-845D-E9617690B6CA",
                         "minLength": "0",
                         "maxLength": "16",
                         "bindable": "cardNo",
                         "bind": "{cardNo}",
                         "columnWidth": 0.5
                    }, {
                         "name": "expDate",
                         "itemId": "expDate",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Exp Date",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Exp Date<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B881B4B8-C5F4-4D3D-957A-1C1BA037BBD6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "expDate",
                         "bind": "{expDate}",
                         "columnWidth": 0.5
                    }, {
                         "name": "nameOnCard",
                         "itemId": "nameOnCard",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name On Card",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name On Card<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "90316C40-107F-44CE-A532-BAD6D4B70607",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "nameOnCard",
                         "bind": "{nameOnCard}",
                         "columnWidth": 0.5
                    }, {
                         "name": "amt",
                         "itemId": "amt",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Amount",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Amount<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4ED81F60-4621-4D36-B9E3-3004E2FE5775",
                         "minValue": "0",
                         "maxValue": "9999999",
                         "bindable": "amt",
                         "bind": "{amt}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cvv",
                         "itemId": "cvv",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "CVV",
                         "margin": "5 5 5 5",
                         "fieldLabel": "CVV<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "53BCA35E-41B8-454D-893E-84FC4FD1CB25",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "cvv",
                         "bind": "{cvv}",
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
                         "fieldId": "065ED0C5-A4A3-4D2A-8F36-0C8702C374A1",
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
                         "customId": 563,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 563,
                              "customId": 790
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 563,
                              "customId": 791,
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
                              "parentId": 563,
                              "customId": 792,
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
                    "displayName": "Card ",
                    "title": "Details Grid",
                    "name": "CardGrid",
                    "itemId": "CardGrid",
                    "restURL": "/Card",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Card Id",
                         "dataIndex": "cardId",
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
                         "header": "Card No",
                         "dataIndex": "cardNo",
                         "flex": 1
                    }, {
                         "header": "Exp Date",
                         "dataIndex": "expDate",
                         "flex": 1
                    }, {
                         "header": "Name On Card",
                         "dataIndex": "nameOnCard",
                         "flex": 1
                    }, {
                         "header": "Amount",
                         "dataIndex": "amt",
                         "flex": 1
                    }, {
                         "header": "CVV",
                         "dataIndex": "cvv",
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
               "viewModel": "CardViewModel",
               "xtype": "form",
               "displayName": "Card ",
               "title": "Card ",
               "name": "Card",
               "itemId": "Card",
               "bodyPadding": 10,
               "items": [{
                    "name": "cardId",
                    "itemId": "cardId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Card Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Card Id<font color='red'> *<\/font>",
                    "fieldId": "13DACA53-CB54-4B1B-AA61-4D24E55DE977",
                    "hidden": true,
                    "value": "",
                    "bindable": "cardId",
                    "bind": "{cardId}"
               }, {
                    "name": "cardNo",
                    "itemId": "cardNo",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Card No",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Card No<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "71BD7C67-E351-45F0-845D-E9617690B6CA",
                    "minLength": "0",
                    "maxLength": "16",
                    "bindable": "cardNo",
                    "bind": "{cardNo}",
                    "columnWidth": 0.5
               }, {
                    "name": "expDate",
                    "itemId": "expDate",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Exp Date",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Exp Date<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B881B4B8-C5F4-4D3D-957A-1C1BA037BBD6",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "expDate",
                    "bind": "{expDate}",
                    "columnWidth": 0.5
               }, {
                    "name": "nameOnCard",
                    "itemId": "nameOnCard",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name On Card",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name On Card<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "90316C40-107F-44CE-A532-BAD6D4B70607",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "nameOnCard",
                    "bind": "{nameOnCard}",
                    "columnWidth": 0.5
               }, {
                    "name": "amt",
                    "itemId": "amt",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Amount",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Amount<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4ED81F60-4621-4D36-B9E3-3004E2FE5775",
                    "minValue": "0",
                    "maxValue": "9999999",
                    "bindable": "amt",
                    "bind": "{amt}",
                    "columnWidth": 0.5
               }, {
                    "name": "cvv",
                    "itemId": "cvv",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "CVV",
                    "margin": "5 5 5 5",
                    "fieldLabel": "CVV<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "53BCA35E-41B8-454D-893E-84FC4FD1CB25",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "cvv",
                    "bind": "{cvv}",
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
                    "fieldId": "065ED0C5-A4A3-4D2A-8F36-0C8702C374A1",
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
                    "customId": 563,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 563,
                         "customId": 790
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 563,
                         "customId": 791,
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
                         "parentId": 563,
                         "customId": 792,
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