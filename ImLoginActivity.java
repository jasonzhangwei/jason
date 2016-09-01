package com.example.im;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ImLoginActivity extends ActionBarActivity {
	private EditText et_username;
	private EditText et_password;
	private Button bt_login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_im_login);
		et_username= (EditText) findViewById(R.id.et_username);
		et_password=(EditText) findViewById(R.id.et_password);
		bt_login= (Button) findViewById(R.id.btn_login);
		bt_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EMChatManager.getInstance().login(et_username.getText().toString(), et_password.getText().toString(),new EMCallBack() {//回调
					@Override
					public void onSuccess() {
						runOnUiThread(new Runnable() {
							public void run() {
								EMGroupManager.getInstance().loadAllGroups();
								EMChatManager.getInstance().loadAllConversations();
								Log.d("main", "登陆聊天服务器成功！");	
								Intent intent=new Intent(getApplicationContext(), ImChatActivity.class); 
								startActivity(intent);
								
							}
						});
					}
				 
					@Override
					public void onProgress(int progress, String status) {
				 
					}
				 
					@Override
					public void onError(int code, String message) {
						Log.d("main", "登陆聊天服务器失败！");
					}
				});
				
			}
		});
	}

	
}
