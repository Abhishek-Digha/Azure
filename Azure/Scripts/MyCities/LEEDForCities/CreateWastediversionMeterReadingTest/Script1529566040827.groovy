import internal.GlobalVariable as GlobalVariable


try {
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.CitySheet, GlobalVariable.rowNumTwo)
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsDataInput.createWasteDiversionMeterReading'(GlobalVariable.CDataInput,GlobalVariable.rowNumTwo)
			
} catch (Throwable t) {
	System.out.println(t.getLocalizedMessage())
	Error e1 = new Error(t.getMessage())
	e1.setStackTrace(t.getStackTrace())
	e1.printStackTrace()
}