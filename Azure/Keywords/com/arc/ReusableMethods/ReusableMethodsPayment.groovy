package com.arc.ReusableMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.googlecode.javacv.CanvasFrame.Exception
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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsPayment extends BaseClass{
	ReusableMethodsSubmitReview submitReviewObj = new ReusableMethodsSubmitReview()

	@Keyword
	public void paymentByCC(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String cardName   = data.getCellData(sheetName, "CardName", rowNum)
		String cardNum    = data.getCellData(sheetName, "CardNumber", rowNum)
		String cardDate   = data.getCellData(sheetName, "Date ", rowNum)
		String cardCvv    = data.getCellData(sheetName, "CVV", rowNum)
		String partyName  = data.getCellData(sheetName, "PartyName", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('PaymenntLocator/PromoCodeTextfieldRegPayment')),true)
		WebUI.check(findTestObject('Object Repository/PaymenntLocator/CreditCradOptionRegistration'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_name '),cardName)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), cardNum)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_expiry'),cardDate)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_CVV'),cardCvv)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , true)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(20)
		WebUI.waitForElementVisible(findTestObject('Object Repository/PaymenntLocator/NextButtonCongratulationPage'), 20)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/NextButtonCongratulationPage'))
		//Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		//Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void regPaymentUsingPromocode(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String regPromocode   = data.getCellData(sheetName, "RegPromocode", rowNum)
		String discRegPrice    = data.getCellData(sheetName, "DisRegPrice", rowNum)
		String regdAmount    = data.getCellData(sheetName, "RegAmount", rowNum)
		String amountDiscounted    = data.getCellData(sheetName, "DiscountedAmountRegd", rowNum)

		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/InputPromocode'), regPromocode)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickToApplyPromocode'))
		WebUI.delay(8)
		String subTotalAmount= WebUI.getText(findTestObject('Object Repository/PaymenntLocator/SubTotalRegdAmount'))
		WebUI.verifyEqual(regdAmount + " for 5 years", subTotalAmount )
		String discAmount= WebUI.getText(findTestObject('Object Repository/PaymenntLocator/AmountDiscountedRegd'))
		WebUI.verifyEqual(amountDiscounted, discAmount )
		String discPrice= WebUI.getText(findTestObject('PaymenntLocator/DiscountedPriceRegd'))
		WebUI.verifyEqual(discRegPrice, discPrice)
	}


	@Keyword
	public void reviewPaymentUsingPromocode(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String reviewPromocode   = data.getCellData(sheetName, "RevPromocode", rowNum)
		String discReviewPrice   = data.getCellData(sheetName, "DisReviewPrice", rowNum)
		String reviewAmount      = data.getCellData(sheetName, "ReviewAmount", rowNum)
		String discountedAmount  = data.getCellData(sheetName, "DiscountedAmountReview", rowNum)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/InputPromocodeReview'), reviewPromocode)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickToApplyPromocode'))
		WebUI.delay(5)
		String discAmountReview= WebUI.getText(findTestObject('Object Repository/PaymenntLocator/DiscountedAmountReiew'))
		WebUI.verifyEqual(discountedAmount , discAmountReview)
		String subTotal= WebUI.getText(findTestObject('Object Repository/PaymenntLocator/SubTotalReviewAmount'))
		WebUI.verifyEqual(reviewAmount, subTotal)
		String discPriceReview= WebUI.getText(findTestObject('Object Repository/PaymenntLocator/DiscountedPriceReview'))
		WebUI.verifyEqual(discReviewPrice, discPriceReview)
	}

	@Keyword
	public void regPaymentByCheckIND(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String partyName  = data.getCellData(sheetName, "PartyName", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('PaymenntLocator/PromoCodeTextfieldRegPayment')),true)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Continue'))
		WebUI.delay(20)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void regPaymentByCheckINT(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/CheckRadio'))
		WebUI.delay(2)
		String partyName  = data.getCellData(sheetName, "PartyName", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('PaymenntLocator/PromoCodeTextfieldRegPayment')),true)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(15)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/NextButtonCongratulationPage'))

	}
	@Keyword
	public void regPaymentByCheckCN(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(4)
		String partyName  = data.getCellData(sheetName, "PartyName", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(15)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void payNowRegistrationPaymentIND(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		//WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.verifyElementPresent(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'), 5)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.switchToWindowTitle('')
		//WebUI.switchToWindowIndex(1)
		WebUI.delay(3)
		WebUI.setText(findTestObject('PayNowRegistrationPaymentIN/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Continue'))
		WebUI.selectOptionByValue(findTestObject('PayNowRegistrationPaymentIN/select_Select Bank'), 'AvenuesTest', true)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_Make Payment'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/returnToMerchantSite'))
		WebUI.switchToWindowTitle('Arc dashboard')
		Assert.assertEquals(WebUI.getText(findTestObject('PayNowRegistrationPaymentIN/checkStatusCompleted')),'Completed')

	}

	@Keyword
	public void payNowSubmitReviewPaymentIND(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		//WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.verifyElementPresent(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'), 5)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.switchToWindowTitle('')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentIN/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Continue'))
		WebUI.selectOptionByValue(findTestObject('PayNowRegistrationPaymentIN/select_Select Bank'), 'AvenuesTest', true)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_Make Payment'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/returnToMerchantSite'))
		WebUI.switchToWindowTitle('Arc dashboard')
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/PayNowSubmitReviewPaymentIN/submitReviewPaymentStatus')),'Completed')
	}


	@Keyword
	public void payNowRegistrationPaymentINT(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(1)
		//WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'), 'K')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_expiry'), '02/2025')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_number'), '999')
		//WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/div_Street Address  This field'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'), 'GBCI BUILDING')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('PayNowRegistrationPaymentUSTest/select_AfghanistanAland Island'), 'United States', false)
		WebUI.selectOptionByLabel(findTestObject('RegistrationPaymentCheck/select_Select StateAlabamaAlas'), 'Alabama', false)
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'), '35006')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_phone'), '9486861522')
		WebUI.delay(4)
		WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/button_Pay now_1'))
		WebUI.delay(5)
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))
		Assert.assertEquals(regStatus, "Completed")
	}


	@Keyword
	public void payNowReviewPaymentUS(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'), 'K')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_expiry'), '02/2025')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_number'), '999')
		//WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/div_Street Address  This field'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'), 'GBCI BUILDING')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('PayNowRegistrationPaymentUSTest/select_AfghanistanAland Island'), 'United States', false)
		WebUI.selectOptionByLabel(findTestObject('RegistrationPaymentCheck/select_Select StateAlabamaAlas'), 'Alabama', false)
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'), '35006')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_phone'), '9486861522')
		WebUI.delay(2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/button_Pay now_1'))
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'),10)
		WebUI.delay(10)
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		Assert.assertEquals(regStatus, "Completed")
	}

	@Keyword
	public void clickCheckOptionRegistration(){

		WebUI.click(findTestObject('Object Repository/PaymenntLocator/SelectOptionCheck'))
	}

	@Keyword
	public void clickCheckOptionReview(){
		WebUI.delay(5)
		WebUI.click(findTestObject('ReviewPaymentByCheckUS/input_payment-type'))
	}


	@Keyword
	public void reviewPaymentByCheckINT(){
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(4)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('Object Repository/SubmitReview/PromocodeTextFieldReviewPayment')),true)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/payment-typeCheck'))
		WebUI.delay(2)
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_firstname2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_firstname2'), 'Saurav')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_lastname2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_lastname2'), 'K')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_streetaddress2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_streetaddress2'), 'GBCI')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_city2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_city2'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckUS/select_AfghanistanAland Island'), 'India', false)
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckUS/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_postalcode2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_postalcode2'), '122018')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_email2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_email2'), 'saurav@groupten.com')
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_phone2'), '9486861522')
		WebUI.click(findTestObject('ReviewPaymentByCheckUS/button_Continue'))
	}





	@Keyword
	public void verifyCheckOptionHasPreFilledValueWithOptionToEnterphoneNo(String sheetName, rowNum){
		String firstName  = data.getCellData(sheetName, "CardName", rowNum)
		String lastName  = data.getCellData(sheetName, "CardLast", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(6)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		WebUI.delay(20)
		WebUI.waitForElementClickable(findTestObject('SubmitReview/button_Continue'), 20)
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('SubmitReview/button_Continue'), 20)
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/payment-typeCheck'))
		WebUI.delay(2)
		switch(country) {
			case 'India':
				country='IN'
				break
			case 'United States':
				country= 'US'
				break
		}

		switch(state) {
			case 'Virginia':
				state='string:VA'
				break
			case 'Indiana':
				state='string:IN'
				break
		}



		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_firstname2'),'value'), firstName)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_lastname2'),'value'), lastName)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_streetaddress2'),'value'), address)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_city2'),'value'), city)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/select_AfghanistanAland Island'),'value'), country)
		println WebUI.getAttribute(findTestObject('Object Repository/RegistrationPaymentCheck/StatesReviewPayment'),'label')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/RegistrationPaymentCheck/StatesReviewPayment'),'value'), state)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_postalcode2'),'value'), zip)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_email2'),'value'), partyEmail)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_phone2'),'value'), '')
	}

	//validate if the credit card belongs to the correct service provider submit review
	@Keyword
	public void validateCreditCardSubmitReview(){
		//for visa card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/VisaCard'), 2), true)
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '4012000010000')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/VisaCard'), 2), true)
		println "Visa Card label is present"

		WebUI.delay(3)

		//for master card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/MasterCard'), 2), true)
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '5499740000000057')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/MasterCard'), 2), true)
		println "Master Card label is present"

		WebUI.delay(3)

		//for amex card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/AmexCard'), 2), true)
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '371449635392376')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/AmexCard'), 2), true)
		println "AMEX Card label is present"

		//for discover card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/DiscoverCard'), 2), true)
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '6011000990099818')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/DiscoverCard'), 2), true)
		println "Discover Card label is present"

	}


	//validate if the credit card belongs to the correct service provider registration payment
	@Keyword
	public void validateCreditCardRegistrationPayment(){
		//for visa card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/VisaCard'), 2), true)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), '4012000010000')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/VisaCard'), 2), true)
		println "Visa Card label is present"

		WebUI.delay(3)

		//for master card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/MasterCard'), 2), true)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), '5499740000000057')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/MasterCard'), 2), true)
		println "Master Card label is present"

		WebUI.delay(3)

		//for amex card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/AmexCard'), 2), true)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), '371449635392376')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/AmexCard'), 2), true)
		println "AMEX Card label is present"

		WebUI.delay(3)

		//for discover card
		Assert.assertEquals(WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitReview/DiscoverCard'), 2), true)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), '6011000990099818')
		Assert.assertEquals(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/DiscoverCard'), 2), true)
		println "Discover Card label is present"
	}


	// verify if the element CC, CVV and Expiary date fields are enabled
	@Keyword
	public void verifyPaymentByCCHasCCExpiaryAndCVVEnabled(){
		Assert.assertTrue(WebUI.verifyElementClickable(findTestObject('SubmitReview/input_cardnumber')))
		Assert.assertTrue(WebUI.verifyElementClickable(findTestObject('SubmitReview/input_CC_expiry')))
		Assert.assertTrue(WebUI.verifyElementClickable(findTestObject('SubmitReview/input_CC_number')))
		println "Verify if the Payment by credit card has fields CC, CVV and Expiary date enabled"
	}


	@Keyword
	public void reviewPaymentByCheckIND(){

		WebUI.delay(5)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('Object Repository/SubmitReview/PromocodeTextFieldReviewPayment')),true)
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_firstname2'), 'Saurav')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_lastname2'), 'K')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_streetaddress2'), 'GBCI Gurgaon')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_city2'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckIND/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.delay(3)
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_postalcode2'), '122018')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_email2'), 'testuser@gmail.com')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_phone2'), '9486861522')
		WebUI.click(findTestObject('ReviewPaymentByCheckIND/button_Continue'))
		WebUI.delay(3)
		WebUI.click(findTestObject('ReviewPaymentByCheckIND/button_Continue_1'))
		WebUI.delay(2)
	}

	@Keyword
	public void reviewPaymentByCreditcardINT(String sheetName, int rowNum){
		WebUI.delay(6)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		Assert.assertEquals(WebUI.verifyElementClickable(findTestObject('Object Repository/SubmitReview/PromocodeTextFieldReviewPayment')),true)
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/CreditCardOptionButton'), 2))
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitReview/CheckOptionButton'), 2))
		WebUI.clearText(findTestObject('SubmitReview/input_firstname'))
		WebUI.setText(findTestObject('SubmitReview/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('SubmitReview/input_lastname'))
		WebUI.setText(findTestObject('SubmitReview/input_lastname'), 'K')
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('SubmitReview/input_CC_expiry'), '09/2025')
		WebUI.setText(findTestObject('SubmitReview/input_CC_number'), '999')
		WebUI.clearText(findTestObject('SubmitReview/input_streetaddress'))
		WebUI.setText(findTestObject('SubmitReview/input_streetaddress'), address)
		WebUI.clearText(findTestObject('SubmitReview/input_city'))
		WebUI.setText(findTestObject('SubmitReview/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/SubmitReview/ReviewPaymentSelectCountry'), country, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/SubmitReview/SelectStatesReviewPayment'), state, false)
		WebUI.clearText(findTestObject('Object Repository/SubmitReview/postalcode'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/postalcode'), zip)
		WebUI.setText(findTestObject('SubmitReview/input_email'), partyEmail)
		WebUI.setText(findTestObject('SubmitReview/input_phone'), '9486861522')
		WebUI.click(findTestObject('SubmitReview/span_Continue'))
	}



	@Keyword
	public void verifyPaymentByCCHasPreFilledDataWithOptionToFillPhoneNo(String sheetName, int rowNum){

		String firstName  = data.getCellData(sheetName, "CardName", rowNum)
		String lastName  = data.getCellData(sheetName, "CardLast", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)
		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(6)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitReviewText')), "Submit for Review")
		WebUI.delay(20)
		WebUI.waitForElementClickable(findTestObject('SubmitReview/button_Continue'), 20)
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('SubmitReview/button_Continue'), 20)
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.delay(2)
		switch(country)
		{
			case 'India':
				country='IN'
				break
			case 'United States':
				country= 'US'
				break
		}

		switch(state)
		{
			case 'Virginia':
				state='string:VA'
				break

			case 'Indiana':
				state='string:IN'
				break
		}


		Assert.assertEquals(WebUI.getAttribute(findTestObject('SubmitReview/input_firstname'),'value'), firstName)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('SubmitReview/input_lastname'),'value'), lastName)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('SubmitReview/input_streetaddress'),'value'), address)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('SubmitReview/input_city'),'value'), city)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/ReviewPaymentSelectCountry'),'value'), country)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/RegistrationPaymentCheck/StatesReviewPayment'),'value'), state)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/SubmitReview/postalcode'),'value'), zip)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('SubmitReview/input_email'),'value'), partyEmail)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('ReviewPaymentByCheckUS/input_phone2'),'value'), '')
	}

	//review payment cancel button navigates to selection page
	@Keyword
	public void verifyClickingReviewPaymentCancelNavigatesToSelectionPage(){
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/SubmitReview/CancelButtonReviewPayment'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SelectionPageTitle')),'Certification Type and Reporting Period')
	}

	//review payment submit section edit button navigates to payment page
	@Keyword
	public void verifyEditButtonAtSubmitSectionNavigatesToPaymentSection(){

		WebUI.click(findTestObject('Object Repository/SubmitReview/EditButtonSubmitPage'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/PaymentPageVerifyText')), 'Enter Payment Information')
	}


	//verify submit page frequency details
	@Keyword
	public void validateDetailsAtSubmitSectionPaymentReview(String sheetName, int rowNum ){

		String address    = data.getCellData(sheetName, "Address", rowNum)
		String city       = data.getCellData(sheetName, "City", rowNum)
		String country    = data.getCellData(sheetName, "Country", rowNum)
		String state      = data.getCellData(sheetName, "State", rowNum)
		String zip        = data.getCellData(sheetName, "Zip", rowNum)
		String partyEmail = data.getCellData(sheetName, "PartyEmail", rowNum)

		/*switch(country)
		 {
		 case 'IN':
		 country='India'
		 break
		 case 'US':
		 country= 'United States'
		 break
		 }*/

		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/Frequency')),'One-time payment of '+submitReviewObj.reviewAmount.replaceAll("\\s",""))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/Address')), address+", "+city)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/StateAndPinCode')), state+" "+zip)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/Country')), country)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/EmailId')), partyEmail)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/MobileNo')),'9486861522' )
	}


	//edit payment details and verify if the changes reflects
	@Keyword
	public void editSubmitReviewPaymentDetails(){

		WebUI.clearText(findTestObject('SubmitReview/input_streetaddress'))
		WebUI.setText(findTestObject('SubmitReview/input_streetaddress'), 'GBCI')
		WebUI.clearText(findTestObject('SubmitReview/input_city'))
		WebUI.setText(findTestObject('SubmitReview/input_city'), 'gurgaon')
		WebUI.selectOptionByLabel(findTestObject('Object Repository/SubmitReview/ReviewPaymentSelectCountry'), 'India', false)
		WebUI.selectOptionByLabel(findTestObject('SubmitReview/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.clearText(findTestObject('Object Repository/SubmitReview/postalcode'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/postalcode'), '122018')
		WebUI.setText(findTestObject('SubmitReview/input_email'), 'abhishekkumar@groupten.com')
		WebUI.setText(findTestObject('SubmitReview/input_phone'), '9486861520')
		WebUI.click(findTestObject('SubmitReview/span_Continue'))
		WebUI.delay(8)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/Address')), 'GBCI, gurgaon')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/StateAndPinCode')), 'Haryana'+" "+'122018')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/Country')), 'India')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/EmailId')), 'abhishekkumar@groupten.com')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/SubmitSection/MobileNo')),'9486861520' )
	}



	@Keyword
	public void paymentPageFieldDetailsVerification() {
		WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/span_Credit card'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/span_Check'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Name on Card'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Credit Card Number'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/span_Credit card'))

		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Expiration Date'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_CVV'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Bill-to-party name'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Bill-to-party email'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Address 1'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Address 2'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_City'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_CountryRegion'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_State'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/label_Zip Code'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/span_Credit card'))
		WebUI.verifyElementVisible(findTestObject('PaymenntLocator/DashbordPayment/span_Credit card'))

		WebUI.verifyImagePresent(findTestObject('PaymenntLocator/DashbordPayment/img_card_img amex'))
		WebUI.verifyImagePresent(findTestObject('PaymenntLocator/DashbordPayment/img_card_img discover'))
		WebUI.verifyImagePresent(findTestObject('PaymenntLocator/DashbordPayment/img_card_img mastercard'))
		WebUI.verifyImagePresent(findTestObject('PaymenntLocator/PaymenntLocator/DashbordPayment/img_card_img visa'))
	}

	@Keyword
	public void paymentPageProjectDetailsVerification(String sheetName , int rowNum ,String prjRating ,String member) {
		/*Verify if the project details are appearing correctly on the right side with ( Project ID , Name , Rating system) for Buildings - LEED V4 O+M: EB (WP), City- , Community - Transit - , Parksmart */

		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)

		String projectName = data.getCellData(sheetName,"ProjectName",rowNum)

		String regPriceNonMem = data.getCellData(sheetName,"RegAmount",rowNum)
		String regPriceNonmem = regPriceNonMem.concat(" for 5 years")
		println regPriceNonmem

		String projectIDUI = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/ProjectNameID'))
		WebUI.verifyMatch(projectIDUI,projectId, false)

		String projectNameUI= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/ProjectName'))
		WebUI.verifyMatch(projectNameUI,projectName, false)

		String ratingSystem= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/RatingSystem'))
		WebUI.verifyMatch(prjRating,ratingSystem, false)

		String toregPrince= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/TotalRegPrice'))
		WebUI.verifyMatch(regPriceNonmem,toregPrince, false)

		//String memberUI= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/USGBCMember'))
		//WebUI.verifyMatch(memberUI,member, false)

	}


	@Keyword
	public void paymentPageprojectFeeNavigation() {
		/*Verify the link to view certification fees and member discount and when clicked takes you to http://www.usgbc.org/cert-guide/fees */
		WebUI.click(findTestObject('PaymenntLocator/projectDetails/a_View certification fees and'))
		WebUI.delay(15)
		WebUI.switchToWindowIndex(1)
		String usgbcregPaymentPage = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/h2_LEED Certification Fees'))
		Assert.assertEquals(usgbcregPaymentPage,"LEED Certification Fees")
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}

	@Keyword
	public void paymentPageProjectDetailsVerificationparking(String sheetName , int rowNum ,String prjRating ,String member) {
		/*Verify if the project details are appearing correctly on the right side with ( Project ID , Name , Rating system) for Buildings - LEED V4 O+M: EB (WP), City- , Community - Transit - , Parksmart */

		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)

		String projectName = data.getCellData(sheetName,"ProjectName",rowNum)

		String regPriceNonMem = data.getCellData(sheetName,"RegAmount",rowNum)

		String projectIDUI = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/ProjectNameID'))
		WebUI.verifyMatch(projectIDUI,projectId, false)

		String projectNameUI= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/ProjectName'))
		WebUI.verifyMatch(projectNameUI,projectName, false)

		String ratingSystem= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/RatingSystem'))
		WebUI.verifyMatch(prjRating,ratingSystem, false)

		String toregPrince= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/TotalRegPrice'))
		WebUI.verifyMatch(regPriceNonMem,toregPrince, false)

		String memberUI= WebUI.getText(findTestObject('PaymenntLocator/projectDetails/USGBCMember'))
		//WebUI.verifyMatch(memberUI,member, false)
	}


	@Keyword
	public void paymentPageSpecialCharValidationTest() {
		/*Verify the special characters where applicable drop-down  where applicable */
		WebUI.check(findTestObject('Object Repository/PaymenntLocator/CreditCradOptionRegistration'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_name '),'!@#$%^&*()!@#$%^&*(!@#$%^&*@#$%^&*(@#$%^')
		WebUI.click(findTestObject('PaymenntLocator/DashbordPayment/label_CVV'))
		WebUI.verifyElementNotPresent(findTestObject('PaymenntLocator/projectDetails/CardNameValidation'),2)

		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), '122!@#$%^&*(@#$%^&*#$%^&$')
		WebUI.click(findTestObject('PaymenntLocator/DashbordPayment/label_CVV'))
		WebUI.verifyElementPresent(findTestObject('PaymenntLocator/projectDetails/span_Please enter valid credit'),2)

		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_expiry'),'12/2017')
		WebUI.click(findTestObject('PaymenntLocator/DashbordPayment/label_CVV'))
		WebUI.verifyElementPresent(findTestObject('PaymenntLocator/projectDetails/span_Please enter valid expiry'),2)

		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_CVV'),'@#3')
		WebUI.click(findTestObject('PaymenntLocator/DashbordPayment/label_CVV'))
		WebUI.verifyElementPresent(findTestObject('PaymenntLocator/projectDetails/span_Please enter valid CVV.'),2)
	}

	@Keyword
	public void regPaymentCheckAddress(){
		/********************Verify for Check - check the verbiage on InstructionsUpon completing the billing form below and clicking Generate Invoice, an invoice will be generated and emailed to the bill-to-party email address listed below.Mail the invoice and check to the following address:Green Business Certification Inc.P.O. Box 822964Philadelphia, PA 19182-2964To avoid delays in processing, please write the invoice number on the check.Once GBCI receives the check, please allow 2-3 business days for processing. ******************************/
		//WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		//WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/CheckRadio'))
		WebUI.delay(3)
		String address = "InstructionsUpon completing the billing form below and clicking Generate Invoice, an invoice will be generated and emailed to your email address.Mail the invoice and check to the following address:Green Business Certification Inc.P.O. Box 822964Philadelphia, PA 19182-2964To avoid delays in processing, please write the invoice number on the check.Once GBCI receives the check, please allow 2-3 business days for processing."
		String addresscheck= address.replaceAll("\\s+","")

		String  checkAddress = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/CheckAddress'))
		String addresscheckUI= checkAddress.replaceAll("\\s+","")
		Assert.assertEquals(addresscheck,addresscheckUI)


	}

	// verify the tax on selecting the other state and uttar pradesh
	@Keyword
	public void verifyRegistrationAmountWithTaxIndia(String sheetName, int rowNum){

		String state = data.getCellData(sheetName, 'State', rowNum)
		String regAmount = data.getCellData(sheetName, 'RegAmount', rowNum)
		String taxAmount = data.getCellData(sheetName, 'IGST', rowNum)
		String subTotal = data.getCellData(sheetName, 'SubTotal', rowNum)

		if(state.equalsIgnoreCase('Uttar Pradesh')){

			//pending for uttar pradesh
		}else{

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/TotalRegistrationAmountAfterTaxIND')), regAmount + " for 5 years"  )
			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/SubTotalRegistrationAmountIND')),subTotal + " for 5 years")
			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/IGSTTaxApplicableOnSubTotalRegAmountIND')),taxAmount)

		}
	}



	@Keyword
	public void verifySezCheckBoxPresentAndClausePopUpOpens(){
		WebUI.delay(5)
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'), 10))
		Assert.assertTrue(WebUI.verifyElementClickable(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox')))
		WebUI.check(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'))
		WebUI.delay(5)
		WebUI.verifyTextPresent("Clause X: Taxes", false)
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/PaymenntLocator/SEZAgreeButton'), 10))
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/PaymenntLocator/SEZCancelButton'), 10))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/SEZCancelButton'))
		Assert.assertTrue(WebUI.verifyElementNotChecked(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'), 5))
		WebUI.delay(5)
		println WebUI.getText(findTestObject('Object Repository/PaymenntLocator/IGSTTaxApplicableOnSubTotalRegAmountIND'))
		WebUI.verifyNotMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/IGSTTaxApplicableOnSubTotalRegAmountIND')), "₹ 0.00", false)
		WebUI.delay(2)
		WebUI.uncheck(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'))
		WebUI.delay(3)
	}

	@Keyword
	public void verifyOnclickingSezCheckBoxTaxBecomeZero(){
		WebUI.delay(5)
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'), 10))
		WebUI.check(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'))
		WebUI.delay(5)
		WebUI.verifyTextPresent("Clause X: Taxes", false)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/SEZAgreeButton'))
		WebUI.delay(5)
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/IGSTTaxApplicableOnSubTotalRegAmountIND')), "₹ 0.00")
		WebUI.delay(2)
		WebUI.uncheck(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'))
		WebUI.delay(3)
	}


	@Keyword
	public void SezFileUploadAndVerifyItIsDisplaying(){
		WebUI.delay(5)
		WebUI.check(findTestObject('Object Repository/PaymenntLocator/SEZCheckBox'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/SEZAgreeButton'))
		WebUI.delay(5)
		//pdf file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadDocumentDataInput)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//text file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadTextFile)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//jpg file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadJpeg)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//png file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadPng)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//gif file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadGif)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//xls file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadXls)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)
		//doc file upload
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/ClickOnUploadButtonSEZ'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/PaymenntLocator/FileUploadSez'), UploadDocs)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.delay(5)


		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZOne')), "uploadDoc.docx", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZTwo')), "uploasExcel.xlsx", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZThree')), "uploadGif.gif", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZFour')), "uploadPng.png", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZFive')), "Parking SJ.jpg", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZSix')), "txtFileUpload.txt", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZSeven')), "USGBC.pdf", false, FailureHandling.CONTINUE_ON_FAILURE)
		println "Uploaded files are displaying"

		//delete sez file
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/DeleteSEZFile'))
		WebUI.delay(5)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/PaymenntLocator/UploadedFileSEZSeven'), 4)
		println "File deleted successfully"
	}



}




