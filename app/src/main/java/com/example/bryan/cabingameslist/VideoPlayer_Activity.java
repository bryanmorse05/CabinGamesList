package com.example.bryan.cabingameslist;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer_Activity extends AppCompatActivity {

    VideoView cabinVideoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_);

        cabinVideoPlayerView = findViewById(R.id.cabinVideoPlayerView);

        String vidAddress = "https://drive.google.com/file/d/1zQlso9Ra5QLYEaeowL-8dlD0zzNM53zg/preview";

        Uri videoUri = Uri.parse(vidAddress);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(cabinVideoPlayerView);
        cabinVideoPlayerView.setMediaController(mediaController);

        cabinVideoPlayerView.setVideoURI(videoUri);
        cabinVideoPlayerView.start();
    }
}
