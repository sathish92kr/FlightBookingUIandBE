package com.flight.dbservice.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FlightSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLIGHT_SCHEDULE_ID")
	private long id;

	@Column(name = "FLIGHT_NAME")
	private String flightName;

	@Column(name = "FLIGHT_DEP_LOC")
	private String flightDepLoc;

	@Column(name = "FLIGHT_ARR_LOC")
	private String flightArrLoc;

	@Column(name = "FLIGHT_DEP_DATE")
	// @Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate flightDepDate;

	@Column(name = "FLIGHT_ARR_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate flightArrDate;

	@Column(name = "FLIGHT_DEP_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime flightDepTime;

	@Column(name = "FLIGHT_ARR_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime flightArrTime;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "FLIGHT_ID", nullable = true, referencedColumnName = "FLIGHT_ID")
	@JsonIgnoreProperties("flightSchedule")
	// @JsonIgnore
	private Flight flight;

	@OneToOne(optional = true)
	@JoinColumn(name = "FLIGHT_SEATS_ID")
	private FlightSeats flightseats;

	@OneToOne(optional = true)
	@JoinColumn(name = "FLIGHT_FARE_ID")
	private FlightFare flightfare;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightDepLoc() {
		return flightDepLoc;
	}

	public void setFlightDepLoc(String flightDepLoc) {
		this.flightDepLoc = flightDepLoc;
	}

	public String getFlightArrLoc() {
		return flightArrLoc;
	}

	public void setFlightArrLoc(String flightArrLoc) {
		this.flightArrLoc = flightArrLoc;
	}

	public LocalDate getFlightDepDate() {
		return flightDepDate;
	}

	public void setFlightDepDate(LocalDate flightDepDate) {
		this.flightDepDate = flightDepDate;
	}

	public LocalDate getFlightArrDate() {
		return flightArrDate;
	}

	public void setFlightArrDate(LocalDate flightArrDate) {
		this.flightArrDate = flightArrDate;
	}

	public LocalTime getFlightDepTime() {
		return flightDepTime;
	}

	public void setFlightDepTime(LocalTime flightDepTime) {
		this.flightDepTime = flightDepTime;
	}

	public LocalTime getFlightArrTime() {
		return flightArrTime;
	}

	public void setFlightArrTime(LocalTime flightArrTime) {
		this.flightArrTime = flightArrTime;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightFare getFlightfare() {
		return flightfare;
	}

	public void setFlightfare(FlightFare flightfare) {
		this.flightfare = flightfare;
	}

	public FlightSeats getFlightseats() {
		return flightseats;
	}

	public void setFlightseats(FlightSeats flightseats) {
		this.flightseats = flightseats;
	}

	public FlightSchedule(String flightName, String flightDepLoc, String flightArrLoc, LocalDate flightDepDate,
			LocalDate flightArrDate, LocalTime flightDepTime, LocalTime flightArrTime, Flight flight) {
		super();
		this.flightName = flightName;
		this.flightDepLoc = flightDepLoc;
		this.flightArrLoc = flightArrLoc;
		this.flightDepDate = flightDepDate;
		this.flightArrDate = flightArrDate;
		this.flightDepTime = flightDepTime;
		this.flightArrTime = flightArrTime;
		this.flight = flight;
	}

	public FlightSchedule(String flightName, String flightDepLoc, String flightArrLoc, LocalDate flightDepDate,
			LocalDate flightArrDate, LocalTime flightDepTime, LocalTime flightArrTime, Flight flight,
			FlightFare flightfare, FlightSeats flightseats) {
		super();
		this.flightName = flightName;
		this.flightDepLoc = flightDepLoc;
		this.flightArrLoc = flightArrLoc;
		this.flightDepDate = flightDepDate;
		this.flightArrDate = flightArrDate;
		this.flightDepTime = flightDepTime;
		this.flightArrTime = flightArrTime;
		this.flight = flight;
		this.flightfare = flightfare;
		this.flightseats = flightseats;
	}

	public FlightSchedule() {

	}

}
