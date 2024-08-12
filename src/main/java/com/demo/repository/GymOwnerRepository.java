package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.GymOwner;

@Repository
public interface GymOwnerRepository extends JpaRepository<GymOwner, Long> {
}