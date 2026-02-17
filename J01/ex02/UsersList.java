/*

 * UsersList
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */


interface UsersList {
    void addUser(User user);
    User getUserById(int id);
    User getUserByIndex(int index);
    int getUsersCount();
}