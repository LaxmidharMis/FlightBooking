package com.flightapp.service;

import java.util.List;

import com.flightapp.entity.FlightDetails;

public interface AirlinesService {
	public List<FlightDetails> searchFlight(String from, String to, String departureDate) throws Exception;
	
//	public List<FlightDetailsInfo> findFlightsByPlace(String from, String to) ;

}
