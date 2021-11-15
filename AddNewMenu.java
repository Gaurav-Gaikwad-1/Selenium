package MessFunctionality;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = s.nextLine();
		System.out.println("Enter password : ");
		String pass = s.nextLine();
		
		System.out.println("enter name of new menu");
		String menuName = s.nextLine();
		System.out.println("enter type of new menu");
		String menuType = s.nextLine();
		System.out.println("enter price of new menu");
		String menuPrice = s.nextLine();

		
		System.out.println("enter items in new menu");
		String items = s.nextLine();
		
		
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
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[4]/button")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 
		driver.findElement(By.xpath("//*[@id=\"MenuName\"]")).sendKeys(menuName);
		
		driver.findElement(By.xpath("//*[@id=\"Type\"]")).sendKeys(menuType);
		
		driver.findElement(By.xpath("//*[@id=\"SetPrice\"]")).sendKeys(menuPrice);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div[3]/div/form/input")).sendKeys(items+"\n");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button")).click();
		
	}

}
