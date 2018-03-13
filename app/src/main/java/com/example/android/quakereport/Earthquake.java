package com.example.android.quakereport;

import java.time.Instant;
import java.util.Date;
import java.text.DateFormat;

/**
 * Created by genetrinks on 3/11/18.
 */

public class Earthquake {

    private float magnitude;
    private String location;
    private long date;
    private Date formattedDate;
    private String URL;

    //basic constructor with magnitude, location and date
    public Earthquake(float magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.formattedDate = new Date(date) ;
    }

    //full constructor with magnitude, location, date, and URL
    public Earthquake(float magnitude, String location, long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.formattedDate = new Date(date) ;
        this.URL = url;
    }

    // Getters

    public float getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }
    
    public String getFormattedDate() {
        return DateFormat.getDateTimeInstance().format(date);
    }

    public String getURL() {
        return URL;
    }

    // a toString method for printing
    @Override
    public String toString() {
        return "Earthquake{" +
                "magnitude='" + magnitude + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date + '\''+
                ", formatted date=" + formattedDate.toString() +
                '}';
    }
}
