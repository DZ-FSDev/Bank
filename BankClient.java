/**
 * Defines a bank client of first and last name and their ID.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class BankClient{
  
  private String firstName;  //First name of bank client
  private String lastName;  //Last name of bank client
  private long bankID;  //Bank ID of bank client
  
 /**
  * Constructor of bank client.  Sets instance variables to the passed parameters.
  *
  * @param firstName The specified first name of this bank client.
  * @param lastName The specified last name of this bank client.
  * @param bankID The specified bank ID of this bank client.
  */    
  public BankClient(String firstName, String lastName, long bankID){
    this.firstName = firstName;
    this.lastName = lastName;
    this.bankID = bankID;
  }
  
 /**
  * Returns the first name of the bank client.
  *
  * @return The first name of the bank client.
  */    
  public String getFirstName(){
    return firstName;
  }
  
 /**
  * Returns the last name of the bank client.
  * 
  * @return The last name of the bank client.
  */    
  public String getLastName(){
    return lastName;
  }
  
  /**
  * Returns a description of the bank client with first and last name and ID.
  *
  * @return The description of the bank client with first and last name and ID.
  */
  @Override
  public String toString(){
    return firstName + " " + lastName + " (" + bankID + ")"; 
  }
}
