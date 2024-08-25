package com.learn.greenbus.controller;

import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.dto.UserDTO;
import com.learn.greenbus.model.UserProfile;
import com.learn.greenbus.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {

    @Autowired
    UserProfileService userProfile;

    @GetMapping("ping")
    public ResponseEntity healthCheck() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity loginEndpoint(@RequestBody UserProfile userData) {
        try {

            UserDTO userDTO = userProfile.verifyLogin(userData);
            if (userDTO != null) {
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("signup")
    public ResponseEntity signinEndpoint(@RequestBody UserProfile user) {
        try {
            UserDTO userDTO = userProfile.persistUser(user);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* *********** WIP ************** */
    // @PutMapping("user/{id}")
    // public ResponseEntity updateUserProfile(@PathVariable String id, @RequestBody UserProfile user) {
        
    //     try {
    //         UserProfile z = userProfile.updateUserProfile(id, user);
    //         return new ResponseEntity<>(z, HttpStatus.OK);
    //     }
    //     catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity getUserProfile(@PathVariable String id) {
        try {
            UserDTO userDTO = userProfile.getUserProfile(id);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // User journey list
    
}
