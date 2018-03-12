package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by genetrinks on 3/11/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> quakeList) {
        super(context, 0, quakeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // get the earthquake object at the position which was passed in
        Earthquake currentEarthquake = getItem(position);

        // set the text in the textview with the magnitude cast as a string
        TextView itemMagnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        itemMagnitude.setText(currentEarthquake.getMagnitude()+"");

        // set the text in the textview with the location
        TextView itemLocation = (TextView) listItemView.findViewById(R.id.location);
        itemLocation.setText(currentEarthquake.getLocation());

        // set the text in the textview with the date
        TextView itemFormattedDate = (TextView) listItemView.findViewById(R.id.date);
        itemFormattedDate.setText(currentEarthquake.getFormattedDate());

        return listItemView;
    }
}
