package com.flight.dbservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flight.dbservice.model.Flight;
import com.flight.dbservice.model.FlightSchedule;
import com.flight.dbservice.repo.FlightFareRepo;
import com.flight.dbservice.repo.FlightRepo;
import com.flight.dbservice.repo.FlightScheduleRepo;
import com.flight.dbservice.repo.FlightSeatsRepo;

@Service
public class FlightScheduleService {

	@Autowired
	FlightRepo flightrepo;

	@Autowired
	FlightScheduleRepo flightschrepo;

	@Autowired
	FlightFareRepo flightfarerepo;

	@Autowired
	FlightSeatsRepo flightseatsrepo;

	public List<FlightSchedule> getFlightByName(String name) {

		return flightschrepo.findByFlightName(name);

	}

	public List<FlightSchedule> findByflightDepLocAndflightArrLoc(String descLoc, String arrLoc) {

		return flightschrepo.findByFlightDepLocAndFlightArrLoc(descLoc, arrLoc);

	}

	public List<FlightSchedule> findByflightDepLocAndflightArrLocAndflightDepDate(String descLoc, String arrLoc,
			LocalDate desDate) {

		return flightschrepo.findByFlightDepLocAndFlightArrLocAndFlightDepDate(descLoc, arrLoc, desDate);

	}

	public List<FlightSchedule> findByflightDepLocAndflightArrLocAndflightArrDate(String descLoc, String arrLoc,
			String arrDate) {

		return flightschrepo.findByFlightDepLocAndFlightArrLocAndFlightArrDate(descLoc, arrLoc, arrDate);

	}

	public List<FlightSchedule> findByflightDepLocAndflightArrLocAndflightDepDateAndflightArrDate(String descLoc,
			String arrLoc, String desDate, String arrDate) {

		return flightschrepo.findByFlightDepLocAndFlightArrLocAndFlightDepDateAndFlightArrDate(descLoc, arrLoc, desDate,
				arrDate);

	}

	public FlightSchedule scheduleFlight(FlightSchedule flightSchedule) {

		FlightSchedule postApi = new FlightSchedule(flightSchedule.getFlightName(), flightSchedule.getFlightDepLoc(),
				flightSchedule.getFlightArrLoc(), flightSchedule.getFlightDepDate(), flightSchedule.getFlightArrDate(),
				flightSchedule.getFlightDepTime(), flightSchedule.getFlightArrTime(), flightSchedule.getFlight(),
				flightSchedule.getFlightfare(), flightSchedule.getFlightseats());

		if (flightSchedule.getFlight() != null) {
			flightrepo.save(flightSchedule.getFlight());
		}
		if (flightSchedule.getFlightfare() != null) {
			flightfarerepo.save(flightSchedule.getFlightfare());
		}
		if (flightSchedule.getFlightseats() != null) {
			flightseatsrepo.save(flightSchedule.getFlightseats());
		}

		return flightschrepo.save(postApi);
	}

	public List<FlightSchedule> getAllFlightSchedule() {
		// TODO Auto-generated method stub
		return flightschrepo.findAll();
	}

	public void deleteFlight(long id) {
		flightschrepo.deleteById(id);

	}

	public ResponseEntity<FlightSchedule> updateFlightSchedule(long id, FlightSchedule flightSchedule) {

		Optional<FlightSchedule> isflightScheduleid = flightschrepo.findById(id);

		if (isflightScheduleid.isPresent()) {
			FlightSchedule _flightSchedule = isflightScheduleid.get();
			_flightSchedule.setFlightName(flightSchedule.getFlightName());
			_flightSchedule.setFlightDepLoc(flightSchedule.getFlightDepLoc());
			_flightSchedule.setFlightArrLoc(flightSchedule.getFlightArrLoc());
			_flightSchedule.setFlightDepDate(flightSchedule.getFlightDepDate());
			_flightSchedule.setFlightArrDate(flightSchedule.getFlightArrDate());
			_flightSchedule.setFlightDepTime(flightSchedule.getFlightDepTime());
			_flightSchedule.setFlightArrTime(flightSchedule.getFlightArrTime());

			if (flightSchedule.getFlight() != null) {
//				Optional<Flight> isflightid = flightrepo.findById(id);
//				Flight flight = flightSchedule.getFlight();
//				if (isflightid.isPresent()) {
//					Flight _isflightid = isflightid.get();
//					_isflightid.setFlightCompany(flight.getFlightCompany());
//					_isflightid.setFlightModel(flight.getFlightModel());
//					_isflightid.setFlightCode(flight.getFlightCode());
//					_isflightid.setFlightEcoSeats(flight.getFlightEcoSeats());
//					_isflightid.setFlightBuiSeats(flight.getFlightBuiSeats());
//					_isflightid.setFlightAvlStatus(flight.getFlightAvlStatus());
//
//				}
//			System.out.println(flight);

				flightrepo.save(flightSchedule.getFlight());
			}
			if (flightSchedule.getFlightfare() != null) {
				flightfarerepo.save(flightSchedule.getFlightfare());
			}
			if (flightSchedule.getFlightseats() != null) {
				flightseatsrepo.save(flightSchedule.getFlightseats());
			}

			return new ResponseEntity<>(flightschrepo.save(flightSchedule), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
