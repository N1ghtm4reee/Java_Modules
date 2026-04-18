package ex03;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Ayoub", 1000L);
        User user2 = new User("John", 500L);
        User user3 = new User("Sara", 300L);

        TransactionsList transactionsList = new TransactionsLinkedList();

        Transaction transaction1 = new Transaction(user2, user1, transferCategory.credits, 200L);
        Transaction transaction2 = new Transaction(user3, user2, transferCategory.credits, 100L);
        Transaction transaction3 = new Transaction(user1, user3, transferCategory.debits, 50L);

        System.out.println("Initial balances:");
        printBalances(user1, user2, user3);

        System.out.println("\nAdding transactions to the list...");
        transactionsList.add(transaction1);
        transactionsList.add(transaction2);
        transactionsList.add(transaction3);
        printTransactions(transactionsList.toArray());

        System.out.println("\nTesting get(id):");
        Transaction foundTransaction = transactionsList.get(transaction2.getId());
        if (foundTransaction != null) {
            System.out.println("Found transaction: " + describeTransaction(foundTransaction));
        } else {
            System.out.println("Transaction was not found.");
        }

        System.out.println("\nTesting remove(existing transaction):");
        transactionsList.remove(transaction2);
        printTransactions(transactionsList.toArray());

        System.out.println("\nTesting remove(missing transaction):");
        try {
            transactionsList.remove(transaction2);
        } catch (TransactionNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\nTesting get(id) after removal:");
        Transaction removedTransaction = transactionsList.get(transaction2.getId());
        System.out.println(removedTransaction == null ? "Transaction removed successfully." : "Transaction still exists.");

        System.out.println("\nFinal balances after executing the transactions:");
        printBalances(user1, user2, user3);
    }

    private static void printBalances(User... users) {
        for (User user : users) {
            System.out.println(user.getName() + " balance: " + user.getBalance());
        }
    }

    private static void printTransactions(Transaction[] transactions) {
        System.out.println("Transactions count: " + transactions.length);
        for (Transaction transaction : transactions) {
            System.out.println(describeTransaction(transaction));
        }
    }

    private static String describeTransaction(Transaction transaction) {
        return "id=" + transaction.getId()
                + ", sender=" + transaction.Sender.getName()
                + ", recipient=" + transaction.Recipient.getName()
                + ", category=" + transaction.category
                + ", amount=" + transaction.transferAmount
                + ", status=" + transaction.status;
    }
}
