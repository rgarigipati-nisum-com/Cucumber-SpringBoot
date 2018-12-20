import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Application;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration()
public class RecipePuppy {
	
//	@LocalServerPort
//	protected int localServerPort;
	
	private String url;
	private ResponseEntity<String> response;
	    
	@Autowired
	protected TestRestTemplate restTemplate;
	
	@Given("^the client makes a call to the receipe puppy$")
	public void the_client_makes_a_call_to_the_receipe_puppy() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		url="http://www.recipepuppy.com/api/";
		
	  
	}

	@When("^the user calls the api with onions,eggs$")
	public void the_user_calls_the_api_with_onions_eggs() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = restTemplate.getForEntity(new URI(url+"?i=onions,egg"), String.class);
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg1, response.getStatusCode().value());
	
	}

	@Then("^the response has the title (.*)$")
	public void the_response_has_the_title_Recipe_Puppy(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(response.getBody().indexOf(title) > 0);

	}

	@Then("^also has (.*) as ingredients$")
	public void also_has_onins_and_egg_as_ingredients(String ingredients) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String[] ingredient=ingredients.split(",");
		for (int index=0; index < ingredient.length; index++) {
			assertTrue(response.getBody().indexOf(ingredient[index])>0);
		}
	}


}
