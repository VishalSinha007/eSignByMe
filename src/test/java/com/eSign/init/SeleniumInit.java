package com.eSign.init;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.internal.Utils;
import com.eSign.Verification.SignedForOneSigner_generalverification;
import com.eSign.indexpage.SignedForOneSigner_generalindexpage;
import com.utility.TestData;


public class SeleniumInit {

	String testUrl;
	String seleniumHub;
	String seleniumHubPort;
	public String targetBrowser;
	public String suiteName = "";
	public String testName = "";

	public WebDriver driver;

	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null;
	public static String currentTest;

	public static String browserName = "";
	public static String osName = "";
	public static String browserVersion = "";
	
	public SignedForOneSigner_generalindexpage signedforonesignergeneralindexpage;
	public SignedForOneSigner_generalverification signedforonesignergeneralverification;

	
	

	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		testUrl = TestData.getURL();

		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		browserName = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		System.out.println(" Before Test ");

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext testContext) throws Exception {
		System.out.println("Set up Start =====");
		String path = "";

		File theDir = new File(path);

		if (!theDir.exists()) {
			System.out.println("creating directory: ");
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		URL remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		currentTest = method.getName(); // get Name of current test.

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
			
			final FirefoxOptions options = new FirefoxOptions();
		//	options.addArguments("-profile", "./firefoxprofile"); // Added for CSRF Issue
			
			profile.setPreference("geo.enabled", false);
			profile.setPreference("geo.provider.use_corelocation", false);
			profile.setPreference("geo.prompt.testing", false);
			profile.setPreference("geo.prompt.testing.allow", false);
		//	profile.setPreference("csrf_protection", false);
				
			capability = DesiredCapabilities.firefox();
			capability.setCapability(FirefoxDriver.PROFILE, profile);	
			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			capability.setCapability("marionette", true);

			options.addArguments("no-sandbox");

			/*options.addArguments("--start-maximized");*/
			if (TestData.getHeadless().contains("Yes")) {
				options.addArguments("headless");
				options.addArguments("--window-size=1920x1080");
			}
			
			capability.setBrowserName("firefox");
			capability.setJavascriptEnabled(true);
			browserName = capability.getVersion();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
			// driver = new RemoteWebDriver(new
			// URL("http://172.16.150.12:4444/wd/hub"), capability);
		//	driver = new ChromeDriver(capability);
			
			System.out.println("=========" + "firefox Driver " + "==========");
			driver = new FirefoxDriver(capability);
			
			/*if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
				path = "/Users/Jignesh/developer/test-automation";
			} else {
				path = "Resources/geckodriver.exe";
			}*/

			/*profile.setPreference("dom.max_chrome_script_run_time", "999");
			profile.setPreference("dom.max_script_run_time", "999");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", path);
			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download,manager.focusWhenStarting", false);
			// profile.setPreference("browser.download.useDownloadDir",true);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.closeWhenDone", false);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);
			profile.setAcceptUntrustedCertificates(true);
			profile.setPreference("security.OCSP.enabled", 0);
			profile.setPreference("network.http.use-cache", false);
			profile.setPreference("gfx.direct2d.disabled", true);
			profile.setPreference("layers.acceleration.disabled", true);*/
			//capability = DesiredCapabilities.firefox();
			/*capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);*/
			//capability.setCapability("marionette", true);
			/*browserName = capability.getBrowserName();
			osName = System.getProperty("os.name");
			browserVersion = capability.getVersion().toString();*/

			/*System.out.println("=========" + "firefox Driver " + "==========");
			driver = new FirefoxDriver();*/
			// driver = new RemoteWebDriver(remote_grid, capability);
		} else if (targetBrowser.contains("chrome")) {
			File file = new File("./lib/chromedriver_2_41.exe");

			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

			final ChromeOptions options = new ChromeOptions();
			String downloadFilepath = new File("Downloads").getAbsolutePath();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			System.err.println("File Path ============" + file.getAbsolutePath());
			options.setExperimentalOption("prefs", chromePrefs);
			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);

			options.addArguments("no-sandbox");

			options.addArguments("--start-maximized");
			if (TestData.getHeadless().contains("Yes")) {
				options.addArguments("headless");
				options.addArguments("--window-size=1920x1080");
			}
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);
			browserName = capability.getVersion();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
			// driver = new RemoteWebDriver(new
			// URL("http://172.16.150.12:4444/wd/hub"), capability);
			driver = new ChromeDriver(capability);
			/* driver.manage().window().setSize(new Dimension(1920,1080)); */
			System.out.println("=========" + "Chorme Driver " + "==========");
			// driver.setFileDetector(new LocalFileDetector());
		}

		suiteName = testContext.getSuite().getName();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); //--> Firefox
		testUrl = TestData.getURL();
		driver.get(testUrl);
		
		signedforonesignergeneralindexpage=new SignedForOneSigner_generalindexpage(driver);
		signedforonesignergeneralverification=new SignedForOneSigner_generalverification(driver);
		
		

	}

	/**
	 * Log For Failure Test Exception.
	 * 
	 * @param tests
	 */
	private void getShortException(IResultMap tests) {

		for (ITestResult result : tests.getAllResults()) {

			Throwable exception = result.getThrowable();
			List<String> msgs = Reporter.getOutput(result);
			boolean hasReporterOutput = msgs.size() > 0;
			boolean hasThrowable = exception != null;
			if (hasThrowable) {
				boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					log("<h3>" + (wantsMinimalOutput ? "Expected Exception" : "Failure Reason:") + "</h3>");
				}

				// Getting first line of the stack trace
				String str = Utils.stackTrace(exception, true)[0];
				Scanner scanner = new Scanner(str);
				String firstLine = scanner.nextLine();
				log(firstLine);
				scanner.close();
			}
		}
	}

	/**
	 * After Method
	 * 
	 * @param testResult
	 */

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {

		ITestContext ex = testResult.getTestContext();

		try {
			testName = testResult.getName();
			System.err.println("----------->         " + testResult.getTestName());
			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("=========++++   >>  ");
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
				String screenshotName = Common.getCurrentTimeStampString() + testName;
				Reporter.log("<br> <b>Please look to the screenshot - </b>");
				Common.makeScreenshot(driver, screenshotName);
				// Reporter.log(testResult.getThrowable().getMessage());

				getShortException(ex.getFailedTests());
				Common.logStatus("Fail");
				driver.close();
				driver.quit();

			} else {
				try {
					Common.pause(5);
					Common.pause(5);
				} catch (Exception e) {
					log("<br></br> Not able to perform logout");
				}

				System.out.println("TEST PASSED - " + testName + "\n");

				System.out.println("here is test status--" + testResult.getStatus());

				driver.close();
				driver.quit();
			}

		} catch (Throwable throwable) {
			System.out.println("message from tear down" + throwable.getMessage());
		}
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {
		System.out.println(msg);
		Reporter.log("<br></br>" + msg);
	}

}
