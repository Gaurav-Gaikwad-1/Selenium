import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToVisitSavedMess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		
		System.setProperty("webdriver.chrome.driver","G:/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

	

		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.get("http://localhost:3000/login/customer");

     	driver.findElement(By.id("formGridEmail")).sendKeys("jamesss@gmail.com");

		driver.findElement(By.id("formGridPassword")).sendKeys("James@123");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/form/button")).click();
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		try {
		driver.findElement(By.linkText("SAVED MESS")).click();
		}catch(Exception e) {
			System.out.println("Fetching Saved Mess Unsuccessfull");
		}	
	}
}
