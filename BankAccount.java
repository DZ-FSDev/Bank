import java.math.BigDecimal;

/**
 * Defines a bank account of its owner and account balance.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.6
 */
public abstract class BankAccount implements Cloneable{
  private final BankClient OWNER;  //Owner of the bank account.
  protected BigDecimal balance;  //Balance of the bank account.
  private final int ID;  //ID of the bank account.
  
 /**
  * Constructs a bank account with a specified owner, balance and id.
  * 
  * @param owner The specified owner of this bank account.
  * @param balance The specified starting balance of this bank account.
  * @param id The specified id of this bank account.
  * @throws IllegalArgumentException Thrown when an invalid owner, balance, or ID was specified.
  */
  public BankAccount(BankClient owner, BigDecimal balance, int id) throws IllegalArgumentException {
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
  public void setBalance(BigDecimal newBalance) throws IllegalArgumentException{
    validateBalanceAmount(newBalance);
    
    this.balance = newBalance;
  }
  
 /**
  * Adds the provided amount to the balance of the bank account as a deposit.
  *
  * @param amount The specified amount to deposit.
  * @throws IllegalArgumentException Thrown when a non-number or negative number is provided.
  */    
  public void deposit(BigDecimal amount) throws IllegalArgumentException{
    validatePositiveAmount(amount);
    
    this.balance = this.balance.add(amount);
  }
  
 /**
  * Subtracts the provided amount from the balance of the bank account as a withdrawal.
  *
  * @param amount The specified amount to be withdrawn.
  * @throws InsufficientFundsException Thrown when there is not enough funds for the
  *         withdrawal.
  * @throws IllegalArgumentException Thrown when a non-number or negative number is provided.
  */    
  public void withdraw(BigDecimal amount)throws InsufficientFundsException, IllegalArgumentException{
    validatePositiveAmount(amount);
    
    if((balance.subtract(amount)).doubleValue() > 0){
      balance = balance.subtract(amount);
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
    return this.ID;
  }

 /**
  * Returns the balance of the bank account.
  * 
  * @return The balance of the bank account.
  */    
  public BigDecimal getBalance(){
    return this.balance;
  }
  
 /**
  * Validates whether a specified amount is a valid value for a balance.
  * Balances cannot be NaN, positive infinity, or negative infinity.
  *
  * @param amount The specified amount.
  * @throws IllegalArgumentException Thrown when amount is NaN, or +/- infinity.
  */
  private static void validateBalanceAmount(BigDecimal amount) throws IllegalArgumentException {
    if(!Double.isFinite(amount.doubleValue())) {
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
  private static void validatePositiveAmount(BigDecimal amount) throws IllegalArgumentException {
    if(amount.doubleValue() < 0 || !Double.isFinite(amount.doubleValue())) {
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
    return (BankAccount)this.clone();
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
    stringBuilder.append(ID);
    stringBuilder.append("\nOwner: ");
    stringBuilder.append(OWNER);
    stringBuilder.append("\nBalance: $");
    stringBuilder.append(balance.setScale(2));
    
    return stringBuilder.toString();
  }
}
