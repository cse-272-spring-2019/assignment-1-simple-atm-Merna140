
public interface ATM {

	public boolean validate(String cardNumber);	
    public void deposit(double Damount);
    public void withdrawal(double Wamount); 
    public double balance(); 
    public String TransactionName1(); 
    public double TransactionValue1();
    public String TransactionName2(); 
    public double TransactionValue2(); 
}
