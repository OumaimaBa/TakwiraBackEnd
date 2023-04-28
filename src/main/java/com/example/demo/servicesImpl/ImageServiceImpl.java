package com.example.demo.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Image;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	public ImageRepository imageRepo;
	
	@Override
	public Image getImageById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getAllImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<byte[]> getImageByTerrain(String id) {
	    List<Image> images = imageRepo.findByTerrainIdTerrain(id);
	    List<byte[]> bytesList = new ArrayList<>();
	    for (Image image : images) {
	        bytesList.add(image.getBin());
	    }
	    return bytesList;
	}

	@Override
	public List<Image> addImage(List<Image> images) {
		return imageRepo.saveAll(images);
	}



}
