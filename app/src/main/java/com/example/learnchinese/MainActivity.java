package com.example.learnchinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.learnchinese.R;
import com.example.learnchinese.VocabReviewActivities.PeopleActivity;
import com.example.learnchinese.VocabReviewActivities.VocabActivity;
import com.example.learnchinese.VocabReviewMenu.VocabReviewMenu;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);


        Button vocabReview = findViewById(R.id.vocab_review_button);
        vocabReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onVocabReviewClick();
            }
        });


    }

    @Override
    public void openVocabReview() {
        Intent intent = new Intent(this, VocabReviewMenu.class);
        startActivity(intent);
    }



}
