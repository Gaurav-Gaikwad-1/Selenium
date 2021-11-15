package MessFunctionality;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMenuToCurrentMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = s.nextLine();
		System.out.println("Enter password : ");
		String pass = s.nextLine();
		
		
		System.out.println("Enter name of menu to add it to current menu: ");
		String menu = s.nextLine();
		menu = menu.toLowerCase();
		
		System.setProperty("webdriver.chrome.driver","G:/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		driver.get("http://localhost:3000/login/mess");
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='formGridEmail']")).sendKeys(username);

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/input")).sendKeys(pass);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='root']/div[2]/form/button")).submit();
		
		driver.findElement(By.xpath("//h5[contains(text(),'"+menu+"')]/parent::div/following-sibling::p[2]/div/*[name()='svg'][1]")).click();
	} 

}
