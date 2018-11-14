package com.rainy.bryan.cabingameslist.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rainy.bryan.cabingameslist.R;

public class HomePage_Activity extends AppCompatActivity {

    Button infoButton, gamesButton, videosButton, friendsButton;
    static final String CABIN_URL = "https://www.tripadvisor.com/VacationRentalReview-g32074-d4956340-Edgewood_Castle_15_000sf_5_star_luxury_Sleeps_24-Big_Bear_Region_California.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_);

        getSupportActionBar().setTitle("Big Bear Cabin Con 2018");

        infoButton = findViewById(R.id.homePageCabinInfoButton);
        gamesButton = findViewById(R.id.homePageGamesListButton);
        videosButton = findViewById(R.id.homePageCabinVideosButton);
        friendsButton = findViewById(R.id.homePageFriendsButton);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(CABIN_URL));
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

        friendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Friends_Activity.class);
                startActivity(intent);
            }
        });
    }
}