package com.learn.greenbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.UserProfile;

@Repository
public interface UserRepo extends MongoRepository<UserProfile, String> {
    public UserProfile findByEmailid(String emailid);
}
