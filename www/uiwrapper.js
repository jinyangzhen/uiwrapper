/*
 * (C) Copyright Hewlett-Packard Development Company, LP -  All Rights Reserved.
 * User: yangzhen.jin@hp.com
 * Date: 6/21/14
 */
cordova.define("com.hp.dreadwing.plugin.uiwrapper", function (require, exports, module) {
    var exec = require("cordova/exec");

    function UiWrapper() {}

    UiWrapper.prototype.reload = function (message, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UiWrapper', 'reload', [message]);
    };

    var uiwrapper = new UiWrapper();
    module.exports = uiwrapper;
});