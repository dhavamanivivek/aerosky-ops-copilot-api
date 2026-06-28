package com.aeroskylabs.ops.copilot.service;

import com.aeroskylabs.ops.copilot.exception.IncidentNotFoundException;
import com.aeroskylabs.ops.copilot.model.MockIncident;
import com.aeroskylabs.ops.copilot.repository.MockIncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockIncidentService {

    private final MockIncidentRepository repository;

    public MockIncidentService(MockIncidentRepository repository) {
        this.repository = repository;
    }

    public List<MockIncident> getAllIncidents() {
        return repository.findAll();
    }

    public MockIncident getByNumber(String incidentNumber) {
        return repository.findByNumber(incidentNumber)
                .orElseThrow(() -> new IncidentNotFoundException(incidentNumber));
    }
}