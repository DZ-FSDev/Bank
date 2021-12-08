/*
 * InsufficientFundsException
 * 
 * PURPOSE:  Defines the exception to be thrown when there are insufficient funds in the account during a withdrawal attempt.
 */
public class InsufficientFundsException extends Exception {
  
 /*
  * Constructor of insufficient funds exception.  Calls the super constructor and passes a message provided as a parameter.
  */    
  public InsufficientFundsException(String message){
    super(message);
  }
}
