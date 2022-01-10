/**
 * Defines a bank account of its owner and account balance.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.4
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
    if(owner == null) throw new IllegalArgumentException("Owner cannot be null!");
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
    validateBalanceAmount(amount);
    
    this.balance = newBalance;
  }
  
 /**
  * Adds the provided amount to the balance of the bank account as a deposit.
  *
  * @param amount The specified amount to deposit.
  * @throws IllegalArgumentException Thrown when a non-number or negative number is provided.
  */    
  public void deposit(double amount) throws IllegalArgumentException{
    validatePositiveAmount(amount);
    
    balance += amount;
  }
  
 /**
  * Subtracts the provided amount from the balance of the bank account as a withdrawal.
  *
  * @param amount The specified amount to be withdrawn.
  * @throws InsufficientFundsException Thrown when there is not enough funds for the
  *         withdrawal.
  * @throws IllegalArgumentException Thrown when a non-number or negative number is provided.
  */    
  public void withdraw(double amount)throws InsufficientFundsException, IllegalArgumentException{
    validatePositiveAmount(amount);
    
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
  * Validates whether a specified amount is a valid value for a balance.
  * Balances cannot be NaN, positive infinity, or negative infinity.
  *
  * @param amount The specified amount.
  * @throws IllegalArgumentException Thrown when amount is NaN, or +/- infinity.
  */
  private static void validateBalanceAmount(double amount) throws IllegalArgumentException {
    if(!Double.isFinite(amount)) {
      throw new IllegalArgumentException(amount + " is not a valid balance.");
    }
  }
  
 /**
  * Validates whether a specified amount is a valid value for a positive balance.
  * Balances cannot be NaN, positive infinity, or negative infinity.
  *
  * @param amount The specified amount.
  * @throws IllegalArgumentException Thrown when amount is NaN, or +/- infinity, or negative.
  */
  private static void validatePositiveAmount(double amount) throws IllegalArgumentException {
    if(amount < 0 || !Double.isFinite(amount)) {
      throw new IllegalArgumentException(amount + " is not a valid positive amount.");
    }
  }
  
 /**
  * Collects interest for the bank account.
  */    
  public abstract void collectInterest();
  
 /**
  * Returns a clone of this Bank Account.
  * 
  * @return A clone of this Bank Account.
  */
  @Override
  protected BankAccount clone(){
    return new BankAccount(owner.clone(), balance, id);
  }
  
 /**
  * Returns the description of the bank account, including the owner, ID, and the balance.
  *
  * @return The description of the bank account, including the owner, ID, and the balance.
  */
  @Override
  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append("Account id: ");
    stringBuilder.append(id);
    stringBuilder.append("\nOwner: ");
    stringBuilder.append(owner);
    stringBuilder.append("\nBalance: $");
    stringBuilder.append(String.format("%.2f", balance));
    
    return stringBuilder.toString();
  }
}
