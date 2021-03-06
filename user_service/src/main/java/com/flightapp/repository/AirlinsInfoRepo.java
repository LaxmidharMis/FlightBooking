package com.flightapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.FlightDetails;

public interface AirlinsInfoRepo extends JpaRepository<FlightDetails, Integer>{
	
//	@Query("from FlightInfo where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
//	
//	List<FlightInfo> findFlights(@Param("departureCity") String from , @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);
	@Query("FROM FlightDetails WHERE fromPlace =:fromPlace and toPlace =:toPlace and cast(departureDate as date) =:departureDate")
       List<FlightDetails> findByFromPlaceAndToPlaceAndDateOfDeparture(String fromPlace,String toPlace,Date departureDate);

//	 List<FlightDetailsInfo> findByFromPlaceAndToPlace(String fromPlace,String toPlace);
}
