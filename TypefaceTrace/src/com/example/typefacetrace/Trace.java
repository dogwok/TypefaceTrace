package com.example.typefacetrace;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Trace extends Activity {

	LinearLayout traceLayout;
	EditText traceEditText, traceEditTextSize; 
	TextView traceTextView;
	SeekBar zoomBar; 
	String typefacePath, typeface; 
    Typeface selectedTypeface; 
	int textSize_increment = 10;  
	int count = 20; 
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trace_layout);
		initTraceTextInput();
		initTextSizeInput(); 
		loadTypeface();
		showTypefaceType(typeface); 
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void initTraceTextInput(){
		traceEditText = (EditText)findViewById(R.id.etTraceText);
		traceTextView = (TextView)findViewById(R.id.tvTraceText); 
		
		traceEditText.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				String content = traceEditText.getText().toString(); 
				traceTextView.setText(content);
			}
			
		});
	}
	
	public void initTextSizeInput(){
		traceEditTextSize = (EditText)findViewById(R.id.etTraceSize);
		zoomBar = (SeekBar)findViewById(R.id.sbZoomBar); 
	}
	
	public void loadTypeface(){
		Bundle b = getIntent().getExtras(); 
		typeface = b.getString("Typeface"); 
		typefacePath = "fonts/"+typeface+".ttf"; 
		selectedTypeface = Typeface.createFromAsset(getAssets(), typefacePath); 
	}
	
	public void showTypefaceType(String typeface){
		TextView typefaceTypeTV = (TextView)findViewById(R.id.tvTrace);
		typefaceTypeTV.setText(typeface);
		typefaceTypeTV.setTextSize(40); 
		selectedTypeface = Typeface.createFromAsset(getAssets(), typefacePath);
		typefaceTypeTV.setTypeface(selectedTypeface);
	}
	
	
}
