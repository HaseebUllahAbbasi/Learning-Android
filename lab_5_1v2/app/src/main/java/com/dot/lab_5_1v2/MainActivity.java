package com.dot.lab_5_1v2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    View viewById;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = findViewById(R.id.newbutton);
        registerForContextMenu(viewById);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
    }


    public void optionClicked(MenuItem item)
    {
        Log.d(TAG, "optionClicked: Method Specific Called");

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        if(item.getTitle() == "option_1")
        {

        }
        Log.d(TAG, "onOptionsItemSelected: "+ item.getItemId() + " "+ item.getTooltipText());
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        Toast.makeText(this,"Item "+item.getTitle()+" selected ",Toast.LENGTH_LONG).show();

        Log.d(TAG, "onContextItemSelected: "+item.getItemId() + " "+ item.getTooltipText());
        return true;
    }
}