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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_);

        cabinVideoPlayer = findViewById(R.id.videoPlayerView);

//        String vidAddress = "<html><body>Video<br><iframe width="320" height="315" src="https://www.youtube.com/watch?v=9GlFZ1wWUk4" frameborder="0" allowfullscreen></iframe></body></html>";
//        String vidAddress = "https://drive.google.com/file/u/1/folders/1PoCX8VcwqmXpyMI5U4s6c-gid0sqNBWG?ogsrc=32/preview";

//        String vidAddress = "<object width='400' height='400' data=\"http://www.youtube.com/embed/9GlFZ1wWUk4\"></object>";
//        String testVideo = "<html><body>Cabin Video 2006<br><iframe width=\"400\" height=\"320\"  src=\"http://www.youtube.com/embed/zIF6kJ3ItYQ\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        //Android Cabin Video ID 1NQjbaVvQklDdRewjFLcAL0ex3Vk5NXl6-FXZV7X4VS2WG
        //https://drive.google.com/file/d/1NQjbaVvQklDdRewjFLcAL0ex3Vk5NXl6/view?usp=sharing

        //Original Cabin Video
        //https://drive.google.com/file/d/1zQlso9Ra5QLYEaeowL-8dlD0zzNM53zg/view?usp=sharing


//        webViewCabinVideo.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });

//        WebSettings webSettings = webViewCabinVideo.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webViewCabinVideo.loadData(testVideo, "text/html", "utf-8");

        //Download and then play the file
        //https://www.googleapis.com/drive/v3/files/file_id?key=your_key&alt=media

        //API Key
        //AIzaSyBNk85aKtbQDxtqQ9GCviajs0Wssnl_uWg

        //This is to download and then play the video in a VideoPlayer
        String videoLink = "https://www.googleapis.com/drive/v3/files/1NQjbaVvQklDdRewjFLcAL0ex3Vk5NXl6?key=AIzaSyBNk85aKtbQDxtqQ9GCviajs0Wssnl_uWg&alt=media";
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(cabinVideoPlayer);
        cabinVideoPlayer.setMediaController(mediaController);
        cabinVideoPlayer.setVideoURI(Uri.parse(videoLink));
        cabinVideoPlayer.start();



    }
}
