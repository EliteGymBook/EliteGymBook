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

import com.demo.beans.Gym;
import com.demo.service.GymService;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGymById(@PathVariable Long id) {
        return gymService.getGymById(id)
                .map(gym -> ResponseEntity.ok().body(gym))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gym createGym(@RequestBody Gym gym) {
        return gymService.saveGym(gym);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gym> updateGym(@PathVariable Long id, @RequestBody Gym gymDetails) {
        return gymService.getGymById(id)
                .map(gym -> {
                    gym.setGymName(gymDetails.getGymName());
                    gym.setGymAddress(gymDetails.getGymAddress());
                    gym.setGymContact(gymDetails.getGymContact());
                    Gym updatedGym = gymService.saveGym(gym);
                    return ResponseEntity.ok().body(updatedGym);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGym(@PathVariable Long id) {
        return gymService.getGymById(id)
                .map(gym -> {
                    gymService.deleteGym(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}