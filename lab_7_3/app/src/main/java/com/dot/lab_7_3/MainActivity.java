package com.dot.lab_7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] sounds;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sounds = new int[]{R.raw.number_one, R.raw.number_two,
                R.raw.number_one, R.raw.number_two,
                R.raw.number_one, R.raw.number_two,
                R.raw.number_one, R.raw.number_two,
                R.raw.number_one,R.raw.number_two};


        ArrayList<Number> list = new ArrayList<>();
        list.add(new Number("1", "One", R.drawable.number_one));
        list.add(new Number("2", "Two", R.drawable.number_two));
        list.add(new Number("3", "Three", R.drawable.number_three));
        list.add(new Number("4", "Four", R.drawable.number_four));
        list.add(new Number("5", "Five", R.drawable.number_five));
        list.add(new Number("6", "Six", R.drawable.number_six));
        list.add(new Number("7", "Seven", R.drawable.number_seven));
        list.add(new Number("8", "Eight", R.drawable.number_eight));
        list.add(new Number("9", "Nine", R.drawable.number_nine));
        list.add(new Number("10", "Ten", R.drawable.number_ten));

        MyAdapter adapter = new MyAdapter(this, R.layout.custom_num_layout, list);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[position]);
                mediaPlayer.start();
            }
        });
    }

}