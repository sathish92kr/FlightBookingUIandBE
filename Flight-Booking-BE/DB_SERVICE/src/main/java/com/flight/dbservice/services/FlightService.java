package com.flight.dbservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.flight.dbservice.model.Flight;
import com.flight.dbservice.repo.FlightRepo;

@Service
public class FlightService {

	@Autowired
	FlightRepo flightrepo;

	public List<Flight> getFlightByCompany(String company) {

		return flightrepo.findByFlightCompany(company);

	}

	public List<Flight> getFlightByModel(String model) {

		return flightrepo.findByFlightModel(model);

	}

	public List<Flight> getFlightByStatus(String status) {

		return flightrepo.findByFlightAvlStatus(status);

	}

	public Flight createFlight(Flight flight) {

		Flight postApi = new Flight(flight.getFlightCompany(), flight.getFlightModel(),flight.getFlightEcoSeats(), flight.getFlightBuiSeats(),
				 flight.getFlightAvlStatus(), flight.getFlightCode());

		return flightrepo.save(postApi);
	}

	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return flightrepo.findAll();
	}

	public void deleteFlight(long id) {
		flightrepo.deleteById(id);
	}

	public ResponseEntity<Flight> updateFlight(long id, Flight flight) {

		Optional<Flight> isFlightid = flightrepo.findById(id);

		if (isFlightid.isPresent()) {
			Flight _flight = isFlightid.get();
			_flight.setFlightCompany(flight.getFlightCompany());
			_flight.setFlightModel(flight.getFlightModel());
			_flight.setFlightCode(flight.getFlightCode());
			_flight.setFlightEcoSeats(flight.getFlightEcoSeats());
			_flight.setFlightBuiSeats(flight.getFlightBuiSeats());
			_flight.setFlightAvlStatus(flight.getFlightAvlStatus());
			return new ResponseEntity<>(flightrepo.save(_flight), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
