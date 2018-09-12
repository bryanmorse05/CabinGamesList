package com.example.bryan.cabingameslist;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GameDetailPage_Activity extends AppCompatActivity {

    ImageView detailImageView;
    TextView detailName, detailDescription;
    Button tutorialButton, manualButton;
    String manualWebAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail_page_);

        detailImageView = findViewById(R.id.heroImage);
        detailName = findViewById(R.id.detailNameText);
        detailDescription = findViewById(R.id.detailDescriptionText);
        tutorialButton = findViewById(R.id.detailTutorialButton);
        manualButton = findViewById(R.id.detailManualButton);

        if (getIntent().getExtras().getString("imageURL") != null || getIntent().getExtras().getString("imageURL") != "") {

            Picasso.with(this)
                    .load(getIntent().getExtras().getString("imageURL"))
                    .error(R.drawable.ic_launcher_background)       //Handles 404, but not null
                    .into(detailImageView);
        }
        else {
            Picasso.with(this).load(R.drawable.ic_launcher_background).into(detailImageView);
        }

        detailName.setText(getIntent().getExtras().getString("name"));
        detailDescription.setText(getIntent().getExtras().getString("description"));
        manualWebAddress = getIntent().getExtras().getString("manual");

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + getIntent().getExtras().getString("tutorial")));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + getIntent().getExtras().getString("tutorial")));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getExtras().getString("manual")));
                startActivity(browserIntent);
            }
        });

    }
}
