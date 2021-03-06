package com.flightapp.controller;

import java.util.List;

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

import com.flightapp.entity.TicketBooking;
import com.flightapp.service.TiceketBookingService;
import com.flightapp.validation.EmailNotFound;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class TickectBookingController {

	@Autowired
	private TiceketBookingService ticketBookingService;

//	@Autowired
//	private ModelMapper modelMapper;

	@DeleteMapping("/cancelFlight/{pnrNumber}")
	public ResponseEntity<?> deleteFlight(@PathVariable("pnrNumber") Integer pnrNumber) {

		ResponseEntity<String> resp = null;
		try {
			ticketBookingService.cancelBookFlight(pnrNumber);
			resp = ResponseEntity.ok("Fligh Ticket Cancel Succesfully With Id  " + pnrNumber);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("This Flight not exist ", HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}

	@PostMapping("/bookFlight")
	public Integer bookFlight(@RequestBody TicketBooking ticket) {
		Long pnrNumber = generatePNRNumber();
		ticket.setPnrNumber(pnrNumber);
		System.out.println("Pnr number is...." + pnrNumber);
		Integer id = ticketBookingService.bookFlight(ticket);
		System.out.println("Flight is created with id...." + id);
		return id;

	}

	@GetMapping("/getAllBookFlight")
	public List<TicketBooking> getAllBookFlight() {

		return ticketBookingService.getAllBookFlight();
	}

//	@PostMapping("/bookFlight")
//	public ResponseEntity<?> bookFlight(@RequestBody UserInfo userInfo) {
//
//		// convert DTO to entity
//
//		TicketBooking bookFlight = modelMapper.map(userInfo, TicketBooking.class);
//		TicketBooking book = ticketBookingService.bookFlight(bookFlight);
//
//		// convert entity to DTO
//
//		UserInfo userInput = modelMapper.map(book, UserInfo.class);
//		return new ResponseEntity<>("Your Ticket book succesfully..  PNR number is : "+userInput.getId(), HttpStatus.CREATED);
//	}
//    

//	@GetMapping("/flight/{pnrNumber}")
//    public Optional<TicketBooking> getBookingByPnrNo(@PathVariable("pnrNumber") Long pnrNumber) {
//        return ticketBookingService.getBookingByPnrNo(pnrNumber);
//    }

	@GetMapping("/getFlightByPnr/{pnrNumber}")
	public ResponseEntity<TicketBooking> getFlightByPnr(@PathVariable("pnrNumber") Long pnrNumber) {

		ResponseEntity<TicketBooking> resp = null;
		try {
			TicketBooking flightByPnr = ticketBookingService.getFlightByPnr(pnrNumber);
			resp = ResponseEntity.ok(flightByPnr);
		} catch (Exception e) {
			resp = new ResponseEntity<TicketBooking>(HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/getFlightByEmailId/{email}")
	public ResponseEntity<List<TicketBooking>> getFlightByEmailId(@PathVariable String email) {

		ResponseEntity<List<TicketBooking>> resp = null;
		try {
			List<TicketBooking> flightByemail = ticketBookingService.getByEmail(email);
			if (flightByemail.size() == 0) {
				throw new EmailNotFound();
			}
			resp = ResponseEntity.ok(flightByemail);
		} catch (Exception e) {
			resp = new ResponseEntity<List<TicketBooking>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}
		return resp;
	}

	static Long generatePNRNumber() {
		int lenght = 10;
		String number = "0123456789";

		StringBuilder sb = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			int index = (int) (number.length() * Math.random());

			sb.append(number.charAt(index));
		}
		return Long.valueOf(sb.toString());
	}

}
