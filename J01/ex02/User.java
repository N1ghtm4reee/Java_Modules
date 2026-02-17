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
    public int id;
    public String Name;
    public Long Balance;

    public User() {
        this.id = UserIdsGenerator.getInstance().generateId();
    }
}