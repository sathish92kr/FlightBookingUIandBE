package com.flight.dbservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.dbservice.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

	List<Flight> findByFlightCompany(String company);

//	@Query("select u.id, u.flightAvlStatus, u.flightBuiSeats, u.flightEcoSeats, u.flightModel, u.flightCompany\r\n"
//			+ "FROM Flight u where u.flightModel = ?1")
	List<Flight> findByFlightModel(String flight);

	List<Flight> findByFlightAvlStatus(String flight);

}
