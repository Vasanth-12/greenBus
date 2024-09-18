package com.learn.greenbus.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.dto.BusDetailsDTO;
import com.learn.greenbus.dto.JourneyDTO;
import com.learn.greenbus.model.BookingDetails;
import com.learn.greenbus.model.Journey;
import com.learn.greenbus.repository.JourneyRepo;

@Service
public class JourneyService {

    @Autowired
    JourneyRepo journeyRepo;

    public Journey optJourney(Journey journey) {

        journey.setAvailableSeats(journey.busdetails.getSeatCount());
        for (String seatnumber:journey.busdetails.seatNumber) {
            /*
             * need to be autowired
             */
            BookingDetails seatObj = new BookingDetails();
            seatObj.setSeatNumber(seatnumber);
            seatObj.setBooked(false);

            System.out.println(seatObj);

            journey.seatDetails.put(seatnumber, seatObj);
        }
        journeyRepo.save(journey);

        return journey;
    }

    public JourneyDTO createJourneyDTO(Journey journey) {
        BusDetailsDTO busDetailsDTO = BusDetailsDTO.builder()
                                        .id(journey.busdetails.id)
                                        .agencyid(journey.busdetails.agencyid)
                                        .type(journey.busdetails.type)
                                        .ac(journey.busdetails.ac)
                                        .build();

        return JourneyDTO.builder()
                    .id(journey.id)
                    .availableSeats(journey.availableSeats)
                    .busDetailsDTO(busDetailsDTO)
                    .ticketFee(journey.ticketFee)
                    .build();
    }

    public List<JourneyDTO> getListOfJourney(String boardingPoint, String destiny) {

        List<Journey> journeyList = journeyRepo.findByBoardingPoints(boardingPoint, destiny);
        List<JourneyDTO> journeyDTOs =  journeyList.stream()
                                            .map(journeyDetails -> createJourneyDTO(journeyDetails))
                                            .collect(Collectors.toList());
        return journeyDTOs;
    }

    public Journey getJourneyDetail(String id) {
        return journeyRepo.findById(id).orElseThrow();
    }

    public synchronized boolean booking(String journeyId, BookingDetails bookingDetails) {
        Journey journey = journeyRepo.findById(journeyId).orElseThrow();
        String seatNumber = bookingDetails.seatNumber;
        if (!journey.seatDetails.get(seatNumber).booked) {
            try {
                journey.seatDetails.replace(seatNumber, bookingDetails);
                journey.seatDetails.get(seatNumber).setBooked(true);
                journey.availableSeats--;
                journeyRepo.save(journey);
                return true;
            }
            catch (Exception e) {
                throw e;
            }
        }
        else
            return false;
    }
}