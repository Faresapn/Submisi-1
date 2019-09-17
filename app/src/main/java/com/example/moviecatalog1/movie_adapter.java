package com.example.moviecatalog1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class movie_adapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Items> mList;




    public movie_adapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setmList(ArrayList<Items> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }




        @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        MovieViewHolder movieViewHolder = new MovieViewHolder(convertView);
        Items movieItems =(Items) getItem(i);
        movieViewHolder.bind(movieItems);
        return convertView;
    }


    public class MovieViewHolder{
        TextView mtittle;
        TextView mreleas;

        ImageView mphoto;

        MovieViewHolder(View view){
            mtittle = view.findViewById(R.id.tittle);
            mreleas = view.findViewById(R.id.releas);
            mphoto = view.findViewById(R.id.img_film);


        }

        void bind(Items movieItems){
            mtittle.setText(movieItems.getTitle());
            mreleas.setText(movieItems.getInfo());
            mphoto.setImageResource(movieItems.getImage());
        }
    }
}
