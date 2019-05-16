package com.example.learnchinese.VocabReviewActivities;

import android.os.Bundle;


public class AnimalsActivity extends VocabActivity {

    private String mCategory = "ANIMALS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String sendCategory() {
        return mCategory;
    }

}
