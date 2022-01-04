package com.dot.lab_7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DbHelper dBhelper;
    List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<User>();
        dBhelper = new DbHelper(this);

        Cursor c = dBhelper.getUsers();
        if (c.moveToFirst()){
            do{
                User user = new User(c.getString(0),c.getString(1),c.getString(2));
                // do what ever you want here
                list.add(user);
            }while(c.moveToNext());
        }
        c.close();
        ListView listView = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this,R.layout.row_layout,list);
        listView.setAdapter(adapter);

    }

}