/**
 * Defines the exception to be thrown when there are insufficient funds in the account during a withdrawal attempt.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class InsufficientFundsException extends Exception {
 /**
  * Contructs a new insufficient funds exception.  
  * Calls the super constructor and passes a message provided as a parameter.
  *
  * @param message The specified exception message to be passed to the super constructor.
  */    
  public InsufficientFundsException(String message){
    super(message);
  }
}
