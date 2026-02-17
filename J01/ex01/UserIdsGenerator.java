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
    int lastId;
    

    private UserIdsGenerator() {
        this.lastId = 0;
    }
    
    public void CreateInstance() {
        this.Instance = new UserIdsGenerator();
    }

    public int generateId() {
        return (lastId = lastId + 1);
    }

    public static UserIdsGenerator getInstance() {
        if (UserIdsGenerator.Instance == null)
            UserIdsGenerator.Instance = new UserIdsGenerator();
        return UserIdsGenerator.Instance;
    }
}