import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/BuildingSuites/BuildingNone/USBuildingNoneSuite/USBuildingNoneSuite')

suiteProperties.put('name', 'USBuildingNoneSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("E:\\Azure\\Azure\\Reports\\BuildingSuites\\BuildingNone\\USBuildingNoneSuite\\USBuildingNoneSuite\\20190117_022849\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/BuildingSuites/BuildingNone/USBuildingNoneSuite/USBuildingNoneSuite', suiteProperties, [new TestCaseBinding('Test Cases/Buildings/MyBuildings/BuildingNone/AddNewProjectTest', 'Test Cases/Buildings/MyBuildings/BuildingNone/AddNewProjectTest',  null), new TestCaseBinding('Test Cases/Buildings/MyBuildings/BuildingNone/PaymentByCreditCardTest', 'Test Cases/Buildings/MyBuildings/BuildingNone/PaymentByCreditCardTest',  null), new TestCaseBinding('Test Cases/Buildings/MyBuildings/BuildingNone/SubmitSurveyTest', 'Test Cases/Buildings/MyBuildings/BuildingNone/SubmitSurveyTest',  null)])
