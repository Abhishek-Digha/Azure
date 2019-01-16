package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.math.RoundingMode
import java.time.YearMonth
import java.time.format.DateTimeFormatter

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.KatalonWebDriverBackedSelenium
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
public class ReusableMethodsAnalytics extends BaseClass{

	public ReusableMethodsDataInput ReusDataInput = new ReusableMethodsDataInput()
	ReusableMethodsNavigation navigation = new ReusableMethodsNavigation()

	@Keyword
	public void downloadAndVerifySurveyExportedData(){
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		 WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))*/
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), "Survey Data Didn't downloaded successfully")
		println "Survey Exported File downloaded and verified successfully"
	}
	@Keyword
	public void ArcLogoProjNameAndAdd(String sheetName ,int rowNum){
		navigation.navigateToAnalyticsTotal()
		/**************Reading data form excel sheet*************************/
		String prjName          = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjAddress   	= data.getCellData(sheetName, "Address", rowNum)

		String projNameUI= WebUI.getText(findTestObject('Analytics/TotalAnalytics/ProjectName'))
		WebUI.verifyMatch(projNameUI,prjName, false)

		String projAdd= WebUI.getText(findTestObject('Object Repository/Analytics/TotalAnalytics/Address'))
		WebUI.verifyMatch(prjAddress,projAdd, false)

		/***********Verify the Logo is displayed in the right top corner of the total analytics page.**************/
		WebUI.verifyElementPresent(findTestObject('Object Repository/Analytics/TotalAnalytics/img'),1)
	}

	@Keyword
	public void overallScore(){
		WebUI.click(findTestObject('Object Repository/PerformanceScore/Score/a_ Total'))
		WebUI.delay(15)
		WebUI.waitForElementPresent(findTestObject('PerformanceScore/Score/TotalPerformanceScore'),10)
		//Verifying the Performance score
		String totalperformaceScore = WebUI.getText(findTestObject('PerformanceScore/Score/TotalPerformanceScore'))
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String overallscore = WebUI.getText(findTestObject('Analytics/TotalAnalytics/OverallScore'))
		WebUI.verifyMatch(overallscore,totalperformaceScore, false)

		/*************Verifying ToolTip text for total analytics Energy**************************/

		WebUI.scrollToElement(findTestObject('Analytics/TotalAnalytics/Annual_ADJUSTED'),2)
		WebUI.mouseOver(findTestObject('Analytics/TotalAnalytics/Annual_ADJUSTED'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/a_ADJUSTED'),3)



	}
	@Keyword
	public void indivisualScore(){

		WebUI.click(findTestObject('PerformanceScore/DataInput/a_ Data Input'))
		//WebUI.delay(17)
		ReusableMethodsLogin.waitForIframeLoad(60)
		String energyPerScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/EnergyScore'))
		String energyperScoreout33 = energyPerScore.concat(" out of 33")


		String waterPfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WaterScore'))
		String waterPfScoreout15 = waterPfScore.concat(" out of 15")

		String wastePfScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/WasteScore'))
		String wastePfScore8 = wastePfScore.concat(" out of 8")

		String transPortperScore = WebUI.getText(findTestObject('PerformanceScore/DataInput/TransportScore'))
		String transPortperScore14 = transPortperScore.concat(" out of 14")

		String humanexperience = WebUI.getText(findTestObject('PerformanceScore/DataInput/HumanExp'))
		String humanexperience20 = humanexperience.concat(" out of 20")

		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String energyScore = WebUI.getText(findTestObject('Analytics/Score/EnergyScore'))
		String waterScore = WebUI.getText(findTestObject('Analytics/Score/WaterScore'))
		String wasteScore = WebUI.getText(findTestObject('Analytics/Score/WasteScore'))
		String transportScore = WebUI.getText(findTestObject('Analytics/Score/TransprotScore'))
		String humExp = WebUI.getText(findTestObject('Analytics/Score/HumExp'))

		WebUI.verifyMatch(energyScore , energyperScoreout33, false)
		WebUI.verifyMatch(waterPfScoreout15 ,waterScore, false)
		WebUI.verifyMatch(wastePfScore8 ,wasteScore , false)
		WebUI.verifyMatch(transPortperScore14 ,transportScore, false)
		WebUI.verifyMatch(humanexperience20,humExp, false)
	}
	@Keyword
	public void oppHourAreaOcc(){

		navigation.navigateToAnalyticsTotal()

		String area = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Area'))
		WebUI.verifyMatch(area,'2,000', false)

		String operatinghour = WebUI.getText(findTestObject('Analytics/TotalAnalytics/OpeartingHour'))
		WebUI.verifyMatch(operatinghour,'100', false)

		String occupancy = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Occupant'))
		WebUI.verifyMatch(occupancy,'9', false)


		/****Verifying in the graph occupancy and operating hour******************/	
		String garea = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphArea'))
		WebUI.verifyMatch(garea,'Gross Area (sq. foot) : 2000',false)

		String gopeartinghour = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphOppHour'))
		WebUI.verifyMatch(gopeartinghour,'Operating Hours : 100', false)

		String goccupancy = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphOccupany'))
		WebUI.verifyMatch(goccupancy,'Occupancy : 9', false)

		/***** Verifying in the Unit by excel upload ******************/
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/span_(sq. feet)'),3)

		/*****Verify if the Waste section has two line items "Average daily waste generated (lbs)" and "Average daily waste diverted (lbs)"for Buildings and Transit project****/
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/AVERAGE DAILY WASTE DIVERTE'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/AVERAGE DAILY WASTE GENERAT'),3)
	}

	@Keyword
	public void analyticoppHourAreaOcc(){

		navigation.navigateToAnalyticsTotal()

		String area = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Area'))
		WebUI.verifyMatch(area,'1,000', false)

		String operatinghour = WebUI.getText(findTestObject('Analytics/TotalAnalytics/OpeartingHour'))
		WebUI.verifyMatch(operatinghour,'100', false)

		String occupancy = WebUI.getText(findTestObject('Analytics/TotalAnalytics/Occupant'))
		WebUI.verifyMatch(occupancy,'9', false)

		/****Verifying in the graph occupancy and operating hour******************/
		String garea = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphArea'))
		WebUI.verifyMatch(garea,'Gross Area (sq. foot) : 1000',false)

		String gopeartinghour = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphOppHour'))
		WebUI.verifyMatch(gopeartinghour,'Operating Hours : 100', false)

		String goccupancy = WebUI.getText(findTestObject('Analytics/TotalAnalytics/GraphOccupany'))
		WebUI.verifyMatch(goccupancy,'Occupancy : 9', false)

		/***** Verifying in the Unit by excel upload ******************/
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/span_(sq. feet)'),3)

		/*****Verify if the Waste section has two line items "Average daily waste generated (lbs)" and "Average daily waste diverted (lbs)"for Buildings and Transit project****/
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/AVERAGE DAILY WASTE DIVERTE'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/AVERAGE DAILY WASTE GENERAT'),3)
	}


	@Keyword
	public void verifyAnlyticsEDailiyMTCO2e() throws IOException, InterruptedException{
		navigation.navigateToAnalyticsTotal()
		println "TEST STARTED ENERGY PROJECT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)"
		String  str1= WebUI.getText(findTestObject('Analytics/Cal/Anualcarbon'))
		String str6 =  str1.replace(',', '')

		System.out.println(str1)
		double energyCarbonEmession=Double.parseDouble(str6)

		if(energyCarbonEmession==0) {
			KeywordUtil.markFailedAndStop("!!!Energy Analytics ANNUAL ADJUSTED CARBON EMISSIONS (MTCO2e) is not generated hence displays as 0 after filling all the data!!!!!!")
		}
		else {
			double edaily=((energyCarbonEmession)/365)
			println edaily
			BigDecimal pden = new BigDecimal(edaily)
			pden = pden.setScale(4, RoundingMode.HALF_UP)
			String calcuated = pden.toString()
			System.out.println(calcuated)

			String dailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/Dailycarbon'))
			WebUI.verifyMatch(dailyCarbon, calcuated, false)

			println  "Verified Project Energy Daily Carbon Emissions successully"
			println 'Test Passed'

			println 'TEST STARTED ENERGY PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)'
			String  pstr1=WebUI.getText(findTestObject('Analytics/Cal/BPAnualcarbon'))

			System.out.println(pstr1)
			double epdaily=Double.parseDouble(pstr1)/365

			BigDecimal epden = new BigDecimal(epdaily)
			epden = epden.setScale(4, RoundingMode.HALF_UP)
			System.out.println(epden)
			String pcalcuated = epden.toString()


			String epdailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/BPDailycarbon'))
			WebUI.verifyMatch(epdailyCarbon, pcalcuated, false)

			println  "Verified PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)"
			println  "Test Passed"

			println "TEST STARTED ENERGY PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)"
			String  ostr1=WebUI.getText(findTestObject('Analytics/Cal/OAnualcarbon'))
			System.out.println(ostr1)
			double eodaily=Double.parseDouble(ostr1)/365
			BigDecimal eoden = new BigDecimal(eodaily)
			eoden = eoden.setScale(4, RoundingMode.HALF_UP)
			String pocccalcuated = eoden.toString()

			String eodailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/ODailycarbon'))
			WebUI.verifyMatch(eodailyCarbon, pocccalcuated, false)
			println  "Verified PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully"
		}
	}
	@Keyword
	public void verifyWDailiyWaterConsumption() throws IOException, InterruptedException{

		//navigation.navigateToAnalyticsTotal()
		println "TEST STARTED WATER PROJECT(TOTAL DAILY  WATER CONSUMPTION=TOTAL ANNUAL WATER CONSUMPTION/365)"
		String  str1=WebUI.getText(findTestObject('Analytics/Cal/WAnualcarbon'))
		String str6 =  str1.replace(',', '')
		System.out.println(str1)
		double waterConsumption=Double.parseDouble(str6)
		if(waterConsumption==0) {
			KeywordUtil.markFailedAndStop("!!!Water Analytics ANNUAL WATER CONSUMPTION is not generated hence displays as 0 after filling all the data and recomputed score!!!!!!")
		}

		else {
			double edaily=waterConsumption/365
			System.out.println(edaily)

			BigDecimal pden = new BigDecimal(edaily)
			pden = pden.setScale(4, RoundingMode.HALF_UP)
			String dailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/WDailycarbon'))
			Thread.sleep(1000)
			String str2= new String(dailyCarbon)
			System.out.println(dailyCarbon)
			double d3=Double.parseDouble(str2)
			BigDecimal pden1 = new BigDecimal(d3)
			pden1 = pden.setScale(4, RoundingMode.HALF_UP)
			System.out.println(pden)
			System.out.println(pden1)
			Assert.assertEquals(pden,pden1)
			println  "Verified Project Water Daily CONSUMPTION successully"
			println  "Test Passed"

			println "TEST STARTED Water PER SQ FT(TOTAL DAILY CONSUMPTION =TOTAL ANNUAL CONSUMPTION /365)"
			String  pstr1=WebUI.getText(findTestObject('Analytics/Cal/WPAnualcarbon'))
			String pstr6 =  pstr1.replace(',', '')
			double epdaily=Double.parseDouble(pstr6)/365
			BigDecimal epden = new BigDecimal(epdaily)
			epden = epden.setScale(4, RoundingMode.HALF_UP)
			System.out.println(epden)
			String epdailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/WPDailycarbon'))
			Thread.sleep(1000)
			double epdailyCarbon1 =Double.parseDouble(epdailyCarbon)
			BigDecimal epden1 = new BigDecimal(epdailyCarbon1)
			epden1 = epden1.setScale(4, RoundingMode.HALF_UP)
			System.out.println(epden)
			System.out.println(epden1)
			Assert.assertEquals(epden,epden1)
			println  "Verified Water PER SQ FT DAILY CONSUMPTION "
			println  "Test Passed"

			println "TEST STARTED Water PER OCC(TOTAL DAILY WATER CONSUMPTION =TOTAL ANNUAL WATER CONSUMPTION/365)"
			String  ostr1=WebUI.getText(findTestObject('Analytics/Cal/WOAnualcarbon'))
			String ostr6 =  ostr1.replace(',', '')
			System.out.println(ostr6)
			double eodaily=Double.parseDouble(ostr6)/365
			BigDecimal eoden = new BigDecimal(eodaily)
			eoden = eoden.setScale(4, RoundingMode.HALF_UP)
			String eodailyCarbon =WebUI.getText(findTestObject('Analytics/Cal/WODailycarbon'))
			Thread.sleep(1000)
			double eodailyCarbon1 =Double.parseDouble(eodailyCarbon)
			BigDecimal eoden1 = new BigDecimal(eodailyCarbon1)
			eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP)
			System.out.println(eoden)
			System.out.println(eoden1)
			Assert.assertEquals(eoden,eoden1)
			println "Verified Water PER OCC DAILY WATER CONSUMPTION Successfully"
		}
	}
	@Keyword
	public void verifyCTotalPerOCCAnalytics() throws IOException, InterruptedException{
		println "Verifying TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) PER OCC"
		String  str1= WebUI.getText(findTestObject('Analytics/Cal/OCTotal'))
		String occupancy =  str1.replace(',', '')

		Double CTotal= Double.parseDouble(occupancy)
		BigDecimal AtotalMtco2e = new BigDecimal(CTotal)
		AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(AtotalMtco2e)

		String  str2=WebUI.getText(findTestObject('Analytics/Cal/OCTEScope1'))
		String occupancyscope1 =  str2.replace(',', '')

		Double CTEScope1 = Double.parseDouble(occupancyscope1)
		System.out.println(CTEScope1)

		String  str3=WebUI.getText(findTestObject('Analytics/Cal/OCTEScope2'))
		String occupancyscope2 =  str3.replace(',', '')
		Double CTEScope2 = Double.parseDouble(occupancyscope2)
		System.out.println(CTEScope2)

		String  str4=WebUI.getText(findTestObject('Analytics/Cal/OCTTransportion'))
		String occupancytransport =  str4.replace(',', '')
		Double CTTransportion = Double.parseDouble(occupancytransport)
		System.out.println(CTTransportion)

		Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion
		BigDecimal totalMtco2e = new BigDecimal(TotalCarbon)
		totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(totalMtco2e)
		Assert.assertEquals(AtotalMtco2e,totalMtco2e)
		println " Test passed Verified TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For PER OCC Successfully"
	}
	@Keyword
	public void verifyCTotalProjectAnalytics() throws IOException, InterruptedException{
		//navigation.navigateToAnalyticsTotal()
		println "Verifying TOTAL ANNUAL CARBON EMISSIONS (MTCO2e): For Project"
		String  str1=WebUI.getText(findTestObject('Analytics/Cal/CTotal'))
		String mtco2c =  str1.replace(',', '')
		Double CTotal= Double.parseDouble(mtco2c)
		BigDecimal AtotalMtco2e = new BigDecimal(CTotal)
		AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(AtotalMtco2e)

		String  str2=WebUI.getText(findTestObject('Analytics/Cal/CTEScope1'))
		String scpoe1 =  str2.replace(',', '')
		Double CTEScope1 = Double.parseDouble(scpoe1)
		System.out.println(CTEScope1)

		String  str3=WebUI.getText(findTestObject('Analytics/Cal/CTEScope2'))
		String scpoe2 =  str3.replace(',', '')
		Double CTEScope2 = Double.parseDouble(scpoe2)
		System.out.println(CTEScope2)

		String  str4=WebUI.getText(findTestObject('Analytics/Cal/CTTransportion'))
		String trasport =  str4.replace(',', '')

		Double CTTransportion = Double.parseDouble(trasport)
		System.out.println(CTTransportion)

		Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion
		BigDecimal totalMtco2e = new BigDecimal(TotalCarbon)
		totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(totalMtco2e)
		Assert.assertEquals(AtotalMtco2e,totalMtco2e)
		println " Test passed Verified TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For Project Successfully"
	}
	@Keyword
	public void verifyCTotalPerSQFTAnalytics(String param) throws IOException, InterruptedException{
		println "TOTAL ANNUAL CARBON EMISSIONS (MTCO2e): PER SQ FT"
		String  str1=WebUI.getText(findTestObject('Analytics/Cal/SCTotal'))
		Double CTotal= Double.parseDouble(str1)
		BigDecimal AtotalMtco2e = new BigDecimal(CTotal)
		AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(AtotalMtco2e)

		String  str2=WebUI.getText(findTestObject('Analytics/Cal/SCTEScope1'))
		Double CTEScope1 = Double.parseDouble(str2)
		System.out.println(CTEScope1)

		String  str3=WebUI.getText(findTestObject('Analytics/Cal/SCTEScope2'))
		Double CTEScope2 = Double.parseDouble(str3)
		System.out.println(CTEScope2)

		String  str4=WebUI.getText(findTestObject('Analytics/Cal/SCTTransportion'))
		String replaced = str4.replace('-', '0')

		Double CTTransportion = Double.parseDouble(replaced)
		System.out.println(CTTransportion)

		Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion
		BigDecimal totalMtco2e = new BigDecimal(TotalCarbon)
		totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP)
		System.out.println(totalMtco2e)
		Assert.assertEquals(AtotalMtco2e,totalMtco2e)
		println "Test passed TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For PER SQ FT Verified Successfully"
	}

	@Keyword
	public void surveyRepRate(){
		WebUI.delay(4)
		WebUI.click(findTestObject('DataInput/Survey/a_ Data Input'))
		WebUI.delay(15)
		//ReusableMethodsLogin.waitForPageLoad(60)
		WebUI.click(findTestObject('DataInput/Survey/div_Transportation Survey'))
		WebUI.delay(3)
		//WebUI.delay(5)
		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of transport survey results.*****/
		String trsurveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String surveyResponsepercentage1 = trsurveyResponsePercentage.replace("%","")
		String surveyResponsepercentage = surveyResponsepercentage1.replaceAll("\\s","")

		/******Verify that survey response rate% is calculated on the basis of the following formula [ Response %ge = (No. of responses/Occupancy)*100 ] . Always count the no of responses by counting the no of rows of HUMAN EXPERIENCE survey results.*****/
		WebUI.click(findTestObject('DataInput/Survey/OccupantSatisfactionSurv'))
		WebUI.click(findTestObject('Object Repository/DataInput/Survey/SurveryResponseText'))
		//WebUI.delay(10)
		String humsurveyResponsePercentage = WebUI.getText(findTestObject('DataInput/Survey/SurveyResponsePercentage'))
		String humsurveyResponsepercentage1 = humsurveyResponsePercentage.replace("%" ,"")
		String humsurveyResponsepercentage = humsurveyResponsepercentage1.replaceAll("\\s","")

		/***************Verify that survey response rate percentage is same in Transport and HE tabs.***********************************/
		/*
		 WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))*/


		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'), 4)

		//WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		//WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		//WebUI.delay(7)
		ReusableMethodsLogin.waitForloaderToDisappear(60)
		ReusableMethodsLogin.waitForPageLoad(60)
		String transportsurveyResponsePercentage = WebUI.getText(findTestObject('Analytics/TotalAnalytics/TransportRep'))
		String asurveyResponsepercentage1 = transportsurveyResponsePercentage.replace("%","")
		String asurveyResponsepercentage = asurveyResponsepercentage1.replaceAll("\\s","")

		String humExpsurveyResponsePercentage = WebUI.getText(findTestObject('Analytics/TotalAnalytics/HumExpRep'))
		String ahumsurveyResponsepercentage1 = humExpsurveyResponsePercentage.replace("%" ,"")
		String ahumsurveyResponsepercentage = ahumsurveyResponsepercentage1.replaceAll("\\s","")

		WebUI.verifyMatch(asurveyResponsepercentage,surveyResponsepercentage,false)
		WebUI.verifyMatch(ahumsurveyResponsepercentage, humsurveyResponsepercentage, false)
	}

	@Keyword
	public void certificationDetails(){
		navigation.navigateToAnalyticsTotal()
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/CertificaitonLEEDTR'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/CertificationLogo'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/CertificationLogoplatinum'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/TotalAnalytics/CertificationScore'),3)
	}

	@Keyword
	public void downloadExportData(){
		/*************Verify if able to download the export data for the energy , water , waste , transport , Human Experiance ******************/

		/*WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 WebUI.delay(2)
		 */
		WebUI.click(findTestObject('Analytics/Nav/a_ Energy'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)

		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), "Didn't downloaded successfully")
		println "Energy Exported File downloaded and verified successfully"

		WebUI.click(findTestObject('Object Repository/Analytics/Nav/a_ Water'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), "Didn't downloaded successfully")
		println "Water Exported File downloaded and verified successfully"

		WebUI.click(findTestObject('Analytics/Nav/a_ Waste'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), " Didn't downloaded successfully")
		println "Waste Exported File downloaded and verified successfully"

		WebUI.click(findTestObject('Analytics/Nav/a_ Transportation'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), "Didn't downloaded successfully")
		println "Trasport Exported File downloaded and verified successfully"
	}

	@Keyword
	public void  humanExpExportButtionTest() {
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/a_ CreditsActions'))
		 WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))*/

		WebUI.click(findTestObject('Analytics/Nav/a_ Human Experience'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(10)

		println "Verify if download button is present under hum experiace section and able to download export exccel"
		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'), 4)
		WebUI.click(findTestObject('Object Repository/Analytics/ExportSurveyDataButtonInAnalytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnDowloadExportButton'))
		WebUI.delay(4)
		Assert.assertTrue(ReusDataInput.isFileDownloaded("ExportData.xlsx"), "File Didn't downloaded successfully")
		println "Human experiance Exported File downloaded and verified successfully"
	}
	@Keyword
	public void  verifygraphMonthsDetails() {
		WebUI.refresh()
		WebUI.delay(15)
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMM")

		YearMonth thisMonth    = YearMonth.now()
		YearMonth lastmonth    = thisMonth.minusMonths(1)
		YearMonth twomonthsAgo = thisMonth.minusMonths(2)
		YearMonth threetmonthsAgo   = thisMonth.minusMonths(3)
		YearMonth fourmonthsAgo = thisMonth.minusMonths(4)
		YearMonth fivemonthsAgo    = thisMonth.minusMonths(5)
		YearMonth sixmonthsAgo = thisMonth.minusMonths(6)
		YearMonth sevenmonthsAgo   = thisMonth.minusMonths(7)
		YearMonth eightmonthsAgo = thisMonth.minusMonths(8)
		YearMonth ninemonthsAgo   = thisMonth.minusMonths(9)
		YearMonth tenmonthsAgo = thisMonth.minusMonths(10)
		YearMonth elevenmonthsAgo = thisMonth.minusMonths(11)

		String thisMonths    = thisMonth.format(monthYearFormatter)
		String lastMonth    = lastmonth.format(monthYearFormatter)
		String twoMonthsAgo = twomonthsAgo.format(monthYearFormatter)
		String threetMonthsAgo   = threetmonthsAgo.format(monthYearFormatter)
		String fourMonthsAgo = fourmonthsAgo.format(monthYearFormatter)
		String fiveMonthsAgo    = fivemonthsAgo.format(monthYearFormatter)
		String sixMonthsAgo = sixmonthsAgo.format(monthYearFormatter)
		String sevenMonthsAgo   = sevenmonthsAgo.format(monthYearFormatter)
		String eightMonthsAgo = eightmonthsAgo.format(monthYearFormatter)
		String nineMonthsAgo   = ninemonthsAgo.format(monthYearFormatter)
		String tenMonthsAgo = tenmonthsAgo.format(monthYearFormatter)
		String elevenMonthsAgo = elevenmonthsAgo.format(monthYearFormatter)


		String currentMonth = WebUI.getText(findTestObject('Analytics/Graph/currentMonth'))
		WebUI.verifyMatch(thisMonths, currentMonth, false)

		String lastmonths = WebUI.getText(findTestObject('Analytics/Graph/lastMonth'))
		WebUI.verifyMatch(lastMonth,lastmonths, false)

		String twomonthsago = WebUI.getText(findTestObject('Analytics/Graph/twoMonthsAgo'))
		WebUI.verifyMatch(twoMonthsAgo,twomonthsago, false)

		String threetmonthsago = WebUI.getText(findTestObject('Analytics/Graph/threeMonthsAgo'))
		WebUI.verifyMatch(threetMonthsAgo, threetmonthsago, false)

		String fourmonthsago = WebUI.getText(findTestObject('Analytics/Graph/fourMonthsAgo'))
		WebUI.verifyMatch(fourMonthsAgo,fourmonthsago, false)

		String fivemonthsago = WebUI.getText(findTestObject('Analytics/Graph/fiveMonthsAgo'))
		WebUI.verifyMatch(fiveMonthsAgo,fivemonthsago, false)

		String sixmonthsago = WebUI.getText(findTestObject('Analytics/Graph/sixMonthsAgo'))
		WebUI.verifyMatch(sixMonthsAgo, sixmonthsago, false)

		String sevenMonthsago = WebUI.getText(findTestObject('Analytics/Graph/sevenMonthsAgo'))
		WebUI.verifyMatch(sevenMonthsAgo,sevenMonthsago, false)

		String eightMonthsago = WebUI.getText(findTestObject('Analytics/Graph/eightMonthsAgo'))
		WebUI.verifyMatch(eightMonthsAgo,eightMonthsago, false)

		String nineMonthsago = WebUI.getText(findTestObject('Analytics/Graph/nineMonthsAgo'))
		WebUI.verifyMatch(nineMonthsAgo,nineMonthsago, false)

		String tenmonthsago = WebUI.getText(findTestObject('Analytics/Graph/tenMonthsAgo'))
		WebUI.verifyMatch(tenMonthsAgo,tenmonthsago, false)

		String elevenMonthsago = WebUI.getText(findTestObject('Analytics/Graph/elevenMonthsAgo'))
		WebUI.verifyMatch(elevenMonthsAgo,elevenMonthsago, false)

		WebUI.verifyElementPresent(findTestObject('Analytics/Graph/ScoresText'),2)
		WebUI.verifyElementPresent(findTestObject('Analytics/Graph/MonthsText'),2)
	}

	@Keyword
	public void  verifyMonthsDetail() {

		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMM")

		YearMonth thisMonth    = YearMonth.now()
		YearMonth lastmonth    = thisMonth.minusMonths(1)
		YearMonth twomonthsAgo = thisMonth.minusMonths(2)
		YearMonth threetmonthsAgo   = thisMonth.minusMonths(3)
		YearMonth fourmonthsAgo = thisMonth.minusMonths(4)
		YearMonth fivemonthsAgo    = thisMonth.minusMonths(5)
		YearMonth sixmonthsAgo = thisMonth.minusMonths(6)
		YearMonth sevenmonthsAgo   = thisMonth.minusMonths(7)
		YearMonth eightmonthsAgo = thisMonth.minusMonths(8)
		YearMonth ninemonthsAgo   = thisMonth.minusMonths(9)
		YearMonth tenmonthsAgo = thisMonth.minusMonths(10)
		YearMonth elevenmonthsAgo = thisMonth.minusMonths(11)

		String thisMonths    = thisMonth.format(monthYearFormatter)
		String lastMonth    = lastmonth.format(monthYearFormatter)
		String twoMonthsAgo = twomonthsAgo.format(monthYearFormatter)
		String threetMonthsAgo   = threetmonthsAgo.format(monthYearFormatter)
		String fourMonthsAgo = fourmonthsAgo.format(monthYearFormatter)
		String fiveMonthsAgo    = fivemonthsAgo.format(monthYearFormatter)
		String sixMonthsAgo = sixmonthsAgo.format(monthYearFormatter)
		String sevenMonthsAgo   = sevenmonthsAgo.format(monthYearFormatter)
		String eightMonthsAgo = eightmonthsAgo.format(monthYearFormatter)
		String nineMonthsAgo   = ninemonthsAgo.format(monthYearFormatter)
		String tenMonthsAgo = tenmonthsAgo.format(monthYearFormatter)
		String elevenMonthsAgo = elevenmonthsAgo.format(monthYearFormatter)


		String currentMonth = WebUI.getText(findTestObject('Analytics/Gr/currentMonth'))
		WebUI.verifyMatch(thisMonths, currentMonth, false)

		String lastmonths = WebUI.getText(findTestObject('Analytics/Gr/lastMonth'))
		WebUI.verifyMatch(lastMonth,lastmonths, false)

		String twomonthsago = WebUI.getText(findTestObject('Analytics/Gr/twoMonthsAgo'))
		WebUI.verifyMatch(twoMonthsAgo,twomonthsago, false)

		String threetmonthsago = WebUI.getText(findTestObject('Analytics/Gr/threeMonthsAgo'))
		WebUI.verifyMatch(threetMonthsAgo, threetmonthsago, false)

		String fourmonthsago = WebUI.getText(findTestObject('Analytics/Gr/fourMonthsAgo'))
		WebUI.verifyMatch(fourMonthsAgo,fourmonthsago, false)

		String fivemonthsago = WebUI.getText(findTestObject('Analytics/Gr/fiveMonthsAgo'))
		WebUI.verifyMatch(fiveMonthsAgo,fivemonthsago, false)

		String sixmonthsago = WebUI.getText(findTestObject('Analytics/Gr/sixMonthsAgo'))
		WebUI.verifyMatch(sixMonthsAgo, sixmonthsago, false)

		String sevenMonthsago = WebUI.getText(findTestObject('Analytics/Gr/sevenMonthsAgo'))
		WebUI.verifyMatch(sevenMonthsAgo,sevenMonthsago, false)

		String eightMonthsago = WebUI.getText(findTestObject('Analytics/Gr/eightMonthsAgo'))
		WebUI.verifyMatch(eightMonthsAgo,eightMonthsago, false)

		String nineMonthsago = WebUI.getText(findTestObject('Analytics/Gr/nineMonthsAgo'))
		WebUI.verifyMatch(nineMonthsAgo,nineMonthsago, false)

		String tenmonthsago = WebUI.getText(findTestObject('Analytics/Gr/tenMonthsAgo'))
		WebUI.verifyMatch(tenMonthsAgo,tenmonthsago, false)

		String elevenMonthsago = WebUI.getText(findTestObject('Analytics/Gr/elevenMonthsAgo'))
		WebUI.verifyMatch(elevenMonthsAgo,elevenMonthsago, false)

		WebUI.delay(2)

	}

	@Keyword
	public void  verifyMonthsDetails() {

		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMM")

		YearMonth thisMonth    = YearMonth.now()
		YearMonth lastmonth    = thisMonth.minusMonths(1)
		YearMonth twomonthsAgo = thisMonth.minusMonths(2)
		YearMonth threetmonthsAgo   = thisMonth.minusMonths(3)
		YearMonth fourmonthsAgo = thisMonth.minusMonths(4)
		YearMonth fivemonthsAgo    = thisMonth.minusMonths(5)
		YearMonth sixmonthsAgo = thisMonth.minusMonths(6)
		YearMonth sevenmonthsAgo   = thisMonth.minusMonths(7)
		YearMonth eightmonthsAgo = thisMonth.minusMonths(8)
		YearMonth ninemonthsAgo   = thisMonth.minusMonths(9)
		YearMonth tenmonthsAgo = thisMonth.minusMonths(10)
		YearMonth elevenmonthsAgo = thisMonth.minusMonths(11)

		String thisMonths    = thisMonth.format(monthYearFormatter)
		String lastMonth    = lastmonth.format(monthYearFormatter)
		String twoMonthsAgo = twomonthsAgo.format(monthYearFormatter)
		String threetMonthsAgo   = threetmonthsAgo.format(monthYearFormatter)
		String fourMonthsAgo = fourmonthsAgo.format(monthYearFormatter)
		String fiveMonthsAgo    = fivemonthsAgo.format(monthYearFormatter)
		String sixMonthsAgo = sixmonthsAgo.format(monthYearFormatter)
		String sevenMonthsAgo   = sevenmonthsAgo.format(monthYearFormatter)
		String eightMonthsAgo = eightmonthsAgo.format(monthYearFormatter)
		String nineMonthsAgo   = ninemonthsAgo.format(monthYearFormatter)
		String tenMonthsAgo = tenmonthsAgo.format(monthYearFormatter)
		String elevenMonthsAgo = elevenmonthsAgo.format(monthYearFormatter)


		String currentMonth = WebUI.getText(findTestObject('Analytics/Gra/currentMonth'))
		WebUI.verifyMatch(thisMonths, currentMonth, false)

		String lastmonths = WebUI.getText(findTestObject('Analytics/Gra/lastMonth'))
		WebUI.verifyMatch(lastMonth,lastmonths, false)

		String twomonthsago = WebUI.getText(findTestObject('Analytics/Gra/twoMonthsAgo'))
		WebUI.verifyMatch(twoMonthsAgo,twomonthsago, false)

		String threetmonthsago = WebUI.getText(findTestObject('Analytics/Gra/threeMonthsAgo'))
		WebUI.verifyMatch(threetMonthsAgo, threetmonthsago, false)

		String fourmonthsago = WebUI.getText(findTestObject('Analytics/Gra/fourMonthsAgo'))
		WebUI.verifyMatch(fourMonthsAgo,fourmonthsago, false)

		String fivemonthsago = WebUI.getText(findTestObject('Analytics/Gra/fiveMonthsAgo'))
		WebUI.verifyMatch(fiveMonthsAgo,fivemonthsago, false)

		String sixmonthsago = WebUI.getText(findTestObject('Analytics/Gra/sixMonthsAgo'))
		WebUI.verifyMatch(sixMonthsAgo, sixmonthsago, false)

		String sevenMonthsago = WebUI.getText(findTestObject('Analytics/Gra/sevenMonthsAgo'))
		WebUI.verifyMatch(sevenMonthsAgo,sevenMonthsago, false)

		String eightMonthsago = WebUI.getText(findTestObject('Analytics/Gra/eightMonthsAgo'))
		WebUI.verifyMatch(eightMonthsAgo,eightMonthsago, false)

		String nineMonthsago = WebUI.getText(findTestObject('Analytics/Gra/nineMonthsAgo'))
		WebUI.verifyMatch(nineMonthsAgo,nineMonthsago, false)

		String tenmonthsago = WebUI.getText(findTestObject('Analytics/Gra/tenMonthsAgo'))
		WebUI.verifyMatch(tenMonthsAgo,tenmonthsago, false)

		String elevenMonthsago = WebUI.getText(findTestObject('Analytics/Gra/elevenMonthsAgo'))
		WebUI.verifyMatch(elevenMonthsAgo,elevenMonthsago, false)

		WebUI.delay(2)

	}

	@Keyword
	public void  verifysideBar() {
		/*		WebUI.scrollToElement(findTestObject('Analytics/sideBar/a_2'), 3)
		 */  
		/*WebDriver driver  = DriverFactory.getWebDriver()
		 WebElement Image = driver.findElement(By.xpath("//a[@href = '#' and (text() = '2%' or . = '2%')]"));
		 //Used points class to get x and y coordinates of element.
		 Point classname = Image.getLocation();
		 int xcordi = classname.getX();
		 System.out.println("Element's Position from left side"+xcordi +" pixels.");
		 int ycordi = classname.getY();
		 System.out.println("Element's Position from top"+ycordi +" pixels.")*/

		//    WebUI.focus(findTestObject('Analytics/sideBar/a_2'))
		//	WebUI.dragAndDropToObject(findTestObject('Analytics/sideBar/a_2'),findTestObject('Analytics/sideBar/a_5'))
		WebUI.scrollToElement(findTestObject('Analytics/sideBar/a_2'), 3)
		WebUI.dragAndDropByOffset(findTestObject('Analytics/sideBar/a_2'),374,914)
		//	WebUI.scrollToPosition(14,85)
		//WebUI.mouseOver(findTestObject('Analytics/sideBar/a_2'))
		//WebUI.mouseOverOffset(findTestObject('Analytics/sideBar/a_2'),14,85)
		//	WebUI.click(findTestObject('Analytics/sideBar/a_1'))

	}

	@Keyword
	public void  wasteGenDivesion(){

		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_Generated Wastelbsoccupant'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_Undiverted Wastelbsoccupan'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/h4_WASTE GENERATIONDIVERSION'),3)

		String Occupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
		String Sqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

		double OccupantTotal = Double.parseDouble(Occupant)
		double SqarefootTotal = Double.parseDouble(Sqarefoot)
		if(OccupantTotal==0.0000) {
			KeywordUtil.markFailedAndStop("!!!Analytics WASTE GENERATION/DIVERSION Generated Waste/lbs/occupant Undiverted Waste/lbs/occupant readings is not generated hence displays as 0.0000 after filling all the data and recomputed score!!!!!!")
		}

		else {
			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'),'Per month', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)
			double mOccupant = OccupantTotal/12
			double mSqarefoot = SqarefootTotal/12

			BigDecimal pmOccupant = new BigDecimal(mOccupant)
			pmOccupant = pmOccupant.setScale(4, RoundingMode.HALF_UP)

			BigDecimal pmSqarefoot = new BigDecimal(mSqarefoot)
			pmSqarefoot = pmSqarefoot.setScale(4, RoundingMode.HALF_UP)

			String cpmOccupant =pmOccupant.toString()
			String cpmSqarefoot =pmSqarefoot.toString()

			String uOccupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
			String uSqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

			WebUI.verifyMatch(cpmOccupant, uOccupant, false)
			WebUI.verifyMatch(cpmSqarefoot, uSqarefoot, false)

			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'), 'Per day', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)
			double dOccupant = OccupantTotal/365
			double dSqarefoot = SqarefootTotal/365

			BigDecimal dpOccupant = new BigDecimal(dOccupant)
			dpOccupant = dpOccupant.setScale(4, RoundingMode.HALF_UP)

			BigDecimal dpSqarefoot = new BigDecimal(dSqarefoot)
			dpSqarefoot = dpSqarefoot.setScale(4, RoundingMode.HALF_UP)

			String cdOccupant =dpOccupant.toString()
			String cdSqarefoot =dpSqarefoot.toString()

			String udOccupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
			String udSqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

			WebUI.verifyMatch(cdOccupant, udOccupant, false)
			WebUI.verifyMatch(cdSqarefoot, udSqarefoot, false)
		}
	}
	@Keyword
	public void  Scope1scope2Calcuation(){


		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/h4_CARBON CONSUMPTION'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/th_Limited Scope 1'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_MTCO2esquare foot'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_MTCO2eoccupant'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/th_Limited Scope 2'),3)



		String EnergyOccupantMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope1'))
		String EnergyOccupantMTCO2eScope2 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope2'))
		String EnergySqFootMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergySqFootMTCO2eScope1'))
		String EnergySquareFootMTCO2eScope2 =WebUI.getText(findTestObject('Analytics/yearsCal/EnergySquareFootMTCO2eScope2'))

		double EnergyoccupantMTCO2eScope1 = Double.parseDouble(EnergyOccupantMTCO2eScope1)
		double EnergyoccupantMTCO2eScope2 = Double.parseDouble(EnergyOccupantMTCO2eScope2)
		double EnergysqFootMTCO2eScope1 = Double.parseDouble(EnergySqFootMTCO2eScope1)
		double EnergysquareFootMTCO2eScope2 = Double.parseDouble(EnergySquareFootMTCO2eScope2)
		if(EnergyoccupantMTCO2eScope2==0.0000) {
			KeywordUtil.markFailedAndStop("!!!Analytics Energy Carbon consumption MTCO2e/occupant and MTCO2e/square foot and the column of the scope 1 and scope 2 readings is not generated hence displays as 0.0000 after filling all the data and recomputed score!!!!!!")
		}

		else {

			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'),'Per month', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)
			double energyoccupantMTCO2eScope1 = EnergyoccupantMTCO2eScope1/12
			double energyoccupantMTCO2eScope2 = EnergyoccupantMTCO2eScope2/12
			double energysqFootMTCO2eScope1 = EnergysqFootMTCO2eScope1/12
			double energysquareFootMTCO2eScope2 = EnergysquareFootMTCO2eScope2/12

			BigDecimal energyoccupantMTCO2escope1 = new BigDecimal(energyoccupantMTCO2eScope1)
			energyoccupantMTCO2escope1 = energyoccupantMTCO2escope1.setScale(4, RoundingMode.HALF_UP)

			BigDecimal energyoccupantMTCO2escope2 = new BigDecimal(energyoccupantMTCO2eScope2)
			energyoccupantMTCO2escope2 = energyoccupantMTCO2escope2.setScale(4, RoundingMode.HALF_UP)

			BigDecimal energysqFootMTCO2escope1 = new BigDecimal(energysqFootMTCO2eScope1)
			energysqFootMTCO2escope1 = energysqFootMTCO2escope1.setScale(4, RoundingMode.HALF_UP)

			BigDecimal energysquareFootMTCO2escope2 = new BigDecimal(energysquareFootMTCO2eScope2)
			energysquareFootMTCO2escope2 = energysquareFootMTCO2escope2.setScale(4, RoundingMode.HALF_UP)

			String energyoccupantmTCO2escope1 =energyoccupantMTCO2escope1.toString()
			String energyoccupantmTCO2escope2 =energyoccupantMTCO2escope2.toString()
			String energysqFootmTCO2escope1 =energysqFootMTCO2escope1.toString()
			String energysquareFootmTCO2escope2 =energysquareFootMTCO2escope2.toString()

			String mEnergyOccupantMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope1'))
			String mEnergyOccupantMTCO2eScope2 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope2'))
			String mEnergySqFootMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergySqFootMTCO2eScope1'))
			String mEnergySquareFootMTCO2eScope2 =WebUI.getText(findTestObject('Analytics/yearsCal/EnergySquareFootMTCO2eScope2'))


			WebUI.verifyMatch(energyoccupantmTCO2escope1, mEnergyOccupantMTCO2eScope1, false)
			WebUI.verifyMatch(energyoccupantmTCO2escope2, mEnergyOccupantMTCO2eScope2, false)
			WebUI.verifyMatch(energysqFootmTCO2escope1, mEnergySqFootMTCO2eScope1, false)
			WebUI.verifyMatch(energysquareFootmTCO2escope2, mEnergySquareFootMTCO2eScope2, false)

			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'), 'Per day', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)

			String dEnergyOccupantMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope1'))
			String dEnergyOccupantMTCO2eScope2 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergyOccupantMTCO2eScope2'))
			String dEnergySqFootMTCO2eScope1 = WebUI.getText(findTestObject('Analytics/yearsCal/EnergySqFootMTCO2eScope1'))
			String dEnergySquareFootMTCO2eScope2 =WebUI.getText(findTestObject('Analytics/yearsCal/EnergySquareFootMTCO2eScope2'))
			double denergyoccupantMTCO2eScope1 = EnergyoccupantMTCO2eScope1/365
			double denergyoccupantMTCO2eScope2 = EnergyoccupantMTCO2eScope2/365
			double denergysqFootMTCO2eScope1 = EnergysqFootMTCO2eScope1/365
			double denergysquareFootMTCO2eScope2 = EnergysquareFootMTCO2eScope2/365

			BigDecimal denergyoccupantMTCO2escope1 = new BigDecimal(denergyoccupantMTCO2eScope1)
			denergyoccupantMTCO2escope1 = denergyoccupantMTCO2escope1.setScale(4, RoundingMode.HALF_UP)

			BigDecimal denergyoccupantMTCO2escope2 = new BigDecimal(denergyoccupantMTCO2eScope2)
			denergyoccupantMTCO2escope2 = denergyoccupantMTCO2escope2.setScale(4, RoundingMode.HALF_UP)

			BigDecimal denergysqFootMTCO2escope1 = new BigDecimal(denergysqFootMTCO2eScope1)
			denergysqFootMTCO2escope1 = denergysqFootMTCO2escope1.setScale(4, RoundingMode.HALF_UP)

			BigDecimal denergysquareFootMTCO2escope2 = new BigDecimal(denergysquareFootMTCO2eScope2)
			denergysquareFootMTCO2escope2 = denergysquareFootMTCO2escope2.setScale(4, RoundingMode.HALF_UP)
		}
	}

	@Keyword
	public void  waterConsumption(){

		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/h4_WATER CONSUMPTION'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_gallonsoccupant'),3)
		WebUI.verifyElementPresent(findTestObject('Analytics/ElementPre/div_gallonssquare foot'),3)

		String Occupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
		String Sqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

		double OccupantTotal = Double.parseDouble(Occupant)
		double SqarefootTotal = Double.parseDouble(Sqarefoot)


		if(OccupantTotal==0.0000) {
			KeywordUtil.markFailedAndStop("!!!Analytics WATER CONSUMPTION gallons/occupant  gallons/square foot readings is not generated hence displays as 0.0000 after filling all the data and recomputed score!!!!!!")
		}

		else {

			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'),'Per month', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)

			double mOccupant = OccupantTotal/12
			double mSqarefoot = SqarefootTotal/12

			BigDecimal pmOccupant = new BigDecimal(mOccupant)
			pmOccupant = pmOccupant.setScale(4, RoundingMode.HALF_UP)

			BigDecimal pmSqarefoot = new BigDecimal(mSqarefoot)
			pmSqarefoot = pmSqarefoot.setScale(4, RoundingMode.HALF_UP)

			String cpmOccupant =pmOccupant.toString()
			String cpmSqarefoot =pmSqarefoot.toString()

			String uOccupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
			String uSqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

			WebUI.verifyMatch(cpmOccupant, uOccupant, false)
			WebUI.verifyMatch(cpmSqarefoot, uSqarefoot, false)

			WebUI.selectOptionByLabel(findTestObject('Analytics/yearsCal/Peryear'), 'Per day', false, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(3)
			double dOccupant = OccupantTotal/365
			double dSqarefoot = SqarefootTotal/365

			BigDecimal dpOccupant = new BigDecimal(dOccupant)
			dpOccupant = dpOccupant.setScale(4, RoundingMode.HALF_UP)

			BigDecimal dpSqarefoot = new BigDecimal(dSqarefoot)
			dpSqarefoot = dpSqarefoot.setScale(4, RoundingMode.HALF_UP)

			String cdOccupant =dpOccupant.toString()
			String cdSqarefoot =dpSqarefoot.toString()

			String udOccupant = WebUI.getText(findTestObject('Analytics/yearsCal/Occupant'))
			String udSqarefoot = WebUI.getText(findTestObject('Analytics/yearsCal/Sqarefoot'))

			WebUI.verifyMatch(cdOccupant, udOccupant, false)
			WebUI.verifyMatch(cdSqarefoot, udSqarefoot, false)
		}
	}
	@Keyword
	public void elocalAvgGlobalAvg() {
		/*	WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)
		 */		
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Energy'))
		WebUI.delay(5)
		WebUI.waitForElementVisible(findTestObject('Analytics/TotalPage/EngGlobalAvg'), 20)
		String engGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/EngGlobalAvg'))
		String eengGlobal = "Global average: ".concat(engGlobal)
		String engLocal = WebUI.getText(findTestObject('Analytics/TotalPage/EngLocalAvg'))
		String eengLocal = "Local average: ".concat(engLocal)

		println engGlobal
		println engLocal

		/*	WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 */	WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)
		String tengGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/TEngGlobalAvg'))
		String tengLocal = WebUI.getText(findTestObject('Analytics/TotalPage/TEngLocalAvg'))
		println tengGlobal
		println tengLocal
		WebUI.verifyMatch(eengGlobal, tengGlobal, false)
		WebUI.verifyMatch(eengLocal, tengLocal, false)
	}
	@Keyword
	public void eHighLowAvgScore(String sheetName ,int rowNum) {
		WebUI.delay(8)
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(3)
		WebUI.refresh()
		WebUI.delay(3)
		WebUI.refresh()
		WebUI.delay(17)
		/*WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 WebUI.delay(3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		 WebUI.delay(2)*/

		WebUI.click(findTestObject('Analytics/Nav/a_ Energy'))
		WebUI.delay(5)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore1'))
		WebUI.delay(1)
		String engScore1 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly1= engScore1.replaceAll("[^0-9]", "")
		println engScorenumberOnly1
		int engScoreInt1= Integer.parseInt(engScorenumberOnly1)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore2'))
		WebUI.delay(1)
		String engScore2 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly2= engScore2.replaceAll("[^0-9]", "")
		println engScorenumberOnly2
		int engScoreInt2= Integer.parseInt(engScorenumberOnly2)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore3'))
		WebUI.delay(1)
		String engScore3 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly3= engScore3.replaceAll("[^0-9]", "")
		println engScorenumberOnly3
		int engScoreInt3= Integer.parseInt(engScorenumberOnly3)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore4'))
		WebUI.delay(1)
		String engScore4 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly4= engScore4.replaceAll("[^0-9]", "")
		println engScorenumberOnly4
		int engScoreInt4= Integer.parseInt(engScorenumberOnly4)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore5'))
		WebUI.delay(1)
		String engScore5 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly5= engScore5.replaceAll("[^0-9]", "")
		println engScorenumberOnly5
		int engScoreInt5= Integer.parseInt(engScorenumberOnly5)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore6'))
		WebUI.delay(1)
		String engScore6 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly6= engScore6.replaceAll("[^0-9]", "")
		println engScorenumberOnly6
		int engScoreInt6= Integer.parseInt(engScorenumberOnly6)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore7'))
		WebUI.delay(1)
		String engScore7 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly7= engScore1.replaceAll("[^0-9]", "")
		println engScorenumberOnly7
		int engScoreInt7= Integer.parseInt(engScorenumberOnly7)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore8'))
		WebUI.delay(1)
		String engScore8 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly8= engScore8.replaceAll("[^0-9]", "")
		println engScorenumberOnly8
		int engScoreInt8= Integer.parseInt(engScorenumberOnly8)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore9'))
		WebUI.delay(1)
		String engScore9 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly9= engScore9.replaceAll("[^0-9]", "")
		println engScorenumberOnly9
		int engScoreInt9= Integer.parseInt(engScorenumberOnly9)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore10'))
		WebUI.delay(1)
		String engScore10 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly10= engScore10.replaceAll("[^0-9]", "")
		println engScorenumberOnly10
		int engScoreInt10= Integer.parseInt(engScorenumberOnly10)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore11'))
		WebUI.delay(1)
		String engScore11 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly11= engScore11.replaceAll("[^0-9]", "")
		println engScorenumberOnly11
		int engScoreInt11= Integer.parseInt(engScorenumberOnly11)

		WebUI.focus(findTestObject('Analytics/TotalPage/engScore12'))
		WebUI.delay(3)
		String engHighScore12 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String engScorenumberOnly12= engHighScore12.replaceAll("[^0-9]", "")
		println engScorenumberOnly12
		int engScoreInt12= Integer.parseInt(engScorenumberOnly12)

		ArrayList<Integer> energy = new ArrayList<Integer>()
		energy.add(engScoreInt1)
		energy.add(engScoreInt2)
		energy.add(engScoreInt3)
		energy.add(engScoreInt4)
		energy.add(engScoreInt5)
		energy.add(engScoreInt6)
		energy.add(engScoreInt7)
		energy.add(engScoreInt8)
		energy.add(engScoreInt9)
		energy.add(engScoreInt10)
		energy.add(engScoreInt11)
		energy.add(engScoreInt12)

		Collections.sort(energy)
		println energy
		Collections.reverse(energy)
		println energy

		for(int i = 0; i<=11; i++) {
			if(i==0){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",2,highest)
			}
			if(i==11){
				System.out.println(energy.get(i))
				String loweset = energy.get(i)
				data.setCellData(sheetName,"energyScore", 3, loweset)
			}
		}
		float energyAvgcal = (engScoreInt1 + engScoreInt2 +engScoreInt3 +engScoreInt4 +engScoreInt5 + engScoreInt6 + engScoreInt7 + engScoreInt8 + engScoreInt9 + engScoreInt10 + engScoreInt11 + engScoreInt12 ) / 12
		String energyAvgCal = Math.round(energyAvgcal)

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String UIEngAvgScore = WebUI.getText(findTestObject('Analytics/TotalPage/TotalEngAvg'))
		double UIEngAvgscore = Double.parseDouble(UIEngAvgScore)
		int UiEngAvgScore = Math.round(UIEngAvgscore)
		String UIengAvgScore = UiEngAvgScore.toString()

		String cehighScore = data.getCellData(sheetName,"energyScore",2)
		String celowScore = data.getCellData(sheetName,"energyScore",3)

		/****************************Verifying highest Energy Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalEngHigh')), cehighScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying lowest Energy Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalEngLow')), celowScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying Average Energy Score **************************************************/
		WebUI.verifyMatch(UIengAvgScore,energyAvgCal,true,FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public void waterlocalAvgGlobalAvg() {
		/*	WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)*/

		WebUI.click(findTestObject('PerformanceScore/Score/a_ Water'))
		WebUI.delay(5)

		String waterGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/WaterGlobalAvg'))
		String ewaterGlobal = "Global average: ".concat(waterGlobal)
		String waterLocal = WebUI.getText(findTestObject('Analytics/TotalPage/WaterLocalAvg'))
		String ewaterLocal = "Local average: ".concat(waterLocal)

		println waterGlobal
		println waterLocal

		/*	WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 */	
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)
		String twaterGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/TWaterGlobalAvg'))
		String twaterLocal = WebUI.getText(findTestObject('Analytics/TotalPage/TWaterLocalAvg'))
		println twaterGlobal
		println twaterLocal
		WebUI.verifyMatch(ewaterGlobal, twaterGlobal, true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(ewaterLocal, twaterLocal, true, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public void waterHighLowAvgScore(String sheetName ,int rowNum) {
		/*	WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 */
		WebUI.click(findTestObject('Analytics/Nav/a_ Water'))
		WebUI.delay(5)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore1'))
		WebUI.delay(1)
		String waterScore1 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly1= waterScore1.replaceAll("[^0-9]", "")
		println waterScorenumberOnly1
		int waterScoreInt1= Integer.parseInt(waterScorenumberOnly1)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore2'))
		WebUI.delay(1)
		String waterScore2 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly2= waterScore2.replaceAll("[^0-9]", "")
		println waterScorenumberOnly2
		int waterScoreInt2= Integer.parseInt(waterScorenumberOnly2)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore3'))
		WebUI.delay(1)
		String waterScore3 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly3= waterScore3.replaceAll("[^0-9]", "")
		println waterScorenumberOnly3
		int waterScoreInt3= Integer.parseInt(waterScorenumberOnly3)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore4'))
		WebUI.delay(1)
		String waterScore4 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly4= waterScore4.replaceAll("[^0-9]", "")
		println waterScorenumberOnly4
		int waterScoreInt4= Integer.parseInt(waterScorenumberOnly4)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore5'))
		WebUI.delay(1)
		String waterScore5 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly5= waterScore5.replaceAll("[^0-9]", "")
		println waterScorenumberOnly5
		int waterScoreInt5= Integer.parseInt(waterScorenumberOnly5)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore6'))
		WebUI.delay(1)
		String waterScore6 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly6= waterScore6.replaceAll("[^0-9]", "")
		println waterScorenumberOnly6
		int waterScoreInt6= Integer.parseInt(waterScorenumberOnly6)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore7'))
		WebUI.delay(1)
		String waterScore7 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly7= waterScore1.replaceAll("[^0-9]", "")
		println waterScorenumberOnly7
		int waterScoreInt7= Integer.parseInt(waterScorenumberOnly7)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore8'))
		WebUI.delay(1)
		String waterScore8 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly8= waterScore8.replaceAll("[^0-9]", "")
		println waterScorenumberOnly8
		int waterScoreInt8= Integer.parseInt(waterScorenumberOnly8)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore9'))
		WebUI.delay(1)
		String waterScore9 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly9= waterScore9.replaceAll("[^0-9]", "")
		println waterScorenumberOnly9
		int waterScoreInt9= Integer.parseInt(waterScorenumberOnly9)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore10'))
		WebUI.delay(1)
		String waterScore10 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly10= waterScore10.replaceAll("[^0-9]", "")
		println waterScorenumberOnly10
		int waterScoreInt10= Integer.parseInt(waterScorenumberOnly10)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore11'))
		WebUI.delay(1)
		String waterScore11 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly11= waterScore11.replaceAll("[^0-9]", "")
		println waterScorenumberOnly11
		int waterScoreInt11= Integer.parseInt(waterScorenumberOnly11)

		WebUI.focus(findTestObject('Analytics/TotalPage/waterScore12'))
		WebUI.delay(3)
		String waterHighScore12 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String waterScorenumberOnly12= waterHighScore12.replaceAll("[^0-9]", "")
		println waterScorenumberOnly12
		int waterScoreInt12= Integer.parseInt(waterScorenumberOnly12)

		ArrayList<Integer> water = new ArrayList<Integer>()
		water.add(waterScoreInt1)
		water.add(waterScoreInt2)
		water.add(waterScoreInt3)
		water.add(waterScoreInt4)
		water.add(waterScoreInt5)
		water.add(waterScoreInt6)
		water.add(waterScoreInt7)
		water.add(waterScoreInt8)
		water.add(waterScoreInt9)
		water.add(waterScoreInt10)
		water.add(waterScoreInt11)
		water.add(waterScoreInt12)

		Collections.sort(water)
		println water
		Collections.reverse(water)
		println water

		for(int i = 0; i<=11; i++) {
			if(i==0){
				System.out.println(water.get(i))
				String highest = water.get(i)
				data.setCellData(sheetName,"waterScore",2,highest)
			}
			if(i==11){
				System.out.println(water.get(i))
				String loweset = water.get(i)
				data.setCellData(sheetName,"waterScore", 3, loweset)
			}
		}
		float waterAvgcal = (waterScoreInt1 + waterScoreInt2 +waterScoreInt3 +waterScoreInt4 +waterScoreInt5 + waterScoreInt6 + waterScoreInt7 + waterScoreInt8 + waterScoreInt9 + waterScoreInt10 + waterScoreInt11 + waterScoreInt12 ) / 12
		String waterAvgCal = Math.round(waterAvgcal)

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String UIwaterAvgScore = WebUI.getText(findTestObject('Analytics/TotalPage/TotalwaterAvg'))
		double UIwaterAvgscore = Double.parseDouble(UIwaterAvgScore)
		int UiwaterAvgScore = Math.round(UIwaterAvgscore)
		String UIwaterAvgScor = UiwaterAvgScore.toString()

		String cehighScore = data.getCellData(sheetName,"waterScore",2)
		String celowScore = data.getCellData(sheetName,"waterScore",3)

		/****************************Verifying highest water Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalwaterHigh')), cehighScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying lowest water Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalwaterLow')), celowScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying Average water Score **************************************************/
		WebUI.verifyMatch(UIwaterAvgScor,waterAvgCal,true,FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	public void wastelocalAvgGlobalAvg() {
		/*WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)
		 */	WebUI.click(findTestObject('PerformanceScore/Score/a_ Waste'))
		WebUI.delay(12)

		String wasteGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/WasteGlobalAvg'))
		String ewasteGlobal = "Global average: ".concat(wasteGlobal)
		String wasteLocal = WebUI.getText(findTestObject('Analytics/TotalPage/WasteLocalAvg'))
		String ewasteLocal = "Local average: ".concat(wasteLocal)

		println wasteGlobal
		println wasteLocal

		/*		WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))*/

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)
		String twasteGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/TWasteGlobalAvg'))
		String twasteLocal = WebUI.getText(findTestObject('Analytics/TotalPage/TWasteLocalAvg'))
		println twasteGlobal
		println twasteLocal
		WebUI.verifyMatch(ewasteGlobal, twasteGlobal, false)
		WebUI.verifyMatch(ewasteLocal, twasteLocal, false)
	}
	@Keyword
	public void wasteHighLowAvgScore(String sheetName ,int rowNum) {
		/*WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 WebUI.delay(4)
		 */	

		WebUI.click(findTestObject('Analytics/Nav/a_ Waste'))
		WebUI.delay(5)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore1'))
		WebUI.delay(1)
		String wasteScore1 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly1= wasteScore1.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly1
		int wasteScoreInt1= Integer.parseInt(wasteScorenumberOnly1)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore2'))
		WebUI.delay(1)
		String wasteScore2 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly2= wasteScore2.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly2
		int wasteScoreInt2= Integer.parseInt(wasteScorenumberOnly2)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore3'))
		WebUI.delay(1)
		String wasteScore3 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly3= wasteScore3.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly3
		int wasteScoreInt3= Integer.parseInt(wasteScorenumberOnly3)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore4'))
		WebUI.delay(1)
		String wasteScore4 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly4= wasteScore4.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly4
		int wasteScoreInt4= Integer.parseInt(wasteScorenumberOnly4)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore5'))
		WebUI.delay(1)
		String wasteScore5 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly5= wasteScore5.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly5
		int wasteScoreInt5= Integer.parseInt(wasteScorenumberOnly5)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore6'))
		WebUI.delay(1)
		String wasteScore6 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly6= wasteScore6.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly6
		int wasteScoreInt6= Integer.parseInt(wasteScorenumberOnly6)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore7'))
		WebUI.delay(1)
		String wasteScore7 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly7= wasteScore1.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly7
		int wasteScoreInt7= Integer.parseInt(wasteScorenumberOnly7)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore8'))
		WebUI.delay(1)
		String wasteScore8 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly8= wasteScore8.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly8
		int wasteScoreInt8= Integer.parseInt(wasteScorenumberOnly8)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore9'))
		WebUI.delay(1)
		String wasteScore9 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly9= wasteScore9.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly9
		int wasteScoreInt9= Integer.parseInt(wasteScorenumberOnly9)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore10'))
		WebUI.delay(1)
		String wasteScore10 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly10= wasteScore10.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly10
		int wasteScoreInt10= Integer.parseInt(wasteScorenumberOnly10)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore11'))
		WebUI.delay(1)
		String wasteScore11 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly11= wasteScore11.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly11
		int wasteScoreInt11= Integer.parseInt(wasteScorenumberOnly11)

		WebUI.focus(findTestObject('Analytics/TotalPage/wasteScore12'))
		WebUI.delay(3)
		String wasteHighScore12 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String wasteScorenumberOnly12= wasteHighScore12.replaceAll("[^0-9]", "")
		println wasteScorenumberOnly12
		int wasteScoreInt12= Integer.parseInt(wasteScorenumberOnly12)

		ArrayList<Integer> waste = new ArrayList<Integer>()
		waste.add(wasteScoreInt1)
		waste.add(wasteScoreInt2)
		waste.add(wasteScoreInt3)
		waste.add(wasteScoreInt4)
		waste.add(wasteScoreInt5)
		waste.add(wasteScoreInt6)
		waste.add(wasteScoreInt7)
		waste.add(wasteScoreInt8)
		waste.add(wasteScoreInt9)
		waste.add(wasteScoreInt10)
		waste.add(wasteScoreInt11)
		waste.add(wasteScoreInt12)

		Collections.sort(waste)
		println waste
		Collections.reverse(waste)
		println waste

		for(int i = 0; i<=11; i++) {
			if(i==0){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				data.setCellData(sheetName,"wasteScore",2,highest)
			}
			if(i==11){
				System.out.println(waste.get(i))
				String loweset = waste.get(i)
				data.setCellData(sheetName,"wasteScore", 3, loweset)
			}
		}
		float wasteAvgcal = (wasteScoreInt1 + wasteScoreInt2 +wasteScoreInt3 +wasteScoreInt4 +wasteScoreInt5 + wasteScoreInt6 + wasteScoreInt7 + wasteScoreInt8 + wasteScoreInt9 + wasteScoreInt10 + wasteScoreInt11 + wasteScoreInt12 ) / 12
		String wasteAvgCal = Math.round(wasteAvgcal)

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String UIwasteAvgScore = WebUI.getText(findTestObject('Analytics/TotalPage/TotalwasteAvg'))
		double UIwasteAvgscore = Double.parseDouble(UIwasteAvgScore)
		int UiwasteAvgScore = Math.round(UIwasteAvgscore)
		String UIWasteAvgScore = UiwasteAvgScore.toString()

		String cehighScore = data.getCellData(sheetName,"wasteScore",2)
		String celowScore = data.getCellData(sheetName,"wasteScore",3)

		/****************************Verifying highest waste Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalwasteHigh')), cehighScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying lowest waste Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalwasteLow')), celowScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying Average waste Score **************************************************/
		WebUI.verifyMatch(UIWasteAvgScore,wasteAvgCal,true,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void tlocalAvgGlobalAvg() {
		/*	WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)
		 */		
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Transportation'))
		WebUI.delay(8)
		WebUI.waitForElementVisible(findTestObject('Analytics/TotalPage/TransGlobalAvg'), 20)
		String transGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/TransGlobalAvg'))
		String etransGlobal = "Global average: ".concat(transGlobal)
		String transLocal = WebUI.getText(findTestObject('Analytics/TotalPage/TransLocalAvg'))
		String etransLocal = "Local average: ".concat(transLocal)

		println transGlobal
		println transLocal

		/*	WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 */	
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(3)

		String ttransGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/TTransGlobalAvg'))
		String ttransLocal = WebUI.getText(findTestObject('Analytics/TotalPage/TTransLocalAvg'))
		println ttransGlobal
		println ttransLocal
		WebUI.verifyMatch(etransGlobal, ttransGlobal, false)
		WebUI.verifyMatch(etransLocal, ttransLocal, false)
	}
	@Keyword
	public void transHighLowAvgScore(String sheetName ,int rowNum) {
		/*WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 WebUI.delay(4)
		 */	

		WebUI.click(findTestObject('Analytics/Nav/a_ Transportation'))
		WebUI.delay(8)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore1'))
		WebUI.delay(1)
		String transScore1 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly1= transScore1.replaceAll("[^0-9]", "")
		println transScorenumberOnly1
		int transScoreInt1= Integer.parseInt(transScorenumberOnly1)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore2'))
		WebUI.delay(1)
		String transScore2 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly2= transScore2.replaceAll("[^0-9]", "")
		println transScorenumberOnly2
		int transScoreInt2= Integer.parseInt(transScorenumberOnly2)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore3'))
		WebUI.delay(1)
		String transScore3 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly3= transScore3.replaceAll("[^0-9]", "")
		println transScorenumberOnly3
		int transScoreInt3= Integer.parseInt(transScorenumberOnly3)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore4'))
		WebUI.delay(1)
		String transScore4 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly4= transScore4.replaceAll("[^0-9]", "")
		println transScorenumberOnly4
		int transScoreInt4= Integer.parseInt(transScorenumberOnly4)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore5'))
		WebUI.delay(1)
		String transScore5 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly5= transScore5.replaceAll("[^0-9]", "")
		println transScorenumberOnly5
		int transScoreInt5= Integer.parseInt(transScorenumberOnly5)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore6'))
		WebUI.delay(1)
		String transScore6 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly6= transScore6.replaceAll("[^0-9]", "")
		println transScorenumberOnly6
		int transScoreInt6= Integer.parseInt(transScorenumberOnly6)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore7'))
		WebUI.delay(1)
		String transScore7 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly7= transScore1.replaceAll("[^0-9]", "")
		println transScorenumberOnly7
		int transScoreInt7= Integer.parseInt(transScorenumberOnly7)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore8'))
		WebUI.delay(1)
		String transScore8 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly8= transScore8.replaceAll("[^0-9]", "")
		println transScorenumberOnly8
		int transScoreInt8= Integer.parseInt(transScorenumberOnly8)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore9'))
		WebUI.delay(1)
		String transScore9 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly9= transScore9.replaceAll("[^0-9]", "")
		println transScorenumberOnly9
		int transScoreInt9= Integer.parseInt(transScorenumberOnly9)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore10'))
		WebUI.delay(1)
		String transScore10 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly10= transScore10.replaceAll("[^0-9]", "")
		println transScorenumberOnly10
		int transScoreInt10= Integer.parseInt(transScorenumberOnly10)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore11'))
		WebUI.delay(1)
		String transScore11 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly11= transScore11.replaceAll("[^0-9]", "")
		println transScorenumberOnly11
		int transScoreInt11= Integer.parseInt(transScorenumberOnly11)

		WebUI.focus(findTestObject('Analytics/TotalPage/transScore12'))
		WebUI.delay(3)
		String transHighScore12 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String transScorenumberOnly12= transHighScore12.replaceAll("[^0-9]", "")
		println transScorenumberOnly12
		int transScoreInt12= Integer.parseInt(transScorenumberOnly12)


		ArrayList<Integer> trans = new ArrayList<Integer>()
		trans.add(transScoreInt1)
		trans.add(transScoreInt2)
		trans.add(transScoreInt3)
		trans.add(transScoreInt4)
		trans.add(transScoreInt5)
		trans.add(transScoreInt6)
		trans.add(transScoreInt7)
		trans.add(transScoreInt8)
		trans.add(transScoreInt9)
		trans.add(transScoreInt10)
		trans.add(transScoreInt11)
		trans.add(transScoreInt12)

		Collections.sort(trans)
		println trans
		Collections.reverse(trans)
		println trans

		for(int i = 0; i<=11; i++) {
			if(i==0){
				System.out.println(trans.get(i))
				String highest = trans.get(i)
				data.setCellData(sheetName,"transportation",2,highest)
			}
			if(i==11){
				System.out.println(trans.get(i))
				String loweset = trans.get(i)
				data.setCellData(sheetName,"transportation", 3, loweset)
			}
		}
		float transAvgcal = (transScoreInt1 + transScoreInt2 +transScoreInt3 +transScoreInt4 +transScoreInt5 + transScoreInt6 + transScoreInt7 + transScoreInt8 + transScoreInt9 + transScoreInt10 + transScoreInt11 + transScoreInt12 ) / 12
		String transAvgCal = Math.round(transAvgcal)

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String UItransAvgScore = WebUI.getText(findTestObject('Analytics/TotalPage/TotaltransAvg'))
		double UItransAvgscore = Double.parseDouble(UItransAvgScore)
		int UitransAvgScore = Math.round(UItransAvgscore)
		String UITransAvgScore = UitransAvgScore.toString()

		String cehighScore = data.getCellData(sheetName,"transportation",2)
		String celowScore = data.getCellData(sheetName,"transportation",3)

		/****************************Verifying highest trans Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotaltransHigh')), cehighScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying lowest trans Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotaltransLow')), celowScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying Average trans Score **************************************************/
		WebUI.verifyMatch(UITransAvgScore,transAvgCal,true,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void hlocalAvgGlobalAvg() {
		/*		WebUI.delay(5)
		 WebUI.click(findTestObject('PerformanceScore/Score/a_ Score'))
		 WebUI.delay(3)*/
		WebUI.click(findTestObject('PerformanceScore/Score/a_ Human Experience'))
		WebUI.delay(8)
		WebUI.waitForElementVisible(findTestObject('Analytics/TotalPage/HumGlobalAvg'), 20)
		String HumGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/HumGlobalAvg'))
		String eHumGlobal = "Global average: ".concat(HumGlobal)
		String HumLocal = WebUI.getText(findTestObject('Analytics/TotalPage/HumLocalAvg'))
		String eHumLocal = "Local average: ".concat(HumLocal)

		println HumGlobal
		println HumLocal

		/*WebUI.scrollToElement(findTestObject('Object Repository/Analytics/ClickOnAnalytics'), 3)
		 WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalytics'))
		 */
		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)
		String tHumGlobal = WebUI.getText(findTestObject('Analytics/TotalPage/THumGlobalAvg'))
		String tHumLocal = WebUI.getText(findTestObject('Analytics/TotalPage/THumLocalAvg'))
		println tHumGlobal
		println tHumLocal
		WebUI.verifyMatch(eHumGlobal, tHumGlobal, false)
		WebUI.verifyMatch(eHumLocal, tHumLocal, false)
	}


	@Keyword
	public void hHighLowAvgScore(String sheetName ,int rowNum) {
		WebUI.delay(2)

		WebUI.click(findTestObject('Analytics/Nav/a_ Human Experience'))
		WebUI.delay(5)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore1'))
		WebUI.delay(1)
		String humScore1 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly1= humScore1.replaceAll("[^0-9]", "")
		println humScorenumberOnly1
		int humScoreInt1= Integer.parseInt(humScorenumberOnly1)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore2'))
		WebUI.delay(1)
		String humScore2 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly2= humScore2.replaceAll("[^0-9]", "")
		println humScorenumberOnly2
		int humScoreInt2= Integer.parseInt(humScorenumberOnly2)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore3'))
		WebUI.delay(1)
		String humScore3 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly3= humScore3.replaceAll("[^0-9]", "")
		println humScorenumberOnly3
		int humScoreInt3= Integer.parseInt(humScorenumberOnly3)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore4'))
		WebUI.delay(1)
		String humScore4 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly4= humScore4.replaceAll("[^0-9]", "")
		println humScorenumberOnly4
		int humScoreInt4= Integer.parseInt(humScorenumberOnly4)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore5'))
		WebUI.delay(1)
		String humScore5 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly5= humScore5.replaceAll("[^0-9]", "")
		println humScorenumberOnly5
		int humScoreInt5= Integer.parseInt(humScorenumberOnly5)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore6'))
		WebUI.delay(1)
		String humScore6 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly6= humScore6.replaceAll("[^0-9]", "")
		println humScorenumberOnly6
		int humScoreInt6= Integer.parseInt(humScorenumberOnly6)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore7'))
		WebUI.delay(1)
		String humScore7 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly7= humScore1.replaceAll("[^0-9]", "")
		println humScorenumberOnly7
		int humScoreInt7= Integer.parseInt(humScorenumberOnly7)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore8'))
		WebUI.delay(1)
		String humScore8 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly8= humScore8.replaceAll("[^0-9]", "")
		println humScorenumberOnly8
		int humScoreInt8= Integer.parseInt(humScorenumberOnly8)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore9'))
		WebUI.delay(1)
		String humScore9 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly9= humScore9.replaceAll("[^0-9]", "")
		println humScorenumberOnly9
		int humScoreInt9= Integer.parseInt(humScorenumberOnly9)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore10'))
		WebUI.delay(1)
		String humScore10 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly10= humScore10.replaceAll("[^0-9]", "")
		println humScorenumberOnly10
		int humScoreInt10= Integer.parseInt(humScorenumberOnly10)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore11'))
		WebUI.delay(1)
		String humScore11 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly11= humScore11.replaceAll("[^0-9]", "")
		println humScorenumberOnly11
		int humScoreInt11= Integer.parseInt(humScorenumberOnly11)

		WebUI.focus(findTestObject('Analytics/TotalPage/humScore12'))
		WebUI.delay(3)
		String humHighScore12 = WebUI.getText(findTestObject('Analytics/TotalPage/ScoreText'))
		String humScorenumberOnly12= humHighScore12.replaceAll("[^0-9]", "")
		println humScorenumberOnly12
		int humScoreInt12= Integer.parseInt(humScorenumberOnly12)

		ArrayList<Integer> hum = new ArrayList<Integer>()
		hum.add(humScoreInt1)
		hum.add(humScoreInt2)
		hum.add(humScoreInt3)
		hum.add(humScoreInt4)
		hum.add(humScoreInt5)
		hum.add(humScoreInt6)
		hum.add(humScoreInt7)
		hum.add(humScoreInt8)
		hum.add(humScoreInt9)
		hum.add(humScoreInt10)
		hum.add(humScoreInt11)
		hum.add(humScoreInt12)

		Collections.sort(hum)
		println hum
		Collections.reverse(hum)
		println hum

		for(int i = 0; i<=11; i++) {
			if(i==0){
				System.out.println(hum.get(i))
				String highest = hum.get(i)
				data.setCellData(sheetName,"humanExperience",2,highest)
			}
			if(i==11){
				System.out.println(hum.get(i))
				String loweset = hum.get(i)
				data.setCellData(sheetName,"humanExperience", 3, loweset)
			}
		}
		float humAvgcal = (humScoreInt1 + humScoreInt2 +humScoreInt3 +humScoreInt4 +humScoreInt5 + humScoreInt6 + humScoreInt7 + humScoreInt8 + humScoreInt9 + humScoreInt10 + humScoreInt11 + humScoreInt12 ) / 12
		String humAvgCal = Math.round(humAvgcal)

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(5)

		String UIhumAvgScore = WebUI.getText(findTestObject('Analytics/TotalPage/TotalhumAvg'))
		double UIhumAvgscore = Double.parseDouble(UIhumAvgScore)
		int UihumAvgScore = Math.round(UIhumAvgscore)
		String UIHumAvgScore = UihumAvgScore.toString()

		String cehighScore = data.getCellData(sheetName,"humanExperience",2)
		String celowScore = data.getCellData(sheetName,"humanExperience",3)

		/****************************Verifying highest hum Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalhumHigh')), cehighScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying lowest hum Score **************************************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/TotalPage/TotalhumLow')), celowScore, true,FailureHandling.CONTINUE_ON_FAILURE)
		/****************************Verifying Average hum Score **************************************************/
		WebUI.verifyMatch(UIHumAvgScore,humAvgCal,true,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void annualcarbonemissions(String sheetName ,int rowNum) {

		String KWHReading = data.getCellData(sheetName,"EnergykWh",2)
		String noOfDays = data.getCellData(sheetName,"ENoOfDays",2)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dKWHReading =  Double.parseDouble(KWHReading)

		double meterdatakBtu = dKWHReading * 3.4121416331 // (1 kWh = 3.4121416331 kBtu)

		Double raw_ghg = (meterdatakBtu * 210.904194234467)/dnoOfDays

		Double raw_ghginMtCo2e = raw_ghg/1000000

		Double annualcarbonemissionsMTCO2e = raw_ghginMtCo2e * 365

		BigDecimal annualCarbonemissionsMTCO2e = new BigDecimal(annualcarbonemissionsMTCO2e)
		annualCarbonemissionsMTCO2e = annualCarbonemissionsMTCO2e.setScale(4, RoundingMode.HALF_UP)
		String cannualCarbonemissionsMTCO2e = annualCarbonemissionsMTCO2e.toString()

		/****************UI Verses Calculated Value of Annual carbon Emissions (MTCO2e)*****************************/
		String UIannualCarbonemissionsMTCO2e = WebUI.getText(findTestObject('Analytics/TotalCarbon/AnnualcarbonemissionsProject'))
		WebUI.verifyMatch(UIannualCarbonemissionsMTCO2e, cannualCarbonemissionsMTCO2e, false)

	}
	@Keyword
	public void annualcarbonemissionspersqft(String sheetName ,int rowNum) {

		WebUI.click(findTestObject('Object Repository/Analytics/ClickOnAnalyticsTotal'))
		WebUI.delay(2)

		String KWHReading = data.getCellData(sheetName,"EnergykWh",2)
		String noOfDays = data.getCellData(sheetName,"ENoOfDays",2)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dKWHReading =  Double.parseDouble(KWHReading)

		double meterdatakBtu = dKWHReading * 3.4121416331 // (1 kWh = 3.4121416331 kBtu)

		Double raw_ghg = (meterdatakBtu * 210.904194234467)/dnoOfDays

		Double raw_ghginMtCo2e = raw_ghg/1000000

		Double dUIannualCarbonemissionsMTCO2e = raw_ghginMtCo2e * 365

		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		Double dgrossAreasqft =  Double.parseDouble(grossAreasqft)

		Double annualcarbonemissionsMTCO2epersqft = dUIannualCarbonemissionsMTCO2e/dgrossAreasqft

		BigDecimal cannualcarbonemissionsMTCO2epersqft = new BigDecimal(annualcarbonemissionsMTCO2epersqft)
		cannualcarbonemissionsMTCO2epersqft = cannualcarbonemissionsMTCO2epersqft.setScale(4,RoundingMode.HALF_UP)

		String cannulCarbonemissionsMTCO2epersqft = cannualcarbonemissionsMTCO2epersqft.toString()

		String UIcarbonemissionsMTCO2epersqft = WebUI.getText(findTestObject('Analytics/TotalCarbon/AnnualCarbonPerSQFt'))
		/****************UI Verses Calculated Value of Annual carbon per square feet*****************************/
		WebUI.verifyMatch(UIcarbonemissionsMTCO2epersqft, cannulCarbonemissionsMTCO2epersqft, false)
	}

	@Keyword
	public void annualcarbonemissionsperOccupancy(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",rowNum)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		String KWHReading = data.getCellData(sheetName,"EnergykWh",2)
		String noOfDays = data.getCellData(sheetName,"ENoOfDays",2)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dKWHReading =  Double.parseDouble(KWHReading)

		double meterdatakBtu = dKWHReading * 3.4121416331 // (1 kWh = 3.4121416331 kBtu)

		Double raw_ghg = (meterdatakBtu * 210.904194234467)/dnoOfDays

		Double raw_ghginMtCo2e = raw_ghg/1000000

		Double dUIannualCarbonemissionsMTCO2e = raw_ghginMtCo2e * 365

		/*String UIannualCarbonemissionsMTCO2e = WebUI.getText(findTestObject('Analytics/TotalCarbon/AnnualcarbonemissionsProject'))
		 Double dUIannualCarbonemissionsMTCO2e =  Double.parseDouble(UIannualCarbonemissionsMTCO2e)
		 */
		String annualcarbonemissionsMTCO2eperOcc = dUIannualCarbonemissionsMTCO2e/dBOccupancy
		BigDecimal annualcarbonemissionsMTCO2ePerOcc = new BigDecimal(annualcarbonemissionsMTCO2eperOcc)
		annualcarbonemissionsMTCO2ePerOcc = annualcarbonemissionsMTCO2ePerOcc.setScale(4,RoundingMode.HALF_UP)

		String cannualcarbonemissionsMTCO2ePerOcc = annualcarbonemissionsMTCO2ePerOcc.toString()
		String UIannualcarbonemissionsMTCO2eperOcc = WebUI.getText(findTestObject('Analytics/TotalCarbon/AnnualCarbonPerOccupancy'))

		/****************UI Verses Calculated Value of Annual carbon per Occupancy*****************************/
		WebUI.verifyMatch(UIannualcarbonemissionsMTCO2eperOcc, cannualcarbonemissionsMTCO2ePerOcc, false)
	}
	@Keyword
	public void annualWaterConsumtionProj(String sheetName ,int rowNum) {

		String totalUnitGal = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitGal =  Double.parseDouble(totalUnitGal)

		Double daily = dtotalUnitGal/dnoOfDays

		Double annualwaterconsumption = daily * 365

		BigDecimal cannualwaterconsumption = new BigDecimal(annualwaterconsumption)
		cannualwaterconsumption = cannualwaterconsumption.setScale(4,RoundingMode.HALF_UP)

		String cAnnualwaterconsumption = cannualwaterconsumption.toString()
		String UIAnnualwaterconsumption = WebUI.getText(findTestObject('Analytics/Cal/WAnualcarbon'))

		/****************UI Verses Calculated Value of annual water consumption in gallon *****************************/
		WebUI.verifyMatch(UIAnnualwaterconsumption, cAnnualwaterconsumption, false)
	}
	@Keyword
	public void annualWaterConsumtionPerSqfeet(String sheetName ,int rowNum) {

		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		double dgrossAreasqft =  Double.parseDouble(grossAreasqft)

		/*String UIAnnualwaterconsumption = WebUI.getText(findTestObject('Analytics/Cal/WAnualcarbon'))
		 double dUIAnnualwaterconsumption =  Double.parseDouble(UIAnnualwaterconsumption)
		 */
		String totalUnitGal = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitGal =  Double.parseDouble(totalUnitGal)

		Double daily = dtotalUnitGal/dnoOfDays

		Double dUIAnnualwaterconsumption = daily * 365

		double Annualwaterconsumption = dUIAnnualwaterconsumption / dgrossAreasqft

		BigDecimal annualwaterconsumption = new BigDecimal(Annualwaterconsumption)
		annualwaterconsumption = annualwaterconsumption.setScale(4,RoundingMode.HALF_UP)

		String cannualwaterConsumption = annualwaterconsumption.toString()

		String UIcarbonemissionsMTCO2epersqft = WebUI.getText(findTestObject('Analytics/TotalCarbon/ProjAnnualWaterSqFt'))

		/****************UI Verses Calculated Value of Annual carbon per square feet*****************************/
		WebUI.verifyMatch(UIcarbonemissionsMTCO2epersqft, cannualwaterConsumption, false)
	}
	@Keyword
	public void waterconsumptiongalPerOccupany(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",rowNum)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		//String UIwaterconsumptiongalPerOccupany = WebUI.getText(findTestObject('Analytics/Cal/WOAnualcarbon'))
		/*	String  UIwaterconsumptiongalPerOccupany=WebUI.getText(findTestObject('Analytics/Cal/WAnualcarbon'))
		 String uIwaterconsumptiongalPerOccupany =  UIwaterconsumptiongalPerOccupany.replace(',', '')
		 Double dUIwaterconsumptiongalPerOccupany =  Double.parseDouble(uIwaterconsumptiongalPerOccupany)
		 */
		String totalUnitGal = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitGal =  Double.parseDouble(totalUnitGal)

		Double daily = dtotalUnitGal/dnoOfDays

		Double dUIAnnualwaterconsumption = daily * 365
		double UIwaterconsumptiongalperOccupany = dUIAnnualwaterconsumption/dBOccupancy
		BigDecimal UIWaterconsumptiongalperOccupany = new BigDecimal(UIwaterconsumptiongalperOccupany)
		UIWaterconsumptiongalperOccupany = UIWaterconsumptiongalperOccupany.setScale(4,RoundingMode.HALF_UP)
		String cUIWaterconsumptiongalperOccupany = UIWaterconsumptiongalperOccupany.toString()

		String UIannualcarbonemissionsMTCO2eperOcc = WebUI.getText(findTestObject('Analytics/TotalCarbon/AnnualWaterConOcc'))
		String eUIAnnualcarbonemissionsMTCO2eperOcc =  UIannualcarbonemissionsMTCO2eperOcc.replace(',', '')

		/****************UI Verses Calculated Value water per Occupancy*****************************/
		WebUI.verifyMatch(eUIAnnualcarbonemissionsMTCO2eperOcc, cUIWaterconsumptiongalperOccupany, false)
	}

	@Keyword
	public void monthlywaterconsumptionProject(String sheetName ,int rowNum) {

		String  str1=WebUI.getText(findTestObject('Analytics/Cal/WAnualcarbon'))
		String str6 =  str1.replace(',', '')
		System.out.println(str1)
		double waterConsumption=Double.parseDouble(str6)
		double monthly=waterConsumption/12

		BigDecimal pden = new BigDecimal(monthly)
		pden = pden.setScale(4, RoundingMode.HALF_UP)
		String monthlyconsumption = pden.toString()

		String monthlyWater =WebUI.getText(findTestObject('Analytics/TotalCarbon/MonthlyWaterProject'))
		String UImonthlywater =  monthlyWater.replace(',', '')
		/*double d3=Double.parseDouble(str7);
		 BigDecimal pden1 = new BigDecimal(d3);
		 pden1 = pden1.setScale(4, RoundingMode.HALF_UP);
		 String UImonthlyconsumption = pden1.toString()
		 */	/****************UI Verses Calculated Value water monthly per Project *****************************/
		WebUI.verifyMatch(UImonthlywater, monthlyconsumption, false)
	}
	@Keyword
	public void monthlywaterconsumptionPerSqFeet(String sheetName ,int rowNum) {

		String  pstr1=WebUI.getText(findTestObject('Analytics/Cal/WPAnualcarbon'))
		String pstr6 =  pstr1.replace(',', '')
		double epdaily=Double.parseDouble(pstr6)/12
		BigDecimal epden = new BigDecimal(epdaily)
		epden = epden.setScale(4, RoundingMode.HALF_UP)
		String cmonthlyconsumptionft = epden.toString()

		String epdailyCarbon =WebUI.getText(findTestObject('Analytics/TotalCarbon/MontlyWaterPerSqFeet'))
		double epdailyCarbon1 =Double.parseDouble(epdailyCarbon)
		BigDecimal epden1 = new BigDecimal(epdailyCarbon1)
		epden1 = epden1.setScale(4, RoundingMode.HALF_UP)
		String UImonthlyconsumptionft = epden1.toString()
		/****************UI Verses Calculated Value water monthly per square feet *****************************/
		WebUI.verifyMatch(UImonthlyconsumptionft, epdailyCarbon, false)
	}
	@Keyword
	public void monthlywaterconsumptionOccupancy(String sheetName ,int rowNum) {
		String  ostr1=WebUI.getText(findTestObject('Analytics/Cal/WOAnualcarbon'))
		double eodaily=Double.parseDouble(ostr1)/12
		BigDecimal eoden = new BigDecimal(eodaily)
		eoden = eoden.setScale(4, RoundingMode.HALF_UP)
		String cmonthlyOccupancy = eoden.toString()

		String eodailyCarbon =WebUI.getText(findTestObject('Analytics/TotalCarbon/MonthlyWaterOccupancy'))
		double eodailyCarbon1 =Double.parseDouble(eodailyCarbon)
		BigDecimal eoden1 = new BigDecimal(eodailyCarbon1)
		eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP)
		String amonthlyOccupancy = eoden1.toString()

		/****************UI Verses Calculated Value water monthly per Occupancy*****************************/
		WebUI.verifyMatch(amonthlyOccupancy, cmonthlyOccupancy, false)
	}

	@Keyword
	public void dailywatergeneratedProject(String sheetName ,int rowNum) {

		String totalUnitlbs = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double avgdaily = dtotalUnitlbs/dnoOfDays

		BigDecimal avgdailywater = new BigDecimal(avgdaily)
		avgdailywater = avgdailywater.setScale(4,RoundingMode.HALF_UP)

		String avgdailywaterGenerated = avgdailywater.toString()

		String UIavgdailywaterGenerated = WebUI.getText(findTestObject('Analytics/Cal/WDailycarbon'))

		/****************UI Verses Calculated Value of annual water generated Per project in LBS *****************************/
		WebUI.verifyMatch(UIavgdailywaterGenerated, avgdailywaterGenerated, false)
	}

	@Keyword
	public void dailywatergeneratedSqFeet(String sheetName ,int rowNum) {

		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		Double dgrossAreasqft =  Double.parseDouble(grossAreasqft)

		/*	String UIwatergenSqFeet = WebUI.getText(findTestObject('Analytics/Cal/WDailycarbon'))
		 Double dUIwatergenSqFeet =  Double.parseDouble(UIwatergenSqFeet)*/

		String totalUnitlbs = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double avgdaily = dtotalUnitlbs/dnoOfDays

		String Annualwatergen = avgdaily/dgrossAreasqft

		BigDecimal AnnualwaterGen = new BigDecimal(Annualwatergen)
		AnnualwaterGen = AnnualwaterGen.setScale(4,RoundingMode.HALF_UP)

		String cAnnualwaterGen = AnnualwaterGen.toString()

		String UIcarbonemissionsMTCO2epersqft = WebUI.getText(findTestObject('Analytics/Cal/WPDailycarbon'))
		/****************UI Verses Calculated Value of water per square feet*****************************/
		WebUI.verifyMatch(UIcarbonemissionsMTCO2epersqft, cAnnualwaterGen, false)
	}

	@Keyword
	public void dailywatergeneratedOccupancy(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",rowNum)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		/*	String UIwatergenOccupancy = WebUI.getText(findTestObject('Analytics/Cal/WDailycarbon'))
		 Double UiwatergenOccupancy =  Double.parseDouble(UIwatergenOccupancy)*/

		String totalUnitlbs = data.getCellData(sheetName,"WaterconGal",rowNum)
		String noOfDays = data.getCellData(sheetName,"WaterNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double avgdaily = dtotalUnitlbs/dnoOfDays

		double UiwatergenOccu= avgdaily/dBOccupancy
		BigDecimal Uiwatergenoccupancy = new BigDecimal(UiwatergenOccu)
		Uiwatergenoccupancy = Uiwatergenoccupancy.setScale(4,RoundingMode.HALF_UP)

		String Uiwatergenocc = Uiwatergenoccupancy.toString()
		String UIannualcarbonemissionsMTCO2eperOcc = WebUI.getText(findTestObject('Analytics/Cal/WODailycarbon'))

		/****************UI Verses Calculated Value daily water per Occupancy*****************************/
		WebUI.verifyMatch(UIannualcarbonemissionsMTCO2eperOcc, Uiwatergenocc, false)
	}


	@Keyword
	public void averagedailywastegeneratedProject(String sheetName ,int rowNum) {
		String totalUnitlbs = data.getCellData(sheetName,"GWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double avgdaily = dtotalUnitlbs/dnoOfDays

		BigDecimal avgdailywaste = new BigDecimal(avgdaily)
		avgdailywaste = avgdailywaste = avgdailywaste.setScale(4,RoundingMode.HALF_UP)

		String avgdailywasteGenerated = avgdailywaste.toString()

		String UIavgdailywasteGenerated = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgDailyGenProj'))

		/****************UI Verses Calculated Value of annual waste generated Per project in LBS *****************************/
		WebUI.verifyMatch(UIavgdailywasteGenerated, avgdailywasteGenerated, false)
	}

	@Keyword
	public void averagedailywastegeneratedSqFeet(String sheetName ,int rowNum) {

		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		Double dgrossAreasqft =  Double.parseDouble(grossAreasqft)

		/*	String UIwastegenSqFeet = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgDailyGenProj'))
		 Double dUIwastegenSqFeet =  Double.parseDouble(UIwastegenSqFeet)
		 */
		String totalUnitlbs = data.getCellData(sheetName,"GWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double dUIwastegenSqFeet = dtotalUnitlbs/dnoOfDays

		String Annualwastegen = dUIwastegenSqFeet/dgrossAreasqft

		BigDecimal AnnualwasteGen = new BigDecimal(Annualwastegen)
		AnnualwasteGen = AnnualwasteGen.setScale(4,RoundingMode.HALF_UP)

		String cAnnualwasteGen = AnnualwasteGen.toString()

		String UIcarbonemissionsMTCO2epersqft = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgWasteGenSqFeet'))
		/****************UI Verses Calculated Value of waste generation per square feet*****************************/
		WebUI.verifyMatch(UIcarbonemissionsMTCO2epersqft, cAnnualwasteGen, false)
	}

	@Keyword
	public void averagedailywastegeneratedOccupancy(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",rowNum)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		/*	String UIwastegenOccupancy = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgDailyGenProj'))
		 Double UiwastegenOccupancy =  Double.parseDouble(UIwastegenOccupancy)
		 */

		String totalUnitlbs = data.getCellData(sheetName,"GWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double UiwastegenOccupancy = dtotalUnitlbs/dnoOfDays

		String UiwastegenOccu= UiwastegenOccupancy/dBOccupancy
		BigDecimal Uiwastegenoccupancy = new BigDecimal(UiwastegenOccu)
		Uiwastegenoccupancy = Uiwastegenoccupancy.setScale(4,RoundingMode.HALF_UP)

		String UiWastegenoccupancy = Uiwastegenoccupancy.toString()
		String UIannualcarbonemissionsMTCO2eperOcc = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgWasteGenOccupancy'))

		/****************UI Verses Calculated Value waste genration per Occupancy*****************************/
		WebUI.verifyMatch(UIannualcarbonemissionsMTCO2eperOcc, UiWastegenoccupancy, false)
	}
	@Keyword
	public void averagedailywastedivProject(String sheetName ,int rowNum) {
		String totalUnitlbs = data.getCellData(sheetName,"DWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double avgdaily = dtotalUnitlbs/dnoOfDays

		BigDecimal avgdailywaste = new BigDecimal(avgdaily)
		avgdailywaste = avgdailywaste.setScale(4,RoundingMode.HALF_UP)

		String avgdailywastediv = avgdailywaste.toString()

		String UIavgdailywastediv = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgWasteDivProj'))

		/****************UI Verses Calculated Value of annual waste diverted Per project in LBS *****************************/
		WebUI.verifyMatch(UIavgdailywastediv, avgdailywastediv, false)
	}

	@Keyword
	public void averagedailywastedivSqFeet(String sheetName ,int rowNum) {

		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		Double dgrossAreasqft =  Double.parseDouble(grossAreasqft)
		String totalUnitlbs = data.getCellData(sheetName,"DWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double dUIwastedivSqFeet = dtotalUnitlbs/dnoOfDays


		/*String UIwastedivSqFeet = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgWasteDivProj'))
		 Double dUIwastedivSqFeet =  Double.parseDouble(UIwastedivSqFeet)
		 */
		double Annualwastediv = dUIwastedivSqFeet/dgrossAreasqft

		BigDecimal AnnualWastediv = new BigDecimal(Annualwastediv)
		AnnualWastediv = AnnualWastediv.setScale(4,RoundingMode.HALF_UP)

		String cAnnualWastediv = AnnualWastediv.toString()

		String UIwasteDIv = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgDailyDivPerSqFeet'))
		/****************UI Verses Calculated Value of waste diverted per square feet*****************************/
		WebUI.verifyMatch(UIwasteDIv, cAnnualWastediv, false)
	}

	@Keyword
	public void averagedailywastedivOccupancy(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",rowNum)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)
		String grossAreasqft = data.getCellData(sheetName,"GrossAreasqft",rowNum)
		Double dgrossAreasqft =  Double.parseDouble(grossAreasqft)
		String totalUnitlbs = data.getCellData(sheetName,"DWasteReading",rowNum)
		String noOfDays = data.getCellData(sheetName,"WasteNoOfDays",rowNum)

		Double dnoOfDays =  Double.parseDouble(noOfDays)
		Double dtotalUnitlbs =  Double.parseDouble(totalUnitlbs)

		double UiwastegenOccupancy = dtotalUnitlbs/dnoOfDays

		/*
		 String UIwastegenOccupancy = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgWasteDivProj'))
		 Double UiwastegenOccupancy =  Double.parseDouble(UIwastegenOccupancy)
		 */
		double UiwastegenOccu= UiwastegenOccupancy/dBOccupancy
		BigDecimal Uiwastegenoccupancy = new BigDecimal(UiwastegenOccu)
		Uiwastegenoccupancy = Uiwastegenoccupancy.setScale(4,RoundingMode.HALF_UP)

		String cUiWastedivoccupancy = Uiwastegenoccupancy.toString()
		String UIWastedivoccupancy = WebUI.getText(findTestObject('Analytics/TotalCarbon/AvgDailyDivPerOccupancy'))

		/****************UI Verses Calculated Value waste diverted per Occupancy*****************************/
		WebUI.verifyMatch(UIWastedivoccupancy, cUiWastedivoccupancy, false)
	}
	@Keyword
	public void transDailycarbonemissionsproject(String sheetName ,int rowNum) {
		String walk1 = data.getCellData(sheetName, "Walk", rowNum)
		double dwalk = Double.parseDouble(walk1)
		double cwalk = dwalk * 0.0

		String bus1 = data.getCellData(sheetName, "Bus", rowNum)
		double bus2 = Double.parseDouble(bus1)
		double cbus = bus2 * 0.68

		String tram1 = data.getCellData(sheetName, "Tram", rowNum)
		double tram2 = Double.parseDouble(tram1)
		double clight_rail = tram2 * 0.44

		String heavyrail1 = data.getCellData(sheetName, "Heavyrail", rowNum)
		double heavyrail2 = Double.parseDouble(heavyrail1)
		double cheavy_rail =  heavyrail2 * 0.33

		String motorcycle1 = data.getCellData(sheetName, "Motorcycle", rowNum)
		double motorcycle2 = Double.parseDouble(motorcycle1)
		double cmotorcycle =  motorcycle2 * 0.26

		String carsolo1 = data.getCellData(sheetName, "Carsolo", rowNum)
		double carsolo2 = Double.parseDouble(carsolo1)
		double ccar = carsolo2 * 0.93

		String Carpool1 = data.getCellData(sheetName, "Carpool", rowNum)
		double Carpool2 = Double.parseDouble(Carpool1)
		double ccar23 = Carpool2 * 0.39

		String Caralternative1 = data.getCellData(sheetName, "Caralternative", rowNum)
		double Caralternative2 = Double.parseDouble(Caralternative1)
		double ccars4 = Caralternative2 * 0.44

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",2)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		double totalTransportCarobn = cwalk + cbus + clight_rail + cheavy_rail + cmotorcycle + ccar + ccar23 + ccars4

		double  Avg_route = totalTransportCarobn/4

		double  Avg_carbon_emission = Avg_route * 0.00045359237

		double daily_carbon_emission = Avg_carbon_emission * 2 * dBOccupancy

		double annual_carbon_emissionin = daily_carbon_emission * 313

		double annual_daily_carbon_emissionin_lbs = daily_carbon_emission / 0.00045359237

		String annual_Dailycarbon_Emissionin_Lbs = annual_daily_carbon_emissionin_lbs.toString()
		BigDecimal daily_carbon_emissionin_lbs = new BigDecimal(annual_Dailycarbon_Emissionin_Lbs)
		daily_carbon_emissionin_lbs = daily_carbon_emissionin_lbs.setScale(4,RoundingMode.HALF_UP)

		String daily_carbon_Emissionin_lbs = daily_carbon_emissionin_lbs.toString()

		String UIdaily_carbon_Emissionin_lbs = WebUI.getText(findTestObject('Analytics/Transport/DaliyProj'))
		String UIdaily_carbon_Emissionin_Lbs =  UIdaily_carbon_Emissionin_lbs.replace(',', '')

		WebUI.verifyMatch(UIdaily_carbon_Emissionin_Lbs, daily_carbon_Emissionin_lbs, false)
	}

	@Keyword
	public void transAnnualcarbonemissionsproject(String sheetName ,int rowNum) {

		String walk1 = data.getCellData(sheetName, "Walk", rowNum)
		double dwalk = Double.parseDouble(walk1)
		double cwalk = dwalk * 0.0

		String bus1 = data.getCellData(sheetName, "Bus", rowNum)
		double bus2 = Double.parseDouble(bus1)
		double cbus = bus2 * 0.68

		String tram1 = data.getCellData(sheetName, "Tram", rowNum)
		double tram2 = Double.parseDouble(tram1)
		double clight_rail = tram2 * 0.44

		String heavyrail1 = data.getCellData(sheetName, "Heavyrail", rowNum)
		double heavyrail2 = Double.parseDouble(heavyrail1)
		double cheavy_rail =  heavyrail2 * 0.33

		String motorcycle1 = data.getCellData(sheetName, "Motorcycle", rowNum)
		double motorcycle2 = Double.parseDouble(motorcycle1)
		double cmotorcycle =  motorcycle2 * 0.26

		String carsolo1 = data.getCellData(sheetName, "Carsolo", rowNum)
		double carsolo2 = Double.parseDouble(carsolo1)
		double ccar = carsolo2 * 0.93

		String Carpool1 = data.getCellData(sheetName, "Carpool", rowNum)
		double Carpool2 = Double.parseDouble(Carpool1)
		double ccar23 = Carpool2 * 0.39

		String Caralternative1 = data.getCellData(sheetName, "Caralternative", rowNum)
		double Caralternative2 = Double.parseDouble(Caralternative1)
		double ccars4 = Caralternative2 * 0.44

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",2)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		double totalTransportCarobn = cwalk + cbus + clight_rail + cheavy_rail + cmotorcycle + ccar + ccar23 + ccars4

		double  Avg_route = totalTransportCarobn / 4
		println Avg_route

		double  Avg_carbon_emission = Avg_route * 0.00045359237
		println Avg_carbon_emission

		double daily_carbon_emission = Avg_carbon_emission * 2 * dBOccupancy
		println daily_carbon_emission

		double annual_carbon_emissionin = daily_carbon_emission * 313
		println annual_carbon_emissionin

		//double annual_daily_carbon_emissionin_lbs = daily_carbon_emission / 0.00045359237

		double annual_annual_carbon_emissionin_lbs = annual_carbon_emissionin / 0.00045359237
		println annual_annual_carbon_emissionin_lbs

		BigDecimal annual_carbon_Emissionin_lbs = new BigDecimal(annual_annual_carbon_emissionin_lbs)
		annual_carbon_Emissionin_lbs = annual_carbon_Emissionin_lbs.setScale(4,RoundingMode.HALF_UP )

		String annual_carbon_Emissionin_Lbs = annual_carbon_Emissionin_lbs.toString()


		String UIannual_carbon_Emissionin_lbs = WebUI.getText(findTestObject('Analytics/Transport/AProj'))
		String UIannual_Annualcarbon_Emissionin_lbs =  UIannual_carbon_Emissionin_lbs.replace(',', '')


		WebUI.verifyMatch(UIannual_Annualcarbon_Emissionin_lbs, annual_carbon_Emissionin_Lbs, false)
	}

	@Keyword
	public void dailyCarbonwtransportOccupancy(String sheetName ,int rowNum) {

		String BOccupancy = data.getCellData(sheetName,"BOccupancy",2)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		String walk1 = data.getCellData(sheetName, "Walk", rowNum)
		double dwalk = Double.parseDouble(walk1)
		double cwalk = dwalk * 0.0

		String bus1 = data.getCellData(sheetName, "Bus", rowNum)
		double bus2 = Double.parseDouble(bus1)
		double cbus = bus2 * 0.68

		String tram1 = data.getCellData(sheetName, "Tram", rowNum)
		double tram2 = Double.parseDouble(tram1)
		double clight_rail = tram2 * 0.44

		String heavyrail1 = data.getCellData(sheetName, "Heavyrail", rowNum)
		double heavyrail2 = Double.parseDouble(heavyrail1)
		double cheavy_rail =  heavyrail2 * 0.33

		String motorcycle1 = data.getCellData(sheetName, "Motorcycle", rowNum)
		double motorcycle2 = Double.parseDouble(motorcycle1)
		double cmotorcycle =  motorcycle2 * 0.26

		String carsolo1 = data.getCellData(sheetName, "Carsolo", rowNum)
		double carsolo2 = Double.parseDouble(carsolo1)
		double ccar = carsolo2 * 0.93

		String Carpool1 = data.getCellData(sheetName, "Carpool", rowNum)
		double Carpool2 = Double.parseDouble(Carpool1)
		double ccar23 = Carpool2 * 0.39

		String Caralternative1 = data.getCellData(sheetName, "Caralternative", rowNum)
		double Caralternative2 = Double.parseDouble(Caralternative1)
		double ccars4 = Caralternative2 * 0.44

		double totalTransportCarobn = cwalk + cbus + clight_rail + cheavy_rail + cmotorcycle + ccar + ccar23 + ccars4

		double  Avg_route = totalTransportCarobn / 4
		println Avg_route

		double  Avg_carbon_emission = Avg_route * 0.00045359237
		println Avg_carbon_emission

		double daily_carbon_emission = Avg_carbon_emission * 2 * dBOccupancy
		println daily_carbon_emission

		double daily_carbon_emissionin_lbs = daily_carbon_emission / 0.00045359237

		double daily_carbon_emissionin_Lbs= daily_carbon_emissionin_lbs/dBOccupancy
		BigDecimal daily_carbon_emissionin_LbsOcc = new BigDecimal(daily_carbon_emissionin_Lbs)
		daily_carbon_emissionin_LbsOcc = daily_carbon_emissionin_LbsOcc.setScale(4,RoundingMode.HALF_UP)

		String cdaily_carbon_emissionin_LbsOcc = daily_carbon_emissionin_LbsOcc.toString()
		String UIcUitransOccup = WebUI.getText(findTestObject('Analytics/Transport/TRProjOccupancy'))

		/****************UI Verses Calculated Value Daily transport per Occupancy*****************************/
		WebUI.verifyMatch(UIcUitransOccup, cdaily_carbon_emissionin_LbsOcc, false)
	}

	@Keyword
	public void annualCarbonwtransportOccupancy(String sheetName ,int rowNum) {
		String BOccupancy = data.getCellData(sheetName,"BOccupancy",2)
		Double dBOccupancy =  Double.parseDouble(BOccupancy)

		String walk1 = data.getCellData(sheetName, "Walk", rowNum)
		double dwalk = Double.parseDouble(walk1)
		double cwalk = dwalk * 0.0

		String bus1 = data.getCellData(sheetName, "Bus", rowNum)
		double bus2 = Double.parseDouble(bus1)
		double cbus = bus2 * 0.68

		String tram1 = data.getCellData(sheetName, "Tram", rowNum)
		double tram2 = Double.parseDouble(tram1)
		double clight_rail = tram2 * 0.44

		String heavyrail1 = data.getCellData(sheetName, "Heavyrail", rowNum)
		double heavyrail2 = Double.parseDouble(heavyrail1)
		double cheavy_rail =  heavyrail2 * 0.33

		String motorcycle1 = data.getCellData(sheetName, "Motorcycle", rowNum)
		double motorcycle2 = Double.parseDouble(motorcycle1)
		double cmotorcycle =  motorcycle2 * 0.26

		String carsolo1 = data.getCellData(sheetName, "Carsolo", rowNum)
		double carsolo2 = Double.parseDouble(carsolo1)
		double ccar = carsolo2 * 0.93

		String Carpool1 = data.getCellData(sheetName, "Carpool", rowNum)
		double Carpool2 = Double.parseDouble(Carpool1)
		double ccar23 = Carpool2 * 0.39

		String Caralternative1 = data.getCellData(sheetName, "Caralternative", rowNum)
		double Caralternative2 = Double.parseDouble(Caralternative1)
		double ccars4 = Caralternative2 * 0.44

		double totalTransportCarobn = cwalk + cbus + clight_rail + cheavy_rail + cmotorcycle + ccar + ccar23 + ccars4

		double  Avg_route = totalTransportCarobn / 4
		println Avg_route

		double  Avg_carbon_emission = Avg_route * 0.00045359237
		println Avg_carbon_emission

		double daily_carbon_emission = Avg_carbon_emission * 2 * dBOccupancy
		println daily_carbon_emission

		double annual_carbon_emissionin = daily_carbon_emission * 313
		println annual_carbon_emissionin

		double annual_annual_carbon_emissionin_lbs = annual_carbon_emissionin / 0.00045359237

		String annual_annual_carbon_emissionin_lbsOCC= annual_annual_carbon_emissionin_lbs/dBOccupancy

		BigDecimal annual_annual_carbon_emissionin_lbsOCCp = new BigDecimal(annual_annual_carbon_emissionin_lbsOCC)
		annual_annual_carbon_emissionin_lbsOCCp = annual_annual_carbon_emissionin_lbsOCCp.setScale(4,RoundingMode.HALF_UP)

		String cannual_annual_carbon_emissionin_lbsOCCp = annual_annual_carbon_emissionin_lbsOCCp.toString()

		String UIcUitransOccup = WebUI.getText(findTestObject('Analytics/Transport/Aoccupancy'))
		String UIcUitransOccupancy =  UIcUitransOccup.replace(',', '')

		/****************UI Verses Calculated Value Annual transport per Occupancy*****************************/
		WebUI.verifyMatch(UIcUitransOccupancy, cannual_annual_carbon_emissionin_lbsOCCp, false)
	}

	@Keyword
	public void totalannual_carbon_emissions() {

		String  str1=WebUI.getText(findTestObject('Analytics/Cal/CTotal'))
		String mtco2c =  str1.replace(',', '')
		Double CTotal= Double.parseDouble(mtco2c)
		BigDecimal UIAtotalMtco2e = new BigDecimal(CTotal)
		UIAtotalMtco2e = UIAtotalMtco2e .setScale(4, RoundingMode.HALF_UP)
		String cUIAtotalMtco2e = UIAtotalMtco2e.toString()

		String  str2=WebUI.getText(findTestObject('Analytics/Transport/totalDailyAnnualCarbonProj'))
		String annualtrans =  str2.replace(',', '')
		double annualtransport = Double.parseDouble(annualtrans)
		double cannualtransport = annualtransport * 313

		BigDecimal cAnnualtransport = new BigDecimal(cannualtransport)
		cAnnualtransport = cAnnualtransport .setScale(4, RoundingMode.HALF_UP)
		String cAnnualTransport = cAnnualtransport.toString()

		/****************UI Verses Calculated Total annual carbon emissions (MTCO2e): Total daily carbon emissions (MTCO2e) * 313*****************************/
		WebUI.verifyMatch(cUIAtotalMtco2e, cAnnualTransport, false)
	}

	@Keyword
	public void total_daily_carbon_emissions() {

		String totaldalilytransprot = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/totalDailyAnnualCarbonProj'))

		String dtransprot = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/ProjDailyTrasnport'))
		Double dtransprotDaily= Double.parseDouble(dtransprot)

		String scope2Dailay = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/EnergyDailyScope2'))
		Double scope2dailay= Double.parseDouble(scope2Dailay)

		String scope1Dailay = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/EnergyDailyScope1'))
		Double scoped1ailay= Double.parseDouble(scope1Dailay)


		double totaltransprotAnnaual = scoped1ailay + scope2dailay + dtransprotDaily

		BigDecimal totaltransprotannaual = new BigDecimal(totaltransprotAnnaual)
		totaltransprotannaual = totaltransprotannaual .setScale(4, RoundingMode.HALF_UP)
		String ctotaltransprotAnn = totaltransprotannaual.toString()

		/****************UI Verses Calculated Sum of daily scope 1 carbon emissions (MTCO2e), scope 2 carbon emissions (MTCO2e), Transportation carbon emissions (MTCO2e)..************/
		WebUI.verifyMatch(totaldalilytransprot, ctotaltransprotAnn, false)
	}

	@Keyword
	public void annualtransportation_annual_carbon_emissions() {

		String totaldalilytransprot = WebUI.getText(findTestObject('Object Repository/Portfolio/CarbonVal/TotalPortfolio'))

		String dtransprot = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/ProjDailyTrasnport'))
		Double dtransprotDaily= Double.parseDouble(dtransprot)

		String scope2Dailay = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/EnergyDailyScope2'))
		Double scope2dailay= Double.parseDouble(scope2Dailay)

		String scope1Dailay = WebUI.getText(findTestObject('Object Repository/Analytics/Transport/EnergyDailyScope1'))
		Double scoped1ailay= Double.parseDouble(scope1Dailay)

		double totaltransprotAnnaual = (scope2dailay + scoped1ailay ) * 365 + (dtransprotDaily * 313)

		BigDecimal totaltransprotannaual = new BigDecimal(totaltransprotAnnaual)
		totaltransprotannaual = totaltransprotannaual .setScale(4, RoundingMode.HALF_UP)
		String ctotaltransprotAnn = totaltransprotannaual.toString()

		/****************UI Verses Calculated Total daily carbon emissions (MTCO2e): Sum of daily scope 1 carbon emissions (MTCO2e), scope 2 carbon emissions (MTCO2e), Transportation carbon emissions (MTCO2e).************/
		WebUI.verifyMatch(totaldalilytransprot, ctotaltransprotAnn, false)
	}

	@Keyword
	public void transportation_daily_carbon_emissions() {

		String dtransprot = WebUI.getText(findTestObject('Analytics/Cal/CTTransportion'))
		Double dtransprotDaily= Double.parseDouble(dtransprot)

		double totaltransprotdaily = dtransprotDaily / 313

		BigDecimal totaltransprotDaily = new BigDecimal(totaltransprotdaily)
		totaltransprotDaily = totaltransprotDaily .setScale(4, RoundingMode.HALF_UP)
		String ctotaltransprotDaily = totaltransprotDaily.toString()

		/****************UI Verses Calculated Transportation daily carbon emissions (MTCO2e)/ 313*****************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/Transport/ProjDailyTrasnport')), ctotaltransprotDaily, false)
	}
	@Keyword
	public void avgoccupainttest(String sheetName ,int rowNum) {
		String avghumExp = data.getCellData(sheetName, "HumAvgSatisfaction", rowNum)
		Double avghumexp= Double.parseDouble(avghumExp)

		BigDecimal avghumexperiance = new BigDecimal(avghumexp)
		avghumexperiance = avghumexperiance .setScale(4, RoundingMode.HALF_UP)
		String cavghumexperiance = avghumexperiance.toString()

		/****************UI Verses Calculated average occupaint satisfacation *****************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/Nav/AverageOccupaint')), cavghumexperiance, false)
	}
	@Keyword
	public void co2caltest(String sheetName ,int rowNum) {

		String co2humExp = data.getCellData(sheetName, "HumCo2Read", rowNum)
		Double co2HumExp= Double.parseDouble(co2humExp)

		String nofdayco2humExp = data.getCellData(sheetName, "HumNoOfDay", rowNum)
		Double nofdayco2HumExp= Double.parseDouble(nofdayco2humExp)


		double co2HumExpmean = co2HumExp / nofdayco2HumExp

		BigDecimal co2HumExpMean = new BigDecimal(co2HumExpmean)
		co2HumExpMean = co2HumExpMean .setScale(4, RoundingMode.HALF_UP)
		String cco2HumexpMean = co2HumExpMean.toString()

		/****************UI Verses Calculated human exp co2 *****************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/Nav/Co2')), cco2HumexpMean, false)
	}
	@Keyword
	public void totalVolatileOrganicTest(String sheetName ,int rowNum) {

		String tvochumExp = data.getCellData(sheetName, "HumTVOCRead", rowNum)
		Double tvocHumExp= Double.parseDouble(tvochumExp)

		String nofdayhumExp = data.getCellData(sheetName, "HumNoOfDay", rowNum)

		Double nofdayHumExp= Double.parseDouble(nofdayhumExp)
		double HumExpmean = tvocHumExp / nofdayHumExp

		BigDecimal humExpmean = new BigDecimal(HumExpmean)
		humExpmean = humExpmean .setScale(4, RoundingMode.HALF_UP)
		String ctvocHumexpMean = humExpmean.toString()

		/****************UI Verses Calculated human exp TVOC *****************************/
		WebUI.verifyMatch(WebUI.getText(findTestObject('Analytics/Nav/Tvoc')), ctvocHumexpMean, false)

	}
}

