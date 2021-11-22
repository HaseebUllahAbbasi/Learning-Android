package com.dot.mid_lab_exam_prc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class dice extends AppCompatActivity
{
    Integer[] array1 = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

    }
    Random random = new Random();
    int max = 6;
    int min = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
        Toast.makeText(this,"Item: "+item.getTitle(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    public void generate(View view)
    {
        Integer index_1 = random.nextInt(max - min)+min;
        Toast.makeText(this,index_1.toString(),Toast.LENGTH_LONG).show();
        Integer index_2 = random.nextInt(max - min)+min;
        ImageView n1 = findViewById(R.id.n1);
        ImageView n2 = findViewById(R.id.n2);
        n1.setImageResource(array1[index_1-1]);
        n2.setImageResource(array1[index_2-1]);
        if(index_1 == index_2)
        {
            view.setEnabled(false);
            Toast.makeText(this,"Matched", Toast.LENGTH_LONG).show();
        }

    }
}