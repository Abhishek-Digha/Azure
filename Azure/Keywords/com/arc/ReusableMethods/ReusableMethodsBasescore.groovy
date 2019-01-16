package com.arc.ReusableMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsBasescore {

	@Keyword
	public void preRequisiteAttemptTransit(){
		WebUI.click(findTestObject('PreRequisite/a_ Prerequisites'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/span_Site Management Policy'))

		WebUI.delay(5)
		println 1

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 2

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 3

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 4

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))


		println 5

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/span_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 6

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 7

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))


		println 8
		WebUI.delay(5)
		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 9

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 10

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/span_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		Assert.assertEquals(WebUI.getText(findTestObject('PreRequisite/span_Site Management Policy')),'Site Management Policy')
	}


	@Keyword
	public void basePointAttemptTransit(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('Object Repository/BasePoint/a_ Base Points'))

		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))

		for (int c in 0..22){

			WebUI.delay(5)
			WebUI.click(findTestObject('PreRequisite/CheckBox1'))
			WebUI.delay(5)
			WebUI.waitForElementClickable(findTestObject('PreRequisite/button_Attempted'), 20)
			WebUI.click(findTestObject('PreRequisite/button_Attempted'))
			WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
			WebUI.delay(5)
			WebUI.waitForElementClickable(findTestObject('Object Repository/BasePoint/button_Ok'), 20)
			WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 5)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
		}

		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/BasePoint/span_Site Development - Protec')),'Site Development - Protect or Restore Habitat')
	}
	@Keyword
	public void basePromptMessageVerificationTransit(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('Object Repository/BasePoint/a_ Base Points'))

		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))


		WebUI.delay(5)
		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(5)


		WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
		WebUI.delay(5)

	}

	@Keyword
	public void basePointAttemptReveiwCityCom(){
		/***********User should be able to add team member under base points.*********************************/
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.waitForElementClickable(findTestObject('BasePoint/CityCom/a_ Base Points'), 10)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(8)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('BasePoint/CityCom/span_Ready for Review'), 3)

		/***Verify that once the status is selected from Attempted to 'ready for review' , the whole base points section should be become uneditable and will turn greyed out.**/	
		WebUI.verifyElementNotPresent(findTestObject('BasePoint/BasePointCreditCom/FileUploadNotVisible'), 3)

	}


	@Keyword
	public void basePointTeamMemberAdd(){
		/***********User should be able to add team member under base points.*********************************/
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.waitForElementClickable(findTestObject('BasePoint/CityCom/a_ Base Points'), 10)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(8)
		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamIconClick'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamMemberSelection'))
		WebUI.delay(10)

		String teamMemUI = WebUI.getText(findTestObject("BasePoint/BasePointCreditCom/VerifyAddedTeamSuccessully"))
		WebUI.verifyMatch(GlobalVariable.teamMemName,teamMemUI, false)


	}


	@Keyword
	public void basePointTeamMemberAddTransit(){
		/***********User should be able to add team member under base points.*********************************/
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('PreRequisite/a_ Prerequisites'))
		//WebUI.setViewPortSize(1500,800)
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/span_Site Management Policy'))
		WebUI.delay(8)

		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamIconClick'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamMemberSelection'))
		WebUI.delay(10)

		String teamMemUI = WebUI.getText(findTestObject("BasePoint/BasePointCreditCom/VerifyAddedTeamSuccessully"))
		WebUI.verifyMatch(GlobalVariable.teamMemName,teamMemUI, false)


	}


	@Keyword
	public void baseMyActionCreditAssignTest(){
		/***********User should be able to add team member under base points.*********************************/
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.scrollToElement(findTestObject('BasePoint/BasePointCreditCom/a_ My Actions'),5)
		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/a_ My Actions'))
		WebUI.delay(6)
		String teamMemUI = WebUI.getText(findTestObject('BasePoint/BasePointCreditCom/MyActionAssignedCredit'))
		WebUI.verifyMatch(GlobalVariable.teamMemName,teamMemUI,false)
	}

	@Keyword
	public void baseMyActionCreditAssignTransitTest(){
		/***********User should be able to add team member under base points.*********************************/
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.scrollToElement(findTestObject('BasePoint/BasePointCreditCom/a_ My Actions'),5)

		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/a_ My Actions'))
		WebUI.delay(10)

		String teamMemUI = WebUI.getText(findTestObject("BasePoint/BasePointCreditCom/MyActionTransit"))
		WebUI.verifyMatch(GlobalVariable.teamMemName,teamMemUI,false)

	}

	@Keyword
	public void nameOfCreditCreditTransit(){
		/*******Verify that the Name of the credit is correct  for Buildings.***********/
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Site Management Policy'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Site Development - Protec'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Rainwater Management'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Heat Island Reduction'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Light Pollution Reduction'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Site Management'),2)

		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Site Improvement Plan'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Indoor Water Use Reductio'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Energy Efficiency Best Ma'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Minimum Energy Performanc'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Fundamental Refrigerant M'),2)

		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Enhanced Refrigerant Mana'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Ongoing Purchasing and Wa'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Facility Maintenance and'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Purchasing - ongoing'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Purchasing - lamps'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Purchasing - facility mai'),2)

		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Solid waste management'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Minimum Indoor Air Qualit'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Environmental Tobacco Smo'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Green Cleaning Policy'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Thermal Comfort'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Interior Lighting'),2)

		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Daylight and Quality View'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Green Cleaning - Custodia'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Green Cleaning - Products'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Green Cleaning - Equipmen'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Integrated Pest Managemen'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Energy'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Water'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Waste'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Transportation'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Human Experience'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Innovation1'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Innovation2'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Innovation3'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Innovation4'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Innovation5'),2)

	}
	@Keyword
	public void nameOfCreditCreditCityComLEED(){
		/*******Verify that the Name of the credit is correct  for City/Community LEED***********/
		WebUI.delay(2)
		WebUI.click(findTestObject("DataInput/Notification/a_ All Actions"))
		//WebUI.delay(2)
	/*	WebUI.scrollToPosition(0,500)
		WebUI.delay(5)
		WebUI.refresh()*/
		WebUI.delay(17)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Energy'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Water'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Waste'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Transportation'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Human Experience'),2)
		Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Additional dataLEED')).equalsIgnoreCase("Additional data"))
		//WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Additional data'),2)
       
		 WebUI.scrollToElement(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Basic services plan'),3, FailureHandling.CONTINUE_ON_FAILURE)
		
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Basic services plan'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Benchmarking and evaluati'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Biodiversity plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Carbon reduction plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Certification Plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Commit to sharing data'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Culture and heritage plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Governance'),2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Green infrastructure plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Healthy community plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Meeting'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Project boundary'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Resilience plan'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Roadmap'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Stakeholders'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Arc dashboard/Credit/CityCom/span_Watershed Coastal areas o'),2)

	}
	@Keyword
	public void nameOfCreditCreditCityComOtherNone(){
		/*******Verify that the Name of the credit is correct  for City/Community Other/None***********/
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Energy'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Water'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Waste'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Transportation'),2)
		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/Credit/span_Human Experience'),2)
		Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/Credit/CityCom/span_Additional data')).equalsIgnoreCase("Additional data"))


	}

}
