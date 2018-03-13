package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by genetrinks on 3/11/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private String primaryLocation;
    private String offsetLocation;


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

        // set the text in the textview with the magnitude formattted as a string
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(formatMagnitude(currentEarthquake));

        // get the location in 2 parts
        parseTheLocation(currentEarthquake.getLocation());

        // set the text in the textview with the offset location
        TextView offsetLocationTextView = (TextView) listItemView.findViewById(R.id.offset_location);
        offsetLocationTextView.setText(this.offsetLocation);

        // set the text in the textview with the primary location
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(this.primaryLocation);

        // set the text in the textview with the date
        TextView itemFormattedDate = (TextView) listItemView.findViewById(R.id.date);
        itemFormattedDate.setText(currentEarthquake.getFormattedDate());

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }

    private void parseTheLocation(String location){

        //split the location string into 2 parts
        // if the location is of the format "20km SE of xxx"
        // then the offset substring will end at "of"
        // and the primary substring will be the rest of the string
        if (location.contains("of")){
            int index = location.indexOf("of ");
            offsetLocation = location.substring(0, index+2);
            primaryLocation = location.substring(index+3, location.length());
        }

        // otherwise if the format does not contain an offset
        // just set the offset to "Near the"
        else {
            offsetLocation =  "Near the";
            primaryLocation = location;
        }
    }

    private String formatMagnitude(Earthquake currentEarthquake){

        // pass in an earthquake, get the magnitude, and format it
        // to 1 decimal place and store it as a string, then return that string
        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMag = formatter.format(currentEarthquake.getMagnitude());
        return formattedMag;
    }

    private int getMagnitudeColor(double magnitude){
        int tempColor;

        switch ((int)Math.floor(magnitude)) {
            case 0:
            case 1:
               tempColor = R.color.magnitude1;
               break;
            case 2:
                tempColor = R.color.magnitude2;
                break;
            case 3:
                tempColor = R.color.magnitude3;
                break;
            case 4:
                tempColor = R.color.magnitude4;
                break;
            case 5:
                tempColor = R.color.magnitude5;
                break;
            case 6:
                tempColor = R.color.magnitude6;
                break;
            case 7:
                tempColor = R.color.magnitude7;
                break;
            case 8:
                tempColor = R.color.magnitude8;
                break;
            case 9:
                tempColor = R.color.magnitude9;
                break;
            default:
                tempColor = R.color.magnitude10plus;
                break;
        }

        return (ContextCompat.getColor(getContext(),tempColor));
    }

}
