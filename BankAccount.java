/*
 * BankAccount
 * 
 * PURPOSE:  Defines an abstract bank account of its owner and account balance.
 */
public abstract class BankAccount{
  
  protected BankClient owner;  //Owner of the bank account.
  protected double balance;  //Balance of the bank account.
  protected int id;  //ID of the bank account.
  
 /*
  * Constructor or bank account.  Sets instance variables to the passed parameters.
  */    
  public BankAccount(BankClient owner, double balance, int id){
    this.owner = owner;
    this.balance = balance;
    this.id = id;
  }
  
 /*
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
  
 /*
  * Dummy method to enable polymorphism.
  */    
  public void collectInterest(){}
  
 /*
  * Returns the description of the bank account, including the owner, ID, and the balance.
  */    
  public String toString(){
    return "Account id: " + id + "\nOwner: " + owner + "\nBalance: $" + String.format("%.2f", balance);
  }
}
