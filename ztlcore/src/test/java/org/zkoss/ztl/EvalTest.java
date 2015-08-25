/* B36_2813877Test.java

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
public class EvalTest extends ZKClientTestCase {

	public EvalTest() {
		target = "http://10.1.3.142:8889/zk5/ztl.zul";
		browsers = getBrowsers("firefox");
		_timeout = 60000;
		caseID = getClass().getSimpleName();
	}

	@Test(expected = AssertionError.class)
	public void testresizer() {
		for (Selenium browser : browsers) {
			try {
				start(browser);
				
				browser.getEval("alert('hi')");
		
				/** end **/
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				stop();
			}
		}
	}
}



