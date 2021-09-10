package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClassForServiceNow {

	@Test
	public void runUpdateIncident() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(NewIncident.incidentNum, Keys.ENTER);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.switchTo().frame("gsft_main");
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select urgencyDD = new Select(urgency);
		urgencyDD.selectByIndex(0);
		
		WebElement state = driver.findElement(By.id("incident.state"));
		Select stateDD = new Select(state);
		stateDD.selectByVisibleText("In Progress");
		
		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Test");
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		String text = driver.findElement(By.id("incident.urgency")).getText();
		if(text.contains("High"))
		{
			System.out.println("Urgency is selected as High");
		}
		else
		{
			System.out.println("Urgency is not selected as High");
		}
		
		String text2 = driver.findElement(By.id("incident.state")).getText();
		if(text2.contains("In Progress"))
		{
			System.out.println("State is selected as InProgress");
		}
		else
		{
			System.out.println("State is not selected as InProgress");
		}
	

	}

}
