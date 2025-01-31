package com.example.apfast.repository;


import com.example.apfast.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Long> {

}
