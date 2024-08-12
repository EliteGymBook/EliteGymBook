package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
}