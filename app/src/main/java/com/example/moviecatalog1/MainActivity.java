package com.example.moviecatalog1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {

    private String[] datajudul;
    private String[] dataDesc;
    private String[] datarelease;
    private TypedArray dataPhoto;
    private movie_adapter adapter;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.list);
        adapter = new movie_adapter(this);
        lv.setAdapter(adapter);
        prep();
        add();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Items mitems = new Items();

                        mitems.setImage(dataPhoto.getResourceId(position, -1));
                        mitems.setTitle(datajudul[position]);
                        mitems.setInfo(dataDesc[position]);
                        mitems.setDesc(datarelease[position]);
                        Intent intent = new Intent(MainActivity.this,detail.class);
                        intent.putExtra(detail.EXTRA_MOVIES,mitems);
                        startActivity(intent);
                    }
        });

    }
    public void prep (){
        datajudul = getResources().getStringArray(R.array.title);
        dataDesc = getResources().getStringArray(R.array.realese);
        datarelease = getResources().getStringArray(R.array.info);
        dataPhoto = getResources().obtainTypedArray(R.array.image);

    }
    private void add() {
        ArrayList<Items> items = new ArrayList<>();

        for (int i = 0; i < datajudul.length; i++) {
            Items movie = new Items();
            movie.setImage(dataPhoto.getResourceId(i, -1));
            movie.setTitle(datajudul[i]);
            movie.setInfo(dataDesc[i]);
            movie.setDesc(datarelease[i]);
            items.add(movie);
        }
        adapter.setmList(items);
    }
}
