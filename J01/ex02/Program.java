/*

 * Program
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

class Program {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        user1.Name = "Ayoub";
        user1.Balance = 1500L;

        user2.Name = "Hugo";
        user2.Balance = 500L;

        UsersArrayList users = new UsersArrayList();
        users.addUser(user1);
        System.out.println(users.usersData[0].Name);

        System.out.println(users.index);
    }
}