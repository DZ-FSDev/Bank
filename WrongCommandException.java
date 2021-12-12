/*
 * WrongCommandException
 * 
 * PURPOSE: Defines the exception to be thrown when an wrong command is read by the parser.
 */
public class WrongCommandException extends Exception{
  
 /*
  * Constructor of wrong command exception.  Calls the super constructor and passes a message provided as a parameter.
  */    
  public WrongCommandException(String message){
    super(message);
  }
}
