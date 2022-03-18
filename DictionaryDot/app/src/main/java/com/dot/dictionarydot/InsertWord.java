package com.dot.dictionarydot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertWord extends AppCompatActivity {

    EditText word,desc;
    ContentValues values = new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);
    }

    public void saveWord(View view)
    {
        word = findViewById(R.id.word_text);
        desc = findViewById(R.id.word_desc);
        values.put("word",word.getText().toString());
        values.put("wordDesc",desc.getText().toString());
        Uri uri =  getContentResolver().insert(MyContentProvider.CONTENT_URI,values);

    }

}