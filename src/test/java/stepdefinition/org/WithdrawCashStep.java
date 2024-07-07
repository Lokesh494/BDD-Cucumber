package stepdefinition.org;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pojoclass.org.AccountDetails;

public class WithdrawCashStep {

	public AccountDetails accountDetails;
	public int actBalance;

	@Given("I have a balance of ${int} in my account")
	public void I_have_a_balance_of_$_in_my_account(int amount) {
		accountDetails = new AccountDetails();
		accountDetails.setBalance(amount);
		actBalance = accountDetails.getBalance();
		Assert.assertEquals(actBalance, amount);
	}

	@When("I request ${int}")
	public void I_request_$(int amount) {
		accountDetails.withdraw(amount);
	}

	@Then("${int} should be dispensed")
	public void $_should_be_dispensed(int amount) {
		Assert.assertEquals("dispensed failed" , actBalance - accountDetails.getBalance(), amount );
	}

}
