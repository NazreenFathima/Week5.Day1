package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignIncident extends BaseClassForServiceNow {

	@Test
	public void runAssignIncident() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(NewIncident.incidentNum, Keys.ENTER);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.switchTo().frame("gsft_main");
		WebElement category = driver.findElement(By.id("incident.category"));
		Select categoryDD = new Select(category);
		categoryDD.selectByVisibleText("Software");
	
		Thread.sleep(1000);
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigned to software group");
		driver.findElement(By.id("sysverb_update_bottom")).click();
	    driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		String text = driver.findElement(By.id("incident.category")).getText();
		if(text.contains("Software"))
		{
			System.out.println("Selected category is Software");
		}
		else
		{
			System.out.println("Selected category is not Software");
		}

	}

}
