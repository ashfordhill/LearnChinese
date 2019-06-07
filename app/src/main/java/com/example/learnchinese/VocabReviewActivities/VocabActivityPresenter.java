package com.example.learnchinese.VocabReviewActivities;

import android.widget.ListView;

import com.example.learnchinese.data.WordCursorAdapter;

public class VocabActivityPresenter {

    private VocabActivityView view;
    private WordCursorAdapter mCursorAdapter;


    public VocabActivityPresenter(VocabActivityView view, WordCursorAdapter mCursorAdapter, ListView listview){
        this.view = view;
        this.mCursorAdapter = mCursorAdapter;

    }


    public void displayWords() {
        view.initView();
    }


 }
