package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.arc.BaseClass.BaseClass
import com.arc.BaseClass.CommonMethod
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ReusableMethodsAddNewProject extends BaseClass{
	ReusableMethodsNavigation navigation = new ReusableMethodsNavigation()
	SimpleDateFormat formatarDate = new SimpleDateFormat(' HH:mm:ss')
	@Keyword
	public void buildingAddNewProject(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String spaceType    = data.getCellData(sheetName, "SpaceType", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);

		String proName
		if(sheetName.equalsIgnoreCase("USBuildingProject")){
			proName="USBuilding"
		}
		else if(sheetName.equalsIgnoreCase("ChinaBuildingProject")){
			proName="CHBuilding"
		}
		else if(sheetName.equalsIgnoreCase("BuildingIndiaProject")){
			proName="INDBuilding"
		}
		else{
			proName="CNBuilding"
		}
		//String proName= prjName.substring(0, 9)
		String ProjectName = proName +prjRating +formatarDate.format(date)
		data.setCellData(sheetName,"ProjectName", rowNum, ProjectName)

		navigation.clickAddProject()

		WebUI.sendKeys(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select space type'),spaceType,true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_gross_area'),prjArea )
		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.delay(2)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, false)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		//String PaymentPageText = WebUI.getText(findTestObject('Add_Project_Details/VerifyPaymentPage_ text'))
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/ProjectDetailsAssertionText'))
		WebUI.verifyMatch(PaymentPageText,'Project Details',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"ProjectID", rowNum, Project_ID)
		data.setCellData(sheetName,"RegDate", rowNum, ReusableMethodsManage.verifyBillingDate())
		WebUI.delay(5)
	}



	@Keyword
	public void buildingTransitAddNewProject(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String prjName          = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjType 		    = data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating    	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String spaceType        = data.getCellData(sheetName, "SpaceType", rowNum);
		String annualRider      = data.getCellData(sheetName, "annual_ridership", rowNum);
		String weekOprhrs       = data.getCellData(sheetName, "week_opr_hrs", rowNum);
		String fullTimeStaff    = data.getCellData(sheetName, "fulltime_staff", rowNum);
		String avgtimeSpent     = data.getCellData(sheetName, "avg_time_spent", rowNum);
		String ownerOrg 	    = data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	    = data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry     = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	    = data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		    = data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	    = data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		    = data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	    = data.getCellData(sheetName, "Country", rowNum);
		String prjState 	    = data.getCellData(sheetName, "State", rowNum);
		String prjZip 		    = data.getCellData(sheetName, "Zip", rowNum);
		String isStation 		= data.getCellData(sheetName, "is_station", rowNum);

		String proName
		if(sheetName.equalsIgnoreCase("USBuildingProject")){
			proName="USBuilding"
		}
		else if(sheetName.equalsIgnoreCase("ChinaBuildingProject")){
			proName="CHBuilding"
		}
		else if(sheetName.equalsIgnoreCase("BuildingIndiaProject")){
			proName="INDBuilding"
		}
		else{
			proName="CNBuilding"
		}

		String ProjectName = proName +prjRating +formatarDate.format(date)
		data.setCellData(sheetName,"ProjectName", rowNum, ProjectName)
		navigation.clickAddProject()
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/AddProjectBuildingTransit/select_Select space typeAirpor'),spaceType, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/AddProjectBuildingTransit/select_SelectUndergroundAbove'),isStation, false)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_annual_ridership'), annualRider)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_operatingHours'), weekOprhrs)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_full_time_staff'), fullTimeStaff)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_time_spent_by_riders'), avgtimeSpent)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/AddProjectBuildingTransit/select_Select Owner TypeBusine'),ownerType, false)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_owner_email'), ownerMail)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_gross_area'), prjArea)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'), prjState, false)
		WebUI.setText(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/AddProjectBuildingTransit/input_reg_agreement'))
		WebUI.delay(2)
		WebUI.doubleClick(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(8)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/ProjectDetailsAssertionText'))
		WebUI.verifyMatch(PaymentPageText,'Project Details',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"ProjectID", rowNum, Project_ID)
		data.setCellData(sheetName,"RegDate", rowNum, ReusableMethodsManage.verifyBillingDate())
		WebUI.delay(5)
	}



	@Keyword
	public void addNewProjectCityORCom(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum)
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum)
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum)
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum)
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum)
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum)
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum)
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum)
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum)
		String prjCity 		= data.getCellData(sheetName, "City", rowNum)
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum)
		String prjState 	= data.getCellData(sheetName, "State", rowNum)
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum)


		String proName
		if(sheetName.equalsIgnoreCase("USCityProject")){
			proName="USCity"
		}
		else if(sheetName.equalsIgnoreCase("ChinaCityProject")){
			proName="CHCity"
		}
		else if (sheetName.equalsIgnoreCase("CanadaCityProject")) {
			proName="CNCity"
		}
		else if(sheetName.equalsIgnoreCase("CityIndiaProject")){
			proName="INDCity"
		}
		else if(sheetName.equalsIgnoreCase("USCommunityProject")){
			proName="USComm"
		}
		else if(sheetName.equalsIgnoreCase("ChinaCommunityProject")){
			proName="CHComm"
		}
		else if(sheetName.equalsIgnoreCase("CommunityIndiaProject")){
			proName="INDComm"
		}
		else{
			proName="CNComm"
		}

		String ProjectName = proName + prjRating + formatarDate.format(date)
		data.setCellData(sheetName,"ProjectName", rowNum, ProjectName)
		navigation.clickAddProject()
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		//WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		//WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		//WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		//WebUI.delay(2)
		//WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		//WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		//WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_gross_area'),prjArea )
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_occupancy'),prjPopulation)
		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, true)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/strong_Promotional Code'))
		WebUI.verifyMatch(PaymentPageText,'Promotional Code',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"ProjectID", rowNum, Project_ID)
		data.setCellData(sheetName,"RegDate", rowNum, ReusableMethodsManage.verifyBillingDate())
		WebUI.delay(5)
	}
	@Keyword
	public void parkingAddNewProject(String sheetName , int rowNum) {
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String parkingSpaces = data.getCellData(sheetName, "no_park_space", rowNum);
		String parkingStructure=  data.getCellData(sheetName, "park_level", rowNum);
		String dataCommisioned= data.getCellData(sheetName, "date_comm", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);


		String proName
		if(sheetName.equalsIgnoreCase("USBuildingProject")){
			proName="USParking"
		}
		else if(sheetName.equalsIgnoreCase("ChinaBuildingProject")){
			proName="CHParking"
		}
		else if(sheetName.equalsIgnoreCase("BuildingIndiaProject")){
			proName="INDParking"
		}
		else{
			proName="CNParking"
		}

		String ProjectName = proName +prjRating +formatarDate.format(date)
		data.setCellData(sheetName,"ProjectName", rowNum, ProjectName)

		navigation.clickAddProject()

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_noOfParkingSpace'),parkingSpaces )

		WebUI.setText(findTestObject('Add_Project_Details/input_noOfParkingLevels'),parkingStructure)
		WebUI.setText(findTestObject('Add_Project_Details/input_year_constructed'),dataCommisioned)
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/input_year_constructed'))

		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, true)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/strong_Promotional Code'))
		WebUI.verifyMatch(PaymentPageText,'Promotional Code',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"ProjectID", rowNum, Project_ID)
		data.setCellData(sheetName,"RegDate", rowNum, ReusableMethodsManage.verifyBillingDate())
		data.setCellData(sheetName,"Date", rowNum, ReusableMethodsManage.verifyBillingDate())
		WebUI.delay(5)
		WebUI.delay(5)
	}
}