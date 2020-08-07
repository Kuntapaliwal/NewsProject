package com.example.newsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SkipNext extends AppCompatActivity {
    private TextView mTextMessage;
Button skip,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

skip=findViewById(R.id.skip);
next=findViewById(R.id.next);
skip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(SkipNext.this,OutOfApp.class);
    }
});
next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(SkipNext.this,WelcomeActivity.class);
    }
});
    }

}
