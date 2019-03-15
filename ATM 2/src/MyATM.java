
public class MyATM implements ATM{
	
	Account account1 = new Account ("123456",0);

	@Override
	public boolean validate(String cardNumber) {
		if(cardNumber.compareTo(account1.getCardNumber())==0)
			return true;
		
		else	
			return false;
	}

	@Override
	public void deposit(double Damount) {
		account1.deposit(Damount);		
	}

	@Override
	public void withdrawal(double Wamount) {
		account1.withdrawal(Wamount);		
	}

	@Override
	public double balance() {
		double Balance;	
		Balance=account1.getBalance();
		return Balance;
	}

	@Override
	public String TransactionName1() {
		String TName;
		TName=account1.previous1();
		return TName;
	}

	@Override
	public double TransactionValue1() {
		double TValue;
		TValue=account1.previous2();
		return TValue;	
	}

	@Override
	public String TransactionName2() {
		String TName;
		TName=account1.next1();
		return TName;	
	}

	@Override
	public double TransactionValue2() {
		double TValue;
		TValue=account1.next2();
		return TValue;	
	}
}
