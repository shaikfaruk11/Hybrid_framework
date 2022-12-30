package config;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.TestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testsetup {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static TakesScreenshot ts;
	public static Properties pro;
	public static ExtentReports report;
	public static ExtentTest logger;
	public String reportname;
	

	@BeforeSuite
	public void method() throws InterruptedException {
		reportname="localRun"+LocalDateTime.now().toString().replace(":", "").replace(".", "").replace("T", "").replace("-", "");
		Thread.sleep(1000);
		String folderName=LocalDateTime.now().getDayOfMonth()+"_"+LocalDateTime.now().getMonthValue()+"_"+LocalDateTime.now().getYear();
		report=new ExtentReports("Reports/"+folderName+"/"+reportname+".html");
		File screenshot= new File(System.getProperty("user.dir")+"./Reports/"+folderName+"/Screenshots");
		screenshot.mkdir();
	}
	@BeforeMethod
	public void lunchbrowser() throws MalformedURLException {
		logger=report.startTest("test1");
		driver=openBrowser(getProperties("execution_env"),getProperties("execution_browser"));
	}
	
	@AfterMethod
	public void teardown() {
		report.flush();
	}
	
	@AfterSuite
	public void method1() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public WebDriver openBrowser(String exeuction_env,String browser) throws MalformedURLException {
		if(exeuction_env.equals("local")) {
			switch(browser){
			case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				 break;
			case "Edge":
			      WebDriverManager.edgedriver().setup();
			      driver= new EdgeDriver();
			      break;
			      
			default:
				System.out.println("no browser defined");
				break;
				
				
	}
		}else if(exeuction_env.equals("grid")) {
			 DesiredCapabilities capability = new DesiredCapabilities();
	         capability.setBrowserName("chrome");
	         capability.setPlatform(Platform.WIN10);
			driver= new RemoteWebDriver(new URL("http://192.168.1.40:4444/wd/hub"),capability);
		}else if(exeuction_env.equals("mobile")){
			
		}
		return driver;
	}
	
	public static  String getProperties(String key) {
		String value = null;
		try {
	File F= new File("./config.properties");
	FileInputStream fis= new FileInputStream(F);
		pro= new Properties();
		pro.load(fis);
		value=pro.getProperty(key);
	}catch(Exception e) {
		
	}
		return value;
	
}
}


