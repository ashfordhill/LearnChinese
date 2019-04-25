package com.example.learnchinese;

import android.view.View;

import com.example.learnchinese.data.WordCursorAdapter;

public class MainActivityPresenter {
    private MainActivityView view;
    private WordRepository wordRepository;
    private WordCursorAdapter mCursorAdapter;


    public MainActivityPresenter(MainActivityView view,WordCursorAdapter mCursorAdapter, WordRepository wordRepository){
        this.view = view;
    }


    public void displayWords() {
        view.initView();
    }

}
