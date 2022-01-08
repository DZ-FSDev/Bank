/**
 * Defines a subclass chequing account of an owner, balance, and ID.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class ChequingAccount extends BankAccount {
  /** The transaction fee for each withdrawal. */
  private static final double TRANSACTION_FEE = 4.95;  //Fixed transaction fee for each withdrawal [$]
  
 /**
  * Constructs a new chequing account.
  *
  * @param owner The specified owner of this chequing account.
  * @param balance The specified opening balance of this chequing account.
  * @param id The specified id of this chequing account.
  */    
  public ChequingAccount(BankClient owner, double balance, int id){
    super(owner, balance, id);
  }
  
 /**
  * Subtracts the provided amount from the balance of the bank account using the super class method.
  * Subtracts the transaction fee which can leave the account at a negative balance.
  *
  * @param amount The specified amount to be withdrawn.
  * @throws InsufficientFundsException Thrown when there is not enough funds for the
  *         withdrawal.
  */    
  public void withdraw(double amount)throws InsufficientFundsException{
    super.withdraw(amount);
    super.balance -= TRANSACTION_FEE;
  }
    
 /**
  * Returns a description of the account type and its details using the super class method.
  *
  * @return The description of the chequing account, including the owner, ID, and the balance.
  */
  @Override
  public String toString(){
    return "Chequing " + super.toString();
  }
}
