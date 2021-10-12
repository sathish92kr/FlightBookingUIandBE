package com.flight.dbservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLIGHT_ID", nullable = false)
	private long id;

	@Column(name = "FLIGHT_COMPANY")
	private String flightCompany;
	@Column(name = "FLIGHT_MODEL")
	private String flightModel;
	@Column(name = "FLIGHT_CODE", unique = true)
	private String flightCode;
	@Column(name = "FLIGHT_ECO_SEATS")
	private int flightEcoSeats;
	@Column(name = "FLIGHT_BUI_SEATS")
	private int flightBuiSeats;

	@Column(name = "FLIGHT_AVL_STATUS")
	private String flightAvlStatus;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "flight")
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("flight")
	//@JsonIgnore
	private Set<FlightSchedule> flightSchedule=new HashSet<FlightSchedule>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getFlightEcoSeats() {
		return flightEcoSeats;
	}

	public void setFlightEcoSeats(int flightEcoSeats) {
		this.flightEcoSeats = flightEcoSeats;
	}

	public int getFlightBuiSeats() {
		return flightBuiSeats;
	}

	public void setFlightBuiSeats(int flightBuiSeats) {
		this.flightBuiSeats = flightBuiSeats;
	}

	public String getFlightAvlStatus() {
		return flightAvlStatus;
	}

	public void setFlightAvlStatus(String flightAvlStatus) {
		this.flightAvlStatus = flightAvlStatus;
	}

	public Set<FlightSchedule> getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(Set<FlightSchedule> flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Flight(String flightCompany, String flightModel, int flightEcoSeats, int flightBuiSeats,
			String flightAvlStatus, String flightCode) {
		super();
		this.flightCompany = flightCompany;
		this.flightModel = flightModel;
		this.flightEcoSeats = flightEcoSeats;
		this.flightBuiSeats = flightBuiSeats;
		this.flightAvlStatus = flightAvlStatus;
		this.flightCode = flightCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [id=").append(id).append(", flightCompany=").append(flightCompany)
				.append(", flightModel=").append(flightModel).append(", flightEcoSeats=").append(flightEcoSeats)
				.append(", flightBuiSeats=").append(flightBuiSeats).append(", flightAvlStatus=").append(flightAvlStatus)
				.append(", flightSchedule=").append(flightSchedule).append("]");
		return builder.toString();
	}

	public Flight() {
		super();
	}

}
