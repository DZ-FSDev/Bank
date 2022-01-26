import java.io.*;
import java.util.*;
import java.math.BigDecimal;

/**
 * Reads input and parses through the commands of a provided file.  
 * Exceptions are raised for the commands which encounter errors.
 * 
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class Main{
  
  private final static String FILE_NAME = "TEST_FILE.txt";
  
 /**
  * Initiates the reading of the file and performs commands according to the input file provided.
  */    
  public static void main(String[] args){
    Bank bank = new Bank();
    try{
      readInputFile(FILE_NAME, bank);
    }catch(Exception e){
      System.out.println(e);
    }
  }
  
 /**
  * Reads the specified file line by line and passes it to the parse command method.
  *
  * @param file The input file containing the commands to be excuted.
  * @param bank The bank for the commands to be executed on.
  */    
  public static void readInputFile(String file, Bank bank) throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    while((line = reader.readLine()) != null){
      try{
        parseCommand(line, bank);
      }catch(WrongCommandException e){
        System.out.println(e);
      }
    }
    reader.close();
  }
  
 /**
  * Performs the required actions based on the specified command line by reading the provided tokens one by one.
  *
  * @param line The command line to be parsed.
  * @param bank The bank for the commands to be excuted on.
  * @throws WrongCommandException Thrown when an unrecognized command is parsed.
  */    
  public static void parseCommand(String line, Bank bank) throws Exception{
    Scanner lineReader = new Scanner(line);
    String token = "";
    if(lineReader.hasNext()){
      token = lineReader.next();
    }
    if(token.equals("")){
    }else if(token.equals("#")){
      processComment(line);
    }else if(token.equals("NEW-CLIENT")){
      newClient(lineReader, bank);
    }else if(token.equals("GET-CLIENT-INFO")){
      getClientInfo(lineReader, bank);
    }else if(token.equals("NEW-ACCOUNT")){
      newAccount(lineReader, bank);
    }else if(token.equals("GET-ACCOUNT-INFO")){
      getAccountInfo(lineReader, bank);
    }else if(token.equals("WITHDRAW")){
      withdraw(lineReader, bank);
    }else if(token.equals("DEPOSIT")){
      deposit(lineReader, bank);
    }else if(token.equals("INTEREST")){
      interest(bank);
    }else{
      lineReader.close();
      throw new WrongCommandException("The command " + token + " is not recognized.");
    }
  }
  
 /**
  * Prints out a specified line.
  *
  * @param line The line to be printed.
  */    
  public static void processComment(String line){
    System.out.println(line);
  }
  
 /**
  * Adds a new client to the bank.  Throws an exception if any errors are encountered.
  *
  * @param scanner The Scanner to read the next two tokens of first name then last name.
  * @param bank The bank for the new client to be added to.
  * @throws InvalidCommandArgsException Thrown when either a first or last name is missing.
  */    
  public static void newClient(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    try{
      bank.addBankClient(scanner.next(), scanner.next());
      System.out.println("NEW CLIENT CREATED");
    }catch(Exception e){
      throw new InvalidCommandArgsException("NEW-CLIENT: First or last name is missing.");
    }
  }
  
 /**
  * Prints the account info of a bank client.  Throws an exception if any errors are encountered.
  *
  * @param scanner The Scanner to read the next two tokens of first name then last name.
  * @param bank The bank for the client info to be retrieved from.
  * @throws InvalidCommandArgsException Thrown when either a first or last name is missing.
  */    
  public static void getClientInfo(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    try{
      BankClient client = bank.getBankClient(scanner.next(), scanner.next());
      if(client == null){
        System.out.println("CLIENT NOT FOUND");
      }else{
        System.out.println(client);
      }
    }catch(Exception e){
      throw new InvalidCommandArgsException("GET-CLIENT-INFO: First or last name is missing.");
    }
  }
  
 /**
  * Creates a new account for a bank client.  Throws an exception if any errors are encountered.
  *
  * @param scanner The Scanner to read the next four tokens of bank accoun type, first name, last name, then opening balance.
  * @param bank The bank for the new account to be added to.
  * @throws InvalidCommandArgsException Thrown when either an account type, first or last name, or opening balance is missing or invalid.
  */    
  public static void newAccount(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    BankClient client;
    String type, first, last;
    BigDecimal balance;
    try{
      type = scanner.next();
      first = scanner.next();
      last = scanner.next();
      balance = BigDecimal.valueOf(scanner.nextDouble());
      client = bank.getBankClient(first, last);
    }catch(Exception e){
      throw new InvalidCommandArgsException("NEW-ACCOUNT: account type, first name, last name or balance is missing.");
    }
    if(client == null){
      System.out.println("CLIENT NOT FOUND");
    }else if(type.equals("CHQ")){
      int accountID = bank.addChequingAccount(client, balance);
      System.out.println("NEW ACCOUNT OF TYPE " + type + " CREATED WITH ID = " + accountID);
    }else if(type.equals("SVG")){
      int accountID = bank.addSavingsAccount(client, balance);
      System.out.println("NEW ACCOUNT OF TYPE " + type + " CREATED WITH ID = " + accountID);
    }else{
      throw new InvalidCommandArgsException("NEW-ACCOUNT: " + type + " is not a valid account type.");
    }
  }
  
 /**
  * Prints the account info a bank account.  Throws an exception the account of specified ID is not found or missing.
  *
  * @param scanner The Scanner to read the next token of bank ID.
  * @param bank The bank for the account info to be retrieved from.
  * @throws InvalidCommandArgsException Thrown when either an invalid bank ID is provided.
  */    
  public static void getAccountInfo(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    try{
      BankAccount account = bank.getBankAccount(scanner.nextInt());
      if(account == null){
        System.out.println("ACCOUNT NOT FOUND");
      }else{
        System.out.println(account);
      }
    }catch(Exception e){
      throw new InvalidCommandArgsException("GET-ACCOUNT-INFO: accountId is missing or incorrect.");
    }
  }
  
 /**
  * Processes a deposit on a bank account.  Throws an exception the account of specified ID is not found or missing.
  *
  * @param scanner The Scanner to read the next token of bank ID.
  * @param bank The bank to process the deposit.
  * @throws InvalidCommandArgsException Thrown when either an invalid bank ID is provided.
  */    
  public static void deposit(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    try{
      BankAccount account = bank.getBankAccount(scanner.nextInt());
      BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());
      if(account == null){
        System.out.println("ACCOUNT NOT FOUND");
      }else{
        account.deposit(amount);
        System.out.println("DEPOSIT COMPLETED");
      }
    }catch(Exception e){
      throw new InvalidCommandArgsException("DEPOSIT: accountID or amount is missing or incorrect.");
    }
  }
  
 /**
  * Processes a withdrawal on a bank account.  Throws an exception the account of specified ID is not found or missing.
  *
  * @param scanner The Scanner to read the next token of bank ID.
  * @param bank The bank to process the withdrawal.
  * @throws InvalidCommandArgsException Thrown when either an invalid bank ID is provided.
  */    
  public static void withdraw(Scanner scanner, Bank bank) throws InvalidCommandArgsException{
    try{
      BankAccount account = bank.getBankAccount(scanner.nextInt());
      BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());
      if(account == null){
        System.out.println("ACCOUNT NOT FOUND");
      }else{
        try{
          account.withdraw(amount);
          System.out.println("WITHDRAWAL COMPLETED");
        }catch(Exception e){
          System.out.println(e);
        }
      }
    }catch(Exception e){
      throw new InvalidCommandArgsException("WITHDRAW: accountID or amount is missing or incorrect.");
    }
  }
  
 /**
  * Pays the interest to the savings accounts of the specified bank.
  *
  * @param bank The bank to process the interest payment.
  */    
  public static void interest(Bank bank){
    bank.payInterest();
    System.out.println("INTEREST WAS PAID");
  }
  }
