package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Image;

public interface ImageService {

	public Image getImageById(Long id);
	public List<byte[]> getImageByTerrain(String id);
	public List<Image> addImage(List<Image> images);
	public List<Image> getAllImages();
}
