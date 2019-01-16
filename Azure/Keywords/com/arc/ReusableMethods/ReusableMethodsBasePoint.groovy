package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.beans.decoder.FalseElementHandler
public class ReusableMethodsBasePoint extends BaseClass{

	@Keyword
	public void preRequisiteAttemptTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('PreRequisite/a_ Prerequisites'))
		//WebUI.setViewPortSize(1500,800)
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
		//WebUI.setViewPortSize(1500,800)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))

		for (int c in 0..22){

			WebUI.delay(5)
			WebUI.click(findTestObject('PreRequisite/CheckBox1'))
			WebUI.delay(5)
			WebUI.click(findTestObject('PreRequisite/button_Attempted'))
			WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
		}

		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/BasePoint/span_Site Development - Protec')),'Site Development - Protect or Restore Habitat')
	}


	@Keyword
	public void basePointOptionA() throws IOException, InterruptedException{
		WebUI.waitForElementClickable(findTestObject('BasePoint/CityCom/a_ Base Points'), 10)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(8)
		WebUI.check(findTestObject('BasePoint/CityCom/Checkbox1'))
		WebUI.delay(5)
		for(int count=2;count<=11;count++) {
			WebUI.delay(1)
			myTestObject.addProperty("xpath", ConditionType.EQUALS,"(//input[@type='checkbox'])"+[count])
			WebUI.scrollToElement(myTestObject, 2)
			WebUI.check(myTestObject)
			WebUI.delay(1)
		}
		WebUI.delay(9)
		WebUI.scrollToElement(findTestObject('BasePoint/CityCom/OptionPointA'), 5)
		String point = WebUI.getText(findTestObject('BasePoint/CityCom/OptionPointA'))
		Assert.assertEquals(point, "10", "Values doesn't matched")
	}

	@Keyword
	public void basePointOptionB(String sheetName, int rowNum) throws IOException, InterruptedException{
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "ADeatailsValueReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "ADeatailsValueReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "ADeatailsValueReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "ADeatailsValueReading4", rowNum)
		String ureading1  = data.getCellData(sheetName, "ADeatailsUnitReading1", rowNum)
		String ureading2  = data.getCellData(sheetName, "ADeatailsUnitReading2", rowNum)
		String ureading3  = data.getCellData(sheetName, "ADeatailsUnitReading3", rowNum)
		String ureading4  = data.getCellData(sheetName, "ADeatailsUnitReading4", rowNum)

		WebUI.delay(3)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(15)
		myTestObject.addProperty("xpath", ConditionType.EQUALS,"(//input[@type='checkbox'])[12]")
		WebUI.check(myTestObject)
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/ClickOptionB'))
		WebUI.delay(6)

		WebUI.delay(2)
		for(int count =1 ;count<=4;count++ ) {
			WebUI.click(findTestObject('BasePoint/CityCom/ClickDropdown'))
			WebUI.delay(2)
			WebUI.scrollToElement(findTestObject('BasePoint/CityCom/Option'+count),10)
			WebUI.delay(2)
			WebUI.click(findTestObject('BasePoint/CityCom/Option'+count))
			WebUI.click(findTestObject('BasePoint/CityCom/AddButton'))
			WebUI.delay(5)
		}

		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue1'), reading1)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit1'), ureading1)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue2'), reading2)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit2'), ureading2)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue3'), reading3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit3'), ureading3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue4'), reading4)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit4'), ureading4)
		WebUI.delay(1)

		for(int count=1;count<=4;count++) {
			WebUI.scrollToElement(findTestObject('BasePoint/CityCom/Checkbox'+count),10)
			WebUI.click(findTestObject('BasePoint/CityCom/Checkbox'+count))
			WebUI.delay(2)
			WebUI.click(findTestObject('DataInput/SaveButton'+count))
			WebUI.delay(2)
		}
		WebUI.delay(6)
		WebUI.refresh()
		WebUI.delay(15)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue1'),"value"),reading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue2'),"value"),reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue3'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue4'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit1'),"value"),ureading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit2'),"value"),ureading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit3'),"value"),ureading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit4'),"value"),ureading1,"Not Valid")
		WebUI.delay(5)
		WebUI.click(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(7)
		//WebUI.scrollToElement(findTestObject('BasePoint/CityCom/OptionPointB'), 6)
		String point = WebUI.getText(findTestObject('BasePoint/CityCom/OptionPointB'))
		WebUI.verifyMatch(point, "2", true)
	}

	@Keyword
	public void countTotalNumberOfBasePointTransit() throws IOException, InterruptedException{
		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebDriver driver  = DriverFactory.getWebDriver()
		ArrayList numberOfCount = driver.findElements(By.xpath("//span[@class = 'fw-semi-bold ng-binding']"))
		int numberOfCountSize = numberOfCount.size()

		Iterator<Integer> iterator = numberOfCountSize.iterator()

		// while loop iterating the value
		while (iterator.hasNext()) {
			int value=  iterator.next()
			String actualtotalCount= value
			WebUI.verifyMatch(actualtotalCount, '23', false)
		}


	}
	@Keyword
	public void countTotalNumberAllActionTransit() throws IOException, InterruptedException{
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'))
		WebUI.delay(8)
		WebDriver driver  = DriverFactory.getWebDriver()
		ArrayList numberOfCount = driver.findElements(By.xpath("//span[@class = 'fw-semi-bold ng-binding']"))
		int numberOfCountSize = numberOfCount.size()

		Iterator<Integer> iterator = numberOfCountSize.iterator()

		// while loop iterating the value
		while (iterator.hasNext()) {

			int value=  iterator.next()
			String actualtotalCount= value
			WebUI.verifyMatch(actualtotalCount, '38', false)
		}
	}
	@Keyword
	public void moduleCreditOtherNone() throws IOException, InterruptedException{

		WebUI.verifyElementNotPresent(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ All Actions'),2)

		WebUI.verifyElementNotPresent(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ Prerequisites'),2)

		WebUI.verifyElementNotPresent(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ My Actions'),2)

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 2)

		WebUI.verifyElementPresent(findTestObject('DataInput/Survey/a_ Data Input'),2)

		WebUI.verifyElementPresent(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_ Review'),2)



	}
	@Keyword
	public void basePromptMessageAttemptedToReadyForReview(){

		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))
		WebUI.delay(5)

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(5)

		String promptText = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/BaseScorePromptText'))
		String promptText1 = promptText.replaceAll("\\s+","")
		String actulText = "This credit will automatically display in your base score, but will have to undergo review by GBCI before being awarded."
		String actulText1= actulText.replaceAll("\\s+","")
		WebUI.verifyMatch(promptText1, promptText1, false)

		WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
		WebUI.delay(5)

	}
	@Keyword
	public void basePromptMessageReadyForReviewtoAttempted(){

		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))
		WebUI.delay(5)

		WebUI.click(findTestObject('PaymenntLocator/projectDetails/span_Ready for Review'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PaymenntLocator/projectDetails/a_Attempted'))
		WebUI.delay(3)

		String promptText = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/BaseScorePromptText'))
		String promptText1 = promptText.replaceAll("\\s+","")
		String actulText = "This credit will automatically display in your base score, but will have to undergo review by GBCI before being awarded."
		String actulText1= actulText.replaceAll("\\s+","")
		WebUI.verifyMatch(promptText1, promptText1, false)

		WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
		WebUI.delay(10)
		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(10)

	}
	@Keyword
	public void basePointTotalScoreTest(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))*/
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/BasePoint/BasePoint'),20)
		WebUI.delay(10)
		String basepointScore = WebUI.getText(findTestObject('Object Repository/BasePoint/BasePoint'))
		WebUI.verifyMatch(basepointScore ,'10', false)
	}


	@Keyword
	public void basePointResourceNaviagionTest(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 */
		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 10)
		WebUI.doubleClick(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/span_Purchasing - ongoing'))
		WebUI.delay(5)

		WebUI.click(findTestObject('PaymenntLocator/projectDetails/a_Resources'))
		WebUI.delay(5)

		WebUI.switchToWindowIndex(1)
		WebUI.delay(10)
		String projectRegistration = WebUI.getText(findTestObject('PaymenntLocator/projectDetails/h2_LEED v4 OM performance path'))
		WebUI.delay(1)
		WebUI.verifyMatch(projectRegistration,'LEED v4 O+M performance path resources',false)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)

	}
	@Keyword
	public void basePointCreditLibraryNaviagionTest(){

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 */
		WebUI.scrollToElement(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'), 2)
		WebUI.click(findTestObject('Object Repository/BasePoint/a_ Base Points (1)'))
		WebUI.delay(8)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/span_Purchasing - ongoing'))
		WebUI.delay(5)

		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/NavigationCreditAction/a_Credit Library'))
		WebUI.delay(5)

		WebUI.switchToWindowIndex(1)
		WebUI.delay(10)
		String projectRegistration = WebUI.getText(findTestObject('BasePoint/BasePointCreditCom/CreditSitemanagementpolicy'))
		WebUI.delay(1)
		WebUI.verifyMatch(projectRegistration,'Purchasing - ongoing',false)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)

	}
}