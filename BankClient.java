/*
 * BankClient
 * 
 * PURPOSE: Defines a bank client of first and last name and their ID.
 */
public class BankClient{
  
  private String firstName;  //First name of bank client
  private String lastName;  //Last name of bank client
  private long bankID;  //Bank ID of bank client
  
 /*
  * Constructor of bank client.  Sets instance variables to the passed parameters.
  */    
  public BankClient(String firstName, String lastName, long bankID){
    this.firstName = firstName;
    this.lastName = lastName;
    this.bankID = bankID;
  }
  
 /*
  * Returns a description of the bank client with first and last name and ID.
  */    
  public String toString(){
    return firstName + " " + lastName + " (" + bankID + ")"; 
  }
  
 /*
  * Returns the first name of the bank client.
  */    
  public String getFirstName(){
    return firstName;
  }
  
 /*
  * Returns the last name of the bank client.
  */    
  public String getLastName(){
    return lastName;
  }
}
