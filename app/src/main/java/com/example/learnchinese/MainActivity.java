package com.example.learnchinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.learnchinese.VocabReviewMenu.VocabReviewMenu;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        // Set on click listeners for main menu buttons
        Button vocabReviewButton = findViewById(R.id.vocab_review_button);
        vocabReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onVocabReviewClick();
            }
        });

        Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAboutClick();
            }
        });
    }

    @Override
    public void openVocabReview() {
        Intent intent = new Intent(this, VocabReviewMenu.class);
        startActivity(intent);
    }

    @Override
    public void openAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}
