package com.example.mydatabook;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DrawableItems> {

    private ArrayList<DrawableItems> items;
    private Context context;
    private TextView tv;
    private ImageView img;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DrawableItems> objects) {
        super(context, resource, objects);

        items = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_drawable, parent, false);
        tv = convertView.findViewById(R.id.textViewCustomList);
        img = convertView.findViewById(R.id.imageViewCustomList);

        DrawableItems currentItems = items.get(position);

        tv.setText(currentItems.getTitle());
        if(tv.getText().equals("Bio")){
            img.setImageResource(android.R.drawable.ic_dialog_info);
        }else if(tv.getText().equals("Vaccination")){
            img.setImageResource(android.R.drawable.ic_menu_edit);
        }else if(tv.getText().equals("Anniversary")){
            img.setImageResource(android.R.drawable.ic_menu_my_calendar);
        }else if(tv.getText().equals("About Us")){
            img.setImageResource(android.R.drawable.btn_star_big_on);
        }

        img.setColorFilter(ContextCompat.getColor(context, R.color.babyBlue), PorterDuff.Mode.MULTIPLY);

        return convertView;


    }
}
