package com.example.learnchinese.VocabReviewMenu;

public class VocabReviewMenuPresenter {

    private VocabReviewMenuView view;

    public VocabReviewMenuPresenter(VocabReviewMenuView view)
    {
        this.view = view;
    }

    void onPeopleClick() {
        view.onPeopleClick();
    }

    void onAnimalsClick() {
        view.onAnimalsClick();
    }


}
