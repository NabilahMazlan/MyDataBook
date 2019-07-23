package com.example.mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {

    TextView tvNames, tvModules;
    ActionBar ab;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvNames = findViewById(R.id.tvNames);
        tvModules = findViewById(R.id.tvModule);
        img = findViewById(R.id.imageView);

        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(img, new Callback() {
            @Override
            public void onSuccess() {
                Toast.makeText(AboutUsActivity.this, "Yeayyy", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(AboutUsActivity.this, "Booooo", Toast.LENGTH_SHORT).show();

            }
        });
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        tvNames.setText("Created By - Ah Chong, Peter, Mary");
        tvModules.setText("C347 - Android Programming II Republic Polytechnic");
    }
}
