package es.uniovi.asw.steps;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.MainController;

public class LoginSteps {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	protected ConfigurableApplicationContext appContext;
	protected WebDriver driver = new HtmlUnitDriver();
	protected String baseUrl = "http://localhost:8080/dashboard_i3a";
	Map<String, String> users = new HashMap<>();

	@Before
	public void setUp() {
		driver.get(baseUrl);
	}

	@Given("^a list of users:$")
	public void a_list_of_users(List<User> users) throws Throwable {
		for (User u : users) {
			LOG.debug("Inserting user..." + u.name + " - " + u.password);
		}
		assertEquals(3, users.size());
	}

	@When("^I login with correct \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_name_and_password(String name, String password) throws Throwable {
		LOG.debug("Login with values..." + name + " - " + password);
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("//*[@id='inputField']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='buttonLogin']")).click();
	}

	@Then("^I receive a welcome message \"([^\"]*)\"$")
	public void i_receive_a_welcome_message(String welcome) throws Throwable {	
		List<WebElement>list = driver.findElements(By.xpath("//*[contains(text(),'" + welcome + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		LOG.debug("Receiving welcome message: "+ welcome);
	}

	@Then("^I can see \"([^\"]*)\"$")
	public void i_can_see(String text) throws Throwable {
		List<WebElement>list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		LOG.debug("Checking text present: "+ text);
	}
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	}

	public static class User {
		private String name;
		private String password;
	}
}
