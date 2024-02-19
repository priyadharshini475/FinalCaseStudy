package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteArticlePage;
import pages.LoginArticlePage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

public class OrderStepDef {
	WebDriver driver=TestBase.getDriver();
	LoginArticlePage loginArticlePage;
	NewArticlePage newArticlePage;
	UpdateArticlePage updateArticlePage;
	DeleteArticlePage deleteArticlePage;
	public OrderStepDef(){
		loginArticlePage=new LoginArticlePage(driver);
		newArticlePage=new  NewArticlePage(driver);
		updateArticlePage=new UpdateArticlePage(driver);
		deleteArticlePage= new  DeleteArticlePage(driver);
		
	}
	@Given("User is on login Page")
	public void user_is_on_login_page() {
	TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	  loginArticlePage.login();
	}
	
	@When("User enters inValid Credentials")
	public void user_enters_in_valid_credentials(DataTable dataTable) {
		List<Map<String,String>> users=dataTable.asMaps();
		String name=users.get(0).get("email");
		String password=users.get(0).get("password");
		loginArticlePage.inValidLoginTest(name, password);
	}
	
	@Then("Should display the invalid login message")
	public void should_display_the_invalid_login_message(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String expmsg=msgs.get(0);
	    Assert.assertEquals(loginArticlePage.checkInValidLogin(),expmsg);
	}
	
	@When("User enters  valid Credentials")
	public void user_enters_valid_credentials(DataTable dataTable) {
		List<Map<String,String>> users=dataTable.asMaps();
		String name=users.get(0).get("email");
		String password=users.get(0).get("password");
		loginArticlePage.validLoginTest(name, password);
     }
	
	@Then("Should display the success login message")
	public void should_display_the_success_login_message(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String userName=msgs.get(0);
		WebElement ele=loginArticlePage.validUserName(driver,userName);
	    Assert.assertEquals(loginArticlePage.checkValidLogin(ele),userName);
	}
	
	@Given("User is on newArticleCreationPage")
	public void user_is_on_new_article_creation_page() {
		newArticlePage.newArticle();
	 	}
	
	@When("User Create the duplicate article")
	public void user_create_the_duplicate_article(DataTable dataTable) {
		List<Map<String,String>> article=dataTable.asMaps();
		String articleTitle=article.get(0).get("articleTitle");
		String  description=article.get(0).get("description");
		String body=article.get(0).get("body");
		String tags=article.get(0).get("tags");
		newArticlePage.newArticle(articleTitle,description,body,tags);
	  
	}
	@Then("Should display the duplicate article message")
	public void should_display_the_duplicate_article_message(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String dupexpmsg=msgs.get(0);
	    Assert.assertEquals(newArticlePage.duplicateArticleValidate(),dupexpmsg);
	}
	
	
	@When("User create the new Article")
	public void user_create_the_new_article(DataTable dataTable) {
		List<Map<String,String>> article=dataTable.asMaps();
		String articleTitle=article.get(0).get("articleTitle");
		String  description=article.get(0).get("description");
		String body=article.get(0).get("body");
		String tags=article.get(0).get("tags");
		newArticlePage.newArticle(articleTitle,description,body,tags);
	  
	}
	@Then("Should display the new Article Title")
	public void should_display_the_new_article_title(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String newArticleTitle=msgs.get(0);
		WebElement ele=newArticlePage.getNewArticleElement(driver,newArticleTitle);
	    Assert.assertEquals(newArticlePage.newArticleValidate(ele),newArticleTitle);
	}
	
	
	
	@Given("User is on updateArticlePage")
	public void user_is_on_update_article_page() {
		updateArticlePage.homePage();
	   
	}
	@When("User Update the Article")
	public void user_update_the_article(DataTable dataTable) {
		List<Map<String,String>> article=dataTable.asMaps();
		String articleTitle=article.get(0).get("articleTitle");
		String updateArticleTitle=article.get(0).get("updatedArticleTitle");
		String  description=article.get(0).get("description");
		String body=article.get(0).get("body");
		String tags=article.get(0).get("tags");
		WebElement locateArticle=updateArticlePage.articleTitleElement(driver,articleTitle);
		updateArticlePage.update(locateArticle,updateArticleTitle,description,body,tags);
        
		
	}
	@Then("Should display the updated Article Title")
	public void should_display_the_updated_article_title(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String updArticleTitle=msgs.get(0);
		WebElement ele=updateArticlePage.getUpdateArticleElement(driver,updArticleTitle);
		Assert.assertEquals(updateArticlePage.updateArticleValidate(ele),updArticleTitle);
	    
	}
	@Given("User is on deleteArticlePage")
	public void user_is_on_delete_article_page() {
		deleteArticlePage.home();
	   
	}
	@When("User delete the Article")
	public void user_delete_the_article(DataTable dataTable) {
		List<Map<String,String>> article=dataTable.asMaps();
		String delTitle=article.get(0).get("articleName");
		WebElement ele=deleteArticlePage.delArticleLocate(driver, delTitle);
	    deleteArticlePage.deleteArticle(ele);
		
	}
	@Then("should the article to be deleted")
	public void should_the_article_to_be_deleted(DataTable dataTable) {
		List<String> msgs=dataTable.asList();
		String del_msg=msgs.get(0);
		Assert.assertEquals(deleteArticlePage.deleteValidate(),del_msg);
	}
	
}	
	
	


