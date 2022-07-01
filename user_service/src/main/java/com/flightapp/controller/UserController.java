package com.flightapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entity.FlightDetails;
import com.flightapp.entity.FlightInfo;
import com.flightapp.entity.User;
import com.flightapp.serviceImpl.AirlinesServiceImpl;
import com.flightapp.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserServiceImpl userserviceImpl;

	@Autowired
	private AirlinesServiceImpl airLineServiceImpl;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/userRegistration")
	public Integer registerUser(@RequestBody User user) {
		Integer id = userserviceImpl.saveUser(user);
		return id;
	}

	@GetMapping("/getUserAll")
	public List<User> getAll() {

		return userserviceImpl.getAllUser();

	}

	@GetMapping("/user/{id}")
	public Optional<User> getById(@PathVariable Integer id) {

		return userserviceImpl.getUser(id);

	}

	@GetMapping("/searchAllFlights")
	public ResponseEntity<FlightInfo[]> getAllFlight() {

		ResponseEntity<FlightInfo[]> response = restTemplate.getForEntity("http://admin-service/searchAllFlights",
				FlightInfo[].class);
		return response;

	}

	@DeleteMapping("/cancelUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {

		ResponseEntity<?> resp = null;
		try {
			userserviceImpl.deleteUser(id);
			Map<String, Boolean> response = new HashMap<>();
			response.put("User is Deleted with id" + id, Boolean.TRUE);
			resp = ResponseEntity.ok(response);

		} catch (Exception e) {

			resp = new ResponseEntity<String>(" Flight not present with  this flightNumber  " + id,
					HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/searchFlight/{fromPlace}/{toPlace}/{dateOfDeparture}")
	public ResponseEntity<?> searchFligthByFromplaceAndToPlace(@PathVariable String fromPlace,
			@PathVariable String toPlace, @PathVariable("dateOfDeparture") String dateOfDeparture) throws Exception {
		List<FlightDetails> flights = airLineServiceImpl.searchFlight(fromPlace, toPlace, dateOfDeparture);

		if (flights.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Found");
		}
		return ResponseEntity.ok(flights);

	}
//	@GetMapping("/search/{fromPlace}/{toPlace}/{startDate}")
//    public List<?> findByfromPlaceAndtoPlace(@PathVariable("fromPlace") String fromPlace,
//            @PathVariable("toPlace") String toPlace,@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) {
//        List<FlightDetails> fromPlaceAndtoPlace = null;
//
//        try {
//            if (fromPlace != null && toPlace != null) {
//                fromPlaceAndtoPlace = airLineServiceImpl.searchFlight(fromPlace, toPlace,startDate);
//                if (fromPlaceAndtoPlace.size() == 0) {
//                    throw new ResourceNotFoundException();
//                }
//                System.out.println(fromPlaceAndtoPlace);
//
//                return fromPlaceAndtoPlace;
//            } else {
//                throw new ResourceNotFoundException(
//                        "Unable to fetch resource from " + fromPlace + " toPlace " + toPlace + " journeyDate "+startDate);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            throw new ResourceNotFoundException("Unable to fetch resource from " + fromPlace + " toPlace " + toPlace + " journeyDate "+startDate);
//
//        }
//
//        // return fromPlaceAndtoPlace;
//
//    }

//	@GetMapping("/searchFlights/{fromPlace}/{toPlace}")
//	public ResponseEntity<?> searchFlightByPlace(@PathVariable String fromPlace, @PathVariable String toPlace) {
//		List<FlightDetailsInfo> flights = airLineServiceImpl.findFlightsByPlace(fromPlace, toPlace) ;
//		if (flights.size() == 0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Found");
//		}
//		return ResponseEntity.ok(flights);
//
//		
//	}

}