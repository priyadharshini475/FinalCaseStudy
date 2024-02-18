package pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class DeleteArticlePage {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='btn btn-sm'][1]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;
	
	 @FindBy(xpath="(//a[@href='#/'])[2]")
     WebElement home;
     
     @FindBy(xpath="(//button)[2]")
     WebElement globalFeed;
     
     
	
	 public DeleteArticlePage(WebDriver driver) {
		 this.driver=driver;
	 		PageFactory.initElements(driver,this);
	 	}
	 
	 public void home() {
		 home.click();
		 globalFeed.click();
	 }
	 
	 public WebElement delArticleLocate(WebDriver driver,String articleTitle) {
		// WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
		 WebElement ele=driver.findElement(By.xpath("//h1"));
		 return ele;
		 
	 }
	 public void deleteArticle(WebElement ele)
		{
			ele.click();
		    deleteBtn.click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
	 public String deleteValidate() {
		 return check.getText();
	 }
	 

}
