

class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "Ayoub", 1000L);
        User user2 = new User(2, "John", 0L);

        Transaction transfer = new Transaction(user2, user1, transferCategory.credits, 500L);
        System.out.println("Transfer id: " + transfer.Id);
        System.out.println("Transfer status: " + transfer.status);
    }
}
