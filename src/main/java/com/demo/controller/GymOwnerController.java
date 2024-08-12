package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.GymOwner;
import com.demo.service.GymOwnerService;

@RestController
	@RequestMapping("/api/gymOwners")
	public class GymOwnerController {

	    @Autowired
	    private GymOwnerService gymOwnerService;

	    @GetMapping
	    public List<GymOwner> getAllGymOwners() {
	        return gymOwnerService.getAllGymOwners();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<GymOwner> getGymOwnerById(@PathVariable Long id) {
	        return gymOwnerService.getGymOwnerById(id)
	                .map(gymOwner -> ResponseEntity.ok().body(gymOwner))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public GymOwner createGymOwner(@RequestBody GymOwner gymOwner) {
	        return gymOwnerService.saveGymOwner(gymOwner);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<GymOwner> updateGymOwner(@PathVariable Long id, @RequestBody GymOwner gymOwnerDetails) {
	        return gymOwnerService.getGymOwnerById(id)
	                .map(gymOwner -> {
	                    gymOwner.setOwnerName(gymOwnerDetails.getOwnerName());
	                    gymOwner.setOwnerEmail(gymOwnerDetails.getOwnerEmail());
	                    gymOwner.setOwnerPassword(gymOwnerDetails.getOwnerPassword());
	                    GymOwner updatedGymOwner = gymOwnerService.saveGymOwner(gymOwner);
	                    return ResponseEntity.ok().body(updatedGymOwner);
	                }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deleteGymOwner(@PathVariable Long id) {
	        return gymOwnerService.getGymOwnerById(id)
	                .map(gymOwner -> {
	                    gymOwnerService.deleteGymOwner(id);
	                    return ResponseEntity.ok().build();
	                }).orElse(ResponseEntity.notFound().build());
	    }
	
}
