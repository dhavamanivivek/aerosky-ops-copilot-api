package com.aeroskylabs.ops.copilot.repository;

import com.aeroskylabs.ops.copilot.model.MockIncident;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MockIncidentRepository {

    private final Map<String, MockIncident> incidents = new LinkedHashMap<>();

    public MockIncidentRepository() {
        incidents.put("INC0010001", new MockIncident(
                "mock-sys-1001",
                "INC0010001",
                "Courier assignment failing for recovered baggage cases",
                "COURIER_ASSIGNMENT_FAILED observed for baggage-disruption-api while calling courier-assignment-api.",
                "baggage-disruption-api",
                "2",
                "New",
                "AeroBag L2 Support"
        ));
        incidents.put("INC0010002", new MockIncident(
                "mock-sys-1002",
                "INC0010002",
                "Airport scan event timeout for delayed baggage case",
                "BAG_SCAN_EVENT_TIMEOUT observed in baggage-disruption-api from airport-scan-event-adapter.",
                "baggage-disruption-api",
                "2",
                "New",
                "AeroBag L2 Support"
        ));
        incidents.put("INC0010003", new MockIncident(
                "mock-sys-1003",
                "INC0010003",
                "Routing config not found during baggage case creation",
                "AIRPORT_ROUTING_CONFIG_NOT_FOUND observed during baggage case creation for baggage-disruption-api.",
                "baggage-disruption-api",
                "3",
                "New",
                "AeroBag L2 Support"
        ));
    }

    public List<MockIncident> findAll() {
        return List.copyOf(incidents.values());
    }

    public Optional<MockIncident> findByNumber(String number) {
        return Optional.ofNullable(incidents.get(number));
    }
}