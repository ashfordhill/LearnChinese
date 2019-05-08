package com.example.learnchinese.VocabReviewActivities;

import com.example.learnchinese.MainActivityView;
import com.example.learnchinese.WordRepository;
import com.example.learnchinese.data.WordCursorAdapter;

public class VocabActivityPresenter {

    private VocabActivityView view;
    private WordRepository wordRepository;
    private WordCursorAdapter mCursorAdapter;


    public VocabActivityPresenter(VocabActivityView view, WordCursorAdapter mCursorAdapter){
        this.view = view;
    }


    public void displayWords() {
        view.initView();
    }
}
