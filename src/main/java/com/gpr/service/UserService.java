package com.gpr.service;

import com.gpr.db.domain.User;
import com.gpr.db.repository.UserRepository;
import com.gpr.mvc.exception.RecordNotFoundException;
import com.gpr.mvc.model.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Service facade to handle App User's use cases.
 */
@Service
@Transactional
    public class UserService {

    @Autowired
	private UserRepository UserRepository;

    public AppUser getUser(UUID uuid) throws RecordNotFoundException {
        User user = getUserByUuid(uuid);
        return convertUsertoAppUser(user);
    }

    public void createUser(String firstName, String lastName, String email,String password) {
        User User = new User();
        User.setFirstName(firstName);
        User.setLastName(lastName);
        User.setEmail(email);
        User.setUuid(UUID.randomUUID());
        User.setPassword(password);
        UserRepository.save(User);
    }

    public void deleteUser(UUID uuid) throws RecordNotFoundException{
        User User = getUserByUuid(uuid);
        if(User != null) {
            UserRepository.delete(User);
        }
    }

    public User getUserByUuid(UUID uuid) throws RecordNotFoundException {
        User User = UserRepository.findByUuid(uuid);
        if(User == null) {
            throw new RecordNotFoundException("User not found with UUID: " + uuid);
        }
        return User;
    }
    
    public AppUser getUserByEmailAndPassword(String email, String password) throws RecordNotFoundException {
        User user = UserRepository.findByEmailAndPassword(email, password);
        if(user == null) {
            throw new RecordNotFoundException("Invalid Email or Password");
        }
        return convertUsertoAppUser(user);
    }


    // We convert a domain/entity object (User) to a model object (AppUser). This way,
    // we don't return unnecessary domain/entity data to the client, ex. id or uuid
    public AppUser convertUsertoAppUser(User User) {
        if(User == null) return null;
        AppUser user = new AppUser();
        user.setFirstName(User.getFirstName());
        user.setLastName(User.getLastName());
        user.setEmail(User.getEmail());
        user.setId(User.getUuid().toString());
        return user;
    }
}