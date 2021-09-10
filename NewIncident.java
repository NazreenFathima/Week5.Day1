package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class NewIncident extends BaseClassForServiceNow {

	public static String incidentNum;
	@Test
	public void runNewIncident() throws InterruptedException
	{
		// TODO Auto-generated method stub
		
		//Click on Create new option and fill the mandatory fields
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
		
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Short Description");
		
		//Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().defaultContent();
	
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNum, Keys.ENTER);
	
		String verifyIncident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		
		if (incidentNum.equals(verifyIncident))
		System.out.println("Incident created successfully");
		else
			System.out.println("Incident creation unsuccessful");
		
	}

}
