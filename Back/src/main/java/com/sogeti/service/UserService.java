package com.sogeti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sogeti.model.User;
import com.sogeti.repository.UserRepository;

import exception.PasswordIncorrectException;
import exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * findByusername method finds the user who has the username:
	 * 
	 * @param username
	 * @return User who matches this username
	 */
	public User findByUsername(String username) {
		Optional<User> u = userRepository.findByUsername(username);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	/**
	 * findAll method returns all the users recorded in the database
	 * 
	 * @return the list of users
	 */
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	/**
	 * insertUser method allows us to register and add new users in our users
	 * database
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User insertUser(User user) throws Exception {

		User fetchuser = findByUsername(user.getUsername());
		// if the fetched user doesn't exist in the database : inserted in the user
		// table
		if (fetchuser == null) {

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
		// if the fetched user exists already in the database : throw an exception
		else
			throw new Exception();

	}

	/**
	 * 
	 * @param args : the features (username, password, ...) of the user who tried to
	 *             signin
	 * @return user : if the password of the user matches the password cooresponding
	 * @throws Exception
	 */
	public User verifPassword(User args) throws UserNotFoundException, PasswordIncorrectException {
		User user = findByUsername(args.getUsername());

		if (user == null)
			throw new UserNotFoundException();
		if (passwordEncoder.matches(args.getPassword(), user.getPassword())) {
			return user;
		} else
			throw new PasswordIncorrectException();
	}

	public boolean verifPassword(long id, String password) {
		Optional<User> userOption = findById(id);
		if (userOption.isPresent()) {
			User user = userOption.get();
			return passwordEncoder.matches(password, user.getPassword());
		}
		return false;
	}

//	public boolean verifPassword(String username, String password)
//	{
//		Optional<User> userOption = findByUsername(username);
//		if(userOption.isPresent()) {
//			User user = userOption.get();
//			return passwordEncoder.matches(password, user.getPassword());
//		}
//		return false;
//	}
//	
	public void deleteByUsername(String username) {
		userRepository.deleteByusername(username);
	}

	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

}
