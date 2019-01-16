package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.io.IOException
import java.math.RoundingMode
import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ResuableMethodsPortfolio extends BaseClass {
	WebDriver driver= DriverFactory.getWebDriver()
	SimpleDateFormat formatarDate = new SimpleDateFormat('HHmmss')
	@Keyword
	public void createNewPortfolio( String sheetName,int rowNum) throws IOException, InterruptedException {
		String  organization = data.getCellData(sheetName,"Organization",rowNum)
		String  orgCountry 	= data.getCellData(sheetName, "orgCountry", rowNum)
		String  orgContact 	= data.getCellData(sheetName, "orgContact", rowNum)
		String  location 	= data.getCellData(sheetName, "location", rowNum)
		String  email = data.getCellData(sheetName, "email", rowNum)
		String  desc 	= data.getCellData(sheetName,"portfolioDesc", rowNum)
		data.setCellData(sheetName,"ProjectName",rowNum, "Building Portfolio" +" " +formatarDate.format(date))
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum)
		WebUI.scrollToElement(findTestObject('Portfolio/Common/button_ Create a Portfolio'), 4)
		WebUI.click(findTestObject('Portfolio/Common/button_ Create a Portfolio'))
		WebUI.delay(4)
		WebUI.setText(findTestObject('Portfolio/Common/input_name'), prjName)
		WebUI.setText(findTestObject('Portfolio/Common/input_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Common/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/span_Z Park'))
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Common/OwnerOrg'), orgCountry,false)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_organization_c'), orgContact)
		WebUI.setText(findTestObject('Portfolio/Common/input_location'),location)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_email'),email)
		WebUI.setText(findTestObject('Portfolio/Common/textarea_Description'), desc)
		WebUI.click(findTestObject('Portfolio/Common/button_Create'))
		WebUI.delay(7)
		WebUI.click(findTestObject('Portfolio/Common/button_Done'))
		WebUI.delay(5)
		String started = WebUI.getText(findTestObject('Portfolio/Common/p_Get Started'))
		WebUI.verifyMatch(started,"Get Started!", true)
	}
	@Keyword
	public void createNewPortfolioMantory( String sheetName,int rowNum) throws IOException, InterruptedException {
		String  organization = data.getCellData(sheetName,"Organization",rowNum)
		String  orgCountry 	= data.getCellData(sheetName, "orgCountry", rowNum)
		String  orgContact 	= data.getCellData(sheetName, "orgContact", rowNum)
		String  location 	= data.getCellData(sheetName, "location", rowNum)
		String  email = data.getCellData(sheetName, "email", rowNum)
		String  desc 	= data.getCellData(sheetName,"portfolioDesc", rowNum)

		WebUI.scrollToElement(findTestObject('Portfolio/Common/button_ Create a Portfolio'), 4)
		WebUI.click(findTestObject('Portfolio/Common/button_ Create a Portfolio'))
		WebUI.delay(4)
		WebUI.setText(findTestObject('Portfolio/Common/input_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Common/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/span_Z Park'))
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Common/OwnerOrg'), orgCountry,false)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_organization_c'), orgContact)
		WebUI.setText(findTestObject('Portfolio/Common/input_location'),location)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_email'),email)
		WebUI.setText(findTestObject('Portfolio/Common/textarea_Description'), desc)
		WebUI.click(findTestObject('Portfolio/Common/button_Create'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Portfolio/Project/span_ProjectName'), 5)
	}

	@Keyword
	public void createNewPortfolioSpecial(String sheetName,int rowNum) throws IOException, InterruptedException {
		String  projName =  data.getCellData(sheetName,"ProjectName", rowNum)
		String  organization = data.getCellData(sheetName,"Organization",rowNum)
		String  orgCountry 	= data.getCellData(sheetName, "orgCountry", rowNum)
		String  orgContact 	= data.getCellData(sheetName, "orgContact", rowNum)
		String  location 	= data.getCellData(sheetName, "location", rowNum)
		String  email = data.getCellData(sheetName, "email", rowNum)
		String  desc 	= data.getCellData(sheetName,"portfolioDesc", rowNum)

		WebUI.scrollToElement(findTestObject('Portfolio/Common/button_ Create a Portfolio'), 4)
		WebUI.click(findTestObject('Portfolio/Common/button_ Create a Portfolio'))
		WebUI.delay(4)

		WebUI.setText(findTestObject('Portfolio/Common/input_name'), projName)
		WebUI.setText(findTestObject('Portfolio/Common/input_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Common/input_organization'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/span_Z Park'))
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Common/OwnerOrg'), orgCountry,false)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_organization_c'), orgContact)
		WebUI.setText(findTestObject('Portfolio/Common/input_location'),location)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_email'),email)
		WebUI.setText(findTestObject('Portfolio/Common/textarea_Description'), desc)
		WebUI.click(findTestObject('Portfolio/Common/button_Create'))
		WebUI.delay(7)

		String errorMessage = WebUI.getText(findTestObject('Portfolio/Goal/Validation'))
		WebUI.verifyMatch(errorMessage,"Allowed special characters are & + / : ' , - . #", false)
	}


	@Keyword
	public void AddProjectInPortfolio(String sheetName , int rowNum) throws IOException, InterruptedException {
		String prjName 	= data.getCellData(sheetName,"ProjectName", rowNum)
		/**** Adding 5-Projects in Portfolio ****/
		for(int col=2;col<=7;col++ ) {
			String projectId 	= data.getCellData(sheetName,"ID", col)
			String portfolioName 	= data.getCellData(sheetName, "ProjectName", rowNum)
			WebUI.scrollToElement(findTestObject('Portfolio/Common/span_Add a Project'), 4)
			WebUI.click(findTestObject('Portfolio/Common/span_Add a Project'))
			WebUI.delay(3)
			WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPort'), projectId)
			WebUI.click(findTestObject('Portfolio/Common/input_searchBarPort'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Portfolio/Common/SelectProjectInPortfolio'))
			WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPortfolio'),portfolioName)
			WebUI.click(findTestObject('Portfolio/Common/input_searchBarPortfolio'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Portfolio/Common/SelectPortfolio'))
			WebUI.click(findTestObject('Portfolio/Common/button_Add'))
			WebUI.delay(8)
			WebUI.waitForElementVisible(findTestObject('Portfolio/Common/button_Done'),6)
			WebUI.click(findTestObject('Portfolio/Common/button_Done'))
			WebUI.delay(8)
			String verifyPortfioio =WebUI.getText(findTestObject('Portfolio/Common/ProjectName'))
			WebUI.verifyMatch(verifyPortfioio,portfolioName,false)
		}
		println  "5 Projects Successfully added inside portfolio"
	}

	@Keyword
	public void addProjectDVProtfolio(String sheetName, int rowNum) throws IOException, InterruptedException {
		/**********Verifying the Project Area, Total Occupancy *************/

		String projectArea 	        = data.getCellData(sheetName, "Area", 9 )
		String projectOccupancy 	= data.getCellData(sheetName, "occupancy", 8)
		String certifiedArea 	= data.getCellData(sheetName, "Area", 10)
		String AnnualCarbonEmissions = data.getCellData(sheetName,'carbonEmission', 10)

		WebUI.delay(2)

		String totalGrossArea = WebUI.getText(findTestObject('Portfolio/Common/TotalGrossArea'))
		WebUI.verifyMatch(projectArea,totalGrossArea,false)
		println  "Total Gross Floor Area verified Successfully"

		String ProjectOccupancy = WebUI.getText(findTestObject('Portfolio/Common/TotalOccupant'))
		WebUI.verifyMatch(projectOccupancy,ProjectOccupancy,true,FailureHandling.CONTINUE_ON_FAILURE)
		println  "Total Gross Floor Area verified Successfully"

		String  CertifiedArea = WebUI.getText(findTestObject('Portfolio/Common/TotalCertifiedArea'))
		WebUI.verifyMatch(certifiedArea,CertifiedArea,true,FailureHandling.CONTINUE_ON_FAILURE)
		System.out.println(certifiedArea)

		String TotalOccupant = WebUI.getText(findTestObject('Portfolio/Common/TotalOccupant'))
		WebUI.verifyMatch(projectOccupancy,TotalOccupant,true,FailureHandling.CONTINUE_ON_FAILURE)

		String taddedProject = WebUI.getText(findTestObject('Portfolio/Common/TotalProject'))
		WebUI.verifyMatch(taddedProject,"6",true,FailureHandling.CONTINUE_ON_FAILURE)

		String carbonEmession = WebUI.getText(findTestObject('Portfolio/CarbonVal/ProjectFil/AnnaualEmession'))
		WebUI.verifyMatch(carbonEmession,AnnualCarbonEmissions,true,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void totalScoreIsDisplay(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/span_Scores'))
		WebUI.delay(5)

		String totalScoreFirstValule = WebUI.getText(findTestObject('Analytics/Score/score1'))
		Integer totalScore1valule=Double.parseDouble(totalScoreFirstValule)
		String totalScore2Valule = WebUI.getText(findTestObject('Analytics/Score/score2'))
		Integer totalScore2valule= Double.parseDouble(totalScore2Valule)
		String totalScore3Valule = WebUI.getText(findTestObject('Analytics/Score/score3'))
		Integer totalScore3valule=Double.parseDouble(totalScore3Valule)
		String totalScore4Valule = WebUI.getText(findTestObject('Analytics/Score/score4'))
		Integer totalScore4valule=Double.parseDouble(totalScore4Valule)
		String totalScore5Valule = WebUI.getText(findTestObject('Analytics/Score/score5'))
		Integer totalScore5valule= Double.parseDouble(totalScore5Valule)
		String totalScore6Valule = WebUI.getText(findTestObject('Analytics/Score/score6'))
		Integer totalScore6valule= Double.parseDouble(totalScore6Valule)

		double totalScoreaverage = (totalScore1valule + totalScore2valule + totalScore3valule + totalScore4valule + totalScore5valule + totalScore6valule) / 6

		int totalScoreAverage = Math.round(totalScoreaverage)
		String totalScoreAvg = totalScoreAverage.toString()
		data.setCellData(sheetName,"totalScore",11,totalScoreAvg)

		println totalScoreaverage
		ArrayList<Integer> totalScore = new ArrayList<Integer>()
		totalScore.add(totalScore1valule)
		totalScore.add(totalScore2valule)
		totalScore.add(totalScore3valule)
		totalScore.add(totalScore4valule)
		totalScore.add(totalScore5valule)
		totalScore.add(totalScore6valule)

		Collections.sort(totalScore)
		println totalScore
		Collections.reverse(totalScore)
		println totalScore

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(totalScore.get(i))
				String highest = totalScore.get(i)
				data.setCellData(sheetName,"totalScore",2,highest)
			}
			if(i==1){
				System.out.println(totalScore.get(i))
				String highest2 = totalScore.get(i)
				data.setCellData(sheetName,"totalScore", 3, highest2)
			}
			if(i==2){
				System.out.println(totalScore.get(i))
				String highest3 = totalScore.get(i)
				data.setCellData(sheetName,"totalScore",4, highest3)
			}
			if(i==3){
				System.out.println(totalScore.get(i))
				String highest4 = totalScore.get(i)
				data.setCellData(sheetName,"totalScore",5, highest4)
			}
			if(i==4){
				System.out.println(totalScore.get(i))
				String highest5 = totalScore.get(i)
				data.setCellData(sheetName,"totalScore",6, highest5)
			}
			if(i==5){
				System.out.println(totalScore.get(i))
				String highest6 = totalScore.get(i)
				data.setCellData(sheetName,"totalScore",7, highest6)
			}
		}
	}

	@Keyword
	public void portfolioTScorePDetailsVerifcation(String sheetName, int rowNum) throws IOException, InterruptedException {
		for(int count =1;count<=6;count++) {
			if(count==1) {
				int row =2
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==2) {
				int row =3
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==3) {
				int row = 4
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==4) {
				int row =5
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==5) {
				int row =6
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==6) {
				int row =7
				String totalScore = data.getCellData(sheetName, "totalScore", row)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
		}
	}

	@Keyword
	public void analyticsEnergyScore(String sheetName, int rowNum ) throws IOException, InterruptedException {

		String highScore  = data.getCellData(sheetName, "energyScore", 2)
		String averageScore =data.getCellData(sheetName, "energyScore",11)
		String lowestScore  =data.getCellData(sheetName, "energyScore", 7)

		/*		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Portfolio/Common/a_ Energy'))
		 WebUI.delay(5)
		 */
		println highScore
		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/EHighestScore'))
		println highestScorePoint

		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Energy verified Successfully"


		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/EAverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Energy verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/ELowestScore'))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Energy verified Successfully"
	}
	@Keyword
	public void energyFilter(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Filtering top 5 PProject  score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)


		String prjScore1   =data.getCellData(sheetName, "energyScore", 2)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for Energy top 5 score below details are verified Successfully" +  prjScore1


		String prjScore2   =data.getCellData(sheetName, "energyScore", 3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for Energy top 5 score below details are verified Successfully"  +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "energyScore", 4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for Energy top 5 score below details are verified Successfully" +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "energyScore", 5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for Energy top 5 score below details are verified Successfully" +  prjScore4


		String prjScore5   =data.getCellData(sheetName, "energyScore", 6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for Energy top 5 score below details are verified Successfully" +  prjScore5
	}

	@Keyword
	public void analyticsTotalScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "totalScore", 2)
		String averageScore =data.getCellData(sheetName, "totalScore", 11)
		String lowestScore  =data.getCellData(sheetName, "totalScore", 7)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Total/HighestScore '))
		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Total/AverageScore'))
		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Total/LowestScore '))

		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Tota Highest score  verified Successfully"

		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Tota Average score verified Successfully"

		WebUI.verifyMatch(lowScorePoint,lowestScore,false)
		println "Total Lowest score verified Successfully"
	}

	@Keyword
	public void analyticsCarbonScore(String sheetName, int rowNum ) throws IOException, InterruptedException {

		String highScore    = data.getCellData(sheetName, "carbonEmission", 2)
		String averageScore =data.getCellData(sheetName, "carbonEmission", 11)
		String lowestScore  =data.getCellData(sheetName, "carbonEmission",7)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CaronHighest'))
		double highestScorePoint1 = Double.parseDouble(highestScorePoint)
		BigDecimal highestScorepoint = new BigDecimal(highestScorePoint1)
		highestScorepoint =  highestScorepoint.setScale(1, RoundingMode.HALF_UP)
		String highestscorepoint = highestScorepoint.toString()
		WebUI.verifyMatch(highestscorepoint,highScore,false)

		println "Highest score for carbon  verified Successfully"
		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CarbonAvg'))
		double avgScorePoint1 = Double.parseDouble(avgScorePoint)
		BigDecimal avgScorePoint2 = new BigDecimal(avgScorePoint1)
		avgScorePoint2 =  avgScorePoint2 .setScale(1, RoundingMode.HALF_UP)
		String avgScorepoint = avgScorePoint2.toString()
		WebUI.verifyMatch(avgScorepoint,averageScore,false)

		println "Average score for carbon verified Successfully"
		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CarbonLow'))
		double lowScorePoint1 = Double.parseDouble(lowScorePoint)
		BigDecimal lowScorePoint2 = new BigDecimal(lowScorePoint1)
		lowScorePoint2 =  lowScorePoint2 .setScale(1, RoundingMode.HALF_UP)
		String lowScorepoint = lowScorePoint2.toString()
		WebUI.verifyMatch(lowScorepoint,lowestScore,false)
		println "Lowest score for carbon verified Successfully"
	}
	@Keyword
	public void analyticsCarbonFilter(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Verifying  5 lowest performer for the carbon "
		WebUI.scrollToElement(findTestObject('Portfolio/Common/span_Lowest 5 Performers'), rowNum)
		WebUI.delay(5)

		/*  WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		 WebUI.delay(5)*/

		String prjScore1   = data.getCellData(sheetName, "carbonEmission", 2)
		String uiScore1 =  WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1'))
		double dcprjScore1 = Double.parseDouble(uiScore1)
		BigDecimal bcprjScore1 = new BigDecimal(dcprjScore1)
		bcprjScore1 =  bcprjScore1 .setScale(1, RoundingMode.HALF_UP)

		String acprjScore1 = dcprjScore1.toString()
		WebUI.verifyMatch(acprjScore1, prjScore1, false)
		println "Filter for First carbon top verified Successfully" +  prjScore1

		String prjScore2   =data.getCellData(sheetName, "carbonEmission", 3)
		String uiScore2 =  WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2'))
		double dcprjScore2 = Double.parseDouble(uiScore2)
		BigDecimal bcprjScore2 = new BigDecimal(dcprjScore2)
		bcprjScore2 =  bcprjScore2.setScale(1, RoundingMode.HALF_UP)
		String acprjScore2= dcprjScore2.toString()
		WebUI.verifyMatch(acprjScore2, prjScore2, false)

		println "Filter for  2nd carbon top verified Successfully" +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "carbonEmission", 4)
		String uiScore3 =  WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3'))
		double dcprjScore3 = Double.parseDouble(uiScore3)
		BigDecimal bcprjScore3 = new BigDecimal(dcprjScore3)
		bcprjScore3 =  bcprjScore3.setScale(1, RoundingMode.HALF_UP)
		String acprjScore3= dcprjScore3.toString()
		WebUI.verifyMatch(acprjScore3, prjScore3, false)
		println "Filter for 3rd carbon top  verified Successfully" +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "carbonEmission", 5)
		String uiScore4 =  WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4'))
		double dcprjScore4 = Double.parseDouble(uiScore4)
		BigDecimal bcprjScore4 = new BigDecimal(dcprjScore4)
		bcprjScore4 =  bcprjScore4.setScale(1, RoundingMode.HALF_UP)
		String acprjScore4= dcprjScore4.toString()
		WebUI.verifyMatch(acprjScore4, prjScore4, false)
		println "Filter for carbon 4th  score verified Successfully" +  prjScore4

		String prjScore5   =data.getCellData(sheetName, "carbonEmission", 6)
		String uiScore5 =  WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5'))
		double dcprjScore5 = Double.parseDouble(uiScore5)
		BigDecimal bcprjScore5 = new BigDecimal(dcprjScore5)
		bcprjScore5 =  bcprjScore5.setScale(1, RoundingMode.HALF_UP)
		String acprjScore5= dcprjScore5.toString()
		WebUI.verifyMatch(acprjScore5, prjScore5, false)
		println "Filter for carbon 5th score  verified Successfully" +  prjScore5
	}


	@Keyword
	public void analyticsWaterScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "waterScore", 2)
		String averageScore =data.getCellData(sheetName, "waterScore", 11)
		String lowestScore  =data.getCellData(sheetName, "waterScore", 7)

		/*	WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Portfolio/Common/a_ Water'))
		 WebUI.delay(5)*/

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WHighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Energy verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WAverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Energy verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WLowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Energy verified Successfully"
	}

	@Keyword
	public void analyticsWaterScoreFilter(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Filering top 5 PProjectName , project id , city , score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjScore1   =data.getCellData(sheetName, "waterScore",2)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for water top Ist proj score is verified Successfully" +  prjScore1

		String prjScore2   =data.getCellData(sheetName, "waterScore", 3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for water top 2nd proj score is verified Successfully" +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "waterScore", 4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for water top 3rd proj score is verified Successfully"  +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "waterScore", 5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for water top 4th proj score is verified Successfully"  +  prjScore4

		String prjScore5   =data.getCellData(sheetName, "waterScore", 6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for water top 5th proj score is verified Successfully" +  prjScore5
	}


	@Keyword
	public void analyticsWasteScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "wasteScore", 2)
		String averageScore =data.getCellData(sheetName, "wasteScore", 11)
		String lowestScore  =data.getCellData(sheetName, "wasteScore", 7)

		/*	WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		 WebUI.delay(5)*/

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Waste verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Waste verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Waste verified Successfully"
	}
	@Keyword
	public void analyticsWasteFilterScore(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Verifying top 5 performers for waste score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjScore1   =data.getCellData(sheetName, "wasteScore", 2)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for waste Ist Proj top score verified Successfully" +  prjScore1

		String prjScore2   =data.getCellData(sheetName, "wasteScore", 3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for waste 2nd Proj top score verified Successfully" +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "wasteScore", 4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for waste 3rd Proj top score verified Successfully" +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "wasteScore", 5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for waste 4th Proj top score verified Successfully" +  prjScore4

		String prjScore5   =data.getCellData(sheetName, "wasteScore", 6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for waste 5th Proj top score verified Successfully"  +  prjScore5
	}

	@Keyword
	public void analyticsTransportScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "transportation", 2)
		String averageScore =data.getCellData(sheetName, "transportation", 11)
		String lowestScore  =data.getCellData(sheetName, "transportation", 7)

		/*WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Portfolio/Common/a_ Transportation'))
		 WebUI.delay(5)
		 */
		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Transportation verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Transportation verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowestScore,false)
		println "Lowest score for Transportation verified Successfully"
	}
	@Keyword
	public void analyticsTransportScorefilter(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Filtering top 5 Project score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjScore1   =data.getCellData(sheetName, "transportation",2)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre1')), prjScore1, false)
		println "Filter for Transportation Ist highest score verified Successfully" +  prjScore1

		String prjScore2   =data.getCellData(sheetName, "transportation", 3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre2')), prjScore2, false)
		println "Filter for Transportation 2nd highest score verified Successfully" +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "transportation", 4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre3')), prjScore3, false)
		println "Filter for Transportation 2rd highest score verified Successfully" +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "transportation", 5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre4')), prjScore4, false)
		println "Filter for Transportation 4th highest score verified Successfully" +  prjScore4

		String prjScore5   =data.getCellData(sheetName, "transportation", 6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre5')), prjScore5, false)
		println "Filter for Transportation 5th highest score verified Successfully" +  prjScore5
	}


	@Keyword
	public void analyticsHExperiaceScore(String sheetName, int rowNum ) throws IOException, InterruptedException {

		String highScore    =data.getCellData(sheetName, "humanExperience", 2)
		String averageScore =data.getCellData(sheetName, "humanExperience", 11)
		String lowestScore  =data.getCellData(sheetName, "humanExperience", 7)

		/*		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		 WebUI.delay(2)
		 WebUI.click(findTestObject('Portfolio/Common/a_ Human Experience'))
		 WebUI.delay(5)*/

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Humam experiace verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Humam experiace verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Humam experiace verified Successfully"
	}
	@Keyword
	public void analyticsHExperiaceScoreFilter(String sheetName, int rowNum ) throws IOException, InterruptedException {

		println "Filering top 5 project score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)
		String prjScore1   =data.getCellData(sheetName, "humanExperience", 2)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre1')), prjScore1, false)
		println "Filter Humam experiace top Score Ist project verified Successfully" +  prjScore1

		String prjScore2   =data.getCellData(sheetName, "humanExperience", 3)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre2')), prjScore2, false)
		println "Filter Humam experiace top Score 2nd project verified Successfully" +  prjScore2

		String prjScore3   =data.getCellData(sheetName, "humanExperience", 4)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre3')), prjScore3, false)
		println "Filter Humam experiace top Score 3rd project verified Successfully" +  prjScore3

		String prjScore4   =data.getCellData(sheetName, "humanExperience", 5)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre4')), prjScore4, false)
		println "Filter for Humam experiace  top 5 score below details are verified Successfully" +  prjScore4

		String prjScore5   =data.getCellData(sheetName, "humanExperience", 6)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre5')), prjScore5, false)
		println "Filter for Humam experiace top 5 score below details are verified Successfully" +  prjScore5
	}


	@Keyword
	public void goalCarbon(String sheetName, int rowNum) throws IOException, InterruptedException {
		/****** Methods Verifying the annual carbon emission, goal calculation & validating the text area is saving the text or not after refresh *****/
		String cpReduction = data.getCellData(sheetName, "CPReduction", rowNum)
		String cbValue = data.getCellData(sheetName, "CBValue", rowNum)
		String cUnit = data.getCellData(sheetName, "Cunit", rowNum)
		String ctextbox = data.getCellData(sheetName,"CTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)


		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(5)

		println "Test started verifying carbon unit MTCO2E"
		String mtco2e = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CarbonUnit'))
		System.out.println(mtco2e)
		WebUI.delay(1)
		WebUI.verifyMatch(cUnit, mtco2e, false)
		println "Test passed verified carbon unit  MTCO2E successfully"

		println "Test Started Carbon differece of goal calcation"
		WebUI.clearText(findTestObject('Portfolio/Goal/carbon_percent_reduction'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/carbon_percent_reduction'), cpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Portfolio/Goal/carbon_baseline_value'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/carbon_baseline_value'), cbValue)
		WebUI.click(findTestObject('Portfolio/Goal/CarbonDiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/CarbonDiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(cpReduction)
		double result1 =depReduction-replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/Carbon_base_year'), baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Portfolio/Goal/carbon_target_year'), targetYear, true)

		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Goal/CarbonGoalBar'))
		String greplace = carbonGoal.replace("%" , "")
		double cGexpected=Double.parseDouble(greplace)
		System.out.println(cGexpected)
		double cGactual = depReduction/2
		System.out.println(cGactual)
		Assert.assertEquals(cGactual,cGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.click(findTestObject('Portfolio/Goal/carbon_description_textarea'))
		WebUI.clearText(findTestObject('Portfolio/Goal/carbon_description_textarea'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/carbon_description_textarea'),ctextbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		/*	WebUI.refresh()
		 WebUI.delay(5)
		 println cbValue*/
		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Portfolio/Goal/carbon_baseline_value'),"value").contains(cbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/carbon_percent_reduction'),"value").contains(cpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/carbon_description_textarea'),"value").contains(ctextbox),"Not Valid")
		println "Test passed verified carbon textarea, carbon reducion , base line value after refersh successfully"

	}
	@Keyword
	public void goalEnergy(String sheetName,int rowNum) throws IOException, InterruptedException {

		String epReduction 	= data.getCellData(sheetName, "EPReduction", rowNum)
		String ebValue 	= data.getCellData(sheetName, "EBValue", rowNum)
		String eUnit 	= data.getCellData(sheetName, "Eunit", rowNum)
		String textbox = data.getCellData(sheetName,"ETextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		//WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		//WebUI.delay(5)

		println "Test started verifying energy unit Kbtu"
		String kbtu = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/EnergyUnitkBtu'))
		System.out.println(kbtu)
		WebUI.delay(1)
		WebUI.verifyMatch(kbtu, eUnit, false)
		println "Test passed verified energy unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_percent_reduction'), epReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_baseline_value'), ebValue)

		WebUI.click(findTestObject('Portfolio/Goal/EnergyDiffGoal'))
		WebUI.delay(2)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/EnergyDiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/energy_CurrentProgess'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(epReduction)
		double result1 =depReduction -replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/energy_baseline_year'), baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/energy_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/EnergyGoal'))
		String greplace = energyGoal.replace("%" , "")
		double eGexpected=Double.parseDouble(greplace)
		System.out.println(eGexpected)
		double eGactual = 100/2
		System.out.println(eGactual)
		Assert.assertEquals(eGactual,eGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_baseline_value'),"value").contains(ebValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_percent_reduction'),"value").contains(epReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_description_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified energy textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalWater(String sheetName,int rowNum) throws IOException, InterruptedException {

		String wpReduction = data.getCellData(sheetName, "WPReduction", rowNum)
		String wbValue 	= data.getCellData(sheetName, "WBValue", rowNum)
		String wUnit 	= data.getCellData(sheetName, "Wunit", rowNum)
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying energy unit Gal"
		String gal = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/WaterUnit'))
		System.out.println(gal)
		WebUI.delay(1)
		WebUI.verifyMatch(gal, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/waterDiffGoal'))
		WebUI.delay(4)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/waterDiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/WaterCurrentProgess'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction)
		double result1 =depReduction -replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/water_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/water_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/WaterGoal'))
		String greplace = energyGoal.replace("%" , "")
		double wGexpected=Double.parseDouble(greplace)
		System.out.println(wGexpected)
		double wGactual = depReduction/2
		System.out.println(wGactual)
		Assert.assertEquals(wGactual,wGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/water_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/water_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(4)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified water textarea, energy reducion , base line value after refersh successfully"

	}

	@Keyword
	public void energyScore(String sheetName,int rowNum) throws IOException, InterruptedException {

		String energyFirstValule = WebUI.getText(findTestObject('Portfolio/Score/Energy1'))
		Integer energy1valule=Double.parseDouble(energyFirstValule)
		String energy2Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy2'))
		Integer energy2valule=Double.parseDouble(energy2Valule)
		String energy3Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy3'))
		Integer energy3valule=Double.parseDouble(energy3Valule)
		String energy4Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy4'))
		Integer energy4valule=Double.parseDouble(energy4Valule)
		String energy5Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy5'))
		Integer energy5valule=Double.parseDouble(energy5Valule)
		String energy6Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy6'))
		Integer energy6valule=Double.parseDouble(energy6Valule)

		double energyaverage = (energy1valule + energy2valule + energy3valule + energy4valule + energy5valule + energy6valule) / 6

		int energyAverage = Math.round(energyaverage)
		String energyAvg = energyAverage.toString()
		data.setCellData(sheetName,"energyScore",11,energyAvg)
		println energyaverage

		ArrayList<Integer> energy = new ArrayList<Integer>()
		energy.add(energy1valule)
		energy.add(energy2valule)
		energy.add(energy3valule)
		energy.add(energy4valule)
		energy.add(energy5valule)
		energy.add(energy6valule)

		Collections.sort(energy)
		println energy
		Collections.reverse(energy)
		println energy

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",2,highest)
			}
			if(i==1){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore", 3, highest)
			}
			if(i==2){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",4, highest)
			}
			if(i==3){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",5, highest)
			}
			if(i==4){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",6, highest)
			}
			if(i==5){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				data.setCellData(sheetName,"energyScore",7, highest)
			}
		}
	}

	@Keyword
	public void waterScore(String sheetName,int rowNum) throws IOException, InterruptedException {

		String waterFirstValule = WebUI.getText(findTestObject('Portfolio/Score/Water1'))
		Integer water1valule= Double.parseDouble(waterFirstValule)
		String water2Valule = WebUI.getText(findTestObject('Portfolio/Score/Water2'))
		Integer water2valule=Double.parseDouble(water2Valule)
		String water3Valule = WebUI.getText(findTestObject('Portfolio/Score/Water3'))
		Integer water3valule=Double.parseDouble(water3Valule)
		String water4Valule = WebUI.getText(findTestObject('Portfolio/Score/Water4'))
		Integer water4valule=Double.parseDouble(water4Valule)
		String water5Valule = WebUI.getText(findTestObject('Portfolio/Score/Water5'))
		Integer water5valule=Double.parseDouble(water5Valule)
		String water6Valule = WebUI.getText(findTestObject('Portfolio/Score/Water6'))
		Integer water6valule=Double.parseDouble(water6Valule)

		double wateraverage = (water1valule + water2valule + water3valule + water4valule + water5valule + water6valule) / 6
		int waterAverage = Math.round(wateraverage)
		String waterAvg = waterAverage.toString()
		data.setCellData(sheetName,"waterScore",11,waterAvg)

		println wateraverage
		ArrayList<Integer> water = new ArrayList<Integer>()
		water.add(water1valule)
		water.add(water2valule)
		water.add(water3valule)
		water.add(water4valule)
		water.add(water5valule)
		water.add(water6valule)
		Collections.sort(water)
		println water
		Collections.reverse(water)
		println water

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(water.get(i))
				String highest = water.get(i)
				data.setCellData(sheetName,"waterScore",2,highest)
			}
			if(i==1){
				System.out.println(water.get(i))
				String highest2 = water.get(i)
				data.setCellData(sheetName,"waterScore", 3, highest2)
			}
			if(i==2){
				System.out.println(water.get(i))
				String highest3 = water.get(i)
				data.setCellData(sheetName,"waterScore",4, highest3)
			}
			if(i==3){
				System.out.println(water.get(i))
				String highest4 = water.get(i)
				data.setCellData(sheetName,"waterScore",5, highest4)
			}
			if(i==4){
				System.out.println(water.get(i))
				String highest5 = water.get(i)
				data.setCellData(sheetName,"waterScore",6, highest5)
			}
			if(i==5){
				System.out.println(water.get(i))
				String highest6 = water.get(i)
				data.setCellData(sheetName,"waterScore",7, highest6)
			}
		}
	}
	@Keyword
	public void wasteScore(String sheetName,int rowNum) throws IOException, InterruptedException {

		String wasteFirstValule = WebUI.getText(findTestObject('Portfolio/Score/Waste1'))
		Integer waste1valule=Double.parseDouble(wasteFirstValule)
		String waste2Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste2'))
		Integer waste2valule=Double.parseDouble(waste2Valule)
		String waste3Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste3'))
		Integer waste3valule=Double.parseDouble(waste3Valule)
		String waste4Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste4'))
		Integer waste4valule=Double.parseDouble(waste4Valule)
		String waste5Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste5'))
		Integer waste5valule=Double.parseDouble(waste5Valule)
		String  waste6Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste6'))
		Integer waste6valule=Double.parseDouble(waste6Valule)

		double wasteaverage = (waste1valule + waste2valule + waste3valule + waste4valule + waste5valule + waste6valule) / 6
		int wasteAverage = Math.round(wasteaverage)
		String wasteAvg = wasteAverage.toString()
		data.setCellData(sheetName,"wasteScore",11,wasteAvg)
		println wasteaverage

		ArrayList<Integer> waste = new ArrayList<Integer>()
		waste.add(waste1valule)
		waste.add(waste2valule)
		waste.add(waste3valule)
		waste.add(waste4valule)
		waste.add(waste5valule)
		waste.add(waste6valule)
		Collections.sort(waste)
		println waste
		Collections.reverse(waste)
		println waste

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				data.setCellData(sheetName,"wasteScore",2,highest)
			}
			if(i==1){
				System.out.println(waste.get(i))
				String highest2 = waste.get(i)
				data.setCellData(sheetName,"wasteScore", 3, highest2)
			}
			if(i==2){
				System.out.println(waste.get(i))
				String highest3 = waste.get(i)
				data.setCellData(sheetName,"wasteScore",4, highest3)
			}
			if(i==3){
				System.out.println(waste.get(i))
				String highest4 = waste.get(i)
				data.setCellData(sheetName,"wasteScore",5, highest4)
			}
			if(i==4){
				System.out.println(waste.get(i))
				String highest5 = waste.get(i)
				data.setCellData(sheetName,"wasteScore",6, highest5)
			}
			if(i==5){
				System.out.println(waste.get(i))
				String highest6 = waste.get(i)
				data.setCellData(sheetName,"wasteScore",7, highest6)
			}
		}
	}

	@Keyword
	public void transportScore(String sheetName,int rowNum) throws IOException, InterruptedException {

		String transportationFirstValule = WebUI.getText(findTestObject('Portfolio/Score/Trans1'))
		Integer transportation1valule=Double.parseDouble(transportationFirstValule)
		String transportation2Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans2'))
		Integer transportation2valule= Double.parseDouble(transportation2Valule)
		String transportation3Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans3'))
		Integer transportation3valule=Double.parseDouble(transportation3Valule)
		String transportation4Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans4'))
		Integer transportation4valule=Double.parseDouble(transportation4Valule)
		String transportation5Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans5'))
		Integer transportation5valule= Double.parseDouble(transportation5Valule)

		String transportation6Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans6'))
		Integer transportation6valule= Double.parseDouble(transportation6Valule)


		double transportationaverage = (transportation1valule + transportation2valule + transportation3valule + transportation4valule + transportation5valule + transportation6valule) / 6

		int transportationAverage = Math.round(transportationaverage)
		String transportationAvg = transportationAverage.toString()
		data.setCellData(sheetName,"transportation",11,transportationAvg)
		println transportationaverage

		ArrayList<Integer> transportation = new ArrayList<Integer>()
		transportation.add(transportation1valule)
		transportation.add(transportation2valule)
		transportation.add(transportation3valule)
		transportation.add(transportation4valule)
		transportation.add(transportation5valule)
		transportation.add(transportation6valule)

		Collections.sort(transportation)

		println transportation
		Collections.reverse(transportation)
		println transportation

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				data.setCellData(sheetName,"transportation",2,highest)
			}
			if(i==1){
				System.out.println(transportation.get(i))
				String highest2 = transportation.get(i)
				data.setCellData(sheetName,"transportation", 3, highest2)
			}
			if(i==2){
				System.out.println(transportation.get(i))
				String highest3 = transportation.get(i)
				data.setCellData(sheetName,"transportation",4, highest3)
			}
			if(i==3){
				System.out.println(transportation.get(i))
				String highest4 = transportation.get(i)
				data.setCellData(sheetName,"transportation",5, highest4)
			}
			if(i==4){
				System.out.println(transportation.get(i))
				String highest5 = transportation.get(i)
				data.setCellData(sheetName,"transportation",6, highest5)
			}
			if(i==5){
				System.out.println(transportation.get(i))
				String highest6 = transportation.get(i)
				data.setCellData(sheetName,"transportation",7, highest6)
			}
		}
	}

	@Keyword
	public void humExpScore(String sheetName,int rowNum) throws IOException, InterruptedException {

		String humanExperienceFirstValule = WebUI.getText(findTestObject('Portfolio/Score/Hum1'))
		Integer humanExperience1valule= Double.parseDouble(humanExperienceFirstValule)
		String humanExperience2Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum2'))
		Integer humanExperience2valule=Double.parseDouble(humanExperience2Valule)
		String humanExperience3Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum3'))
		Integer humanExperience3valule=Double.parseDouble(humanExperience3Valule)
		String humanExperience4Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum4'))
		Integer humanExperience4valule=Double.parseDouble(humanExperience4Valule)
		String humanExperience5Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum5'))
		Integer humanExperience5valule=Double.parseDouble(humanExperience5Valule)
		String humanExperience6Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum6'))
		Integer humanExperience6valule=Double.parseDouble(humanExperience6Valule)

		double humanExperienceaverage = (humanExperience1valule + humanExperience2valule + humanExperience3valule + humanExperience4valule + humanExperience5valule + humanExperience6valule ) / 6
		int humanExperienceAverage = Math.round(humanExperienceaverage)
		String humanExperienceAvg = humanExperienceAverage.toString()

		data.setCellData(sheetName,"humanExperience",11,humanExperienceAvg)

		println humanExperienceAverage

		ArrayList<Integer> humanExperience = new ArrayList<Integer>()

		humanExperience.add(humanExperience1valule)
		humanExperience.add(humanExperience2valule)
		humanExperience.add(humanExperience3valule)
		humanExperience.add(humanExperience4valule)
		humanExperience.add(humanExperience5valule)
		humanExperience.add(humanExperience6valule)

		Collections.sort(humanExperience)
		println humanExperience

		Collections.reverse(humanExperience)
		println humanExperience

		for(int i = 0; i<=5; i++) {
			if(i==0){
				System.out.println(humanExperience.get(i))
				String highest = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience",2,highest)
			}
			if(i==1){
				System.out.println(humanExperience.get(i))
				String highest2 = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience", 3,highest2)
			}
			if(i==2){
				System.out.println(humanExperience.get(i))
				String highest3 = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience",4, highest3)
			}
			if(i==3){
				System.out.println(humanExperience.get(i))
				String highest4 = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience",5, highest4)
			}
			if(i==4){
				System.out.println(humanExperience.get(i))
				String highest5 = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience",6, highest5)
			}
			if(i==5){
				System.out.println(humanExperience.get(i))
				String highest6 = humanExperience.get(i)
				data.setCellData(sheetName,"humanExperience",7, highest6)
			}
		}
	}
	@Keyword
	public void goalGeneratedWaste(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/	

		String wpReduction = data.getCellData(sheetName, "WastePReduction", rowNum)
		String wbValue = data.getCellData(sheetName, "WasteBValue", rowNum)
		String wUnit = data.getCellData(sheetName, "Wasteunit", rowNum)
		String wtextbox = data.getCellData(sheetName,"WasteTextBox", rowNum)
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying energy unit lbs"
		String lbs = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_Unit'))
		System.out.println(lbs)
		WebUI.delay(1)
		WebUI.verifyMatch(lbs, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_percent_reduction'))
		println wpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/generated_waste_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/generated_waste_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/generated_waste_DiffGoal'))
		WebUI.delay(4)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_DiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_currentProgress'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction)
		double result1 =depReduction -replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/generated_waste_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/generated_waste_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_Goal'))
		String greplace = energyGoal.replace("%" , "")
		double wGexpected=Double.parseDouble(greplace)
		System.out.println(wGexpected)
		double wGactual = depReduction/2
		System.out.println(wGactual)
		Assert.assertEquals(wGactual,wGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/generated_waste_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/generated_waste_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/waste_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified energy textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalDivertedWaste(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String wpReduction = data.getCellData(sheetName, "WastePReduction", rowNum)
		String wbValue = data.getCellData(sheetName, "WasteBValue", rowNum)
		String wUnit = data.getCellData(sheetName, "Wasteunit", rowNum)
		String wtextbox = data.getCellData(sheetName,"WasteTextBox", rowNum)
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying energy unit lbs"
		String lbs = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_unit'))
		System.out.println(lbs)
		WebUI.delay(1)
		WebUI.verifyMatch(lbs, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_percent_reduction'))
		println wpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/diverted_waste_currentProgess'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction)
		double result1 =depReduction -replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)

		WebUI.verifyMatch(forntenddiffGoal, calcalteddiffGoal, false)

		//Assert.assertTrue(forntenddiffGoal,calcalteddiffGoal);
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/diverted_waste_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/diverted_waste_target_year'),targetYear,true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_Goal'))
		String greplace = energyGoal.replace("%" , "")
		double wGexpected=Double.parseDouble(greplace)
		System.out.println(wGexpected)
		double wGactual = depReduction/2
		System.out.println(wGactual)
		Assert.assertEquals(wGactual,wGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/diverted_waste_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/diverted_waste_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/waste_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalTransport(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String tpReduction = data.getCellData(sheetName, "TReduction", rowNum)
		String tbValue 	= data.getCellData(sheetName, "TBValue", rowNum)
		String tUnit 	= data.getCellData(sheetName, "Tunit", rowNum)
		String textbox = data.getCellData(sheetName,"TTextBox", rowNum)

		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying energy unit lbs"
		String mtco2e = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/TransportUnit'))
		System.out.println(mtco2e)
		WebUI.delay(1)
		WebUI.verifyMatch(mtco2e, tUnit, false)
		println "Test passed verified transport unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_percent_reduction'))
		println tpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_percent_reduction'), tpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_baseline_value'), tbValue)

		WebUI.click(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/transport_DiffGoal'))
		System.out.println(forntenddiffGoal)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/transport_currentProgess'))
		System.out.println(currentProgress)
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		System.out.println("Fatching replaced value")
		System.out.println(replace)
		double depReduction=Double.parseDouble(tpReduction)
		double result1 =depReduction -replace1
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/transport_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/transport_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/transport_Goal'))
		String greplace = energyGoal.replace("%" , "")
		double wGexpected=Double.parseDouble(greplace)
		System.out.println(wGexpected)
		double wGactual = depReduction/2
		System.out.println(wGactual)
		Assert.assertEquals(wGactual,wGexpected)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/transport_currentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_baseline_value'),"value").contains(tbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_percent_reduction'),"value").contains(tpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalHumanExp(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String hpReduction = data.getCellData(sheetName, "HReduction", rowNum)
		String hbValue 	= data.getCellData(sheetName, "HBValue", rowNum)
		String hUnit 	= data.getCellData(sheetName, "Hunit", rowNum)
		String htextbox = data.getCellData(sheetName,"HTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying human experiace unit Average Score"
		String averageScore = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/humExpUnit_Average Score'))
		System.out.println(averageScore)
		WebUI.delay(1)
		WebUI.verifyMatch(averageScore, hUnit, false)
		println "Test passed verified human experiace unit successfully"

		println "Test Started human experiance differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanExp_percent_reduction'))
		println hpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanExp_percent_reduction'), hpReduction)
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanExp_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanExp_baseline_value'), hbValue)

		WebUI.click(findTestObject('Portfolio/Goal/humExpDiffGoal'))
		WebUI.delay(3)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/humExpCurrentProgress'))
		double dcurrentProgress= Double.parseDouble(currentProgress)
		String front_enddDGoal = WebUI.getText(findTestObject('Portfolio/Goal/humExpDiffGoal'))
		double afront_endDiffGoal =Double.parseDouble(front_enddDGoal)
		double dhpReduction =Double.parseDouble(hpReduction)
		double calculate_diff_Goal = dhpReduction - dcurrentProgress
		System.out.println(calculate_diff_Goal)
		Assert.assertEquals(afront_endDiffGoal,calculate_diff_Goal)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/humExp_score_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/humExp_score_target_year'), targetYear, true)

		String hum_Goal = WebUI.getText(findTestObject('Portfolio/Goal/HumanExpGoal'))
		double dhum_Goal=Double.parseDouble(hum_Goal)
		System.out.println(dhum_Goal)
		double chum_Goal = dhpReduction/2
		System.out.println(chum_Goal)
		Assert.assertEquals(chum_Goal, dhum_Goal)
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'),htextbox )
		WebUI.click(findTestObject('Portfolio/Goal/transport_currentProgess'))
		WebUI.delay(2)
		/*	WebUI.refresh()
		 WebUI.delay(5)*/

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanExp_baseline_value'),"value").contains(hbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanExp_percent_reduction'),"value").contains(hpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanexp_textarea'),"value").contains(htextbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalCertification(String sheetName,int rowNum) throws IOException, InterruptedException {
		String cpReduction 		= data.getCellData(sheetName, "CertReduction", rowNum)
		String cUnit 	= data.getCellData(sheetName, "Certunit", rowNum)
		String ctextbox 	= data.getCellData(sheetName,"CertTextBox", rowNum)
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		println "Test started verifying certification unit "
		String certification = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CertificationsUnit'))
		WebUI.verifyMatch(certification, cUnit, false)
		println  "Test passed verified unit successfully"

		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/certification_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/certification_percent_reduction'), cpReduction)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/certification_currentProgess'))
		WebUI.delay(2)
		String  forntenddiffGoal = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CertificationDiffGoal'))
		String  currentProgress = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/certification_currentProgess'))
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace)
		double dwpercentagered=Double.parseDouble(cpReduction)
		double result1 =dwpercentagered -replace1

		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1)
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %"
		System.out.println(calcalteddiffGoal)
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal)

	}
	@Keyword
	public void totalEnergyConsumption(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))

		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on Size"
		String  averageEnergyKBTU= WebUI.getText(findTestObject('Portfolio/Total/AverageEnergyKBTU'))
		System.out.println(averageEnergyKBTU)
		double averageenergyKBTU =Double.parseDouble(averageEnergyKBTU)


		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)

		String avg_sqarefoot1  = data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)
		String  atotalmtco2eScope1=WebUI.getText(findTestObject('Portfolio/Total/AEnergyScope1'))
		System.out.println(atotalmtco2eScope1)
		double datotalmtco2eScope1 =Double.parseDouble(atotalmtco2eScope1)
		String  atotalmtco2eScope2=WebUI.getText(findTestObject('Portfolio/Total/AEnergyScope2'))
		System.out.println(atotalmtco2eScope2)
		double datotalmtco2eScope2 =Double.parseDouble(atotalmtco2eScope2)
		System.out.println("Fatching ")
		System.out.println(datotalmtco2eScope2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Energy'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/EnergyGoal'))
		String greplace = carbonGoal.replace("%" , "")
		double cGoalPercetage=Double.parseDouble(greplace)
		System.out.println(cGoalPercetage)

		double result =((averageenergyKBTU) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)

		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)

		String sareductionTarget2 = areductionTarget2.toString()
		String scGoalPercentage = cGoalPercentage.toString()
		WebUI.verifyMatch(sareductionTarget2, scGoalPercentage,true,FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(areductionTarget2, cGoalPercentage);

		System.out.println(areductionTarget2)
		System.out.println(cGoalPercentage)
		println "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/EAvgOccScope1'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(2, RoundingMode.HALF_UP)
		double occupancyCalcuation = (datotalmtco2eScope1 / favgOccupanit_proj)
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(2, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant)
		System.out.println(expavgmtco2_peroccupant1)

		String savgmtco2_peroccupant = avgmtco2_peroccupant.toString()
		String sexpavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.toString()
		WebUI.verifyMatch(savgmtco2_peroccupant, sexpavgmtco2_peroccupant1,true,FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/EAvgSqFootScope1'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot2)
		double cavg_squarefoot = (datotalmtco2eScope1 / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)
		System.out.println(cavg_squarefoot1)

		String savg_squarefoot2 = avg_squarefoot2.toString()
		String scavg_squarefoot1 = cavg_squarefoot1.toString()
		WebUI.verifyMatch(savg_squarefoot2, scavg_squarefoot1,true,FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println "verified average sqaure feet per project successully"

		//Issue Found in rounding 4 postion after decimal Rajan will fix later .
		println "Test started verifying average occpant per project"
		String totalNoOccupaint2 = WebUI.getText(findTestObject('Portfolio/Total/EAvgOccScope2'))
		double expavgmtco2_peroccupant2 = Double.parseDouble(totalNoOccupaint2)
		BigDecimal expavgmtco2_peroccupantScope2 = new BigDecimal(expavgmtco2_peroccupant2)
		expavgmtco2_peroccupantScope2 = expavgmtco2_peroccupantScope2.setScale(4, RoundingMode.HALF_UP)
		double occupancyCalcuation2 = (datotalmtco2eScope2 / favgOccupanit_proj)
		BigDecimal cavgoccupancyCalcuationScope2 = new BigDecimal(occupancyCalcuation2)
		cavgoccupancyCalcuationScope2 = cavgoccupancyCalcuationScope2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(cavgoccupancyCalcuationScope2)

		String scavgoccupancyCalcuationScope2 = cavgoccupancyCalcuationScope2.toString()
		String sexpavgmtco2_peroccupantScope2 = expavgmtco2_peroccupantScope2.toString()
		WebUI.verifyMatch(scavgoccupancyCalcuationScope2, sexpavgmtco2_peroccupantScope2,true,FailureHandling.CONTINUE_ON_FAILURE)
		//	Assert.assertEquals(cavgoccupancyCalcuationScope2, expavgmtco2_peroccupantScope2);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefootScope2 = WebUI.getText(findTestObject('Portfolio/Total/EAvgSqFootScope2'))
		System.out.println(avg_squarefootScope2)
		double avg_squarefootscope2 = Double.parseDouble(avg_squarefootScope2)
		BigDecimal avg_SquarefootScope2 = new BigDecimal(avg_squarefootscope2)
		avg_SquarefootScope2 = avg_SquarefootScope2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_SquarefootScope2)
		double cavg_SquarefootScope2 = (datotalmtco2eScope2 / avg_sqarefoot2)
		BigDecimal cAvg_SquarefootScope2 = new BigDecimal(cavg_SquarefootScope2)
		cAvg_SquarefootScope2 = cAvg_SquarefootScope2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(cAvg_SquarefootScope2)

		String savg_SquarefootScope2 = avg_SquarefootScope2.toString()
		String scAvg_SquarefootScope2 = cAvg_SquarefootScope2.toString()
		WebUI.verifyMatch(savg_SquarefootScope2, scAvg_SquarefootScope2,true,FailureHandling.CONTINUE_ON_FAILURE)

		//Assert.assertEquals(avg_SquarefootScope2,cAvg_SquarefootScope2);
		println " verified average sqaure feet per project successully"

	}
	@Keyword
	public void waterConsumptionTest(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)
		println "Test passed counted total number of project based on area"

		String  annualWaterConsuption=WebUI.getText(findTestObject('Portfolio/Total/AnnualWaterConsuption'))
		System.out.println(annualWaterConsuption)
		double awaterconsumption =Double.parseDouble(annualWaterConsuption)
		String avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)
		String avg_sqarefoot1  = data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Water'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal =WebUI.getText(findTestObject('Portfolio/Total/WaterGoal'))
		String greplace = carbonGoal.replace("%" , "")
		double cGoalPercetage=Double.parseDouble(greplace)
		System.out.println(cGoalPercetage)
		double result =((awaterconsumption) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)

		String sareductionTarget2 = areductionTarget2.toString()
		String scGoalPercentage = cGoalPercentage.toString()
		WebUI.verifyMatch(sareductionTarget2, scGoalPercentage,true,FailureHandling.CONTINUE_ON_FAILURE)

		//Assert.assertEquals(areductionTarget2, cGoalPercentage);
		System.out.println(areductionTarget2)
		System.out.println(cGoalPercentage)
		println "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/AverageOccpantGallons'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP)

		double occupancyCalcuation = (awaterconsumption / favgOccupanit_proj)
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant)
		System.out.println(expavgmtco2_peroccupant1)

		String savgmtco2_peroccupant = avgmtco2_peroccupant.toString()
		String sexpavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.toString()
		WebUI.verifyMatch(savgmtco2_peroccupant, sexpavgmtco2_peroccupant1,true,FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/AverageSquareFootGallons'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)
		double cavg_squarefoot = (awaterconsumption / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot2)
		System.out.println(cavg_squarefoot1)

		String savg_squarefoot2 = avg_squarefoot2.toString()
		String scavg_squarefoot1 = cavg_squarefoot1.toString()
		WebUI.verifyMatch(savg_squarefoot2, scavg_squarefoot1,true,FailureHandling.CONTINUE_ON_FAILURE)

		//Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println  "verified average sqaure feet per project successully"
	}
	@Keyword
	public void totalCarbonConsumption(String sheetName,int rowNum) throws IOException, InterruptedException {

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on area"
		String  annualCarbonConsuption=WebUI.getText(findTestObject('Object Repository/Portfolio/Common/Annaul'))
		System.out.println(annualCarbonConsuption)
		double acmtco2e =Double.parseDouble(annualCarbonConsuption)

		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)
		String avg_sqarefoot1  = data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Carbon'))
		WebUI.delay(5)

		println  "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/CarbonGoal'))
		String greplace = carbonGoal.replace("%" , "")
		double cGoalPercetage=Double.parseDouble(greplace)
		System.out.println(cGoalPercetage)
		double result =((acmtco2e) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)

		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))

		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)
		String sareductionTarget2 = areductionTarget2.toString()
		String scGoalPercentage = cGoalPercentage.toString()

		WebUI.verifyMatch( scGoalPercentage,sareductionTarget2,true,FailureHandling.CONTINUE_ON_FAILURE)
		//Assert.assertEquals(areductionTarget2, cGoalPercentage)
		System.out.println(areductionTarget2)
		System.out.println(cGoalPercentage)
		println  "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint =WebUI.getText(findTestObject('Portfolio/Total/AverageOccupant'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP)
		double occupancyCalcuation = (acmtco2e / favgOccupanit_proj)

		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant)
		System.out.println(expavgmtco2_peroccupant1)

		String savgmtco2_peroccupant = avgmtco2_peroccupant.toString()
		String sexpavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.toString()
		WebUI.verifyMatch(savgmtco2_peroccupant, sexpavgmtco2_peroccupant1,true,FailureHandling.CONTINUE_ON_FAILURE)
		println "verified average occpant per project successully"

		println  "Test started verifying average sqaure feet per project"
		String avg_squarefoot =WebUI.getText(findTestObject('Portfolio/Total/CAvgSqaurefoot'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)

		double cavg_squarefoot = (acmtco2e / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot2)
		System.out.println(cavg_squarefoot1)

		String savg_squarefoot2 = avg_squarefoot2.toString()
		String scavg_squarefoot1 = cavg_squarefoot1.toString()
		WebUI.verifyMatch(scavg_squarefoot1,savg_squarefoot2,true,FailureHandling.CONTINUE_ON_FAILURE)
		println " verified average sqaure feet per project successully"
	}

	@Keyword
	public void transprtTransportationMetrics(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(10)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on the area"
		String  transportDaliyAvg=WebUI.getText(findTestObject('Portfolio/Total/TransportDaliyAvg'))
		System.out.println(transportDaliyAvg)
		double transportdaliyAvg =Double.parseDouble(transportDaliyAvg)
		double transportAnnualAvg = transportdaliyAvg * 365

		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)


		String avg_sqarefoot1  =  data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Transportation'))
		WebUI.delay(10)

		println "Test started verifying average occpant per project"
		WebUI.scrollToElement(findTestObject('Portfolio/Total/TransprotAvgEmissionOccpint'), 3)
		String transprotAvgEmissionOccpint =WebUI.getText(findTestObject('Portfolio/Total/TransprotAvgEmissionOccpint'))

		double transprotavgEmissionOccpint = Double.parseDouble(transprotAvgEmissionOccpint)
		BigDecimal transprotavgemissionoccpint = new BigDecimal(transprotavgEmissionOccpint)
		transprotavgemissionoccpint = transprotavgemissionoccpint.setScale(4, RoundingMode.HALF_UP)

		double occupancyCalcuation = (transportAnnualAvg / favgOccupanit_proj)
		BigDecimal avgtransport_peroccupant = new BigDecimal(occupancyCalcuation)
		avgtransport_peroccupant = avgtransport_peroccupant.setScale(4, RoundingMode.HALF_UP)

		String stransprotavgemissionoccpint = transprotavgemissionoccpint.toString()
		String savgtransport_peroccupant = avgtransport_peroccupant.toString()
		WebUI.verifyMatch(stransprotavgemissionoccpint ,savgtransport_peroccupant , true,FailureHandling.CONTINUE_ON_FAILURE)
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/TransportAvgDistOccupaint'))
		System.out.println(avg_squarefoot)

		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)

		double cavg_squarefoot = (transportAnnualAvg / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)

		String savg_squarefoot2 = avg_squarefoot2.toString()
		String scavg_squarefoot1 = cavg_squarefoot1.toString()
		WebUI.verifyMatch(savg_squarefoot2 ,scavg_squarefoot1 ,true,FailureHandling.CONTINUE_ON_FAILURE)
		println " verified average sqaure feet per project successully"
	}

	@Keyword
	public void wasteDiversionTest(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)
		println "counting total number of project based on size"
		String lessthan50000  =   WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)

		println "Test passed counted total number of project based on Size"
		String  avgWasteGen=  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteDiv'))
		System.out.println(avgWasteGen)
		double avgwasteGen =Double.parseDouble(avgWasteGen)
		double annaulwasteGen = avgwasteGen * 365

		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)

		//	String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/WasteGoal'))
		String greplace = carbonGoal.replace("%" , "")
		double cGoalPercetage=Double.parseDouble(greplace)

		double result =((annaulwasteGen) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/WasteDRTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)

		String sareductionTarget2 = areductionTarget2.toString()
		String scGoalPercentage = cGoalPercentage.toString()
		WebUI.verifyMatch(sareductionTarget2, scGoalPercentage,true,FailureHandling.CONTINUE_ON_FAILURE)


	}


	@Keyword
	public void humExpTransportationMetrics()throws IOException, InterruptedException {

		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(5)
		println "Test started verifying acheive goal in percentage"
		String hum_Goal =WebUI.getText(findTestObject('Portfolio/Goal/HumanExpGoal'))
		String ghum_avgScore = WebUI.getText(findTestObject('Portfolio/Total/humExpAvgScore'))
		String gavgScore =WebUI.getText(findTestObject('Portfolio/Total/GHumExp'))

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		String havgSatisfaction = WebUI.getText(findTestObject('Portfolio/Total/AvgOccupaintSatisfaction'))
		Double havgsatisfaction = Double.parseDouble(havgSatisfaction)
		BigDecimal thAvgsatisfaction = new BigDecimal(havgsatisfaction)
		thAvgsatisfaction = thAvgsatisfaction.setScale(4, RoundingMode.HALF_UP)

		WebUI.click(findTestObject('Portfolio/Common/a_ Human Experience'))
		WebUI.delay(5)
		String ahum_Goal = WebUI.getText(findTestObject('Portfolio/Total/AGoalHumExp'))
		String ahum_avgScore = WebUI.getText(findTestObject('Portfolio/Total/humExpAvgScore'))
		String ahumAvgstisfaction = WebUI.getText(findTestObject('Portfolio/Total/AhumExpAvgSatisfaction'))
		Double aavgsatisfaction = Double.parseDouble(ahumAvgstisfaction)
		BigDecimal ahAvgsatisfaction = new BigDecimal(aavgsatisfaction)
		ahAvgsatisfaction = ahAvgsatisfaction.setScale(4, RoundingMode.HALF_UP)
		println "Test Started Verifying hum exp avg score"
		String havgScore =WebUI.getText(findTestObject('Portfolio/Total/AvgHumanExp'))
		Assert.assertEquals(havgScore, gavgScore)

		Assert.assertEquals(hum_Goal, ahum_Goal)
		println "Test passed verified acheive goal percentage successfully"
		Assert.assertEquals(ghum_avgScore, ahum_avgScore)
		println "Test passed verified hum exp avg socre sucore successully"
		Assert.assertEquals(ahAvgsatisfaction, thAvgsatisfaction)
		println " Test Passed verified hum exp average satisfaction"
	}

	@Keyword
	public void wasteGenerationTest(String sheetName,int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)
		println "counting total number of project based on size"
		String lessthan50000  =   WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on Size"
		String  avgWasteGen=  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGen'))
		System.out.println(avgWasteGen)
		double avgwasteGen =Double.parseDouble(avgWasteGen)
		double annaulwasteGen = avgwasteGen * 365

		String repavgOccupanit  = data.getCellData(sheetName,"occupancy",15)
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)

		//String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = data.getCellData(sheetName,"Area",15)
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/WasteGoal'))
		String greplace = carbonGoal.replace("%" , "")
		double cGoalPercetage=Double.parseDouble(greplace)

		double result =((annaulwasteGen) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/WasteGRTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)

		String sareductionTarget2 = areductionTarget2.toString()
		String scGoalPercentage = cGoalPercentage.toString()
		WebUI.verifyMatch(sareductionTarget2, scGoalPercentage,true,FailureHandling.CONTINUE_ON_FAILURE)

		println "verifyed 2018 Reduction Targets"
		println "Test started verifying average occpant per project"

		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerOccupaint'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP)
		double occupancyCalcuation = (annaulwasteGen / favgOccupanit_proj)
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant)
		System.out.println(expavgmtco2_peroccupant1)

		String savgmtco2_peroccupant = avgmtco2_peroccupant.toString()
		String sexpavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.toString()
		WebUI.verifyMatch(savgmtco2_peroccupant, sexpavgmtco2_peroccupant1,true,FailureHandling.CONTINUE_ON_FAILURE)
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot =  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerSqFoot'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)
		double cavg_squarefoot = (annaulwasteGen / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)

		String savg_squarefoot2 = avg_squarefoot2.toString()
		String scavg_squarefoot1 = cavg_squarefoot1.toString()
		WebUI.verifyMatch(scavg_squarefoot1,savg_squarefoot2,true,FailureHandling.CONTINUE_ON_FAILURE)
		println "verified average sqaure feet per project successully"

	}
	@Keyword
	public void editPortfolioDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		String projectName   = data.getCellData(sheetName, "ProjectName", 2)
		String organization  = data.getCellData(sheetName, "Organization", 3)
		String orgCountry 	 = data.getCellData(sheetName, "orgCountry", 3)
		String orgContact    = data.getCellData(sheetName, "orgContact", 3)
		String location      = data.getCellData(sheetName, "location", 3)
		String email         = data.getCellData(sheetName, "email", 3)
		String prjDesc       = data.getCellData(sheetName, "portfolioDesc", 3)

		WebUI.click(findTestObject('Portfolio/Total/span_Edit'))
		WebUI.delay(2)
		WebUI.clearText(findTestObject('Portfolio/Total/portfolio_name'))

		WebUI.sendKeys(findTestObject('Portfolio/Total/portfolio_name'), projectName)
		WebUI.clearText(findTestObject('Portfolio/Total/textarea_organization'))

		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Total/textarea_organization'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Portfolio/Total/OrgV Architecture'))
		WebUI.delay(3)
		println "Entering the Portfolio Organization Name"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Total/org_country'), orgCountry, false)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Mob'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Mob'), orgContact)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Location'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Location'), location)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Email'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Email'), email)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Description'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Description'), prjDesc)

		WebUI.click(findTestObject('Portfolio/Total/span_Save'))
		WebUI.delay(10)
		WebUI.refresh()
		WebUI.delay(5)
		WebUI.waitForPageLoad(10)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/portfolio_name'),"value").contains(projectName),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_organization'),"value").contains(organization),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/org_country'),"value").contains("TR"),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Mob'),"value").contains(orgContact),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Location'),"value").contains(location),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Description'),"value").contains(prjDesc),"Not Valid")
		println  "Edit Project  Verified Successfully"
	}
	@Keyword
	public void editPortfolioName(String sheetName, int rowNum) throws IOException, InterruptedException {
		String projectName   = data.getCellData(sheetName, "ProjectName", 3)
		WebUI.click(findTestObject('Portfolio/Total/span_Edit'))
		WebUI.delay(2)
		WebUI.clearText(findTestObject('Portfolio/Total/portfolio_name'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/portfolio_name'), projectName)
		WebUI.click(findTestObject('Portfolio/Total/span_Save'))
		WebUI.delay(10)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/portfolio_name'),"value").contains(projectName),"Not Valid")
		println  "Edit Project  Verified Successfully"
	}

	@Keyword
	public void AddTeamMember(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.delay(2)
		String teamMember   = data.getCellData(sheetName, "teamMember", rowNum)

		WebUI.sendKeys(findTestObject('Portfolio/Total/input_AddCollabrator'), teamMember)
		WebUI.scrollToElement(findTestObject('Portfolio/Total/button_Add'), 3)
		WebUI.click(findTestObject('Portfolio/Total/button_Add'))
		WebUI.delay(7)
		String teammember = WebUI.getText(findTestObject('Portfolio/Total/VerifyTeamMail'))
		println teammember
		WebUI.verifyMatch(teammember, teamMember, false)
		println  "Add New Team Member Verified Successfully"
	}

	public void editTeamMember() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Portfolio/Total/a_ Team'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Portfolio/Total/EditRole'))
		WebUI.click(findTestObject('Portfolio/Total/EditAuthRight'))
		WebUI.click(findTestObject('Portfolio/Total/SelectRole'))
		WebUI.click(findTestObject('Portfolio/Total/SaveRole'))
		WebUI.delay(8)
		String role = WebUI.getText(findTestObject('Portfolio/Total/GetRole'))
		WebUI.verifyMatch(role, "Can Edit", false)
		println "Team Member Authourization is updated"
		println "Edit Team Member Authourization Verified Successfully"
	}

	@Keyword
	public void AddNotRegisterUsgbcTeamMember() throws IOException, InterruptedException {
		/*WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		 WebUI.delay(1)
		 WebUI.doubleClick(findTestObject('Portfolio/Total/a_ Team'))
		 */	WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Portfolio/Total/input_AddCollabrator'),'aabbccdd@gmail.com')
		WebUI.scrollToElement(findTestObject('Portfolio/Total/button_Add'), 3)
		WebUI.click(findTestObject('Portfolio/Total/button_Add'))
		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('Portfolio/Common/InvalidTeamMem'),2)
	}
	@Keyword
	public void verifyAunthenticationLevel() throws IOException, InterruptedException {

		WebUI.sendKeys(findTestObject('Portfolio/Total/input_AddCollabrator'),'aabbccdd@gmail.com')
		WebUI.scrollToElement(findTestObject('Portfolio/Total/button_Add'), 3)
		WebUI.click(findTestObject('Portfolio/Total/button_Add'))
		WebUI.delay(10)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Common/InvalidTeamMem'),2)
	}

	@Keyword
	public void changeAuthLevelNone() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Portfolio/Total/a_ Team'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Portfolio/Total/EditRole'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Total/EditAuthRight'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Portfolio/Common/a_None'),5)
		WebUI.click(findTestObject('Portfolio/Common/a_None'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Total/SaveRole'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/Common/Atleast one user with Edit Popup'),7)
	}
	@Keyword
	public void manageNavigationTest() throws IOException, InterruptedException {
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/manage/nav/FirtstProj'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Portfolio/manage/nav/PerformaceScore'),4)
	}
	@Keyword
	public void addedProjectDetails() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Common/PortfolioPage'))
		WebUI.delay(5)

		By projectId  = By.xpath('//tr[@class="arcTbl--row project_row ng-scope"]/td[5]')
		ArrayList<WebElement> projectIds = driver.findElements(projectId)
		for (projectid in projectIds){
			String Projectid = projectid.getText()
			println Projectid
		}
		String TotalProjectid= projectIds.size()
		/******************** Verifying if  all the project id displays *******************/
		WebUI.verifyMatch(TotalProjectid,'6', false)

		By projectNa  = By.xpath('//tr[@class="arcTbl--row project_row ng-scope"]/td[2]')
		ArrayList<WebElement> projectNas = driver.findElements(projectNa)
		for (projectna in projectNas){
			String Projectid = projectna.getText()
			println projectna
		}
		String Totalprojectna= projectNas.size()
		/******************** Verifying if all the project name displays *******************/
		WebUI.verifyMatch(Totalprojectna,'6', false)

		By projectScore  = By.xpath('//tr[@class="arcTbl--row project_row ng-scope"]/td[7]')
		ArrayList<WebElement> projectScores = driver.findElements(projectScore)
		for (tprojectScore in projectScores){
			String Projectscore = tprojectScore.getText()
			println Projectscore
		}
		String totalprojectscores= projectScores.size()
		/******************** Verifying all the project score displays *******************/
		WebUI.verifyMatch(totalprojectscores,'6', false)
	}

	@Keyword
	public void deleteprojectfromportfolio(String sheetName, int rowNum) throws IOException, InterruptedException {
		String projectId 	= data.getCellData(sheetName,"ID",8)
		String portfolioName 	= data.getCellData(sheetName, "ProjectName",2)

		WebUI.scrollToElement(findTestObject('Portfolio/manage/AddProject'), 4)
		WebUI.click(findTestObject('Portfolio/manage/AddProject'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPort'), projectId)
		WebUI.click(findTestObject('Portfolio/Common/input_searchBarPort'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/SelectProjectInPortfolio'))
		WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPortfolio'),portfolioName)
		WebUI.click(findTestObject('Portfolio/Common/input_searchBarPortfolio'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/SelectPortfolio'))
		WebUI.click(findTestObject('Portfolio/Common/button_Add'))
		WebUI.delay(10)
		WebUI.waitForElementVisible(findTestObject('Portfolio/Common/button_Done'),6)
		WebUI.click(findTestObject('Portfolio/Common/button_Done'))
		WebUI.delay(7)

		//WebUI.scrollToElement(findTestObject('Portfolio/Total/a_ Manage'),2)
		//WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		//WebUI.delay(3)

		WebUI.click(findTestObject('Portfolio/Common/PortfolioPage'))
		WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Portfolio/Common/ClickScore'),2)
		WebUI.click(findTestObject('Portfolio/Common/ClickScore'))
		WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Object Repository/Portfolio/Common/Fifth'), 3)
		WebUI.click(findTestObject('Object Repository/Portfolio/Common/Fifth'))
		WebUI.delay(9)

		/***************Verifying project is deleted successfully by count no of projects ********************/
		WebDriver driver  = DriverFactory.getWebDriver()
		ArrayList numberOfCount = driver.findElements(By.xpath("//*[@class='vertical-align-middle']"))
		int numberOfCountSize = numberOfCount.size()

		Iterator<Integer> iterator = numberOfCountSize.iterator()

		// while loop iterating the value
		while (iterator.hasNext()) {
			int value =  iterator.next()
			String actualtotalCount= value
			WebUI.verifyMatch(actualtotalCount,'6', false)
		}

	}


	@Keyword
	public void changeAuthLevelread() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/manage/Edit2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/manage/CanEdit2'))
		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Portfolio/manage/CanRead'),5)
		WebUI.click(findTestObject('Portfolio/manage/CanRead'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/manage/Save2'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Portfolio/manage/canReadPresent'),7)

	}

	@Keyword
	public void projecthistory() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Object Repository/Portfolio/HistoryProjectDeatils/a_ History'))
		WebUI.delay(7)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P1'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P2'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P3'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P4'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P5'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P6'),2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/HistoryProjectDeatils/P7'),2, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyTextPresent("added", false)
		WebUI.verifyTextPresent("deleted", false)
	}
	@Keyword
	public void projectCarbonTotal(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Object Repository/Portfolio/CarbonVal/Page_Arc dashboard/span_Carbon'))
		WebUI.delay(5)
		String carbonFirstValule = WebUI.getText(findTestObject('Portfolio/CarbonVal/First'))
		double carbon1valule=Double.parseDouble(carbonFirstValule)
		String carbon2Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/2nd'))
		double carbon2valule=Double.parseDouble(carbon2Valule)
		String carbon3Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/Third'))
		double carbon3valule=Double.parseDouble(carbon3Valule)
		String carbon4Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/four'))
		double carbon4valule=Double.parseDouble(carbon4Valule)
		String carbon5Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/Fifth'))
		double carbon5valule=Double.parseDouble(carbon5Valule)
		String carbon6Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/sixth'))
		double carbon6valule=Double.parseDouble(carbon6Valule)

		double totalcarbon = carbon1valule + carbon2valule + carbon3valule + carbon4valule + carbon5valule + carbon6valule

		BigDecimal carbontotal = new BigDecimal(totalcarbon)
		carbontotal =  carbontotal.setScale(1, RoundingMode.HALF_UP)
		String carbonTotal = carbontotal.toString()
		data.setCellData(sheetName,"carbonEmission",10,carbonTotal)

		double carbonaverage = totalcarbon / 6
		BigDecimal carbonAverage = new BigDecimal(carbonaverage)
		carbonAverage =  carbonAverage .setScale(1, RoundingMode.HALF_UP)
		String carbonAvg = carbonAverage.toString()
		data.setCellData(sheetName,"carbonEmission",11,carbonAvg)

		ArrayList<Double> carbon = new ArrayList<Double>()

		carbon.add(carbon1valule)
		carbon.add(carbon2valule)
		carbon.add(carbon3valule)
		carbon.add(carbon4valule)
		carbon.add(carbon5valule)
		carbon.add(carbon6valule)

		Collections.sort(carbon)
		println carbon
		Collections.reverse(carbon)
		println carbon
		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println(carbon.get(i))
				String highest = carbon.get(i)
				String chighest = highest.toString()
				data.setCellData(sheetName,"carbonEmission", 2 ,chighest)
			}
			if(i==1){
				System.out.println(carbon.get(i))
				Double highest = carbon.get(i)
				String chighest = highest.toString()
				data.setCellData(sheetName,"carbonEmission", 3 ,chighest)
			}
			if(i==2){
				System.out.println(carbon.get(i))
				Double highest = carbon.get(i)
				String chighest = highest.toString()
				data.setCellData(sheetName,"carbonEmission", 4 ,chighest)
			}
			if(i==3){
				System.out.println(carbon.get(i))
				Double highest = carbon.get(i)
				String chighest = highest.toString()
				data.setCellData(sheetName,"carbonEmission", 5 ,chighest)
			}
			if(i==4){
				System.out.println(carbon.get(i))
				Double highest = carbon.get(i)
				String chighest = highest.toString()
				data.setCellData(sheetName,"carbonEmission", 6 ,chighest)
			}
			if(i==5){
				System.out.println(carbon.get(i))
				Double highest = carbon.get(i)
				String chighest = highest.toString()
				if(chighest=="0.0")
					chighest = '0'
				data.setCellData(sheetName,"carbonEmission" , 7,chighest)
			}

		}
	}

	@Keyword
	public void projectCarbonFilter(String sheetName, int rowNum) throws IOException, InterruptedException {
		String carbonFirstValule = WebUI.getText(findTestObject('Portfolio/CarbonVal/First'))
		String carbon2Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/2nd'))
		String carbon3Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/Third'))
		String carbon4Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/four'))
		String carbon5Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/Fifth'))
		String carbon6Valule = WebUI.getText(findTestObject('Portfolio/CarbonVal/sixth'))

		String carbon2valule= data.getCellData(sheetName,"carbonEmission", 2)
		String carbon3valule= data.getCellData(sheetName,"carbonEmission", 3)
		String carbon4valule= data.getCellData(sheetName,"carbonEmission", 4)
		String carbon5valule= data.getCellData(sheetName,"carbonEmission", 5)
		String carbon6valule= data.getCellData(sheetName,"carbonEmission", 6)
		String carbon7valule= data.getCellData(sheetName,"carbonEmission", 7)

		WebUI.verifyMatch(carbonFirstValule, carbon2valule, false)
		WebUI.verifyMatch(carbon2Valule, carbon3valule, false)
		WebUI.verifyMatch(carbon3Valule, carbon4valule, false)
		WebUI.verifyMatch(carbon4Valule, carbon5valule, false)
		WebUI.verifyMatch(carbon5Valule, carbon6valule, false)
		WebUI.verifyMatch(carbon6Valule, carbon7valule, false)


	}

	@Keyword
	public void projectScope1Filter(String sheetName, int rowNum) throws IOException, InterruptedException {

		//WebUI.delay(10)
		WebUI.click(findTestObject('Portfolio/CarbonVal/Filter/Filter'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/CarbonVal/Filter/Scope1'))
		WebUI.delay(5)
		By scope1val = By.xpath('//div[@class="progress-bar scope1_raw_ghg-bg carbon--progressBar__marginRight"]')
		WebUI.delay(2)
		ArrayList<WebElement> scope1s= driver.findElements(scope1val)
		for (scope1 in scope1s){
			String scope1v = scope1.getText()
			if(scope1v.matches("\\d*\\.?\\d+"))
				println scope1v
			else
				KeywordUtil.markFailedAndStop("!!! Scope 1 progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String scope1totalProg= scope1s.size()
		/******************** Verifying if scope 1 progress bar present inside all the project *******************/
		WebUI.verifyMatch(scope1totalProg,'6', false)

		/*********************Verify if Scope2 and Transportation bar Should not display ************************/
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/Scope2ProgessBar'),2)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/TransportProgessBar'),2)
		WebUI.uncheck(findTestObject('Portfolio/CarbonVal/Filter/Scope1'))
		WebUI.delay(2)

	}
	@Keyword
	public void projectScope2Filter(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.check(findTestObject('Portfolio/CarbonVal/Filter/scope2'))
		WebUI.delay(5)

		By scope2val = By.xpath('//div[@class="progress-bar scope2_raw_ghg-bg carbon--progressBar__marginRight"]')
		ArrayList<WebElement> scope2s = driver.findElements(scope2val)
		for (scope2 in scope2s){
			String scope2v = scope2.getText()
			if(scope2v.matches("\\d*\\.?\\d+"))
				println scope2v
			else
				KeywordUtil.markFailedAndStop("!!! Scope 2 progress bar displays empety or null or vaule not displays !!!!!!")
		}
		String scope2totalProg= scope2s.size()
		/******************** Verifying if scope 1 progress bar present inside all the project *******************/
		WebUI.verifyMatch(scope2totalProg,'6', false)
		/*********************Verify if Scope2 and Transportation bar Should not display ************************/
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/scope1ProgessBar'),2)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/TransportProgessBar'),2)
		WebUI.uncheck(findTestObject('Portfolio/CarbonVal/Filter/scope2'))
		WebUI.delay(2)

	}
	@Keyword
	public void transportFilter(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.check(findTestObject('Portfolio/CarbonVal/Filter/transportCheckbox'))
		WebUI.delay(5)
		By transportVal = By.xpath('//div[@class="progress-bar raw_transit-bg carbon--progressBar__marginRight"]')
		ArrayList<WebElement> transvalues= driver.findElements(transportVal)
		for (transvalue in transvalues) {
			String trans = transvalue.getText()
			if(trans.matches("\\d*\\.?\\d+"))
				println trans
			else
				KeywordUtil.markFailedAndStop("!!! Trasnportion progress bar displays empety or null or vaule not displays !!!!!!")
		}
		String transport= transvalues.size()
		/******************** Verifying if scope 1 progress bar present inside all the project *******************/	
		WebUI.verifyMatch(transport,'6', false)

		/*********************Verify if Scope 1 and Scope 2 bar Should not display ************************/	
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/scope1ProgessBar'),2)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/CarbonVal/Filter/Scope2ProgessBar'),2)

	}
	@Keyword
	public void projectCarbonScope1Scope2Trant(String sheetName, int rowNum) throws IOException, InterruptedException {

		By scope2val = By.xpath('//div[@class="progress-bar scope2_raw_ghg-bg carbon--progressBar__marginRight"]')
		ArrayList<WebElement> scope2s = driver.findElements(scope2val)
		for (scope2 in scope2s){
			String scope2v = scope2.getText()
			if(scope2v.matches("\\d*\\.?\\d+"))
				println scope2v
			else
				KeywordUtil.markFailedAndStop("!!! Scope 2 progress bar displays empety or null or vaule not displays !!!!!!")
		}
		String scope2totalProg= scope2s.size()
		/******************** Verifying if scope 2 progress bar present inside all the project *******************/
		WebUI.verifyMatch(scope2totalProg,'6', false)


		By scope1val = By.xpath('//div[@class="progress-bar scope1_raw_ghg-bg carbon--progressBar__marginRight"]')
		ArrayList<WebElement> scope1s= driver.findElements(scope1val)
		for (scope1 in scope1s){
			String scope1v = scope1.getText()
			if(scope1v.matches("\\d*\\.?\\d+"))
				println scope1v
			else
				KeywordUtil.markFailedAndStop("!!! Scope 1 progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String scope1totalProg= scope1s.size()
		/******************** Verifying if scope 2 progress bar present inside all the project *******************/
		WebUI.verifyMatch(scope1totalProg,'6', false)

		By transportVal = By.xpath('//div[@class="progress-bar raw_transit-bg carbon--progressBar__marginRight"]')
		ArrayList<WebElement> transvalues= driver.findElements(transportVal)
		for (transvalue in transvalues) {
			String trans = transvalue.getText()
			if(trans.matches("\\d*\\.?\\d+"))
				println trans
			else
				KeywordUtil.markFailedAndStop("!!! Trasnportion progress bar displays empety or null or vaule not displays !!!!!!")
		}
		String transport= transvalues.size()
		/******************** Verifying if transport progress bar present inside all the project *******************/
		WebUI.verifyMatch(transport,'6', false)

	}


	@Keyword
	public void anualCarbonEmession(String sheetName, int rowNum) throws IOException, InterruptedException {

		/************* Total Annual Emissions *****************************************/
		String annualcarconEmession =  data.getCellData(sheetName,"carbonEmission", 10)
		Double annualCarconEmession =  Double.parseDouble(annualcarconEmession)
		String emissionstotaloccupant =  data.getCellData(sheetName,"occupancy", 8)
		String actannualcarconEmession = WebUI.getText(findTestObject('Portfolio/CarbonVal/AnualEmession'))
		WebUI.verifyMatch(actannualcarconEmession, annualcarconEmession,true, FailureHandling.CONTINUE_ON_FAILURE)

		/************* Verifying Emissions per occupant *****************************************/
		String aemessionPerOccupaint = WebUI.getText(findTestObject('Portfolio/CarbonVal/aemessionPerOccupaint'))
		Double emissionsTotaloccupant =  Double.parseDouble(emissionstotaloccupant)
		Double emissionsperoccupant = annualCarconEmession/emissionsTotaloccupant
		int EmessionPer = (int) Math.round(emissionsperoccupant)
		String  cemessionPerOccupaint = EmessionPer.toString()
		println EmessionPer
		WebUI.verifyMatch(aemessionPerOccupaint, cemessionPerOccupaint,true, FailureHandling.CONTINUE_ON_FAILURE)


	}
	@Keyword
	public void annualEmissionsAndEmissionsPeroccupan(String sheetName, int rowNum) throws IOException, InterruptedException {

		String str2 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 1'))
		String str4 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 2'))
		String str1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Energy Emissions'))
		String str3 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Transportation'))

		WebUI.scrollToElement(findTestObject('Portfolio/Common/a_ Analytics'),2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(3)

		String str5 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/TAnnualCarbonEmissions'))
		Double str9 =  Double.parseDouble(str5)
		Double str30 =  str9*6
		BigDecimal str10 = new BigDecimal(str30)
		str10 =  str10 .setScale(1, RoundingMode.HALF_UP)
		String str11 = str10.toString()

		String str6 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/TAnnualScope1'))
		Double str12 =  Double.parseDouble(str6)
		Double str31 =  str12*6
		BigDecimal str13 = new BigDecimal(str31)
		str13 =  str13 .setScale(1, RoundingMode.HALF_UP)
		String str14 = str13.toString()

		String str7 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/TEnergyAnnualScope2'))
		Double str18 =  Double.parseDouble(str7)
		Double str32 =  str18*6
		BigDecimal str15 = new BigDecimal(str32)
		str15 =  str15 .setScale(1, RoundingMode.HALF_UP)
		String str16 = str15.toString()

		String str8 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/TTransportation'))
		Double str26 =  Double.parseDouble(str8)
		Double str33 =  str26*6
		BigDecimal str20 = new BigDecimal(str33)
		str20 =  str20.setScale(1, RoundingMode.HALF_UP)
		String str22 = str20.toString()

		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/PortfolioPorject'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Portfolio/CarbonVal/Page_Arc dashboard/span_Carbon'))
		WebUI.delay(5)
		WebUI.verifyMatch(str2, str14,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(str4, str16,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(str1, str11,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(str3, str22,true, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public void rowsperpage() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/RowPerPage'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Portfolio/CarbonVal/CarbonPage/a_20'),5)
		WebUI.verifyElementPresent(findTestObject('Portfolio/CarbonVal/CarbonPage/a_40'),5)
		WebUI.verifyElementPresent(findTestObject('Portfolio/CarbonVal/CarbonPage/a_50'),5)
		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/a_20'))
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Portfolio/CarbonVal/CarbonPage/span_20'),5)

	}
	@Keyword
	public void projectScoreTest(String sheetName, int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Score/Sort/SortButton'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Energy'))
		WebUI.delay(7)

		String energy1Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy1'))
		String energy2Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy2'))
		String energy3Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy3'))
		String energy4Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy4'))
		String energy5Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy5'))
		String energy6Valule = WebUI.getText(findTestObject('Portfolio/Score/Energy6'))

		String energy1valule=  data.getCellData(sheetName,"energyScore",2)
		String energy2valule=  data.getCellData(sheetName,"energyScore",3)
		String energy3valule=  data.getCellData(sheetName,"energyScore",4)
		String energy4valule=  data.getCellData(sheetName,"energyScore",5)
		String energy5valule=  data.getCellData(sheetName,"energyScore",6)
		String energy6valule=  data.getCellData(sheetName,"energyScore",7)

		WebUI.verifyMatch(energy1Valule, energy1valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(energy2Valule, energy2valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(energy3Valule, energy3valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(energy4Valule, energy4valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(energy5Valule, energy5valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(energy6Valule, energy6valule,true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Water'))
		WebUI.delay(7)

		String water1Valule = WebUI.getText(findTestObject('Portfolio/Score/Water1'))
		String water2Valule = WebUI.getText(findTestObject('Portfolio/Score/Water2'))
		String water3Valule = WebUI.getText(findTestObject('Portfolio/Score/Water3'))
		String water4Valule = WebUI.getText(findTestObject('Portfolio/Score/Water4'))
		String water5Valule = WebUI.getText(findTestObject('Portfolio/Score/Water5'))
		String water6Valule = WebUI.getText(findTestObject('Portfolio/Score/Water6'))

		String water1valule = data.getCellData(sheetName,"waterScore",2)
		String water2valule = data.getCellData(sheetName,"waterScore",3)
		String water3valule = data.getCellData(sheetName,"waterScore",4)
		String water4valule = data.getCellData(sheetName,"waterScore",5)
		String water5valule = data.getCellData(sheetName,"waterScore",6)
		String water6valule = data.getCellData(sheetName,"waterScore",6)

		WebUI.verifyMatch(water1Valule, water1valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(water2Valule, water2valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(water3Valule, water3valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(water4Valule, water4valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(water5Valule, water5valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(water6Valule, water6valule,true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Waste'))
		WebUI.delay(5)

		String waste1Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste1'))
		String waste2Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste2'))
		String waste3Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste3'))
		String waste4Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste4'))
		String waste5Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste5'))
		String waste6Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste6'))

		String waste1valule = data.getCellData(sheetName,"wasteScore",2)
		String waste2valule = data.getCellData(sheetName,"wasteScore",3)
		String waste3valule = data.getCellData(sheetName,"wasteScore",4)
		String waste4valule = data.getCellData(sheetName,"wasteScore",5)
		String waste5valule = data.getCellData(sheetName,"wasteScore",6)
		String waste6valule = data.getCellData(sheetName,"wasteScore",7)

		WebUI.verifyMatch(waste1Valule, waste1valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(waste2Valule, waste2valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(waste3Valule, waste3valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(waste4Valule, waste4valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(waste5Valule, waste5valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(waste6Valule, waste6valule,true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Transportation'))
		WebUI.delay(5)

		String transportation1Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans1'))
		String transportation2Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans2'))
		String transportation3Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans3'))
		String transportation4Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans4'))
		String transportation5Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans5'))
		String transportation6Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans6'))

		String transportation1valule = data.getCellData(sheetName,"transportation",2)
		String transportation2valule = data.getCellData(sheetName,"transportation",3)
		String transportation3valule = data.getCellData(sheetName,"transportation",4)
		String transportation4valule = data.getCellData(sheetName,"transportation",5)
		String transportation5valule = data.getCellData(sheetName,"transportation",6)
		String transportation6valule = data.getCellData(sheetName,"transportation",7)

		WebUI.verifyMatch(transportation1Valule, transportation1valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(transportation2Valule, transportation2valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(transportation3Valule, transportation3valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(transportation4Valule, transportation4valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(transportation5Valule, transportation5valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(transportation6Valule, transportation6valule,true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Human Experience'))
		WebUI.delay(5)

		String humanExperience1Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum1'))
		String humanExperience2Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum2'))
		String humanExperience3Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum3'))
		String humanExperience4Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum4'))
		String humanExperience5Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum5'))
		String humanExperience6Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum6'))

		String humanExperience1valule = data.getCellData(sheetName,"humanExperience",2)
		String humanExperience2valule = data.getCellData(sheetName,"humanExperience",3)
		String humanExperience3valule = data.getCellData(sheetName,"humanExperience",4)
		String humanExperience4valule = data.getCellData(sheetName,"humanExperience",5)
		String humanExperience5valule = data.getCellData(sheetName,"humanExperience",6)
		String humanExperience6valule = data.getCellData(sheetName,"humanExperience",7)

		WebUI.verifyMatch(humanExperience1Valule, humanExperience1valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(humanExperience2Valule, humanExperience2valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(humanExperience3Valule, humanExperience3valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(humanExperience4Valule, humanExperience4valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(humanExperience5Valule, humanExperience5valule,true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(humanExperience6Valule, humanExperience6valule,true, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public void projectScoreFilter(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Project/Filter/span_Filter'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Project/Filter/input_Filter_energy'))
		WebUI.delay(5)
		By energy = By.xpath('//div[@class="progress"]/div[@class="progress-bar energy score--progressBar__marginRight"]')
		ArrayList<WebElement> energys= driver.findElements(energy)
		for (senergy in energys){
			String sEnergy = senergy.getText()
			if(sEnergy.matches("\\d*\\.?\\d+"))
				println sEnergy
			else
				KeywordUtil.markFailedAndStop("!!! Energy progreess bar displays empety or null or vaule not displays !!!!!!")
		}
		String senergy= energys.size()
		/******************** Verifying if Energy progress bar present inside all the project *******************/
		WebUI.verifyMatch(senergy,'6', false)

		/*********************Verify if water , waste ,Transportation and humExp progress bar Should not display ************************/
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProgressBarWater'),2,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProjBarWaste'),2,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProjBarTrans'),2,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProgBarHum'),2,FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Project/Filter/input_water'))
		WebUI.delay(5)

		By water = By.xpath('//div[@class="progress"]/div[@class="progress-bar energy score--progressBar__marginRight"]')
		ArrayList<WebElement> waters= driver.findElements(water)
		for (swater in waters){
			String sWater = swater.getText()
			if(sWater.matches("\\d*\\.?\\d+"))
				println sWater
			else
				KeywordUtil.markFailedAndStop("!!! Water progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String swater= waters.size()
		/******************** Verifying water progress bar present inside all the project *******************/
		WebUI.verifyMatch(swater,'6', false)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProjBarWaste'),2,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProjBarTrans'),2,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(findTestObject('Portfolio/Project/Filter/ProgBarHum'),2,FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/Project/Filter/input_waste'))
		WebUI.delay(5)

		By waste = By.xpath('//div[@class="progress"]/div[@class="progress-bar energy score--progressBar__marginRight"]')
		ArrayList<WebElement> wastes= driver.findElements(waste)
		for (swaste in wastes){
			String sWaste = swaste.getText()
			if(sWaste.matches("\\d*\\.?\\d+"))
				println sWaste
			else
				KeywordUtil.markFailedAndStop("!!! Waste progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String swaste= wastes.size()
		/******************** Verifying waste progress bar present inside all the project *******************/
		WebUI.verifyMatch(swaste,'6', false)

		WebUI.click(findTestObject('Portfolio/Project/Filter/input_transport'))
		WebUI.delay(5)

		By transport = By.xpath('//div[@class="progress-bar transport score--progressBar__marginRight"]')
		ArrayList<WebElement> transports= driver.findElements(transport)
		for (stransport in transports){
			String sTransport = stransport.getText()
			if(sTransport.matches("\\d*\\.?\\d+"))
				println sTransport
			else
				KeywordUtil.markFailedAndStop("!!! Transport progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String stransport= transports.size()
		/******************** Verifying if transportation progress bar present inside all the project *******************/
		WebUI.verifyMatch(stransport,'6', false)

		WebUI.click(findTestObject('Portfolio/Project/Filter/human_exp'))
		WebUI.delay(5)

		By humExp = By.xpath('//div[@class="progress-bar human_experience score--progressBar__marginRight"]')
		ArrayList<WebElement> humExps= driver.findElements(humExp)
		for (shumExp in humExps){
			String shumExperiance = shumExp.getText()
			if(shumExperiance.matches("\\d*\\.?\\d+"))
				println shumExperiance
			else
				KeywordUtil.markFailedAndStop("!!! Human Exp progreess bar displays empety  or null or vaule not displays !!!!!!")
		}
		String sHumExperiance= humExps.size()
		/******************** Verifying if Human Exp progress bar present inside all the project *******************/
		WebUI.verifyMatch(sHumExperiance,'6', false)

	}
	@Keyword
	public void projectScoreOutOf100(String sheetName, int rowNum) throws IOException, InterruptedException {
		//	WebUI.scrollToElement(findTestObject('Portfolio/Project/Filter/Performance Weighted Scor'),2)
		WebUI.delay(7)
		WebUI.click(findTestObject('Portfolio/Project/Filter/Button_100 Point Score'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Project/Filter/100 Point Score'))
		WebUI.delay(5)

		WebUI.click(findTestObject('Portfolio/Score/Sort/SortButton'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Energy'))
		WebUI.delay(7)

		String Energy1Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy1'))
		Integer energy1Valule = Integer.parseInt(Energy1Valule)

		String Energy2Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy2'))
		Integer energy2Valule = Integer.parseInt(Energy2Valule)

		String Energy3Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy3'))
		Integer energy3Valule = Integer.parseInt(Energy3Valule)

		String Energy4Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy4'))
		Integer energy4Valule = Integer.parseInt(Energy4Valule)

		String Energy5Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy5'))
		Integer energy5Valule = Integer.parseInt(Energy5Valule)

		String Energy6Valule =  WebUI.getText(findTestObject('Portfolio/Score/Energy6'))
		Integer energy6Valule = Integer.parseInt(Energy6Valule)

		ArrayList<Integer> energy = new ArrayList<Integer>()
		energy.add(energy1Valule)
		energy.add(energy2Valule)
		energy.add(energy3Valule)
		energy.add(energy4Valule)
		energy.add(energy5Valule)
		energy.add(energy6Valule)

		Collections.sort(energy)
		println energy
		Collections.reverse(energy)


		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				WebUI.verifyMatch(Energy1Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==1){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				WebUI.verifyMatch(Energy2Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==2){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				WebUI.verifyMatch(Energy3Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==3){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				WebUI.verifyMatch(Energy4Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==4){
				System.out.println(energy.get(i))
				String highest = energy.get(i)
				WebUI.verifyMatch(Energy5Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==5){
				System.out.println(energy.get(i))
				String  highest = energy.get(i)
				WebUI.verifyMatch(Energy6Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)


			}

		}

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Water'))
		WebUI.delay(7)

		String Water1Valule = WebUI.getText(findTestObject('Portfolio/Score/Water1'))
		Integer water1Valule = Integer.parseInt(Water1Valule)

		String Water2Valule = WebUI.getText(findTestObject('Portfolio/Score/Water2'))
		Integer water2Valule = Integer.parseInt(Water2Valule)

		String Water3Valule = WebUI.getText(findTestObject('Portfolio/Score/Water3'))
		Integer water3Valule = Integer.parseInt(Water3Valule)

		String Water4Valule = WebUI.getText(findTestObject('Portfolio/Score/Water4'))
		Integer water4Valule = Integer.parseInt(Water4Valule)

		String Water5Valule = WebUI.getText(findTestObject('Portfolio/Score/Water5'))
		Integer water5Valule = Integer.parseInt(Water5Valule)

		String Water6Valule = WebUI.getText(findTestObject('Portfolio/Score/Water6'))
		Integer water6Valule = Integer.parseInt(Water6Valule)


		ArrayList<Integer> water = new ArrayList<Integer>()
		water.add(water1Valule)
		water.add(water2Valule)
		water.add(water3Valule)
		water.add(water4Valule)
		water.add(water5Valule)
		water.add(water6Valule)

		Collections.sort(water)
		println water
		Collections.reverse(water)
		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println(water.get(i))
				String highest = water.get(i)
				WebUI.verifyMatch(Water1Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==1){
				System.out.println(water.get(i))
				String highest = water.get(i)
				WebUI.verifyMatch(Water2Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==2){
				System.out.println(water.get(i))
				String highest = water.get(i)
				WebUI.verifyMatch(Water3Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==3){
				System.out.println(water.get(i))
				String highest = water.get(i)
				WebUI.verifyMatch(Water4Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==4){
				System.out.println(water.get(i))
				String highest = water.get(i)
				WebUI.verifyMatch(Water5Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==5){
				System.out.println(water.get(i))
				String  highest = water.get(i)
				WebUI.verifyMatch(Water6Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)


			}

		}


		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Waste'))
		WebUI.delay(7)

		String Waste1Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste1'))
		Integer waste1Valule = Integer.parseInt(Waste1Valule)

		String Waste2Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste2'))
		Integer waste2Valule = Integer.parseInt(Waste2Valule)

		String Waste3Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste3'))
		Integer waste3Valule = Integer.parseInt(Waste3Valule)

		String Waste4Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste4'))
		Integer waste4Valule = Integer.parseInt(Waste4Valule)

		String Waste5Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste5'))
		Integer waste5Valule = Integer.parseInt(Waste5Valule)

		String Waste6Valule = WebUI.getText(findTestObject('Portfolio/Score/Waste6'))
		Integer waste6Valule = Integer.parseInt(Waste6Valule)

		ArrayList<Integer> waste = new ArrayList<Integer>()
		waste.add(waste1Valule)
		waste.add(waste2Valule)
		waste.add(waste3Valule)
		waste.add(waste4Valule)
		waste.add(waste5Valule)
		waste.add(waste6Valule)

		Collections.sort(waste)
		println waste
		Collections.reverse(waste)


		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				WebUI.verifyMatch(Waste1Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==1){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				WebUI.verifyMatch(Waste2Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==2){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				WebUI.verifyMatch(Waste3Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==3){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				WebUI.verifyMatch(Waste4Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==4){
				System.out.println(waste.get(i))
				String highest = waste.get(i)
				WebUI.verifyMatch(Waste5Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==5){
				System.out.println(waste.get(i))
				String  highest = waste.get(i)
				WebUI.verifyMatch(Waste6Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)


			}

		}


		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Transportation'))
		WebUI.delay(5)

		String Transportation1Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans1'))
		Integer transportation1Valule = Integer.parseInt(Transportation1Valule)

		String Transportation2Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans2'))
		Integer transportation2Valule = Integer.parseInt(Transportation2Valule)

		String Transportation3Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans3'))
		Integer transportation3Valule = Integer.parseInt(Transportation3Valule)

		String Transportation4Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans4'))
		Integer transportation4Valule = Integer.parseInt(Transportation4Valule)

		String Transportation5Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans5'))
		Integer transportation5Valule = Integer.parseInt(Transportation5Valule)

		String Transportation6Valule = WebUI.getText(findTestObject('Portfolio/Score/Trans6'))
		Integer transportation6Valule = Integer.parseInt(Transportation6Valule)


		ArrayList<Integer> transportation = new ArrayList<Integer>()
		transportation.add(transportation1Valule)
		transportation.add(transportation2Valule)
		transportation.add(transportation3Valule)
		transportation.add(transportation4Valule)
		transportation.add(transportation5Valule)
		transportation.add(transportation6Valule)

		Collections.sort(transportation)
		println transportation
		Collections.reverse(transportation)


		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				WebUI.verifyMatch(Transportation1Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==1){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				WebUI.verifyMatch(Transportation2Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==2){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				WebUI.verifyMatch(Transportation3Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==3){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				WebUI.verifyMatch(Transportation4Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==4){
				System.out.println(transportation.get(i))
				String highest = transportation.get(i)
				WebUI.verifyMatch(Transportation5Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==5){
				System.out.println(transportation.get(i))
				String  highest = transportation.get(i)
				WebUI.verifyMatch(Transportation6Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)


			}

		}

		WebUI.click(findTestObject('Portfolio/Score/Sort/li_Human Experience'))
		WebUI.delay(5)

		String HumanExperience1Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum1'))
		Integer humanExperience1Valule = Integer.parseInt(HumanExperience1Valule)

		String HumanExperience2Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum2'))
		Integer humanExperience2Valule = Integer.parseInt(HumanExperience2Valule)

		String HumanExperience3Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum3'))
		Integer humanExperience3Valule = Integer.parseInt(HumanExperience3Valule)

		String HumanExperience4Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum4'))
		Integer humanExperience4Valule = Integer.parseInt(HumanExperience4Valule)

		String HumanExperience5Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum5'))
		Integer humanExperience5Valule = Integer.parseInt(HumanExperience5Valule)

		String HumanExperience6Valule = WebUI.getText(findTestObject('Portfolio/Score/Hum6'))
		Integer humanExperience6Valule = Integer.parseInt(HumanExperience6Valule)

		ArrayList<Integer>humanExperience= new ArrayList<Integer>()
		humanExperience.add( humanExperience1Valule)
		humanExperience.add( humanExperience2Valule)
		humanExperience.add( humanExperience3Valule)
		humanExperience.add( humanExperience4Valule)
		humanExperience.add( humanExperience5Valule)
		humanExperience.add( humanExperience6Valule)

		Collections.sort( humanExperience)
		println  humanExperience
		Collections.reverse( humanExperience)


		for(int i = 0; i <=5; i++) {
			if(i==0){
				System.out.println( humanExperience.get(i))
				String highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience1Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==1){
				System.out.println( humanExperience.get(i))
				String highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience2Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==2){
				System.out.println( humanExperience.get(i))
				String highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience3Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(i==3){
				System.out.println( humanExperience.get(i))
				String highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience4Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==4){
				System.out.println( humanExperience.get(i))
				String highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience5Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)

			}
			if(i==5){
				System.out.println( humanExperience.get(i))
				String  highest =  humanExperience.get(i)
				WebUI.verifyMatch(HumanExperience6Valule, highest,true, FailureHandling.CONTINUE_ON_FAILURE)


			}

		}

	}

	@Keyword
	public void totalcarbonScope1Scope2AnnualTrans(String sheetName, int rowNum) throws IOException, InterruptedException {

		String Scope1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 1'))
		String Scope2 = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 2'))
		String AnnualEnergy = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Energy Emissions'))
		String transportation = WebUI.getText(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Transportation'))

		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 1'))
		WebUI.delay(3)

		String Scope1Valule1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/First'))
		Double Scope1value1 = Double.parseDouble(Scope1Valule1)
		String Scope1Valule2= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/second'))
		Double Scope1value2 = Double.parseDouble(Scope1Valule2)
		String Scope1Valule3= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Third'))
		Double Scope1value3 = Double.parseDouble(Scope1Valule3)
		String Scope1Valule4= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Four'))
		Double Scope1value4 = Double.parseDouble(Scope1Valule4)
		String Scope1Valule5= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Fifth'))
		Double Scope1value5 = Double.parseDouble(Scope1Valule5)
		String Scope1Valule6= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Sixth'))
		Double Scope1value6 = Double.parseDouble(Scope1Valule6)

		WebUI.click(findTestObject('Portfolio/CarbonVal/Carbon/Cancel'))
		WebUI.delay(2)

		Double Scope1totalValue = Scope1value1 + Scope1value2 + Scope1value3 + Scope1value4 + Scope1value5 + Scope1value6
		BigDecimal Scope1totalvalue = new BigDecimal(Scope1totalValue)
		Scope1totalvalue =  Scope1totalvalue.setScale(1, RoundingMode.HALF_UP)

		String calculatedScope1 =  Scope1totalvalue.toString()
		WebUI.verifyMatch(Scope1, calculatedScope1,true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Scope 2'))
		WebUI.delay(3)

		String Scope2Valule1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/First'))
		Double Scope2value1 = Double.parseDouble(Scope2Valule1)
		String Scope2Valule2= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/second'))
		Double Scope2value2 = Double.parseDouble(Scope2Valule2)
		String Scope2Valule3= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Third'))
		Double Scope2value3 = Double.parseDouble(Scope2Valule3)
		String Scope2Valule4= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Four'))
		Double Scope2value4 = Double.parseDouble(Scope2Valule4)
		String Scope2Valule5= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Fifth'))
		Double Scope2value5 = Double.parseDouble(Scope2Valule5)
		String Scope2Valule6= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Sixth'))
		Double Scope2value6 = Double.parseDouble(Scope2Valule6)

		WebUI.click(findTestObject('Portfolio/CarbonVal/Carbon/Cancel'))
		WebUI.delay(2)

		Double Scope2totalValue = Scope2value1 + Scope2value2 + Scope2value3 + Scope2value4 + Scope2value5 + Scope2value6
		BigDecimal Scope2totalvalue = new BigDecimal(Scope2totalValue)
		Scope2totalvalue =  Scope2totalvalue.setScale(1, RoundingMode.HALF_UP)

		String calculatedScope2 =  Scope2totalvalue.toString()
		WebUI.verifyMatch(Scope2, calculatedScope2,true,FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Energy Emissions'))
		WebUI.delay(3)

		String AnnualEnergyValule1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/First'))
		Double AnnualEnergyvalue1 = Double.parseDouble(AnnualEnergyValule1)
		String AnnualEnergyValule2= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/second'))
		Double AnnualEnergyvalue2 = Double.parseDouble(AnnualEnergyValule2)
		String AnnualEnergyValule3= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Third'))
		Double AnnualEnergyvalue3 = Double.parseDouble(AnnualEnergyValule3)
		String AnnualEnergyValule4= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Four'))
		Double AnnualEnergyvalue4 = Double.parseDouble(AnnualEnergyValule4)
		String AnnualEnergyValule5= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Fifth'))
		Double AnnualEnergyvalue5 = Double.parseDouble(AnnualEnergyValule5)
		String AnnualEnergyValule6= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Sixth'))
		Double AnnualEnergyvalue6 = Double.parseDouble(AnnualEnergyValule6)

		WebUI.click(findTestObject('Portfolio/CarbonVal/Carbon/Cancel'))
		WebUI.delay(2)

		Double AnnualEnergytotalValue = AnnualEnergyvalue1 + AnnualEnergyvalue2 + AnnualEnergyvalue3 + AnnualEnergyvalue4 + AnnualEnergyvalue5 + AnnualEnergyvalue6
		BigDecimal cAnnualEnergytotalvalue = new BigDecimal(AnnualEnergytotalValue)
		cAnnualEnergytotalvalue =  cAnnualEnergytotalvalue.setScale(1, RoundingMode.HALF_UP)
		String cannualEnergytotalvalue = cAnnualEnergytotalvalue.toString()

		Double scope1AndScope2 = Scope1totalValue + Scope2totalValue
		BigDecimal cscope1AndScope2 = new BigDecimal(scope1AndScope2)
		cscope1AndScope2 =  cscope1AndScope2.setScale(1, RoundingMode.HALF_UP)
		String Cscope1AndScope2 = cscope1AndScope2.toString()

		WebUI.verifyMatch(AnnualEnergy, Cscope1AndScope2,true, FailureHandling.CONTINUE_ON_FAILURE)

		/****************Calculating total Annual Emission form total project*****************************/
		WebUI.verifyMatch(AnnualEnergy, cannualEnergytotalvalue, true, FailureHandling.CONTINUE_ON_FAILURE)


		WebUI.click(findTestObject('Portfolio/CarbonVal/CarbonPage/Annual Transportation'))
		WebUI.delay(2)

		String transportationValule1 = WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/First'))
		Double transportationvalue1 = Double.parseDouble(transportationValule1)
		String transportationValule2= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/second'))
		Double transportationvalue2 = Double.parseDouble(transportationValule2)
		String transportationValule3= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Third'))
		Double transportationvalue3 = Double.parseDouble(transportationValule3)
		String transportationValule4= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Four'))
		Double transportationvalue4 = Double.parseDouble(transportationValule4)
		String transportationValule5= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Fifth'))
		Double transportationvalue5 = Double.parseDouble(transportationValule5)
		String transportationValule6= WebUI.getText(findTestObject('Portfolio/CarbonVal/Carbon/Sixth'))
		Double transportationvalue6 = Double.parseDouble(transportationValule6)

		WebUI.click(findTestObject('Portfolio/CarbonVal/Carbon/Cancel'))
		WebUI.delay(2)

		Double TransportationtotalValue = transportationvalue1 + transportationvalue2 + transportationvalue3 + transportationvalue4 + transportationvalue5 + transportationvalue6
		BigDecimal transportationTotalValue = new BigDecimal(TransportationtotalValue)
		transportationTotalValue =  transportationTotalValue.setScale(1, RoundingMode.HALF_UP)

		String transportationtotalValue = transportationTotalValue.toString()
		WebUI.verifyMatch(transportation, transportationtotalValue,true, FailureHandling.CONTINUE_ON_FAILURE)



	}

	@Keyword
	public void totalcarbonPageScoreSorting(String sheetName, int rowNum) throws IOException, InterruptedException {

		WebUI.click(findTestObject('Portfolio/Common/Project'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Portfolio/CarbonVal/ProjectFil/ClickSocre'))
		WebUI.delay(5)

		for(int count =1;count<=6;count++) {
			if(count==1) {
				int row =2
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==2) {
				int row =3
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==3) {
				int row = 4
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==4) {
				int row =5
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==5) {
				int row =6
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==6) {
				int row =7
				String totalScore = data.getCellData(sheetName, "totalScore", row)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[7]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
		}

	}
	@Keyword
	public void projectCertifiedProjectDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/CarbonVal/ProjectFil/FilterButtion'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/CarbonVal/ProjectFil/Platinum'))
		WebUI.delay(2)
		By noOfCertProj = By.xpath("//table[@class='table table-sorted arcTbl']//td[4]")
		ArrayList<WebElement> noOfCertifiedProj= driver.findElements(noOfCertProj)
		for (noOfCertifiedProjs in noOfCertifiedProj){
			String NoOfCertifiedProjs = noOfCertifiedProjs.getText()
			println NoOfCertifiedProjs
		}
		String CnoOfCertifiedProj= noOfCertifiedProj.size()
		/******************** Verifying if scope 1 progress bar present inside all the project *******************/
		WebUI.verifyMatch(CnoOfCertifiedProj,'2', false)

	}
	@Keyword
	public void projectSIDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/CarbonVal/ProjectFil/SIButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/SQMile'))
		WebUI.delay(2)

		String totalFloorAreaSI = data.getCellData(sheetName,"AreaSI",9)
		String totalCertifiedAreaSI = data.getCellData(sheetName,"AreaSI",10)

		String totalGrossArea = WebUI.getText(findTestObject('Portfolio/Common/TotalGrossArea'))
		WebUI.verifyMatch(totalGrossArea,totalFloorAreaSI,true,FailureHandling.CONTINUE_ON_FAILURE)
		println  "Total Gross Floor Area verified Successfully"

		String  CertifiedArea = WebUI.getText(findTestObject('Portfolio/Common/TotalCertifiedArea'))
		WebUI.verifyMatch(totalCertifiedAreaSI,CertifiedArea,true,FailureHandling.CONTINUE_ON_FAILURE)
		System.out.println(totalCertifiedAreaSI)

	}

	@Keyword
	public void downloadPortfolioExport(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.verifyElementPresent(findTestObject('Portfolio/CarbonVal/ProjectFil/ExportPortfolio'),2)
		WebUI.click(findTestObject('Portfolio/CarbonVal/ProjectFil/ExportPortfolio'))
		WebUI.delay(5)
		ReusableMethodsDataInput reusableMethodsDataInput = new ReusableMethodsDataInput()
		Assert.assertTrue(reusableMethodsDataInput.isFileDownloaded('Portfolio Export.xlsx'), 'Failed to download Expected document')

	}
	@Keyword
	public void totalAnnualCarbonEmissionsCalculation() throws IOException, InterruptedException
	{
		/*WebUI.scrollToElement(findTestObject('Portfolio/Common/a_ Analytics'),2)
		 WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		 WebUI.delay(2)
		 */
		WebUI.scrollToElement(findTestObject('Portfolio/Common/a_ Total'),2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "Verifying TOTAL ANNUAL CARBON EMISSIONS (MTCO2e): For Project"
		WebUI.scrollToElement(findTestObject('Object Repository/Portfolio/CarbonVal/TotalPortfolio'),4)
		String  str1= WebUI.getText(findTestObject('Object Repository/Portfolio/CarbonVal/TotalPortfolio'))

		String mtco2c =  str1.replace(',', '')
		Double CTotal= Double.parseDouble(mtco2c)
		BigDecimal AtotalMtco2e = new BigDecimal(CTotal)
		AtotalMtco2e = AtotalMtco2e .setScale(2, RoundingMode.HALF_UP)
		String totalCaron = AtotalMtco2e.toString()

		String  str2=WebUI.getText(findTestObject('Portfolio/Total/carbon/CTEScope1'))
		String scpoe1 =  str2.replace(',', '')
		Double CTEScope1 = Double.parseDouble(scpoe1)
		System.out.println(CTEScope1)

		String  str3=WebUI.getText(findTestObject('Portfolio/Total/carbon/CTEScope2'))
		String scpoe2 =  str3.replace(',', '')
		Double CTEScope2 = Double.parseDouble(scpoe2)
		System.out.println(CTEScope2)

		String  str4=WebUI.getText(findTestObject('Portfolio/Total/carbon/CTTransportion'))
		String trasport =  str4.replace(',', '')

		Double CTTransportion = Double.parseDouble(trasport)
		System.out.println(CTTransportion)

		Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion

		BigDecimal totalMtco2e = new BigDecimal(TotalCarbon)
		totalMtco2e = totalMtco2e .setScale(2, RoundingMode.HALF_UP)
		String ctotalMtco2e = totalMtco2e.toString()
		System.out.println(totalMtco2e)
		WebUI.verifyMatch(totalCaron, ctotalMtco2e, false)
	}
	@Keyword
	public void verifyAnlyticsEDailiyMTCO2e() throws IOException, InterruptedException{
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
			pden = pden.setScale(2, RoundingMode.HALF_UP)
			String calcuated = pden.toString()
			System.out.println(calcuated)

			String dailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/Dailycarbon'))
			WebUI.verifyMatch(dailyCarbon, calcuated, false)

			println  "Verified Project Energy Daily Carbon Emissions successully"
			println 'Test Passed'

			println 'TEST STARTED ENERGY PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)'
			String  pstr1=WebUI.getText(findTestObject('Portfolio/Total/carbon/BPAnualcarbon'))

			System.out.println(pstr1)
			double epdaily=Double.parseDouble(pstr1)/365

			BigDecimal epden = new BigDecimal(epdaily)
			epden = epden.setScale(2, RoundingMode.HALF_UP)
			System.out.println(epden)
			String pcalcuated = epden.toString()
			if(pcalcuated=="0.00")
				pcalcuated = '0'

			String epdailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/BPDailycarbon'))

			WebUI.verifyMatch(epdailyCarbon, pcalcuated, false)

			println  "Verified PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)"
			println  "Test Passed"

			println "TEST STARTED ENERGY PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)"
			String  ostr1=WebUI.getText(findTestObject('Portfolio/Total/carbon/OAnualcarbon'))
			System.out.println(ostr1)
			double eodaily=Double.parseDouble(ostr1)/365
			BigDecimal eoden = new BigDecimal(eodaily)
			eoden = eoden.setScale(2, RoundingMode.HALF_UP)
			String pocccalcuated = eoden.toString()

			String eodailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/ODailycarbon'))
			WebUI.verifyMatch(eodailyCarbon, pocccalcuated, false)
			println  "Verified PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully"
			WebUI.delay(2)
		}
	}
	@Keyword
	public void verifyWDailiyWaterConsumption() throws IOException, InterruptedException{

		//WebUI.delay(10)
		println "TEST STARTED WATER PROJECT(TOTAL DAILY  WATER CONSUMPTION=TOTAL ANNUAL WATER CONSUMPTION/365)"
		String  str1=WebUI.getText(findTestObject('Portfolio/Total/carbon/WAnualcarbon'))
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
			pden = pden.setScale(2, RoundingMode.HALF_UP)
			String cdailyCarbon = pden.toString()
			System.out.println(cdailyCarbon)
			String dailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/WDailycarbon'))
			WebUI.verifyMatch(dailyCarbon, cdailyCarbon, true,FailureHandling.CONTINUE_ON_FAILURE)
			println  "Verified Project Water Daily CONSUMPTION successully"
			println  "Test Passed"

			println "TEST STARTED Water PER SQ FT(TOTAL DAILY CONSUMPTION =TOTAL ANNUAL CONSUMPTION /365)"
			String  pstr1=WebUI.getText(findTestObject('Portfolio/Total/carbon/WPAnualcarbon'))
			String pstr6 =  pstr1.replace(',', '')
			double epdaily=Double.parseDouble(pstr6)/365
			BigDecimal epden = new BigDecimal(epdaily)
			epden = epden.setScale(2, RoundingMode.HALF_UP)
			String cwaterDailySF = epden.toString()
			String epdailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/WPDailycarbon'))
			if(cwaterDailySF=="0.00")
				cwaterDailySF = '0'
			System.out.println(cwaterDailySF)
			WebUI.verifyMatch(epdailyCarbon, cwaterDailySF, true, FailureHandling.CONTINUE_ON_FAILURE)
			println  "Verified Water PER SQ FT DAILY CONSUMPTION "
			println  "Test Passed"

			println "TEST STARTED Water PER OCC(TOTAL DAILY WATER CONSUMPTION =TOTAL ANNUAL WATER CONSUMPTION/365)"
			String  ostr1=WebUI.getText(findTestObject('Portfolio/Total/carbon/WOAnualcarbon'))
			String ostr6 =  ostr1.replace(',', '')
			System.out.println(ostr6)
			double eodaily=Double.parseDouble(ostr6)/365
			BigDecimal eoden = new BigDecimal(eodaily)
			eoden = eoden.setScale(2, RoundingMode.HALF_UP)
			String waterOcc = eoden.toString()

			String eodailyCarbon =WebUI.getText(findTestObject('Portfolio/Total/carbon/WODailycarbon'))
			System.out.println(eoden)
			WebUI.verifyMatch(eodailyCarbon, waterOcc, true, FailureHandling.CONTINUE_ON_FAILURE)
			println "Verified Water PER OCC DAILY WATER CONSUMPTION Successfully"
		}
	}

	@Keyword
	public void dailyCarbonEmissionstr() throws IOException, InterruptedException{
		String  str4=WebUI.getText(findTestObject('Portfolio/Total/carbon/CTTransportion'))
		String trasport =  str4.replace(',', '')

		double trasnportDay=Double.parseDouble(trasport)/365
		System.out.println(trasnportDay)

		BigDecimal trasnportday = new BigDecimal(trasnportDay)
		trasnportday = trasnportday.setScale(2, RoundingMode.HALF_UP)
		String ctrasnportDay = trasnportday.toString()
		String actualtransport = WebUI.getText(findTestObject('Portfolio/Total/carbon/transport'))
		WebUI.verifyMatch(actualtransport, ctrasnportDay, false)

	}

	@Keyword
	public void avgOperatingHour(String sheetName, int rowNum ) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		String avgOpp =  data.getCellData(sheetName,"OppHour",15)
		double davgOppc = Double.parseDouble(avgOpp)
		int avgOppHour = Math.round(davgOppc)
		String cavgOppHour = avgOppHour.toString()
		String calhours = cavgOppHour.concat(" hours")
		String UIavgOppHour = WebUI.getText(findTestObject('Object Repository/Portfolio/Common/Analytic/AvgOppHour'))
		WebUI.verifyMatch(UIavgOppHour,calhours,false)
		println "Average Operating Hour verified Successfully"
	}

	@Keyword
	public void avgOccupancy(String sheetName, int rowNum ) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))

		String avgOcc =  data.getCellData(sheetName,"occupancy",15)
		double davgOcc = Double.parseDouble(avgOcc)
		int avgOccroundOff = Math.round(davgOcc)
		String calavgOcc = avgOccroundOff.toString()
		String caloccupants = calavgOcc.concat(" occupants")
		String UIAvgoccupancy = WebUI.getText(findTestObject('Portfolio/Common/Analytic/AvgOcc'))
		WebUI.verifyMatch(UIAvgoccupancy,caloccupants,false)
		println "Average Occupancy verified Successfully"
	}

	@Keyword
	public void avgArea(String sheetName, int rowNum ) throws IOException, InterruptedException {

		WebUI.scrollToElement(findTestObject('Portfolio/Common/a_ Analytics'),2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		String avgArea =  data.getCellData(sheetName,"Area",15)
		double davgAreac = Double.parseDouble(avgArea)
		int avgArearoundOff = Math.round(davgAreac)
		String calavgArea = avgArearoundOff.toString()
		String calavgAreasf = calavgArea.concat(" sf")
		String UIavgArea = WebUI.getText(findTestObject('Portfolio/Common/Analytic/AvgArea'))
		WebUI.verifyMatch(UIavgArea,calavgAreasf,false)
		println "Average Area verified Successfully"
	}



}


