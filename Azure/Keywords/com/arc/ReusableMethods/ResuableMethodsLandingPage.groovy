package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class ResuableMethodsLandingPage extends BaseClass {
	ReusableMethodsNavigation landingPage =new ReusableMethodsNavigation()

	@Keyword
	public void invalidIDLoginTest() throws IOException, InterruptedException {
		/*******Verify invalid ID not able to log-in*************************/
		//landingPage.ArcLogoNavigation()
		//WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/ClickingLoginDrop'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'),'invalidUser@gamil.com' )
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), 'password')
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(6)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String errortext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/ErrorMessageSorry'))
		String errortextUI= errortext.replaceAll("\\s+","")
		WebUI.verifyMatch(errortextUI,'ErrormessageSorry,unrecognizedusernameorpassword.', false)
	}

	@Keyword
	public void hyperlinksCookiePolicy() throws IOException, InterruptedException {
		/*******Check hyperlinks  in Login module for 'cookie policy' clicking on the hyperlinks should redirect to correct webpage.*************************/
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_Cookie Statement'))
		WebUI.delay(6)
		WebUI.switchToWindowIndex(1)
		String cookiepolicyPage = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/CookiePolicyPage'))
		WebUI.verifyMatch(cookiepolicyPage,'This is the Cookie Policy for Arc, accessible from http://arcskoru.com', false)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/RedirectPrdPage'))
		WebUI.delay(6)
		WebUI.switchToWindowIndex(2)
		WebUI.verifyTextPresent('Your World is Alive!', true)
		WebUI.closeWindowIndex(2)
		WebUI.closeWindowIndex(1)


		/*******Check hyperlinks for 'cookie policy' inside banner clicking on the hyperlinks should redirect to correct webpage.*************************/
		WebUI.switchToWindowIndex(0)
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/DashboardPage/Banner_Cookie Statement'),2)
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Banner_Cookie Statement'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		String cookiepolicyBanner = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/CookiePolicyPage'))
		WebUI.verifyMatch(cookiepolicyBanner,'This is the Cookie Policy for Arc, accessible from http://arcskoru.com', false)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/RedirectPrdPage'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(2)
		WebUI.verifyTextPresent('Your World is Alive!', true)
		WebUI.closeWindowIndex(2)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}

	@Keyword
	public void hyperlinksPrivacypolicy() throws IOException, InterruptedException {
		/*******Check hyper links  in Login module for 'privacy policy' clicking on the hyperlinks should redirect to correct web-page.*************************/
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_Privacy Statement'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		String privicyPage = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/Privacy Notice'))
		WebUI.verifyMatch(privicyPage,'Privacy Notice', false)

		/*WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/PRDPrivicy'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(2)
		 WebUI.verifyTextPresent('Your World is Alive!', true)
		 WebUI.closeWindowIndex(2)
		 */	WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}

	@Keyword
	public void hyperlinksTermsofuse() throws IOException, InterruptedException {
		/*******Check Hyper links  in Login module for 'privacy policy' clicking on the hyperlinks should redirect to correct web-page.*************************/
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_Terms of Use'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		String termsofuse = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/Legalconditions'))
		WebUI.verifyMatch(termsofuse,'Legal terms and conditions', false)

		/*		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/DashboardPage/termsarcskoru'),5)
		 WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/termsarcskoru'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(2)
		 WebUI.verifyTextPresent('Your World is Alive!', true)
		 WebUI.closeWindowIndex(2)*/
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}
	@Keyword
	public void setaccountPref() throws IOException, InterruptedException {
		/*****Verify 'User account' -->preferences , user is able to turn on/off the toggle and the functionality works fine for 'Receive email when new score version is available'****/
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/b_caret'), 4)
		WebUI.click(findTestObject('Page_Arc dashboard/b_caret'))
		WebUI.delay(1)

		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/Account/a_ Preferences'),4)
		WebUI.click(findTestObject('Page_Arc dashboard/Account/a_ Preferences'))
		WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/Account/accountPref'), 4)
		WebUI.click(findTestObject('Page_Arc dashboard/Account/accountPref'))

		String popuptext = WebUI.getText(findTestObject('Page_Arc dashboard/Account/ValidationPopup'))
		WebUI.verifyMatch(popuptext,'Receive email when new score version is available', false)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/Account/CloseAccountPrefPopup'))
		WebUI.delay(5)
	}




	@Keyword
	public void hyperlinksEndUser() throws IOException, InterruptedException {
		/*******Check hyperlinks  in Login module for End User License Agreement.  clicking on the hyperlinks should redirect to correct web-page.*************************/
		//landingPage.ArcLogoNavigation()
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_End User License Agreement'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		String termsofuse = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/End User License Agreement'))
		WebUI.verifyMatch(termsofuse,'End User License Agreement', false)

		/*	WebUI.scrollToElement(findTestObject('Page_Arc dashboard/DashboardPage/End_Arc Privacy Notice'),10)
		 WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/End_Arc Privacy Notice'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(2)
		 //String Logintext = WebUI.getText(findTestObject('Page_Home  Arc/Click_Log in'))
		 WebUI.verifyTextPresent('Your World is Alive!', true)
		 WebUI.closeWindowIndex(2)
		 */	WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}
	@Keyword
	public void sidebarcollapsing() throws IOException, InterruptedException {
		/*******Verify if side bar collapsing .*************************/
		WebUI.delay(1)
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/DashboardPage/SideCollpsingBar'), 10)
		WebUI.delay(5)
		WebUI.verifyElementClickable(findTestObject('Page_Arc dashboard/DashboardPage/SideCollpsingBar'))
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/SideCollpsingBar'))
		WebUI.delay(2)
	}
	@Keyword
	public void verifyIaccepttheEULATest() throws IOException, InterruptedException {
		/*******Verify checkbox functionality for 'I accept the EULA' at the login window should give error message if left unchecked.*************************/
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'),'invalidUser@gamil.com' )
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), 'password')
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String errortext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage//IAcceptValidationText'))
		WebUI.verifyMatch(errortext,'Please read through and accept our aforementioned Privacy Documents and Terms to be able to proceed to your account. For any questions, you may write to us at info@usgbc.org', false)
	}

	@Keyword
	public void verifyMyAccountNavigation() throws IOException, InterruptedException {
		/*******Verify My Account Navigate to correct page *************************/
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/b_caret'), 4)
		WebUI.click(findTestObject('Page_Arc dashboard/b_caret'))
		WebUI.delay(1)
		WebUI.scrollToElement(findTestObject('Page_Arc dashboard/DashboardPage/a_ My Account'), 2)
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_ My Account'))
		WebUI.delay(6)
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String Logintext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/ARCs account'))
		WebUI.verifyMatch(Logintext,'Manage your projects and register new projects on LEED Online.', false)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}
	@Keyword
	public void verifyAddProjectButton() {
		/**********Project Details : Verify Add project is available on project dashboard*******************/
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		String addButton = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(1)
		WebUI.verifyMatch(addButton,'+ Add',false)
	}
	@Keyword
	public void projectRegistrationPage() {
		/**********Verify if Project Registration page is open when add project is clicked on *******************/
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		String projectRegistration = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/AllProject/ProjectRegistrationARC'))
		WebUI.delay(1)
		WebUI.verifyMatch(projectRegistration,'Project Registration',false)
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(7)
	}

	@Keyword
	public void buildingLEEDPage() {
		/**********Verify if project type selected is  'Building LEED', a pop up to redirect to LEED ONLINE appears. Verify if redirect button works as expected.*******************/
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(5)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'),'Buildings', true)
		WebUI.delay(2)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), 'LEED', true)
		WebUI.delay(4)
		WebUI.click(findTestObject("Page_Arc dashboard/DashboardPage/GotoLEEDOnline"))
		WebUI.switchToWindowIndex(1)
		WebUI.delay(10)
		String projectRegistration = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/AllProject/Project Registration'))
		WebUI.delay(1)
		WebUI.verifyMatch(projectRegistration,'Project Registration',false)
		WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
		WebUI.delay(1)
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(7)
	}

	@Keyword
	public void verifyProjectRegFieldDetails() {
		/**********Verify if Project Details page includes following fields Project Name , Unit Type, Space type , Owner Org , Owner email , Owner country ,area, address,city , country , state ,zipcode , geo-location , check box for service agreement , skip,next .*******************/
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), 'Buildings', true)
		WebUI.delay(2)

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Unit Type'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Type'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Owner Type'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Owner Organization (Clic'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Owner Email'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Owner CountryRegion'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Area'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Address'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_City'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_CountryRegion'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_State'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Zip Code'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Geo location (Optional)'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_I agree to the terms and'))

		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/button_Skip'))

		WebUI.verifyElementVisible(findTestObject('Add_Project_Details/button_Next'))

		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(7)
	}

	@Keyword
	public verifyValidationAndToolTip() {
		/**********Verify the radio buttons for the Units & tool tip text .*******************/
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ToolTip'))
		WebUI.delay(1)
		String toolTipText = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ToolTipText'))
		String toolTipText1= toolTipText.replaceAll("\\s+","")
		WebUI.verifyMatch(toolTipText1,'IPunits=inchesandpoundsSIunits=metresandkilograms', false)
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(7)
	}
	@Keyword
	public verifyValidationSpecialCharacter() {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(1)

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '& + / :  , - . #')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementNotPresent(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'),2)

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '!')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '@')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '$')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '%')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '^')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '*')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '(')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))

		WebUI.clearText(findTestObject('Object Repository/Add_Project_Details/input_name'))
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), '?')
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/Reg/label_Project Name'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Page_Arc dashboard/DashboardPage/Reg/ErrorMessageSpecialcharacters'))
	}

	@Keyword
	public verifyDashboadAllProjectDetail() {
		WebUI.delay(8)
		WebDriver driver  = DriverFactory.getWebDriver()
		WebUI.scrollToPosition(0,1000)
		WebUI.delay(10)

		ArrayList numberofProject = driver.findElements(By.xpath("//td[@class='vertical-align-middle cursor-pointer']/span[@class='ng-binding']"))
		int projectID = numberofProject.size()
		println projectID
		if(projectID>=30)
			println "Dashborad have all the Projects with the PorjectId and belwo are the  xpath for project ID"
		else
			Assert.fail("Dashborad have less than 30 with the below projects ID xpath ")
		Iterator iterator = numberofProject.iterator()
		while (iterator.hasNext()) {
			String projectid = iterator.next()
			println projectid
		}

		ArrayList numberofProjectName = driver.findElements(By.xpath("//span[@class = 'fw-semi-bold ng-binding']"))
		int numberOfCountSizeName = numberofProjectName.size()
		println numberOfCountSizeName
		if(numberOfCountSizeName>=30)
			println "Dashborad have all Project name with below xpath"
		else
			Assert.fail("Dashborad have less than 30  with the below projects Name xpath ")
		Iterator iteratorname = numberofProjectName.iterator()
		while (iteratorname.hasNext()) {
			String projectName = iteratorname.next()
			println projectName
		}

		ArrayList numberofProjectstatusReg = driver.findElements(By.xpath("//*[(text() = 'Registered' or . = 'Registered')]"))
		int numberofProjectstatusreg = numberofProjectstatusReg.size()
		println numberofProjectstatusreg
		if(numberofProjectstatusreg>=30)
			println "Dashborad have all the project with registered status with below xpath"
		else
			Assert.fail("Dashborad have less then 30 projects")
		Iterator iteratornamestatusReg = numberofProjectstatusreg.iterator()
		while (iteratornamestatusReg.hasNext()) {
			String projectNamestaus = iteratornamestatusReg.next()
			println projectNamestaus
		}

		ArrayList numberofProjectscore = driver.findElements(By.xpath("//*[@class = 'smallScorepuckBlank ng-scope']"))
		int numberofProjectScore = numberofProjectscore.size()
		println numberofProjectScore
		if(numberofProjectScore>=30)
			println "Dashborad have all projects score with below xpath "
		else
			Assert.fail("Dashborad have less then 30 project with Score xpath")
		Iterator numberofprojectScore = numberofProjectscore.iterator()
		while (numberofprojectScore.hasNext()) {
			String projectScore = numberofprojectScore.next()
			println projectScore
		}
	}

	@Keyword
	public void submitFeedback(String sheetName , int rowNum) {
		/**********Project Details : Verify Add project is available on project dashboard*******************/
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/happy'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/okay'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/unhappy'))
		WebUI.delay(2)

		WebUI.setText(findTestObject('Page_Arc dashboard/Feedback/ProjectId'),projectId)
		WebUI.setText(findTestObject('Page_Arc dashboard/Feedback/textarea_feedback'),"submiting the survery feedback")
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/Submit'))

		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Feedback/span_Feedback Sent'),10)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)
	}

	@Keyword
	public void feedbackValidation(String sheetName , int rowNum) {
		/**********Verify project id should be filled by default and display based on selection of project*******************/
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)

		String userId =  WebUI.getAttribute(findTestObject('Page_Arc dashboard/Feedback/UserName'),'value')
		WebUI.verifyMatch(GlobalVariable.teamMemName,userId, false)

		String projectid = WebUI.getAttribute(findTestObject('Page_Arc dashboard/Feedback/ProjectId'),'value')
		WebUI.verifyMatch(projectId, projectid, false)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)
	}

	@Keyword
	public void feedbackBlankFieldTest(String sheetName , int rowNum) {
		/**********Verify project id should be filled by default and display based on selection of project*******************/
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)

		WebUI.setText(findTestObject('Page_Arc dashboard/Feedback/ProjectId'),projectId)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/Submit'))

		WebUI.delay(10)
		/************Verifying the blank value in the feedback *********************************************/
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Feedback/span_Error Sending Feedback'),10)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)
	}

	@Keyword
	public void feedbacInformativeFieldTest(String sheetName , int rowNum) {
		/**********Verify project id should be filled by default and display based on selection of project*******************/
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))

		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/happy'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/IinfoOkay'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/InfoUnhappy'))

		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/WellHappy'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/okay'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/Wellunhappy'))

		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/PerformanceHappy'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/PerformanceOkay'))
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/unhappy'))

		WebUI.setText(findTestObject('Page_Arc dashboard/Feedback/ProjectId'),projectId)
		WebUI.setText(findTestObject('Page_Arc dashboard/Feedback/textarea_feedback'),"submiting the survery feedback")
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/Submit'))

		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Feedback/span_Feedback Sent'),10)
		WebUI.click(findTestObject('Page_Arc dashboard/Feedback/FeedBackButton'))
		WebUI.delay(2)
	}
}
