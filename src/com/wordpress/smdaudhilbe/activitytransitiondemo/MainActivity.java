package com.wordpress.smdaudhilbe.activitytransitiondemo;

import java.util.List;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setExitSharedElementCallback(new SharedElementCallback() {
			@Override
			public void onSharedElementEnd(List<String> sharedElementNames,List<View> sharedElements, List<View> sharedElementSnapshots) {
				findViewById(R.id.imageView1).setTranslationZ(0);
			}
		});
	}

	@fromXML
	public void secondActivityClicked(View view) {
		ActivityOptions aOptions = ActivityOptions.makeSceneTransitionAnimation(this,findViewById(R.id.imageView1),getString(R.string.transName));		
		startActivity(new Intent(this, SecondActivity.class),aOptions.toBundle());
		findViewById(R.id.imageView1).setTranslationZ(20);
	}
}