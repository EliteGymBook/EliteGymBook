package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.GymOwner;
import com.demo.repository.GymOwnerRepository;

@Service
public class GymOwnerServiceImpl implements GymOwnerService {

    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    @Override
    public List<GymOwner> getAllGymOwners() {
        return gymOwnerRepository.findAll();
    }

    @Override
    public Optional<GymOwner> getGymOwnerById(Long id) {
        return gymOwnerRepository.findById(id);
    }

    @Override
    public GymOwner saveGymOwner(GymOwner gymOwner) {
        return gymOwnerRepository.save(gymOwner);
    }

    @Override
    public void deleteGymOwner(Long id) {
        gymOwnerRepository.deleteById(id);
    }
}
