/**
 * Defines a bank account of its owner and account balance.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public abstract class BankAccount implements Clonable{
  private final BankClient OWNER;  //Owner of the bank account.
  private double balance;  //Balance of the bank account.
  private final int ID;  //ID of the bank account.
  
 /**
  * Constructs a bank account with a specified owner, balance and id.
  * 
  * @param owner The specified owner of this bank account.
  * @param balance The specified starting balance of this bank account.
  * @param id The specified id of this bank account.
  * @throws IllegalArgumentException Thrown when an invalid owner, balance, or ID was specified.
  */
  public BankAccount(BankClient owner, double balance, int id) throws IllegalArgumentException {
    this.OWNER = owner;
    this.setBalance(balance);
    this.ID = id;
  }
  
 /**
  * Sets the balance of this bank account to a new balance.
  *
  * @param newBalance The new balance for this bank account.
  * @throws IllegalArgumentException Thrown when a non-number is provided.
  */
  public void setBalance(double newBalance) throws IllegalArgumentException{
    if(Double.isNaN(newBalance) || Double.isInfinite(newBalance)) {
      throw new IllegalArgumentException(newBalance + " is not a valid balance.");
    }
    
    this.balance = newBalance;
  }
  
 /**
  * Adds the provided amount to the balance of the bank account as a deposit.
  *
  * @param amount The specified amount to deposit.
  * @throws IllegalArgumentException Thrown when a non-number is provided.
  */    
  public void deposit(double amount) throws IllegalArgumentException{
    if(Double.isNaN(amount) || Double.isInfinite(amount)) {
      throw new IllegalArgumentException(amount + " is not a valid balance.");
    }
    
    balance += amount;
  }
  
 /**
  * Subtracts the provided amount from the balance of the bank account as a withdrawal.
  *
  * @param amount The specified amount to be withdrawn.
  * @throws InsufficientFundsException Thrown when there is not enough funds for the
  *         withdrawal.
  * @throws IllegalArgumentException Thrown when a non-number is provided.
  */    
  public void withdraw(double amount)throws InsufficientFundsException, IllegalArgumentException{
    if(Double.isNaN(amount) || Double.isInfinite(amount)) {
      throw new IllegalArgumentException(amount + " is not a valid balance.");
    }
    
    if((balance - amount) > 0){
      balance -= amount;
    }else{
      throw new InsufficientFundsException("InsufficientFundsException: Insufficient funds for the withdrawal");
    }
  }
  
 /**
  * Returns the ID of the bank account.
  * 
  * @return The ID of the bank account.
  */    
  public int getID(){
    return id;
  }
  
 /**
  * Collects interest for the bank account.
  */    
  public abstract void collectInterest();
  
 /**
  * Returns a deep clone of this Bank Account.
  * 
  * @return A deep clone of this Bank Account.
  */
  protected BankAccount clone(){
    return new BankAccount(owner.clone(), balance, id);
  }
  
 /**
  * Returns the description of the bank account, including the owner, ID, and the balance.
  *
  * @return The description of the bank account, including the owner, ID, and the balance.
  */    
  public String toString(){
    return "Account id: " + id + "\nOwner: " + owner + "\nBalance: $" + String.format("%.2f", balance);
  }
}
