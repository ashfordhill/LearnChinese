package com.example.learnchinese;

import android.view.View;

import com.example.learnchinese.data.WordCursorAdapter;

public class MainActivityPresenter {

    private MainActivityView view;


    public MainActivityPresenter(MainActivityView view){
        this.view = view;
    }


    public void onVocabReviewClick() {
        view.openVocabReview();
    }

}
