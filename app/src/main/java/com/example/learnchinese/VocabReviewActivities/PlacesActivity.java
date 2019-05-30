package com.example.learnchinese.VocabReviewActivities;

import android.os.Bundle;


public class PlacesActivity extends VocabActivity {

    private String mCategory = "PLACES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String sendCategory() {
        return mCategory;
    }

}