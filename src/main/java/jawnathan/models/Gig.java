package jawnathan.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Gig {
    private int gigId;
    private LocalDate date;
    private String details;
    private LocalTime startTime;
    private LocalTime endTime;
    private int venueId;
    private int groupId;

    public Gig(int gigId, LocalDate date, LocalDate endDate, String details, LocalTime startTime, LocalTime endTime, int venueId, int groupId) {
        this.gigId = gigId;
        this.date = date;
        this.details = details;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venueId = venueId;
    }

    public Gig() {
    }

    public int getGigId() {
        return gigId;
    }

    public void setGigId(int gigId) {
        this.gigId = gigId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}