package com.example.bryan.cabingameslist.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bryan.cabingameslist.R;

public class HomePage_Activity extends AppCompatActivity {

    Button infoButton, gamesButton, videosButton, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_);

        getSupportActionBar().setTitle("Big Bear Cabin Con 2018");

        infoButton = findViewById(R.id.homePageCabinInfoButton);
        gamesButton = findViewById(R.id.homePageGamesListButton);
        videosButton = findViewById(R.id.homePageCabinVideosButton);
        button4 = findViewById(R.id.homePageButtonFour);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vrbo.com/1273971"));
                startActivity(browserIntent);
            }
        });

        gamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameListView_Activity.class);
                startActivity(intent);
            }
        });

        videosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoListView_Activity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do something here
            }
        });
    }
}
