package com.example.typefacetrace;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Trace extends Activity {

	LinearLayout traceLayout;
	EditText traceEditText;
	TextView traceTextView;
	SeekBar zoomBar; 
	Button lockButton; 
	String typefacePath, typeface; 
    Typeface selectedTypeface; 
	int minimumTextSize = 60;   
	int count = 20; 
	boolean activityEnabled = true; 
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trace_layout);
		lockButton = (Button)findViewById(R.id.lockButton);
		lockButton.setOnClickListener(lockEverything);
		loadTypeface();
		showTypefaceType(typeface); 
		initTraceTextInput();
		initTextSizeInput(); 
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void initTraceTextInput(){
		traceEditText = (EditText)findViewById(R.id.etTraceText);	
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
		
		zoomBar = (SeekBar)findViewById(R.id.sbZoomBar);
		zoomBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				traceTextView.setTextSize(minimumTextSize + (4*(zoomBar.getProgress())));
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
	
	public void loadTypeface(){
		Bundle b = getIntent().getExtras(); 
		typeface = b.getString("Typeface"); 
		typefacePath = "fonts/"+typeface+".ttf"; 
		selectedTypeface = Typeface.createFromAsset(getAssets(), typefacePath); 
	}
	
	public void showTypefaceType(String typeface){
		TextView typefaceTypeTV = (TextView)findViewById(R.id.tvTrace);
		traceTextView = (TextView)findViewById(R.id.tvTraceText); 
		traceTextView.setTextSize(60);
		typefaceTypeTV.setText(typeface);
		typefaceTypeTV.setTextSize(40); 
		
		selectedTypeface = Typeface.createFromAsset(getAssets(), typefacePath);
		typefaceTypeTV.setTypeface(selectedTypeface);
		traceTextView.setTypeface(selectedTypeface);
	}
	
	private OnClickListener lockEverything = new OnClickListener(){
		
		public void onClick(View v){
			if(activityEnabled){
				traceEditText.setEnabled(false);
				zoomBar.setEnabled(false);
				activityEnabled = false;
			} else {
				traceEditText.setEnabled(true);
				zoomBar.setEnabled(true);
				activityEnabled = true; 
			}
		}
	};

	
	
}
