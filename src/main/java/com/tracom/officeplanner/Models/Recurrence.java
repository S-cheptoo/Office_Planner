package com.tracom.officeplanner.Models;

public enum Recurrence {
    NONE,
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY;

    public String getName(){
        return this.name();
    }
}
