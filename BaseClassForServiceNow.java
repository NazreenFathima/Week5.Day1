package week5.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForServiceNow {
	
	
	public ChromeDriver driver;
	@BeforeMethod
		public void preCondition() throws InterruptedException 
		{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev84255.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=Souj9uBw9AWV");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter username as admin
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
		//Enter password as September@2021
		driver.findElement(By.id("user_password")).sendKeys("September@2021");
		
		//Click Login
		driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(1000);
		
		//Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
	}
	
	

}
