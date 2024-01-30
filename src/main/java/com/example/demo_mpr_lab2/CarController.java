package com.example.demo_mpr_lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping ("/index")
    public String home(ModelMap map) {
        map.put("hello","hello tomeK2");
        return "index"; //resources/templates/index.html
    }
    @GetMapping(value = "/all")
    public String ee(){
           return "test2";
    }

    @GetMapping("/cars")
    public String all(Model model){
        model.addAttribute("cars",service.displayCarRepository());
        return "cars";
    }

    @GetMapping("/add_car")
    public String addCar(){

        return "add_car";
    }

    @GetMapping("/update_car")
    public String updateCar(){

        return "edit_car";
    }

    @GetMapping("/find_car")
    public String findCar(){

        return "find_car";
    }

    @GetMapping("/delete_car")
    public String deleteCar(){

        return "delete_car";
    }


@GetMapping ("Car/{name}")

    public Car getCarName(@PathVariable("name") String name) {
        return this.service.getRepositoryName(name);
}

    @GetMapping ("Car/name")

    public String getCarName1(@RequestParam String name, Model model) {
        model.addAttribute("cars",service.getRepositoryName(name));
        return "found_cars";
        //return this.service.getRepositoryName(name);
    }

@GetMapping("Car/show")
    public ArrayList<Car> ShowCars(){
        return service.displayCarRepository() ;
}


@PostMapping("Car/add")
    public Car addCarToRepository(@RequestBody Car car){
        return this.service.addCarToRepository(car);
        //return "cars";
}

    @PostMapping("/add1")
    public String addCarToRepository1(@RequestParam String name, @RequestParam String color){
        this.service.addCarToRepository(new Car(name, color));
        return "/add_car";

    }

@PutMapping("Car/update/{name}")
    public void updateCarInRepository(@PathVariable("name") String name,@RequestBody Car updatedCar){
        service.updateCarByName(name, updatedCar);
}

    @PostMapping("Car/update")
    public String updateCarInRepository1(@RequestParam String name, @RequestParam String color){
    //public void updateCarInRepository1(@PathVariable("name") String name,@RequestBody Car updatedCar){

        service.updateCarByName(name, new Car(name, color));
        return "cars";
    }

@DeleteMapping("Car/delete/{name}")
    public void deletaCarInRepository(@PathVariable("name") String name) {
        service.deleteFromCarRepository(name);
}

@PostMapping("Car/delete")
public String deletaCarInRepository1(@RequestParam String name, Model model) {
    //model.addAttribute("cars",service.getRepositoryName(name));
    service.deleteFromCarRepository(name);
    return "delete_car";
}

}