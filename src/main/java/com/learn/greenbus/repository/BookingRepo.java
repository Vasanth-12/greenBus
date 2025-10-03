package com.learn.greenbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.greenbus.model.Booking;

@Repository
public interface BookingRepo extends  MongoRepository<Booking, String> {

}
