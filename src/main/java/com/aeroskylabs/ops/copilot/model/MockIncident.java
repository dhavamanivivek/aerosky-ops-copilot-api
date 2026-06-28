package com.aeroskylabs.ops.copilot.model;

public class MockIncident {

    private String sysId;
    private String number;
    private String shortDescription;
    private String description;
    private String serviceName;
    private String priority;
    private String state;
    private String assignmentGroup;

    public MockIncident() {}

    public MockIncident(String sysId, String number, String shortDescription, String description,
                        String serviceName, String priority, String state, String assignmentGroup) {
        this.sysId = sysId;
        this.number = number;
        this.shortDescription = shortDescription;
        this.description = description;
        this.serviceName = serviceName;
        this.priority = priority;
        this.state = state;
        this.assignmentGroup = assignmentGroup;
    }

    public String getSysId() { return sysId; }
    public void setSysId(String sysId) { this.sysId = sysId; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getAssignmentGroup() { return assignmentGroup; }
    public void setAssignmentGroup(String assignmentGroup) { this.assignmentGroup = assignmentGroup; }
}