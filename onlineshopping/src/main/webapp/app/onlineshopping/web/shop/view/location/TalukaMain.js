Ext.define('Onlineshopping.onlineshopping.web.shop.view.location.TalukaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TalukaMainController",
     "restURL": "/Taluka",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopping.onlineshopping.shared.shop.model.location.TalukaModel", "Onlineshopping.onlineshopping.web.shop.controller.location.TalukaMainController", "Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel", "Onlineshopping.onlineshopping.shared.shop.model.location.StateModel", "Onlineshopping.onlineshopping.shared.shop.model.location.RegionModel", "Onlineshopping.onlineshopping.shared.shop.model.location.DistrictModel", "Onlineshopping.onlineshopping.shared.shop.viewmodel.location.TalukaViewModel"],
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
               "displayName": "Taluka",
               "name": "TalukaTreeContainer",
               "itemId": "TalukaTreeContainer",
               "restURL": "/Taluka",
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
                    "itemId": "TalukaTree",
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
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "7F7197C7-EE83-45EA-9C33-1194EE605E96",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "804F2E62-B53F-41B2-B8F1-AA60D2420CC3",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.StateModel"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region",
                         "fieldId": "8713882B-2E11-426D-B6EE-A6416DDDA4EC",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.RegionModel"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District",
                         "fieldId": "A9607E2D-8AA9-4227-9985-FE6F7565D8B2",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.DistrictModel"
                         }
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name",
                         "fieldId": "92A794B3-3453-4073-85EE-F8640B2FEC6F",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code",
                         "fieldId": "55A5FD71-38ED-4E75-A0E2-6FCBC1CB2688",
                         "minLength": "0",
                         "maxLength": "32"
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
                    "viewModel": "TalukaViewModel",
                    "xtype": "form",
                    "displayName": "Taluka",
                    "title": "Taluka",
                    "name": "Taluka",
                    "itemId": "Taluka",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "talukaId",
                         "itemId": "talukaId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                         "fieldId": "DB6BFADD-E288-42AB-9980-7BC03723BE37",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "talukaId",
                         "bind": "{talukaId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7F7197C7-EE83-45EA-9C33-1194EE605E96",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "804F2E62-B53F-41B2-B8F1-AA60D2420CC3",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8713882B-2E11-426D-B6EE-A6416DDDA4EC",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.RegionModel"
                         },
                         "bindable": "regionId",
                         "bind": "{regionId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A9607E2D-8AA9-4227-9985-FE6F7565D8B2",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Onlineshopping.onlineshopping.shared.shop.model.location.DistrictModel"
                         },
                         "bindable": "districtId",
                         "bind": "{districtId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "92A794B3-3453-4073-85EE-F8640B2FEC6F",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "talukaName",
                         "bind": "{talukaName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "55A5FD71-38ED-4E75-A0E2-6FCBC1CB2688",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "talukaCode",
                         "bind": "{talukaCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaDescription",
                         "itemId": "talukaDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "taluka Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Description",
                         "fieldId": "1C810627-568C-45EB-A7D6-56D9F9249C89",
                         "bindable": "talukaDescription",
                         "bind": "{talukaDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaFlag",
                         "itemId": "talukaFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "6CE68613-042C-4B7F-AADD-51409D82002B",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "talukaFlag",
                         "bind": "{talukaFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLatitude",
                         "itemId": "talukaLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "talukaaLatitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaaLatitude",
                         "fieldId": "D796551C-0980-47F4-8642-20BAC6B1DC11",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLatitude",
                         "bind": "{talukaLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLongitude",
                         "itemId": "talukaLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Citry Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Citry Longitude",
                         "fieldId": "78532C90-3AE2-4421-903A-1CCC2F564EC7",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLongitude",
                         "bind": "{talukaLongitude}",
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
                         "fieldId": "0F0F9C27-2EED-45B0-B14E-CFEC28D8C6DB",
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
                         "customId": 232,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 232,
                              "customId": 633
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 232,
                              "customId": 634,
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
                              "parentId": 232,
                              "customId": 635,
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
                    "displayName": "Taluka",
                    "title": "Details Grid",
                    "name": "TalukaGrid",
                    "itemId": "TalukaGrid",
                    "restURL": "/Taluka",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "taluka Id",
                         "dataIndex": "talukaId",
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
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "taluka Name",
                         "dataIndex": "talukaName",
                         "flex": 1
                    }, {
                         "header": "taluka Code",
                         "dataIndex": "talukaCode",
                         "flex": 1
                    }, {
                         "header": "taluka Description",
                         "dataIndex": "talukaDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "talukaFlag",
                         "flex": 1
                    }, {
                         "header": "talukaaLatitude",
                         "dataIndex": "talukaLatitude",
                         "flex": 1
                    }, {
                         "header": "Citry Longitude",
                         "dataIndex": "talukaLongitude",
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
               "viewModel": "TalukaViewModel",
               "xtype": "form",
               "displayName": "Taluka",
               "title": "Taluka",
               "name": "Taluka",
               "itemId": "Taluka",
               "bodyPadding": 10,
               "items": [{
                    "name": "talukaId",
                    "itemId": "talukaId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                    "fieldId": "DB6BFADD-E288-42AB-9980-7BC03723BE37",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "talukaId",
                    "bind": "{talukaId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7F7197C7-EE83-45EA-9C33-1194EE605E96",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "804F2E62-B53F-41B2-B8F1-AA60D2420CC3",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8713882B-2E11-426D-B6EE-A6416DDDA4EC",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.location.RegionModel"
                    },
                    "bindable": "regionId",
                    "bind": "{regionId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A9607E2D-8AA9-4227-9985-FE6F7565D8B2",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Onlineshopping.onlineshopping.shared.shop.model.location.DistrictModel"
                    },
                    "bindable": "districtId",
                    "bind": "{districtId}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaName",
                    "itemId": "talukaName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "92A794B3-3453-4073-85EE-F8640B2FEC6F",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "talukaName",
                    "bind": "{talukaName}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaCode",
                    "itemId": "talukaCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "55A5FD71-38ED-4E75-A0E2-6FCBC1CB2688",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "talukaCode",
                    "bind": "{talukaCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaDescription",
                    "itemId": "talukaDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "taluka Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Description",
                    "fieldId": "1C810627-568C-45EB-A7D6-56D9F9249C89",
                    "bindable": "talukaDescription",
                    "bind": "{talukaDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaFlag",
                    "itemId": "talukaFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "6CE68613-042C-4B7F-AADD-51409D82002B",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "talukaFlag",
                    "bind": "{talukaFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLatitude",
                    "itemId": "talukaLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "talukaaLatitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaaLatitude",
                    "fieldId": "D796551C-0980-47F4-8642-20BAC6B1DC11",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLatitude",
                    "bind": "{talukaLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLongitude",
                    "itemId": "talukaLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Citry Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Citry Longitude",
                    "fieldId": "78532C90-3AE2-4421-903A-1CCC2F564EC7",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLongitude",
                    "bind": "{talukaLongitude}",
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
                    "fieldId": "0F0F9C27-2EED-45B0-B14E-CFEC28D8C6DB",
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
                    "customId": 232,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 232,
                         "customId": 633
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 232,
                         "customId": 634,
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
                         "parentId": 232,
                         "customId": 635,
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