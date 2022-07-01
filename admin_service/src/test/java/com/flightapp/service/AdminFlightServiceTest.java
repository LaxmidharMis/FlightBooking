package com.flightapp.service;

//import static org.mockito.BDDMockito.given;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.flightapp.entity.FlightDetails;
//import com.flightapp.repository.FlightRepository;
//
//
//@ExtendWith(MockitoExtension.class)
//public class AdminFlightServiceTest {
//	
//	@Mock
//	private FlightRepository flightRepo;
//	
//	@InjectMocks
//	private AdminFlightServiceImpl serviceImpl;
//	private FlightDetails flightDetails;
//
//	
//	@BeforeEach
//	public void setup() throws ParseException {
//		flightDetails = new FlightDetails(12,32363, "Indigo", "Blr", "Delhi",Date.valueOf("2022-08-08"),Date.valueOf("2022-08-08"), "1 Days",10,10,5000.0,Date.valueOf("2022-08-08"));
//
//	}
//
//	@DisplayName("saveflight from service layer")
//	@Test
//	public void saveFlight()  {
//
//		given(flightRepo.findByFlightNumber(flightDetails.getFlightNumber()))
//				.willReturn(Optional.empty());
//		
//		given(flightRepo.save(flightDetails)).willReturn(flightDetails);
//
//		
//		// when
//		Integer saveFlight = serviceImpl.saveFlights(flightDetails);
//		// then
//		Assertions.assertThat(saveFlight).isNotNull();
//	}
//
//	@DisplayName("throw exception")
//	@Test
//	public void saveFlightException() throws ParseException {
//
//		given(flightRepo.findByFlightNumber(flightDetails.getFlightNumber()))
//				.willReturn(Optional.of(flightDetails));
//
//		// given(addFlightRepository.save(addFlightDetails)).willReturn(addFlightDetails);
//
//		System.out.println(flightRepo);
//		System.out.println(serviceImpl);
//
//		
//	}
//
//	@DisplayName("getAllFlight")
//	@Test
//	public void getAllFlight() throws ParseException {
//		FlightDetails flightDetails2 = new FlightDetails(12,32363, "Indigo", "Blr", "Delhi",Date.valueOf("2022-08-08"),Date.valueOf("2022-08-08"), "1 Days",10,10,5000.0,Date.valueOf("2022-08-08"));
//
//
//		given(flightRepo.findAll()).willReturn(List.of(flightDetails, flightDetails2));
//
//		// when
//		java.util.List<FlightDetails> allFlightList = serviceImpl.getAllFlights();
//		// then
//
//		Assertions.assertThat(allFlightList).isNotNull();
//		Assertions.assertThat(allFlightList.size()).isEqualTo(2);
//	}
//
//	@DisplayName("getAllFlight negative scenario with empty list")
//	@Test
//	public void getAllFlightNegativeScenario() throws ParseException {
//		FlightDetails addFlightDetails3 =new FlightDetails(12,32363, "Indigo", "Blr", "Delhi",Date.valueOf("2022-08-08"),Date.valueOf("2022-08-08"), "1 Days",10,10,5000.0,Date.valueOf("2022-08-08"));
//
//		given(flightRepo.findAll()).willReturn(Collections.emptyList());
//
//		// when
//		java.util.List<FlightDetails> allFlightList = serviceImpl.getAllFlights();
//		// then
//
//		Assertions.assertThat(allFlightList).isEmpty();
//		Assertions.assertThat(allFlightList.size()).isEqualTo(0);
//	}
//
//	@DisplayName("getFlightByName ")
//	@Test
//	public void getFlightByName() throws ParseException {
//
//		given(flightRepo.findByOperatingAirlines("India Airway")).willReturn(Optional.of(flightDetails));
//
//		// when
//		FlightDetails flight = serviceImpl.getFlight(flightDetails.getOperatingAirlines());
//		// then
//
//		Assertions.assertThat(flight).isNotNull();
//
//	}
//
//	
//}
