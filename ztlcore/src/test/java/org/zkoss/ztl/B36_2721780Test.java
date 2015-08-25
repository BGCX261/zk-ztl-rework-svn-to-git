/* B36_2721780Test.java

	Purpose:ztl for ${ztl.ztlName} , zul ${ztl.zulName}

	Description:

	History:
		����, 20, 2011 17:45:48 �U��

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under Apache License Version 2.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.ztl;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;

@Tags(tags = "window")
public class B36_2721780Test extends ZKClientTestCase {

	public B36_2721780Test() {
		target = "http://10.1.3.142:8889/zk5/ztl.zul";
		browsers = getBrowsers("all");
		_timeout = 60000;
		caseID = getClass().getSimpleName();
	}

	@Test(expected = AssertionError.class)
	public void testsize() {
		for (Selenium browser : browsers) {
			try {
				start(browser);
				windowFocus();
				windowMaximize();
				String zscript = "";
				Widget engine = new Widget(new StringBuffer("zk.Desktop._dt"));

				// remove all of unnecessary children
				if (target.endsWith("/service.zul"))
					removeChildren(engine.firstChild());

				/** start **/
				/** server code **/
				zscript = ""
					+ "			<zk>"
					+ "			Resize the outer window, the inner most window should not change."
					+ "			<window id=\"out\" border=\"normal\" title=\".\" sizable=\"true\""
					+ "			  mode=\"overlapped\" width=\"500px\" height=\"500px\">"
					+ "			  <window id=\"middle\" border=\"normal\" width=\"300px\" height=\"300px\">"
					+ "			    <window id=\"innermost\" border=\"normal\" width=\"100px\""
					+ "			      height=\"100px\" sizable=\"true\" mode=\"overlapped\">"
					+ "			"
					+ "			    </window>"
					+ "			  </window>"
					+ "			</window>"
					+ "			</zk>"
					+ "		"
					;
				runZscript(zscript);
				Widget out = engine.$f("out");
				Widget middle = engine.$f("middle");
				Widget innermost = engine.$f("innermost");
				waitResponse();
				/** client code **/
		
				JQuery cr = jq("$out div.z-window-overlapped-cr");
				JQuery br = jq("$out div.z-window-overlapped-br");
				JQuery innerWin = jq(innermost);
				int oldHeight = innerWin.outerHeight();
				int oldWidth = innerWin.outerWidth();
				int left = cr.offsetLeft() + cr.outerWidth();
				int top = cr.offsetTop() + 10;
				dragdropTo(cr, left + "," + top, (left + 100) + "," + top);
				verifyEquals(oldHeight, innerWin.outerHeight());
				verifyEquals(oldWidth, innerWin.outerWidth());
				left =cr.outerWidth() / 2;
				top = br.offsetTop();
				dragdropTo(cr, left + "," + top, left + "," + (top + 100));
				verifyEquals(oldHeight, innerWin.outerHeight());
				verifyEquals(oldWidth, innerWin.outerWidth());
		
				/** end **/
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				stop();
			}
		}
	}
}



