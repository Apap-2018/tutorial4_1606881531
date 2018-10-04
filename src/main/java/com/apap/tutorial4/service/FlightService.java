package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;

import java.util.List;

public interface FlightService {
    void addFlight(FlightModel flight);
    List<FlightModel> getByPilot(String licenseNumber);
}
