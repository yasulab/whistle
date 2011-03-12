package org.sorarier.whistle;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Whistle extends Activity implements OnClickListener{
    private MediaPlayer mp;
    private int resId = R.raw.whistle;
    private boolean whistling = false;
    private View whistleBtn;
    //private View stopBtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Set up click listeners for all the buttons.
        whistleBtn = findViewById(R.id.whistle_button);
        whistleBtn.setOnClickListener(this);        
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
    
    public void onClick(View v){
	    // Release any resources from previous MediaPlayer
	    if(mp != null){
		    mp.release();
	    }
	    switch (v.getId()){
	    case R.id.whistle_button:
		    if(whistling == false){
			    v.setBackgroundResource(R.drawable.btn_off);
			    //v.setVisibility(View.INVISIBLE);			    
			    //stopBtn.setVisibility(View.VISIBLE);
			 // Create a new MediaPlayer to play this sound
			    mp = MediaPlayer.create(this, resId);
			    mp.setLooping(true);
			    mp.start();
			    whistling = true;
			    return;
		    }else{
			    v.setBackgroundResource(R.drawable.btn_on);
			    whistling = false;
			    return;
		    }
	    default:
		return;
	    }
    }
}