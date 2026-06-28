package com.aeroskylabs.ops.copilot.controller;

import com.aeroskylabs.ops.copilot.model.AnalyzeRequest;
import com.aeroskylabs.ops.copilot.model.IncidentContextResponse;
import com.aeroskylabs.ops.copilot.model.MockIncident;
import com.aeroskylabs.ops.copilot.service.IncidentAnalysisService;
import com.aeroskylabs.ops.copilot.service.MockIncidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final MockIncidentService mockIncidentService;
    private final IncidentAnalysisService incidentAnalysisService;

    public IncidentController(MockIncidentService mockIncidentService,
                              IncidentAnalysisService incidentAnalysisService) {
        this.mockIncidentService = mockIncidentService;
        this.incidentAnalysisService = incidentAnalysisService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<IncidentContextResponse> analyze(@Valid @RequestBody AnalyzeRequest request) {
        MockIncident incident = mockIncidentService.getByNumber(request.getIncidentNumber());
        IncidentContextResponse response = incidentAnalysisService.analyze(incident);
        return ResponseEntity.ok(response);
    }
}