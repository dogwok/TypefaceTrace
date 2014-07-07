package com.example.typefacetrace;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity {

	Button traceButton, browseButton, brushButton, caligraphyButton; 
	TextView welcomeStatement; 
	Typeface font; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        traceButton = (Button)findViewById(R.id.bTrace);
        browseButton = (Button)findViewById(R.id.bBrowse);
        brushButton = (Button)findViewById(R.id.bBrush); 
        caligraphyButton = (Button)findViewById(R.id.bCaligraphy); 
        welcomeStatement = (TextView)findViewById(R.id.tvWelcome); 
        font = Typeface.createFromAsset(getAssets(), "fonts/Raleway.ttf");
        welcomeStatement.setTypeface(font);
    }

    public void onClick(View view){
    	switch(view.getId()){
    	case R.id.bBrowse : 
    		Intent intent = new Intent(getBaseContext(), BrowseTypefaces.class); 
    		startActivity(intent); 
    	}
    }


}
