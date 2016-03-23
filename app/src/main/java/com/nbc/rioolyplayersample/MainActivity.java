package com.nbc.rioolyplayersample;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nbc.rioolyplayer.VideoPlayerFragment;
import com.nbc.rioolyplayer.ui.VideoPlayerConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        VideoPlayerFragment fragment = (VideoPlayerFragment) fragmentManager.findFragmentByTag("video");
        if (fragment == null) {
            fragment = createVideoPlayerFragment();
            fragmentManager.beginTransaction()
                .add(R.id.container, fragment, "video")
                .commit();
        }
    }

    private VideoPlayerFragment createVideoPlayerFragment() {
        VideoPlayerConfig config = new VideoPlayerConfig()
            .publicUrl("http://link.theplatform.com/s/vFnELC/media/4vT1u_cBVX4V")
            .title("Jordan Burroughs Wins Gold In Freestyle")
            .length("252.053")
            .guid("810WRLT4076")
            .contentType("video/mp4")
            .olympicProductionType("National")
            .olympicSponsor("BMW - Golden Moments")
            .olympicVideoSubType("Highlight")
            .sPlayList("5 Unbelievable Olympic Moments from Rio")
            .chromedSponsor("teamusa")
            .localStation("knbc")
            .sport("BKM400100")
            .athlete("1000001")
            .metadata("extra", "optional-data")
            .heartbeatTrackingServer("nbcume.hb.omtrdc.net")
            .heartbeatPublisher("nbc")
            .heartbeatOvp("ovp?")
            .heartbeatSdk("1.4.14.1415?");

        return VideoPlayerFragment.create(config.toDictionary());
    }
}
