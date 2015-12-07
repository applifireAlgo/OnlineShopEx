Ext.define('Onlineshopping.onlineshopping.web.shop.view.retail.ItemCatalogue', {
     "xtype": "itemCatalogue",
     "name": "itemCat",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "itemList",
          "items": [],
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "2.0"
          },
          "templateConfig": {
               "uiId": "803627A5-AB22-4DC2-8598-CCF9C40A0FA6",
               "uiClass": "Onlineshopping.onlineshopping.web.shop.view.retail.CartPartial",
               "uiType": 2,
               "url": "secure/Item/findAll",
               "requestMethodType": "GET"
          },
          "padding": 0,
          "margin": 5,
          "itemId": "olboaoi",
          "dockedItems": []
     }],
     "border": true,
     "title": "Item Catalogue",
     "margin": 5,
     "itemId": "jocdgoi",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "layout": "fit",
     "requires": ["Onlineshopping.onlineshopping.web.shop.controller.retail.ItemCatalogueController", "Onlineshopping.onlineshopping.shared.shop.viewmodel.retail.ItemCatalogueViewModel", "Onlineshopping.onlineshopping.shared.shop.model.retail.ItemCatalogueModel", "Onlineshopping.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatalogueViewModel",
     "controller": "ItemCatalogueController"
});