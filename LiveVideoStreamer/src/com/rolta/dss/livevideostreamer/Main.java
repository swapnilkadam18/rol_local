package com.rolta.dss.livevideostreamer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {

	private Button videoStream;
	private Button videoView;

	public static final int ACTIVITY_VIDEO_CAMERA = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initializeViews();

		videoStream.setOnClickListener(this);
		videoView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (v == videoStream) {
			// stream the video
			startStreaming();
		} else {
			// view the video
			startViewing();
		}
	}

	/**
	 * @author Swapnil.Kadam this will be used to view the incoming packets
	 *         which were transmitted
	 */
	private void startViewing() {
		Toast.makeText(this, "still under development", Toast.LENGTH_SHORT)
				.show();
	}

	private void startStreaming() {

		Intent intent = new Intent(this, VideoCamera.class);
		startActivityForResult(intent, ACTIVITY_VIDEO_CAMERA);
		
	}

	private void initializeViews() {
		videoStream = (Button) findViewById(R.id.videoStream);
		videoView = (Button) findViewById(R.id.videoView);
	}

}
