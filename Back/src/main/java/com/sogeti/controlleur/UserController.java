package com.sogeti.controlleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sogeti.service.UserService;

import exception.PasswordIncorrectException;
import exception.UserNotFoundException;

import com.sogeti.model.User;

@RestController
@RequestMapping("/sport/users")
public class UserController {
	@Autowired
	UserService userService;
	
	/* Request for finding all users */
	@GetMapping("/all")
	@CrossOrigin(origins = "*")
    public List<User> findAll()
	{
        return userService.findAll();
    }
	
	/* Request for finding one user by his username */
	@CrossOrigin(origins = "*")
	@GetMapping("/{username}")
    public User findUser(@PathVariable String username)
	{
        return userService.findByUsername(username);
    }

	
	/* Requests for login */
	@CrossOrigin(origins = "*")
	@PostMapping("/connexion")
    public User verifPassword(@RequestBody User user) 
	{	
		System.out.println("this user is :" + user);
        
        try {
            return userService.verifPassword(user);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "User Not Found", ex);
        } catch (PasswordIncorrectException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "password Incorrect", e);
		}
    }
	
	
	/* Request for register */
	@CrossOrigin(origins = "*")
	@PostMapping("/adduser")
    public User insertMyUser(@RequestBody User user)
	{
		 try {
	            return userService.insertUser(user);
	        } catch (Exception ex) {
	            throw new ResponseStatusException(
	              HttpStatus.NOT_FOUND, "User Already Exists", ex);
        
    }
		 }
	
	/* Request for deleting users*/
	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteuser/{username}")
    public void deleteUser(@PathVariable String username)
	{
		userService.deleteByUsername(username);
    }

}
