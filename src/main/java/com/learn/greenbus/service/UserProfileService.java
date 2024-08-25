package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.model.UserProfile;
import com.learn.greenbus.repository.UserRepo;
import com.learn.greenbus.dto.UserDTO;

import lombok.Data;

@Data
@Service
public class UserProfileService {

    @Autowired
    UserRepo userRepo;

    public UserDTO verifyLogin(UserProfile userData) {

        String emailid = userData.emailid;
        String password = userData.password;

        System.out.println("Inside verifyLogin: "+ emailid+ " - "+ password);
        UserProfile userLogin = userRepo.findByEmailid(emailid);
        if (userLogin.password.equals(password)) {
            return new UserDTO(userLogin.id, userLogin.username, userLogin.emailid);

        }
        return null;
    }

    public UserDTO persistUser(UserProfile userData) {
        userData = userRepo.save(userData);
        return new UserDTO(userData.id, userData.username, userData.emailid);
    }

    public UserProfile updateUserProfile(String id, UserProfile userData) {
        return userRepo.updateUserProfile(id, userData);
    }

    public UserDTO getUserProfile(String id) {
        UserProfile userData = userRepo.findById(id).orElseThrow();
        return new UserDTO(userData.id, userData.username, userData.emailid);
    }
}
