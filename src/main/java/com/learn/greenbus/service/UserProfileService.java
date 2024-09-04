package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.dto.UserDTO;
import com.learn.greenbus.model.UserProfile;
import com.learn.greenbus.repository.UserRepo;

import lombok.Data;

@Data
@Service
public class UserProfileService {

    @Autowired
    UserRepo userRepo;

    public UserDTO verifyLogin(UserDTO userData) {

        String emailid = userData.emailid;
        String password = userData.password;

        System.out.println("Inside verifyLogin: "+ emailid+ " - "+ password);
        UserProfile userLogin = userRepo.findByEmailid(emailid);
        if (userLogin.password.equals(password)) {
            return UserDTO.builder()
                        .id(userLogin.id)
                        .username(userLogin.username)
                        .emailid(userLogin.emailid)
                        .mobilenumber(userLogin.mobilenumber)
                        .build();
        }
        return null;
    }

    public UserDTO persistUser(UserDTO userDataIn) {
        UserProfile userData = userRepo.save(UserProfile.builder()
                                    .username(userDataIn.username)
                                    .emailid(userDataIn.emailid)
                                    .mobilenumber(userDataIn.mobilenumber)
                                    .password(userDataIn.password)
                                    .build());
        return UserDTO.builder()
                    .id(userData.id)
                    .username(userData.username)
                    .emailid(userData.emailid)
                    .mobilenumber(userData.mobilenumber)
                    .build();
    }

    public UserDTO updateUserProfile(String id, UserDTO userData) {
    
        UserProfile user = userRepo.findById(userData.id).orElseThrow();
        user.setEmailid(userData.emailid);
        user.setMobilenumber(userData.mobilenumber);
        user.setUsername(userData.username);
        
        userRepo.save(user);
        return userData;
    }

    public UserDTO updateUserPassword(String id, UserDTO userData) {
        UserProfile user = userRepo.findById(id).orElseThrow();
        user.setPassword(userData.password);

        userRepo.save(user);
        return UserDTO.builder()
                .id(user.id)
                .username(user.username)
                .emailid(user.emailid)
                .mobilenumber(user.mobilenumber)
                .build();

    }

    public UserDTO getUserProfile(String id) {
        UserProfile userData = userRepo.findById(id).orElseThrow();
        return UserDTO.builder()
                        .id(userData.id)
                        .username(userData.username)
                        .emailid(userData.emailid)
                        .mobilenumber(userData.mobilenumber)
                        .build();
    }
}
