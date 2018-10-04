package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "addPilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    // TODO : ada hubungin view-pilot
    // Variable to use is flights and pilot.
    @RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
    private String getPilot(@RequestParam(name = "licenseNumber") String licenseNumber, Model model) {
        model.addAttribute("pilot", pilotService.getPilotDetailByLicenseNumber(licenseNumber));
        model.addAttribute("flights", flightService.getByPilot(licenseNumber));
        return "view-pilot";
    }
}
