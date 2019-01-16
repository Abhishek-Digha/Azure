package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



public class ReusableMethodsSearch extends BaseClass{
	/*************Search By Project ID **************************************/
	@Keyword
	public void searchProgram(String sheetName , int rowNum) {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		//	WebUI.click(findTestObject('Page_Arc dashboard/sideBar'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		//	if(WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))!= null)
		//	WebUI.clearText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.setText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'), projectId)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.delay(3)
		String nuberOfProjects = WebUI.getText(findTestObject('Page_Arc dashboard/no_Project (1 project)'))
		println nuberOfProjects
		WebUI.verifyMatch(nuberOfProjects,'Project (1 project)', false)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/search_Result'))

	}

	@Keyword
	public void searchProgramForNoProjectPresent(String sheetName , int rowNum) {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		//	WebUI.click(findTestObject('Page_Arc dashboard/sideBar'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))

		//	if(WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))!= null)
		//	WebUI.clearText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))

		WebUI.setText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'), projectId)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.delay(3)
		String nuberOfProjects = WebUI.getText(findTestObject('Page_Arc dashboard/no_Project (0 project)'))
		println nuberOfProjects
		WebUI.verifyMatch(nuberOfProjects,'Project (0 projects)', false)
		WebUI.delay(2)
		/*WebUI.closeWindowIndex(1)
		 WebUI.delay(3)
		 WebUI.switchToWindowIndex(0)*/
	}

	/*************Search By Project Name **************************************/
	@Keyword
	public void searchProgramByName(String sheetName , int rowNum) {
		String projectName = data.getCellData(sheetName,"ProjectName",rowNum)

		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.clearText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))

		WebUI.setText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'), projectName)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.delay(3)
		String nuberOfProjects = WebUI.getText(findTestObject('Page_Arc dashboard/no_Project (1 project)'))
		println nuberOfProjects
		WebUI.verifyMatch(nuberOfProjects,'Project (1 project)', false)
	}


	@Keyword
	public void searchProgramPortfolio(String sheetName, int rowNum) {
		String projectName = data.getCellData(sheetName,"ProjectName",rowNum)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.setText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'), projectName)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.delay(3)
		String nuberOfProtfolio = WebUI.getText(findTestObject('Portfolio/Common/TNoPortfolio (1 portfolio)'))
		println nuberOfProtfolio
		WebUI.verifyMatch(nuberOfProtfolio,'Portfolio (1 portfolio)', false)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/search_Result'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
	}
}

