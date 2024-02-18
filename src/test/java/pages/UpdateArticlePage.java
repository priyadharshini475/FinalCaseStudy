package pages;
import java.time.Duration;import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class UpdateArticlePage {
	 @FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	    WebElement editBtn;
	    
	    @FindBy(xpath="//input[@placeholder='Article Title']")
	    WebElement articleTitle;
	    
	    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
	    WebElement articleAbout;
	    
	    @FindBy(xpath="//textArea[@rows='8']")
	    WebElement textArea;
	    
	     @FindBy(xpath="//input[@placeholder='Enter tags']")
	    WebElement enterTags;
	     
	     @FindBy(xpath="//button[contains(text(),'Update Article')]")
	     WebElement update_btn;
	     
//	     @FindBy(xpath="//h1[contains(text(),'Unit Test1..')]")
//	       WebElement headerCheckBtn;
	     
//	     @FindBy(xpath="//h1[contains(text(),'Unit Test1..')]")
//	     WebElement check;
//	     
	     @FindBy(xpath="(//a[@href='#/'])[2]")
	     WebElement home;
	     
         @FindBy(xpath="(//button)[2]")
	     WebElement globalFeed;
	     

	     // For find the webelement for already existing article title to update...
	     public WebElement articleTitleElement(WebDriver driver,String articleTitle) {
	    	 WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
	    	 return ele;
	     }
	     // For find the webelement for the updated Title
	     public WebElement getUpdateArticleElement(WebDriver driver,String updatedarticleTitle) {
	    	 WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+updatedarticleTitle+"')]"));
	    	 return ele;
	     }
	     
	     public  UpdateArticlePage(WebDriver driver) {
	    	 PageFactory.initElements(driver,this);
	     }
	     
	     public void homePage() {
	    	 home.click();
	    	 globalFeed.click();
	    	 
	     }
	    
		public void update(WebElement ele,String title,String about,String text,String tags) {
			     ele.click();
		         editBtn.click();
		    	 articleTitle.clear();
		    	 articleTitle.sendKeys(title);
		    	 articleAbout.clear();
		    	 articleAbout.sendKeys(about);
		    	 textArea.clear();
		    	 textArea.sendKeys(text);
		    	 enterTags.clear();
		    	 enterTags.sendKeys(tags);
		    	 update_btn.click();
	 }
		public String updateArticleValidate(WebElement check) {
			return check.getText();
		}
}
