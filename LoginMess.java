package MessFunctionality;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = s.nextLine();
		System.out.println("Enter password : ");
		String pass = s.nextLine();
		
		System.setProperty("webdriver.chrome.driver","G:/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

	

		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		driver.get("http://localhost:3000/login/mess");
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"formGridEmail\"]")).sendKeys(username);

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/input")).sendKeys(pass);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/form/button")).submit();
		System.out.println("Login Successfully");
	}

}



//testmess123@gmail.com        TestUser@11