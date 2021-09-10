package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClassForServiceNow {

	@Test
	public void runDeleteIncident() throws InterruptedException
	{
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(NewIncident.incidentNum, Keys.ENTER);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.switchTo().frame("gsft_main");
		//driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		//driver.switchTo().alert().dismiss();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(NewIncident.incidentNum, Keys.ENTER);
		
		String text = driver.findElement(By.xpath("//tbody[@class='list2_body']//td")).getText();
		if(text.contains("No records to display"))
			System.out.println("Incident deleted successfully");
		else
			System.out.println("Incident not deleted");
		
	}

}
