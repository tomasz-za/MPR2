package com.example.demo_mpr_lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaneController {

    private final PlaneService service;

    public PlaneController(PlaneService service) {
        this.service = service;

    }

    @GetMapping("/planes")
    public String allplanes(Model model) {
        model.addAttribute("plane", service.displayPlaneRepository());
        return "planes";
    }
}