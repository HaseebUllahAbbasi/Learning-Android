package com.example.arslan_3_dec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Persons> arrayPerson = new ArrayList();
//

        MyAdapter adapter = new MyAdapter(this,arrayPerson);
        ListView listView = findViewById(R.id.myList);
        adapter.add(new Persons("sam","2734984","ok@.com",R.drawable.bush));
        adapter.add(new Persons("sam","2734984","ok@.com",R.drawable.carson));
        adapter.add(new Persons("sam","2734984","ok@.com",R.drawable.clinton));
        listView.setAdapter(adapter);

//        arrayPerson.add();
//        arrayPerson.add(new Persons("sam","2734984","ok@.com"));
//        arrayPerson.add(new Persons("sam","2734984","ok@.com"));
//        arrayPerson.add(new Persons("sam","2734984","ok@.com"));
    }

}