import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class CatFacts {

	private String url;
	
	private ResponseEntity<String> response;
	    
	@Autowired
	protected TestRestTemplate restTemplate;
	
	@Given("^the client makes a call to the hero ku$")
	public void the_client_makes_a_call_to_the_hero_ku() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		url="https://cat-fact.herokuapp.com";
	    
	}

	@When("^the user calls the api for facts$")
	public void the_user_calls_the_api_with_facts() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = restTemplate.getForEntity(new URI(url+"/facts"), String.class);
		
	}
	
	@Then("^the client receives status of (\\d+)$")
	public void the_client_receives_status_of(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg1, response.getStatusCode().value());
	
	}

	@Then("^the response has the text$")
	public void the_response_has_the_text(DataTable data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		 List<Map<String, String>> rows = data.asMaps(String.class, String.class);
		 
		 for (Map<String, String> row : rows) {
			 
			 String text = row.get("text");
			 
			 assertThat(response.toString()).contains(text);
		 }
		
	}
	
	
}
