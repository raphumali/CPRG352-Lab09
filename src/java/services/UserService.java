
package services;

import dataaccess.RoleDB;
import models.*;
import dataaccess.UserDB;
import java.util.List;



public class UserService {
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean activity, String firstname, String lastname, String password, int roleID) throws Exception{
       User user = new User(email, activity, firstname, lastname, password);
        RoleDB roleDB = new RoleDB();
        UserDB userDB = new UserDB();
        Role role = roleDB.get(roleID); 
        user.setRole(role);
        userDB.insert(user);
    }
    
    public void update(String email, boolean activity, String firstname, String lastname, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }

   
}







