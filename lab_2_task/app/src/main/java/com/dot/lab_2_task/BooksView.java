package com.dot.lab_2_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BooksView extends AppCompatActivity
{

    private static final String TAG = "Tag";
    ArrayList<Book> books = new ArrayList<>();
    CustomAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_view);
        books.add(new Book(R.drawable.book_1,"title _1 ","Simple 2","ISBN _ 1 ","false",null,"10"));
        books.add(new Book(R.drawable.book_2,"title _2 ","Simple 3","ISBN _ 2 ","true","Sample_ person ","22"));
        books.add(new Book(R.drawable.book_4,"title _3 ","Simple 4","ISBN _ 3 ","false",null,"32"));
        books.add(new Book(R.drawable.book_5,"title _4 ","Simple 5","ISBN _ 4 ","true","Sample_ person ","9"));
        books.add(new Book(R.drawable.book_2,"title _5 ","Simple 6","ISBN _ 5 ","false",null,"14"));
        books.add(new Book(R.drawable.book_5,"title _6 ","Simple 7","ISBN _ 6  ","true","Sample_ person ","44"));

        listView = findViewById(R.id.listView);

        adapter = new CustomAdapter(this,R.layout.custom_view,books);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("clicked");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Book itemAtPosition =  (Book) listView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(),OneBook.class);
                intent.putExtra("img",itemAtPosition.getImg());
                intent.putExtra("author",itemAtPosition.getAuthor());
                intent.putExtra("title",itemAtPosition.getTitle());
                intent.putExtra("issue",itemAtPosition.getIssued());
                intent.putExtra("issuedTo",itemAtPosition.getIssuedTo());
                intent.putExtra("avail",itemAtPosition.getNo_of_books_available());

                Log.d(TAG, "onItemClick: "+itemAtPosition);
                startActivity(intent);



            }
        });

    }
}