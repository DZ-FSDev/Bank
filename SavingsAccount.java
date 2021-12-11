/*
 * SavingsAccount
 * 
 * PURPOSE: Defines a subclass savings account of an owner, balance, and ID.
 */
public class SavingsAccount extends BankAccount{
  
  private static final double INTEREST_RATE = 1.5;  //The interest to be paid to all savings accounts [Percent]
  
 /*
  * Constructor of savings account.  Passes provided parameters to the super constructor.
  */    
  public SavingsAccount(BankClient owner, double balance, int id){
    super(owner, balance, id);
  }
  
 /*
  * Increases the balance of the savings account by the interest rate's percent.
  */    
  public void collectInterest(){
    balance *= (INTEREST_RATE/100 + 1);
  }
  
 /*
  * Returns a description of the account type and its details using the super class method.
  */    
  public String toString(){
    return "Savings " + super.toString();
  }
}
