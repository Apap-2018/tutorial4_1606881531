package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;

    @Override
    public void addFlight(FlightModel flight) {
        flightDb.save(flight);
    }

    @Override
    public List<FlightModel> getByPilot(String licenseNumber) {
        return flightDb.findFlightModelsByPilot_LicenseNumber(licenseNumber);
    }
}
