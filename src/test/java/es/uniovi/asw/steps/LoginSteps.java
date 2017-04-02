package es.uniovi.asw.steps;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.MainController;

@WebAppConfiguration
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

		driver.findElement(By.xpath("//*[@id=\"inputField\"]")).sendKeys(name);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.name("buttonlogin")).click();
	}

	@Then("^I receive a welcome message$")
	public void i_receive_a_welcome_message(String welcome) throws Throwable {
		LOG.debug("Welcome value received");
		String currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, "http://localhost:8080/dashboard_i3a/dashboard");
		assertEquals(welcome, "Welcome: Pablo");
	}

	public static class User {
		private String name;
		private String password;
	}
}
