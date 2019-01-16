	package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.event.KeyEvent
import java.text.DateFormat
import java.text.SimpleDateFormat

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ReusableMethodsSubmitReview extends BaseClass{
	public static String reviewAmount

	public static void performanceScoreDataInputCheckboxSelection(){
		WebUI.waitForElementVisible(findTestObject('Object Repository/SubmitReview/EnergyCheckBox'), 20)
		WebUI.click(findTestObject('Object Repository/SubmitReview/EnergyCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/WaterCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/WasteCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/TransportationCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/HumanExperienceCheckBox'))
	}

	@Keyword
	public static void countNoOfDataInputFilesInSubmitReview(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPerformanceScoreVerificationTest')), "Performance Score Verification")

		(1..5).each{

			if(it==1){
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetDataInputFileCountSubmitReview',[index: it])),'8')
			}
			else if(it==4) {
				//Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetDataInputFileCountSubmitReview',[index: it])),'8')
			}
			else if(it==5) {
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetDataInputFileCountSubmitReview',[index: it])),'8')
			}
			else
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetDataInputFileCountSubmitReview',[index: it])),'7')
		}
	}


	@Keyword
	public void countNoOfFilesUploadedCityComm(){
		//WebUI.delay(5)
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		WebUI.delay(8)
		(1..12).each{

			if(it==1){
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'7')
			}
			else if(it==7){

			}

			else
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'1')
		}
		//Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/BasePointFileCountCityComm')),'1')
	}

	@Keyword
	public void performanceScoreSelectionAndSummary(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(13)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPerformanceScoreVerificationTest')), "Performance Score Verification")
		//reviewAmount = WebUI.getText(findTestObject('Object Repository/SubmitReview/ReviewAmount'))
		performanceScoreDataInputCheckboxSelection()
		WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'), 3)
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.delay(6)
		ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit Performance Score Verification Test Message")
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit Performance Score Verification Test Message')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'5')
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPerformanceScoreVerificationTextOnSummeryPage')), "Performance Score Verification")
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	@Keyword
	public void performanceScoreSelectionAndSummeryWithoutPerformanceData(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPerformanceScoreVerificationTest')), "Performance Score Verification")
		WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'), 3)
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.delay(6)
		ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit Performance Score Verification Test Message")
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		WebUI.delay(2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit Performance Score Verification Test Message')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'0')
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPerformanceScoreVerificationTextOnSummeryPage')), "Performance Score Verification")
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	//verify text 'Update operating hours and occupancy to generate score for all categories'
	@Keyword
	public void verifyOprHrsAndOccupancyUpdateMessageAtSubmitReviewPage(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyUpdateOprHrsAndOccupancyToGenerateScore')), "(Update operating hours and occupancy to generate score for all categories)")

	}

	//Transit PreRequisite and BasePoint Default status
	@Keyword
	public void preRequisiteAndBasePointDefaultStatus(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		WebUI.delay(5)
		//for preRequisite
		(1..10).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Missing')
		}

		//for BasePoint
		(11..33).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Missing')
		}

		println "Credits- PreRequisite and Base Points default status verified successfully"
	}

	//Transit PreRequisite and BasePoint Status during Submit review
	@Keyword
	public void preRequisiteAndBasePointDuringSubmitReviewStatus(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(15)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		//for preRequisite
		(1..10).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Ready for Review')
		}

		//for BasePoint
		(11..33).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Ready for Review')
		}
		println "Credits- PreRequisite and Base Points default status verified successfully"
	}

	//City/Comm PreRequisite and BasePoint Default status
	@Keyword
	public void preRequisiteAndBasePointDefaultStatusCityComm(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		WebUI.delay(5)
		//for preRequisite
		(1..6).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Missing')
		}


		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatusBasePointCity')),'Missing')


		println "Credits- PreRequisite and Base Points default status verified successfully"
	}



	//City/Comm PreRequisite and BasePoint during submit review status
	@Keyword
	public void preRequisiteAndBasePointStatusDuringSubmitReviewCityComm(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		WebUI.delay(5)
		//for preRequisite
		(1..6).each {
			Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatus',[('index') : it])),'Ready for Review')
		}


		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CreditStatusBasePointCity')),'Ready for Review')


		println "Credits- PreRequisite and Base Points default status verified successfully"
	}

	//Check only one certification is allowed(Transit Above Ground)
	@Keyword
	public void verifyOnlyOneCertificationAllowedTransitAboveGround(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyProjectStillUnderReviewTextPresent')),'Project is still under review')
		Assert.assertEquals(WebUI.verifyElementNotClickable(findTestObject('Object Repository/SubmitReview/CheckContinueButtonDisable')), true)

	}


	@Keyword
	public void verifyCertificationIsAllowedWithoutRequirementTUG(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(7)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifySummaryTextOnSummaryPage')), "Summary")
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPaymentTextPaymentPage')), "Payment")

	}

	@Keyword
	public void countNoOfFilesUploadedTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		WebUI.delay(5)

		(1..33).each{

			if(it==1){
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'7')
			}
			else
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'1')
		}
		(34..36).each{
			if(it==34)
			{
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'8')
			}
			else
				Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreditFileupload/GetCreditFileCountCityComm',[index: it])),'7')
		}
	}


	@Keyword
	public void certificationSelectionAndSummeryTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		WebUI.delay(5)
		/*(1..28).each {
		 WebUI.check(findTestObject('SubmitReview/CheckBoxReview',[('index') : it]))
		 }
		 WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'), 3)
		 WebUI.click(findTestObject('SubmitReview/div_Upload'))
		 WebUI.delay(6)
		 ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		 WebUI.delay(4)
		 WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit Certification Test Message")
		 WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		 //WebUI.refresh()
		 Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit Certification Test Message')
		 Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'38')*/
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextSummaryCityProject')), "Certification")
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	@Keyword
	public void certificationSelectionAndSummeryCityCom(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextCity')), "Certification")
		reviewAmount = WebUI.getText(findTestObject('Object Repository/SubmitReview/ReviewAmount'))
		WebUI.delay(5)
		//countNoOfFilesUploadedCityComm()
		WebUI.check(findTestObject('Object Repository/SubmitReview/BaseScoreCheckBoxCity'))
		(1..6).each {
			WebUI.check(findTestObject('SubmitReview/CheckBoxReview',[('index') : it]))
		}
		WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'), 3)
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.delay(6)
		ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit Certification Test Message")
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		//WebUI.refresh()
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit Certification Test Message')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'13')
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/CertificationTextSummaryCityProject')), "Certification")
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	@Keyword
	public void  preCertificationSelectionAndSummeryCityCom(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/PreCertificationText')), "Pre-Certification")
		WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'),1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SelectPre-Certification'))
		WebUI.delay(5)
		(1..6).each {
			WebUI.check(findTestObject('SubmitReview/CheckBoxReview',[('index') : it]))
		}
		WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'),3)
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.delay(6)
		ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit PreCertification Test Message")
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		//WebUI.refresh()
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit PreCertification Test Message')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'12')
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPreCertificationTextSummery')), "Pre-Certification")
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}
	@Keyword
	public void checkSubmitReviewIsDisabledTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review", false, FailureHandling.CONTINUE_ON_FAILURE)
		//check whether the information for registration payment is pending or not
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/CheckRegistrationPaymentPendingText')), "Registration payment is still under process", false, FailureHandling.CONTINUE_ON_FAILURE)
		//check if the continue button to submit review is disabled or not
		Assert.assertEquals(WebUI.verifyElementNotClickable(findTestObject('Object Repository/SubmitReview/CheckContinueButtonDisable')), true)
		println "Due to pending registration payment the error message is displaying "
	}

	@Keyword
	public void preCertificationSelectionAndSummeryTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review",false, FailureHandling.CONTINUE_ON_FAILURE )

		//WebUI.waitForElementClickable(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'), 3)
		//WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'),3)
		WebUI.delay(20)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SelectPre-Certification'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/PreCertificationText')), "Pre-Certification", false, FailureHandling.CONTINUE_ON_FAILURE)
		(1..28).each {
			WebUI.check(findTestObject('SubmitReview/CheckBoxReview',[('index') : it]))
		}
		WebUI.scrollToElement(findTestObject('SubmitReview/div_Upload'),3)
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.delay(6)
		ReusableMethodsDataInput.uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'), "Submit Pre Certification Test Message")
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSaveAddtionalTextArea'))
		//WebUI.refresh()
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/SubmitReviewTextAreaAdditionalMessage'),'value'),'Submit Pre Certification Test Message', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyTotalCredits')),'38', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/VerifyPreCertificationTextSummery')), "Pre-Certification", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/SubmitReview/PreRequisiteEligibleTextVerification')), "Eligible", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}


	/*@Keyword
	 public void checkReviewPaymentPayNowStatus(){
	 String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
	 Assert.assertEquals(regStatus, "Completed")
	 }*/

	@Keyword
	public void submitPerformanceScoreAndVerifySuccessMessage(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitPerformanceScore'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}

	@Keyword
	public void submitCertificationAndVerifySuccessMessage(){
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/SubmitCertification'),3)
		WebUI.waitForElementNotClickable(findTestObject('Object Repository/SubmitReview/SubmitCertification'),9)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitCertification'))
		WebUI.delay(8)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}
	@Keyword
	public void submitPreCertAndVerifySuccessMessage(){
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/SubmitPreCertification'), 3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/SubmitReview/SubmitPreCertification'),9)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitPreCertification'))
		WebUI.delay(8)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}

	@Keyword
	public void onClickChangeCreditNavigateSelectionPage(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(10)
		performanceScoreDataInputCheckboxSelection()
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/ChangeCreditLink'))
		WebUI.delay(4)
		String url=WebUI.getUrl()
		Assert.assertTrue(url.contains('submitforreview/selection'))
		println 'Change credit successfully redirected to the Selection page'
	}

	/*@Keyword
	 public void addCertification(String sheetName, int rowNum){
	 String prjId   =   data.getCellData(sheetName, "ProjectID", rowNum)
	 WebUI.click(findTestObject('Manage/adminToolNew/a_ Certification'))
	 WebUI.delay(3)
	 WebUI.setText(findTestObject('Manage/adminToolNew/leedId'),prjId )
	 WebUI.delay(2)
	 WebUI.setText(findTestObject('Object Repository/Manage/adminToolNew/certificationPoints'),"80" )
	 WebUI.delay(2)
	 WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_silver'))
	 WebUI.delay(2)
	 WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_Save'))
	 WebUI.delay(5)
	 Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Manage/adminToolNew/MessageSuccessfullySubmitted')), "Project Certification added")
	 }*/

	@Keyword
	public void addCertificationFromAdminToolForCities(String sheetName, int rowNum){
		String prjId   =   data.getCellData(sheetName, "ProjectID", rowNum)
		WebUI.click(findTestObject('Manage/adminToolNew/a_ Certification'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Manage/adminToolNew/leedId'),prjId )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemDownArrow'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Manage/adminToolNew/a_LEED v4 Cities'), 2)
		WebUI.click(findTestObject('Manage/adminToolNew/a_LEED v4 Cities'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminTool/SourceId'), prjId)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminToolNew/certificationPoints'),"80" )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_Save'))
		WebUI.delay(10)
		//WebUI.closeWindowIndex(2)
		//WebUI.delay(2)
		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
		//Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Manage/adminToolNew/MessageSuccessfullySubmitted')), "Project Certification added")
	}

	@Keyword
	public void addCertificationFromAdminToolForCommunity(String sheetName, int rowNum){
		String prjId   =   data.getCellData(sheetName, "ProjectID", rowNum)
		WebUI.click(findTestObject('Manage/adminToolNew/a_ Certification'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Manage/adminToolNew/leedId'),prjId )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemDownArrow'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemCommunity'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemCommunity'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminTool/SourceId'), prjId)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminToolNew/certificationPoints'),"80" )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_Save'))
		WebUI.delay(15)
		//WebUI.closeWindowIndex(2)
		//WebUI.delay(2)
		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
		//Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Manage/adminToolNew/MessageSuccessfullySubmitted')), "Project Certification added")
	}

	@Keyword
	public void addCertificationFromAdminToolForBuildings(String sheetName, int rowNum){
		String prjId   =   data.getCellData(sheetName, "ProjectID", rowNum)
		WebUI.click(findTestObject('Manage/adminToolNew/a_ Certification'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Manage/adminToolNew/leedId'),prjId )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemDownArrow'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemBuilding'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemBuilding'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminTool/SourceId'), prjId)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminToolNew/certificationPoints'),"80" )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_Save'))
		WebUI.delay(10)
		//Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Manage/adminToolNew/MessageSuccessfullySubmitted')), "Project Certification added")
		//WebUI.closeWindowIndex(2)
		//WebUI.delay(2)
		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
	}


	@Keyword
	public void addCertificationFromAdminToolForTransit(String sheetName, int rowNum){
		String prjId   =   data.getCellData(sheetName, "ProjectID", rowNum)
		WebUI.click(findTestObject('Manage/adminToolNew/a_ Certification'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Manage/adminToolNew/leedId'),prjId )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemDownArrow'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemTransit'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/ratingSystemTransit'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminTool/SourceId'), prjId)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Manage/adminToolNew/certificationPoints'),"80" )
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/adminToolNew/button_Save'))
		WebUI.delay(10)
		println WebUI.getWindowIndex()
		//WebUI.closeWindowIndex(2)
		//WebUI.delay(2)
		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)

	}

	@Keyword
	public void verifyReportingPeriodPreviousAndCurrent(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(16)
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy")
		Date date = new Date()
		println dateFormat.format(date)
		//check if able to select the current date and previous year as reporting year
		WebUI.waitForElementVisible(findTestObject('Object Repository/SubmitReview/ReviewDate'), 20)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/ReviewDate'),'value'), dateFormat.format(date))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSelectDate'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickCurrentMonth'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSelectYear'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickToSelectMonth'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnDay'))
		WebUI.delay(8)
		/*WebUI.click(findTestObject('Object Repository/SubmitReview/ReportingDate'))
		 WebUI.delay(2)
		 WebUI.setText(findTestObject('Object Repository/SubmitReview/ReportingDate'),"02/02/2017" )*/
		Robot robot= new Robot()
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(8)
		println WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/ReviewDate'),'value')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/ReviewDate'),'value'), '02/02/2017')

		//verify if the current year score is visible for the current year
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/SubmitReview/CurrentScore')))
		String currentScore= WebUI.getText(findTestObject('Object Repository/SubmitReview/CurrentScore'))
		println currentScore
		String reportingScore= WebUI.getText(findTestObject('Object Repository/SubmitReview/ReportingPeroidScore'))
		println reportingScore
		//click on the data input checkbox
		performanceScoreDataInputCheckboxSelection()
		WebUI.delay(4)
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.delay(10)
		String reportingPeriod= WebUI.getText(findTestObject('Object Repository/SubmitReview/SummaryPageReportingPeriod'))
		Assert.assertEquals('02/02/2016 - 02/02/2017', reportingPeriod)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SummaryPageScoreSubmitted')), reportingScore+"/100")
		WebUI.delay(7)
		//WebUI.mouseOver(findTestObject('Object Repository/SubmitReview/ScoreSidebar'))
		//WebUI.click(findTestObject('Object Repository/SubmitReview/ScoreSidebar'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/ScoreTotalSideBar'))
		WebUI.delay(12)
		String scoreTotal = WebUI.getText(findTestObject('Object Repository/SubmitReview/TotalScore'))
		println scoreTotal
		Assert.assertEquals(scoreTotal, currentScore)
		println "The score includes base point in addition to data input"

	}


}
