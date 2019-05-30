package com.example.learnchinese.VocabReviewActivities;

import android.os.Bundle;


public class FoodActivity extends VocabActivity {

    private String mCategory = "FOOD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String sendCategory() {
        return mCategory;
    }

}