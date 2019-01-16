package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ResuableMethodsPerformanceScore extends BaseClass {

	ReusableMethodsLogin reusableMethodsLogin = new ReusableMethodsLogin()
	ReusableMethodsSearch reusableMethodsSearch = new ReusableMethodsSearch()

	@Keyword
	public void genratePerformanceScoreAdminTool(String sheetName,int rowNum) throws IOException, InterruptedException {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScoreButton'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('PerformanceScore/PorjectId'),projectId)
		WebUI.delay(2)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScore'))
		WebUI.delay(15)

		String energyScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyScore'))
		String waterScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterSocre'))
		String wasteScore = WebUI.getText(findTestObject('PerformanceScore/Score/WasteScore'))
		String transportScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportScore'))
		String humanExpScore = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExperianceScore'))
		String basePointScore = WebUI.getText(findTestObject('PerformanceScore/Score/BasePointPScore'))

		double energyscore = Double.parseDouble(energyScore)
		double waterscore =  Double.parseDouble(waterScore)
		double wastescore =  Double.parseDouble(wasteScore)
		double transportscore = Double.parseDouble(transportScore)
		double humexpscore =    Double.parseDouble(humanExpScore)
		double basepointscore = Double.parseDouble(basePointScore)
		double totalPerformanceScore = energyscore + waterscore + wastescore + transportscore + humexpscore + basepointscore
		String totalperformanceScore = Math.round(totalPerformanceScore)
		//String totalperformanceScore = Double.toString(totalPerformanceScore)
		println totalperformanceScore

		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
		//Search the project
		reusableMethodsSearch.searchProgram(sheetName,rowNum)
		WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
		WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Total'))
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TotalPerformanceScore'),10)
		WebUI.delay(25)
		//Verifying the Performance score
		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		print totalperformaceScore
		WebUI.verifyMatch(totalperformaceScore , totalperformanceScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/BasePointScore'),10)
		String basepointScore = WebUI.getText(findTestObject('PerformanceScore/Score/BasePointScore'))
		WebUI.verifyMatch(basepointScore , basePointScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/EnergyPerScore'),10)
		String energyperScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyPerScore'))
		WebUI.verifyMatch(energyperScore , energyScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WaterPerScore'),10)
		String waterpfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterPerScore'))
		WebUI.verifyMatch(waterpfScore ,waterScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WastePerSocre'),10)
		String wastepfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WastePerSocre'))
		WebUI.verifyMatch(wastepfScore ,wasteScore , false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TransportperScore'),10)
		String transportperScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportperScore'))
		WebUI.verifyMatch(transportperScore ,transportScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/HumanExpScore'),10)
		String humanExperience = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExpScore'))
		WebUI.verifyMatch(humanExperience ,humanExpScore, false)

		/********* Verifying the Generated score for total score & Energy & Water & Waste & Transport & Human Experience under data Input section ********/
		WebUI.click(findTestObject('PerformanceScore/DataInput/a_ Data Input'))
		WebUI.delay(14)

		WebUI.waitForElementPresent(findTestObject('PerformanceScore/DataInput/TotalScore'),10)
		//Verifying the Performance score
		String totalPerformaceScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/TotalScore'))
		print totalPerformaceScore
		WebUI.verifyMatch(totalPerformaceScore ,totalperformanceScore, false)

		String energyPerScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/EnergyScore'))
		WebUI.verifyMatch(energyPerScore , energyScore, false)

		String waterPfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		WebUI.verifyMatch(waterPfScore ,waterScore, false)

		String wastePfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WasteScore'))
		WebUI.verifyMatch(wastePfScore ,wasteScore , false)

		String transPortperScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/TransportScore'))
		WebUI.verifyMatch(transPortperScore ,transportScore, false)

		String humanexperience = WebUI.getText(findTestObject('PerformanceScore/DataInput/HumanExp'))
		WebUI.verifyMatch(humanexperience ,humanExpScore, false)

	}

	@Keyword
	public void genratePerformanceScoreAdminToolOtherNone(String sheetName,int rowNum) throws IOException, InterruptedException {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScoreButton'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('PerformanceScore/PorjectId'),projectId)
		WebUI.delay(2)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScore'))
		WebUI.delay(20)

		String energyScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyScore'))
		String waterScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterSocre'))
		String wasteScore = WebUI.getText(findTestObject('PerformanceScore/Score/WasteScore'))
		String transportScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportScore'))
		String humanExpScore = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExperianceScore'))

		double energyscore = Double.parseDouble(energyScore)
		double waterscore =  Double.parseDouble(waterScore)
		double wastescore =  Double.parseDouble(wasteScore)
		double transportscore = Double.parseDouble(transportScore)
		double humexpscore =    Double.parseDouble(humanExpScore)
		double totalPerformanceScore = energyscore + waterscore + wastescore + transportscore + humexpscore
		String totalperformanceScore = Math.round(totalPerformanceScore)
		//String totalperformanceScore = Double.toString(totalPerformanceScore)
		println totalperformanceScore

		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)
		//Search the project
		reusableMethodsSearch.searchProgram(sheetName,rowNum)

		WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
		WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Total'))
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TotalPerformanceScore'),10)
		WebUI.delay(15)
		//Verifying the Performance score
		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		print totalperformaceScore
		WebUI.verifyMatch(totalperformaceScore , totalperformanceScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/EnergyPerScore'),10)
		String energyperScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyPerScore'))
		WebUI.verifyMatch(energyperScore , energyScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WaterPerScore'),10)
		String waterpfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterPerScore'))
		WebUI.verifyMatch(waterpfScore ,waterScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WastePerSocre'),10)
		String wastepfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WastePerSocre'))
		WebUI.verifyMatch(wastepfScore ,wasteScore , false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TransportperScore'),10)
		String transportperScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportperScore'))
		WebUI.verifyMatch(transportperScore ,transportScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/HumanExpScore'),10)
		String humanExperience = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExpScore'))
		WebUI.verifyMatch(humanExperience ,humanExpScore, false)

		/********* Verifying the Generated score for total score & Energy & Water & Waste & Transport & Human Experience under data Input section ********/
		WebUI.click(findTestObject('PerformanceScore/DataInput/a_ Data Input'))
		WebUI.delay(14)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/DataInput/TotalScore'),10)
		//Verifying the Performance score
		String totalPerformaceScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/TotalScore'))
		print totalPerformaceScore
		WebUI.verifyMatch(totalPerformaceScore ,totalperformanceScore, false)

		String energyPerScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/EnergyScore'))
		WebUI.verifyMatch(energyPerScore , energyScore, false)

		String waterPfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		WebUI.verifyMatch(waterPfScore ,waterScore, false)

		String wastePfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WasteScore'))
		WebUI.verifyMatch(wastePfScore ,wasteScore , false)

		String transPortperScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/TransportScore'))
		WebUI.verifyMatch(transPortperScore ,transportScore, false)

		String humanexperience = WebUI.getText(findTestObject('PerformanceScore/DataInput/HumanExp'))
		WebUI.verifyMatch(humanexperience ,humanExpScore, false)

	}

	@Keyword
	public void genratePerformanceScoreAdminToolCityComLEED(String sheetName,int rowNum) throws IOException, InterruptedException {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScoreButton'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('PerformanceScore/PorjectId'),projectId)
		WebUI.delay(2)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScore'))
		WebUI.delay(15)

		String energyScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyScore'))
		String waterScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterSocre'))
		String wasteScore = WebUI.getText(findTestObject('PerformanceScore/Score/WasteScore'))
		String transportScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportScore'))
		String humanExpScore = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExperianceScore'))
		String basePointScore = WebUI.getText(findTestObject('PerformanceScore/Score/BasePointPScore'))

		double energyscore = Double.parseDouble(energyScore)
		double waterscore =  Double.parseDouble(waterScore)
		double wastescore =  Double.parseDouble(wasteScore)
		double transportscore = Double.parseDouble(transportScore)
		double humexpscore =    Double.parseDouble(humanExpScore)
		double basepointscore = Double.parseDouble(basePointScore)
		double totalPerformanceScore = energyscore + waterscore + wastescore + transportscore + humexpscore + basepointscore
		String totalperformanceScore = Math.round(totalPerformanceScore)
		//String totalperformanceScore = Double.toString(totalPerformanceScore)
		println totalperformanceScore

		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)


		//Search the project
		reusableMethodsSearch.searchProgram(sheetName,rowNum)

		WebUI.delay(5)

		//WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
		WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Total'))
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TotalPerformanceScore'),10)
		WebUI.delay(15)
		//Verifying the Performance score
		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		print totalperformaceScore
		WebUI.verifyMatch(totalperformaceScore , totalperformanceScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/BasePointScore'),10)
		String basepointScore = WebUI.getText(findTestObject('PerformanceScore/Score/BasePointScore'))
		WebUI.verifyMatch(basepointScore , basePointScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/EnergyPerScore'),10)
		String energyperScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyPerScore'))
		WebUI.verifyMatch(energyperScore , energyScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WaterPerScore'),10)
		String waterpfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterPerScore'))
		WebUI.verifyMatch(waterpfScore ,waterScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WastePerSocre'),10)
		String wastepfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WastePerSocre'))
		WebUI.verifyMatch(wastepfScore ,wasteScore , false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TransportperScore'),10)
		String transportperScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportperScore'))
		WebUI.verifyMatch(transportperScore ,transportScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/HumanExpScore'),10)
		String humanExperience = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExpScore'))
		WebUI.verifyMatch(humanExperience ,humanExpScore, false)

	}

	@Keyword
	public void genratePerformanceScoreAdminToolCityComOtherNone(String sheetName,int rowNum) throws IOException, InterruptedException {
		String projectId = data.getCellData(sheetName,"ProjectID",rowNum)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScoreButton'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('PerformanceScore/PorjectId'),projectId)
		WebUI.delay(2)
		WebUI.click(findTestObject('PerformanceScore/RecomputeScore'))
		WebUI.delay(15)

		String energyScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyScore'))
		String waterScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterSocre'))
		String wasteScore = WebUI.getText(findTestObject('PerformanceScore/Score/WasteScore'))
		String transportScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportScore'))
		String humanExpScore = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExperianceScore'))

		double energyscore = Double.parseDouble(energyScore)
		double waterscore =  Double.parseDouble(waterScore)
		double wastescore =  Double.parseDouble(wasteScore)
		double transportscore = Double.parseDouble(transportScore)
		double humexpscore =    Double.parseDouble(humanExpScore)
		double totalPerformanceScore = energyscore + waterscore + wastescore + transportscore + humexpscore
		String totalperformanceScore = Math.round(totalPerformanceScore)
		//String totalperformanceScore = Double.toString(totalPerformanceScore)
		println totalperformanceScore

		WebUI.closeWindowIndex(1)
		WebUI.delay(2)
		WebUI.switchToWindowIndex(0)


		//Search the project
		reusableMethodsSearch.searchProgram(sheetName,rowNum)

		WebUI.delay(15)
		//WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Score'))
		WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Total'))
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TotalPerformanceScore'),10)
		WebUI.delay(15)
		//Verifying the Performance score
		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		print totalperformaceScore
		WebUI.verifyMatch(totalperformaceScore , totalperformanceScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/EnergyPerScore'),10)
		String energyperScore = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyPerScore'))
		WebUI.verifyMatch(energyperScore , energyScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WaterPerScore'),10)
		String waterpfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WaterPerScore'))
		WebUI.verifyMatch(waterpfScore ,waterScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/WastePerSocre'),10)
		String wastepfScore = WebUI.getText(findTestObject('PerformanceScore/Score/WastePerSocre'))
		WebUI.verifyMatch(wastepfScore ,wasteScore , false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TransportperScore'),10)
		String transportperScore = WebUI.getText(findTestObject('PerformanceScore/Score/TransportperScore'))
		WebUI.verifyMatch(transportperScore ,transportScore, false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(12)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/HumanExpScore'),10)
		String humanExperience = WebUI.getText(findTestObject('PerformanceScore/Score/HumanExpScore'))
		WebUI.verifyMatch(humanExperience ,humanExpScore, false)

	}

	@Keyword
	public void setdefaultpagePerformanceScore(String sheetName, int rowNum) throws IOException, InterruptedException {
		/*WebUI.waitForPageLoad(10)
		 WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Manage/Parking/Manage'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('PerformanceScore/a_ Settings'))
		WebUI.delay(7)
		WebUI.scrollToElement(findTestObject('PerformanceScore/span_All Actions'),5)
		WebUI.click(findTestObject('PerformanceScore/span_All Actions'))
		WebUI.delay(3)
		//WebUI.waitForElementClickable(findTestObject('PerformanceScore/PerformanceScore'),3)
		WebUI.click(findTestObject('PerformanceScore/PerformanceScore'))
		WebUI.delay(15)
		//Verifying the default functionality of performance score
		reusableMethodsSearch.searchProgram(sheetName, rowNum)
		WebUI.delay(10)
		String performaceScore = WebUI.getText(findTestObject('PerformanceScore/span_Performance Score'))
		WebUI.verifyMatch(performaceScore , 'Performance Score', false)
	}

	@Keyword
	public void setdefaultpagePerformanceScoreOtherNone(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.delay(3)
		WebUI.click(findTestObject('PerformanceScore/a_ Settings'))
		WebUI.delay(7)
		WebUI.focus(findTestObject('Page_Arc dashboard/DashboardPage/AllProject/span_Data Input'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Page_Arc dashboard/DashboardPage/AllProject/span_Data Input'))
		WebUI.delay(4)
		WebUI.click(findTestObject('PerformanceScore/PerformanceScore'))
		WebUI.delay(10)
		//Verifying the default functionality of performance score
		reusableMethodsSearch.searchProgram(sheetName, rowNum)
		WebUI.delay(10)
		String performaceScore = WebUI.getText(findTestObject('PerformanceScore/span_Performance Score'))
		WebUI.verifyMatch(performaceScore , 'Performance Score', false)
	}


	@Keyword
	public void verifyCompleteScoreSection() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)*/
		String TotalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		WebUI.verifyMatch(TotalperformaceScore , 'Performance Score', false)
	}
	@Keyword
	public void totalPerformanceScoreUIAllFieldVerification() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)

		String performaceScore = WebUI.getText(findTestObject('PerformanceScore/span_Performance Score'))
		WebUI.verifyMatch(performaceScore , 'Performance Score', false)

		String total = WebUI.getText(findTestObject('PerformanceScore/Score/span_Total'))
		WebUI.verifyMatch(total ,"TOTAL", false)

		String higestScoretotal = WebUI.getText(findTestObject('PerformanceScore/Score/TotalHigestScore100'))
		WebUI.verifyMatch(higestScoretotal ,"100", false)

		String lowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/Score/TotalLowestSocre0'))
		WebUI.verifyMatch(lowestSocreTotal ,"0", false)

		String energy = WebUI.getText(findTestObject('PerformanceScore/Score/span_Energy'))
		WebUI.verifyMatch(energy ,"ENERGY", false)

		String higestScoreEnergy = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyHighestSocre100'))
		WebUI.verifyMatch(higestScoretotal ,"100", false)

		String lowestSocreEnergy = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyLowestSocre0'))
		WebUI.verifyMatch(lowestSocreEnergy ,"0", false)

		String water = WebUI.getText(findTestObject('PerformanceScore/Score/span_Water'))
		WebUI.verifyMatch(water ,"WATER", false)

		String waste = WebUI.getText(findTestObject('PerformanceScore/Score/span_Waste'))
		WebUI.verifyMatch(waste ,"WASTE", false)

		String transport = WebUI.getText(findTestObject('PerformanceScore/Score/span_Transportation'))
		WebUI.verifyMatch(transport ,"TRANSPORTATION", false)

		String humanExp = WebUI.getText(findTestObject('PerformanceScore/Score/span_Human Experience'))
		WebUI.verifyMatch(humanExp ,"HUMAN EXPERIENCE", false)

		String basePoint = WebUI.getText(findTestObject('PerformanceScore/Score/span_Base Points'))
		WebUI.verifyMatch(basePoint ,"BASE POINTS", false)
	}
	@Keyword
	public void individualScoreUIAllFieldVerification() throws IOException, InterruptedException {

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)*/
		/********* Verifying all fields UI  Score for individual Energy , Water , Waste , Transport , Human Exp , Base Point ************* */	
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.delay(5)


		String lowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(lowestSocreTotal ,"0", false)
		String higestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/BasePointMax_10'))
		WebUI.verifyMatch(higestScoretotal ,"10", false)
		String basePoint = WebUI.getText(findTestObject('PerformanceScore/FieldScore/BaseScore'))
		WebUI.verifyMatch(basePoint ,"BASE SCORE", false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(5)
		String energylowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(energylowestSocreTotal ,"0", false)
		String energyhigestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/MaxEnergy_33'))
		WebUI.verifyMatch(energyhigestScoretotal ,"33", false)
		String energy = WebUI.getText(findTestObject('PerformanceScore/FieldScore/span_Energy'))
		WebUI.verifyMatch(energy ,"ENERGY", false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(5)
		String waterlowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(waterlowestSocreTotal ,"0", false)
		String waterhigestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/WaterMax_15'))
		WebUI.verifyMatch(waterhigestScoretotal ,"15", false)
		String water = WebUI.getText(findTestObject('PerformanceScore/FieldScore/span_Water'))
		WebUI.verifyMatch(water ,"WATER", false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(5)
		String wastelowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(wastelowestSocreTotal ,"0", false)
		String wastehigestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/WasteMax_8'))
		WebUI.verifyMatch(wastehigestScoretotal ,"8", false)
		String waste = WebUI.getText(findTestObject('PerformanceScore/FieldScore/span_Waste'))
		WebUI.verifyMatch(waste ,"WASTE", false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(5)
		String translowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(translowestSocreTotal ,"0", false)
		String transhigestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/Transportation_14'))
		WebUI.verifyMatch(transhigestScoretotal ,"14", false)
		String transportation = WebUI.getText(findTestObject('PerformanceScore/FieldScore/span_Transportation'))
		WebUI.verifyMatch(transportation ,"TRANSPORTATION", false)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(5)
		String humlowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/minPoint_0'))
		WebUI.verifyMatch(humlowestSocreTotal ,"0", false)
		String humhigestScoretotal = WebUI.getText(findTestObject('PerformanceScore/FieldScore/HumanExperienceMax_20'))
		WebUI.verifyMatch(humhigestScoretotal ,"20", false)
		String humExp = WebUI.getText(findTestObject('PerformanceScore/FieldScore/span_HumanExperience'))
		WebUI.verifyMatch(humExp ,"HUMAN EXPERIENCE", false)
	}


	@Keyword
	public void totalPerformanceScoreUIAllFieldVerificationCityComOtherNone() throws IOException, InterruptedException {

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)*/
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)

		String performaceScore = WebUI.getText(findTestObject('PerformanceScore/span_Performance Score'))
		WebUI.verifyMatch(performaceScore , 'Performance Score', false)

		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		WebUI.verifyMatch(totalperformaceScore ,"0", false)

		String total = WebUI.getText(findTestObject('PerformanceScore/Score/span_Total'))
		WebUI.verifyMatch(total ,"TOTAL", false)

		String higestScoretotal = WebUI.getText(findTestObject('PerformanceScore/Score/TotalHigestScore100'))
		WebUI.verifyMatch(higestScoretotal ,"100", false)

		String lowestSocreTotal = WebUI.getText(findTestObject('PerformanceScore/Score/TotalLowestSocre0'))
		WebUI.verifyMatch(lowestSocreTotal ,"0", false)

		String energy = WebUI.getText(findTestObject('PerformanceScore/Score/span_Energy'))
		WebUI.verifyMatch(energy ,"ENERGY", false)

		String higestScoreEnergy = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyHighestSocre100'))
		WebUI.verifyMatch(higestScoretotal ,"100", false)

		String lowestSocreEnergy = WebUI.getText(findTestObject('PerformanceScore/Score/EnergyLowestSocre0'))
		WebUI.verifyMatch(lowestSocreEnergy ,"0", false)

		String water = WebUI.getText(findTestObject('PerformanceScore/Score/span_Water'))
		WebUI.verifyMatch(water ,"WATER", false)

		String waste = WebUI.getText(findTestObject('PerformanceScore/Score/span_Waste'))
		WebUI.verifyMatch(waste ,"WASTE", false)

		String transport = WebUI.getText(findTestObject('PerformanceScore/Score/span_Transportation'))
		WebUI.verifyMatch(transport ,"TRANSPORTATION", false)

		String humanExp = WebUI.getText(findTestObject('PerformanceScore/Score/span_Human Experience'))
		WebUI.verifyMatch(humanExp ,"HUMAN EXPERIENCE", false)
	}

	@Keyword
	public void totalPerformanceScoreUIWithoutScore() throws IOException, InterruptedException {
		/********* Verifying blank category score race-track without entering data for total performance score section ************* */

		/*WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)
		 */
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)

		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		WebUI.verifyMatch(totalperformaceScore ,"0", false)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TotalPointBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/EnergyBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WaterBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WasteBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TransportBalnkRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/HumExpBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/BasePointBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	public void totalPerformanceScoreUIWithoutScoreAg() throws IOException, InterruptedException {
		/********* Verifying blank category score race-track without entering data for total performance score section ************* */

		/*WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)*/

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(10)

		//String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		//WebUI.verifyMatch(totalperformaceScore ,"6", false)

		//WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TotalPointBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		//WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/EnergyBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WaterBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WasteBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TransportBalnkRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		//	WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/HumExpBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/BasePointBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public void totalPerformanceScoreUIWithoutScoreCityComOtherNone() throws IOException, InterruptedException {
		/********* Verifying blank category score race-track without entering data for total performance score section ************* */

		/*WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(1)*/

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(10)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TotalPointBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/EnergyBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WaterBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/WasteBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/TransportBalnkRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('PerformanceScore/TotalRacetrack/HumExpBlankRaceTrack') ,5, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public void individualPerformanceScoreUIWithoutScore() throws IOException, InterruptedException {
		/********* Verifying blank category score race-track without entering data for individual Energy , Water , Waste , Transport , Human Exp , Base Point ************* */	

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/BasePointBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/EnergyBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/WaterBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/WasteBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/TransportBalnkRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/HumExpBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	public void individualPerformanceScoreUIWithoutScoreAg() throws IOException, InterruptedException {
		/********* Verifying blank category score race-track without entering data for individual Energy , Water , Waste , Transport , Human Exp , Base Point ************* */
		/*WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(4)
		 */
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Base Points'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/BasePointBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/EnergyBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/WaterBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/WasteBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/TransportBalnkRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)
		/*
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		 WebUI.delay(5)
		 WebUI.verifyElementPresent(findTestObject('PerformanceScore/RaceTrack/HumExpBlankRaceTrack'),5, FailureHandling.STOP_ON_FAILURE)*/
	}
	@Keyword
	public void navigationTotalScoreToAnalytics() throws IOException, InterruptedException {

		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))*/
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)

		WebUI.click(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		WebUI.delay(5)
		Boolean totalScore = WebUI.verifyTextPresent('Overall score', false)
		Assert.assertTrue(totalScore)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Total'))
		WebUI.delay(5)
		Assert.assertTrue(totalScore)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Energy'))
		WebUI.delay(5)
		Boolean analyticsEnergy = WebUI.verifyTextPresent('CARBON CONSUMPTION', false)
		Assert.assertTrue(analyticsEnergy)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Water'))
		WebUI.delay(5)
		Boolean analyticsWater = WebUI.verifyTextPresent('WATER CONSUMPTION', false)
		Assert.assertTrue(analyticsWater)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Waste'))
		WebUI.delay(5)
		Boolean analyticsWaste = WebUI.verifyTextPresent('WASTE GENERATION/DIVERSION', false)
		Assert.assertTrue(analyticsWaste)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Transportation'))
		WebUI.delay(5)
		Boolean analyticsTransport = WebUI.verifyTextPresent('Transportation', false)
		Assert.assertTrue(analyticsTransport)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Total'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/span_Human Experience'))
		WebUI.delay(5)
		Boolean analyticsHumExp = WebUI.verifyTextPresent('Human Experience', false)
		Assert.assertTrue(analyticsHumExp)
	}
	@Keyword
	public void navigationIndividualRacetrackToAnalytics() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)*/
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/RaceTrack/CURRENT ENERGY'))
		WebUI.delay(10)
		Boolean analyticsEnergy = WebUI.verifyTextPresent('CARBON CONSUMPTION', false)
		Assert.assertTrue(analyticsEnergy)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/RaceTrack/CURRENT WATER'))
		WebUI.delay(5)
		Boolean analyticsWater = WebUI.verifyTextPresent('WATER CONSUMPTION', false)
		Assert.assertTrue(analyticsWater)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/RaceTrack/CURRENT WASTE'))
		WebUI.delay(5)
		Boolean analyticsWaste = WebUI.verifyTextPresent('WASTE GENERATION/DIVERSION', false)
		Assert.assertTrue(analyticsWaste)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(10)
		WebUI.click(findTestObject('PerformanceScore/RaceTrack/CURRENT TRANSPORTATION'))
		WebUI.delay(10)
		Boolean analyticsTransport = WebUI.verifyTextPresent('Transportation', false)
		Assert.assertTrue(analyticsTransport)

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		WebUI.delay(5)
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(10)
		WebUI.click(findTestObject('PerformanceScore/RaceTrack/CURRENT HUMAN EXPERIENCE'))
		WebUI.delay(10)
		Boolean analyticsHumExp = WebUI.verifyTextPresent('Human Experience', false)
		Assert.assertTrue(analyticsHumExp)
	}
}