package com.flightapp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FlightInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column
	private String flightNumber;
	@Column
	private String operatingAirlines;
	@Column
	private String departureCity;
	@Column
	private String arrivalCity;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfDeparture;
	@Column
	private Timestamp estimatedDepartureTime;
	private Double cost;

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlightInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightInfo(Integer id, String flightNumber, String operatingAirlines, String departureCity,
			String arrivalCity, Date dateOfDeparture, Timestamp estimatedDepartureTime, Double cost) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateOfDeparture = dateOfDeparture;
		this.estimatedDepartureTime = estimatedDepartureTime;
		this.cost = cost;
	}

}
