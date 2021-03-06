/* ZKSelenium.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Aug 18, 2010 3:54:01 PM , Created by jumperchen
}}IS_NOTE

Copyright (C) 2010 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.ztl.util;

import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.DefaultSelenium;

/**
 * @author jumperchen
 *
 */
public class ZKSelenium extends DefaultSelenium {
	private String _browserbrand;
	private String _browsername;
	
	private boolean _openonce = false;
	private int _cyclecount = 0;
	
	private boolean isBrowserOpened = false;
	@Override
	public void start() {
		if(_openonce){
			_cyclecount++;
			if(_cyclecount % 20 == 0){
				super.close();
				super.stop();
				super.start();
			}
				
			if(!isBrowserOpened){
				super.start();
				isBrowserOpened = true;
			}
		}else{
			super.start();
		}
	}
	@Override
	public void close() {
		if(!_openonce)
			super.close();
	}
	@Override
	public void stop() {
		if(!_openonce)
			super.stop();
	}
	
	/**
	 * Do ZK way eval
	 * @param script
	 * @return
	 */
	public String getEval(String script) {
		return commandProcessor.getString("getUserEval", new String[] {script,});
	}
	
	public ZKSelenium(CommandProcessor processor,boolean openonce) {
		super(processor);
		this._openonce=openonce;
	}
	public ZKSelenium(CommandProcessor processor, String browserbrand, 
			String browsername,boolean openonce) {
		super(processor);
		this._openonce=openonce;
		_browserbrand = browserbrand;
		_browsername = browsername;
	}
	public String getBrowserBrand() {
		return _browserbrand;
	}
	
	public String getBrowserName() {
		return _browsername;
	}
	
	public CommandProcessor getCmdProcessor() {
	    return commandProcessor;
	}
	
}
