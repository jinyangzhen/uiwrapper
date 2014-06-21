/*
 * (C) Copyright Hewlett-Packard Development Company, LP -  All Rights Reserved.
 * User: yangzhen.jin@hp.com
 * Date: 6/21/14
 */
var exec = require("cordova/exec");

function UiWrapper() {
}

UiWrapper.prototype.reload = function (message, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'UiWrapper', 'reload', [message]);
};

var uiwrapper = new UiWrapper();
module.exports = uiwrapper;
