package com.example.learnchinese.VocabReviewActivities;

import android.os.Bundle;


public class NumbersActivity extends VocabActivity {

    private String mCategory = "NUMBERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String sendCategory() {
        return mCategory;
    }

}