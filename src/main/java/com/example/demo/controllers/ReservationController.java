package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.services.ReservationService;

@CrossOrigin("*")
@RequestMapping("reservations")
@RestController
public class ReservationController {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
    private ReservationService reservationService;
    
	@PostMapping("/add")
	public Reservation addReservation(@RequestBody Reservation reservation) {
	    return reservationService.saveReservation(reservation);
	}
	
	@GetMapping("/{idTerrain}")
	public List<Reservation> getReservationsByTerrain(@PathVariable String idTerrain) {
	    return reservationService.getReservationsByTerrain(idTerrain);
	}

	@DeleteMapping("/{idTerrain}/{nomST}/{date}/{time}")
    public boolean supprimerReservation(@PathVariable String idTerrain, @PathVariable String nomST,
                                        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        return reservationService.supprimerReservation(idTerrain, nomST, date, time);
    }
	
	@GetMapping("/{idTerrain}/{nomSt}/{date}")
	public List<String> getNonDispoHours(@PathVariable String idTerrain, @PathVariable String nomSt, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	    List<Reservation> reservations = reservationService.getHeuresNonDispo(idTerrain,nomSt, date);
	    List<LocalTime> heuresNonDispo = new ArrayList<>();
	    for (Reservation res : reservations) {
	        heuresNonDispo.add(res.getR_id().getTime());
	    }

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	    List<String> heuresNonDispoFormatees = new ArrayList<>();
	    for (LocalTime heure : heuresNonDispo) {
	        String heureFormatee = heure.format(formatter);
	        heuresNonDispoFormatees.add(heureFormatee);
	    }
	    return heuresNonDispoFormatees;
	}


}
