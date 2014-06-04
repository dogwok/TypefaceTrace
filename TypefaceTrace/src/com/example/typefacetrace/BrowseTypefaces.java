package com.example.typefacetrace;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

@SuppressLint("NewApi") public class BrowseTypefaces extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_typefaces);
	

		final ListView listview = (ListView) findViewById(R.id.listview);
	    String[] values = new String[] { "Bodoni", "Clarendon", "Akzedenz Grotesk",
	    		"Avenir", "Din", "Futura", "News Gothic", "Frutiger"};
	    
	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
    
	    final TypefaceListArrayAdapter adapter = new TypefaceListArrayAdapter(this, values); 
	        listview.setAdapter(adapter);
	        
	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	            @Override
	            public void onItemClick(AdapterView<?> parent, final View view,
	                int position, long id) {
	              final String item = (String) parent.getItemAtPosition(position);
	              Log.v("Adapter", "Item Selected"+item); 
	              Intent trace_intent = new Intent(getBaseContext(), Trace.class);
                  Bundle traceInfo = new Bundle(); 
                  traceInfo.putString("Typeface", item);
                  trace_intent.putExtras(traceInfo);
                  startActivity(trace_intent); 
	            }

	          });    
	        
	}
	
	
}
