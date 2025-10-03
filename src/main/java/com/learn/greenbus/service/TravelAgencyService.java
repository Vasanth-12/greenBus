package com.learn.greenbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.dto.TravelAgencyDTO;
import com.learn.greenbus.model.BusDetails;
import com.learn.greenbus.model.TravelAgency;
import com.learn.greenbus.repository.BusDetailsRepo;
import com.learn.greenbus.repository.TravelAgencyRepo;

import lombok.Data;

@Data
@Service
public class TravelAgencyService {

    @Autowired
    TravelAgencyRepo repo;

    @Autowired
    BusDetailsRepo busDetailsRepo;

    public TravelAgencyDTO agencyLogin(TravelAgencyDTO agency) {

        String agencyMailID = agency.emailid;
        String password = agency.password;

        TravelAgency agencyData = repo.findByEmailid(agencyMailID);
        if (agencyData.password.equals(password)) {
            return TravelAgencyDTO.builder()
                    .id(agencyData.id)
                    .agencyname(agencyData.agencyname)
                    .emailid(agencyData.emailid)
                    .build();  
        }
        return null;
    }

    public TravelAgencyDTO agencySignup(TravelAgencyDTO agency) {
        TravelAgency agencyData = TravelAgency.builder()
                                    .agencyname(agency.agencyname)
                                    .emailid(agency.emailid)
                                    .password(agency.password)
                                    .build();

        agencyData = repo.save(agencyData);
        return TravelAgencyDTO.builder()
                .id(agencyData.id)
                .agencyname(agencyData.agencyname)
                .emailid(agencyData.emailid)
                .build();
    }

    public List<BusDetails> getAgencyBusList(String id) {
        return busDetailsRepo.findByAgencyid(id);
    }

    public BusDetails addBus(BusDetails busDetails) {
        return busDetailsRepo.save(busDetails);
    }
}
