package org.schipol.model;

import java.util.Date;

public record Flight(String flightName, String id, Date scheduleDate, Integer terminal, Date actualLandingTime, Object aircraftType) {
}
