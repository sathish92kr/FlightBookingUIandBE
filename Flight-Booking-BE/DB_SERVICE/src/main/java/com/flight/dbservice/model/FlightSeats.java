package com.flight.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FlightSeats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLIGHT_SEATS_ID", nullable = false)
	private long id;

	@Column(name = "FLIGHT_ECO_AVL")
	private int flightEcoAvl;
	@Column(name = "FLIGHT_BUI_AVL")
	private int flightBuiAvl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFlightEcoAvl() {
		return flightEcoAvl;
	}

	public void setFlightEcoAvl(int flightEcoAvl) {
		this.flightEcoAvl = flightEcoAvl;
	}

	public int getFlightBuiAvl() {
		return flightBuiAvl;
	}

	public void setFlightBuiAvl(int flightBuiAvl) {
		this.flightBuiAvl = flightBuiAvl;
	}

	public FlightSeats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightSeats(int flightEcoAvl, int flightBuiAvl) {
		super();
		this.flightEcoAvl = flightEcoAvl;
		this.flightBuiAvl = flightBuiAvl;
	}

	@Override
	public String toString() {
		return "FlightSeats [id=" + id + ", flightEcoAvl=" + flightEcoAvl + ", flightBuiAvl=" + flightBuiAvl + "]";
	}

}
