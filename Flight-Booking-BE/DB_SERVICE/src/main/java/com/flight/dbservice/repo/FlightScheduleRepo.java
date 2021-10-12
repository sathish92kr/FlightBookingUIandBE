package com.flight.dbservice.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.dbservice.model.FlightSchedule;

@Repository
public interface FlightScheduleRepo extends JpaRepository<FlightSchedule, Long> {

	List<FlightSchedule> findByFlightName(String name);

	List<FlightSchedule> findByFlightDepLocAndFlightArrLoc(String descLoc, String arrLoc);

	List<FlightSchedule> findByFlightDepLocAndFlightArrLocAndFlightDepDate(String descLoc, String arrLoc,
			LocalDate desDate);

	List<FlightSchedule> findByFlightDepLocAndFlightArrLocAndFlightArrDate(String descLoc, String arrLoc,
			String arrDate);

	List<FlightSchedule> findByFlightDepLocAndFlightArrLocAndFlightDepDateAndFlightArrDate(String descLoc,
			String arrLoc, String desDate, String arrDate);

}
