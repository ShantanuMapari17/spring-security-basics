package Learning.spring.boot.security.controllers;

import Learning.spring.boot.security.models.User;
import Learning.spring.boot.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello SPRING-SECURITY";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/helloAdmin")
    public String helloAdmin(){
        return "Hello ADMIN";
    }

    //all users
    @GetMapping("/")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    //return single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
