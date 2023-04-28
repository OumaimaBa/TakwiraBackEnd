package com.example.demo.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.ReservationId;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

	List<Reservation> findByRid(ReservationId r_id);

    List<Reservation> findByRidSousTerrainIdSTTerrainIdTerrain(String idTerrain);

    List<Reservation> findByRidSousTerrainIdSTTerrainIdTerrainAndRidSousTerrainIdSTNomAndRidDate(String idTerrain, String nomSt, LocalDate date);

}
