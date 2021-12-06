package com.example.numberslab7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] sounds;
    MediaPlayer md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sounds = new int[]{R.raw.number_one,R.raw.number_two,R.raw.number_three,R.raw.number_four,R.raw.number_five,
        R.raw.number_six,R.raw.number_seven,R.raw.number_eight,R.raw.number_nine,R.raw.number_ten};


        ArrayList<Numbers> list = new ArrayList<>();
        list.add(new Numbers("1","One",R.drawable.number_one));
        list.add(new Numbers("2","Two",R.drawable.number_two));
        list.add(new Numbers("3","Three",R.drawable.number_three));
        list.add(new Numbers("4","Four",R.drawable.number_four));
        list.add(new Numbers("5","Five",R.drawable.number_five));
        list.add(new Numbers("6","Six",R.drawable.number_six));
        list.add(new Numbers("7","Seven",R.drawable.number_seven));
        list.add(new Numbers("8","Eight",R.drawable.number_eight));
        list.add(new Numbers("9","Nine",R.drawable.number_nine));
        list.add(new Numbers("10","Ten",R.drawable.number_ten));

        MyAdapter adapter = new MyAdapter(this,R.layout.custom_list_layout,list);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                md = MediaPlayer.create(getApplicationContext(),sounds[position]);
                md.start();
            }
        });
    }

}