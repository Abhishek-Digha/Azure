import internal.GlobalVariable as GlobalVariable

//Energy Meter Create

try {
	//CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumSix)
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsDataInput.createEnergyMeter'(GlobalVariable.BDataInput, GlobalVariable.rowNumTwo)

} catch (Throwable t) {
	System.out.println(t.getLocalizedMessage())
		Error e1 = new Error(t.getMessage())
		e1.setStackTrace(t.getStackTrace())
		e1.printStackTrace()
}

