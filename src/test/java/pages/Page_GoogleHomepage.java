package pages;

import common.Page_BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Page_GoogleHomepage extends Page_BasePage {



	public void launchRemoteWebDriver() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		//For Firefox use below capabilities
		//DesiredCapabilities caps = DesiredCapabilities.firefox();
		//caps.setPlatform(Platform.WINDOWS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("window-size=1024,768"); // Bypass OS security model

		driver = new RemoteWebDriver(new URL("http://45.145.20.100:4444/wd/hub"), options);

	}

	public void launchBrowserInSpecificGeoLocation(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/binary/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

//		DevTools devTools = driver.getDevTools();
//		devTools.createSession();
//		devTools.send(Emulation.setGeolocationOverride(
//				Optional.of(35.8235),
//				Optional.of(-78.8256),
//				Optional.of(100)));
	}

	public void launchBrowserInSpecificNetwork(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/binary/chromedriver.exe");
		ChromeDriver driver;
		driver = new ChromeDriver();
//
//		DevTools devTools = driver.getDevTools();
//		devTools.createSession();
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		devTools.send(Network.emulateNetworkConditions(
//				false,
//				20,
//				20,
//				50,
//				Optional.of(ConnectionType.CELLULAR2G)
//		));
	}
	public void launchBrowserWithDeviceMode(int width, int height, boolean isMobile, int deviceScaleFactor){

		System.setProperty("webdriver.chrome.driver", "src/test/resources/binary/chromedriver.exe");
//		DevTools devTools = driver.getDevTools();
//		devTools.createSession();
//		Map deviceMetrics = new HashMap()
//		{{
//			put("width", width);
//			put("height", height);
//			put("mobile", isMobile);
//			put("deviceScaleFactor", deviceScaleFactor);
//		}};
//		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

	}

	public void launchDEfaultBrowser(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/binary/chromedriver.exe");
		driver = new ChromeDriver();

	}
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","/app/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("window-size=1024,768"); // Bypass OS security model
		driver = new ChromeDriver(options);
	}

	public void launchBrowserWithFirefox(){
		FirefoxOptions firefoxDockerOptions = new FirefoxOptions();
		System.setProperty("webdriver.gecko.driver","/bin/geckodriver");
		firefoxDockerOptions.addArguments("--headless");
		firefoxDockerOptions.addArguments("--no-sandbox");
		System.setProperty("webdriver.gecko.args", "--disable-logging");
		System.setProperty("webdriver.gecko.silentOutput", "true");
		firefoxDockerOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		firefoxDockerOptions.addArguments("disable-infobars"); // disabling infobars
		firefoxDockerOptions.addArguments("--disable-extensions"); // disabling extensions
		firefoxDockerOptions.addArguments("--disable-gpu"); // applicable to windows os only
		firefoxDockerOptions.addArguments("--width=1920"); // Bypass OS security model
		firefoxDockerOptions.addArguments("--height=1080");
		driver = new FirefoxDriver(firefoxDockerOptions);
	}


	public String printTitle(){
		return driver.getTitle();
	}
	public void openGoogleURL() {
		driver.get("https://www.swtestacademy.com/selenium-grid/");
	}
		
	public void checkSearchBoxIsDisplayed() {
		if(driver.findElement(By.name("q")).isDisplayed()) {
			System.out.println("Search text box is displayed");
		} else {
			System.out.println("Search text box is NOT displayed");
		}
	}
	
	public void checkGoogleSearchButtonIsDisplayed() {
		if(driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value=\"Google'da Ara\"]")).isDisplayed()) {
			System.out.println("Google'da Ara button is displayed");
		} else {
			System.out.println("Google'da Ara button is NOT displayed");
		}
	}
	
	public void checkImFeelingLuckyButtonIsDisplayed() {
		if(driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Kendimi Şanslı Hissediyorum']")).isDisplayed()) {
			System.out.println("I'm Kendimi Şanslı Hissediyorum button is displayed");
		} else {
			System.out.println("I'm Kendimi Şanslı Hissediyorum button is NOT displayed");
		}
	}

	public String printContents() {
		return driver.findElement(By.className("entry-title")).getText();
	}
}
