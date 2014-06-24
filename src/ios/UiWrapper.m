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
    
    NSString* path = [[NSBundle mainBundle] pathForResource:@"www/index" ofType:@"html"];
    NSURL* url = [NSURL fileURLWithPath:path];
    NSURLRequest* request = [NSURLRequest requestWithURL: url];
    
    [topview.webView loadRequest:request];

    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"reloaded"];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
