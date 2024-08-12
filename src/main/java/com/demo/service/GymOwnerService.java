package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.GymOwner;

public interface GymOwnerService {

	List<GymOwner> getAllGymOwners();
    Optional<GymOwner> getGymOwnerById(Long id);
    GymOwner saveGymOwner(GymOwner gymOwner);
    void deleteGymOwner(Long id);
}
