package com.learn.greenbus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.BusDetails;

@Repository
public interface BusDetailsRepo extends MongoRepository<BusDetails, String>{

    public List<BusDetails> findByAgencyid(String agencyId);

}
