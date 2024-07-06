import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

//bukaBrowserkeURL
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

//maximizeUkuranWindow
WebUI.maximizeWindow()

//flowLoginPage
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service - Login Page/btn_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service - Login Page/input_Username_username'), username)

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service - Login Page/input_Password_password'), password)

//screenshotUntukReport
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service - Login Page/button_Login'))

// validasiLogin
String currentUrl = WebUI.getUrl()
if (currentUrl.contains('https://katalon-demo-cura.herokuapp.com/#appointment')) {
	// Comment success message
	KeywordUtil.markPassed('Sukses masuk ke halaman appointment')
} else {
	// Get the alert text and comment error message
	String alertText = WebUI.getText(findTestObject('Object Repository/Page_CURA Healthcare Service - Login Page/p_Login failed Please ensure the username and password are valid'))
		KeywordUtil.markFailed('Login gagal: ' + alertText)
	}

//screenshotUntukReport
WebUI.takeScreenshot()