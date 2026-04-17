package ex03;

public class Program {
    
    public static void main(String[] args) {
        User user1 = new User("Ayoub", 1000L);
        User user2 = new User("John", 500L);
        TransactionsList transactionsList = new TransactionsLinkedList();

        Transaction transaction1 = new Transaction(user2, user1, transferCategory.credits, 200L);
        transactionsList.add(transaction1);

        System.out.println("Transaction ID: " + transactionsList.get(transaction1.Id));

    }
}
