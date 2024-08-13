package com.learn.greenbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.model.BusDetails;
import com.learn.greenbus.repository.BusDetailsRepo;

@Service
public class BusDetailsService {

    @Autowired
    BusDetailsRepo busRepo;

    public BusDetails addBus(BusDetails busDetails) {
        return busRepo.save(busDetails);
    }

    public void deleteBus(String busId) {
        busRepo.deleteById(busId);
    }

    public List<BusDetails> listBus(String agencyId) {
        System.out.println("Inside listbus: " + busRepo.findByAgencyid(agencyId));
        return busRepo.findByAgencyid(agencyId);
    }
}
