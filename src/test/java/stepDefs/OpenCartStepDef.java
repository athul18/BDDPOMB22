package stepDefs;

import java.util.List;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchResultsPage;

public class OpenCartStepDef extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage acctPage;
	SearchResultsPage resultPage;
	
	@Given("User is on Home page")
	public void user_i_on_home_page() {
	 initialize();
	   }
	
	@Given("User navigates to login Page")
	public void user_navigates_to_login_page() {
	  homePage = new HomePage();
	  homePage.navigateTOLogin();
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) {
	    loginPage = new LoginPage();
	    loginPage.login(strUser, strPwd);
	}
	
	@Then("should display  My Account page")
	public void should_display_my_account_page() {
	acctPage = new MyAccountPage();
	acctPage.getPageTitle();
	Assert.assertEquals(acctPage.getPageTitle(), "My Account");
	}
	
	@When("User search item") 
	public void user_search_an_item(io.cucumber.datatable.DataTable dataTable){
		List<List<String>> items = dataTable.asLists();
		String strItem = items.get(0).get(0);
		acctPage.searchItem(strItem);
	}
	
	@Given("should display  search result page")
	public void should_display_search_result_page() {
	   resultPage = new SearchResultsPage();
	   boolean isPage = resultPage.isSearchResult();
	   Assert.assertTrue(isPage);	   
	}
	
	@When("User Add Item to cart")
	public void user_add_item_to_cart() {
	   resultPage.addItemToCart();
	}
	@Then("Item must be available in cart")
	public void item_must_be_available_in_cart() {
	   boolean isAdded = resultPage.isItemAdded();
	   Assert.assertTrue(isAdded);
	}

}
