package br.unitau.cortesemfila;

import br.unitau.cortesemfila.MainActivity;
import br.unitau.cortesemfila.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.widget.VideoView;

public class Splash extends Activity implements OnCompletionListener {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        
        VideoView video = (VideoView) findViewById(R.id.videoView1);
        video.setVideoPath("android.resource://br.unitau.cortesemfila/raw/" + R.raw.splash);
        video.start();
        video.setOnCompletionListener(this);
    }

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
		
	}
}