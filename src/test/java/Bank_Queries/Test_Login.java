package Bank_Queries;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test_Login {
	WebDriver driver;


	  @BeforeMethod
	  public void setup() 
	  {
		  
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://zero.webappsecurity.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  }

	  @Test
	  public void Login() throws InterruptedException 
	  
	  {

		  	driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			
			Thread.sleep(1000);
			
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.linkText("Pay Bills")).click();
			driver.findElement(By.linkText("Add New Payee")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("np_new_payee_name")).sendKeys("HydroOne Utility");
			driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RoberSpec Pkwy, Mississuaga, ON L6R1K9");
			driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");
			driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
			driver.findElement(By.id("add_new_payee")).click();
			System.out.println("The new payee HydroOne Utility was successfully created");
		
		
				
		}
	  
	  
	  @AfterMethod
	  
	  public void TearDown()
	  
	  {
		  driver.quit();
	  }
}
