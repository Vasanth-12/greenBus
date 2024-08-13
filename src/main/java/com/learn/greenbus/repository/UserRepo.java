package com.learn.greenbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.UserProfile;

@Repository
public interface UserRepo extends MongoRepository<UserProfile, String> {

    public UserProfile findByEmailid(String emailid);


    /* *********** WIP ************** */
    @Query("{'_id': ?0}")
    // @Aggregation(pipeline = {
    //     "{'$match': {'_id': ?0}}",
    //     "{'$replaceWith': ?1}",
    // })
    public UserProfile updateUserProfile(String id, UserProfile user);
}
