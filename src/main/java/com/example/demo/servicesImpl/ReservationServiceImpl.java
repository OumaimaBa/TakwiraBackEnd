package com.example.demo.servicesImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.ReservationId;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
    private ReservationRepository reservationRepository;

	@Override
	public Reservation saveReservation(Reservation reservation) {
		ReservationId r = new ReservationId(reservation.getR_id().getSousTerrain(),reservation.getR_id().getDate(),reservation.getR_id().getTime());
		if(reservationRepository.findByRid(r).size()!=0) {
	        throw new RuntimeException("Terrain non disponible ");
	    }
	    return reservationRepository.save(reservation);
	}

	@Override
    public void deleteReservation(ReservationId id) {
        reservationRepository.deleteById(id);
    }

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(ReservationId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationsByTerrain(String idTerrain) {
	    List<Reservation> reservations = reservationRepository.findByRidSousTerrainIdSTTerrainIdTerrain(idTerrain);
	    return reservations;
	}

	@Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean supprimerReservation(String idTerrain, String nomST, LocalDate date, LocalTime time) {
        String sql = "DELETE FROM reservation WHERE id_terrain = ? AND nom_st = ? AND date = ? AND time = ?";
        int rowsAffected = jdbcTemplate.update(sql, idTerrain, nomST, date, time);
        return rowsAffected > 0;
    }

	@Override
	public List<Reservation> getHeuresNonDispo(String idTerrain, String nomSt, LocalDate date) {
		return reservationRepository.findByRidSousTerrainIdSTTerrainIdTerrainAndRidSousTerrainIdSTNomAndRidDate(idTerrain, nomSt, date);
	}


}
