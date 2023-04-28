package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Terrain;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.TerrainRepository;
import com.example.demo.repositories.UtilisateurRepository;
import com.example.demo.services.TerrainService;

@Service
public class TerrainServiceImpl implements TerrainService{

	@Autowired
	private TerrainRepository terrainRepo;
	
	@Autowired
	private UtilisateurRepository userRepo;
	
	/*@Autowired
	private SousTerrainRepository STRepo;*/
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Terrain> getAllTerrains() {
		// TODO Auto-generated method stub
		return terrainRepo.findAll();
	}

	@Override
	public Optional<Terrain> getTerrainById(String id) {
		// TODO Auto-generated method stub
		return terrainRepo.findById(id);
	}

	@Override
	public Terrain addTerrain(Terrain terrain) {
		Optional<Terrain> terain = terrainRepo.findById(terrain.getIdTerrain());
		Optional<Utilisateur> user = userRepo.findById(terrain.getIdTerrain());
		if(terain.isEmpty() && user.isEmpty()) {
			String encodedPassword = passwordEncoder.encode(terrain.getMdp());
	        terrain.setMdp(encodedPassword);
		    Terrain terrainAjoute = terrainRepo.save(terrain);
		    Utilisateur userAjoute = new Utilisateur(terrainAjoute.getIdTerrain(),terrainAjoute.getMdp(),null,null,null,0, null,null,null, null);
		    userRepo.save(userAjoute);
		    return terrainAjoute;
		}else return null;
	}

	@Override
	public String login(String idTerrain, String mdp) {
		Optional<Terrain> terrain = terrainRepo.findByIdTerrain(idTerrain);

	    if (terrain.isEmpty()|| (terrain.isPresent() && (!BCrypt.checkpw(mdp, terrain.get().getMdp())))) {
	    	return "oups !";
	    }else return "bravooooo";
	}

}