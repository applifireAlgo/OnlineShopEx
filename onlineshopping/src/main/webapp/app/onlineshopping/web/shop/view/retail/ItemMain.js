Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.retail.ItemModel", "Onlineshopping.onlineshopping.web.shop.controller.retail.ItemMainController", "Onlineshopping.view.fw.component.FileUploadComponent", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.ItemViewModel"],
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
               "displayName": "Item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
               "restURL": "/Item",
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
                    "itemId": "ItemTree",
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
                    "viewModel": "ItemViewModel",
                    "xtype": "form",
                    "displayName": "Item",
                    "title": "Item",
                    "name": "Item",
                    "itemId": "Item",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "itemId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemId<font color='red'> *<\/font>",
                         "fieldId": "B9552B92-CC1E-41C9-A3BC-464E9B0AE850",
                         "hidden": true,
                         "value": "",
                         "bindable": "itemId",
                         "bind": "{itemId}"
                    }, {
                         "name": "product",
                         "itemId": "product",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B1E14A1D-323D-4753-8A6F-650ABDD101F4",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "product",
                         "bind": "{product}",
                         "columnWidth": 0.5
                    }, {
                         "name": "brand",
                         "itemId": "brand",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "366F1D34-8B1F-4E67-B906-E5A601D02FD0",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "brand",
                         "bind": "{brand}",
                         "columnWidth": 0.5
                    }, {
                         "name": "category",
                         "itemId": "category",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "150FD158-B3CA-4AB4-BC36-226E989EFD32",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "category",
                         "bind": "{category}",
                         "columnWidth": 0.5
                    }, {
                         "name": "item",
                         "itemId": "item",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3668F965-088E-4936-A7F6-8A27357D6B17",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "item",
                         "bind": "{item}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C62FBEC6-E507-443D-8BF5-EA8963284E8F",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "itemStock",
                         "bind": "{itemStock}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "DF4359E2-A043-4BA0-AE33-13DEFAE0BC67",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "itemPrice",
                         "bind": "{itemPrice}",
                         "columnWidth": 0.5
                    }, {
                         "items": [{
                              "name": "filePathHidden",
                              "xtype": "hidden",
                              "itemId": "filePathHidden",
                              "bind": "{itemIcon}"
                         }, {
                              "name": "itemIcon",
                              "itemId": "itemIcon",
                              "xtype": "fileupload",
                              "customWidgetType": "vdFileUpload",
                              "displayName": "Icon",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Icon<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "763F919A-E410-4EFC-83C4-28167D321F6A",
                              "bindable": "itemIcon",
                              "columnWidth": 0.5
                         }]
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "EFD178AD-B752-4621-89EA-439C3ED4F258",
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
                         "customId": 534,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 534,
                              "customId": 987
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 534,
                              "customId": 988,
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
                              "parentId": 534,
                              "customId": 989,
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
                    "displayName": "Item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "restURL": "/Item",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "itemId",
                         "dataIndex": "itemId",
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
                         "header": "Product",
                         "dataIndex": "product",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brand",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "category",
                         "flex": 1
                    }, {
                         "header": "Item",
                         "dataIndex": "item",
                         "flex": 1
                    }, {
                         "header": "Stock",
                         "dataIndex": "itemStock",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "itemIcon",
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
               "viewModel": "ItemViewModel",
               "xtype": "form",
               "displayName": "Item",
               "title": "Item",
               "name": "Item",
               "itemId": "Item",
               "bodyPadding": 10,
               "items": [{
                    "name": "itemId",
                    "itemId": "itemId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "itemId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemId<font color='red'> *<\/font>",
                    "fieldId": "B9552B92-CC1E-41C9-A3BC-464E9B0AE850",
                    "hidden": true,
                    "value": "",
                    "bindable": "itemId",
                    "bind": "{itemId}"
               }, {
                    "name": "product",
                    "itemId": "product",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B1E14A1D-323D-4753-8A6F-650ABDD101F4",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "product",
                    "bind": "{product}",
                    "columnWidth": 0.5
               }, {
                    "name": "brand",
                    "itemId": "brand",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Brand",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Brand<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "366F1D34-8B1F-4E67-B906-E5A601D02FD0",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "brand",
                    "bind": "{brand}",
                    "columnWidth": 0.5
               }, {
                    "name": "category",
                    "itemId": "category",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "150FD158-B3CA-4AB4-BC36-226E989EFD32",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "category",
                    "bind": "{category}",
                    "columnWidth": 0.5
               }, {
                    "name": "item",
                    "itemId": "item",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3668F965-088E-4936-A7F6-8A27357D6B17",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "item",
                    "bind": "{item}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemStock",
                    "itemId": "itemStock",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Stock",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Stock<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C62FBEC6-E507-443D-8BF5-EA8963284E8F",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "itemStock",
                    "bind": "{itemStock}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemPrice",
                    "itemId": "itemPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Price<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "DF4359E2-A043-4BA0-AE33-13DEFAE0BC67",
                    "minValue": "-9223372000000000000",
                    "maxValue": "9223372000000000000",
                    "bindable": "itemPrice",
                    "bind": "{itemPrice}",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden",
                         "bind": "{itemIcon}"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "763F919A-E410-4EFC-83C4-28167D321F6A",
                         "bindable": "itemIcon",
                         "columnWidth": 0.5
                    }]
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "EFD178AD-B752-4621-89EA-439C3ED4F258",
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
                    "customId": 534,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 534,
                         "customId": 987
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 534,
                         "customId": 988,
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
                         "parentId": 534,
                         "customId": 989,
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