package com.flight.dbservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.dbservice.model.FlightFare;

@Repository
public interface FlightFareRepo extends JpaRepository<FlightFare, Long> {


}
