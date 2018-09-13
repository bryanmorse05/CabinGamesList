package com.example.bryan.cabingameslist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage_Activity extends AppCompatActivity {

    Button infoButton, gamesButton, videosButton, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_);

        getSupportActionBar().setTitle("Welcome Friends to");

        infoButton = findViewById(R.id.homePageCabinInfoButton);
        gamesButton = findViewById(R.id.homePageGamesListButton);
        videosButton = findViewById(R.id.homePageCabinVideosButton);
        button4 = findViewById(R.id.homePageButtonFour);

        gamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameListView_Activity.class);
                startActivity(intent);
            }
        });
    }
}
