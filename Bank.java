import java.math.BigDecimal;

/**
 * Defines a bank of clients and accounts.
 * 
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public class Bank{
  /** The maximum number of clients this bank will handle. */
  private static final int MAX_CLIENTS = 1000;
  
  /** The maximum number of accounts this bank will handle. */
  private static final int MAX_ACCOUNTS = 1000;  //Maximum number of accounts
  
  /** The starting client ID. */
  private static final long CLIENT_ID_BASE = 1019999999999999l;
  
  /** The starting account ID. */
  private static final int ACCOUNT_ID_BASE = 499999;
  
  private BankClient[] clients;  //Array of clients
  private BankAccount[] accounts;  //Array of accounts
  private int numClients;  //Number of clients in bank
  private int numAccounts;  //Number of accounts in bank
  
 /**
  * Contructs a new bank.
  */  
  public Bank(){
    this.clients = new BankClient[MAX_CLIENTS];
    this.accounts = new BankAccount[MAX_ACCOUNTS];
    this.numClients = 0;
    this.numAccounts = 0;
  }

 /**
  * Adds a client to the bank with a specified first and last name.
  *
  * @param firstName The first name of the client.
  * @param lastName The last name of the client.
  */    
  public void addBankClient(String firstName, String lastName){
    this.clients[this.numClients ++] =
      new BankClient(firstName, lastName, (CLIENT_ID_BASE + this.numClients));                                                 
  }
  
 /**
  * Returns a reference of the client of the bank which matches the first and last name provided;
  * null otherwise.
  *
  * @param firstName The specified first name of the client to search.
  * @param lastName The specified last name of the client to search.
  * @return A copy of the client of the bank which matches the first and last name provided;
  *         null otherwise.
  */
  public BankClient getBankClient(String firstName, String lastName){
    for(int i = 0; i < this.numClients; i++) {
      if(this.clients[i].getFirstName().equals(firstName) &&
         this.clients[i].getLastName().equals(lastName)) {
        return clients[i];
      }
    }
    return null;
  }

 /**
  * Adds a new chequing account to the bank for the client with the beginning balance provided.
  * 
  * @param client The client which the chequing account belongs.
  * @param balance The balance of the chequing account.
  * @return The account number which belongs to the new chequing account.
  */    
  public int addChequingAccount(BankClient client, double balance){
    this.accounts[this.numAccounts ++] = new ChequingAccount(client, balance, (ACCOUNT_ID_BASE + this.numAccounts));
    return (ACCOUNT_ID_BASE + this.numAccounts);
  }
  
 /**
  * Adds a new savings account to the bank for the client with the beginning balance provided.
  *
  * @param client The client which the savings account belongs.
  * @param balance The balance of the savings account.
  * @return The account number which belongs to the new savings account.
  */    
  public int addSavingsAccount(BankClient client, BigDecimal balance){
    accounts[numAccounts ++] = new SavingsAccount(client, balance, (ACCOUNT_ID_BASE + this.numAccounts));
    return (ACCOUNT_ID_BASE + this.numAccounts);
  }
  
 /**
  * Returns a reference of the bank account of the bank which matches with the id provided; null otherwise.
  * 
  * @param id The specified account id.
  * @return The bank account of the bank which matches with the id provided; null otherwise.
  */    
  public BankAccount getBankAccount(int id){
    for(int i = 0; i < numAccounts; i++){
      if(accounts[i].getID() == id){
        return accounts[i];
      }
    }
    return null;
  }
  
 /**
  * Pays interest to all the savings accounts of the bank.
  */    
  public void payInterest(){
    for(int i = 0; i < numAccounts; i++){
      this.accounts[i].collectInterest();
    }
  }
}
