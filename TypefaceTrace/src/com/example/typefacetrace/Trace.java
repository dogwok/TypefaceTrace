package com.example.typefacetrace;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Trace extends Activity {

	LinearLayout traceLayout;
	EditText traceLetters; 
	int textSize_increment = 10;  
	int count = 20; 
	
    Typeface selectedTypeface; 
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trace_layout);
		
		traceLayout = (LinearLayout)findViewById(R.id.traceLayout);
		traceLetters = (EditText)findViewById(R.id.etTrace); 
		Button increaseButton = (Button)findViewById(R.id.increaseTextSize);
		Button decreaseButton = (Button)findViewById(R.id.decreaseTextSize); 
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
		typefaceTypeTV.setTextSize(25); 
		String typefacePath = "fonts/"+typeface+".ttf"; 
		selectedTypeface = Typeface.createFromAsset(getAssets(), typefacePath);
		typefaceTypeTV.setTypeface(selectedTypeface);
	}
	
	public void increaseTextSize(View inc){
		if(count < 40){
			count++; 
			traceLetters.setTextSize((textSize_increment*count));
		} else {
			count = 40; 
		}
	}
	
	public void decreaseTextSize(View dec){
		
		if( count > 20){
			count--; 
			traceLetters.setTextSize((textSize_increment*count));
		} else {
			count = 20; 
		}
	}
}
