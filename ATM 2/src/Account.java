
public class Account {
		
	private String cardNumber;
	private double balance;
	private Transaction [] transactions;
	private int Index;
	
	public Account(String cardNumber,double balance) {
		this.cardNumber=cardNumber;
		this.balance=balance;
		transactions=new Transaction[100];
		Index=0;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double deposit(double Damount) {
		balance=balance+Damount;	
		Transaction memo=new Transaction("Deposit",Damount);	
		transactions[Index++]=memo;
		return balance;
	}
	
	public double withdrawal(double Wamount) {
	    balance=balance-Wamount;	
		Transaction memo=new Transaction("Withdrawal",Wamount);	
		transactions[Index++]=memo;	
		return balance;
	}
	
	public String previous1() {	
		String tranName;	
		tranName=transactions[Index-1].getName();		
		return tranName;
	}
	
    public double previous2() {		
		double tranValue;		
		tranValue=transactions[Index-1].getAmount();			
		Index=Index-1;
		return tranValue;
	}

	public String next1() {	
		String tranName;	
		tranName=transactions[Index+1].getName();		
		return tranName;	
	}
	
     public double next2() {		
		double tranValue;		
		tranValue=transactions[Index+1].getAmount();			
		Index=Index+1;	
		return tranValue;
	}
}
