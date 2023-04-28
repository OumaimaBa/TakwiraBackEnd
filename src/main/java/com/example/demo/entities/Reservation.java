package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@EmbeddedId
	private ReservationId rid;
	
	private String code;

	@ManyToOne
	@JoinColumn(name = "username")
	private Utilisateur user;
	
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(ReservationId r_id, String code, Utilisateur user) {
		super();
		rid = r_id;
		this.code=code;
		this.user = user;
	}

	public ReservationId getR_id() {
		return rid;
	}

	public void setR_id(ReservationId r_id) {
		rid = r_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

