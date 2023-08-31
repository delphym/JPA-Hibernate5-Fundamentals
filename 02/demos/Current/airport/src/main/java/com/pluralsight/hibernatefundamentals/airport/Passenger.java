package com.pluralsight.hibernatefundamentals.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
		pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID"))
public class Passenger {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name ="NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "AIRPORT_ID")
	private Airport airport;

	@OneToMany(mappedBy = "passenger")
	private List<Ticket> tickets = new ArrayList<>();

	@Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(50) not null")
	String address;

	public Passenger(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Passenger() {
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Ticket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
