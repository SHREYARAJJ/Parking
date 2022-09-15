package com.shreya.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shreya.parking.databinding.ActivityNavigationBinding;

public class bookingdetail extends Parking {

    ActivityNavigationBinding activityNavigationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNavigationBinding = ActivityNavigationBinding.inflate(getLayoutInflater());

        setContentView(activityNavigationBinding.getRoot());
        allocateActivityTitle("Booking Detail");
    }
}