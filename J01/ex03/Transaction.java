package ex03;

/*

 * Transaction
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

import java.util.UUID;

enum transferCategory {
    credits,
    debits
}


enum transferStatus {
    success,
    failed,
    pending
}

public class Transaction {
    String Id = UUID.randomUUID().toString();
    User Recipient;
    User Sender;
    transferCategory category;
    Long transferAmount;
    transferStatus status;


    Transaction(User Recipient, User Sender, transferCategory category, Long transferAmount) {
        this.Recipient = Recipient;
        this.Sender = Sender;
        this.category = category;
        this.transferAmount = transferAmount;

        int status = this.executeTransfer(this.Sender, this.Recipient, this.category, this.transferAmount);
        if (status == 0) {
            this.status = transferStatus.success;
        } else {
            this.status = transferStatus.failed;
        }
    }


    public int executeTransfer(User Sender, User Recipient, transferCategory category, Long transferAmount) {
        // Implementation for executing the transfer
        Long senderBalance = getSenderBalance(this.Sender);
        if (category == transferCategory.credits) {
            if (senderBalance >= transferAmount) {
                Long newSenderBalance = senderBalance - transferAmount;
                setRecipientBalance(this.Recipient, this.Recipient.getBalance() + transferAmount);
                setRecipientBalance(this.Sender, newSenderBalance);
                return 0; // Transfer successful
            } else {
                System.out.println("Insufficient balance for the transfer.");
                return -1;
            }
        } else if (category == transferCategory.debits) {
            Long newSenderBalance = senderBalance + transferAmount;
            setRecipientBalance(this.Recipient, this.Recipient.getBalance() - transferAmount);
            setRecipientBalance(this.Sender, newSenderBalance);
            return 0; // Transfer successful
        }
        return -1; // Transfer failed
    }
    Long getSenderBalance(User sender) {
        return sender.getBalance();
    }
    void setRecipientBalance(User recipient, Long newBalance) {
        recipient.setNewBalance(newBalance);
    }

}