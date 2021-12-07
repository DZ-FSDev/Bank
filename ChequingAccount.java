/*
 * ChequingAccount
 * 
 * PURPOSE: Defines a subclass chequing account of an owner, balance, and ID.
 */
public class ChequingAccount extends BankAccount {
  
  private static final double TRANSACTION_FEE = 4.95;  //Fixed transaction fee for each withdrawal [$]
  
 /*
  * Constructor of chequing account.  Passes provided parameters to the super constructor.
  */    
  public ChequingAccount(BankClient owner, double balance, int id){
    super(owner, balance, id);
  }
  
 /*
  * Subtracts the provided amount from the balance of the bank account using the super class method.
  * Subtracts the transaction fee which can leave the account at a negative balance.
  */    
  public void withdraw(double amount)throws InsufficientFundsException{
    super.withdraw(amount);
    super.balance -= TRANSACTION_FEE;
  }
    
 /*
  * Returns a description of the account type and its details using the super class method.
  */    
  public String toString(){
    return "Chequing " + super.toString();
  }
}
