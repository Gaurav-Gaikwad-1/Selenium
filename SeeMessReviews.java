import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeeMessReviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter mess name you want to visit");
		String messName = s.nextLine();
		
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
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		driver.findElement(By.linkText(messName.toUpperCase())).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div/button/span[1]/span")).click();
	}

}
