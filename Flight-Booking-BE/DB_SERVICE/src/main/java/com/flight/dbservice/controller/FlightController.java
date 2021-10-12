package com.flight.dbservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dbservice.model.Flight;
import com.flight.dbservice.services.FlightService;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {

	@Autowired
	FlightService flightservice; 

	@PostMapping("/addFlight")
	public String createFlight(@RequestBody Flight flight) {

		flightservice.createFlight(flight);

		return "Flight added Sucessfully";

	}

	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") long id) {
		try {
			flightservice.deleteFlight(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/editFlight/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable("id") long id, @RequestBody Flight flight) {

		ResponseEntity<Flight> rs = flightservice.updateFlight(id, flight);
		return rs;

	}

	@GetMapping("/fcompany")
	public ResponseEntity<List<Flight>> getFlightByCompany(@RequestParam String fcompany) {

		List<Flight> companyList = flightservice.getFlightByCompany(fcompany);

		return new ResponseEntity<List<Flight>>(companyList, HttpStatus.OK);
	}

	@GetMapping("/gelAllFlights")
	public ResponseEntity<List<Flight>> getAllFlights() {

		List<Flight> flightList = flightservice.getAllFlight();

		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}

	@GetMapping("/fmodel")
	public ResponseEntity<List<Flight>> getFlightByModel(@RequestParam String fmodel) {

		List<Flight> modelList = flightservice.getFlightByModel(fmodel);

		System.out.println(modelList);

		return new ResponseEntity<List<Flight>>(modelList, HttpStatus.OK);
	}

	@GetMapping("/fstatus")
	public ResponseEntity<List<Flight>> getFlightByStatus(@RequestParam String fstatus) {

		List<Flight> statusList = flightservice.getFlightByStatus(fstatus);

		return new ResponseEntity<List<Flight>>(statusList, HttpStatus.OK);
	}

}
