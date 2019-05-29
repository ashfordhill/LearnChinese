package com.example.learnchinese.VocabReviewMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.learnchinese.R;
import com.example.learnchinese.VocabReviewActivities.AnimalsActivity;
import com.example.learnchinese.VocabReviewActivities.PeopleActivity;


public class VocabReviewMenu extends AppCompatActivity implements VocabReviewMenuView{

    private VocabReviewMenuPresenter presenter;
    private ListView mVocabOptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_review_menu);

        presenter = new VocabReviewMenuPresenter(this);

        mVocabOptionView = (ListView) findViewById(R.id.vocab_review_option_list);

        VocabReviewMenuAdapter mVocabReviewMenuAdapter = new VocabReviewMenuAdapter(this);
        mVocabOptionView.setAdapter(mVocabReviewMenuAdapter);

        mVocabOptionView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {

                String value = (String)adapter.getItemAtPosition(position);
                presenter.onVocabReviewMenuOptionClick(value);
            }
        });

    }

    public void launchActivity(Class<?> className) {
        Intent intent = new Intent(getBaseContext(), className);
        startActivity(intent);
    }


}
