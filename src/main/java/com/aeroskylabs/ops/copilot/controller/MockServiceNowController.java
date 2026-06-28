package com.aeroskylabs.ops.copilot.controller;

import com.aeroskylabs.ops.copilot.model.MockIncident;
import com.aeroskylabs.ops.copilot.service.MockIncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mock-servicenow/incidents")
public class MockServiceNowController {

    private final MockIncidentService mockIncidentService;

    public MockServiceNowController(MockIncidentService mockIncidentService) {
        this.mockIncidentService = mockIncidentService;
    }

    @GetMapping
    public ResponseEntity<List<MockIncident>> listIncidents() {
        return ResponseEntity.ok(mockIncidentService.getAllIncidents());
    }

    @GetMapping("/{incidentNumber}")
    public ResponseEntity<MockIncident> getIncident(@PathVariable String incidentNumber) {
        return ResponseEntity.ok(mockIncidentService.getByNumber(incidentNumber));
    }
}