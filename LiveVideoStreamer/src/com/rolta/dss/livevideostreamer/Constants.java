package com.rolta.dss.livevideostreamer;

import java.util.ArrayList;

import android.util.Log;

public class Constants {
	//to maintain the sequence for fetching the data latter.
	//in constants so scope will be global
	public static ArrayList<String> videoSequence = new ArrayList<String>();

	
	public void showLog(String TAG, String message){
		Log.e(TAG, message);
	}
}
