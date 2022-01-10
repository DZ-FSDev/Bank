/**
 * Defines the exception to be thrown when an invalid argument is read by the parser.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class InvalidCommandArgsException extends WrongCommandException{
 /**
  * Constructor of insufficient funds exception.  
  * Calls the super constructor and passes a message provided as a parameter.
  *
  * @param message The specified exception message to be passed to the super constructor.
  */    
  public InvalidCommandArgsException(String message){
    super(message);
  } 
}
