

/*

 * Program
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

// import transaction

class Program {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        Transaction trans = new Transaction();

        user1.Identifier = 1;
        user1.Name = "Ayoub";
        user1.Balance = 1500L;

        user2.Identifier = 2;
        user2.Name = "Hugo";
        user2.Balance = 500L;

        trans.Identifier = 1;
        trans.Sender = user1;
        trans.Recipient = user2;
        trans.category = transferCategory.credits;
        trans.transferAmount = 500L;
    }
}