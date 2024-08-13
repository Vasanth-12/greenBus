package com.learn.greenbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.TravelAgency;

@Repository
public interface TravelAgencyRepo extends MongoRepository<TravelAgency, String>{

    public TravelAgency findByAgencyEmailID(String emailId);

}
