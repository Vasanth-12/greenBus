package com.learn.greenbus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.Journey;

@Repository
public interface JourneyRepo extends MongoRepository<Journey, String>{

    //public List<Journey> findByBoardingPoints(Bson all);

    //public List<Journey> findByBoardingPoints(Bson eq);

    @Query(value = "{'boardingPoints': { $all: [?0, ?1]}}")
    public List<Journey> findByBoardingPoints(String boardingPoint, String destiny);

    //public void saveAll(Journey journey);
}
