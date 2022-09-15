package com.shreya.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shreya.parking.databinding.ActivityBookingBinding;

public class booking extends Parking {

     ActivityBookingBinding activityBookingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBookingBinding = ActivityBookingBinding.inflate(getLayoutInflater());

        setContentView(activityBookingBinding.getRoot());
        allocateActivityTitle("Booking");
    }
}