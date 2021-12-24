/*
 * Bank
 * 
 * PURPOSE:  Defines a bank of clients and accounts.
 */
public class Bank{
  private static final int MAX_CLIENTS = 1000;  //Maximum number of clients [People]
  private static final int MAX_ACCOUNTS = 1000;  //Maximum number of accounts
  private BankClient[] clients;  //Array of clients
  private BankAccount[] accounts;  //Array of accounts
  private int numClients;  //Number of clients in bank
  private int numAccounts;  //Number of accounts in bank
  
 /*
  * Contructor of bank.  Initializes arrays for the clients and accounts.
  */  
  public Bank(){
    this.clients = new BankClient[MAX_CLIENTS];
    this.accounts = new BankAccount[MAX_ACCOUNTS];
    this.numClients = 0;
    this.numAccounts = 0;
  }

 /*
  * Adds a client to the bank of first and last name.
  */    
  public void addBankClient(String firstName, String lastName){
    this.clients[this.numClients ++] =
      new BankClient(firstName, lastName, (1019999999999999l + this.numClients));                                                 
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
    this.accounts[this.numAccounts ++] = new ChequingAccount(client, balance, (499999 + this.numAccounts));
    return (499999 + this.numAccounts);
  }
  
 /*
  * Adds a new savings account to the bank for the client with the beginning balance provided.
  */    
  public int addSavingsAccount(BankClient client, double balance){
    accounts[numAccounts ++] = new SavingsAccount(client, balance, (499999 + this.numAccounts));
    return (499999 + this.numAccounts);
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
