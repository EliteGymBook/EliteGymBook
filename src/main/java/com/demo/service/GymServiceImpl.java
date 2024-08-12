package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Gym;
import com.demo.repository.GymRepository;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;

    @Override
    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    @Override
    public Optional<Gym> getGymById(Long id) {
        return gymRepository.findById(id);
    }

    @Override
    public Gym saveGym(Gym gym) {
        return gymRepository.save(gym);
    }

    @Override
    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}