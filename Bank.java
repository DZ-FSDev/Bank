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
  private static final long ACCOUNT_ID_BASE = 499999;
  
  private BankClient[] clients;  //Array of clients
  private BankAccount[] accounts;  //Array of accounts
  private long numClients;  //Number of clients in bank
  private long numAccounts;  //Number of accounts in bank
  
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
  
 /*
  * Returns the client of the bank which matches with the first and last name provided.
  */
  public BankClient getBankClient(String firstName, String lastName){
    for(int i = 0; i < this.numClients; i++){
      if(this.clients[i].getFirstName().equals(firstName) &&
         this.clients[i].getLastName().equals(lastName)) {
        return clients[i].clone();
      }
    }
    return null;
  }

 /*
  * Adds a new chequing account to the bank for the client with the beginning balance provided.
  */    
  public int addChequingAccount(BankClient client, double balance){
    this.accounts[this.numAccounts ++] = new ChequingAccount(client, balance, (ACCOUNT_ID_BASE + this.numAccounts));
    return (ACCOUNT_ID_BASE + this.numAccounts);
  }
  
 /*
  * Adds a new savings account to the bank for the client with the beginning balance provided.
  */    
  public int addSavingsAccount(BankClient client, double balance){
    accounts[numAccounts ++] = new SavingsAccount(client, balance, (ACCOUNT_ID_BASE + this.numAccounts));
    return (ACCOUNT_ID_BASE + this.numAccounts);
  }
  
 /*
  * Returns the bank account of the bank which matches with the id provided.
  */    
  public BankAccount getBankAccount(int id){
    for(int i = 0; i < numAccounts; i++){
      if(accounts[i].getID() == id){
        return this.accounts[i];
      }
    }
    return null;
  }
  
 /*
  * Pays interest to all the savings accounts of the bank.
  */    
  public void payInterest(){
    for(int i = 0; i < numAccounts; i++){
      this.accounts[i].collectInterest();
    }
  }
}
