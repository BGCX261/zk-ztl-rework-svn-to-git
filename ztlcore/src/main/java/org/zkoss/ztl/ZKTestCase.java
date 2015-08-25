/* ZKTestCase.java

	Purpose:
		
	Description:
		
	History:
		Wed Sep 16 12:49:43 TST 2009, Created by sam

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

This program is distributed under GPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.ztl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.imageio.ImageIO;

import org.zkoss.ztl.util.ConfigHelper;
import org.zkoss.ztl.util.ZKSelenium;
import org.zkoss.ztl.util.image.Comparator;
import org.zkoss.ztl.util.image.DefaultComparator;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.thoughtworks.selenium.Selenium;
/**
 * A skeleton of ZK Selenium test, which implements all of the methods of {@link Selenium}
 * interface.
 * 
 * @author sam
 * @author jumperchen
 *
 */
public class ZKTestCase extends ZKSeleneseTestCase implements Selenium {
	protected static final ThreadLocal<Selenium> _selenium = new ThreadLocal<Selenium>();
	/**
	 * The keycode of the PAGE_UP key
	 */
	public static final String PAGE_UP = "33";
	/**
	 * The keycode of the PAGE_DOWN key
	 */
	public static final String PAGE_DOWN = "34";
	/**
	 * The keycode of the END key
	 */
	public static final String END = "35";
	/**
	 * The keycode of the HOME key
	 */
	public static final String HOME = "36";
	/**
	 * The keycode of the LEFT key
	 */
	public static final String LEFT = "37";
	/**
	 * The keycode of the UP key
	 */
	public static final String UP = "38";
	/**
	 * The keycode of the RIGHT key
	 */
	public static final String RIGHT = "39";
	/**
	 * The keycode of the DOWN key
	 */
	public static final String DOWN = "40";
	/**
	 * The keycode of the INSERT key
	 */
	public static final String INSERT = "45";
	/**
	 * The keycode of the DELETE key
	 */
	public static final String DELETE = "46";
	/**
	 * keypressNative native follow java.awt.Event's keycode .
	 */
	public static final String DELETE_NATIVE = "127";
	/**
	 * The keycode of the BACKSPACE key
	 */
	public static final String BACKSPACE = "8";
	/**
	 * The keycode of the TAB key
	 */
	public static final String TAB = "9";
	/**
	 * The keycode of the ENTER key
	 */
	public static final String ENTER = "13";
	/**
	 * The keycode of the ESC key
	 */
	public static final String ESC = "27";
	/**
	 * The keycode of the SHIFT key
	 */
	public static final String SHIFT = "16";
	/**
	 * The keycode of the CTRL key
	 */
	public static final String CTRL = "17";
	/**
	 * The keycode of the ALT key
	 */
	public static final String ALT = "18";
	/**
	 * The keycode of the A key
	 */
	public static final String A = "65";
	/**
	 * The keycode of the C key
	 */
	public static final String C = "67";
	/**
	 * The keycode of the V key
	 */
	public static final String V = "86";
	/**
	 * The keycode of the X key
	 */
	public static final String X = "88";
	
	/**
	 * The prefix is depended on what the ID generator is.
	 */
	private static String PREFIX = "zk_comp_";

	private static SimpleDateFormat format = new SimpleDateFormat("MMddHH");
	
	// implicit variable
	protected String target;
	protected List<Selenium> browsers;
	protected String caseID;

	/**
	 * Launches the browser with a new Selenium session
	 */
	protected void start(Selenium selenium) {
		System.out.println("testing:"+((ZKSelenium)selenium).getBrowserName());
		selenium.start();
		selenium.open(target);
		if (selenium == null)
		    Thread.dumpStack();
		
		_selenium.set(selenium);
		this.selenium = selenium;
	}
	
	/**
	 * Returns the current browser.
	 */
	public static final Selenium getCurrent() {
	    Selenium selenium = _selenium.get();
	    if (selenium == null)
	        Thread.dumpStack();
	    
	    return selenium;
	}

	
	
	public void setUp() {
		if (target == null)
			throw new NullPointerException("target cannot be null!");
	}

	protected final static String uuid(int number) {
		return PREFIX + number;
	}
	
	protected List<Selenium> getBrowsers(String browsers) {
		return ConfigHelper.getInstance().getBrowsers(browsers);
	}
	
	/**
	 * Resizes the current window to the size(width and height).
	 */
	public void windowResizeTo(int width, int height) {
		getCurrent().getEval("window.resizeTo("+width + "," + height+")");
	}
	
	/** untested yet
	protected List<LoggingSelenium> getLoggingBrowsers(String browsers, BufferedWriter loggingWriter){
		return ConfigHelper.getInstance().getLoggingBrowsers(browsers, loggingWriter);
	}
	*/
	
	
	public void addLocationStrategy(String strategyName,
			String functionDefinition) {
		getCurrent().addLocationStrategy(strategyName, functionDefinition);
	}

	
	public void addScript(String scriptContent, String scriptTagId) {
		getCurrent().addScript(scriptContent, scriptTagId);
	}

	
	public void addSelection(String locator, String optionLocator) {
		getCurrent().addSelection(locator, optionLocator);
	}

	
	public void allowNativeXpath(String allow) {
		getCurrent().allowNativeXpath(allow);
	}

	
	public void altKeyDown() {
		getCurrent().altKeyDown();
	}

	
	public void altKeyUp() {
		getCurrent().altKeyUp();
	}

	
	public void answerOnNextPrompt(String answer) {
		getCurrent().answerOnNextPrompt(answer);
	}

	
	public void assignId(String locator, String identifier) {
		getCurrent().assignId(locator, identifier);
	}

	
	public void attachFile(String fieldLocator, String fileLocator) {
		getCurrent().attachFile(fieldLocator, fileLocator);		
	}

	
	public void captureEntirePageScreenshot(String filename, String kwargs) {
		getCurrent().captureEntirePageScreenshot(filename, kwargs);
	}

	
	public String captureEntirePageScreenshotToString(String kwargs) {
		return getCurrent().captureEntirePageScreenshotToString(kwargs);
	}

	
	public void captureScreenshot(String filename) {
		getCurrent().captureScreenshot(filename);
	}

	
	public String captureScreenshotToString() {
		return getCurrent().captureScreenshotToString();
	}

	
	public void check(String locator) {
		getCurrent().check(locator);
	}

	
	public void chooseCancelOnNextConfirmation() {
		getCurrent().chooseCancelOnNextConfirmation();
	}

	
	public void chooseOkOnNextConfirmation() {
		getCurrent().chooseOkOnNextConfirmation();
	}

	
	public void click(String locator) {
		getCurrent().click(locator);
	}

	
	public void clickAt(String locator, String coordString) {
		getCurrent().clickAt(locator, coordString);
	}

	
	public void close() {
		getCurrent().close();
	}

	
	public void contextMenu(String locator) {
		getCurrent().contextMenu(locator);
	}

	
	public void contextMenuAt(String locator, String coordString) {
		getCurrent().contextMenuAt(locator, coordString);
	}

	
	public void controlKeyDown() {
		getCurrent().controlKeyDown();
	}

	
	public void controlKeyUp() {
		getCurrent().controlKeyUp();
	}

	
	public void createCookie(String nameValuePair, String optionsString) {
		getCurrent().createCookie(nameValuePair, optionsString);
	}

	
	public void deleteAllVisibleCookies() {
		getCurrent().deleteAllVisibleCookies();
	}

	
	public void deleteCookie(String name, String optionsString) {
		getCurrent().deleteCookie(name, optionsString);
	}

	
	public void doubleClick(String locator) {
		// don't use doubleClick(), because it fails in IE
		getCurrent().doubleClickAt(locator, "0,0");
	}

	
	public void doubleClickAt(String locator, String coordString) {
		getCurrent().doubleClickAt(locator, coordString);
	}

	
	public void dragAndDrop(String locator, String movementsString) {
		getCurrent().dragAndDrop(locator, movementsString);
	}
	
	/**
	 * Drags and drops the specific element from its specific area to another area.
	 * <p>For example,<br/>
	 * 		draggdropTo("z-xxx", "10,20", "20,20")
	 * <p>The result of the "z-xxx" is moved 10px right.
	 * @param locatorOfObjectToBeDragged the draggable UUID
	 * @param from the "x,y" value is related to the draggable element, which is dragged from.
	 * @param to the "x,y" value is related to the draggable element, which is dropped to.
	 */
	public void dragdropTo(String locatorOfObjectToBeDragged, String from, String to) {
		Selenium browser = getCurrent();
		browser.mouseDownAt(locatorOfObjectToBeDragged, from);
		browser.mouseMoveAt(locatorOfObjectToBeDragged, to);
		browser.mouseUpAt(locatorOfObjectToBeDragged, to);
	}
	
	/**
	 * Drags and drops the specific element from its specific area to another element.
	 * <p>For example,<br/>
	 * 		draggdropToObject("z-xxx", "z-yyy", "10,20", "10,20")
	 * <p>The result of the "z-xxx" is moved to the position(10,20) of the "z-yyy".
	 * @param locatorOfObjectToBeDragged the draggable UUID
	 * @param locatorOfDragDestinationObject the droppable UUID
	 * @param from the "x,y" value is related to the draggable element, which is dragged from.
	 * @param to the "x,y" value is related to the droppable element, which is dropped to.
	 */
	public void dragdropToObject(String locatorOfObjectToBeDragged,
			String locatorOfDragDestinationObject, String from, String to) {
		Selenium browser = getCurrent();
		browser.mouseDownAt(locatorOfObjectToBeDragged, from);
		browser.mouseMoveAt(locatorOfDragDestinationObject, to);
		browser.mouseUpAt(locatorOfDragDestinationObject, to);
	}
	
	
	public void dragAndDropToObject(String locatorOfObjectToBeDragged,
			String locatorOfDragDestinationObject) {
		getCurrent().dragAndDropToObject(locatorOfObjectToBeDragged, locatorOfDragDestinationObject);
	}

	
	public void dragdrop(String locator, String movementsString) {
		getCurrent().dragdrop(locator, movementsString);
	}

	
	public void fireEvent(String locator, String eventName) {
		getCurrent().fireEvent(locator, eventName);
	}

	
	public void focus(String locator) {
		getCurrent().focus(locator);
	}

	
	public String getAlert() {
		return getCurrent().getAlert();
	}

	
	public String[] getAllButtons() {
		return getCurrent().getAllButtons();
	}

	
	public String[] getAllFields() {
		return getCurrent().getAllFields();
	}

	
	public String[] getAllLinks() {
		return getCurrent().getAllLinks();
	}

	
	public String[] getAllWindowIds() {
		return getCurrent().getAllWindowIds();
	}

	
	public String[] getAllWindowNames() {
		return getCurrent().getAllWindowNames();
	}

	
	public String[] getAllWindowTitles() {
		return getCurrent().getAllWindowTitles();
	}

	
	public String getAttribute(String attributeLocator) {
		return getCurrent().getAttribute(attributeLocator);
	}

	
	public String[] getAttributeFromAllWindows(String attributeName) {
		return getCurrent().getAttributeFromAllWindows(attributeName);
	}

	
	public String getBodyText() {
		return getCurrent().getBodyText();
	}

	
	public String getConfirmation() {
		return getCurrent().getConfirmation();
	}

	
	public String getCookie() {
		return getCurrent().getCookie();
	}

	
	public String getCookieByName(String name) {
		return getCurrent().getCookieByName(name);
	}

	
	public Number getCursorPosition(String locator) {
		return getCurrent().getCursorPosition(locator);
	}

	
	public Number getElementHeight(String locator) {
		return getCurrent().getElementHeight(locator);
	}

	
	public Number getElementIndex(String locator) {
		return getCurrent().getElementIndex(locator);
	}

	
	public Number getElementPositionLeft(String locator) {
		return getCurrent().getElementPositionLeft(locator);
	}

	
	public Number getElementPositionTop(String locator) {
		return getCurrent().getElementPositionTop(locator);
	}

	
	public Number getElementWidth(String locator) {
		return getCurrent().getElementWidth(locator);
	}

	
	public String getEval(String script) {
		return getCurrent().getEval(script);
	}

	
	public String getExpression(String expression) {
		return getCurrent().getExpression(expression);
	}

	
	public String getHtmlSource() {
		return getCurrent().getHtmlSource();
	}

	
	public String getLocation() {
		return getCurrent().getLocation();
	}

	
	public Number getMouseSpeed() {
		return getCurrent().getMouseSpeed();
	}

	
	public String getPrompt() {
		return getCurrent().getPrompt();
	}

	
	public String[] getSelectOptions(String selectLocator) {
		return getCurrent().getSelectOptions(selectLocator);
	}

	
	public String getSelectedId(String selectLocator) {
		return getCurrent().getSelectedId(selectLocator);
	}

	
	public String[] getSelectedIds(String selectLocator) {
		return getCurrent().getSelectedIds(selectLocator);
	}

	
	public String getSelectedIndex(String selectLocator) {
		return getCurrent().getSelectedIndex(selectLocator);
	}

	
	public String[] getSelectedIndexes(String selectLocator) {
		return getCurrent().getSelectedIndexes(selectLocator);
	}

	
	public String getSelectedLabel(String selectLocator) {
		return getCurrent().getSelectedLabel(selectLocator);
	}

	
	public String[] getSelectedLabels(String selectLocator) {
		return getCurrent().getSelectedLabels(selectLocator);
	}

	
	public String getSelectedValue(String selectLocator) {
		return getCurrent().getSelectedValue(selectLocator);
	}

	
	public String[] getSelectedValues(String selectLocator) {
		return getCurrent().getSelectedValues(selectLocator);
	}

	
	public String getSpeed() {
		return getCurrent().getSpeed();
	}

	
	public String getTable(String tableCellAddress) {
		return getCurrent().getTable(tableCellAddress);
	}

	
	public String getText(String locator) {
		return getCurrent().getText(locator);
	}

	
	public String getTitle() {
		return getCurrent().getTitle();
	}

	
	public String getValue(String locator) {
		return getCurrent().getValue(locator);
	}

	
	public boolean getWhetherThisFrameMatchFrameExpression(
			String currentFrameString, String target) {
		return getCurrent().getWhetherThisFrameMatchFrameExpression(currentFrameString, target);
	}

	
	public boolean getWhetherThisWindowMatchWindowExpression(
			String currentWindowString, String target) {
		return getCurrent().getWhetherThisWindowMatchWindowExpression(currentWindowString, target);
	}

	
	public Number getXpathCount(String xpath) {
		return getCurrent().getXpathCount(xpath);
	}

	
	public void goBack() {
		getCurrent().goBack();
	}

	
	public void highlight(String locator) {
		getCurrent().highlight(locator);
	}

	
	public void ignoreAttributesWithoutValue(String ignore) {
		getCurrent().ignoreAttributesWithoutValue(ignore);
	}

	
	public boolean isAlertPresent() {
		return getCurrent().isAlertPresent();
	}

	
	public boolean isChecked(String locator) {
		return getCurrent().isChecked(locator);
	}

	
	public boolean isConfirmationPresent() {
		return getCurrent().isConfirmationPresent();
	}

	
	public boolean isCookiePresent(String name) {
		return getCurrent().isCookiePresent(name);
	}

	
	public boolean isEditable(String locator) {
		return getCurrent().isEditable(locator);
	}

	
	public boolean isElementPresent(String locator) {
		return getCurrent().isElementPresent(locator);
	}

	
	public boolean isOrdered(String locator1, String locator2) {
		return getCurrent().isOrdered(locator1, locator2);
	}

	
	public boolean isPromptPresent() {
		return getCurrent().isPromptPresent();
	}

	
	public boolean isSomethingSelected(String selectLocator) {
		return getCurrent().isSomethingSelected(selectLocator);
	}

	
	public boolean isTextPresent(String pattern) {
		return getCurrent().isTextPresent(pattern);
	}

	
	public boolean isVisible(String locator) {
		return getCurrent().isVisible(locator);
	}

	
	public void keyDown(String locator, String keySequence) {
		getCurrent().keyDown(locator, keySequence);
	}

	
	public void keyDownNative(String keycode) {
		getCurrent().keyDownNative(keycode);
	}

	
	public void keyPress(String locator, String keySequence) {
		getCurrent().keyPress(locator, keySequence);
	}

	
	public void keyPressNative(String keycode) {
		getCurrent().keyPressNative(keycode);
	}

	
	public void keyUp(String locator, String keySequence) {
		getCurrent().keyUp(locator, keySequence);
	}

	
	public void keyUpNative(String keycode) {
		getCurrent().keyUpNative(keycode);
	}

	
	public void metaKeyDown() {
		getCurrent().metaKeyDown();
	}

	
	public void metaKeyUp() {
		getCurrent().metaKeyUp();
	}

	
	public void mouseDown(String locator) {
		getCurrent().mouseDown(locator);
	}

	
	public void mouseDownAt(String locator, String coordString) {
		getCurrent().mouseDownAt(locator, coordString);
	}

	
	public void mouseDownRight(String locator) {
		getCurrent().mouseDownRight(locator);
	}

	
	public void mouseDownRightAt(String locator, String coordString) {
		getCurrent().mouseDownRightAt(locator, coordString);		
	}

	
	public void mouseMove(String locator) {
		getCurrent().mouseMove(locator);
	}

	
	public void mouseMoveAt(String locator, String coordString) {
		getCurrent().mouseMoveAt(locator, coordString);
	}

	
	public void mouseOut(String locator) {
		getCurrent().mouseOut(locator);
	}

	
	public void mouseOver(String locator) {
		getCurrent().mouseOver(locator);
	}

	
	public void mouseUp(String locator) {
		getCurrent().mouseUp(locator);
	}

	
	public void mouseUpAt(String locator, String coordString) {
		getCurrent().mouseUpAt(locator, coordString);
	}

	
	public void mouseUpRight(String locator) {
		getCurrent().mouseUpRight(locator);
	}

	
	public void mouseUpRightAt(String locator, String coordString) {
		getCurrent().mouseUpRightAt(locator, coordString);
	}

	
	public void open(String url) {
		getCurrent().open(url);
	}

	
	public void openWindow(String url, String windowID) {
		getCurrent().openWindow(url, windowID);
	}

	
	public void refresh() {
		getCurrent().refresh();
	}

	
	public void removeAllSelections(String locator) {
		getCurrent().removeAllSelections(locator);
	}

	
	public void removeScript(String scriptTagId) {
		getCurrent().removeScript(scriptTagId);
	}

	
	public void removeSelection(String locator, String optionLocator) {
		getCurrent().removeSelection(locator, optionLocator);
	}

	
	public String retrieveLastRemoteControlLogs() {
		return getCurrent().retrieveLastRemoteControlLogs();
	}

	
	public void rollup(String rollupName, String kwargs) {
		getCurrent().rollup(rollupName, kwargs);
	}

	
	public void runScript(String script) {
		getCurrent().runScript(script);
	}

	
	public void select(String selectLocator, String optionLocator) {
		getCurrent().focus(selectLocator);
		getCurrent().select(selectLocator, optionLocator);
		
		// fixed for IE to fire onchange event.
		getCurrent().windowFocus();
	}

	
	public void selectFrame(String locator) {
		getCurrent().selectFrame(locator);
	}

	
	public void selectWindow(String windowID) {
		getCurrent().selectWindow(windowID);
	}

	
	public void setBrowserLogLevel(String logLevel) {
		getCurrent().setBrowserLogLevel(logLevel);
	}

	
	public void setContext(String context) {
		getCurrent().setContext(context);
	}

	
	public void setCursorPosition(String locator, String position) {
		getCurrent().setCursorPosition(locator, position);
	}

	
	public void setExtensionJs(String extensionJs) {
		getCurrent().setExtensionJs(extensionJs);
	}

	
	public void setMouseSpeed(String pixels) {
		getCurrent().setMouseSpeed(pixels);
	}

	
	public void setSpeed(String value) {
		getCurrent().setSpeed(value);
	}

	
	public void setTimeout(String timeout) {
		getCurrent().setTimeout(timeout);
	}

	
	public void shiftKeyDown() {
		getCurrent().shiftKeyDown();
	}

	
	public void shiftKeyUp() {
		getCurrent().shiftKeyUp();
	}

	
	public void showContextualBanner() {
		getCurrent().showContextualBanner();
	}

	
	public void showContextualBanner(String className, String methodName) {
		getCurrent().showContextualBanner(className, methodName);
	}

	
	public void shutDownSeleniumServer() {
		getCurrent().shutDownSeleniumServer();
	}

	
	public void start() {
		getCurrent().start();
	}

	
	public void start(String optionsString) {
		getCurrent().start(optionsString);
	}

	
	public void start(Object optionsObject) {
		getCurrent().start(optionsObject);
	}

	
	public void submit(String formLocator) {
		getCurrent().submit(formLocator);
	}

	
	public void type(String locator, String value) {
		getCurrent().type(locator, value);		
	}

	
	public void typeKeys(String locator, String value) {
		getCurrent().typeKeys(locator, value);
	}

	
	public void uncheck(String locator) {
		getCurrent().uncheck(locator);
	}

	
	public void useXpathLibrary(String libraryName) {
		getCurrent().useXpathLibrary(libraryName);		
	}

	
	public void waitForCondition(String script, String timeout) {
		getCurrent().waitForCondition(script, timeout);		
	}

	
	public void waitForFrameToLoad(String frameAddress, String timeout) {
		getCurrent().waitForFrameToLoad(frameAddress, timeout);
	}

	
	public void waitForPageToLoad(String timeout) {
		getCurrent().waitForPageToLoad(timeout);
	}

	
	public void waitForPopUp(String windowID, String timeout) {
		getCurrent().waitForPopUp(windowID, timeout);
	}

	
	public void windowFocus() {
		getCurrent().windowFocus();
	}

	
	public void windowMaximize() {
		getCurrent().windowMaximize();
	}

	
	public void stop() {
		Selenium selenium = getCurrent();
		selenium.close();
		selenium.stop();
		_selenium.remove();	
	}

	
	public void addCustomRequestHeader(String arg0, String arg1) {
		getCurrent().addCustomRequestHeader(arg0, arg1);
	}

	
	public String captureNetworkTraffic(String arg0) {
		return getCurrent().captureNetworkTraffic(arg0);
	}

	
	public void deselectPopUp() {
		getCurrent().deselectPopUp();
	}

	
	public void selectPopUp(String arg0) {
		getCurrent().selectPopUp(arg0);
	}

	public void verifyEquals(Object obj1, Object obj2){
		if(obj1 == obj2)return;
		
		if( obj1!=null && obj2!=null && (obj1 instanceof Number) && (obj2 instanceof Number)){
			super.verifyEquals(""+obj1, ""+obj2);
		} else super.verifyEquals(obj1, obj2);
	}
	
	/**
	 * 
	 * @param comparator an image comparator.
	 */
	public void verifyImage(Comparator comparator) {
		ZKSelenium zkSelenium = (ZKSelenium) getCurrent();
        String browserName = zkSelenium.getBrowserName();
        ConfigHelper configHelper = ConfigHelper.getInstance();
        String resultDirStr = configHelper.getImageDest() + File.separator +  format.format(new java.util.Date());
        String baseDirStr = configHelper.getImageSrc();
        
        if (resultDirStr == null || resultDirStr.isEmpty() ||
            baseDirStr == null || baseDirStr.isEmpty()) {
            verifyTrue("Incorrect setting of images' outputing path. Please check config.properties.", false);
            return;
        }
        
        try {
            File resultDir = new File(resultDirStr);
            File baseDir = new File(baseDirStr);
            
            if (!baseDir.exists()) {
                baseDir.mkdir();
            }
            
            if (!resultDir.exists()) {
                resultDir.mkdir();
            }

            String title = this.getEval("document.title");
            byte[] imgByteArr = Base64.decode(zkSelenium.getCmdProcessor().getString("captureEntirePageScreenshotToString", new String[] {title, browserName}));
            BufferedImage testBuffImg = ImageIO.read(new ByteArrayInputStream(imgByteArr));
            
            if (configHelper.isComparable()) {
                BufferedImage baseBuffImg = ImageIO.read(new File(baseDir, caseID + "_" + browserName + ".png"));
                if (baseBuffImg.getWidth() != testBuffImg.getWidth() || baseBuffImg.getHeight() != testBuffImg.getHeight()) {
                	String f = resultDirStr + "/" + caseID + "_" + browserName + "_result.png";
                	ImageIO.write(testBuffImg, "png", new File(f));
                	super.verifyTrue("The size of images are not the same. Please check result. - " + f, false);
                	return;
                }
                Comparator ic = comparator == null ? new DefaultComparator(baseBuffImg.getWidth()/configHelper.getGranularity(),
                		baseBuffImg.getHeight()/configHelper.getGranularity(), configHelper.getLeniency()):
                    						comparator;
                BufferedImage imgc = ic.compare(baseBuffImg, testBuffImg);
                if (imgc != null) {
                	String f = resultDirStr + "/" + caseID + "_" + browserName + "_result.png";
                	ImageIO.write(imgc, "png", new File(f));
                    super.verifyTrue("Images are mismatch. Please check result. - " + f, false);
                } else {
                	File f = new File(resultDirStr + "/" + caseID + "_" + browserName + "_result.png");
                	if (f.isFile()) {
                		f.delete();
                	}
                }
            } else {
                ImageIO.write(testBuffImg, "png", new File(baseDir, caseID + "_" + browserName + ".png"));
            }
        } catch (Exception e) {
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	PrintStream ps = new PrintStream(baos);
        	e.printStackTrace(ps);
            super.fail(baos.toString());
        }
	}
	/**
	 * Compares the snapshot of the testing result.
	 * It is decided by the config.properties <i>comparable</i>.
	 * <p> If true, it will load base image from the specified path, and compare
	 * the current screen shot of the testing result. Otherwise, it just captures
	 * the current screen shot and put into the base image path.
	 * <p> The default comparator is to use {@link Defaultcomparator}. You can
	 * also use {@link #verifyImage(Comparator)} to specify your own comparator.
	 * @see DefaultComparator
	 */
	public void verifyImage() {
		verifyImage(null);
	}

	public String getLog() {
		return getCurrent().getLog();
	}

	public void open(String url, String ignoreResponseCode) {
		getCurrent().open(url, ignoreResponseCode);
	}

	public Number getCssCount(String css) {
		return getCurrent().getCssCount(css);
	}
}
