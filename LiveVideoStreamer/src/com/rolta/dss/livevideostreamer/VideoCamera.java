package com.rolta.dss.livevideostreamer;

import java.io.File;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Swapnil.Kadam this is to start the camera and start the process
 *         step 1: start the camera 
 *         step 2: start recording 
 *         step 3: save it on the data storage in bg thread 
 *         step 4: automatically start the camera in recording mode 
 *         step 5: do the step 3 
 *         step 6: after the first recording is complete align it for 
 *         data transfer on communication layer
 */
public class VideoCamera extends Activity implements Callback, OnClickListener {
	
	private static String TAG = VideoCamera.class.getSimpleName();
	private MediaRecorder mRecorder;
	private SurfaceHolder mHolder;
	private PowerManager.WakeLock mWakeLock;
	
	//for names of the video files
	private int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		mRecorder = new MediaRecorder();
		initRecorder();
		setContentView(R.layout.videocamera);
		
		SurfaceView cameraView = (SurfaceView) findViewById(R.id.camera_surface);
	    mHolder = cameraView.getHolder();
	    mHolder.addCallback(this);

	    cameraView.setClickable(true);
	    cameraView.setOnClickListener(this);


	}

	private void initRecorder() {
	    mRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
		mRecorder.setMaxDuration(SettingsPage.SP_MAX_DURATION);
		mRecorder.setVideoSize(SettingsPage.SP_VIDEO_WIDTH, SettingsPage.SP_VIDEO_HEIGHT); 
		mRecorder.setVideoFrameRate(SettingsPage.SP_FRAME_RATE);
		
	    File mediaStorageDir = new File(this.getFilesDir(), SettingsPage.SP_MEDIA_STORAGE_DIRECTORY);;
	    if ( !mediaStorageDir.exists() ) {
	        if ( !mediaStorageDir.mkdirs() ){
	            Log.e(TAG,"failed to create directory");
	        	}
	    	}
	    String filePath = getFilesDir() + String.valueOf(count) + ".mp4";
	    Constants.videoSequence.add(filePath);
	    mRecorder.setOutputFile(filePath);
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
