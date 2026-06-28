# CLAUDE.md

## Project

Project name: `aerosky-ops-copilot-api`

This is a dummy/demo Spring Boot project for an Ops Copilot / Incident Intelligence MVP.

The project must use only fictional/demo context.

## Strict data rules

Do not use or generate any real company names, client names, internal project names, secrets, production URLs, access tokens, API keys, passwords, or proprietary references.

Do not use references to any real airline, employer, client, or consulting company.

Use only the fictional context below:

* Fictional company: AeroSky Airlines
* Product: AeroBag Assist
* Domain: Baggage Disruption Management
* Source service: `baggage-disruption-api`
* Copilot service: `aerosky-ops-copilot-api`
* Owning/support team: AeroBag Platform Team / AeroBag L2 Support

## Technology

Use:

* Java 21
* Spring Boot 3
* Maven
* Package name: `com.aeroskylabs.ops.copilot`

Use clean packages:

* `controller`
* `service`
* `model`
* `repository`
* `exception`

## Current development scope

Build only Step 1: Incoming incident flow using mock ServiceNow data.

Do not add Splunk integration yet.

Do not add Datadog integration yet.

Do not add GitHub integration yet.

Do not add Jira integration yet.

Do not add real ServiceNow API integration yet.

Do not add LLM or AI integration yet.

Do not add authentication/security yet.

Do not add database persistence yet.

## Required endpoints

### 1. List mock incidents

`GET /api/mock-servicenow/incidents`

Return all mock incidents.

### 2. Get mock incident by number

`GET /api/mock-servicenow/incidents/{incidentNumber}`

Return one mock incident by incident number.

If the incident does not exist, return a clean 404 response.

### 3. Analyze incident

`POST /api/incidents/analyze`

Request body:

```json
{
  "incidentNumber": "INC0010001"
}
```

Behaviour:

* Look up the mock incident.
* Extract basic search terms from the incident.
* Return an incident context response.
* Do not call any external connectors.

Expected response shape:

```json
{
  "incidentNumber": "INC0010001",
  "serviceName": "baggage-disruption-api",
  "shortDescription": "Courier assignment failing for recovered baggage cases",
  "description": "COURIER_ASSIGNMENT_FAILED observed for baggage-disruption-api while calling courier-assignment-api.",
  "searchTerms": [
    "baggage-disruption-api",
    "COURIER_ASSIGNMENT_FAILED",
    "courier-assignment-api"
  ],
  "nextStep": "Incident context prepared. External evidence connectors are not called yet."
}
```

## Mock incidents

Create these mock incidents in an in-memory repository.

### INC0010001

* `sysId`: `mock-sys-1001`
* `number`: `INC0010001`
* `shortDescription`: `Courier assignment failing for recovered baggage cases`
* `description`: `COURIER_ASSIGNMENT_FAILED observed for baggage-disruption-api while calling courier-assignment-api.`
* `serviceName`: `baggage-disruption-api`
* `priority`: `2`
* `state`: `New`
* `assignmentGroup`: `AeroBag L2 Support`

Expected search terms:

* `baggage-disruption-api`
* `COURIER_ASSIGNMENT_FAILED`
* `courier-assignment-api`

### INC0010002

* `sysId`: `mock-sys-1002`
* `number`: `INC0010002`
* `shortDescription`: `Airport scan event timeout for delayed baggage case`
* `description`: `BAG_SCAN_EVENT_TIMEOUT observed in baggage-disruption-api from airport-scan-event-adapter.`
* `serviceName`: `baggage-disruption-api`
* `priority`: `2`
* `state`: `New`
* `assignmentGroup`: `AeroBag L2 Support`

Expected search terms:

* `baggage-disruption-api`
* `BAG_SCAN_EVENT_TIMEOUT`
* `airport-scan-event-adapter`

### INC0010003

* `sysId`: `mock-sys-1003`
* `number`: `INC0010003`
* `shortDescription`: `Routing config not found during baggage case creation`
* `description`: `AIRPORT_ROUTING_CONFIG_NOT_FOUND observed during baggage case creation for baggage-disruption-api.`
* `serviceName`: `baggage-disruption-api`
* `priority`: `3`
* `state`: `New`
* `assignmentGroup`: `AeroBag L2 Support`

Expected search terms:

* `baggage-disruption-api`
* `AIRPORT_ROUTING_CONFIG_NOT_FOUND`

## Search-term extraction rules

Keep extraction simple and deterministic.

Always include:

* `serviceName`

If description contains:

* `COURIER_ASSIGNMENT_FAILED`, include `COURIER_ASSIGNMENT_FAILED`
* `courier-assignment-api`, include `courier-assignment-api`
* `BAG_SCAN_EVENT_TIMEOUT`, include `BAG_SCAN_EVENT_TIMEOUT`
* `airport-scan-event-adapter`, include `airport-scan-event-adapter`
* `AIRPORT_ROUTING_CONFIG_NOT_FOUND`, include `AIRPORT_ROUTING_CONFIG_NOT_FOUND`
* `airport-routing-config-api`, include `airport-routing-config-api`

Remove duplicate terms.

Preserve meaningful order:

1. service name
2. error code
3. downstream system

## Error handling

If incident is not found, return HTTP 404 with response:

```json
{
  "errorCode": "INCIDENT_NOT_FOUND",
  "message": "Incident not found: INC0019999"
}
```

If request body is invalid or missing incident number, return HTTP 400 with a clear message.

## Files to include

Include:

* `README.md`
* `.gitignore`
* `scripts/test-incident-flow.ps1`

The PowerShell test script should test:

* list incidents
* get `INC0010001`
* analyze `INC0010001`
* analyze `INC0010002`
* analyze `INC0010003`

## README requirements

README should include:

* project purpose
* fictional/demo context
* local run command
* curl commands
* PowerShell script command
* current scope
* explicitly state that external connectors are intentionally not implemented yet

## Build requirements

The project must pass:

```powershell
mvn clean install
```

The app must run with:

```powershell
mvn spring-boot:run
```

Default port should be:

```yaml
server:
  port: 8082
```

## Implementation style

Keep code simple and readable.

Do not over-engineer.

Do not add unnecessary frameworks.

Do not create interfaces for future connectors yet.

Do not add unused classes for Splunk, Datadog, GitHub, Jira, or real ServiceNow yet.

This first milestone is only:

Mock incident source → incident lookup → search term extraction → incident context response.
