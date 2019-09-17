package com.example.moviecatalog1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detail extends AppCompatActivity {
    public static final String EXTRA_MOVIES="EXTRA_MOVIES";
    TextView title,desc,info;
    ImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Items movieItems= getIntent().getParcelableExtra(EXTRA_MOVIES);
        title = findViewById(R.id.txt_tittle);
        desc = findViewById(R.id.txt_rilis);
        info = findViewById(R.id.txt_dtl);
        photo = findViewById(R.id.img_film);

        title.setText(movieItems.getTitle());
        desc.setText(movieItems.getDesc());
        info.setText(movieItems.getInfo());
        photo.setImageResource(movieItems.getImage());
    }

}
