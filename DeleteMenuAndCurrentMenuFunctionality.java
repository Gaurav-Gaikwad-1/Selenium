package MessFunctionality;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteMenuAndCurrentMenuFunctionality {
	static String menu;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = s.nextLine();
		System.out.println("Enter password : ");
		String pass = s.nextLine();
		
		System.out.println("Select your choice to perform[1/2]\n1.Add to Current menu\n2.Delete Menu");
		int choice = s.nextInt();
		s.nextLine();
		if(choice==1) {
			System.out.println("Enter name of menu to add it to current menu: ");
		    menu = s.nextLine();
			menu = menu.toLowerCase();
		}else if(choice==2){
			System.out.println("Enter name of menu to delete: ");
			menu = s.nextLine();
			menu = menu.toLowerCase();
		}else {
			System.out.println("Wrong choice");System.exit(0);
		}
	
		System.setProperty("webdriver.chrome.driver","G:/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		driver.get("http://localhost:3000/login/mess");
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='formGridEmail']")).sendKeys(username);

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/input")).sendKeys(pass);
		
		driver.findElement(By.xpath("//*[@id='root']/div[2]/form/button")).submit();

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		switch(choice) {
		case 1: String currentMenuXpath = "//h5[contains(text(),'" + menu + "')]/parent::div/following-sibling::p[2]/div/*[name()='svg'][1]";
			    driver.findElement(By.xpath(currentMenuXpath)).click();
		        break;
		        
		case 2: String deleteXpath = "//h5[contains(text(),'" + menu + "')]/parent::div/following-sibling::p[2]/div/*[name()='svg'][3]";
		        driver.findElement(By.xpath(deleteXpath)).click();
				break;				
		}
		
	}

}
//  testmess123@gmail.com        TestUser@11