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
public class B36_2813877Test extends ZKClientTestCase {

	public B36_2813877Test() {
		target = "http://10.1.3.142:8889/zk5/ztl.zul";
		browsers = getBrowsers("all");
		_timeout = 60000;
		caseID = getClass().getSimpleName();
	}

	@Test(expected = AssertionError.class)
	public void testresizer() {
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
					+ "				<window id=\"win\" border=\"normal\" width=\"350px\" minheight=\"350\">"
					+ "					<caption"
					+ "						image=\"/img/Centigrade-Widget-Icons/FirstWindow-24x24.png\""
					+ "						label=\"Complex Window\" />"
					+ "					<borderlayout height=\"300px\">"
					+ "						<north border=\"none\">"
					+ "							<menubar id=\"menubar\" width=\"100%\">"
					+ "								<menu label=\"Project\""
					+ "									src=\"/img/Centigrade-Widget-Icons/Briefcase-16x16.png\">"
					+ "									<menupopup>"
					+ "										<menuitem"
					+ "											src=\"/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png\""
					+ "											label=\"New\" onClick=\"alert(self.label)\" />"
					+ "										<menuitem"
					+ "											src=\"/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png\""
					+ "											label=\"Open\" onClick=\"alert(self.label)\" />"
					+ "										<menuitem"
					+ "											src=\"/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png\""
					+ "											label=\"Save\" onClick=\"alert(self.label)\" />"
					+ "										<menuseparator />"
					+ "										<menuitem label=\"Exit\""
					+ "											src=\"/img/Centigrade-Widget-Icons/DoorOpen-16x16.png\""
					+ "											onClick=\"alert(self.label)\" />"
					+ "									</menupopup>"
					+ "								</menu>"
					+ "								<menu label=\"Help\""
					+ "									src=\"/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png\">"
					+ "									<menupopup>"
					+ "										<menuitem label=\"Index\""
					+ "											onClick=\"alert(self.label)\" />"
					+ "										<menu label=\"About\">"
					+ "											<menupopup>"
					+ "												<menuitem label=\"About ZK\""
					+ "													onClick=\"alert(self.label)\" />"
					+ "												<menuitem label=\"About Potix\""
					+ "													onClick=\"alert(self.label)\" />"
					+ "											</menupopup>"
					+ "										</menu>"
					+ "									</menupopup>"
					+ "								</menu>"
					+ "								<menu"
					+ "									src=\"/img/Centigrade-Widget-Icons/Spyglass-16x16.png\">"
					+ "									<menupopup>"
					+ "										<menuitem label=\"Index\""
					+ "											onClick=\"alert(self.label)\" />"
					+ "									</menupopup>"
					+ "								</menu>"
					+ "							</menubar>"
					+ "						</north>"
					+ "						<center>"
					+ "							<div>"
					+ "								Auto-position (applicable if not embedded)"
					+ "								<image src=\"/img/earth.png\" />"
					+ "							</div>"
					+ "						</center>"
					+ "						<south border=\"0\">"
					+ "							<toolbar mold=\"panel\" align=\"center\">"
					+ "								<button label=\"left,center\""
					+ "									onClick=\"win.position = &quot;left,center&quot;;\" />"
					+ "								<button label=\"right,bottom\""
					+ "									onClick=\"win.position = &quot;right,bottom&quot;;\" />"
					+ "								<button label=\"center\""
					+ "									onClick=\"win.position = &quot;center&quot;;\" />"
					+ "							</toolbar>"
					+ "						</south>"
					+ "					</borderlayout>"
					+ "				</window>"
					+ "				<button label=\"Overlap\""
					+ "					onClick=\"win.setSizable(true);win.doOverlapped();\" />"
					+ "				<button label=\"Popup\" onClick=\"win.setSizable(true);win.doPopup();\" />"
					+ "				<button label=\"Embed\""
					+ "					onClick=\"win.setSizable(false);win.doEmbedded();\" />"
					+ "			</zk>"
					+ "		"
					;
				runZscript(zscript);
				Widget win = engine.$f("win");
				Widget menubar = engine.$f("menubar");
				waitResponse();
				/** client code **/
		
				click(jq("@button[label=\"Overlap\"] td.z-button-cm"));

		
				/** end **/
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				stop();
			}
		}
	}
}



