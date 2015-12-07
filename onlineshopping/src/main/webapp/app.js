/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Onlineshopping',

    extend: 'Onlineshopping.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Onlineshopping.view.mainleftmenutree.MainPanel':'Onlineshopping.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Onlineshopping.view.login.LoginPage':'Onlineshopping.view.mobileview.login.LoginPage',//'Onlineshopping.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Onlineshopping.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
