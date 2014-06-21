/*
 * (C) Copyright Hewlett-Packard Development Company, LP -  All Rights Reserved.
 */
package com.hp.dreadwing.plugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.hp.dreadwing.Mobility;

/**
 * User: yangzhen.jin@hp.com
 * Date: 6/21/14
 */
public class UiWrapper extends CordovaPlugin {

    private final static String ACTION_RELOAD = "reload";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals(ACTION_RELOAD)) {
            Mobility ma = (Mobility) cordova.getActivity();
            ma.reloadMainView();
            callbackContext.success();
            return true;
        }

        callbackContext.error("Invalid action");
        return false;
    }
}
