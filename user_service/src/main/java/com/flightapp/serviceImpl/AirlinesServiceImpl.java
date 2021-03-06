package com.flightapp.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.FlightDetails;
import com.flightapp.repository.AirlinsInfoRepo;
import com.flightapp.service.AirlinesService;

@Service
public class AirlinesServiceImpl implements AirlinesService {

	@Autowired
	AirlinsInfoRepo airlineRepo;

	@Override
	public List<FlightDetails> searchFlight(String fromPlace, String toPlace, String departureDate)
			throws Exception {
		// TODO Auto-generated method stub
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
		System.out.println("Date is..." + date);

		return airlineRepo.findByFromPlaceAndToPlaceAndDateOfDeparture(fromPlace, toPlace, date);
	}

//	@Override
//	public List<FlightDetailsInfo> findFlightsByPlace(String from, String to)  {
//		// TODO Auto-generated method stub
//		return airlineRepo.findByFromPlaceAndToPlace(from, to);
//	}
}
