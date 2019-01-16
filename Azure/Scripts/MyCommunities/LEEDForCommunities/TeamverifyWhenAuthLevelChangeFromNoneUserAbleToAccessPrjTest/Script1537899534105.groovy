import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

try{
	
	//CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.CommunitySheet, GlobalVariable.rowNumTwo)
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.editTeamMemberRole'()
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.logoutFromArcApplication'()
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.loginIntoArcApplication'(GlobalVariable.TeamMember, GlobalVariable.TeamMemberPassword)
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.CommunitySheet, GlobalVariable.rowNumTwo)
	/*WebUI.closeWindowIndex(1)
	WebUI.delay(2)
	WebUI.switchToWindowIndex(0)*/

	} catch (Throwable t) {
	  /*WebUI.closeWindowIndex(1)
	  WebUI.delay(2)
	 WebUI.switchToWindowIndex(0)*/
	  System.out.println(t.getLocalizedMessage())
	  Error e1 = new Error(t.getMessage())
	  e1.setStackTrace(t.getStackTrace())
	  e1.printStackTrace()
 }