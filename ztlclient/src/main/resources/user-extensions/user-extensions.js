/* zselenium.js

	Purpose:
		
	Description:
		
	History:
		Fri May 20 21:05:40     201, Created by TonyQ

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under GPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
//Reference to 
//http://seleniumhq.org/docs/08_user_extensions.html
// The "inDocument" is a the document you are searching.
PageBot.prototype.locateElementByZK = function(text, inDocument) {

	var locator = text;
	
	if (locator.indexOf("zk.") == 0 || locator.indexOf("zk(") == 0
			|| locator.indexOf("jq") == 0) {
		locator = selenium.getUserEval(locator);
		
		if (locator.length == 0 )
			throw new SeleniumError("Element " + locator + " not found");
		
		if (locator.length)
			return locator[0];
		else if (locator.$n)
			return locator.$n();
		return (locator);
	}
	if (locator.charAt(0) == '$' || locator.charAt(0) == '#') {
		var win = this.getCurrentWindow();
		if (win.zk) {
			var element = win.zk(locator).jq[0];
			if (element != null) {
	        	return this.browserbot.highlight(element);
	    	}
	    }
	    LOG.debug('ZK is not found!');
	}
    var element = this.findElementOrNull(locator, win);
    if (element == null) throw new SeleniumError("Element " + locator + " not found");
    return element;
};


//Reference to http://wiki.openqa.org/display/SEL/eval
/*
 * @TODO review this with zSelenium.js 
 */
Selenium.prototype.getUserEval = function(script) {
    try {
        var window = this.browserbot.getUserWindow(),
			result = (window.jq ? window.jq.evalJSON : eval)(script);
        // Selenium RC doesn't allow returning null
        if (result == null) return "null";
        return result;
    } catch (e) {
        throw new SeleniumError("Threw an exception: " + extractExceptionMessage(e));
    }
};

//referecne to http://wiki.openqa.org/display/SEL/waitForCondition
Selenium.prototype.doWaitForCondition = function(script, timeout) {
    if (isNaN(timeout)) {
    	throw new SeleniumError("Timeout is not a number: " + timeout);
    }
    
    testLoop.waitForCondition = function () {
        return eval(script);
    };
    
    testLoop.waitForConditionStart = new Date().getTime();
    testLoop.waitForConditionTimeout = timeout;
    
    testLoop.pollUntilConditionIsTrue = function () {
        try {
	        if (this.waitForCondition()) {
	            this.waitForCondition = null;
	            this.waitForConditionStart = null;
	            this.waitForConditionTimeout = null;
	            this.continueCommandExecutionWithDelay();
	        } else {
	        	if (this.waitForConditionTimeout != null) {
		        	var now = new Date();
		        	if ((now - this.waitForConditionStart) > this.waitForConditionTimeout) {
		        		throw new SeleniumError("Timed out after " + this.waitForConditionTimeout + "ms");
		        	}
		        }
	            window.setTimeout("testLoop.pollUntilConditionIsTrue()", 10);
	        }
	    } catch (e) {
	    	var lastResult = new CommandResult();
    		lastResult.failed = true;
    		lastResult.failureMessage = e.message;
	    	this.commandComplete(lastResult);
	    	this.testComplete();
	    }
    };
};
