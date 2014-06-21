/*
 * (C) Copyright Hewlett-Packard Development Company, LP -  All Rights Reserved.
 */
package com.hp.dreadwing.plugin;

import android.util.Log;
import org.apache.cordova.CordovaActivity;
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
        final CallbackContext ctxt = callbackContext;

        if (action.equals(ACTION_RELOAD)) {
            final Mobility act = (Mobility)cordova.getActivity();
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    act.reloadMainView();
                    Log.d("UiWrapper", "called by ui thread");
                    ctxt.success("1234");
                }
            });

            return true;
        }

        callbackContext.error("Invalid action" + action + args);
        return false;
    }
}
