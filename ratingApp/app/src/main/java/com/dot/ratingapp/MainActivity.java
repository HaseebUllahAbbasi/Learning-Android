package com.dot.ratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dot.ratingapp.model.Person;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity
{
    Person[] persons = new Person[]{
            new Person("Name :1 ",4.5,"This is Detail",R.drawable.elon),
            new Person("Name :2 ",3.5,"This is Detail",R.drawable.imag3),
            new Person("Name :3 ",2.5,"This is Detail",R.drawable.zuker),
            new Person("Name :4 ",1.5,"This is Detail",R.drawable.image1),
            new Person("Name :5 ",9.5,"This is Detail",R.drawable.image4),
            new Person("Name :6 ",4.5,"This is Detail",R.drawable.image0)
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void picClick(View view)
    {
        JSONObject jsonObject = new JSONObject() ;
        ImageView img = (ImageView)view;
        Integer index = Integer.parseInt( (String) img.getTag());
        Intent intent = new Intent(this,Activity_Detail.class);
        try {
            jsonObject.put("name",persons[index].getName());
            jsonObject.put("rating",persons[index].getRatings());
            jsonObject.put("details",persons[index].getRatings());
            jsonObject.put("img",persons[index].getImg());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}