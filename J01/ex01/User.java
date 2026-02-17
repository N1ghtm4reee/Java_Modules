/*

 * User
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

public class User {
    public final int id;
    String Name;
    Long Balance;

    public User() {
        this.id = UserIdsGenerator.getInstance().generateId();
    }
}