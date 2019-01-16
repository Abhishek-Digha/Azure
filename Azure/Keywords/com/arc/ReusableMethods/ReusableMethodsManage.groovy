package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.event.KeyEvent
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.arc.BaseClass.CommonMethod
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
public class ReusableMethodsManage extends BaseClass {


	ReusableMethodsDataInput ReusDataInput = new ReusableMethodsDataInput()
	ReusableMethodsNavigation ReusNavigate = new ReusableMethodsNavigation()
	//ReusableMethodsNavigation navigation = new ReusableMethodsNavigation()
	public CommonMethod commMethod  = new CommonMethod()
	public static Robot robot = new Robot()
	@Keyword
	public void verifyProjectDetailsCityCom(String sheetName, int rowNum) throws IOException, InterruptedException {
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjId        = data.getCellData(sheetName,"ProjectID", rowNum)
		String ownerType    = data.getCellData(sheetName,"OwnerType", rowNum)
		String ownerOrg     = data.getCellData(sheetName,"OwnerOrganization", rowNum)
		String ownerEmail   = data.getCellData(sheetName,"OwnerEmail", rowNum)
		String spaceType    = data.getCellData(sheetName,"SpaceType", rowNum)
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum)
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum)
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum)
		String prjCity 		= data.getCellData(sheetName, "City", rowNum)
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum)
		String prjState 	= data.getCellData(sheetName, "State", rowNum)
		String population 	= data.getCellData(sheetName, "Population", rowNum)

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectName'),'value'),prjName, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectId'),'value'),prjId, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/unitType'),'value'),"string:IP", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAddress'),'value'),prjAddress, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCity'),'value'), prjCity, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectState'),'value'), prjState, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCountry'),'value'),prjCountry, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjPrivate'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerType'),'value'),"string:"+ownerType)
		//Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerOrg'),'value'),ownerOrg)
		//Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerCountry'),'value'),ownerCountry)
		//Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerEmail'),'value'),ownerEmail)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/population'),'value'),population, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/precertify'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),prjArea, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void editProjectDetailsCityCom( String sheetName, int rowNum) throws IOException, InterruptedException {

		String editArea  = data.getCellData(sheetName, "editArea", rowNum)
		String editPopulation  = data.getCellData(sheetName, "editPopulation", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/Parking/Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Manage/Parking/ManageProject'))
		WebUI.delay(2)

		WebUI.clearText(findTestObject('Manage/CityCom/input_grossArea'))
		WebUI.sendKeys(findTestObject('Manage/CityCom/input_grossArea'),editArea )
		WebUI.click(findTestObject('Object Repository/Manage/CityCom/ClickSave'))
		WebUI.delay(2)

		WebUI.clearText(findTestObject('Manage/CityCom/input_population'))
		WebUI.sendKeys(findTestObject('Manage/CityCom/input_population'),editPopulation)
		WebUI.click(findTestObject('Object Repository/Manage/CityCom/ClickSave'))
		WebUI.delay(6)

		WebUI.refresh()
		WebUI.delay(2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/CityCom/input_grossArea'),"value"),editArea ,"Not Equal")
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/CityCom/input_population'),"value"), editPopulation ,"Not Equal")
	}



	@Keyword
	public editOccupanyAreaAndOpreatingHours(){
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Building Settings'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/opreating_Hours'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'), 1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'))
		WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingOccupancy'), '2,000')
		WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'), '5500')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/updateBuildingSettingButton'))
		WebUI.delay(4)
	}

	@Keyword
	public editOccupanyAreaAndOpreatingHoursAnalyticManage(){
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(13)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Building Settings'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/opreating_Hours'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'))

		//	WebUI.setText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingOccupancy'), '10')

		WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'), '10000')

		WebUI.click(findTestObject('Object Repository/DataInput/Data/svg_Imperial system (IP)_svg-i'))
		WebUI.scrollToElement(findTestObject('DataInput/Data/a_Metric system (SI)'), 2)
		WebUI.click(findTestObject('DataInput/Data/a_Metric system (SI)'))

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/updateBuildingSettingButton'))
		WebUI.delay(10)

		/************************Verifying under Manage Section *****************************************/

		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/unitType'),'value'),"string:SI", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),'10000', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/week_opr_hrs'),'value'),'160', false, FailureHandling.CONTINUE_ON_FAILURE)

		/************************Verifying under Analytics Section *****************************************/

		ReusNavigate.navigateToAnalyticsTotal()

		String area = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Area'))
		WebUI.verifyMatch(area,'10,000', false)

		String operatinghour = WebUI.getText(findTestObject('Analytics/TotalAnalytics/OpeartingHour'))
		WebUI.verifyMatch(operatinghour,'160', false)

		/*	String occupancy = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Occupant'))
		 WebUI.verifyMatch(occupancy,'10', false)*/

		WebUI.verifyElementPresent(findTestObject('DataInput/Data/span_(sq. meters)'),2, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	public editOccupanyAreaAndOpreatingHoursTransit(){
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Building Settings'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/opreating_Hours'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'), 1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'))
		//WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingOccupancy'), '2,000')
		WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'), '5500')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/updateBuildingSettingButton'))
		WebUI.delay(4)
	}

	@Keyword
	public void downloadAndUploadArcCalculatorDataTemplate(){
		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'), 2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/Project/calculator'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Manage/Project/CalculatorPopupText')), 'UPLOAD METER DATA')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/Project/excelTemplateDownload'))
		WebUI.delay(6)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("Arc_Data_Template_v03.xlsm"), "Calculator template file didn't downloaded successfully")
		WebUI.delay(3)
		deleteFile(BaseClass.DownloadManageCalculatorExcel)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/Manage/Project/uploadCalculatorTemplate'),BaseClass.UploadManageCalculatorExcel )
		WebUI.delay(6)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/Project/closeBtn'), 15)
		WebUI.click(findTestObject('Object Repository/Manage/Project/closeBtn'))
		WebUI.delay(10)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),'12345', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),'50', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),'1000', false, FailureHandling.CONTINUE_ON_FAILURE)
	}


	//Verify operating hours, occupancy and area after uploading the excel template. For Building None, Other, City, Community Leed, None and Other
	@Keyword
	public void verifyOperatingHrsAreaAndOccupancyAfterExcelUpload(){
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		 WebUI.delay(3)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),'5000', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),'30', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),'9', false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	//Verify operating hours, occupancy and area after uploading the excel template. For Building None, Other, City, Community Leed, None and Other
	@Keyword
	public void verifyOperatingHrsAreaAndOccupancyAfterExcelUploadTrasit(){
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		 WebUI.delay(3)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		 WebUI.delay(2)*/
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),'2000', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),'100', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),'9', false, FailureHandling.CONTINUE_ON_FAILURE)
	}




	@Keyword
	public void verifyBuildingProjectDetails(String sheetName, int rowNum){

		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjId        = data.getCellData(sheetName,"ProjectID", rowNum)
		String ownerType    = data.getCellData(sheetName,"OwnerType", rowNum)
		String ownerOrg     = data.getCellData(sheetName,"OwnerOrganization", rowNum)
		String ownerEmail   = data.getCellData(sheetName,"OwnerEmail", rowNum)
		String spaceType    = data.getCellData(sheetName,"SpaceType", rowNum)
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum)
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum)
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum)
		String prjCity 		= data.getCellData(sheetName, "City", rowNum)
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum)
		String prjState 	= data.getCellData(sheetName, "State", rowNum)

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectName'),'value'),prjName, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectId'),'value'),prjId, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/unitType'),'value'),"string:IP", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/spaceType'),'value'),"string:Airport: Hangar", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAddress'),'value'),prjAddress, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCity'),'value'), prjCity, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectState'),'value'), prjState, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCountry'),'value'),prjCountry, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjPrivate'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerType'),'value'),"string:Business Improvement District", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerOrg'),'value'),ownerOrg, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerCountry'),'value'),ownerCountry, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerEmail'),'value'),ownerEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/preLEEDCertified'),'value'), "boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/containsResUnits'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedHigherEducation'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedLEEDLab'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/precertify'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),prjArea, false, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public void verifyTransitProjectDetails(String sheetName, int rowNum){
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjId        = data.getCellData(sheetName,"ProjectID", rowNum)
		String ownerType    = data.getCellData(sheetName,"OwnerType", rowNum)
		String ownerOrg     = data.getCellData(sheetName,"OwnerOrganization", rowNum)
		String ownerEmail   = data.getCellData(sheetName,"OwnerEmail", rowNum)
		String spaceType    = data.getCellData(sheetName,"SpaceType", rowNum)
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum)
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum)
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum)
		String prjCity 		= data.getCellData(sheetName, "City", rowNum)
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum)
		String prjState 	= data.getCellData(sheetName, "State", rowNum)
		String annualRidership  = data.getCellData(sheetName,"annual_ridership", rowNum)
		String fullTimeStaffAtStn= data.getCellData(sheetName,"fulltime_staff", rowNum)
		String avgTimeSpent      = data.getCellData(sheetName,"avg_time_spent", rowNum)
		String weeklyOprHrs      = data.getCellData(sheetName,"week_opr_hrs", rowNum)

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectName'),'value'),prjName, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/unitType'),'value'),"string:IP", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/spaceType'),'value'),"string:Laboratory", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAddress'),'value'),prjAddress, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCity'),'value'), prjCity, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectState'),'value'), prjState, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCountry'),'value'),prjCountry, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjPrivate'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerType'),'value'),"string:Educational: College, Public", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerOrg'),'value'),ownerOrg, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerCountry'),'value'),ownerCountry, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerEmail'),'value'),ownerEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/preLEEDCertified'),'value'), "boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/containsResUnits'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedHigherEducation'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedLEEDLab'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/precertify'),'value'),"boolean:false", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),prjArea, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/stationType'),'value'),"aboveground", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/annualRidership'),'value'),annualRidership, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/fullTimeStaffAtStn'),'value'),fullTimeStaffAtStn, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/avgTimeSpent'),'value'),avgTimeSpent, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/week_opr_hrs'),'value'),weeklyOprHrs, false, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	public void verifyEnergyPortfolioManagerAppInstallByDefault(){

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/

		WebUI.scrollToElement(findTestObject('Object Repository/Manage/App/a_ Apps'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Manage/App/a_ Apps'))
		WebUI.delay(2)

		println "Verify Portfolio Manager App present"
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/BPortfolioManager'))
		String text = WebUI.getText(findTestObject('Object Repository/Manage/App/BPortfolioManager'))
		WebUI.verifyMatch(text,"Installed",false, FailureHandling.CONTINUE_ON_FAILURE)

		println "Uninstalling App and check uninstalled message."
		WebUI.click(findTestObject('Object Repository/Manage/App/BPortfolioManager'))
		WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/AppUninstalledMessage'))
	}


	@Keyword
	public void verifyOccAndOprHrsNotZero(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'), 2)

		println "Verify if the value of occupancy and operating hours are zero or not"
		Assert.assertNotEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),0,"Not Valid")
		Assert.assertNotEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),0,"Not Valid")
		println "Verified successfully the value of occupancy and operating hours are not zero"
	}

	@Keyword
	public void verifyManageProjectOccAndOprHrsNotZero(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'), 2)
		println "Verify if the value of occupancy and operating hours are zero or not"
		WebUI.clearText(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'))
		WebUI.sendKeys(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'),'0')
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/ProjectDetailVerification/oprHrsErrorMessage'))
		WebUI.clearText(findTestObject('Object Repository/Manage/ProjectDetailVerification/occupancy'))
		WebUI.sendKeys(findTestObject('Object Repository/Manage/ProjectDetailVerification/occupancy'), '0')
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/ProjectDetailVerification/occErrorMessage'))

		println "Verified successfully the value of occupancy and operating hours are not zero"
	}

	@Keyword
	public void verifyTransitOccAndOprHrsNotZero(String sheetName, int rowNum){


		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'), 2)

		println "Verify if the value of occupancy and operating hours are zero or not"

		/*WebUI.clearText(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'))
		 WebUI.sendKeys(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'),'0')*/
		WebUI.setText(findTestObject('Object Repository/Manage/ProjectDetailVerification/input_operatingHours'),'0')
		WebUI.delay(2)
		//WebUI.click(findTestObject('Manage/ProjectdetailVerification/input_operatingHours'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/ProjectDetailVerification/oprHrsErrorMessage'))
		println "Verified successfully the value of Transit occupancy and operating hours are not zero"
	}

	@Keyword
	public void verifyFieldNumOfResUnitPresent(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Manage/Project/is_Residential'), 1)
		println "Verify if the text 'Number of Residential Unit' present"
		WebUI.selectOptionByLabel(findTestObject('Manage/Project/is_Residential'), 'Yes', false)
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/Project/label_NumberOfResidentialunit'), 2)
		println "Verified successfully the text 'Number of Residential Unit' is present"
	}

	@Keyword
	public void verifyNameOfSchoolFieldPresent(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Project/Is_affiliatedHigherEducation'), 2)
		println "Verify the field 'Name of the School' is visible, if option for 'Is project affiliated with a higher education institute?' chosen as 'Yes'"
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Manage/Project/Is_affiliatedHigherEducation'), 'Yes', true)
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(10)
		Assert.assertTrue(WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Project/nameOfTheSchool')))
		println "Verified successfully the text 'Name of School' is present"
	}

	@Keyword
	public void VerifyGFAUnitOnChangeOfUnitsIPAndSI(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		println "Verify if the unit changes on the changing of unit type."
		WebUI.selectOptionByLabel(findTestObject('Manage/Project/selectUnitType'), 'IP', false)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Manage/Project/unit'), 2)
		WebUI.delay(1)
		String unit = WebUI.getText(findTestObject('Manage/Project/unit'))
		WebUI.verifyMatch(unit,"square feet",false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Manage/Project/selectUnitType'), 2)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Manage/Project/selectUnitType'), 'SI', false)
		WebUI.delay(3)
		String unitSI = WebUI.getText(findTestObject('Manage/Project/unitSI'))
		WebUI.verifyMatch(unitSI,"square meters",false)
		println "Verified successfully unit changes on the selection of SI and IP unit types."
	}

	@Keyword
	public void verifyCalculatorLinkPresent(String sheetName, int rowNum){
		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		println "Verify if the calculator hyperlink present on the Manage section."
		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'), 2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/Project/calculator'))
		WebUI.delay(5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/Project/CalculatorPopupText')), 'UPLOAD METER DATA' , false)
		println "Verified successfully calculate hyperlink present on the Manage section."
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/Project/CloseCalculatorPopUp'))

	}

	@Keyword
	public void verifyOccEffectiveDate(String sheetName, int rowNum){

		//String effectiveDate     = data.getCellData(sheetName, "EffectiveAt", rowNum)
		String occupancy     = data.getCellData(sheetName, "occupancy", rowNum)

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)
		println "Verify if the effective date visible on updating the occupancy"
		WebUI.scrollToElement(findTestObject('Manage/Project/label_occupancy'), 1)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Manage/ProjectdetailVerification/projectoccupancy'),occupancy)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/ProjectdetailVerification/input_operatingHours'))
		WebUI.delay(6)
		def effectiveDate = WebUI.getText(findTestObject('Manage/Project/effectiveDate'))
		println "............................................."+effectiveDate
		WebUI.delay(2)
		SimpleDateFormat month = new SimpleDateFormat("MMM")
		SimpleDateFormat day = new SimpleDateFormat("dd")
		SimpleDateFormat year = new SimpleDateFormat("YYYY")
		//+" at " + date.format('hh:mm a')
		def dateNew = "(Effective At: "+ month.format(new Date()) +" " +day.format(new Date()) +", " +year.format(new Date())
		println "............................................."+dateNew
		String [] effectiveDateNew = effectiveDate.split("at", 2)
		println "............................................."+ effectiveDateNew[0]
		WebUI.verifyMatch(effectiveDateNew[0], dateNew+" ", true)
		println "Verified successfully effective date visible on updating the occupancy."
	}



	public static void datePickerTargetCertiDate(){

		WebUI.click(findTestObject('Manage/ProjectDetailVerification/targetDate'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickOnCalender'))
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickDateSwitch'), 5)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickDateSwitch'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickMonthSwitch'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickYearToSelect'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickMonthToSelect'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/ProjectDetailVerification/Target Date Picker/ClickDateToSelect'))

	}


	@Keyword
	public void EditFieldsOnBuildingManageProject(String sheetName, int rowNum){

		//ReusNavigate.navigateToManageSection()
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(3)

		println "Verify if the fields on Manage project section are editable."
		String num = CommonMethod.randomNumber()
		WebUI.setText(findTestObject('Manage/ProjectDetailVerification/projectName'),"Test building None "+num)
		WebUI.delay(2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectName'),'value'),"Test building None "+num,"Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/unitType'), 'SI', false)
		WebUI.delay(2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/unitType'),'value'),"string:SI","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/spaceType'), 'Data Center', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/spaceType'),'value'),"string:Data Center","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/prjPrivate'), 'No', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjPrivate'),'value'),"boolean:false","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/ownerType'), 'Investor: Bank', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/ownerType'),'value'),"string:Investor: Bank","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/preLEEDCertified'), 'Yes', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/preLEEDCertified'),'value'),"boolean:true","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/otherCertiPrgrm'), 'Other', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/otherCertiPrgrm'),'value'),"string:Other","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/containsResUnits'), 'Yes', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/containsResUnits'),'value'),"boolean:true","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedHigherEducation'), 'Yes', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedHigherEducation'),'value'),"boolean:true","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedLEEDLab'), 'No', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/prjAffiliatedLEEDLab'),'value'),"boolean:false","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/yearBuilt'), '1992', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/yearBuilt'),'value'),"string:1992","Not Valid")

		WebUI.clearText(findTestObject('Manage/ProjectDetailVerification/input_grossArea'))
		WebUI.sendKeys(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),"3000" )
		WebUI.delay(1)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'), "3000","Not Valid")

		WebUI.selectOptionByLabel(findTestObject('Manage/ProjectDetailVerification/precertify'), 'Yes', false)
		WebUI.delay(3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/precertify'),'value'),"boolean:true","Not Valid")

		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/floorsAboveGround'), 1)

		WebUI.clearText(findTestObject('Manage/ProjectDetailVerification/floorsAboveGround'))
		WebUI.sendKeys(findTestObject('Manage/ProjectDetailVerification/floorsAboveGround'),"10")
		WebUI.delay(1)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/floorsAboveGround'),'value'),"10","Not Valid")

		//WebUI.clearText(findTestObject('Manage/ProjectDetailVerification/targetDate'))
		//WebUI.sendKeys(findTestObject('Manage/ProjectDetailVerification/targetDate'),"Oct 22, 2028")
		//datePickerTargetCertiDate()
		//WebUI.delay(5)
		//Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/targetDate'),'value'), "Oct 11, 2020","Not Valid")
		//WebUI.click(findTestObject('Manage/ProjectDetailVerification/floorsAboveGround'))

		WebUI.clearText(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'))
		WebUI.sendKeys(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),"10")
		WebUI.delay(1)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),"10","Not Valid")

		WebUI.clearText(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'))
		WebUI.sendKeys(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),"300")
		WebUI.delay(1)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),"300","Not Valid")

		println "Verified successfully fields are editable on Manage project section."
	}

	@Keyword
	public void EditParksmartFieldsOnManageProject(String sheetName, int rowNum){
		WebUI.clearText(findTestObject('Manage/Parking/ParkingLevels'))
		WebUI.sendKeys(findTestObject('Manage/Parking/ParkingLevels'),"10")
		WebUI.delay(1)
		WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Manage/Parking/ParkingLevels'),'value'),"10", false, FailureHandling.CONTINUE_ON_FAILURE)
	}


	//Manage Team Methods
	@Keyword
	public void verifyprjAdminAndArcAdministratorinTeamSection(String sheetName, int rowNum){
		String prjTeamAdminName= data.getCellData(sheetName, "prjTeamAdminName", rowNum)
		String prjTeamAdminEmail= data.getCellData(sheetName, "prjTeamAdminEmail", rowNum)
		String prjTeamArcAdministratorName= data.getCellData(sheetName, "prjTeamArcAdministratorName", rowNum)
		String prjTeamArcAdministratorEmail= data.getCellData(sheetName, "prjTeamArcAdministratorEmail", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		 WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		//WebUI.delay(3)
		String prjAdminName= WebUI.getText(findTestObject('Object Repository/Manage/TeamModule/prjAdminName'))
		WebUI.verifyMatch(prjAdminName, prjTeamAdminName, false, FailureHandling.CONTINUE_ON_FAILURE)
		String prjAdminAuthorizationLevel = WebUI.getText(findTestObject('Manage/TeamModule/prjAdminAuthorizationLevel'))
		WebUI.verifyMatch(prjAdminAuthorizationLevel,"Project Admin", false, FailureHandling.CONTINUE_ON_FAILURE)
		String prjAdminEmail= WebUI.getText(findTestObject('Manage/TeamModule/prjAdminEmail'))
		WebUI.verifyMatch(prjAdminEmail, prjTeamAdminEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
		String prjArcAdministratorName= WebUI.getText(findTestObject('Object Repository/Manage/TeamModule/ArcAdministratorName'))
		WebUI.verifyMatch(prjArcAdministratorName, prjTeamArcAdministratorName, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/ArcAdministratorAuthorizationLevel'),"Arc Administrator", false, 1)
		String prjArcAdministratorEmail= WebUI.getText(findTestObject('Object Repository/Manage/TeamModule/ArcAdministratorEmail'))
		WebUI.verifyMatch(prjArcAdministratorEmail, prjTeamArcAdministratorEmail, false, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public void addTeamMember(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/input_input'), 2)
		WebUI.setText(findTestObject('Manage/TeamModule/input_input'),GlobalVariable.TeamMember)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/TeamModule/button_Add Member'))
		WebUI.delay(12)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/newMemberAddedAuthorizationLevel'),"Team Member", false,10)
	}

	@Keyword
	public void addSameTeamMemberRoleAgain(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		// WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/input_input'), 2)
		WebUI.setText(findTestObject('Manage/TeamModule/input_input'),GlobalVariable.TeamMember)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/TeamModule/button_Add Member'))
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/sameRoleAddAgainErrMsg'))
		WebUI.clearText(findTestObject('Manage/TeamModule/input_input'))
	}

	@Keyword
	public void editProjectAdminRole(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */	
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		// WebUI.delay(5)

		WebUI.verifyElementNotPresent(findTestObject('Manage/TeamModule/prjAdminEditButton'), 3)
	}

	@Keyword
	public void editArcAdministratorRole(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */ 
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('Manage/TeamModule/ArcAdministratorEditButton'))
		WebUI.delay(2)
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/ArcAuthLevelSelect'), 'Team Member', false)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/TeamModule/ArcAdmistratorSaveBtn'))
		WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Manage/TeamModule/atleastOneArcAdministratorPresentMsg'))
	}

	@Keyword
	public void editTeamManagerAndAddSecondArcAdministratorRole(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		//WebUI.delay(5)
		WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.delay(3)
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/newMemberAddedAuthorizationLevel'), 'Arc Administrator', false)
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/TeamModule/button_Save'))
		//WebUI.delay(1)
		//WebUI.verifyElementVisible(findTestObject('Manage/TeamModule/TeamMemberUpdateSuccessMsg'))
		WebUI.delay(7)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/TeamRole'),"Arc Administrator", false,10)

	}

	@Keyword
	public void editTeamMemberRole(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		//WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		//WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		//WebUI.delay(6)
		//WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.delay(2)
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/newMemberAddedAuthorizationLevel'), 'Team Manager', false)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/TeamModule/button_Save'))
		WebUI.delay(8)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/TeamRole'),"Team Manager", false,10)
	}
	@Keyword
	public void verifyTeamMemberDefautRoleMem(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		 WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		 WebUI.delay(5)
		 WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))*/
		/*****************Verifying default added role as team member **************************************************/ 
		WebUI.delay(5)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/TeamRole'),"Team Member", false,10)
	}
	@Keyword
	public void editTeamNonetoMemberRole(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		 WebUI.delay(5)*/
		WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/newMemberAddedAuthorizationLevel'), 'Team Member', false)
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/TeamModule/button_Save'))
		/*	WebUI.delay(2)
		 WebUI.verifyElementVisible(findTestObject('Manage/TeamModule/TeamMemberUpdateSuccessMsg'))*/
		WebUI.delay(8)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/TeamRole'),"Team Member", false,10)
	}


	@Keyword
	public void editAuthLevelToNone(){
		ReusableMethodsDataInput.clickCancel()
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 */
		WebUI.delay(6)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/newMemberAddedAuthorizationLevel'), 'None', false)
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/TeamModule/button_Save'))
		WebUI.delay(5)
		WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Manage/TeamModule/newMemberAddedAuthorizationLevel'),'None', false,10)
		/*WebUI.delay(1)
		 WebUI.verifyElementVisible(findTestObject('Manage/TeamModule/TeamMemberUpdateSuccessMsg'))
		 */
	}


	@Keyword
	public void verifyOnlyOneProjectAdminPresent(){
		/*WebUI.delay(6)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(6)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		/*	WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		 */WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		//WebUI.delay(5)
		//WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.delay(3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/TeamModule/RoleAdmin')),"Project Admin", false)
		WebUI.delay(1)
	}


	//Permission requests section is present
	@Keyword
	public void permissionRequestFieldVerification(){
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/PermissionRequestTitle'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/EmailField'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/DataRequestField'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/StatusField'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/ActionsField'))
	}

	//Permission requests section is not present
	@Keyword
	public void permissionRequestFieldNotPresentVerification(){
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/PermissionRequestTitle'),5)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/EmailField'),5)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/DataRequestField'),5)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/StatusField'),5)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Manage/TeamModule/PermissionRequestSection/ActionsField'),5)
	}

	//Manage Billing Section


	public static String verifyBillingDate() throws IOException, InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY")
		LocalDateTime now = LocalDateTime.now()
		return dtf.format(now)
		System.out.println(dtf.format(now))
	}


	public static String currentTime() throws IOException, InterruptedException {
		Calendar cal = Calendar.getInstance()
		Date date=cal.getTime()
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a")
		String formattedDate=dateFormat.format(date)

	}

	@Keyword
	public void verifyBillingOrderFileDownload(String sheetName, int rowNum){

		//Verify the billing order file
		String orderId = data.getCellData(sheetName,"OrderId", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		//WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/DownloadBilling'))
		WebUI.delay(6)
		print orderId +".pdf"
		Assert.assertTrue(ReusDataInput.isFileDownloaded(orderId +".pdf"), "Order File Didn't downloaded successfully")
		println "Order File downloaded and verified successfully"
	}

	@Keyword
	public void billingStatus(String sheetName, int rowNum){
		WebUI.delay(2)
		String regdAmt = data.getCellData(sheetName, "RegAmount", rowNum)
		String reviewAmt = data.getCellData(sheetName, "ReviewAmount", rowNum)
		String registrationDate = data.getCellData(sheetName, "RegDate", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))
		//Registration Payment details verification
		WebUI.delay(5)
		String regDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/registrationPaymentDate'))
		String regOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationOrderId'))
		String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		data.setCellData(sheetName, "OrderId", rowNum,regOrderId)
		String regOrderType= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/span_REGISTRATION'))
		String regAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationAmount'))
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))

		WebUI.verifyMatch(regDate, registrationDate, false , FailureHandling.CONTINUE_ON_FAILURE)
		// Assert.assertEquals(regAmount, regdAmt)
		WebUI.verifyMatch(regOrderType, "REGISTRATION", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(regStatus, "Completed", false, FailureHandling.CONTINUE_ON_FAILURE)
		String reviewAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewAmount'))
		WebUI.verifyMatch(reviewAmt, reviewAmount, false)
		//Review Payment details verification
		/*
		 String revieDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentDate'))
		 String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		 String reviewAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewAmount'))
		 String reviewStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		 String revieworderId = data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		 Assert.assertEquals(revieDate, verifyBillingDate() )
		 //	Assert.assertEquals(reviewAmount, reviewAmt)
		 Assert.assertEquals(reviewStatus, "Completed")*/
	}


	@Keyword
	public void billingStatusTransit(String sheetName, int rowNum){
		WebUI.delay(2)
		String regdAmt = data.getCellData(sheetName, "DiscRegAmount", rowNum)
		String reviewAmt = data.getCellData(sheetName, "DiscReviewAmount", rowNum)
		String registrationDate = data.getCellData(sheetName, "RegDate", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))

		//Registration Payment details verification

		WebUI.delay(5)

		String regDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/registrationPaymentDate'))
		String regOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationOrderId'))
		String regOrderType= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/span_REGISTRATION'))
		String regAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationAmount'))
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))
		String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		data.setCellData(sheetName, "OrderId", rowNum,regOrderId)
		data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		WebUI.verifyMatch(regDate,registrationDate , false, FailureHandling.CONTINUE_ON_FAILURE)
		// Assert.assertEquals(regAmount, regdAmt)
		WebUI.verifyMatch(regOrderType, "REGISTRATION",false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(regStatus, "Completed",false, FailureHandling.CONTINUE_ON_FAILURE)

		//Review Payment details verification
		/*
		 String revieDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentDate'))
		 String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		 String reviewAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewAmount'))
		 String reviewStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		 String revieworderId = data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		 Assert.assertEquals(revieDate, verifyBillingDate() )
		 //	Assert.assertEquals(reviewAmount, reviewAmt)
		 Assert.assertEquals(reviewStatus, "Completed")*/
	}




	@Keyword
	public void billingStatusParking(String sheetName, int rowNum){
		WebUI.delay(5)
		String regdAmt = data.getCellData(sheetName, "RegAmount", rowNum)
		String registrationDate = data.getCellData(sheetName, "RegDate", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/BillingParksmart'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/BillingParksmart'))

		//Registration Payment details verification
		WebUI.delay(5)

		String regDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/registrationPaymentDate'))
		String regOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationOrderId'))
		data.setCellData(sheetName, "OrderId", rowNum,regOrderId)
		String regOrderType= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/span_REGISTRATION'))
		String regAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationAmount'))
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))



		WebUI.verifyMatch(regDate, registrationDate ,false,FailureHandling.CONTINUE_ON_FAILURE)
		// Assert.assertEquals(regAmount, regdAmt)
		WebUI.verifyMatch(regOrderType, "REGISTRATION",false)
		WebUI.verifyMatch(regStatus, "Completed",false)

		//Review Payment details verification
		/*
		 String revieDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentDate'))
		 String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		 String reviewAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewAmount'))
		 String reviewStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		 String revieworderId = data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		 Assert.assertEquals(revieDate, verifyBillingDate() )
		 //	Assert.assertEquals(reviewAmount, reviewAmt)
		 Assert.assertEquals(reviewStatus, "Completed")*/
	}


	//Manage certification Section

	@Keyword
	public void certificationDetailVerification(String sheetName ,int rowNum){
		String certiType= data.getCellData(sheetName, "CertiType", rowNum)
		String certiLevel= data.getCellData(sheetName, "CertiLevel", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/CertificationAndScore/a_ Certifications'), 2)
		WebUI.click(findTestObject('Manage/CertificationAndScore/a_ Certifications'))
		WebUI.delay(2)
		String certificationType= WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationType'))
		WebUI.verifyMatch(certificationType, certiType, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		String certificationLevel = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationLevel'))
		WebUI.verifyMatch(certificationLevel,certiLevel,false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		String certificationDate = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationDateNotCertifiedProjects'))
		WebUI.verifyMatch(certificationDate, "Pending", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		print certificationDate
		Assert.assertTrue(WebUI.verifyElementNotVisible(findTestObject('Object Repository/Manage/CertificationAndScore/leedLogo')))
	}


	@Keyword
	public void certificationDetailVerificationForPointsAddedFromAdminTool(String sheetName ,int rowNum){
		String certiType= data.getCellData(sheetName, "CertiTypeForCertifiedProjects", rowNum)
		String certiDate = commMethod.dateNew()
		print certiDate
		WebUI.delay(5)
		WebUI.doubleClick(findTestObject('Manage/CertificationAndScore/a_ Certifications'))
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(5)

		String certificationType= WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationType'))
		WebUI.verifyMatch(certificationType, certiType, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		String certificationLevel = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationLevelPlatinum'))
		WebUI.verifyMatch(certificationLevel,'Platinum', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		String certificationPoints= WebUI.getText(findTestObject('Manage/CertificationAndScore/subCertificationPoints'))
		WebUI.verifyMatch(certificationPoints, '80', false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		/*String certificationDate = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationDate'))
		 Assert.assertEquals(certificationDate, certiDate,"Certification date status Didn't matched")
		 print certificationDate*/

		String certificationDate = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationDate'))
		WebUI.verifyMatch(certificationDate, certiDate, false, FailureHandling.CONTINUE_ON_FAILURE)
		print certificationDate
		WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/CertificationAndScore/leedLogo'))
	}


	@Keyword
	public void verifyLogoVisible(String sheetName ,int rowNum){
		//ReusNavigate.navigateToManageSection()
		println "Verify LOGO displayed in Certification section for Certified project."
		//WebUI.scrollToElement(findTestObject('Manage/CertificationAndScore/a_ Certifications'), 2)
		WebUI.click(findTestObject('Manage/CertificationAndScore/a_ Certifications'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/CertificationAndScore/leedLogo'))
		println "Verified successfully LOGO displayed in Certification section for Certified project."
	}


	// Manage Agreement section

	@Keyword
	public void verifyAgreementFileDownload(){
		deleteFile(BaseClass.ServiceAgreement)
		//WebUI.delay(10)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(4)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/button_Download'))
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('Agreement.pdf'), "Agreement File Didn't downloaded successfully")
		println "Agreemnent File downloaded and verified successfully"
	}

	@Keyword
	public void verifyAgreementDateSignAndType(){
		//String agreementDate = data.getCellData(sheetName, "RegDate", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(4)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(3)

		/*String dateSigned = WebUI.getText(findTestObject('Manage/VerifyAgreementFile/dateSigned'))
		 Assert.assertEquals(dateSigned, commMethod.dateNew(),"Agreement date signed is not correct.")
		 WebUI.delay(2)*/
		String type = WebUI.getText(findTestObject('Manage/VerifyAgreementFile/agreementType'))
		WebUI.verifyMatch(type,"Registration" ,false)
		println "Agreement File downloaded and verified successfully"
	}

	@Keyword
	public void verifyAgreementDateSignAndTypeparking(String sheetName, int rowNum)
	{
		String agreementDate = data.getCellData(sheetName, "RegDate", rowNum)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(4)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		/*		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		 WebUI.delay(3)*/
		String dateSigned = WebUI.getText(findTestObject('Manage/VerifyAgreementFile/dateSigned'))
		WebUI.verifyMatch(dateSigned, agreementDate, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		String type = WebUI.getText(findTestObject('Manage/VerifyAgreementFile/agreementType'))
		WebUI.verifyMatch(type,"Registration" ,false, FailureHandling.CONTINUE_ON_FAILURE)
		println "Agreement File downloaded and verified successfully"
	}

	@Keyword
	public void verifyAgreementLOProjectsAgreementType(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(4)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(6)
		String type = WebUI.getText(findTestObject('Manage/VerifyAgreementFile/agreementTypeLO'))
		WebUI.verifyMatch(type,"Addendum" ,false)
		println "Agreement File downloaded and verified successfully"
	}


	@Keyword
	public void verifyAgreementFileDownloadParking(){
		deleteFile(BaseClass.ServiceAgreement)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(8)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.click(findTestObject('Manage/Parking/Manage'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/button_Download'))
		WebUI.delay(10)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('Agreement.pdf'), "Agreement File Didn't downloaded successfully")
		println "Agreemnent File downloaded and verified successfully"
	}

	@Keyword
	public void verifymeasureDownloadfileParking(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Page_Arc dashboard/a_ Management'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/span_A1 - Parking Pricing'))
		WebUI.delay(10)
		WebUI.click(findTestObject('Manage/Parking/Naviation/button_Measure Language (PDF)'))
		WebUI.delay(10)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('A1 - Parking Pricing'), "Measue file Didn't downloaded successfully")
		println "Agreemnent File downloaded and verified successfully"
	}

	@Keyword
	public void verifyAgreementLOProjectsAgreementDetails(String sheetName, int rowNum){

		String name  = data.getCellData(sheetName, "prjTeamAdminName", rowNum)
		String email = data.getCellData(sheetName, "prjTeamAdminEmail", rowNum)
		String id = data.getCellData(sheetName, "UserId", rowNum)
		String prjName = data.getCellData(sheetName, "ProjectName", rowNum)
		String ownerEmail = data.getCellData(sheetName, "OwnerEmail", rowNum)

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(3)
		WebUI.verifyMatch("Addendum", WebUI.getText(findTestObject('Object Repository/Manage/VerifyAgreementFile/Addenum')), false)
		/*WebUI.click(findTestObject('Manage/VerifyAgreementFile/buttonAddendumDownload'))
		 WebUI.delay(3)
		 Assert.assertTrue(ReusDataInput.isFileDownloaded('Agreement.pdf'), "Addendum agreement File Didn't downloaded successfully")
		 println "Addendum agreement File downloaded and verified successfully"
		 WebUI.delay(3)
		 FileInputStream fis = null;
		 try {
		 fis = new FileInputStream(BaseClass.Addendum);
		 }
		 catch (Exception e) {
		 e.printStackTrace();
		 }
		 PDDocument doc = PDDocument.load(fis);
		 String pdfText = new PDFTextStripper().getText(doc);
		 doc.close();
		 fis.close();
		 println(pdfText);
		 Assert.assertTrue(pdfText.contains("User Name : "+name), "PDF not contains the required user name.");
		 Assert.assertTrue(pdfText.contains("User Email : "+email), "PDF not contains the required user email.");
		 Assert.assertTrue(pdfText.contains("User ID : "+id), "PDF not contains the required user id.");
		 //Assert.assertTrue(pdfText.contains("Date of Acceptance : "+date), "PDF not contains the required date.");
		 Assert.assertTrue(pdfText.contains("Name of Project : "+prjName), "PDF not contains the required project name.");
		 Assert.assertTrue(pdfText.contains("Owner Email : "+ownerEmail), "PDF not contains the required owner email.");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org/resources/agent-authority"), "PDF not contains the hypelink: http://www.usgbc.org/resources/agent-authority ");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org"), "PDF not contains the hypelink: http://www.usgbc.org ");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org/cert-guide"), "PDF not contains the hypelink: http://www.usgbc.org/cert-guide ");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org/cert-guide/fees"), "PDF not contains the hypelink: http://www.usgbc.org/cert-guide/fees ");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org/trademarks"), "PDF not contains the hypelink: http://www.usgbc.org/trademarks ");
		 Assert.assertTrue(pdfText.contains("http://www.usgbc.org/resources/change-of-owner"), "PDF not contains the hypelink: http://www.usgbc.org/resources/change-of-owner");
		 Assert.assertTrue(pdfText.contains("http://usgbc.org/resources/primary-owner"), "PDF not contains the hypelink: http://usgbc.org/resources/primary-owner ");
		 Assert.assertTrue(pdfText.contains("legal@gbci.org"), "PDF not contains the hypelink: legal@gbci.org");
		 */


	}

	//Verify the order history
	@Keyword
	public void verifyOrderHistoryUSGBC(String sheetName, int rowNum){
		String name  = data.getCellData(sheetName, "OrderId", rowNum)
		String orderId = data.getCellData(sheetName, "ReviewId", rowNum)
		String orderDate = data.getCellData(sheetName, "RegDate", rowNum)
		String amount = data.getCellData(sheetName, "ReviewAmountReceipt", rowNum)
		//ReusableMethodsLogin.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/USGBCAccount/ClickOnAccountMenu'))
		WebUI.click(findTestObject('Object Repository/USGBCAccount/ClickOnMyAccount'))
		WebUI.delay(4)
		WebUI.switchToWindowIndex(1)
		WebUI.delay(5)
		//ReusableMethodsLogin.waitForPageToLoadCompletely(60)
		WebUI.click(findTestObject('Object Repository/USGBCAccount/ClickOnOrderHistory'))
		
		ReusableMethodsLogin.waitForPageToLoadCompletely(60)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/USGBCAccount/SearchBarUSGBC'))
		WebUI.sendKeys(findTestObject('Object Repository/USGBCAccount/SearchBarUSGBC'),orderId )
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Object Repository/USGBCAccount/ClickOnSearchButton'))
		WebUI.delay(15)
	//	ReusableMethodsLogin.waitForPageLoad(60)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/USGBCAccount/OrderDate')), orderDate, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/USGBCAccount/OrderId')), orderId, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/USGBCAccount/TotalAmount')), amount, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/USGBCAccount/OrderStatus')), 'Completed', false, FailureHandling.CONTINUE_ON_FAILURE)
	//WebUI.verifyElementVisible(findTestObject('Object Repository/USGBCAccount/PayNowButton'), FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static String pdfReader(String pdfFilePath){
		FileInputStream fis
		try {
			fis = new FileInputStream(pdfFilePath)
			PDDocument doc = PDDocument.load(fis)
			String pdfText = new PDFTextStripper().getText(doc)
			//String pdfText = new PDFTextStripper().getT
			doc.close()
			fis.close()
			return pdfText
		}
		catch (Exception e) {
			e.printStackTrace()
		}

	}


	@Keyword
	public void downloadAndVerifyReviewReceipt(String sheetName, int rowNum){
		String reviewId= data.getCellData(sheetName, "ReviewId", rowNum)
		String reviewAmt= data.getCellData(sheetName, "ReviewAmountReceipt", rowNum)
		String itemDesc= data.getCellData(sheetName, "ItemDesc2", rowNum)
		String reviewArea= data.getCellData(sheetName, "ReviewArea", rowNum)
		String itemDisc= data.getCellData(sheetName, "ItemDisc2", rowNum)
		String isStation = data.getCellData(sheetName, "is_station", rowNum)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/DownloadBillingReview'))
		WebUI.delay(6)
		print reviewId +".pdf"
		Assert.assertTrue(ReusDataInput.isFileDownloaded(reviewId +".pdf"), "Order File Didn't downloaded successfully")
		String pdflinks= pdfReader(downloadPath+reviewId+".pdf")
		print pdflinks
		int arr= pdflinks.indexOf(itemDesc)
		String totalPaid
		String subString= pdflinks.substring(arr, pdflinks.indexOf("Total ")+25)
		//print arr
		println subString
		def result = []
		def userName= []
		def userEmail=[]
		result = subString.split("\\r?\\n")
		String itemDescription= itemDesc+"  "+reviewArea+"     ("+ itemDisc+")  "+ reviewAmt
		
		totalPaid="Total Paid   "+reviewAmt
		WebUI.verifyMatch(itemDescription, result[0].trim() , false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(totalPaid, result[1].trim(), false, FailureHandling.CONTINUE_ON_FAILURE)
	}



	@Keyword
	public void verifyBillingReceiptAmountDetail(String sheetName, int rowNum){
		String orderId= data.getCellData(sheetName, "OrderId", rowNum)
		String regAmt= data.getCellData(sheetName, "RegAmountReceipt", rowNum)
		String shipping= data.getCellData(sheetName, "Shipping", rowNum)
		String salesTax= data.getCellData(sheetName, "SalesTax", rowNum)
		String itemDesc= data.getCellData(sheetName, "ItemDesc1", rowNum)
		String itemDisc= data.getCellData(sheetName, "ItemDisc1", rowNum)
		String ratingSystem = data.getCellData(sheetName, "RatingSystem", rowNum)
		String pdflinks= pdfReader(downloadPath+orderId+".pdf")
		//print pdflinks
		int arr= pdflinks.indexOf(itemDesc)
		String itemDescription
		String subString= pdflinks.substring(arr, pdflinks.indexOf("Total Paid")+25)
		//print arr
		//println subString
		def result = []
		def userName= []
		def userEmail=[]
		result = subString.split("\\r?\\n")
		//println result[0].trim()
		//println result[1].trim()
		//println result[2].trim()
		//println result[3].trim()
		if(ratingSystem.equalsIgnoreCase("Parksmart")){
			itemDescription= itemDesc+" 1  "+ regAmt +"     ("+ itemDisc+")  "+ regAmt
		}
		else{
			itemDescription= itemDesc+" 1.000  "+ regAmt +"     ("+ itemDisc+")  "+ regAmt
		}

		String shippingHandling= "Shipping/Handling  "+ shipping
		String saleTax="Sales Tax   "+salesTax
		String totalPaid="Total Paid   "+regAmt
		WebUI.verifyMatch(itemDescription, result[0].trim() , false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(shippingHandling, result[1].trim(), false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(saleTax, result[2].trim(), false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(totalPaid, result[3].trim(), false, FailureHandling.CONTINUE_ON_FAILURE)

	}



	@Keyword
	public void ReadAgreementPDF(String sheetName, int rowNum)
	{
		String name  = data.getCellData(sheetName, "prjTeamAdminName", rowNum)
		String email = data.getCellData(sheetName, "prjTeamAdminEmail", rowNum)
		String id = data.getCellData(sheetName, "UserId", rowNum)
		String date = data.getCellData(sheetName, "RegDate", rowNum)
		String prjName = data.getCellData(sheetName, "ProjectName", rowNum)
		String ownerEmail = data.getCellData(sheetName, "OwnerEmail", rowNum)

		//String[] pdfText= readAgreement(BaseClass.ServiceAgreement)

		String pdflinks= pdfReader(BaseClass.ServiceAgreement)
		print pdflinks
		int arr= pdflinks.indexOf("User Name")
		String subString= pdflinks.substring(arr, pdflinks.length())
		print arr
		println subString
		def result = []
		def userName= []
		def userEmail=[]
		def userId=[]
		def dateOfAccept=[]
		def nameOfProject=[]
		def ownerMail=[]
		result = subString.split("\\r?\\n")
		userName= result[0].split(":")
		println userName[1].trim()
		userEmail=result[1].split(":")
		println userEmail[1].trim()
		userId=result[2].split(":")
		println userId[1].trim()
		dateOfAccept=result[3].split(":")
		dateOfAccept[1].trim()
		nameOfProject=result[4].split(":",2)
		println nameOfProject[1].trim()
		ownerMail=result[5].split(":")
		println ownerMail[1].trim()

		String string1= dateOfAccept[1].substring(0, dateOfAccept[1].indexOf("at")).trim()
		String string2=string1.substring(5)
		String agreementDate= string2.substring(3,6)+" "+ string2.substring(0,2) + ", "+ string2.substring(7)
		println(agreementDate)

		WebUI.verifyMatch(userName[1].trim(), name, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(userEmail[1].trim(), email, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(userId[1].trim(), id, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(ownerMail[1].trim(), ownerEmail , false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(nameOfProject[1].trim(), prjName, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(date,agreementDate, false, FailureHandling.CONTINUE_ON_FAILURE)

		/*)
		 //println(pdfText);
		 println("project name in excel"+prjName);
		 Assert.assertEquals(userName[1].trim(),"User Name : "+ name, "PDF not contains the required user name.")
		 Assert.assertEquals(userEmail[1].trim(),"User Email : "+ email, "PDF not contains the required user email.")
		 Assert.assertEquals(userId[1].trim(),"User ID : " + id , "PDF not contains the required user id.")
		 Assert.assertEquals(agreementDate, date, "PDF not contains the required date.")
		 Assert.assertEquals(nameOfProject[1].trim(),"Name of Project : " + prjName, "PDF not contains the required project name.")
		 Assert.assertEquals(ownerMail[1].trim(),"Owner Email : " + ownerEmail, "PDF not contains the required owner email.")
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org/resources/agent-authority"), "PDF not contains the hypelink: http://www.usgbc.org/resources/agent-authority ");
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org"), "PDF not contains the hypelink: http://www.usgbc.org ");
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org/cert-guide"), "PDF not contains the hypelink: http://www.usgbc.org/cert-guide ");
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org/cert-guide/fees"), "PDF not contains the hypelink: http://www.usgbc.org/cert-guide/fees ");
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org/trademarks"), "PDF not contains the hypelink: http://www.usgbc.org/trademarks ");
		 Assert.assertTrue(pdflinks.contains("http://www.usgbc.org/resources/change-of-owner"), "PDF not contains the hypelink: http://www.usgbc.org/resources/change-of-owner");
		 Assert.assertTrue(pdflinks.contains("http://usgbc.org/resources/primary-owner"), "PDF not contains the hypelink: http://usgbc.org/resources/primary-owner ");
		 Assert.assertTrue(pdflinks.contains("legal@gbci.org"), "PDF not contains the hypelink: legal@gbci.org");*/

	}

	public void verifyAgreementLinks()
	{
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(4)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/buttonAddendumDownload'))
		WebUI.delay(3)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('Agreement.pdf'), "Addendum agreement File Didn't downloaded successfully")
		println "Addendum agreement File downloaded and verified successfully"
		WebUI.delay(3)
		//list = WebUI.getAllLinksOnCurrentPage(true, [])
	}


	public void deleteFile(String PDFURL)
	{
		File file = null
		boolean bool = false
		try {
			file = new File(PDFURL)
			bool = file.delete()
			println "File deleted: "+bool
		}
		catch (Exception e) {
			e.printStackTrace()
		}

	}


	// Manage Score Version

	@Keyword
	public void scoreVersionVerification(){
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		 WebUI.delay(5)*/
		WebUI.scrollToElement(findTestObject('Manage/CertificationAndScore/a_ Score Version'),2)
		WebUI.click(findTestObject('Manage/CertificationAndScore/a_ Score Version'))
		String scoreVersion = WebUI.getText(findTestObject('Manage/CertificationAndScore/h3_Arc score v2.0'))
		WebUI.verifyMatch(scoreVersion, "Arc score v2.0",false, FailureHandling.CONTINUE_ON_FAILURE)
		print scoreVersion
		String scoreStatus= WebUI.getText(findTestObject('Manage/CertificationAndScore/h4_You are all up to date'))
		WebUI.verifyMatch(scoreStatus, "You are all up to date!",false,FailureHandling.CONTINUE_ON_FAILURE )
		print scoreStatus
	}

	@Keyword
	public void verifyScoreUpdatePopupAndComparisionPage(){
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/Manage/CertificationAndScore/scoreLearnMoreBtn'))
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/CertificationAndScore/currentVersion'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/CertificationAndScore/newVersion'))
		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/Manage/Setting/ScroeVersionPageSkipButton'))
		WebUI.navigateToUrl(GlobalVariable.AllProjectUrl)
	}


	// Manage App Section

	@Keyword
	public void verifyAppInstalledOnDataInputPage(){

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Object Repository/DataInput/a_ Data Input'))
		WebUI.delay(14)
		WebUI.click(findTestObject('DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.delay(3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/BuildingComputerFile'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/buildingDropbox'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/buildingGoogleDrive'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/BuildingOnedrive'), 2)

	}

	@Keyword
	public void verifyAppInstalledOnAddSupportingDocuments(){

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 //WebUI.delay(1)
		 //WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(3)*/
		WebUI.doubleClick(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/cityCommComputerFile'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/cityCommDropbox'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/cityCommGoogleDrive'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/cityCommOneDrive'))


	}

	@Keyword
	public void verifyAppRemovedOnAddSupportingDocumentsCityComm(){

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 //WebUI.delay(1)
		 //WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(3)*/
		WebUI.doubleClick(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/cityCommComputerFile'))
		WebUI.verifyElementNotVisible(findTestObject('Object Repository/Manage/App/cityCommDropbox'))
		WebUI.verifyElementNotVisible(findTestObject('Object Repository/Manage/App/cityCommGoogleDrive'))
		WebUI.verifyElementNotVisible(findTestObject('Object Repository/Manage/App/cityCommOneDrive'))

	}

	@Keyword
	public void verifyUnInstallMsgByUnInstallingApps() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		println "Clicking on Apps"
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/App/a_ Apps'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Manage/App/a_ Apps'))
		WebUI.delay(2)

		println "Installing Dropbox"
		WebUI.click(findTestObject('Object Repository/Manage/App/BDropbox'))
		//WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/App/AppUninstalledMessage'),20)

		println  "Installing OneDrive"
		WebUI.click(findTestObject('Object Repository/Manage/App/BOneDrive'))
		//WebUI.delay(1)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/App/AppUninstalledMessage'),20)

		println  "Installing GoogleDrive"
		WebUI.click(findTestObject('Object Repository/Manage/App/BgoogleDrive'))
		//WebUI.delay(5)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/App/AppUninstalledMessage'),20)

	}


	@Keyword
	public void installCustomApps() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		println "Clicking on Apps"
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/App/a_ Apps'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Manage/App/a_ Apps'))
		WebUI.delay(8)

		println "Installing Dropbox"
		WebUI.doubleClick(findTestObject('Object Repository/Manage/App/BDropbox'))
		WebUI.delay(1)
		//	WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/AppInstalledSuccessMsg'))
		WebUI.delay(4)
		println  "Installing OneDrive"
		WebUI.doubleClick(findTestObject('Object Repository/Manage/App/BOneDrive'))
		WebUI.delay(1)
		//	WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/AppInstalledSuccessMsg'))
		WebUI.delay(4)
		println  "Installing GoogleDrive"
		WebUI.doubleClick(findTestObject('Object Repository/Manage/App/BgoogleDrive'))
		WebUI.delay(1)
		//	WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/App/AppInstalledSuccessMsg'))
	}

	//Manage Settings
	@Keyword
	public void verifySettingPageDetailsBuildingAndTransit() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))*/
		//WebUI.delay(1)
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		//WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/lobbySurveyText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/makeScorePublicText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/receiveEmailsText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/plaqueAnimationText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/dataResourcesText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/dataReviewChecklistText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/setDefaultPageText'))

	}

	@Keyword
	public void verifySettingPageDetailsTransitDownloadUserMannual() throws IOException, InterruptedException {
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/downloadUserMannualText'))

	}

	@Keyword
	public void verifySettingPageDetailsCityAndCommunity() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		WebUI.delay(3)

		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/makeScorePublicText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/receiveEmailsText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/plaqueAnimationText'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/setDefaultPageText'))

	}

	@Keyword
	public void verifyLobbyBtnRemailOnAfterNavigationFromOtherPage() throws IOException, InterruptedException {
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(3)*/
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/Manage/Setting/lobbySurveyBtn'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/App/a_ Apps'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/Setting/a_setting'))
		WebUI.delay(3)
		WebUI.verifyElementChecked(findTestObject('Object Repository/Manage/Setting/lobbySurveyBtnOn'), 5)
		//WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/lobbySurveyBtnOn'))

	}

	@Keyword
	public void verifyPlaqueAnimationUrlVisible() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Manage/Setting/animationLink'))
	}

	@Keyword
	public void verifyDataResourceAndDataReviewChecklistPdfDownload() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/Setting/downloadResourceBtn'))
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('DataResources.pdf'), "DataResources File Didn't downloaded successfully")
		WebUI.delay(3)
		deleteFile(BaseClass.DataResourcesPdf)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Manage/Setting/dataReviewChecklistDownloadBtn'))
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('Data Review Checklist.pdf'), "DataResources File Didn't downloaded successfully")
		deleteFile(BaseClass.DataReviewChecklistPdf)
	}

	@Keyword
	public void verifyPlaqueAnimationVisbleInNewWindow(String sheetName, int rowNum) throws IOException, InterruptedException {
		String name  = data.getCellData(sheetName, "ProjectName", rowNum)
		String address = data.getCellData(sheetName, "Address", rowNum)
		String country = data.getCellData(sheetName, "OwnerCountry", rowNum)
		WebDriver driver  = DriverFactory.getWebDriver()
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('Manage/Setting/a_setting'))
		//WebUI.delay(3)
		WebUI.click(findTestObject('Manage/Setting/animationLinkCopyBtn'))
		WebUI.delay(4)
		Robot r = new Robot()
		/*r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_T);
		 r.keyRelease(KeyEvent.VK_CONTROL)
		 r.keyRelease(KeyEvent.VK_T)
		 WebUI.delay(4)
		 //To switch to the new tab
		 WebUI.switchToWindowIndex(1)*/

		((JavascriptExecutor)driver).executeScript('window.open("");')
		WebUI.switchToWindowIndex(1)
		WebUI.delay(2)
		r.keyPress(KeyEvent.VK_CONTROL)
		r.keyPress(KeyEvent.VK_T)
		r.delay(200)
		r.keyRelease(KeyEvent.VK_CONTROL)
		r.keyRelease(KeyEvent.VK_T)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(2)
		WebUI.delay(2)
		r.keyPress(KeyEvent.VK_CONTROL)
		r.keyPress(KeyEvent.VK_V)
		r.keyRelease(KeyEvent.VK_CONTROL)
		r.keyRelease(KeyEvent.VK_V)
		WebUI.delay(2)
		r.keyPress(KeyEvent.VK_ENTER)
		r.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(30)

		Assert.assertEquals(WebUI.getText(findTestObject('Manage/Setting/projectTitleOnAnimationPage')),name)
		//Assert.assertEquals(WebUI.getText(findTestObject('Manage/Setting/projectAddressOnAnimationPage')),address+", "+country)
		WebUI.closeWindowIndex(2)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)


	}

	@Keyword
	public void verifySubmitSurveyMultipleTimes(String sheetName) throws IOException, InterruptedException {
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(15)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/Survey/CopySurveyLink'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/Survey/English'))
		WebUI.delay(2)
		WebDriver driver  = DriverFactory.getWebDriver()
		for( int rowNum=2;rowNum<=2;rowNum++)
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


				Robot r = new Robot()
				((JavascriptExecutor)driver).executeScript('window.open("");')
				WebUI.switchToWindowIndex(1)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_T)
				r.delay(200)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_T)
				WebUI.switchToWindowIndex(2)
				WebUI.delay(2)

				//WebUI.navigateToUrl("")
				WebUI.delay(2)
				r.keyPress(KeyEvent.VK_CONTROL)
				r.keyPress(KeyEvent.VK_V)
				r.delay(200)
				r.keyRelease(KeyEvent.VK_CONTROL)
				r.keyRelease(KeyEvent.VK_V)
				WebUI.delay(2)
				r.keyPress(KeyEvent.VK_ENTER)
				r.keyRelease(KeyEvent.VK_ENTER)
				WebUI.delay(10)
				/*if((WebUI.verifyElementVisible(findTestObject('DataInput/Survey/ACCEPTANDCLOSE'))))
				 WebUI.click(findTestObject('DataInput/Survey/ACCEPTANDCLOSE'))*/
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
				 WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/Survey/ThankMessageMultipleSurvey')), "Thank you for taking our survey!", false)
				 *
				 */
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
				WebUI.delay(3)
				println "Survey Submited Successufully"
				WebUI.closeWindowIndex(2)
			}
			/*else{
			 //WebUI.click(findTestObject('Object Repository/DataInput/Survey/ReloadSurvey'))
			 String walk1 = data.getCellData(sheetName, "Walk", rowNum)
			 String walk2 = data.getCellData(sheetName, "Bus", rowNum)
			 String walk3 = data.getCellData(sheetName, "Tram", rowNum)
			 String walk4 = data.getCellData(sheetName, "Heavyrail", rowNum)
			 String walk5 = data.getCellData(sheetName, "Motorcycle", rowNum)
			 String walk6 = data.getCellData(sheetName, "Carsolo", rowNum)
			 String walk7 = data.getCellData(sheetName, "Carpool", rowNum)
			 String walk8 = data.getCellData(sheetName, "Caralternative", rowNum)
			 String name = data.getCellData(sheetName, "Name", rowNum)
			 //WebUI.click(findTestObject('DataInput/Survey/ACCEPTANDCLOSE'))
			 WebUI.click(findTestObject('Object Repository/DataInput/Survey/ClickOnSelectTravelMethod'))
			 int j=1
			 (1..8).each{
			 WebUI.setText(findTestObject('Object Repository/DataInput/Survey/InputMileage',[index: it]), "walk" + j)
			 j++
			 }
			 WebUI.click(findTestObject('Object Repository/DataInput/Survey/SaveButtonToRecordSurveyData'))
			 WebUI.dragAndDropToObject(findTestObject('Object Repository/DataInput/Survey/SatisfactionSlider'), findTestObject('Object Repository/DataInput/Survey/ExtremelySatisfySpanText'))
			 WebUI.click(findTestObject('DataInput/Survey/Submit'))
			 WebUI.delay(3)
			 WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/DataInput/Survey/ThankMessageMultipleSurvey')), "Thank you for taking our survey!", false)
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
			 WebUI.delay(3)
			 println "Survey Submited Successufully"
			 }*/
		}
		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
	}


	//verify the SEZ files in billing sesction India Project

	@Keyword
	public void verifySEZFilesBillingSection(){
		/*WebUI.delay(2)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))

		//Registration Payment details verification
		WebUI.delay(6)
		String regOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationOrderId'))
		WebUI.doubleClick(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZDocIcon'))
		WebUI.delay(4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileOne')), regOrderId + "-Clause-X-Taxes.pdf", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileTwo')), "uploasExcel.xlsx", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileThree')), "uploadPng.png", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileFour')), "uploadGif.gif", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileFive')), "uploadDoc.docx", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileSix')), "txtFileUpload.txt", false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/SEZFiles/SEZFileSeven')), "Parking SJ.jpg", false, FailureHandling.CONTINUE_ON_FAILURE)

	}




	/*public static void unzip(){
	 String source = "D:\\Katalon\\AutomationArc\\Automation\\Download\\GBCI-India.zip"
	 String destination = "D:\\Katalon\\AutomationArc\\Automation\\DriverFiles"
	 String password = "password";
	 try {
	 ZipFile zipFile = new ZipFile(source)
	 zipFile.extractAll(destination)
	 } catch (ZipException e) {
	 e.printStackTrace()
	 }
	 }
	 */


	public static void unzip(String zipFilePath, String destDirectory) throws IOException {

		File destDir = new File(destDirectory)
		if (!destDir.exists()) {
			destDir.mkdir()
		}
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))
		ZipEntry entry = zipIn.getNextEntry()
		// iterates over entries in the zip file
		while (entry != null) {
			String filePath = destDirectory + File.separator + entry.getName()
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath)
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath)
				dir.mkdir()
			}
			zipIn.closeEntry()
			entry = zipIn.getNextEntry()
		}
		zipIn.close()
	}

	private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))
		byte[] bytesIn = new byte[BUFFER_SIZE]
		int read = 0
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read)
		}
		bos.close()
	}

	@Keyword

	public void verifyGBCIDocsFromZippedFolder(){
		deleteFile(sourceZipFile)
		deleteFile(sourceExtractedFile)
		WebUI.delay(5)
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))*/
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/DownloadGBCIDocs'))
		WebUI.delay(6)
		unzip(sourceZipFile, destinationUnZippedFolder)
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileExtracted('GBCI Citibank Cancelled Cheque.pdf'), " GBCI Citibank Cancelled Cheque File Didn't downloaded successfully")
		Assert.assertTrue(ReusDataInput.isFileExtracted('GBCI PAN Card.pdf'), "GBCI PAN Card File Didn't downloaded successfully")
		Assert.assertTrue(ReusDataInput.isFileExtracted('GBCI-Noida-GST Registration Certificate.pdf'), "GBCI-Noida-GST Registration Certificate File Didn't downloaded successfully")

	}



	/*//Pdf line by line reader
	 static List<String> lines = new ArrayList<String>()
	 public ReusableMethodsManage() throws IOException {
	 }
	 public String[] readAgreement(String agreement){
	 PDDocument document = null
	 def pdfResult = new String[10]
	 try {
	 document = PDDocument.load( new File(agreement) )
	 PDFTextStripper stripper = new ReusableMethodsManage();
	 stripper.setSortByPosition( true );
	 stripper.setStartPage( 0 );
	 stripper.setEndPage( document.getNumberOfPages() );
	 Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
	 stripper.writeText(document, dummy);
	 println(lines.get(475));
	 println(lines.get(476));
	 println(lines.get(477));
	 println(lines.get(478));
	 println(lines.get(479));
	 println(lines.get(480));
	 //lines.get(lines.indexOf())
	 // print lines
	 for(String line:lines){
	 System.out.println(line);
	 }
	 int start=475;
	 for (int i=0; i<=5;i++) {
	 pdfResult[i]= lines.get(start);
	 start++;
	 //System.out.println(pdfResult[i]);
	 }
	 }
	 finally {
	 if( document != null ) {
	 document.close();
	 }
	 }
	 return pdfResult
	 }
	 *//**
	 * Override the default functionality of PDFTextStripper.writeString()
	 *//*
	 @Override
	 protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
	 lines.add(str);
	 // you may process the line here itself, as and when it is obtained
	 }
	 */


	@Keyword
	public void readAgreementPDFParking(String sheetName, int rowNum)
	{
		String name  = data.getCellData(sheetName, "prjTeamAdminName", rowNum)
		String email = data.getCellData(sheetName, "prjTeamAdminEmail", rowNum)
		String id = data.getCellData(sheetName, "UserId", rowNum)
		String date = data.getCellData(sheetName, "RegDate", rowNum)
		String prjName = data.getCellData(sheetName, "ProjectName", rowNum)
		String ownerEmail = data.getCellData(sheetName, "OwnerEmail", rowNum)

		String pdfText= pdfReader(BaseClass.ServiceAgreement)

		println(pdfText)
		println("project name in excel"+prjName)
		//Assert.assertTrue(pdfText.contains("PARKSMART™ SERVICES AGREEMENT"), "Parking Agreement is not downloaded");
		Assert.assertTrue(pdfText.contains("User Name : "+name), "PDF not contains the required user name.")
		Assert.assertTrue(pdfText.contains("User Email : "+email), "PDF not contains the required user email.")
		Assert.assertTrue(pdfText.contains("User ID : "+id), "PDF not contains the required user id.")
		Assert.assertTrue(pdfText.contains("Date of Acceptance"), "Date of Acceptance is not displays")

		Assert.assertTrue(pdfText.contains("Name of Project : "+prjName), "Downloaded agreement PDF does not contains the mandatory field project name.")
		Assert.assertTrue(pdfText.contains("Owner Email : "+ownerEmail), "PDF not contains the required owner email.")
		// Assert.assertTrue(pdfText.contains("Date of Acceptance : "+ date), "PDF not contains the required date.");

	}


	/*@Keyword
	 public void getTestDesc(){
	 BodyContentHandler handler = new BodyContentHandler();
	 Metadata metadata = new Metadata();
	 FileInputStream inputstream = new FileInputStream(new File(
	 CommonMethod.ServiceAgreement));
	 ParseContext pcontext = new ParseContext();
	 //parsing the document using PDF parser
	 PDFParser pdfparser = new PDFParser();
	 pdfparser.parse(inputstream, handler, metadata,pcontext);
	 //getting the content of the document
	 System.out.println("Contents of the PDF :" + handler.toString());
	 //getting metadata of the document
	 System.out.println("Metadata of the PDF:");
	 String[] metadataNames = metadata.names();
	 for(String name : metadataNames) {
	 System.out.println(name+ " : " + metadata.get(name));
	 }
	 }*/

	@Keyword
	public void tVOCNotificaitonTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/Not/div_Total Volatile Organic Com'))
		WebUI.delay(6)
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton1'))
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton2'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/Not/Tvo/svg_Total Volatile Organic Com'),3)

		//WebUI.verifyElementPresent(findTestObject('DataInput/Not/Tvo/p_Missing InformationUnsaved C'),5)



	}

	@Keyword
	public void co2NotificationTest() throws IOException, InterruptedException {
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		//	WebUI.delay(12)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/Not/div_Carbon Dioxide'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton1'))
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton2'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('DataInput/Not/CO2Notification'),5)

	}
	@Keyword
	public void EnergyNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/div_AnalyticsEnergy Meter via'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton1'))
		//	 WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton2'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/NotSym/svg_AnalyticsEnergy Meter via'),5)

	}
	@Keyword
	public void WaterNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/div_AnalyticsWater meter via u'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton1'))
		//	 WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton2'))
		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/NotSym/svg_AnalyticsWater meter via u'),5)

	}
	@Keyword
	public void WasteNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/div_Waste Data'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/PerformanceScore/DataInput/Delete'))
		// WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton2'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/DataInput/NotSym/svg_Waste Data_error_symbol er'),5)

	}
	@Keyword
	public void nottVOCNotificaitonTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/Not/Tvo/svg_Total Volatile Organic Com'),3)
	}

	@Keyword
	public void notNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/Not/CO2Notification'),5)

	}
	@Keyword
	public void notEnergyNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/NotSym/svg_AnalyticsEnergy Meter via'),5)

	}
	@Keyword
	public void notWaterNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/NotSym/svg_AnalyticsWater meter via u'),5)

	}
	@Keyword
	public void notWasteNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DataInput/NotSym/svg_Waste Data_error_symbol er'),5)

	}

	@Keyword
	public void notTRNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/Notification/svg_Transportation Survey_erro'),5)

	}
	@Keyword
	public void notOCCNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/Notification/svg_Occupant Satisfaction Surv'),5)

	}

	@Keyword
	public void aqinotNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Air Quality Index_error_sy'),5)

	}
	@Keyword
	public void carbonMoxnotNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Carbon Monoxide_error_symb'),5)

	}
	@Keyword
	public void NitrogennotNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Nitrogen Dioxide_error_sym'),5)

	}

	@Keyword
	public void OzonenotNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Ozone_error_symbol error_s'),5)

	}
	@Keyword
	public void pm10NotificationTest() throws IOException, InterruptedException {
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('DataInput/TRNotification/div_Pm10'),5)
		WebUI.click(findTestObject('DataInput/TRNotification/div_Pm10'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('DataInput/TRNotification/svg_PM10_error_symbol error_sy'),5)

	}
	@Keyword
	public void pm25NotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_PM2.5_error_symbol error_s'),5)

	}
	@Keyword
	public void sulferDiol25NotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Sulfur Dioxide_error-headin'),5)

	}

	@Keyword
	public void riderShipNotificationTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		println "Before Refresh."
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Ridership_error_symbol err'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.refresh()
		println "After Refresh."
		WebUI.delay(5)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Ridership_error_symbol err'),5)


	}
	@Keyword
	public void riderShipCreateMeterTest() throws IOException, InterruptedException {
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(14)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/TRNotification/div_Ridership'),10)
		WebUI.click(findTestObject('Object Repository/DataInput/TRNotification/div_Ridership'))
		WebUI.delay(5)
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

		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'),'2323')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataInput/SuccessGreenTick'),20)
		WebUI.delay(15)
	}

	@Keyword
	public void verifyNotificationEffectOtherSectionTest() throws IOException, InterruptedException {
		WebUI.delay(1)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Air Quality Index_error_sy'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Carbon Monoxide_error_symb'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Nitrogen Dioxide_error_sym'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Ozone_error_symbol error_s'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_PM2.5_error_symbol error_s'),5,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('DataInput/TRNotification/svg_Sulfur Dioxide_error-headin'),5,FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	public void deleteRiderShipReadingTest() throws IOException, InterruptedException {
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/TRNotification/div_Ridership'),10)
		WebUI.click(findTestObject('Object Repository/DataInput/TRNotification/div_Ridership'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataInput/CityC/DeleteButton1'))
		WebUI.delay(5)
	}

}
