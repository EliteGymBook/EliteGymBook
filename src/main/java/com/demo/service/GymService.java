package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Gym;

public interface GymService {

	List<Gym> getAllGyms();
    Optional<Gym> getGymById(Long id);
    Gym saveGym(Gym gym);
    void deleteGym(Long id);
}
