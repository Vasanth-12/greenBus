package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.model.UserProfile;
import com.learn.greenbus.repository.UserRepo;

import lombok.Data;

@Data
@Service
public class UserProfileService {

    @Autowired
    UserRepo userRepo;

    public UserProfile verifyLogin(UserProfile userData) {

        String emailid = userData.emailid;
        String password = userData.password;

        System.out.println("Inside verifyLogin: "+ emailid+ " - "+ password);
        UserProfile userLogin = userRepo.findByEmailid(emailid);
        if (userLogin.password.equals(password)) {
            return userLogin;
        }
        return null;
    }

    public UserProfile persistUser(UserProfile userData) {
        System.out.println("Inside persistUser: ");
        userRepo.save(userData);
        return userData;
    }

    public UserProfile updateUserProfile(String id, UserProfile userData) {
        return userRepo.updateUserProfile(id, userData);
    }

    public UserProfile getUserProfile(String id) {
        return userRepo.findById(id).orElseThrow();
    }
}
