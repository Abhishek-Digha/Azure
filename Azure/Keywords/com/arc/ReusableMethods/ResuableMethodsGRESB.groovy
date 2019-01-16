package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ResuableMethodsGRESB extends BaseClass {
	ReusableMethodsDataInput reusableMethodsDataInput = new ReusableMethodsDataInput()
	ReusableMethodsNavigation reusableMethodsNavigation = new ReusableMethodsNavigation()
	
	SimpleDateFormat formatarDate = new SimpleDateFormat(' HH:mm:ss')

	@Keyword
	public void  downloadGresbtemplete() throws IOException, InterruptedException {
		WebUI.delay(5)

		WebUI.click(findTestObject('Portfolio/GRESB/button_Import from GRESB'))
		WebUI.delay(5)

		WebUI.click(findTestObject('Portfolio/GRESB/a_Download GRESB Template'))
		WebUI.delay(5)

		WebUI.click(findTestObject('Portfolio/GRESB/a_Download GRESB Template'))
		WebUI.delay(5)
		Assert.assertTrue(reusableMethodsDataInput.isFileDownloaded('2018-GRESB-Asset-Spreadsheet.xlsx'), 'Failed to download Expected document')

		WebUI.click(findTestObject('Object Repository/Portfolio/GRESB/a_template'))
		WebUI.delay(5)
		Assert.assertTrue(reusableMethodsDataInput.isFileDownloaded('2018-GRESB-Asset-Spreadsheet.xlsx'), 'Failed to download Expected document')
	}

	@Keyword
	public void  createGresbData(String sheetName, int rowNum) throws IOException, InterruptedException {

		String ownerType 	= data.getCellData(sheetName, "GOwnerType", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "GOwnerOrganization", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "GOwnerEmail", rowNum);
		String ownerCountry = data.getCellData(sheetName, "GOwnerCountry", rowNum);

		WebUI.click(findTestObject('Portfolio/GRESB/button_Import from GRESB'))
		WebUI.delay(5)

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Portfolio/GRESB/select_Select Owner TypeBusine'), ownerType, false)
		WebUI.click(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'), ownerOrg)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/Portfolio/GRESB/div_U.S. Army'))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Portfolio/GRESB/input_Owner Email_form-control'), ownerMail)
		WebUI.delay(2)

		WebUI.selectOptionByLabel(findTestObject('Portfolio/GRESB/OwnerCountry'),ownerCountry, false)
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/GRESB/button_Browse'))
		WebUI.delay(2)
		ReusableMethodsDataInput.uploadFile(gresbUpload)
		//WebUI.sendKeys(findTestObject('Portfolio/GRESB/button_Browse'),BaseClass.gresbUpload )

		WebUI.delay(4)
		WebUI.click(findTestObject('Portfolio/GRESB/button_UPLOAD'))
		WebUI.delay(15)


	}
	@Keyword
	public void  addOwnerOrg(String sheetName, int rowNum) throws IOException, InterruptedException {

		String ownerType 	= data.getCellData(sheetName, "GOwnerType", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "GOwnerOrganization", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "GOwnerEmail", rowNum);
		String ownerName = data.getCellData(sheetName, "GOwnerOrg", rowNum);


		/*	WebUI.click(findTestObject('Portfolio/GRESB/button_Import from GRESB'))
		 WebUI.delay(5)*/

		WebUI.click(findTestObject('Portfolio/GRESB/Owner/a_Click here'))
		WebUI.delay(2)

		String ownerName1= ownerName.substring(0, 9)
		String OwnerName = ownerName1 +formatarDate.format(date)
		data.setCellData(sheetName,"GOwnerOrg", rowNum, OwnerName)

		WebUI.sendKeys(findTestObject('Portfolio/GRESB/Owner/input_Organization Name_name'), OwnerName)


		WebUI.sendKeys(findTestObject('Portfolio/GRESB/Owner/input_Owner Contact Email_owne'), ownerMail)
		WebUI.sendKeys(findTestObject('Portfolio/GRESB/Owner/input_concat(Owner  s Represen'), ownerMail)

		WebUI.sendKeys(findTestObject('Portfolio/GRESB/Owner/input_Website_form-control ng'),'www.testautomation.com')

		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/GRESB/Owner/button_ADD'))
		WebUI.delay(4)

		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Owner/GRESBImportImage'),2)
	}

	@Keyword
	public void  searchAddedOwnerOrg(String sheetName, int rowNum) throws IOException, InterruptedException {

		String OwnerName = data.getCellData(sheetName, "GOwnerOrg", rowNum);

		WebUI.clearText(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'))
		WebUI.delay(1)

		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'), OwnerName)
		WebUI.delay(4)

		WebUI.click(findTestObject('Object Repository/Portfolio/GRESB/input_Click here_gresb-search'))
		WebUI.delay(5)

		String regMemberName = WebUI.getText(findTestObject('Object Repository/Portfolio/GRESB/Owner/OwnerOrgList'))

		WebUI.verifyMatch(regMemberName,OwnerName,false )
	}

	@Keyword
	public void signAggrementScoreComp() throws IOException, InterruptedException {
		WebUI.delay(10)
		WebUI.waitForElementClickable(findTestObject('Portfolio/GRESB/Owner/ISTProj'),10)
		WebUI.click(findTestObject('Portfolio/GRESB/Owner/ISTProj'))
		WebUI.delay(10)

		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Owner/button_Sign Agreement1'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Owner/ScoreComp1'),2)

		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Owner/button_Sign Agreement2'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Owner/ScoreComp2'),2)
	}
	@Keyword
	public void acceptAggrement() throws IOException, InterruptedException {
		
		WebUI.click(findTestObject('Portfolio/GRESB/Owner/button_Sign Agreement1'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Portfolio/GRESB/AcceptFromPort'),5)
		WebUI.click(findTestObject('Portfolio/GRESB/AcceptFromPort'))
		WebUI.delay(8)
		WebUI.verifyElementPresent(findTestObject('Portfolio/GRESB/Reg'),10)
		
		reusableMethodsNavigation.navigateToBuilding()
		
		WebUI.click(findTestObject('Portfolio/GRESB/AServiceProj'))
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Portfolio/GRESB/ProjAccept'),5)
		WebUI.click(findTestObject('Portfolio/GRESB/ProjAccept'))
		WebUI.delay(2)
		
		
		
	}
	
}
