
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

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String m) {
        super(m);  
    }
}

class UsersArrayList implements UsersList {
    private static UsersArrayList UsersArrayListInstnce;
    User[] usersData;
    int index;
    int arrayMaxSize;

    private UsersArrayList() {
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
        User user = null;
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i].id == id) {
                user = usersData[i];
            }
        }
        if (user == null){
            throw new UserNotFoundException("User not found!");
        }
        return user;
    }
    @Override
    public User getUserByIndex(int index) {
        User user = null;
        for (int i = 0; i < usersData.length; i++) {
            if (i == index) {
                user = usersData[i];
            }
        }
        if (user == null){
            throw new UserNotFoundException("User not found!");
        }
        return user;
    }
    @Override
    public int getUsersCount() {
        return index;
    }
    public static UsersArrayList getInstance() {
        if (UsersArrayList.UsersArrayListInstnce == null) {
            UsersArrayList.UsersArrayListInstnce = new UsersArrayList();
        }
        return UsersArrayList.UsersArrayListInstnce;
    }
}