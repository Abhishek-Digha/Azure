package com.arc.BaseClass
import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.ss.usermodel.IndexedColors

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class BaseClass {

	//Excel Font color
	public static short fontOrange = HSSFColor.ORANGE.index
	public static short fontWhite = HSSFColor.WHITE.index
	public static short Yellow = IndexedColors.YELLOW.getIndex()
	public static short Red = IndexedColors.RED.getIndex()
	public static short Green = IndexedColors.GREEN.getIndex()
	//Excel Report Configuration
	public static rowNumTAG=2
	public static rowNumTUG=2
	public static rowNumBO=2
	public static rowNumBN=2
	public static rowNumMP=2
	public static rowNumCL=2
	public static rowNumCO=2
	public static rowNumCN=2
	public static rowNumCOML=2
	public static rowNumCOMO=2
	public static rowNumCOMN=2
	public static rowNumPORT=2
	public static rowNumError=2
	public static rowNumINBN=2
	public static rowNumDASH=2

	public static String arcReportFile= RunConfiguration.getProjectDir()+"/ARCDataTemplete/ARCReport.xlsx"
	public static XlsReader arcSheet = new XlsReader(arcReportFile)

	//GBCI Documentation folder
	String sourceZipFile= RunConfiguration.getProjectDir()+"/Download/GBCI-India.zip"
	String sourceExtractedFile= RunConfiguration.getProjectDir()+"/Download/GBCI-India/"
	String destinationUnZippedFolder= RunConfiguration.getProjectDir()+"/Download/"
	public static final int BUFFER_SIZE = 4096
	//Data Template and files
	public static String downloadPath = RunConfiguration.getProjectDir()+"/Download/"
	//public static String downloadPath = RunConfiguration.getProjectDir()+"\\Download\\"

	public static String filePath= RunConfiguration.getProjectDir()+"/"+ GlobalVariable.env
	public static String excelTemplateData= RunConfiguration.getProjectDir()+"/ARCDataTemplete/"+ GlobalVariable.ExcelTemplateData
	public static XlsReader data = new XlsReader(filePath)
	public static XlsReader dataExcelTemplate = new XlsReader(excelTemplateData)
	public static String screenShot = RunConfiguration.getProjectDir()+"/ScreenShot/screenshot_"
	public static TestObject myTestObject = new TestObject("customObject")
	public static Date date = new Date(System.currentTimeMillis())
	public static Date dateNew = new Date()

	public static String gresbUpload = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Gresb.xlsx"

	public static String parkImageUpload = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Parking SJ.jpg"
	public static String pdfFile = RunConfiguration.getProjectDir()+"/ARCDataTemplete/USGBC.pdf"
	public String UnzippedNewFolder= RunConfiguration.getProjectDir()+"/Download/GBCI-India/"
	public static String Addendum = RunConfiguration.getProjectDir()+"/Download/Agreement.pdf"
	public static String ServiceAgreement = RunConfiguration.getProjectDir()+"/Download/Agreement.pdf"
	public static String UploadArcDataTempleteTransit = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Arc_Data_Template_transit_above.xlsm"
	public static String UploadArcDataTempleteTransitanalytics = RunConfiguration.getProjectDir()+"/ARCDataTemplete/AnalyticArc_Data_Template_transit_above.xlsm"

	public static String UploadArcDataTempleteTransitBelow = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Arc_Data_Template_transit_below.xlsm"
	public static String UploadArcDataTemplete = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Arc_Data_Template.xlsm"

	public static String analyticsUploadArcDataTemplete = RunConfiguration.getProjectDir()+"/ARCDataTemplete/AnalyticArc_Data_Template.xlsm"

	public static String UploadDocumentDataInput = RunConfiguration.getProjectDir()+"/ARCDataTemplete/USGBC.pdf"
	public static String UploadTextFile=RunConfiguration.getProjectDir()+"/ARCDataTemplete/txtFileUpload.txt"
	public static String UploadJpeg=RunConfiguration.getProjectDir()+"/ARCDataTemplete/Parking SJ.jpg"
	public static String UploadPng=RunConfiguration.getProjectDir()+"/ARCDataTemplete/uploadPng.png"
	public static String UploadGif=RunConfiguration.getProjectDir()+"/ARCDataTemplete/uploadGif.gif"
	public static String UploadXls=RunConfiguration.getProjectDir()+"/ARCDataTemplete/uploasExcel.xlsx"
	public static String UploadDocs=RunConfiguration.getProjectDir()+"/ARCDataTemplete/uploadDoc.docx"
	public static String UploadManageCalculatorExcel = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Arc_Data_Template_v03.xlsm"
	public static String DownloadManageCalculatorExcel = RunConfiguration.getProjectDir()+"/Download/Arc_Data_Template_v03.xlsm"
	public static String DataResourcesPdf = RunConfiguration.getProjectDir()+"/Download/DataResources.pdf"
	public static String DataReviewChecklistPdf = RunConfiguration.getProjectDir()+"/Download/Data Review Checklist.pdf"


	//local files
	/*public static String UploadArcDataTempleteTransitanalytics = RunConfiguration.getProjectDir()+"\\ARCDataTemplete\\AnalyticArc_Data_Template_transit_above.xlsm"
	 public static String parkImageUpload = System.getProperty('user.dir')+"\\ARCDataTemplete\\Parking SJ.jpg"
	 public static String pdfFile = System.getProperty('user.dir')+"\\ARCDataTemplete\\USGBC.pdf"
	 public String UnzippedNewFolder= RunConfiguration.getProjectDir()+"\\Download\\GBCI-India\\"
	 public static String UploadArcDataTempleteTransit = System.getProperty('user.dir')+"\\ARCDataTemplete\\Arc_Data_Template_transit_above.xlsm"
	 public static String DataResourcesPdf = System.getProperty('user.dir')+"\\Download\\DataResources.pdf"
	 //public static String downloadPath = RunConfiguration.getProjectDir()+"\\Download"
	 public static String DataReviewChecklistPdf = System.getProperty('user.dir')+"\\Download\\Data Review Checklist.pdf"
	 public static String UploadArcDataTempleteTransitBelow = System.getProperty('user.dir')+"\\ARCDataTemplete\\Arc_Data_Template_transit_below.xlsm"
	 public static String UploadDocumentDataInput = System.getProperty('user.dir')+"\\ARCDataTemplete\\USGBC.pdf";
	 public static String UploadTextFile=System.getProperty('user.dir')+"\\ARCDataTemplete\\txtFileUpload.txt"
	 public static String UploadJpeg=System.getProperty('user.dir')+"\\ARCDataTemplete\\Parking SJ.jpg"
	 public static String UploadPng=System.getProperty('user.dir')+"\\ARCDataTemplete\\uploadPng.png"
	 public static String UploadGif=System.getProperty('user.dir')+"\\ARCDataTemplete\\uploadGif.gif"
	 public static String UploadXls=System.getProperty('user.dir')+"\\ARCDataTemplete\\uploasExcel.xlsx"
	 public static String UploadDocs=System.getProperty('user.dir')+"\\ARCDataTemplete\\uploadDoc.docx"
	 public static String UploadManageCalculatorExcel = System.getProperty('user.dir')+"\\ARCDataTemplete\\Arc_Data_Template_v03.xlsm"
	 public static String DownloadManageCalculatorExcel = System.getProperty('user.dir')+"\\Download\\Arc_Data_Template_v03.xlsm.pdf"
	 public static String UploadArcDataTemplete =System.getProperty('user.dir')+"\\ARCDataTemplete\\Arc_Data_Template.xlsm"
	 public static String ServiceAgreement = System.getProperty('user.dir')+"\\Download\\Agreement.pdf"
	 public static String Addendum = System.getProperty('user.dir')+"\\Download\\Agreement.pdf"*/
}
