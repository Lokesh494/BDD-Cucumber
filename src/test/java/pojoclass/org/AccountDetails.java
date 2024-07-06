package pojoclass.org;

public class AccountDetails {

	int balance;

	public AccountDetails() {
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	public void withdraw(int amount) {
		if (amount <= balance) {
			this.balance -= amount;
		} else {
			System.out.println("Insufficient funds to dispense $" + amount);
		}

	}

}
