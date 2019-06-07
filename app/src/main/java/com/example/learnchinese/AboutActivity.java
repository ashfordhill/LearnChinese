package com.example.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);

        // a way to make links clickable
        ((TextView) findViewById(R.id.credits_message_textview)).setMovementMethod(LinkMovementMethod.getInstance());

    }
}
