package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.ReservationId;

public interface ReservationService {

	List<Reservation> getAllReservations();

	void deleteReservation(ReservationId id);

	Reservation saveReservation(Reservation reservation);

	Reservation getReservationById(ReservationId id);

	List<Reservation> getReservationsByTerrain(String idTerrain);
	
    boolean supprimerReservation(String idTerrain, String nomST, LocalDate date, LocalTime time);
    
    List<Reservation> getHeuresNonDispo(String idTerrain, String nomSt, LocalDate date);
	
}
