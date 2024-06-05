package com.example.apfast.service;

import com.example.apfast.model.Vehicle;
import com.example.apfast.repository.VehicleDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleDAO vehicleDAO;

    public void addVehicle(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
    }

    public void deleteVehicle(Long vehicleId) {
        vehicleDAO.deleteById(vehicleId);
    }

    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleDAO.findById(vehicleId).orElse(null);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }
}
