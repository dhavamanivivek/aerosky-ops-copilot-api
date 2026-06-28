package com.aeroskylabs.ops.copilot.model;

import java.util.List;

public class IncidentContextResponse {

    private String incidentNumber;
    private String serviceName;
    private String shortDescription;
    private String description;
    private List<String> searchTerms;
    private String nextStep;

    public IncidentContextResponse() {}

    public IncidentContextResponse(String incidentNumber, String serviceName, String shortDescription,
                                   String description, List<String> searchTerms, String nextStep) {
        this.incidentNumber = incidentNumber;
        this.serviceName = serviceName;
        this.shortDescription = shortDescription;
        this.description = description;
        this.searchTerms = searchTerms;
        this.nextStep = nextStep;
    }

    public String getIncidentNumber() { return incidentNumber; }
    public void setIncidentNumber(String incidentNumber) { this.incidentNumber = incidentNumber; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getSearchTerms() { return searchTerms; }
    public void setSearchTerms(List<String> searchTerms) { this.searchTerms = searchTerms; }

    public String getNextStep() { return nextStep; }
    public void setNextStep(String nextStep) { this.nextStep = nextStep; }
}