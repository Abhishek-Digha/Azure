import internal.GlobalVariable

//Change Building Setting (Modify Opreating Hours, Area and Occupancy)

try{

	//CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumSix)
	
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.editOccupanyAreaAndOpreatingHours'()
} 
catch (Throwable t) {
System.out.println(t.getLocalizedMessage())
	Error e1 = new Error(t.getMessage())
	e1.setStackTrace(t.getStackTrace())
	e1.printStackTrace()
}