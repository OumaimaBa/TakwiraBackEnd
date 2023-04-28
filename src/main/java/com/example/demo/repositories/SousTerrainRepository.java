package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.SousTerrain;
import com.example.demo.entities.SousTerrainId;
public interface SousTerrainRepository extends JpaRepository<SousTerrain,SousTerrainId>{

    List<SousTerrain> findByIdST_Terrain_IdTerrain(String idTerrain);
}
