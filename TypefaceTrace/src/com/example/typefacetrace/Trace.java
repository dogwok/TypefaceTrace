package com.example.typefacetrace;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Trace extends Activity {

	LinearLayout traceLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trace_layout);
		
		traceLayout = (LinearLayout)findViewById(R.id.traceLayout);
		
		Bundle b = getIntent().getExtras(); 
		String typeface = b.getString("Typeface"); 
		
		showTypefaceType(typeface); 
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void showTypefaceType(String typeface){
		TextView typefaceTypeTV = (TextView)findViewById(R.id.tvTrace);
		typefaceTypeTV.setText(typeface);
	}
}
