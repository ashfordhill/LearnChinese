package com.example.learnchinese.VocabReviewActivities;

import android.os.Bundle;

import com.example.learnchinese.R;

public class PeopleActivity extends VocabActivity {

    private static final String CATEGORY = "PEOPLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setCategory(CATEGORY);
        super.onCreate(savedInstanceState);
    }
}
