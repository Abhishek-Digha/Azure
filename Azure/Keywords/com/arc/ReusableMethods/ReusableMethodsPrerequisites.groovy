package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ReusableMethodsPrerequisites extends BaseClass {

	@Keyword
	public void narrativeTextSave(String sheetName, int rowNum)throws IOException, InterruptedException {
		String preReqTexBox  = data.getCellData(sheetName, "PreReqTexBox", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)
		WebUI.doubleClick(findTestObject('Page_Arc dashboard/span_Project boundary'))
		WebUI.delay(3)

		for (int i = 0; i <= 4; i++) {
			if(i==0) {
				println "Verifying narrative Text Save functionality for Measure Project Boundary"
				WebUI.click(findTestObject('Page_Arc dashboard/textarea_measureProjectBoundary'))
				WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureProjectBoundary'),preReqTexBox)
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.delay(10)
				Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureProjectBoundary')).contains(preReqTexBox),"Not Valid")
			}
			if(i==1) {
				println "Verifying narrative Text Save functionality for Measure Governance"
				for(int count=1; count<=3;count++){
					WebUI.click(findTestObject('Page_Arc dashboard/textarea_measureGovernance'+count))
					WebUI.delay(1)
					WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureGovernance'+count),preReqTexBox)
					WebUI.delay(1)
				}
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.delay(10)
				for(int count=1; count<=3;count++){
					Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureGovernance'+count)).contains(preReqTexBox),"Not Valid")
				}
			}

			if(i==2) {
				println "Verifying narrative Text Save functionality for Measure Stakeholders"
				for(int count=1; count<=2;count++){
					WebUI.click(findTestObject('Page_Arc dashboard/textarea_measureStake'+count))
					WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureStake'+count),preReqTexBox)
				}
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.delay(10)
				for(int count=1; count<=2;count++){
					Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureStake'+count)).contains(preReqTexBox),"Not Valid")
				}
			}

			if(i==3) {
				println "Verifying narrative Text Save functionality for Measure Meeting"
				WebUI.click(findTestObject('Page_Arc dashboard/textarea_measureMeeting'))
				WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureMeeting'),preReqTexBox)
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.delay(10)
				Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureMeeting')).contains(preReqTexBox),"Not Valid")
			}

			if(i==4) {
				WebUI.click(findTestObject('Page_Arc dashboard/textarea_measureRoadmap'))
				//WebUI.clearText(findTestObject('Page_Arc dashboard/textarea_measureRoadmap'))
				WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureRoadmap'), preReqTexBox)
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.delay(10)
				Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureRoadmap')).contains(preReqTexBox),"Not Valid")
			}
			WebUI.delay(3)
			WebUI.scrollToElement(findTestObject('Page_Arc dashboard/button_Next'), 3)
			WebUI.click(findTestObject('Page_Arc dashboard/button_Next'))
			WebUI.delay(3)
		}
	}

	@Keyword
	public void preRequisiteAttemptCity(){
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/CityCom/span_Commit to sharing data'))
		WebUI.delay(3)
		for(int i=1;i<=6;i++) {
			WebUI.click(findTestObject('PreRequisite/CheckBox1'))
			WebUI.delay(3)
			WebUI.click(findTestObject('PreRequisite/button_Attempted'))
			WebUI.delay(2)
			WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
			WebUI.delay(3)
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
			WebUI.delay(3)
		}
	}
	@Keyword
	public void prevousNextButtonTransitPrereq() {

		WebUI.click(findTestObject('PreRequisite/a_ Prerequisites'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/span_Site Management Policy'))
		WebUI.delay(5)

		for(int count=0;count<=9;count++) {
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
			WebUI.delay(1)
		}
		WebUI.delay(2)
		String firstCredit = WebUI.getText(findTestObject('Page_Arc dashboard/Navigation/span_Site Management Policy'))
		WebUI.verifyMatch(firstCredit,'Site Management Policy', false)

		for(int count1=0;count1<=9;count1++) {
			WebUI.scrollToElement(findTestObject('/Page_Arc dashboard/Navigation/button_Previous'), 2)
			WebUI.click(findTestObject('/Page_Arc dashboard/Navigation/button_Previous'))
			WebUI.delay(1)
		}
		WebUI.delay(1)
		WebUI.verifyMatch(firstCredit,'Site Management Policy', false)
	}

	@Keyword
	public void prevousNextButtonTransitBasePoint() {
		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))
		WebUI.delay(5)

		for(int count=0;count<=9;count++) {
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
			WebUI.delay(1)
		}
		WebUI.delay(2)
		String firstCredit = WebUI.getText(findTestObject('Page_Arc dashboard/Navigation/span_Site Management Policy'))
		WebUI.verifyMatch(firstCredit,'Site Management Policy', false)


		for(int count1=0;count1<=9;count1++) {
			WebUI.scrollToElement(findTestObject('/Page_Arc dashboard/Navigation/button_Previous'), 2)
			WebUI.click(findTestObject('/Page_Arc dashboard/Navigation/button_Previous'))
			WebUI.delay(1)
		}
		WebUI.delay(1)
		WebUI.verifyMatch(firstCredit,'Site Management Policy', false)
	}

	@Keyword
	public void prevousNextCreditcreditNameTest() {
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/span_Site Management Policy'))
		WebUI.delay(3)
		for(int count=0;count<=32;) {

			if(count==0)
				WebUI.verifyTextPresent('Site Management Policy', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==1)
				WebUI.verifyTextPresent('Site Development - Protect or Restore Habitat', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==2)
				WebUI.verifyTextPresent('Rainwater Management', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==3)
				WebUI.verifyTextPresent('Heat Island Reduction', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==4)
				WebUI.verifyTextPresent('Light Pollution Reduction', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==5)
				WebUI.verifyTextPresent('Site Management', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==6)
				WebUI.verifyTextPresent('Site Improvement Plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==7)
				WebUI.verifyTextPresent('Indoor Water Use Reduction', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==8)
				WebUI.verifyTextPresent('Energy Efficiency Best Management Practices', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==9)
				WebUI.verifyTextPresent('Minimum Energy Performance', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==10)
				WebUI.verifyTextPresent('Fundamental Refrigerant Management', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==11)
				WebUI.verifyTextPresent('Enhanced Refrigerant Management', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==12)
				WebUI.verifyTextPresent('Ongoing Purchasing and Waste Policy', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==13)
				WebUI.verifyTextPresent('Facility Maintenance and Renovation Policy', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==14)
				WebUI.verifyTextPresent('Purchasing - ongoing', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==15)
				WebUI.verifyTextPresent('Purchasing - lamps', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==16)
				WebUI.verifyTextPresent('Purchasing - facility maintenance and renovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==17)
				WebUI.verifyTextPresent('Solid waste management - facility maintenance and renovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==18)
				WebUI.verifyTextPresent('Minimum Indoor Air Quality Performance', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==19)
				WebUI.verifyTextPresent('Environmental Tobacco Smoke Control', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==20)
				WebUI.verifyTextPresent('Green Cleaning Policy', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==21)
				WebUI.verifyTextPresent('Thermal Comfort', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==22)
				WebUI.verifyTextPresent('Interior Lighting', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==23)
				WebUI.verifyTextPresent('Daylight and Quality Views', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==24)
				WebUI.verifyTextPresent('Green Cleaning - Custodial Effectiveness Assessment', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==25)
				WebUI.verifyTextPresent('Green Cleaning - Products and Materials', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==26)
				WebUI.verifyTextPresent('Green Cleaning - Equipment', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==27)
				WebUI.verifyTextPresent('Integrated Pest Management', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==28)
				WebUI.verifyTextPresent('Innovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==29)
				WebUI.verifyTextPresent('Innovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==30)
				WebUI.verifyTextPresent('Innovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==31)
				WebUI.verifyTextPresent('Innovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==32)
				WebUI.verifyTextPresent('Innovation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			count++

			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'),2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
			WebUI.delay(2)
		}
	}

	@Keyword
	public void cityprevousNextCreditcreditNameTest() {
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CityCom/span_Commit to sharing data'))
		WebUI.delay(3)

		for(int count=0;count<=21;) {

			if(count==0)
				WebUI.verifyTextPresent('Commit to sharing data', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==1)
				WebUI.verifyTextPresent('Project boundary', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==2)
				WebUI.verifyTextPresent('Governance', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==3)
				WebUI.verifyTextPresent('Stakeholders', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==4)
				WebUI.verifyTextPresent('Meeting', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==5)
				WebUI.verifyTextPresent('Roadmap', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==6)
				WebUI.verifyTextPresent('Energy', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==7)
				WebUI.verifyTextPresent('Water', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==8)
				WebUI.verifyTextPresent('Waste', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==9)
				WebUI.verifyTextPresent('Transportation', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==10)
				WebUI.verifyTextPresent('Human Experience', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==11)
				//WebUI.verifyTextPresent('Additional data'.equalsIgnoreCase('Additional Data'), false ,FailureHandling.CONTINUE_ON_FAILURE)
				//Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Additional dataLEED')).equalsIgnoreCase("Additional data"))
				WebUI.verifyElementPresent(findTestObject('Object Repository/PreRequisite/CityCom/span_Additional Data'),5, FailureHandling.STOP_ON_FAILURE)

			if(count==12)
				WebUI.verifyTextPresent('Certification Plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==13)
				WebUI.verifyTextPresent('Benchmarking and evaluation plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==14)
				WebUI.verifyTextPresent('Carbon reduction plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==15)
				WebUI.verifyTextPresent('Resilience plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==16)
				WebUI.verifyTextPresent('Healthy community plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==17)
				WebUI.verifyTextPresent('Basic services plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==18)
				WebUI.verifyTextPresent('Biodiversity plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==19)
				WebUI.verifyTextPresent('Watershed, Coastal areas, or Ocean resources plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==20)
				WebUI.verifyTextPresent('Culture and heritage plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			if(count==21)
				WebUI.verifyTextPresent('Green infrastructure plan', false ,FailureHandling.CONTINUE_ON_FAILURE)

			count++

			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'),2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
			WebUI.delay(2)
		}
	}
}




