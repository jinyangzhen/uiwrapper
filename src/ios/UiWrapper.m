//
//  UiWrapper.m
//  SM Mobile Client
//
//  Created by yangzhen.jin@hp.com on 6/22/14.
//
//

#import "UiWrapper.h"
#import "../Classes/AppDelegate.h"
#import <Cordova/CDV.h>

@implementation UiWrapper

- (void) reload:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    
    AppDelegate* appDelegate = [[UIApplication sharedApplication] delegate];
    CDVViewController* topview = appDelegate.viewController;
    
    [topview.webView stringByEvaluatingJavaScriptFromString:@"location='file:///index.html'"];
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"reloaded"];
     //   pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
