package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText text;
    ListView list;
    String filename="todolist.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editTextTextPersonName);
        list = findViewById(R.id.listview);
       AddToList();
    }
    public void AddItem(View view)
    {
        String item = text.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename,MODE_APPEND);
            outputStream.write(item.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.close();
            System.out.println("DONE!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        AddToList();
    }
    public void AddToList()
    {
        File directory = getFilesDir();
        File file = new File(directory,filename);
        System.out.println(file.toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);;
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext())
            {
                adapter.add(scanner.next());
            }
            list.setAdapter(adapter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}