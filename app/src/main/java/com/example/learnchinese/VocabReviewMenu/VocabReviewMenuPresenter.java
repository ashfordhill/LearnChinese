package com.example.learnchinese.VocabReviewMenu;

public class VocabReviewMenuPresenter {

    private VocabReviewMenuView view;

    public VocabReviewMenuPresenter(VocabReviewMenuView view)
    {
        this.view = view;
    }


    void onVocabReviewMenuOptionClick(String className) {
        view.launchActivity(ClassTranslater.GetClass(className));
    }


}
