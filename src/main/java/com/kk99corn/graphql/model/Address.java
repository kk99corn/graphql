package com.kk99corn.graphql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String address;
	private String city;
	private String state;
	private String zip;

	public Address() {
	}

	public Address(String address, String city, String state, String zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
