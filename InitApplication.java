package com.example.im;

import com.easemob.chat.EMChat;

import android.app.Application;

public class InitApplication extends Application{
	
	@Override
	public void onCreate() {
		EMChat.getInstance().init(this);
//		EMChat.getInstance().setDebugMode(true);
		super.onCreate();
	}
}
