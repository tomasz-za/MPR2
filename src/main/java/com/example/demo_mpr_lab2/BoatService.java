package com.example.demo_mpr_lab2;

import exceptions.CarAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoatService {
    BoatRepository repository;

    public BoatService(BoatRepository repository) {
        this.repository = repository;
        this.repository.save(new Boat("katamaran", "white"));
        this.repository.save(new Boat("ponton", "black"));
        this.repository.save(new Boat("żaglówka", "dark green"));
    }

    public Boat getRepositoryName(String name) {
        return this.repository.findByName(name);
    }


    public Boat addBoatToRepository(Boat boat) {
        if(repository.findByName(boat.getName()) != null) {
            throw new CarAlreadyExistsException();
        } else {
            return repository.save(boat);
        }
    }

    public void updateBoatByName(String name, Boat updatedBoat) {


        Boat existingBoat = repository.findByName(name);

        if (existingBoat != null) {
            existingBoat.setName(updatedBoat.getName());
            existingBoat.setColor(updatedBoat.getColor());

            repository.save(existingBoat);
        }
    }

    public void deleteFromBoatRepository(String name) {
        Boat existingBoat = repository.findByName(name);

        if (existingBoat != null) {
            repository.delete(existingBoat);
        }
    }

    public ArrayList<Boat> displayBoatRepository(){
        return (ArrayList<Boat>) repository.findAll();

    }

}