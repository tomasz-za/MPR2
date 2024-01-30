package com.example.demo_mpr_lab2;

import exceptions.CarAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlaneService {
    PlaneRepository repository;

    public PlaneService(PlaneRepository repository) {
        this.repository = repository;
        this.repository.save(new Plane("bocian", "white"));
        this.repository.save(new Plane("AB-380", "light blue"));
        this.repository.save(new Plane("B33", "black"));
    }

    public Plane getRepositoryName(String name) {
        return this.repository.findByName(name);
    }


    public Plane addPlaneToRepository(Plane plane) {
        if(repository.findByName(plane.getName()) != null) {
            throw new CarAlreadyExistsException();
        } else {
            return repository.save(plane);
        }
    }

    public void updatePlaneByName(String name, Plane updatedPlane) {


        Plane existingPlane = repository.findByName(name);

        if (existingPlane != null) {
            existingPlane.setName(updatedPlane.getName());
            existingPlane.setColor(updatedPlane.getColor());

            repository.save(existingPlane);
        }
    }

    public void deleteFromPlaneRepository(String name) {
        Plane existingPlane = repository.findByName(name);

        if (existingPlane != null) {
            repository.delete(existingPlane);
        }
    }

    public ArrayList<Plane> displayPlaneRepository(){
        return (ArrayList<Plane>) repository.findAll();

    }

}