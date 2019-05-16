package com.example.learnchinese.VocabReviewMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnchinese.R;
import com.example.learnchinese.VocabReviewActivities.AnimalsActivity;
import com.example.learnchinese.VocabReviewActivities.PeopleActivity;
import com.example.learnchinese.VocabReviewActivities.VocabActivity;

public class VocabReviewMenu extends AppCompatActivity implements VocabReviewMenuView{

    private VocabReviewMenuPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_review_menu);

        presenter = new VocabReviewMenuPresenter(this);

        Button peopleReview = findViewById(R.id.people_review_button);
        Button animalsReview = findViewById(R.id.animals_review_button);

        peopleReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPeopleClick();
            }
        });

        animalsReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAnimalsClick();
            }
        });

    }


    @Override
    public void onPeopleClick() {
        Intent intent = new Intent(this, PeopleActivity.class);
        startActivity(intent);
        finish();
    }

    public void onAnimalsClick() {
        Intent intent = new Intent(this, AnimalsActivity.class);
        startActivity(intent);
        finish();
    }
}
