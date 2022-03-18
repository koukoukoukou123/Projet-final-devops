package com.sogeti.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Find a user by his username
	 * @param username
	 * @return user
	 */
	Optional<User> findByUsername(String username);
	/**
	 * Deleting a user
	 * @param username
	 */
    void deleteByusername(String username);
    /**
     * Check if a user, who has the username, is present in the database
     * @param username
     * @return true if this user is present, or false if he is not found
     */
    Boolean existsByUsername(String username);
    /**
     * Check if a user, who has the email, is present in the database
     * @param email
     * @return true if this user is present, or false if he is not found
     */
    Boolean existsByEmail(String email);
}
