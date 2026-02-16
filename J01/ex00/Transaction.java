/*

 * Transaction
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

enum transferCategory {
    credits,
    debits
}

public class Transaction {
    int Identifier;
    String Recipient;
    String Sender;
    transferCategory category;
    Long transferAmount;

    Long getSenderBalance();
    Long setRecipientBalance();

}