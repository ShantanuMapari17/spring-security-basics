package Learning.spring.boot.security.services;

import Learning.spring.boot.security.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService(){
        list.add(new User("shantanu","1234","shatanumapari17@gmail.com"));
        list.add(new User("akshay", "12345","akmapari@gmail.com"));
        list.add(new User("harsha","12346","hsmapari@gmail.com"));
    }

    public List<User> getAllUsers(){
        return this.list;
    }

    public User getUser(String username){
        return this.list.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
