import internal.GlobalVariable

try {
	
	//CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumSix)
	
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.verifyNameOfSchoolFieldPresent'(GlobalVariable.BuildingSheet ,GlobalVariable.rowNumSix)
	
 } catch (Throwable t) {
	 System.out.println(t.getLocalizedMessage())
	 Error e1 = new Error(t.getMessage())
	 e1.setStackTrace(t.getStackTrace())
	 e1.printStackTrace()
 }


 