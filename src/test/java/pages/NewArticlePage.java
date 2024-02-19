package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class NewArticlePage {
	   @FindBy(xpath="//a[@href='#/editor']")
	   WebElement newArticle_btn;
	   
	   @FindBy(xpath="//input[@placeholder='Article Title']")
	   WebElement articleTitle;
	   
	   @FindBy(xpath="//input[@class='form-control ' and @name='description']")
	   WebElement articleAbout;
	   
	   @FindBy(xpath="//textArea[@rows='8']")
	   WebElement textArea;
	   
	   @FindBy(xpath="//input[@placeholder='Enter tags']")
	   WebElement enterTags;
	    
	   @FindBy(xpath="//button[@type='submit']")
	    WebElement pub_article_btn;
	    

//	    @FindBy(xpath="//h1[contains(text(),'Unit Test')]")
//	    WebElement check;
	    
	    @FindBy(xpath="//span[contains(text(),'Title already exists.. ')]")
	    WebElement duplicate;
	    
	   public NewArticlePage(WebDriver driver) {
	 		PageFactory.initElements(driver,this);
	 	}
	   
	   public void newArticle() {
		   newArticle_btn.click();
	   }
	   public void newArticle(String title,String about,String text,String tags) {
		  
		   articleTitle.clear();
		   articleTitle.sendKeys(title); 
		   articleAbout.clear();
		   articleAbout.sendKeys(about);
		   textArea.clear();
		   textArea.sendKeys(text);
		   enterTags.clear();
		   enterTags.sendKeys(tags);
		   pub_article_btn.click();
	   }  
	   public WebElement getNewArticleElement(WebDriver driver,String articleTitle) {
		   WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
	       return ele;
	   }
	   public String newArticleValidate(WebElement check) {
		  return  check.getText();
	   }

	   public String duplicateArticleValidate() {
		   return duplicate.getText();
	   }
		   
		 
		 

}
