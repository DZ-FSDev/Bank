/**
 * Defines a bank account of its owner and account balance.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public abstract class BankAccount{
  private final BankClient OWNER;  //Owner of the bank account.
  private double balance;  //Balance of the bank account.
  private final int ID;  //ID of the bank account.
  
 /**
  * Constructs a bank account with a specified owner, balance and id.
  * 
  * @param owner The specified owner of this bank account.
  * @param balance The specified starting balance of this bank account.
  * @param id The specified id of this bank account.
  * @throws IllegalArgumentException Thrown when an invalid owner or ID was specified.
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
  */
  public void setBalance(double newBalance) {
    
  }
  
 /**
  * Adds the provided amount to the balance of the bank account.
  */    
  public void deposit(double amount){
    balance += amount;
  }
  
 /*
  * Subtracts the provided amount from the balance of the bank account.
  */    
  public void withdraw(double amount)throws InsufficientFundsException{
    if((balance - amount) > 0){
      balance -= amount;
    }else{
      throw new InsufficientFundsException("InsufficientFundsException: Insufficient funds for the withdrawal");
    }
  }
  
 /*
  * Returns the ID of the bank account.
  */    
  public int getID(){
    return id;
  }
  
 /**
  * Collects interest for the bank account.
  */    
  public abstract void collectInterest();
  
 /**
  * Returns the description of the bank account, including the owner, ID, and the balance.
  *
  * @return The description of the bank account, including the owner, ID, and the balance.
  */    
  public String toString(){
    return "Account id: " + id + "\nOwner: " + owner + "\nBalance: $" + String.format("%.2f", balance);
  }
}
