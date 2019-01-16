package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ReusableMethodsNavigation {

	@Keyword
	public void navigateToBuilding() {
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ Buildings'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ My Buildings'))
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/span_My Buildings'))
		WebUI.verifyMatch(postNavigationLoginText,'My Buildings',true)
	}
	@Keyword
	public void clickAddProject() {
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/Add_Project_Details/button_ Add'), 3)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(2)
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/h1_Project Registration'))
		WebUI.verifyMatch(postNavigationLoginText,'Project Registration',true)
	}
	@Keyword
	public void navigateToCities(){
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ My Cities'))
		WebUI.delay(3)
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/span_My Cities'))
		WebUI.verifyMatch(postNavigationLoginText,'My Cities',false)
	}

	@Keyword
	public void navigateToCommunities(){
		WebUI.delay(3)
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ My Communities'))
		WebUI.delay(3)
		String postNavigationLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Communities'))
		WebUI.verifyMatch(postNavigationLoginText,'My Communities',false)
	}

	@Keyword
	public void navigateToParking(){
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ Buildings'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Page_Arc dashboard/a_ My Parking'))
		WebUI.delay(4)
		String postNavigationLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Parking'))
		WebUI.verifyMatch(postNavigationLoginText,'My Parking',false)
	}
	@Keyword
	public void navigateToPortfolio(){
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ Buildings'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ My Portfolios'))
		WebUI.click(findTestObject('Portfolio/Common/span_My Portfolios'))
		WebUI.delay(4)
		String postNavigationLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Portfolios'))
		WebUI.verifyMatch(postNavigationLoginText,'My Portfolios',false)
	}

	@Keyword
	public void navigateToBuildingTransit() {
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ Buildings'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ My Transit'))
		//WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/i_fa fa-bars fa-lg'))

		print "Making Slider On"
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/span_My Transit'))
		WebUI.verifyMatch(postNavigationLoginText,'My Transit',true)
		WebUI.delay(5)
	}

	@Keyword
	public void navigateToTransitDataInput(){
		//WebUI.setViewPortSize(1500,800)
		WebUI.delay(3)
		/*WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))

	}

	@Keyword
	public void navigateToDataTransport(){
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(6)
	}
	@Keyword
	public void navigateToDataAQI(){

		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_Air Quality Index'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}
	@Keyword
	public void navigateToDataCO(){

		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_Carbon Monoxide'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}

	@Keyword
	public void navigateToDataND(){
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_Nitrogen Dioxide'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}
	@Keyword
	public void navigateToDataOS(){
		WebUI.delay(2)
		WebUI.click(findTestObject('Analytics/Gra/td_Occupant Satisfaction Surve'))
		WebUI.delay(8)
	}
	@Keyword
	public void navigateToDataOzone(){
		WebUI.delay(3)
		WebUI.click(findTestObject('Analytics/Gra/td_Ozone'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(8)
	}
	@Keyword
	public void navigateToDataPM10(){
		WebUI.delay(2)
		WebUI.click(findTestObject('Analytics/Gra/td_PM10'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}
	@Keyword
	public void navigateToDataPM25(){
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_PM2.5'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}
	@Keyword
	public void navigateToDataRid(){
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_Ridership'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}

	@Keyword
	public void navigateToDataSD(){
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Gra/td_Sulfur Dioxide'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Analytics/Gra/span_Details'))
		WebUI.delay(6)
	}



	@Keyword
	public void ArcLogoNavigation() throws IOException, InterruptedException {
		/*******Verify clicking on the ARC LOGO takes you back to the ARC log-in page *************************/
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_appLogo'))
		WebUI.delay(15)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String Logintext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_About'))
		WebUI.verifyMatch(Logintext,'ABOUT', false)
	}
	@Keyword
	public void ArclogoNavigation() throws IOException, InterruptedException {
		/*******Verify clicking on the ARC LOGO takes you back to the ARC log-in page *************************/
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/a_appLogo'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.verifyTextPresent('Welcome', true)
		/*	String Logintext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/Reg/Log inLanding'))
		 WebUI.verifyMatch(Logintext,'LOG IN',, false)
		 */
	}

	@Keyword
	public void navigateToManageSection(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.delay(2)
	}


	@Keyword
	public void navigateToAnalyticsTotal() {
		/*WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))*/
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)
	}

	@Keyword
	public void navigateCreditAction(){
		/***Verify clicking on Credit/Actions shows All Actions , Prerequisites , Base Points , Data Inputs , My Actions and collapses to close the details**/

		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'))
		String allAction = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/AllActions'))
		WebUI.verifyMatch(allAction,'All Actions',, false)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ Prerequisites'))
		WebUI.delay(5)
		String Logintext = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/h1_Prerequisites'))
		WebUI.verifyMatch(Logintext,'Prerequisites', false)

		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)
		String basePoint = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/h1_Base Points'))
		WebUI.verifyMatch(basePoint,'Base Points', false)

		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(10)
		String dataInput = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/span_Meters  Surveys'))
		WebUI.verifyMatch(dataInput,'Meters & Surveys', false)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ My Actions'))
		WebUI.delay(5)
		String myAction = WebUI.getText(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/h1_My Actions'))
		WebUI.verifyMatch(myAction,'My Actions', false)
	}

	@Keyword
	public void navigateToAnalyticsEnergy() {
		//WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Nav/a_ Energy'))
		WebUI.delay(4)
		//WebUI.refresh()
		//WebUI.delay(15)
	}
	@Keyword
	public void navigateToAnalyticsWater() {
		//WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Analytics/Nav/a_ Water'))
		WebUI.delay(4)
		//WebUI.refresh()
		//WebUI.delay(15)
	}

	@Keyword
	public void navigateToAnalyticsWaste() {
		//WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Nav/a_ Waste'))
		WebUI.delay(4)
		//WebUI.refresh()
		//WebUI.delay(15)
	}

	@Keyword
	public void navigateToAnalyticstransport() {
		WebUI.delay(1)
		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Nav/a_ Transportation'))
		WebUI.delay(5)
		//WebUI.refresh()
		//WebUI.delay(15)
	}
	@Keyword
	public void navigateToAnalyticsHumExp() {
		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Analytics/Nav/a_ Human Experience'))
		WebUI.delay(5)
		//WebUI.refresh()
		//WebUI.delay(15)
	}


	@Keyword
	public void clickOnSidebar(String suitId){
		if((suitId.contains("Cities")) || (suitId.contains("Com")) ){

			WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions'), FailureHandling.OPTIONAL)
			if((WebUI.getAttribute(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){

				println "credit action "
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions'))
			}
			if((WebUI.getAttribute(findTestObject('Object Repository/PerformanceScore/Score/a_ Score1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){
				println "Scores"
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
			}
			if((WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/a_ Manage1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){
				println "Manage"
				WebUI.delay(2)
				WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
			}
		}


		else if((suitId.contains("BuildingNone")) || (suitId.contains("BuildingOther")) || (suitId.contains("Transit")) ) {
			WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions'), FailureHandling.OPTIONAL)
			if((WebUI.getAttribute(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){
				println "credit action "
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions'))
			}
			if((WebUI.getAttribute(findTestObject('Object Repository/PerformanceScore/Score/a_ Score1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){

				println "Scores"
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
			}

			if((WebUI.getAttribute(findTestObject('Object Repository/Analytics/ClickOnAnalytics1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){
				println "Analytics"
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
			}


			if((WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/a_ Manage1'), "aria-expanded", FailureHandling.OPTIONAL).equals("false"))){

				println "Manage"
				WebUI.delay(2)
				WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
			}
		}
	}
}
