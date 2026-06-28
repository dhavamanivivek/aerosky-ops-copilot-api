package com.aeroskylabs.ops.copilot.exception;

public class IncidentNotFoundException extends RuntimeException {

    public IncidentNotFoundException(String incidentNumber) {
        super("Incident not found: " + incidentNumber);
    }
}