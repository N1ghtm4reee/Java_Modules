
import java.util.Arrays;

/*

 * UsersArrayList
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

class UsersArrayList implements UsersList {
    User[] usersData;
    int index;
    int arrayMaxSize;

    public UsersArrayList() {
        arrayMaxSize = 10;
        index = 0;
        usersData = new User[arrayMaxSize];
    }
    @Override
    public void addUser(User user) {
        if (index == arrayMaxSize) { /* Resize By adding Half the old size*/
            arrayMaxSize += (arrayMaxSize / 2);
            User[] newArray = new User[arrayMaxSize];
            newArray = Arrays.copyOf(usersData, arrayMaxSize);
            usersData = newArray;
        }
        usersData[index] = user;
        index++;
    }
    @Override
    public User getUserById(int id) {
        return null;
    }
    @Override
    public User getUserByIndex(int index) {
        return null;
    }
    @Override
    public int getUsersCount() {
        return 0;
    }
}