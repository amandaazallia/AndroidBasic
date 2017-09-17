package com.example.android.earthquakeapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Adroady on 9/15/2017.
 */

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url ){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;

    }

    public String getmUrl() {
        return mUrl;
    }
    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }
}