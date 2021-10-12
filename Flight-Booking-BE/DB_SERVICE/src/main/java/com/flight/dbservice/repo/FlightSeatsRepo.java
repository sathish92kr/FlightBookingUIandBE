package com.flight.dbservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.dbservice.model.FlightSeats;

@Repository
public interface FlightSeatsRepo extends JpaRepository<FlightSeats, Long> {

}
