/*

 * UserIdsGenerator
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

public class UserIdsGenerator {
    private static UserIdsGenerator Instance;
    private int lastId;
    

    private UserIdsGenerator() {
        this.lastId = 0;
    }

    public int generateId() {
        return ++lastId;
    }

    public static UserIdsGenerator getInstance() {
        if (UserIdsGenerator.Instance == null)
            UserIdsGenerator.Instance = new UserIdsGenerator();
        return UserIdsGenerator.Instance;
    }
}