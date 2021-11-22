package com.dot.dot_db_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dot.dot_db_android.data.DataBaseHelper;
import com.dot.dot_db_android.util.Util;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        practice();

    }
    public void practice() {
        SQLiteDatabase database = openOrCreateDatabase("dot_db", MODE_PRIVATE, null);
        database.execSQL("create table IF NOT EXISTS Login  (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name	TEXT, password	TEXT)");
        database.execSQL("insert into Login values('check','Passopen')");
        database.execSQL("insert into Login values('check','Passopen')");

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", 1);
        contentValues.put("name", "name_1");
        contentValues.put("password", "password_1");
        database.insert("LOGIN", null, contentValues);


        Cursor cursor = database.rawQuery("select * from Login", null);
        while (cursor.moveToNext()) {
            String userName = cursor.getString(1);
            Toast.makeText(this, "UserName : " + userName, Toast.LENGTH_LONG).show();

        }
    }

    public void selectButton(View view)
    {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }

    public void searchScreen(View view) {

        Intent intent = new Intent(this, searchActivity.class);
        startActivity(intent);
    }

    public void deleteScreen(View view) {

        Intent intent = new Intent(this, deleteActivity.class);
        startActivity(intent);
    }

    public void updateScreen(View view) {
        Intent intent = new Intent(this, updateActivity.class);
        startActivity(intent);
    }

    public void countAll(View view)
    {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
        Integer count = dataBaseHelper.getCount();
        TextView textView =  findViewById(R.id.textCountRecords);
        textView.setText("There Are "+ count+ " Records");
    }

    public void insertScreen(View view) {

        Intent intent = new Intent(this, InsertionScreen.class);
        startActivity(intent);
    }

    public void recyclerViewExample(View view) {
        Intent intent = new Intent(this, RecyclerExample.class);
        startActivity(intent);

    }
}