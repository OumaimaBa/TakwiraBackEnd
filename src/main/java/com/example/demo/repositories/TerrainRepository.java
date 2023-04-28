package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, String> {


	Optional<Terrain> findByIdTerrainAndMdp(String idTerrain, String mdp);

	Optional<Terrain> findByIdTerrain(String idTerrain);

}
