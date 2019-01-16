package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.math.RoundingMode
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert
import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ReusableMethodsDataInput  extends BaseClass{
	WebDriver driver  = DriverFactory.getWebDriver()
	public static Robot robot = new Robot()
	@Keyword
	public void uploadArcDataTemplate(){
		//WebUI.delay(11)

		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))

		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		//WebUI.click(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'))
		//WebUI.delay(4)
		//uploadFile(UploadArcDataTemplete)
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/ClickToUploadFileButton'))
		WebUI.delay(5)
		//clickCancel()
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	//Verify the default units displayed on the Graphs y-axis

	@Keyword
	public void verifyGraphDefaultUnitsPresentOnXAxis(){

	}

	@Keyword
	public void uploadArcDataTemplateBuildingAnalytics(){
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(15)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(2)
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/span_Upload.XLS'), 20)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.analyticsUploadArcDataTemplete )
		//WebUI.click(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'))
		//WebUI.delay(4)
		//uploadFile(analyticsUploadArcDataTemplete)
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/ClickToUploadFileButton'))
		WebUI.delay(5)
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.delay(17)
		/*WebUI.refresh()
		 WebUI.delay(10)*/
	}

	@Keyword
	public void uploadArcDataTemplateTransit(){
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(15)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.UploadArcDataTempleteTransit)
		//WebUI.click(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'))
		//WebUI.delay(4)
		//uploadFile(UploadArcDataTempleteTransit)
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/ClickToUploadFileButton'))
		WebUI.delay(5)
		//clickCancel()
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	@Keyword
	public void uploadArcDataTemplateTransitAboveAnalytics(){
		WebUI.refresh()
		WebUI.delay(15)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(15)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(5)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		//WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.UploadArcDataTempleteTransitanalytics)
		WebUI.click(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'))
		WebUI.delay(4)
		uploadFile(UploadArcDataTempleteTransitanalytics)
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/ClickToUploadFileButton'))
		WebUI.delay(5)
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.delay(17)

	}

	@Keyword
	public void uploadArcDataTemplateTransitBelow(){
		//WebUI.delay(11)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(5)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.UploadArcDataTempleteTransitBelow)
		//WebUI.click(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'))
		//WebUI.delay(4)
		//uploadFile(UploadArcDataTempleteTransitBelow)
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/ClickToUploadFileButton'))
		WebUI.delay(5)
		//clickCancel()
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}



	//should be place after waste generation data input
	@Keyword
	public void verifyErrorWasteDivertedGreaterThanWasteGeneration(){

		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingOne'), '800')
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingOne'), '1000')
		WebUI.delay(4)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickToSaveWasteReading'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/CreateMeterBuilding/VerifyWasteErrorMessage'))
		println "Waste Diverted greater than Waste Genereted"

	}

	//verify the excel upload data for energy meter
	@Keyword
	public void verifyEnergyReadingUploadedViaExcel(String sheetName, int rowNum){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/ClickOnEnergyMeterCreatedViaExcel'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Energy Meter via upload", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		int j=2
		(1..12).each{
			String date1 = dataExcelTemplate.getCellData(sheetName, "Start", j)
			String date2 = dataExcelTemplate.getCellData(sheetName, "End", j)
			String reading = dataExcelTemplate.getCellData(sheetName, "Reading1", j)

			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/StartDateOne',[index: it]),'value'), date1)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/EndDateOne',[index: it]),'value'),date2)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/ReadingOne',[index: it]),'value'),reading)
			j++
		}
	}

	@Keyword
	public void verifyWaterReadingUploadedViaExcel(String sheetName, int rowNum){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/ClickOnWaterMeterCreatedViaExcel'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water meter via upload", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)

		int j=2
		(1..12).each{
			String date1 = dataExcelTemplate.getCellData(sheetName, "Start", j)
			String date2 = dataExcelTemplate.getCellData(sheetName, "End", j)
			String reading = dataExcelTemplate.getCellData(sheetName, "Reading1", j)

			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/StartDateOne',[index: it]),'value'), date1)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/EndDateOne',[index: it]),'value'),date2)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/ReadingOne',[index: it]),'value'),reading)
			j++
		}
		//verify document tab is available under data input section
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/DocumentTab'))
		WebUI.delay(3)
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/UploadButtonInDocumentTab')))

	}


	public String currentTime() throws IOException, InterruptedException {
		Calendar cal = Calendar.getInstance()
		Date date=cal.getTime()
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a")
		String formattedDate=dateFormat.format(date)
	}

	public static String verifyBillingDate() throws IOException, InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY")
		LocalDateTime now = LocalDateTime.now()
		return dtf.format(now)
		System.out.println(dtf.format(now))
	}

	@Keyword
	public void verifyWasteReadingUploadedViaExcel(String sheetName, int rowNum){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Waste Data", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(6)
		int j=2
		(1..11).each{
			String date1 = dataExcelTemplate.getCellData(sheetName, "Start", j)
			String date2 = dataExcelTemplate.getCellData(sheetName, "End", j)
			String reading1 = dataExcelTemplate.getCellData(sheetName, "Reading1", j)
			String reading2 = dataExcelTemplate.getCellData(sheetName, "Reading2", j)


			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/StartDateOne',[index: it]),'value'), date1)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/EndDateOne',[index: it]),'value'),date2)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/WGReadingOne',[index: it]),'value'),reading1)
			Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/DataInputExcelUploadDataVerification/WDReadingOne',[index: it]),'value'),reading2)
			j++
		}
		//verify document tab is available under data input section
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/DocumentTab'))
		WebUI.delay(3)
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/UploadButtonInDocumentTab')))

	}

	@Keyword
	public void verifyWasteGraphpopulatedAfterExcelUpload(String sheetName){
		/*WebUI.delay(15)
		 WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		 */WebUI.delay(4)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Waste Data", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/Graphs/WasteMeterUnitDisplayedOnGraph')), "lbs", false)
		int j=13
		(1..12).each{
			String reading1 = dataExcelTemplate.getCellData(sheetName, "Reading2", j)
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/WasteDivertedGraph',[index: it]))
			String[] reading=WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).split(" ")
			WebUI.verifyMatch(reading[0], reading1, false, FailureHandling.CONTINUE_ON_FAILURE)
			//Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).contains(reading1))
			WebUI.delay(2)
			j--
		}

	}

	public void getGraphReading(String sheetName){
		int j=14
		(1..13).each{

			String reading1 = dataExcelTemplate.getCellData(sheetName, "Reading1", j)
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/WasteGeneratedGraph',[index: it]))
			String[] reading=WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).split(" ")
			WebUI.verifyMatch(reading[0], reading1, false, FailureHandling.CONTINUE_ON_FAILURE)
			//WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).contains(reading1))
			WebUI.delay(2)
			j--
		}
	}

	public void getGraphReading(String sheetName, String colName){
		int j=13
		(1..12).each{

			String reading1 = dataExcelTemplate.getCellData(sheetName, colName, j)
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/WasteGeneratedGraph',[index: it]))
			String[] reading=WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).split(" ")
			WebUI.verifyMatch(reading[0], reading1, false, FailureHandling.CONTINUE_ON_FAILURE)
			//Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph')).contains(reading1))
			WebUI.delay(2)
			j--
		}
	}

	@Keyword
	public void verifyEnergyGraphpopulatedAfterExcelUpload(String sheetName){
		//WebUI.delay(15)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(10)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EnergyMeterViaFileUpload'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Energy Meter via upload", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/Graphs/EnergyMeterUnitDisplayedOnGraph')),"kBtu" , false)
		getGraphReading(sheetName, "Reading1")

	}


	@Keyword
	public void verifyWaterGraphpopulatedAfterExcelUpload(String sheetName){
		//WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(4)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/WaterMeterViaFileUpload'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water meter via upload", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/Graphs/WaterMeterUnitDisplayedOnGraph')), "gal", false)
		getGraphReading(sheetName, "Reading1")

	}

	@Keyword
	public void verifyHumanCo2BuildingGraphpopulatedAfterExcelUpload(String sheetName, int rowNum){
		//WebUI.refresh()
		//WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickOccupantSatisfaction'))
		WebUI.delay(10)
		String people = dataExcelTemplate.getCellData(sheetName,"SurveyTransportation", rowNum)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Occupant Satisfaction Survey", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'))
		WebUI.delay(6)
		WebUI.focus(findTestObject('Object Repository/DataInput/Survey/MonthlySurveyGraph'))
		Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportResponseToolTip')).contains(people))
		WebUI.delay(2)
		WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/SatisfactionGraphHE'))
		Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/OccupantSurveyTooltip')).contains("5"))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Carbon Dioxide", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"Reading2")
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Total Volatile Organic Compounds", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"Reading1")

	}


	@Keyword
	public void verifyHumanCo2BuildingTransitGraphpopulatedAfterExcelUpload(String sheetName, int rowNum){
		WebUI.refresh()
		WebUI.delay(12)
		/*WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		 WebUI.delay(4)*/
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickOccupantSatisfaction'))
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(6)
		String people = dataExcelTemplate.getCellData(sheetName,"SurveyTransportation", rowNum)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Occupant Satisfaction Survey", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'))
		WebUI.delay(6)
		WebUI.focus(findTestObject('Object Repository/DataInput/Survey/MonthlySurveyGraph'))
		/*Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportResponseToolTip')).contains(people))
		 WebUI.delay(2)*/
		WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/SatisfactionGraphHE'))
		Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/OccupantSurveyTooltip')).contains("5"))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/HumanExperienceTransit/PM2.5'))
		WebUI.delay(6)
		//WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Air Quality Index", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"HETransit")
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/HumanExperienceTransit/PM10'))
		WebUI.delay(6)
		//WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Air Quality Index", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"HETransit")
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ozone'))
		WebUI.delay(6)
		//WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Air Quality Index", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"HETransit")
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Air Quality Index'))
		WebUI.delay(6)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Air Quality Index", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		getGraphReading(sheetName,"HETransit")
	}



	@Keyword
	public void verifyTransportationGraphpopulatedAfterExcelUpload(String sheetName, int rowNum){
		/*//WebUI.refresh()
		 WebUI.delay(15)
		 WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		 WebUI.delay(4)*/
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/Survey/div_Transportation Survey'))
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Transportation Survey", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'))
		String people = dataExcelTemplate.getCellData(sheetName,"SurveyTransportation", rowNum)
		WebUI.delay(2)
		WebUI.focus(findTestObject('Object Repository/DataInput/Survey/MonthlySurveyGraph'))
		Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportResponseToolTip')).contains("4"))
		WebUI.delay(2)
		int j=2
		(1..3).each{
			String reading1 = dataExcelTemplate.getCellData(sheetName,"Transportation", j)
			//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationGraph',[index: it]), 4)
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationGraph',[index: it]), FailureHandling.CONTINUE_ON_FAILURE)
			String reading=WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationSurveyToolTip'))
			WebUI.verifyMatch(reading, reading1, false, FailureHandling.CONTINUE_ON_FAILURE)
			//Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationSurveyToolTip')).contains(reading1))
			WebUI.delay(2)
			j++

		}

		int k=6
		for(int index = 5; index <=7; ){
			String reading1 = dataExcelTemplate.getCellData(sheetName,"Transportation", k)
			//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationGraph',[index: it]), 4)
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationGraph',[index: index]), FailureHandling.CONTINUE_ON_FAILURE)
			String reading=WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationSurveyToolTip'))
			WebUI.verifyMatch(reading, reading1, false, FailureHandling.CONTINUE_ON_FAILURE)
			//Assert.assertTrue(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TransportationSurveyToolTip')).contains(reading1))
			WebUI.delay(2)
			k++
			index ++
		}

	}

	@Keyword
	public void verifyDocumentTabFileUploadFunctionality(String sheetName, int rowNum){

		//WebUI.delay(18)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Waste Data", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(4)
		uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadDocumentDataInput)
		//verify document tab is available under data input section
		WebUI.click(findTestObject('Object Repository/DataInput/DocumentTab'))
		WebUI.delay(3)
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/UploadButtonInDocumentTab')))
		WebUI.click(findTestObject('Object Repository/DataInput/UploadButtonInDocumentTab'))
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/Document/ButtonUploadViaDropbox')))
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/Document/ButtonUploadViaGoogleDrive')))
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/Document/ButtonUploadViaOneDrive')))
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/DataInput/ClickOnCompterFileToSelectFile')))
		WebUI.click(findTestObject('Object Repository/DataInput/ClickOnCompterFileToSelectFile'))
		WebUI.delay(4)
		uploadFile(UploadGif)
		//WebUI.sendKeys(findTestObject('Object Repository/DataInput/SendFileToUpload'), UploadGif)
		WebUI.delay(4)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/DocumentNameOne')), 'uploadGif.gif')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/DocumentNameTwo')), 'USGBC.pdf')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/MeterOrCreditOne')), 'Waste')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/MeterOrCreditTwo')), 'Waste Data')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/ReadingOne')), 'N/A')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/ReadingTwo')), 'May 02, 2017 - Jun 02, 2017')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/UploadedByOne')), GlobalVariable.teamMemName)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/UploadedByTwo')), GlobalVariable.teamMemName)
		String date1 = WebUI.getText(findTestObject('Object Repository/DataInput/Document/UploadedOnOne'))
		String modDate1 = date1.substring(0, date1.indexOf("at"))
		Assert.assertEquals(modDate1.trim(), verifyBillingDate())
		String date2 = WebUI.getText(findTestObject('Object Repository/DataInput/Document/UploadedOnTwo'))
		String modDate2 = date2.substring(0, date2.indexOf("at"))
		Assert.assertEquals(modDate2.trim(), verifyBillingDate())
	}


	//should be placed just after after waste generation
	@Keyword
	public void verifyFilterDataInput(){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Waste Data", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/ClickFilter'))
		WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/FilterStartDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/ClickFilter'))
		WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/FilterEndDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		//WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/ClickFilter'))
		WebUI.click(findTestObject('Object Repository/DataInput/CheckFilter/FilterUpdate'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingOne'),'value'),'800')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingOne'),'value'),'300')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterStartDate'), 'value'),"May 02, 2017")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'), 'value'), "Jun 02, 2017")
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingTwo'), 5, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public void editMeterReading(String sheetName, int rowNum){
		String reading4  = data.getCellData(sheetName, "Reading4", rowNum)

		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/EnergyFileUploadTestMeter'))
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Test Energy Meter New", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(8)
		//edit reading one
		//WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterStartDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterStartDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_3'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_3'))
		WebUI.delay(3)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickToSaveEditedMeterReading'),3)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickToSaveEditedMeterReading'))
		//WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_11'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_11'))
		WebUI.delay(3)
		//WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterReadingtextBox'))
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterReadingtextBox'), reading4)
		WebUI.delay(3)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'))
		WebUI.refresh()
		WebUI.delay(15)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading4)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterStartDate'), 'value'),"May 03, 2018")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterEndDatePicker'), 'value'), "Jun 11, 2018")


	}


	@Keyword
	public void uploadCreditFormTest(){

		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/span_Upload .XLS'),10)
		WebUI.doubleClick(findTestObject('DataInput/CityCom/span_Upload .XLS'))
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),10)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		WebUI.click(findTestObject('DataInput/CityCom/ClickToUploadFileButton'))
		WebUI.delay(5)
		clickCancel()
		String successmessage= WebUI.getText(findTestObject('DataInput/p_Excel submitted successfully'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when you data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	@Keyword
	public void fileUploadDataInput(){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/EnergyFileUploadTestMeter'))
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Test Energy Meter'))
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Test Energy Meter", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
		////pdf file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadDocumentDataInput)
		//text file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadTextFile)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadTextFile)
		//jpg file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadJpeg)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadJpeg)
		//Png file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadPng)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadPng)
		//gif file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadGif)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadGif)
		//xls file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadXls)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadXls)
		//doc file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadDocs)
		//duplicate doc file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)
		//WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadDocs)
		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/NoOfFiles'))
		//WebUI.delay(5)
		/*String fileName1= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentOne'))
		 String fileName2= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTwo'))
		 String fileName3= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentThree'))
		 String fileName4= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFour'))
		 String fileName5= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFive'))
		 String fileName6= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSix'))
		 String fileName7= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSeven'))
		 String fileName8= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentEight'))
		 WebUI.verifyTextPresent(fileName1, true)
		 WebUI.verifyTextPresent(fileName2, true)
		 WebUI.verifyTextPresent(fileName3, true)
		 WebUI.verifyTextPresent(fileName4, true)
		 WebUI.verifyTextPresent(fileName5, true)
		 WebUI.verifyTextPresent(fileName6, true)
		 WebUI.verifyTextPresent(fileName7, true)
		 WebUI.verifyTextPresent(fileName8, true)
		 */
	}


	@Keyword
	public void creditFileUploadTransit(){
		/*WebUI.delay(7)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickOnPreRequisite'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/PreRequisiteTransitFirstCredit'))

		for(int i= 0;i<10;i++){
			WebUI.delay(5)
			if(i==0){
				//pdf upload
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadDocumentDataInput)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 1]), 6)
				WebUI.delay(3)
				//textfile
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadTextFile)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 2]), 6)
				WebUI.delay(3)
				//jpg upload
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadJpeg)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 3]), 6)
				WebUI.delay(3)
				//upload png
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadPng)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 4]), 6)
				WebUI.delay(3)
				//upload gif
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadGif)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 5]), 6)
				WebUI.delay(3)
				//upload xls
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadXls)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 6]), 6)
				WebUI.delay(3)
				//upload docs
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadDocs)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 7]), 6)
				WebUI.delay(3)
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/NextButtonCredit'))

			}
			else{
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
				WebUI.delay(2)
				uploadFile(UploadDocumentDataInput)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 1]), 6)
				WebUI.delay(3)
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/NextButtonCredit'))
			}
		}

		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/BasePointSideBar'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/BasePointTransitFirstCredit'))
		for(int i=0; i<23;i++){
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickButtonToUpload'))
			WebUI.delay(2)
			uploadFile(UploadDocumentDataInput)
			WebUI.delay(4)
			WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButton',[index: 1]), 6)
			WebUI.delay(3)
			WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/NextButtonCredit'))
		}

	}


	@Keyword
	public void creditFileUploadCityComm(){

		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/AllActions'))

		WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickOnFirstCreditCityComm'))
		for(int i=0; i<12; i++){
			WebUI.delay(5)
			if((i==0)){
				//pdf upload
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadDocumentDataInput)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 1]), 6)
				WebUI.delay(3)
				//text file
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadTextFile)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 2]), 6)
				WebUI.delay(3)
				//jpeg
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadJpeg)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 3]), 6)
				WebUI.delay(3)
				//png
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadPng)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 4]), 6)
				WebUI.delay(3)
				//gif
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadGif)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 5]), 6)
				WebUI.delay(3)
				//xls
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadXls)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 6]), 6)
				WebUI.delay(3)
				//docs
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadDocs)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 7]), 6)
				WebUI.delay(3)
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/NextButtonCredit'))
				WebUI.delay(5)
				WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CreditFileupload/ProjectBoundayTextSpan'), 20, FailureHandling.STOP_ON_FAILURE)

			}
			else{
				WebUI.delay(5)
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/ClickToUploadCityComm'))
				WebUI.delay(2)
				uploadFile(UploadDocumentDataInput)
				WebUI.delay(4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/DataInput/CreditFileupload/DeleteButtonCityComm',[index: 1]), 6)
				WebUI.delay(6)
				WebUI.click(findTestObject('Object Repository/DataInput/CreditFileupload/NextButtonCredit'))
			}
		}
	}

	@Keyword
	public void fileUploadDataInputHumanExperience(){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Carbon Dioxide', FailureHandling.STOP_ON_FAILURE)
		////pdf file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		//text file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadTextFile)
		WebUI.delay(4)
		//jpg file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadJpeg)
		WebUI.delay(4)
		//Png file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadPng)
		WebUI.delay(4)
		//gif file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadGif)
		WebUI.delay(4)
		//xls file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadXls)
		WebUI.delay(4)
		//doc file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)
		//duplicate doc file
		WebUI.scrollToElement(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'),3)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)

		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/NoOfFiles'))
		//WebUI.delay(3)
		/*String fileName1= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentOne'))
		 String fileName2= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTwo'))
		 String fileName3= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentThree'))
		 String fileName4= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFour'))
		 String fileName5= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFive'))
		 String fileName6= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSix'))
		 String fileName7= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSeven'))
		 String fileName8= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentEight'))
		 WebUI.verifyTextPresent(fileName1, false)
		 WebUI.verifyTextPresent(fileName2, false)
		 WebUI.verifyTextPresent(fileName3, false)
		 WebUI.verifyTextPresent(fileName4, false)
		 WebUI.verifyTextPresent(fileName5, false)
		 WebUI.verifyTextPresent(fileName6, false)
		 WebUI.verifyTextPresent(fileName7, false)
		 WebUI.verifyTextPresent(fileName8, false)*/

	}


	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null)
	}

	public static void uploadFile(String fileLocation) {
		try {
			//Setting clipboard with file location
			setClipboardData(fileLocation)
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot()
			robot.keyPress(KeyEvent.VK_CONTROL)
			robot.keyPress(KeyEvent.VK_V)
			robot.keyRelease(KeyEvent.VK_V)
			robot.keyRelease(KeyEvent.VK_CONTROL)
			WebUI.delay(3)
			robot.keyPress(KeyEvent.VK_ENTER)
			robot.keyRelease(KeyEvent.VK_ENTER)
			WebUI.delay(1)
			/*
			 robot.keyPress(KeyEvent.VK_ENTER)
			 robot.keyRelease(KeyEvent.VK_ENTER)*/
		} catch (Exception exp) {
			exp.printStackTrace()
		}
	}




	@Keyword
	public void fileUploadDataInputWater(){
		//WebUI.delay(18)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'), 3)
		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/WaterFileUplaodMeterTest'))
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'))
		WebUI.delay(5)
		//pdf file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		//text file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadTextFile)
		WebUI.delay(4)
		//jpg file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadJpeg)
		WebUI.delay(4)
		//Png file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadPng)
		WebUI.delay(4)
		//gif file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadGif)
		WebUI.delay(4)
		//xls file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadXls)
		WebUI.delay(2)
		//doc file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)
		/*WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/NoOfFiles'))
		 WebUI.delay(8)
		 String fileName1= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentOne'))
		 String fileName2= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTwo'))
		 String fileName3= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentThree'))
		 String fileName4= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFour'))
		 String fileName5= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFive'))
		 String fileName6= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSix'))
		 String fileName7= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSeven'))*/
		/*WebUI.verifyTextPresent(fileName1, true)
		 WebUI.verifyTextPresent(fileName2, true)
		 WebUI.verifyTextPresent(fileName3, true)
		 WebUI.verifyTextPresent(fileName4, true)
		 WebUI.verifyTextPresent(fileName5, true)
		 WebUI.verifyTextPresent(fileName6, true)
		 WebUI.verifyTextPresent(fileName7, true)*/
	}


	@Keyword
	public void fileUploadDataInputWaste(){
		//WebUI.delay(18)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'), 3)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(5)
		//pdf file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocumentDataInput)
		WebUI.delay(4)
		//text file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadTextFile)
		WebUI.delay(4)
		//jpg file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadJpeg)
		WebUI.delay(4)
		//Png file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		uploadFile(UploadPng)
		WebUI.delay(4)
		//gif file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadGif)
		WebUI.delay(4)
		//xls file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadXls)
		WebUI.delay(4)
		//doc file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.delay(2)
		uploadFile(UploadDocs)
		WebUI.delay(4)
		/*WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/NoOfFiles'))
		 WebUI.delay(5)
		 String fileName1= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentOne'))
		 String fileName2= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTwo'))
		 String fileName3= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentThree'))
		 String fileName4= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFour'))
		 String fileName5= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFive'))
		 String fileName6= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSix'))
		 String fileName7= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSeven'))
		 Assert.assertEquals(fileName1,"USGBC.pdf")
		 Assert.assertEquals(fileName2,"txtFileUpload.txt")
		 Assert.assertEquals(fileName3,"Parking SJ.jpg")
		 Assert.assertEquals(fileName4,"uploadPng.png")
		 Assert.assertEquals(fileName5,"uploadGif.gif")
		 Assert.assertEquals(fileName6,"uploasExcel.xlsx")
		 Assert.assertEquals(fileName7,"uploadDoc.docx")*/
	}


	@Keyword
	public void fileUploadDataInputWasteViaCloud(){
		//WebUI.delay(18)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'), 3)

		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(5)
		//upload files via google drive
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD_delete'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/div_Google Drive'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_identifier'), "testarcupload@gmail.com")
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/content_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_password'), "initpass")
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/span_Next'))
		WebUI.switchToWindowIndex(0)
		WebUI.delay(5)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/GoogleDrive.pdf'))
		//WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/ClickOnSelectGoogleDriveFile'))
		WebUI.delay(5)
		//upload files via one drive
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD_delete'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/div_OneDrive'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveUserId'),"testarcupload@gmail.com")
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveNextButton'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDrivePassword'), "initpass123")
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveNextButton'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveClickDocuments'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveSelectFile'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveClickOpenButton'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(0)
		WebUI.delay(10)
		/*//upload via google drive
		 WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD_delete'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/div_Google Drive'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(1)
		 WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_identifier'), "testarcupload@gmail.com")
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/content_Next'))
		 WebUI.delay(3)
		 WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_password'), "initpass")
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/span_Next'))
		 WebUI.switchToWindowIndex(0)
		 WebUI.delay(5)
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/GoogleDrive.pdf'))
		 //WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/ClickOnSelectGoogleDriveFile'))
		 WebUI.delay(5)
		 //upload files via one drive
		 WebUI.doubleClick(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD_delete'))
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/div_OneDrive'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(1)
		 WebUI.delay(5)
		 WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveUserId'),"testarcupload@gmail.com")
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveNextButton'))
		 WebUI.delay(3)
		 WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDrivePassword'), "initpass123")
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveNextButton'))
		 WebUI.delay(5)
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveClickDocuments'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveSelectFile'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/OneDriveClickOpenButton'))
		 WebUI.delay(5)
		 WebUI.switchToWindowIndex(0)
		 WebUI.delay(10)*/
		//Dropbox file upload file
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD_delete'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/div_Dropbox'))
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_login_email'),"testarcupload@gmail.com")
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/input_login_password'), "initpass")
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/ButtonSignInContinue'))
		WebUI.delay(3)
		WebUI.check(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/CheckDropboxDocumentToUpload'))
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadFilesViaCloud/ClickOnChooseButton'))
		WebUI.switchToWindowIndex(0)
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/ClickOnNoOfFilesTen'))
		WebUI.delay(5)
		String fileName1= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentOne'))
		String fileName2= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTwo'))
		String fileName3= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentThree'))
		String fileName4= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFour'))
		String fileName5= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentFive'))
		String fileName6= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSix'))
		String fileName7= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentSeven'))
		String fileName8= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentEight'))
		String fileName9= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentNine'))
		String fileName10= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/UploadDocumentTen'))
		Assert.assertEquals(fileName1,"USGBC.pdf")
		Assert.assertEquals(fileName2,"txtFileUpload.txt")
		Assert.assertEquals(fileName3,"Parking SJ.jpg")
		Assert.assertEquals(fileName4,"uploadPng.png")
		Assert.assertEquals(fileName5,"uploadGif.gif")
		Assert.assertEquals(fileName6,"uploasExcel.xlsx")
		Assert.assertEquals(fileName7,"uploadDoc.docx")
		Assert.assertEquals(fileName8,"GoogleDrive.pdf")
		Assert.assertEquals(fileName9,"OneDrive.pdf")
		Assert.assertEquals(fileName10,"DropBox.pdf")
	}





	public boolean isFileDownloaded(String fileName){

		boolean flag = false
		File dir = new File(downloadPath)
		File[] dir_contents = dir.listFiles()
		println('Total Files Available in the folder are : ' + dir_contents.length)
		for (int i = 0; i < dir_contents.length; i++) {
			println('File Name at '+ i +' is : ' + dir_contents[i].getName())
			if (dir_contents[i].getName().equals(fileName)) {
				return flag = true
			}
		}
		return flag
	}


	public boolean isFileExtracted(String fileName){

		boolean flag = false
		File dir = new File(UnzippedNewFolder)
		File[] dir_contents = dir.listFiles()
		println('Total Files Available in the folder are : ' + dir_contents.length)
		for (int i = 0; i < dir_contents.length; i++) {
			println('File Name at '+ i +' is : ' + dir_contents[i].getName())
			if (dir_contents[i].getName().equals(fileName)) {
				return flag = true
			}
		}
		return flag
	}

	@Keyword
	public static void clickCancel(){
		WebUI.delay(2)

		robot.keyPress(KeyEvent.VK_C)
		robot.keyRelease(KeyEvent.VK_C)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	//Add New Meter having fields(meter type, unit type, Fuel source)

	@Keyword
	public void newMeterBuidingFieldVerification(){
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'))
		WebUI.delay(3)
		//WebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'),3)
		WebUI.verifyElementPresent(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/UnitDropdown'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/FuelSourceDropdown'), 3)
		println "Add New Meter Fields are visible"
	}

	//Add new meter default fuel type
	@Keyword
	public void addNewMeterBuildingDefaultfuelType(){

		//WebUI.delay(3)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'))
		WebUI.delay(3)
		//WebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		//default fuel type electricity
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		Assert.assertEquals("Purchased from Grid", WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/FuelSourceDropdown')))
		WebUI.delay(2)
		//default fuel type water
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		Assert.assertEquals("Municipality supplied potable water", WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/FuelSourceDropdown')))
		WebUI.delay(2)
		//default fuel type other fuel
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Other Fuels'))
		Assert.assertEquals("Natural Gas", WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/FuelSourceDropdown')))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CancelButtonCreateMeter'))
	}


	//check the performance credits City / Community

	@Keyword
	public void performanceCreditVisibilityCityComm(){
		def String[] performCredits = ['Energy', 'Water', 'Waste', 'Transportation', 'Human Experience', 'Additional Data']
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebDriver driver= DriverFactory.getWebDriver()
		By performanceCredit = By.xpath('//table[@class="table table-striped table-hover"]/tbody/tr')
		List<WebElement> credits= driver.findElements(performanceCredit)
		credits.size()
		println credits.size()
		int i=0
		for (credit in credits) {
			if(i==6)
				break
			println credit.getText()
			Assert.assertTrue(credit.getText().equalsIgnoreCase(performCredits[i]))

			i++
		}

	}


	//performance credit building
	@Keyword
	public void performanceCreditBuilding(){
		//WebUI.delay(18)
		def String[] performCredits = ['Waste', 'Transportation', 'Human Experience']
		Assert.assertEquals('Waste',  WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/BuildingWasteCredit')))
		Assert.assertEquals('Transportation', WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/BuildingTransportationCredit')))
		Assert.assertEquals('Human Experience', WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/BuildingHumanExperienceCredit')))

	}

	//(78) Delete meter reading building energy and water meter

	@Keyword
	public void deleteEnergyAndWaterMeterReadingBuilding(){
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(15)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'))
		WebUI.delay(5)
		for (int c in 1..3){
			WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeletereadingOne'))
			println "Reading "+ c +" Deleted"
			WebUI.delay(4)
		}
		Assert.assertTrue(WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'), 3))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeterNew'))
		WebUI.delay(5)
		for (int c in 1..3){
			WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeletereadingOne'))
			println "Reading "+ c +" Deleted"
			WebUI.delay(4)
		}
		Assert.assertTrue(WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'), 3))
	}


	//Delete city-community energy and water meter readings
	@Keyword
	public void deleteEnergyAndWaterMeterReadingCityComm(){
		//delete energy reading
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeleteCityCommReading'), 2)
		for (int c in 1..5){
			WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeleteCityCommReading'))
			println "Reading "+ c +" Deleted"
			WebUI.delay(10)
		}
		Assert.assertTrue(WebUI.verifyElementNotPresent(findTestObject('DataInput/CityCom/TextboxValue1'),3))

		//delete water reading
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/span_Water'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeleteCityCommReading'), 2)
		for (int c in 1..5){
			WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DeleteCityCommReading'))
			println "Reading "+ c +" Deleted"
			WebUI.delay(10)
		}
		Assert.assertTrue(WebUI.verifyElementNotPresent(findTestObject('DataInput/CityCom/TextboxValue1'),3))
	}



	@Keyword
	public void verifyTheCommentAndActivity() {
		//WebUI.delay(15)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeter'), 3)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeter'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/Activity/CommentBox'),"This is test comment")
		WebUI.click(findTestObject('Object Repository/DataInput/Activity/PostButton'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/Activity/ClickOnReply'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/Activity/ClickOnReply'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/Activity/ReplyTextBox'), "This is test reply")
		WebUI.click(findTestObject('Object Repository/DataInput/Activity/ReplyButton'))
		WebUI.delay(5)
		//verify the Comments
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Activity/GetTheCommentPosted')),'This is test comment')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Activity/GetUserCommented')),GlobalVariable.teamMemName)
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Activity/GetTheCommentTimeStamp'),5))
		//verify the reply
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Activity/GetUserReplied')),GlobalVariable.teamMemName)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Activity/GetReply')),'This is test reply')
		Assert.assertTrue(WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Activity/GetTheReplyTimeStamp'),5))
		printf "Comment and reply verified successfully "
	}


	@Keyword
	public void editEnergyMeterBuilding(){
		//WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeter'), 3)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeter'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterName'), "Test Energy Meter New")
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.delay(10)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditUnit'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/Select_mWh'))
		//WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/Document/ScorePopup'), 20)
		WebUI.delay(15)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditFuelSource'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/Select_GeneratedOnsiteSolar'))
		WebUI.delay(6)
		WebUI.refresh()
		WebUI.delay(15)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterName'),'value'),"Test Energy Meter New")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditUnit')), "MWh")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditFuelSource')), "Generated onsite - solar")
		WebUI.click(findTestObject('Object Repository/DataInput/Document/DataTabDataInput'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/Document/ReadingUnitDisplayDataInput')), 'READING (MWh)')
	}



	@Keyword
	public void editWaterMeterBuilding(){
		//WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'), 3)
		WebUI.delay(4)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterName'), "Test Water Meter New")
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterDetails'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditUnit'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/Water_kGal'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditFuelSource'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MunicipalitySuppliedReclaimWater'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditMeterName'),'value'),"Test Water Meter New")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditUnit')), "kGal")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/EditFuelSource')), "Municipality supplied reclaimed water")
	}


	@Keyword
	public void createEnergyMeterInternational(String sheetName, String sheetName1, int rowNum){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum)
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum)
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum)
		String meterName=  data.getCellData(sheetName, "MeterName", rowNum)


		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(5)
		ReusableMethodsLogin.waitForIframeLoad(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		WebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 5)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), meterName)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/NoReadingTextValidation'), 3, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DetailsTab'))
		WebUI.delay(5)
		(1..2).each{
			WebUI.focus(findTestObject('Object Repository/DataInput/CreateMeterBuilding/WasteGeneratedGraph',[index: it]))
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ToolTipGraph'),2)
		}
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/DataTabDataInput'))
		WebUI.delay(2)
		//reading one

		//WebUI.delay(8)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), meterName, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 5)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two

		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3

		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Nov'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Nov'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(15)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickOnInternationalMeter'), 3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ClickOnInternationalMeter'))
		WebUI.delay(4)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)

	}


	@Keyword
	public void createEnergyMeterWithDifferentUnits(){

		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		ReusableMethodsLogin.waitForIframeLoad(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'),"Energy Meter(MWh)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectMWh'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectOnGenerateOnSiteSolar'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),"Energy Meter(MWh)", FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)

		//MBtu
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'),"Energy Meter(MBtu)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectMBtu'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectOnGenerateOnSiteSolar'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),"Energy Meter(MBtu)", FailureHandling.STOP_ON_FAILURE)

		//KBtu
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'),"Energy Meter(KBtu)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectKBtu'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectOnGenerateOnSiteSolar'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),"Energy Meter(KBtu)", FailureHandling.STOP_ON_FAILURE)

		//Gj

		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'),"Energy Meter(Gj)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectGj'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectOnGenerateOnSiteSolar'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),"Energy Meter(Gj)", FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public void countEnergyMeter(){

		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestEnergyMeterNew')), "Test Energy Meter New")
		Assert.assertEquals(WebUI.getText(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Energy Meter(MWh)')), "Energy Meter(MWh)")
		Assert.assertEquals(WebUI.getText(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Energy Meter(MBtu)')), "Energy Meter(MBtu)")
		Assert.assertEquals(WebUI.getText(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Energy Meter(KBtu)')), "Energy Meter(KBtu)")
		Assert.assertEquals(WebUI.getText(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Energy Meter(Gj)')), "Energy Meter(Gj)")
		println "Total no of Energy Meters are : 5 verified successfully"
	}

	@Keyword
	public void countWaterMeter(){

		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeterNew')), "Test Water Meter New")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Water Meter(kGal)')), "Water Meter(kGal)")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Water Meter(MGal)')), "Water Meter(MGal)")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Water Meter(cf)')), "Water Meter(cf)")
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Water Meter(ccf)')), "Water Meter(ccf)")
		println "Total no of Water Meters are : 5 verified successfully"

	}

	@Keyword
	public void createEnergyMeter(String sheetName, int rowNum){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum)
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum)
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum)
		String meterName=  data.getCellData(sheetName, "MeterName", rowNum)


		//WebUI.delay(18)
		//KatalonWebDriverBackedSelenium.WAIT_FOR_PAGE_TO_LOAD_IN_SECONDS
		//	WebUI.click(findTestObject('Object Repository/BasePoint/a_ Base Points'))
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		//WebUI.delay(12)
		//ReusableMethodsLogin.waitForPageLoad(60)
		//ReusableMethodsLogin.waitForIframeLoad(60)
		//WebUI.delay(10)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/DataInput/LoaderIframeDatainput'), 60)
		WebUI.delay(2)
		//WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		//WebUI.delay(2)
		//WebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 4)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/MeterAndSurveyText'))
		//WebUI.focus(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.delay(5)
		//sWebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'), 2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), meterName)
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//reading one

		WebUI.delay(8)
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), 20)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),meterName, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 5)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two
		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3
		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		//WebUI.delay(15)
		//WebUI.delay(5)
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/div_Test Energy Meter'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)
	}



	@Keyword
	public void createWaterMeterWithDifferentUnits(){

		//kGal
		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)

		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), "Water Meter(kGal)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectkGal'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectMuncipalitySuppliedReclaimedWater'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water Meter(kGal)", FailureHandling.STOP_ON_FAILURE)

		//MGal
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), "Water Meter(MGal)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectMGal'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectMuncipalitySuppliedReclaimedWater'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water Meter(MGal)", FailureHandling.STOP_ON_FAILURE)

		//cf
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), "Water Meter(cf)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/Selectcf'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectReclaimedOnsite'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water Meter(cf)", FailureHandling.STOP_ON_FAILURE)

		//ccf
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), "Water Meter(ccf)")
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnSelectUnit'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/Selectccf'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/ClickOnFuelSource'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/CreateEnergyAndWaterMeterWithDifferentCombinations/SelectReclaimedOnsite'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'), "Water Meter(ccf)", FailureHandling.STOP_ON_FAILURE)



	}



	@Keyword
	public void createWaterMeter(String sheetName, int rowNum){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum)
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum)
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum)
		String meterName=  data.getCellData(sheetName, "MeterName", rowNum)


		//WebUI.delay(18)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))

		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), meterName)
		println meterName
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))
		WebUI.waitForElementNotVisible(findTestObject('DataInput/CreateMeterBuilding/button_ADD'), 20)
		//reading one
		//WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),meterName, FailureHandling.STOP_ON_FAILURE)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two

		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3

		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'), 5)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/TestWaterMeter'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)
	}




	@Keyword
	public void createWasteMeter(){

		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(3)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '1000')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '800')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		//WebUI.delay(4)
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'), 3)
		//WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		/// Reading two

		//WebUI.delay(10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '500')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '200')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)

		//reading 3

		//WebUI.delay(10)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '600')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '300')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//WebUI.delay(15)

		WebUI.refresh()
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		//verifying the data inputted is persisting or not
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/WasteMeter'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingOne'),'value'),'600')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingTwo'),'value'),'500')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingThree'),'value'),'1000')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingOne'),'value'),'300')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingTwo'),'value'),'200')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingThree'),'value'),'800')

	}



	@Keyword
	public void humanExperienceMeter(String sheetName, int rowNum ){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum)
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum)
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum)
		String reading4  = data.getCellData(sheetName, "Reading4", rowNum)
		String reading5  = data.getCellData(sheetName, "Reading5", rowNum)
		String reading6  = data.getCellData(sheetName, "Reading6", rowNum)

		//WebUI.delay(5)
		//WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))

		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Carbon Dioxide', FailureHandling.STOP_ON_FAILURE)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(4)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two

		WebUI.delay(5)

		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3

		//WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)


		//Add the VOC Reading

		WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'))
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Total Volatile Organic Compounds', FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading4)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two

		//WebUI.delay(5)

		//WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading5)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3

		//WebUI.delay(5)
		//WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading6)
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading6)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading4)
	}



	@Keyword
	public void verifyAndDownloadExportData(){

		WebUI.delay(5)
		//WebUI.waitForElementClickable(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 15)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		//WebUI.delay(10)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		//WebUI.scrollToElement(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 5)
		WebUI.waitForElementVisible(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'), 20)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Create Report'))
		WebUI.delay(6)

		//Input Start Date

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportStartDate'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportStartDate'), 'Jan 01, 2017')
		/*WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		 WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		 WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))*/

		//Input End date

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportEndDate'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportEndDate'), 'Jan 01, 2018')
		/*WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		 WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		 WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		 WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		 WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))*/
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DOWNLOAD_DataInputReport'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/cancelButton'))
		WebUI.delay(8)
		//'Verifying the file is download in the User defined Path'
		Assert.assertTrue(isFileDownloaded('Export Data.xlsx'), 'Failed to download Expected document')
	}


	//Transit ridership
	@Keyword
	public void humanExperienceMeterTransitRidership(String sheetName, int rowNum ){

		String Ridership1  = data.getCellData(sheetName, "Ridership1", rowNum)
		String Ridership2  = data.getCellData(sheetName, "Ridership2", rowNum)
		String Ridership3  = data.getCellData(sheetName, "Ridership3", rowNum)

		//WebUI.delay(6)

		//Ridership
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		//WebUI.delay(5)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),2)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Ridership', FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership1)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading two

		//WebUI.delay(6)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		//reading 3

		//WebUI.delay(6)
		//WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'), 20)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/year_2018'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership3)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(5)
		WebUI.refresh()
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		ReusableMethodsLogin.waitForIframeLoad(60)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),Ridership3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),Ridership2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),Ridership1)

	}



	//City DataInput
	@Keyword
	public void createEnergyMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException{

		String reading1  = data.getCellData(sheetName, "EReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "EReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "EReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "EReading4", rowNum)
		String reading5  = data.getCellData(sheetName, "EReading5", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 */
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(8)
		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)

		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)
		WebUI.delay(2)
		for(int count = 1; count<=5; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}
		(1..5).each{
			WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CityCom/DeleteButton',[index: it]), 60)
		}
		WebUI.refresh()
		WebUI.delay(16)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value"), reading1,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value"),reading2,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value"),reading3,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value"),reading4,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value"),reading5,"Not Valid")
	}

	@Keyword
	public void createWaterMeterReading(String sheetName, int rowNum ) throws IOException, InterruptedException {
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "WaterReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "WaterReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "WaterReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "WaterReading4", rowNum)
		String reading5  = data.getCellData(sheetName, "WaterReading5", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 */
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.doubleClick(findTestObject('DataInput/CityCom/span_Water'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Add Year'), 3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(8)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Next Year'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)
		WebUI.delay(1)

		for(int count = 1; count<=5; count++){
			WebUI.delay(4)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}

		/*(1..5).each{
		 WebUI.waitForElementNotClickable(findTestObject('Object Repository/DataInput/CityCom/DeleteButton',[index: it]), 60)
		 }*/
		WebUI.waitForElementNotClickable(findTestObject('DataInput/CityCom/TextboxValue1'), 60)
		WebUI.waitForElementNotClickable(findTestObject('DataInput/CityCom/TextboxValue2'), 60)
		WebUI.waitForElementNotClickable(findTestObject('DataInput/CityCom/TextboxValue3'), 60)
		WebUI.waitForElementNotClickable(findTestObject('DataInput/CityCom/TextboxValue4'), 60)
		WebUI.waitForElementNotClickable(findTestObject('DataInput/CityCom/TextboxValue5'), 60)

		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value"),reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value"),reading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value"),reading5,"Not Valid")
	}

	@Keyword
	public void createWasteGenerationMeterReading(String sheetName,int rowNum) throws IOException, InterruptedException {

		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "wastegeneration1", rowNum)
		String reading2  = data.getCellData(sheetName, "wastegeneration2", rowNum)
		String reading3  = data.getCellData(sheetName, "wastegeneration3", rowNum)
		String reading4  = data.getCellData(sheetName, "wastegeneration4", rowNum)
		String reading5  = data.getCellData(sheetName, "wastegeneration5", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 */
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/span_Waste'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/GwAddYear'))
		WebUI.delay(8)
		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/CWTextboxValue1'),2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/CWTextboxValue1'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/CWTextboxValue2'), reading2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/CWTextboxValue3'), reading3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/CWTextboxValue4'), reading4)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/CWTextboxValue5'), reading5)
		WebUI.delay(1)
		for(int count = 1; count<=5; count++){
			WebUI.delay(4)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}
		(1..5).each{
			WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CityCom/DeleteButton',[index: it]), 60)
		}
		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/CWTextboxValue1'),"value"), reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/CWTextboxValue2'),"value"), reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/CWTextboxValue3'),"value"), reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/CWTextboxValue4'),"value"),reading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/CWTextboxValue5'),"value"), reading5,"Not Valid")

		//waste diversion

		WebUI.delay(8)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CityCom/span_Waste'))
		WebUI.delay(4)
		//WebUI.scrollToElement(findTestObject('DataInput/CityCom/ScrollToTextWasteDiversion'), 3)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/DwAddYear'),2)
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/DwAddYear'), 4)
		WebUI.click(findTestObject('DataInput/CityCom/DwAddYear'))
		WebUI.delay(6)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/DNextButton'),2)
		WebUI.click(findTestObject('DataInput/CityCom/DNextButton'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue1'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue2'), reading2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue3'), reading3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue4'), reading4)
		WebUI.delay(1)
		for(int count = 6; count<=9; count++){
			WebUI.delay(4)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}
		(6..9).each{
			WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/CityCom/DeleteButton',[index: it]), 60)
		}
		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue1'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue2'),"value"), reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue3'),"value"), reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue4'),"value"), reading4,"Not Valid")


	}

	/*@Keyword
	 public void createWasteDiversionMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException{
	 *//*************************Reading data from excel sheet ************************************//*
	 String reading1  = data.getCellData(sheetName, "wastediversion1", rowNum)
	 String reading2  = data.getCellData(sheetName, "wastediversion2", rowNum)
	 String reading3  = data.getCellData(sheetName, "wastediversion3", rowNum)
	 String reading4  = data.getCellData(sheetName, "wastediversion4", rowNum)
	 String reading5  = data.getCellData(sheetName, "wastediversion5", rowNum)
	 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
	 WebUI.delay(1)
	 WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
	 WebUI.delay(1)
	 WebUI.click(findTestObject('DataInput/CityCom/span_Waste'))
	 WebUI.delay(4)
	 WebUI.scrollToElement(findTestObject('DataInput/CityCom/DwAddYear'),2)
	 WebUI.click(findTestObject('DataInput/CityCom/DwAddYear'))
	 WebUI.delay(2)
	 WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
	 WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
	 WebUI.delay(2)
	 WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
	 WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
	 WebUI.delay(2)
	 WebUI.scrollToElement(findTestObject('DataInput/CityCom/DPreviousYear'),2)
	 WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
	 WebUI.delay(2)
	 WebUI.scrollToElement(findTestObject('DataInput/CityCom/DNextButton'),2)
	 WebUI.click(findTestObject('DataInput/CityCom/DNextButton'))
	 WebUI.delay(2)
	 WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue1'), reading1)
	 WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue2'), reading2)
	 WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue3'), reading3)
	 WebUI.sendKeys(findTestObject('DataInput/CityCom/dWTextboxValue4'), reading4)
	 WebUI.delay(1)
	 for(int count = 6; count<=9; count++){
	 WebUI.delay(4)
	 WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
	 WebUI.delay(6)
	 }
	 WebUI.delay(15)
	 WebUI.refresh()
	 WebUI.delay(15)
	 Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue1'),"value"), reading1,"Not Valid")
	 WebUI.delay(3)
	 Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue2'),"value"), reading2,"Not Valid")
	 WebUI.delay(3)
	 Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue3'),"value"), reading3,"Not Valid")
	 WebUI.delay(3)
	 Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue4'),"value"), reading4,"Not Valid")
	 }*/
	@Keyword
	public void createTransportReading(String sheetName, int rowNum) throws IOException, InterruptedException{
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "TReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "TReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "TReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "TReading4", rowNum)
		String reading5  = data.getCellData(sheetName, "TReading5", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 */
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/span_Transportation'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Add Year'), 4)
		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(8)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Next Year'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'),2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'),2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/button_Previous Year'),2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)
		for(int count = 1; count<=5; count++){
			WebUI.delay(3)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}
		WebUI.delay(6)
		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value"),reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value"),reading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value"),reading5,"Not Valid")
	}

	@Keyword
	public void createHumanExpMeterReading(String sheetName, int rowNum)throws IOException, InterruptedException {
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "EPReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "EPReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "HGiniReading1", rowNum)
		String reading4  = data.getCellData(sheetName, "HGiniReading2", rowNum)
		String reading5  = data.getCellData(sheetName, "Hincome1", rowNum)
		String reading6  = data.getCellData(sheetName, "Hincome2", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/span_Human Experience'))
		WebUI.delay(5)
		//WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('DataInput/CityCom/EducationAddYear'))
		WebUI.delay(8)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/EducationAddPrevYear'),2)
		WebUI.click(findTestObject('DataInput/CityCom/EducationAddPrevYear'))
		WebUI.delay(5)
		//WebUI.waitForPageLoad(10)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/BachelorAddYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/BachelorAddYear'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/BachelorAddPrevYear'),5)
		WebUI.click(findTestObject('DataInput/CityCom/BachelorAddPrevYear'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue3'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue4'), reading2)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/EquAddYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/EquAddYear'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/EquAddPrevYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/EquAddPrevYear'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue5'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue6'), reading2)
		WebUI.click(findTestObject('DataInput/CityCom/GiniAddYear'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/GiniAddPrevYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/GiniAddPrevYear'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue7'), reading3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue8'), reading4)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/ProsperityAddYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/ProsperityAddYear'))
		//WebUI.delay(2)
		//WebUI.scrollToElement(findTestObject('DataInput/CityCom/ProsperityAddPrevYear'), 2)
		//WebUI.click(findTestObject('DataInput/CityCom/ProsperityAddPrevYear'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue9'), reading5)

		for(int count = 1; count<=9; count++){
			WebUI.delay(4)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}

		WebUI.delay(6)
		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value"), reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue3'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue4'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue5'),"value"),reading1,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue6'),"value"),reading2,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue7'),"value"),reading3,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue8'),"value"),reading4,"Not Valid")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue9'),"value"),reading5,"Not Valid")
	}

	@Keyword
	public void createADMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.delay(1)
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "ADeatailsValueReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "ADeatailsValueReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "ADeatailsValueReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "ADeatailsValueReading4", rowNum)
		String ureading1  = data.getCellData(sheetName, "ADeatailsUnitReading1", rowNum)
		String ureading2  = data.getCellData(sheetName, "ADeatailsUnitReading2", rowNum)
		String ureading3  = data.getCellData(sheetName, "ADeatailsUnitReading3", rowNum)
		String ureading4  = data.getCellData(sheetName, "ADeatailsUnitReading4", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(9)*/
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(9)
		WebUI.click(findTestObject('DataInput/CityCom/span_Additional Data'))
		WebUI.delay(9)
		for(int count =1 ;count<=4;count++ ) {
			WebUI.click(findTestObject('BasePoint/CityCom/ClickDropdown'))
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('BasePoint/CityCom/Option'+count),10)
			WebUI.delay(2)
			WebUI.click(findTestObject('BasePoint/CityCom/Option'+count))
			WebUI.delay(5)
			WebUI.click(findTestObject('BasePoint/CityCom/AddButton'))
			WebUI.delay(5)
		}
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue1'), reading1)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit1'), ureading1)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue2'), reading2)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit2'), ureading2)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue3'), reading3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit3'), ureading3)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue4'), reading4)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit4'), ureading4)
		WebUI.delay(3)
		for(int count=1;count<=4;count++) {
			WebUI.delay(5)
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
			WebUI.delay(6)
		}

		WebUI.delay(15)
		WebUI.refresh()
		
		WebUI.delay(15)

		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue1'),"value"), reading4,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue2'),"value"),reading3,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue3'),"value"),reading2,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue4'),"value"),reading1,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit1'),"value"),ureading4,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit2'),"value"),ureading3,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit3'),"value"),ureading2,"Not Valid")
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit4'),"value"),ureading1,"Not Valid")
	}

	@Keyword
	public void surveySubmit(String sheetName) throws IOException, InterruptedException, Exception{
		WebUI.delay(8)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(12)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(5)
		/*WebDriver driver  = DriverFactory.getWebDriver()
		 String MainWindowHandle = driver.getWindowHandle()*/
		//int winIndex= WebUI.getWindowIndex()
		WebUI.waitForElementVisible(findTestObject('DataInput/Survey/CopySurveyLink'), 20)
		WebUI.click(findTestObject('DataInput/Survey/CopySurveyLink'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/Survey/English'))
		WebUI.delay(6)
		Robot r = new Robot()
		for( int rowNum=2;rowNum<=5;rowNum++)
		{

			if(rowNum==2)
			{
				String walk1 = data.getCellData(sheetName, "Walk", rowNum)
				String walk2 = data.getCellData(sheetName, "Bus", rowNum)
				String walk3 = data.getCellData(sheetName, "Tram", rowNum)
				String walk4 = data.getCellData(sheetName, "Heavyrail", rowNum)
				String walk5 = data.getCellData(sheetName, "Motorcycle", rowNum)
				String walk6 = data.getCellData(sheetName, "Carsolo", rowNum)
				String walk7 = data.getCellData(sheetName, "Carpool", rowNum)
				String walk8 = data.getCellData(sheetName, "Caralternative", rowNum)
				String name = data.getCellData(sheetName, "Name", rowNum)

				WebUI.delay(1)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_T)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_T)


				WebUI.delay(4)


				//((JavascriptExecutor)driver).executeScript('window.open("");')
				//WebUI.delay(2)
				WebUI.switchToWindowIndex(1)
				/*r.keyPress(KeyEvent.VK_CONTROL)
				 r.keyPress(KeyEvent.VK_T);
				 r.delay(200);
				 r.keyRelease(KeyEvent.VK_CONTROL)
				 r.keyRelease(KeyEvent.VK_T)
				 WebUI.switchToWindowIndex(2)
				 WebUI.delay(4)
				 //WebUI.navigateToUrl("")
				 */				
				WebUI.delay(4)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_V)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_V)
				WebUI.delay(4)
				r.keyPress(KeyEvent.VK_ENTER)
				r.keyRelease(KeyEvent.VK_ENTER)
				WebUI.delay(5)
				WebUI.click(findTestObject('DataInput/Survey/ACCEPTANDCLOSE'),FailureHandling.CONTINUE_ON_FAILURE)
				/*
				 WebUI.setText(findTestObject('DataInput/Survey/survey_tenant_name'), name)*/
				/*WebUI.click(findTestObject('Object Repository/DataInput/Survey/ClickOnSelectTravelMethod'))
				 int j=1
				 (1..8).each{
				 WebUI.setText(findTestObject('Object Repository/DataInput/Survey/InputMileage',[index: it]), "walk" + j)
				 j++
				 }
				 WebUI.click(findTestObject('Object Repository/DataInput/Survey/SaveButtonToRecordSurveyData'))
				 WebUI.dragAndDropToObject(findTestObject('Object Repository/DataInput/Survey/SatisfactionSlider'), findTestObject('Object Repository/DataInput/Survey/ExtremelySatisfySpanText'))
				 WebUI.click(findTestObject('DataInput/Survey/Submit'))
				 WebUI.delay(3)
				 WebUI.verifyMatch(WebUI.getText(findTestObject('DataInput/Survey/Thank')), "Thank you for taking our survey! Your responses:", false)
				 WebUI.delay(3)*/
				WebUI.scrollToElement(findTestObject('DataInput/Survey/WalkR1'), 10)
				WebUI.setText(findTestObject('DataInput/Survey/WalkR1'), walk1)
				WebUI.setText(findTestObject('DataInput/Survey/BusR1'), walk2)
				WebUI.setText(findTestObject('DataInput/Survey/TramR1'), walk3)
				WebUI.setText(findTestObject('DataInput/Survey/HeavyRailR1'), walk4)
				WebUI.setText(findTestObject('DataInput/Survey/MotorcycleR1'), walk5)
				WebUI.setText(findTestObject('DataInput/Survey/carSoloR1'), walk6)
				WebUI.setText(findTestObject('DataInput/Survey/car23R1'), walk7)
				WebUI.setText(findTestObject('DataInput/Survey/cars4R1'), walk8)
				WebUI.setText(findTestObject('DataInput/Survey/survey_tenant_name'), name)
				WebUI.delay(2)
				WebUI.click(findTestObject('DataInput/Survey/Submit'))
				WebUI.delay(3)
				WebUI.waitForElementVisible(findTestObject('DataInput/Survey/Thank'), 20)
				WebUI.click(findTestObject('DataInput/Survey/Thank'))
				WebUI.delay(3)
				WebUI.waitForPageLoad(GlobalVariable.timeOut)
				println "Survey Submited Successufully"
				WebUI.verifyElementVisible(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/YourWorldIsAliveText'), FailureHandling.STOP_ON_FAILURE)
				WebUI.closeWindowIndex(1)
			}
			else
			{

				String walk1 = data.getCellData(sheetName, "Walk", rowNum)
				String walk2 = data.getCellData(sheetName, "Bus", rowNum)
				String walk3 = data.getCellData(sheetName, "Tram", rowNum)
				String walk4 = data.getCellData(sheetName, "Heavyrail", rowNum)
				String walk5 = data.getCellData(sheetName, "Motorcycle", rowNum)
				String walk6 = data.getCellData(sheetName, "Carsolo", rowNum)
				String walk7 = data.getCellData(sheetName, "Carpool", rowNum)
				String walk8 = data.getCellData(sheetName, "Caralternative", rowNum)
				String name = data.getCellData(sheetName, "Name", rowNum)


				//Robot r = new Robot()
				//((JavascriptExecutor)driver).executeScript('window.open("");')
				//WebUI.delay(2)
				//WebUI.switchToWindowIndex(1)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_T)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_T)
				WebUI.delay(2)
				WebUI.switchToWindowIndex(1)
				WebUI.delay(5)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_V)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_V)
				WebUI.delay(2)
				r.keyPress(KeyEvent.VK_ENTER)
				r.keyRelease(KeyEvent.VK_ENTER)
				WebUI.delay(5)
				WebUI.scrollToElement(findTestObject('DataInput/Survey/WalkR1'), 10)
				WebUI.setText(findTestObject('DataInput/Survey/WalkR1'), walk1)
				WebUI.setText(findTestObject('DataInput/Survey/BusR1'), walk2)
				WebUI.setText(findTestObject('DataInput/Survey/TramR1'), walk3)
				WebUI.setText(findTestObject('DataInput/Survey/HeavyRailR1'),walk4)
				WebUI.setText(findTestObject('DataInput/Survey/MotorcycleR1'), walk5)
				WebUI.setText(findTestObject('DataInput/Survey/carSoloR1'), walk6)
				WebUI.setText(findTestObject('DataInput/Survey/car23R1'), walk7)
				WebUI.setText(findTestObject('DataInput/Survey/cars4R1'), walk8)
				WebUI.setText(findTestObject('DataInput/Survey/survey_tenant_name'), name)
				WebUI.click(findTestObject('DataInput/Survey/Submit'))
				WebUI.delay(3)
				WebUI.waitForElementVisible(findTestObject('DataInput/Survey/Thank'), 20)
				WebUI.click(findTestObject('DataInput/Survey/Thank'))
				WebUI.delay(3)
				WebUI.waitForPageLoad(GlobalVariable.timeOut)
				/*WebUI.click(findTestObject('Object Repository/DataInput/Survey/ClickOnSelectTravelMethod'))
				 int k=1
				 (1..8).each{
				 WebUI.setText(findTestObject('Object Repository/DataInput/Survey/InputMileage',[index: it]), "walk" + k)
				 k++
				 }
				 WebUI.click(findTestObject('Object Repository/DataInput/Survey/SaveButtonToRecordSurveyData'))
				 WebUI.delay(3)
				 WebUI.dragAndDropToObject(findTestObject('Object Repository/DataInput/Survey/SatisfactionSlider'), findTestObject('Object Repository/DataInput/Survey/ExtremelySatisfySpanText'))
				 WebUI.click(findTestObject('DataInput/Survey/Submit'))
				 WebUI.delay(3)
				 WebUI.verifyMatch(WebUI.getText(findTestObject('DataInput/Survey/Thank')), "Thank you for taking our survey! Your responses:", false)
				 */WebUI.delay(3)
				println "Survey Submited Successufully"
				WebUI.verifyElementVisible(findTestObject('Object Repository/LoginArc/Page_Arc Skoru  Sustainability perf/YourWorldIsAliveText'), FailureHandling.STOP_ON_FAILURE)
				WebUI.closeWindowIndex(1)
			}
			//WebUI.closeWindowIndex(1)
			//WebUI.closeWindowIndex(2)
			//driver.switchTo().window(MainWindowHandle)
		}
		//WebUI.closeWindowIndex(1)
		//driver.switchTo().window(MainWindowHandle)
		WebUI.switchToWindowIndex(0)

	}
	@Keyword
	public void percentageSurveyResponseRateCalculationTransit() throws IOException, InterruptedException, Exception{
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('Manage/Parking/Manage'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Manage/Parking/ManageProject'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Manage/Project/WeightedOccupancy'), 10)
		String projectoccupancy = WebUI.getAttribute(findTestObject('Manage/Project/WeightedOccupancy'),'value')
		double projectOccupancy= Double.parseDouble(projectoccupancy)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(15)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(5)
		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of transport survey results.*****/
		String surveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String surveyResponsepercentage1 = surveyResponsePercentage.replace("%","")
		String surveyResponsepercentage = surveyResponsepercentage1.replaceAll("\\s","")
		double surveyresponsepercentage= Double.parseDouble(surveyResponsepercentage)
		println surveyResponsepercentage

		double calculatedresponsePecentage = (4/projectOccupancy)*100

		BigDecimal responsePecentage = new BigDecimal(calculatedresponsePecentage)
		responsePecentage = responsePecentage.setScale(2,RoundingMode.HALF_UP)
		String responsePecentageTr = Double.toString(responsePecentage)
		println responsePecentageTr

		WebUI.verifyMatch(responsePecentageTr, surveyResponsepercentage, false)
		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of HUMAN EXPERIENCE survey results.*****/
		WebUI.click(findTestObject('DataInput/Survey/OccupantSatisfactionSurv'))
		WebUI.delay(10)
		String humsurveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String humsurveyResponsepercentage1 = surveyResponsePercentage.replace("%" ,"")
		String humsurveyResponsepercentage = humsurveyResponsepercentage1.replaceAll("\\s","")

		print humsurveyResponsepercentage
		double humsurveyresponsepercentage= Double.parseDouble(humsurveyResponsepercentage)

		double humcalculatedresponsePecentage = (4/projectOccupancy)*100
		BigDecimal responsePecentagehum = new BigDecimal(calculatedresponsePecentage)
		responsePecentagehum = responsePecentagehum.setScale(2, RoundingMode.HALF_UP)
		String responsePecentagehu = Double.toString(responsePecentage)

		Assert.assertEquals(responsePecentagehu,humsurveyResponsepercentage)
		/***************Verify that survey response rate percentage is same in Transport and HE tabs.***********************************/
		WebUI.verifyMatch(humsurveyResponsePercentage, surveyResponsePercentage, false)

	}

	@Keyword
	public void percentageSurveyResponseRateCalculationBuiding() throws IOException, InterruptedException, Exception{
		/*WebUI.delay(2)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/Parking/Manage'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/Parking/ManageProject'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(10)

		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'), 10)
		String projectoccupancy = WebUI.getAttribute((findTestObject('Manage/ProjectDetailVerification/projectoccupancy')),'value')

		double projectOccupancy= Double.parseDouble(projectoccupancy)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(10)
		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of transport survey results.*****/
		String surveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String surveyResponsepercentage1 = surveyResponsePercentage.replace("%","")
		String surveyResponsepercentage = surveyResponsepercentage1.replaceAll("\\s","")
		double surveyresponsepercentage= Double.parseDouble(surveyResponsepercentage)
		println surveyResponsepercentage

		double calculatedresponsePecentage = (4/projectOccupancy)*100

		BigDecimal responsePecentage = new BigDecimal(calculatedresponsePecentage)
		responsePecentage = responsePecentage.setScale(2,RoundingMode.HALF_UP)
		String responsePecentageTr = Double.toString(responsePecentage)
		println responsePecentageTr

		WebUI.verifyMatch(responsePecentageTr, surveyResponsepercentage, false)
		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of HUMAN EXPERIENCE survey results.*****/
		WebUI.click(findTestObject('DataInput/Survey/OccupantSatisfactionSurv'))
		WebUI.delay(10)
		String humsurveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String humsurveyResponsepercentage1 = surveyResponsePercentage.replace("%" ,"")
		String humsurveyResponsepercentage = humsurveyResponsepercentage1.replaceAll("\\s","")

		print humsurveyResponsepercentage
		double humsurveyresponsepercentage= Double.parseDouble(humsurveyResponsepercentage)

		double humcalculatedresponsePecentage = (4/projectOccupancy)*100
		BigDecimal responsePecentagehum = new BigDecimal(calculatedresponsePecentage)
		responsePecentagehum = responsePecentagehum.setScale(2, RoundingMode.HALF_UP)
		String responsePecentagehu = Double.toString(responsePecentage)

		Assert.assertEquals(responsePecentagehu,humsurveyResponsepercentage)
		/***************Verify that survey response rate percentage is same in Transport and HE tabs.***********************************/
		WebUI.verifyMatch(humsurveyResponsePercentage, surveyResponsePercentage, false)

	}


	//Add New Meter" in Energy Tab, should be present, to create a new meter
	@Keyword
	public void checkEnergyAndWaterMeterCreateTabDataInput(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/DataInputFileUpload/EnergyTabDataInput'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/DataInputFileUpload/AddNewMeterButton'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/DataInputFileUpload/WaterMeterTab'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/DataInputFileUpload/AddNewWaterMeterButton'), 5)
	}



	/*@Keyword
	 public void checkEnergyMeterGraph(){
	 //WebUI.delay(18)
	 WebUI.delay(7)
	 WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
	 WebUI.delay(5)
	 WebUI.click(findTestObject('Object Repository/DataInput/Graphs/DetailsTab'))
	 WebUI.delay(5)
	 WebDriver driver  = DriverFactory.getWebDriver()
	 List<WebElement> element = driver.findElements(By.xpath('((((//*[@id="chart-id"]//*[name()="svg"]/*[name()="g"]))[7])//*[name()="g"])[3]'))
	 println element.size()
	 WebUI.mouseOver(findTestObject('Object Repository/DataInput/Graphs/GraphValueOne'))
	 String value= WebUI.getAttribute(findTestObject('Object Repository/DataInput/Graphs/GraphValueOne'), "textContent")
	 println value
	 }*/

	@Keyword
	public void waterScoreShouldNotrecomputemun(String sheetName){
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('DataInput/Survey/a_ Data Input'),5)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(15)
		String uIwaterScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		data.setCellData(sheetName,"waterScore",5,uIwaterScore)

		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/AnalyticsWater meter'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/Details'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/button_Municipality supplied'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/a_Municipality supplied reclai'))
		WebUI.delay(20)

		String waterScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		WebUI.verifyMatch(waterScore,'0', false)

	}

	@Keyword
	public void waterScoreShouldNotrecomputemunReclaimedonsite(){
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/MeterWater/svg_Municipality'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/svg_Municipality'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/a_Reclaimed onsite'))
		WebUI.delay(12)

		String rwaterScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))

		WebUI.verifyMatch(rwaterScore,'0', false, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public void waterScoreShouldrecomput(String sheetName){
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/MeterWater/Reclaimed onsite'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/Municipality'))
		WebUI.delay(18)

		/*WebUI.click(findTestObject('Object Repository/DataInput/MeterWater/a_Municipality supplied potabl'))
		 WebUI.delay(5)*/

		/********************Changing to the default score of water ***********************************************/
		WebUI.scrollToElement(findTestObject('PerformanceScore/DataInput/WaterScore'),5)
		String awaterScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		String pwaterScore = data.getCellData(sheetName,"waterScore", 5)
		WebUI.verifyMatch(pwaterScore,awaterScore, false)
	}
	@Keyword
	public void CitydefaultNotification(){
		String noOfDefalutNoti =WebUI.getText(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.verifyMatch(noOfDefalutNoti,'5', false)



	}

	@Keyword
	public void NotificationNavigationTest(){
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/Notification/Energy'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Notification/span_Energy'), 2)

		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/Notification/Water'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Notification/span_Water'), 2)

		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/Notification/Waste'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Notification/span_Waste'), 2)

		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/Notification/Transport'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Notification/span_Transportation'), 2)

		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/Notification/Hum'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Notification/span_Human Experience'), 2)


	}

	@Keyword
	public void NotificatioBellTest(){

		WebUI.verifyElementNotVisible(findTestObject('Object Repository/DataInput/Notification/BellNotification'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'),5)
		WebUI.click(findTestObject('Object Repository/DataInput/Notification/DefaultNotifcaiton'))
		WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Object Repository/DataInput/Notification/You have 1 notification'),FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	public void precertificationCreditAssionTest(){
		WebUI.delay(3)
		WebUI.click(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/CityCom/span_Commit to sharing data'))
		WebUI.delay(3)

		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamIconClick'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BasePoint/BasePointCreditCom/TeamMemberSelection'))
		WebUI.delay(10)

		String teamMemUI = WebUI.getText(findTestObject("BasePoint/BasePointCreditCom/VerifyAddedTeamSuccessully"))
		WebUI.verifyMatch(GlobalVariable.teamMemName,teamMemUI, false)

		WebUI.click(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)

		String pteamMemUI = WebUI.getText(findTestObject('Object Repository/DataInput/CityC/VerifyTeam'))
		WebUI.verifyMatch(GlobalVariable.teamMemName,pteamMemUI, false)

	}
	@Keyword
	public void HumanExpMeterReadingValidationUI()throws IOException, InterruptedException {
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/span_Human Experience'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('DataInput/CityCom/EducationAddYear'))
		WebUI.delay(8)

		/*WebUI.scrollToElement(findTestObject('DataInput/CityCom/Hum/nextButton'), 2)
		 WebUI.click(findTestObject('DataInput/CityCom/Hum/nextButton'))
		 WebUI.delay(5)*/

		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), '5000')
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+1))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('DataInput/CityCom/Hum/TextValidationPercentPercentvalueshouldnotexceed100'),5)

		/****************************Verifying the Notification of Error message******************************/
		WebUI.clearText(findTestObject('DataInput/CityCom/TextboxValue1'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), '20')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/SaveButton'+1),2)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+1))
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable1'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable1'))
		WebUI.delay(1)

	}


	@Keyword
	public void PopulationHumanExpMeterReadingValidationUI()throws IOException, InterruptedException {

		WebUI.scrollToElement(findTestObject('DataInput/CityCom/BachelorAddYear'), 2)
		WebUI.click(findTestObject('DataInput/CityCom/BachelorAddYear'))
		WebUI.delay(5)

		WebUI.setText(findTestObject('DataInput/CityCom/HTextBox2'), '5000')
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+2))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('DataInput/CityCom/Hum/TextValidationPercentPercentvalueshouldnotexceed100'),5)

		/****************************Verifying the Notification of Error message******************************/
		WebUI.clearText(findTestObject('DataInput/CityCom/HTextBox2'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('DataInput/CityCom/HTextBox2'), '20')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/SaveButton'+2),2)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+2))
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable2'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable2'))
		WebUI.delay(1)

	}
	@Keyword
	public void EQUITABILITYHumanExpMeterReadingValidationUI()throws IOException, InterruptedException {

		WebUI.waitForPageLoad(10)
		WebUI.scrollToElement(findTestObject('DataInput/CityCom/EquAddYear'),2)
		WebUI.click(findTestObject('DataInput/CityCom/EquAddYear'))
		WebUI.delay(5)

		WebUI.setText(findTestObject('DataInput/CityC/TextBox3'), '5000')
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+3))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('DataInput/CityCom/Hum/TextValidationPercentPercentvalueshouldnotexceed100'),5)

		/****************************Verifying the Notification of Error message******************************/
		WebUI.clearText(findTestObject('DataInput/CityC/TextBox3'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('DataInput/CityC/TextBox3'), '20')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/SaveButton'+3),2)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+3))
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable3'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable3'))
		WebUI.delay(1)
	}
	@Keyword
	public void GinicoefficientHumanExpMeterReadingValidationUI()throws IOException, InterruptedException {

		WebUI.click(findTestObject('DataInput/CityCom/GiniAddYear'))
		WebUI.delay(5)

		WebUI.setText(findTestObject('DataInput/CityC/TextBox4'), '5000')
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+4))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('DataInput/CityCom/Hum/Gini'),5)

		/****************************Verifying the Notification of Error message******************************/
		WebUI.clearText(findTestObject('DataInput/CityC/TextBox4'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('DataInput/CityC/TextBox4'),'20')
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/SaveButton'+4),2)
		WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+4))
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable4'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('DataInput/CityCom/Hum/DeleteButtonClickable4'))
		WebUI.delay(1)
	}
}

