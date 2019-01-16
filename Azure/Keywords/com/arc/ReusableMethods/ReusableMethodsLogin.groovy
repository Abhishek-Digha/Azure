package com.arc.ReusableMethods
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.sql.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ReusableMethodsLogin extends BaseClass{
	Robot robot = new Robot()
	String download
	@Keyword
	public void LoginToArcWithRemoteDBMySQL() {
		Class.forName("com.mysql.cj.jdbc.Driver")
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ArcTestData", "root", "")
		java.sql.Statement stmt = connection.createStatement()
		java.sql.ResultSet relsultSet = stmt.executeQuery("Select Url ,UserName , Password from LoginToArc where Env='stg'" )
		while(relsultSet.next()) {
			Object url = relsultSet.getObject('Url')
			println(url)
			Object userName = relsultSet.getObject('UserName')
			println(userName)
			Object password = relsultSet.getObject('Password')
			println(password)
			WebUI.openBrowser(url)
			WebUI.maximizeWindow()
			WebUI.waitForPageLoad(GlobalVariable.timeOut)
			WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
			WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
			WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
			WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
			WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
			WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
			WebUI.delay(5)
		}
	}

	@Keyword
	public void loginIntoArcApplication(String Username,String Password) {
		/*
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_T);
		 r.keyRelease(KeyEvent.VK_CONTROL)
		 r.keyRelease(KeyEvent.VK_T)
		 WebUI.delay(4)
		 //To switch to the new tab
		 WebUI.switchToWindowIndex(1)
		 WebUI.delay(2)
		 WebUI.navigateToUrl(applicationUrl)
		 WebUI.delay(10)
		 WebUI.waitForPageLoad(GlobalVariable.timeOut) 
		 //WebUI.click(findTestObject('Object Repository/Page_Home  Arc/ClickNavLogOut'))
		 //WebUI.click(findTestObject('Object Repository/Page_Home  Arc/LoginArrowDropDown'))
		 */	
		//WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(10)
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'), Username)
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), Password)
		WebUI.delay(2)
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'), 10)
		WebUI.click(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'))
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'), 30)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(3)
	}

	@Keyword
	public void loginIntoArcWithGlobalVariable() {
		String url = GlobalVariable.url
		String userName= GlobalVariable.userName
		String password= GlobalVariable.password
		WebUI.openBrowser('')
		//WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.navigateToUrl(url)
		waitForPageLoad(60)

		WebUI.setText(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/input__name'), userName)

		WebUI.setText(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/input__pass'), password)

		WebUI.click(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/input_Forgot Password_field_po'))

		WebUI.click(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/button_ACCEPT AND CLOSE'))

		WebUI.click(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/button_Log in'))
		//WebUI.waitForPageLoad(10)
		//WebUI.delay(10)
		WebUI.setViewPortSize(1366,1280)
		waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/Page_Home  Arc/WelcomeArcText'))
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'), 30)
		WebUI.click(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/span_Projects'))

		/*WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
		 WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
		 WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
		 WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		 WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		 WebUI.delay(5)
		 //WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'), 30)
		 WebUI.click(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'))*/
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'), 30)
		waitForloaderToDisappear(60)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		/*if((System.getProperty('os.name')).contains("Windows") || (System.getProperty('os.name')).contains("Linux") ){
		 robot.keyPress(KeyEvent.VK_CONTROL)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyRelease(KeyEvent.VK_MINUS)
		 robot.keyRelease(KeyEvent.VK_CONTROL)
		 }
		 else{
		 robot.keyPress(KeyEvent.VK_META)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyPress(KeyEvent.VK_MINUS)
		 robot.keyRelease(KeyEvent.VK_MINUS)
		 robot.keyRelease(KeyEvent.VK_META)
		 }*/
		WebUI.delay(3)
	}

	@Keyword
	public void loginArcGlobalVariable() {
		String url = GlobalVariable.url
		String userName= GlobalVariable.userName
		String password= GlobalVariable.password
		//WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'), 30)
		WebUI.click(findTestObject('Object Repository/Page_Home  Arc/ClickNavProjectText'))
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'), 30)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(3)
	}



	@Keyword
	public void loginIntoArcWithGlobalVariableAppUrl() {
		String url = GlobalVariable.url
		String userName= GlobalVariable.userName
		String password= GlobalVariable.password
		String appUrl = GlobalVariable.appUrl
		//DriverFactory.getGeckoDriverPath()
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize()
		print screenSize.getHeight()
		print screenSize.getWidth()
		Dimension size = new Dimension(1500, 1068)
		WebUI.openBrowser(appUrl)
		WebUI.getViewportHeight()
		WebUI.getViewportWidth()
		WebUI.getViewportLeftPosition()
		WebUI.getViewportTopPosition()
		//WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		//DriverFactory.getWebDriver().manage().window().setSize(size)
		WebUI.setViewPortSize(1366,1280)
		//DriverFactory.getWebDriver().manage().window().maximize()
		WebUI.getViewportHeight()
		WebUI.getViewportWidth()
		WebUI.getViewportLeftPosition()
		WebUI.getViewportTopPosition()
		WebUI.click(findTestObject('Object Repository/LoginViaAppUrl/CookieACCEPTANDCLOSE'))
		WebUI.setText(findTestObject('Object Repository/LoginViaAppUrl/UserName'), userName)
		WebUI.setText(findTestObject('Object Repository/LoginViaAppUrl/UserPassword'), password)
		WebUI.click(findTestObject('Object Repository/LoginViaAppUrl/AcceptAgreement'))
		WebUI.click(findTestObject('Object Repository/LoginViaAppUrl/ClickLOGIN'))
		WebUI.delay(5)
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'), 30)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		if((System.getProperty('os.name')).contains("Windows") || (System.getProperty('os.name')).contains("Linux") ){

			robot.keyPress(KeyEvent.VK_CONTROL)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyRelease(KeyEvent.VK_MINUS)
			robot.keyRelease(KeyEvent.VK_CONTROL)
		}
		else{
			robot.keyPress(KeyEvent.VK_META)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyPress(KeyEvent.VK_MINUS)
			robot.keyRelease(KeyEvent.VK_MINUS)
			robot.keyRelease(KeyEvent.VK_META)
		}
		WebUI.delay(3)
	}



	@Keyword
	public void loginArcAdminToolWithGlobalVariable() {
		WebUI.delay(2)
		String url = GlobalVariable.adminUrl
		String userName= GlobalVariable.adminUserName
		String password= GlobalVariable.adminPassword
		//WebDriver driver  = DriverFactory.getWebDriver()

		Robot r = new Robot()
		//((JavascriptExecutor)driver).executeScript('window.open("");')
		//WebUI.delay(2)
		//WebUI.switchToWindowIndex(1)
		r.keyPress(KeyEvent.VK_CONTROL)
		r.keyPress(KeyEvent.VK_T)
		r.keyRelease(KeyEvent.VK_CONTROL)
		r.keyRelease(KeyEvent.VK_T)
		WebUI.delay(4)

		//To switch to the new tab
		WebUI.switchToWindowIndex(1)
		WebUI.delay(2)
		WebUI.navigateToUrl(url)
		//WebUI.waitForPageLoad(GlobalVariable.timeOut)
		//WebUI.delay(10)
		//waitForPageLoad(60)
		WebUI.delay(12)
		WebUI.setText(findTestObject('PerformanceScore/Username'), userName)
		WebUI.setText(findTestObject('PerformanceScore/Password'), password)
		WebUI.check(findTestObject('PerformanceScore/AcceptCheckbox'))
		WebUI.delay(4)
		WebUI.check(findTestObject('PerformanceScore/AcceptCheckbox'))
		WebUI.click(findTestObject('PerformanceScore/LOG IN'), FailureHandling.CONTINUE_ON_FAILURE)
		//waitForPageLoad(60)
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.waitForElementPresent(findTestObject('PerformanceScore/VerifyTextTeam'), 30)
		//waitForloaderToDisappear(60)
		 WebUI.delay(15)
		String postLoginText = WebUI.getText(findTestObject('PerformanceScore/VerifyTextTeam'))
		WebUI.verifyMatch(postLoginText,'Team',false)
		WebUI.delay(3)

	}
	@Keyword
	public void loginIntoArcWithExcelData() {
		/*** Please change/select row number 1 Stg & 2 Qas, 3 Dev , 4 Prd **********/

		TestData excelData = findTestData('Test Data')
		int row = 2
		String url = excelData.getValue('ArcURL' , row)
		WebUI.openBrowser(url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
		WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'),excelData.getValue('UserName', row))
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), excelData.getValue('Password', row))
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(2)
	}

	@Keyword
	public void logoutFromArcApplication() {
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/b_caret'), 4)
		WebUI.click(findTestObject('Page_Arc dashboard/b_caret'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/logout'), 2)
		WebUI.click(findTestObject('Page_Arc dashboard/logout'))
		WebUI.delay(10)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
	}

	@Keyword
	public void loginWithValidId() {
		String userName= GlobalVariable.userName
		String password= GlobalVariable.password
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
		//	WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/span_Projects'))
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'),30)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(10)
	}
	@Keyword
	public void loginWithBlankValue() {
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		WebUI.waitForElementPresent(findTestObject('Page_Arc dashboard/span_My Projects'), 30)
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.verifyTextPresent('User id is required', true)
		WebUI.verifyTextPresent('Password is required', true)
	}


	public static void waitForPageToLoadCompletely(int timeout){
		// KatalonWebDriverBackedSelenium.WAIT_FOR_PAGE_TO_LOAD_IN_SECONDS

		// wait some number of seconds for page to load
		println 'wait'
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver, timeout)
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"loading\";"))
		//wait.until(((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete"))
		//wait.until(ExpectedConditions.((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"))
		JavascriptExecutor js = (JavascriptExecutor) driver
		println js.executeScript("return document.readyState").toString()
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"))
		WebUI.delay(3)
	}

	public static void waitForPageLoad(int timeout){
		// KatalonWebDriverBackedSelenium.WAIT_FOR_PAGE_TO_LOAD_IN_SECONDS
		//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Arc dashboard/LoaderMainPage'), 60, FailureHandling.CONTINUE_ON_FAILURE)

		// wait some number of seconds for page to load
		println 'wait'
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver, timeout)
		//wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"loading\";"))
		//wait.until(((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete"))
		//wait.until(ExpectedConditions.((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"))
		JavascriptExecutor js = (JavascriptExecutor) driver
		println js.executeScript("return document.readyState").toString()

		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"))
		//println js.executeScript("return jQuery('.pace.pace-active').length").toString().equals("1")
		//println js.executeScript("return jQuery('.pace.pace-active').length").toString()

	}


	public static void waitForloaderToDisappear(int timeout){
		println getCurrentTimeUsingDate()
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver, timeout)
		JavascriptExecutor js = (JavascriptExecutor) driver
		WebUI.delay(4)
		//wait.until(ExpectedConditions.jsReturnsValue("return jQuery('.pace.pace-active').length==1;"))
		println getCurrentTimeUsingDate()
		wait.until(ExpectedConditions.jsReturnsValue("return jQuery('.pace.pace-inactive').length==1;"))
		println getCurrentTimeUsingDate()
		//println js.executeScript("return jQuery('.pace.pace-inactive').length").toString().equals("1")
		//println js.executeScript("return jQuery('.pace.pace-inactive').length").toString()

	}
	public static void waitForIframeLoad(int timeout){

		// wait some number of seconds for page to load
		WebDriver driver = DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver, timeout)
		wait.until(ExpectedConditions.jsReturnsValue("return jQuery('#datainput-widget').contents().context.readyState=='complete';"))
		WebUI.delay(3)

	}



	public static void getCurrentTimeUsingDate() {
		Date date = new Date()
		String strDateFormat = "hh:mm:ss a"
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat)
		String formattedDate= dateFormat.format(date)
		System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate)
	}

}
