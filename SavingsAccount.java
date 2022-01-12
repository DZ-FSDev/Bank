/**
 * Defines a subclass saving account of an owner, balance, and ID.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class SavingsAccount extends BankAccount{
 /** The the interest rate as a percent. */
  private static final double INTEREST_RATE = 1.5;  //The interest to be paid to all savings accounts [Percent]
  
 /**
  * Constructor of savings account.
  *
  * @param owner The specified owner of this saving account.
  * @param balance The specified opening balance of this saving account.
  * @param id The specified id of this saving account.
  */    
  public SavingsAccount(BankClient owner, double balance, int id){
    super(owner, balance, id);
  }
  
 /**
  * Increases the balance of the savings account by the interest rate's percent.
  */    
  public void collectInterest(){
    balance *= (INTEREST_RATE/100 + 1);
  }
  
 /**
  * Returns a description of the account type and its details using the super class method.
  *
  * @return The description of the saving account, including the owner, ID, and the balance.
  */   
  @Override 
  public String toString(){
    return "Savings " + super.toString();
  }
}
