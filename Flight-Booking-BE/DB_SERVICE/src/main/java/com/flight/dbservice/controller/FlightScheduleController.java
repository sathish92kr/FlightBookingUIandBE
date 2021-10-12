package com.flight.dbservice.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RestController;

import com.flight.dbservice.model.FlightSchedule;
import com.flight.dbservice.services.FlightScheduleService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")
public class FlightScheduleController {

	@Autowired
	FlightScheduleService flightschservice;

	@PostMapping("/addSchedule")
	public String createFlightSchedule(@RequestBody FlightSchedule flightSchedule) {

		flightschservice.scheduleFlight(flightSchedule);
		return "Posted Sucessfully";

	}

	@GetMapping("/getallschedule")
	public ResponseEntity<List<FlightSchedule>> getFlightSchedules() {

		List<FlightSchedule> dList = flightschservice.getAllFlightSchedule();

		return new ResponseEntity<List<FlightSchedule>>(dList, HttpStatus.OK);
	}

	@DeleteMapping("/deleteSchedule/{id}")
	public ResponseEntity<HttpStatus> deleteFlightSchedule(@PathVariable("id") long id) {
		try {
			flightschservice.deleteFlight(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/editSchedule/{id}")
	public ResponseEntity<FlightSchedule> updateFlightSchedule(@PathVariable("id") long id,
			@RequestBody FlightSchedule flightSchedule) {

		ResponseEntity<FlightSchedule> rs = flightschservice.updateFlightSchedule(id, flightSchedule);
		return rs;

	}

	@GetMapping("/getflightbyloc/{depLoc}/{arrLoc}")
	public ResponseEntity<List<FlightSchedule>> getFlightByLocation(@PathVariable String depLoc,
			@PathVariable String arrLoc) {

		List<FlightSchedule> dList = flightschservice.findByflightDepLocAndflightArrLoc(depLoc, arrLoc);

		return new ResponseEntity<List<FlightSchedule>>(dList, HttpStatus.OK);
	}

	@GetMapping("/getflightbylocarrdate/{depLoc}/{arrLoc}/{arrDate}")
	public ResponseEntity<List<FlightSchedule>> getFlightByLocationsAndArrDate(@PathVariable String depLoc,
			@PathVariable String arrLoc, @PathVariable String arrDate) {

		List<FlightSchedule> dList = flightschservice.findByflightDepLocAndflightArrLocAndflightArrDate(depLoc, arrLoc,
				arrDate);

		return new ResponseEntity<List<FlightSchedule>>(dList, HttpStatus.OK);
	}

	@GetMapping("/getflightbylocdepdate/{depLoc}/{arrLoc}/{depDate}")
	public ResponseEntity<List<FlightSchedule>> getFlightByLocationAndDepDate(@PathVariable String depLoc,
			@PathVariable String arrLoc, @PathVariable String depDate) {

		List<FlightSchedule> dList = flightschservice.findByflightDepLocAndflightArrLocAndflightDepDate(depLoc, arrLoc,
				LocalDate.parse(depDate));

		return new ResponseEntity<List<FlightSchedule>>(dList, HttpStatus.OK);
	}

	@GetMapping("/getflightbyloc/{depLoc}/{arrLoc}/{depDate}/{arrDate}")
	public ResponseEntity<List<FlightSchedule>> getFlightByLocationAndDepDateAndArrDate(@PathVariable String depLoc,
			@PathVariable String arrLoc, @PathVariable String depDate, @PathVariable String arrDate) {

		List<FlightSchedule> dList = flightschservice
				.findByflightDepLocAndflightArrLocAndflightDepDateAndflightArrDate(depLoc, arrLoc, depDate, arrDate);

		return new ResponseEntity<List<FlightSchedule>>(dList, HttpStatus.OK);
	}

}
