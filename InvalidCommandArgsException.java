/*
 * InvalidCommandArgsException
 * 
 * PURPOSE: Defines the exception to be thrown when an invalid argument is read by the parser.
 */
public class InvalidCommandArgsException extends WrongCommandException{
  
 /*
  * Constructor of insufficient funds exception.  Calls the super constructor and passes a message provided as a parameter.
  */    
  public InvalidCommandArgsException(String message){
    super(message);
  } 
}
