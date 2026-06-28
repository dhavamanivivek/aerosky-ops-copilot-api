package com.aeroskylabs.ops.copilot.service;

import com.aeroskylabs.ops.copilot.model.IncidentContextResponse;
import com.aeroskylabs.ops.copilot.model.MockIncident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class IncidentAnalysisService {

    private static final List<String> KNOWN_ERROR_CODES = List.of(
            "COURIER_ASSIGNMENT_FAILED",
            "BAG_SCAN_EVENT_TIMEOUT",
            "AIRPORT_ROUTING_CONFIG_NOT_FOUND"
    );

    private static final List<String> KNOWN_DOWNSTREAM_SYSTEMS = List.of(
            "courier-assignment-api",
            "airport-scan-event-adapter",
            "airport-routing-config-api"
    );

    private static final String NEXT_STEP =
            "Incident context prepared. External evidence connectors are not called yet.";

    public IncidentContextResponse analyze(MockIncident incident) {
        List<String> searchTerms = extractSearchTerms(incident);
        return new IncidentContextResponse(
                incident.getNumber(),
                incident.getServiceName(),
                incident.getShortDescription(),
                incident.getDescription(),
                searchTerms,
                NEXT_STEP
        );
    }

    private List<String> extractSearchTerms(MockIncident incident) {
        Set<String> terms = new LinkedHashSet<>();
        String description = incident.getDescription();

        terms.add(incident.getServiceName());

        for (String errorCode : KNOWN_ERROR_CODES) {
            if (description.contains(errorCode)) {
                terms.add(errorCode);
            }
        }

        for (String system : KNOWN_DOWNSTREAM_SYSTEMS) {
            if (description.contains(system)) {
                terms.add(system);
            }
        }

        return new ArrayList<>(terms);
    }
}