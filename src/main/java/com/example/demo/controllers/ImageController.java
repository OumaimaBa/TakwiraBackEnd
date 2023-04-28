package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Image;
import com.example.demo.entities.Terrain;
import com.example.demo.repositories.TerrainRepository;
import com.example.demo.services.ImageService;

@CrossOrigin("*")
@RequestMapping("images")
@RestController
public class ImageController {
	
	@Autowired
	public ImageService imageService;
	@Autowired
	public TerrainRepository TRepo;
	
	@PostMapping("/add")
	public ResponseEntity<String> addImages(@RequestParam("file") List<@NotNull MultipartFile> files, @RequestParam String terrainId) {
	    try {
	        Optional<Terrain> terrain = TRepo.findById(terrainId);
	        if (!terrain.isPresent()) {
	            return new ResponseEntity<>("Terrain introuvable", HttpStatus.NOT_FOUND);
	        }

	        List<Image> images = new ArrayList<>();
	        for (MultipartFile file : files) {
	            byte[] bytes = file.getBytes();

	            Image image = new Image();
	            image.setBin(bytes);
	            image.setTerrain(terrain.get());

	            images.add(image);
	        }

	        imageService.addImage(images);

	        return new ResponseEntity<>("Les images ont été ajoutées avec succès", HttpStatus.OK);
	    } catch (IOException e) {
	        return new ResponseEntity<>("Erreur lors de la lecture du fichier", HttpStatus.BAD_REQUEST);
	    }
	}



	@GetMapping("/{id}")
	public List<byte[]> getImagesByTerrain(@PathVariable String id){
		return imageService.getImageByTerrain(id);
	}
}
