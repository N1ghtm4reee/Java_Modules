

class Program {
    public static void main(String[] args) {
        User user1 = new User("Ayoub", 1500L);
        User user2 = new User("Hugo", 500L);

        UsersArrayList users = UsersArrayList.getInstance();
        users.addUser(user1);
        System.out.println(users.usersData[0].getName());

        System.out.println(users.index);
    }
}