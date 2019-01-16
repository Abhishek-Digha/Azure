import internal.GlobalVariable

try{
	//CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumSeven)
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsNavigation.navigateToTransitDataInput'()
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.editOccupanyAreaAndOpreatingHoursTransit'()
} 
catch (Throwable t) {
System.out.println(t.getLocalizedMessage())
	Error e1 = new Error(t.getMessage())
	e1.setStackTrace(t.getStackTrace())
	e1.printStackTrace()
}