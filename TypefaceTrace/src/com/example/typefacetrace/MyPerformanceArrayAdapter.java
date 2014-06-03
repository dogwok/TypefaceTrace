package com.example.typefacetrace;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {
  private final Activity context;
  private final String[] names;

  static class ViewHolder {
    public TextView text;
    public ImageView image;
  }

  public MyPerformanceArrayAdapter(Activity context, String[] names) {
    super(context, R.layout.rowlayout, names);
    this.context = context;
    this.names = names;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View rowView = convertView;
    // reuse views
    if (rowView == null) {
      LayoutInflater inflater = context.getLayoutInflater();
      rowView = inflater.inflate(R.layout.rowlayout, null);
      // configure view holder
      ViewHolder viewHolder = new ViewHolder();
      viewHolder.text = (TextView) rowView.findViewById(R.id.label);
      viewHolder.image = (ImageView) rowView
          .findViewById(R.id.icon);
      rowView.setTag(viewHolder);
    }

    // fill data
    ViewHolder holder = (ViewHolder) rowView.getTag();
    String s = names[position];
    holder.text.setText(s);
    if (s.startsWith("Windows7") || s.startsWith("iPhone")
        || s.startsWith("Solaris")) {
      holder.image.setImageResource(R.drawable.ic_launcher);
    } else {
      holder.image.setImageResource(R.drawable.abc_textfield_searchview_right_holo_light);
    }

    return rowView;
  }
}