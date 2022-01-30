package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	 WebDriver driver;
	 String ExpectederrorMsg ="Oops, that's not a match.";
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  
  @FindBy(id="gh-ac")
 private WebElement search;
  
  @FindBy(id="gh-btn")
 private WebElement searchbutton;
  
  @FindBy(xpath="//*[@id='msku-sel-1']")
  private WebElement clickcolourdropdown;
  
  @FindBy(xpath="//*[@id='msku-opt-0']")
  private WebElement selectoption;
  
  
  @FindBy(xpath="//*[@id='msku-sel-2']")
  private WebElement clicksizedropdown;
  
  @FindBy(xpath="//*[@id=\'srp-river-results\']//li[1]//div[2]//h3")
  private WebElement selectproduct;
   
  @FindBy(xpath="//*[@id='atcRedesignId_btn']")
  private WebElement btnAddTocart;
  
  @FindBy(xpath="//*[@id=\"atcRedesignId_overlay-atc-container\"]//div[1]/div[2]/div[3]/a[2]/span/span")
  private WebElement btnGoToCart;
  
  @FindBy(xpath="//*[@id=\"gh-eb-My\"]/div/a[1]/i")
  private WebElement lnkMyebay;
  
  @FindBy(xpath="//*[@id=\"signin-continue-btn\"]")
  private WebElement btnContinue;
  
  @FindBy(xpath="//*[@id=\"errormsg\"]")
  private WebElement txtErrormsg;

  @FindBy(xpath="//*[@id=\"mainContent\"]/div/div[1]")
  private WebElement txtCartItem;
  
    public void search_Product(String product)
    {
    	search.sendKeys(product);
    }
    
   
    public void click_MyEbay()
    {
    	lnkMyebay.click();
    }
    
    public void click_Continue()
    {
    	btnContinue.click();
    }
    
    public boolean verify_CartItem()
    {
    	boolean cartitem= txtCartItem.isDisplayed();
    	return cartitem;
       
    
    }
    
    public String verify_ErrorMessage()
    {
    	String ActualerrorMsg= txtErrormsg.getText();
    	return ActualerrorMsg;
       
    
    }
    public void click_Search()
    {
    	 searchbutton.click();
    }
    
    public void click_AddToCart()
    {
    	 btnAddTocart.click();
    }
    
    public void click_GoToCart()
    {
    	btnGoToCart.click();
    }
    
    public void click_myEbay()
    {
    	btnGoToCart.click();
    }
    public void select_Product()
    {
    	 selectproduct.click();
    }
    public void select_Colour()
    {
    	clickcolourdropdown.click();
    }
    public void select_Option()
    {
    	selectoption.click();
    }

    public void select_Size()
    {
    	clicksizedropdown.click();
    }
	
	public void switchChildWindow()
	{
		String parent=driver.getWindowHandle();
        Set<String>s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {

        String child_window=I1.next();
        if(!parent.equals(child_window))
        {
        driver.switchTo().window(child_window);
	}
        }
	
}
}


