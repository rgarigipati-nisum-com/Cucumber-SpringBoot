import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Calculator;

public class CalculatorSteps {
	
	private int total;
	 
	private Calculator calculator;
	
	@Given("^I have a calculator$")
	public void i_have_a_calculator() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		calculator = new Calculator();
	}

	@When("^I add (-?\\d+) and (-?\\d+)$")
	public void i_add_and(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		total = calculator.add(arg1,arg2);
	}

	@Then("^the result should be (-?\\d+)$")
	public void the_result_should_be(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg1, total);
	}


}
