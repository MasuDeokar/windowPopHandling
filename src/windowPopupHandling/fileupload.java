package windowPopupHandling;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class fileupload {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		@SuppressWarnings("unused")
		String downloadPath =System.getProperty("user.dir");

		@SuppressWarnings("unused")
		ChromeOptions c =new ChromeOptions();
		String downloadPath1=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","./Server/chromedriver.exe");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath1);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//span[contains(text(),'Select PDF files')]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Dell\\eclipse-workspace\\Check\\fileuploadc.exe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f = new File(downloadPath1+"/Final Resume Vaishali_page-0001.jpg");
		
		if(f.exists())
				{
			Assert.assertTrue(f.exists());
			if(f.delete())
				System.out.println("file deleted");
				}
			
				}
	}



