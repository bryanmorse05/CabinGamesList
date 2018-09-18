package com.example.bryan.cabingameslist.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.bryan.cabingameslist.R;

public class VideoPlayer_Activity extends AppCompatActivity {

    VideoView cabinVideoPlayer;
    static final String API_KEY = "AIzaSyBNk85aKtbQDxtqQ9GCviajs0Wssnl_uWg";
    String cabinVideoID, cabinYear, cabinTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_);

        cabinVideoPlayer = findViewById(R.id.videoPlayerView);

        cabinVideoID = getIntent().getExtras().getString("video_id");
        cabinTitle = getIntent().getExtras().getString("title");
        cabinYear = getIntent().getExtras().getString("year");


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle(cabinYear + " " + cabinTitle);

        //Cabin 1, used as default for testing
//        cabinVideoURL = "1NQjbaVvQklDdRewjFLcAL0ex3Vk5NXl6";

        //Download and then play the file
        //https://www.googleapis.com/drive/v3/files/file_id?key=your_key&alt=media

        //This is to download and then play the video in a VideoPlayer
        String videoLink = "https://www.googleapis.com/drive/v3/files/" + cabinVideoID + "?key=" + API_KEY + "&alt=media";
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(cabinVideoPlayer);
        cabinVideoPlayer.setMediaController(mediaController);
        cabinVideoPlayer.setVideoURI(Uri.parse(videoLink));
        cabinVideoPlayer.start();



    }
}
