package com.flight.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FlightFare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FARE_ID")
	private long id;

	@Column(name = "FLIGHT_ECO_FARE")
	private int flightEcoFare;
	@Column(name = "FLIGHT_BUI_FARE")
	private int flightBuiFare;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightEcoFare() {
		return flightEcoFare;
	}

	public void setFlightEcoFare(int flightEcoFare) {
		this.flightEcoFare = flightEcoFare;
	}

	public int getFlightBuiFare() {
		return flightBuiFare;
	}

	public void setFlightBuiFare(int flightBuiFare) {
		this.flightBuiFare = flightBuiFare;
	}

	public FlightFare(int flightEcoFare, int flightBuiFare) {
		super();
		this.flightEcoFare = flightEcoFare;
		this.flightBuiFare = flightBuiFare;
	}

	@Override
	public String toString() {
		return "FlightFare [id=" + id + ", flightEcoFare=" + flightEcoFare + ", flightBuiFare=" + flightBuiFare + "]";
	}

	public FlightFare() {
		super();
		// TODO Auto-generated constructor stub
	}

}
