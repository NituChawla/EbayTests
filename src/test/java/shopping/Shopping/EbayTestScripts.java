package shopping.Shopping;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class EbayTestScripts extends Base {
	
	public String ActualerrorMsg;
	public String ExpectederrorMsg= "Oops, that's not a match.";	
	public boolean item;
	@BeforeTest
	public void openURL( ) throws IOException {
		driver = initializeDriver();
		}
	
	// Test to verify the added product exists in Shopping Cart
	@Test(enabled=true)
	public void login() throws IOException, InterruptedException {
		 driver.get( prop.getProperty("URL"));
		// Thread.sleep(2000);
		 HomePage home = new HomePage(driver);
		 home.search_Product("bike");
		 home.click_Search();
		 Thread.sleep(1000);
		 home.select_Product();
         home.switchChildWindow();
         try
         { 
        	 home.select_Colour();
        	 home.select_Option();
        	
         }
         catch(Exception e)
         {
        	 System.out.println("Elements do not exist"+e.getMessage());
         }
         
         try
         {
        	 Thread.sleep(1000);
        	 home.select_Size();
        	 home.select_Option();
         }
         catch(Exception e)
         {
        	 System.out.println("Elements do not exist"+e.getMessage());
         }
         
         home.click_AddToCart();
         home.click_GoToCart();
         boolean a =home.verify_CartItem();
     // boolean a = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]")).isDisplayed();
        // home.verify_CartItem(item);        
         Assert.assertTrue(a);
          }
	
	// Test to validate the error message when user email not entered
	@Test(enabled=true)
	public void login1() throws IOException, InterruptedException {
		 driver.get( prop.getProperty("URL"));
		 HomePage home = new HomePage(driver);
		 home.click_MyEbay();
		 home.click_Continue();
		 Thread.sleep(1000);
		 String ActualerrorMsg= home.verify_ErrorMessage();
		Assert.assertEquals(ActualerrorMsg, ExpectederrorMsg);
		   }

	@AfterTest
	public void closeURL( ) {
		  driver.close();
		  driver.quit();
		  driver = null;
}
}
	
