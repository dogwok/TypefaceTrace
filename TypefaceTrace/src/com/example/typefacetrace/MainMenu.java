package com.example.typefacetrace;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends ActionBarActivity {

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
