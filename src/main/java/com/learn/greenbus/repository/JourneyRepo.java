package com.learn.greenbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.Journey;

@Repository
public interface JourneyRepo extends MongoRepository<Journey, String>{

}
