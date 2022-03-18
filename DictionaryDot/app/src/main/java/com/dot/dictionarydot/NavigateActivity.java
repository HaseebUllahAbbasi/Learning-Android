package com.dot.dictionarydot;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class NavigateActivity extends AppCompatActivity
{
    EditText search;
    ContentValues values = new ContentValues();
    DrawerLayout layout;

    private AppBarConfiguration mAppBarConfiguration;

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<WordData> words;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        layout =  findViewById(R.id.drawer_layout);
        listView =  findViewById(R.id.listView_1);
        search =  findViewById(R.id.searchText);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

         words = new ArrayList<>();
         arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);
         listView.setAdapter(arrayAdapter);
         search.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
             {
                 load(null);
             }

             @Override
             public void afterTextChanged(Editable editable)
             {

             }
         });
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
             {

                 WordData itemAtPosition = (WordData) listView.getItemAtPosition(i);
                 openDialog(itemAtPosition);
                 Log.d(TAG, "onItemClick: "+ itemAtPosition.getWord() );
             }
         });

         load(null);

         fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplication(),InsertWord.class);
                startActivity(intent);

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void openDialog(WordData itemAtPosition)
    {

        CustomDialog dialog = new CustomDialog();

        Bundle args = new Bundle();
        args.putString("word", itemAtPosition.getWord());
        args.putString("desc", itemAtPosition.getDescription());

        //The first parameter is the key that will be used to retrieve the value, which is the second parameter.

        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "Word Details");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigate, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    protected void onResume() {
        super.onResume();
        load(null);
        Log.d(TAG, "onResume: ");
    }


    public void load(View view)
    {


        Cursor cr = getContentResolver().query(MyContentProvider.CONTENT_URI, null, null, null, "_id");
        StringBuilder builder = new StringBuilder();
        words.clear();
        while(cr.moveToNext())
        {
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            builder.append(id+ " " + s1+ " "+ s2+ "\n");
            if(search.getText().toString().trim().equals(""))
                words.add(new WordData(id,s1,s2));
            else
                if(s1.contains(search.getText()))
                    words.add(new WordData(id,s1,s2));



        }
        arrayAdapter.notifyDataSetChanged();

        Snackbar.make(layout,builder.toString(),Snackbar.LENGTH_LONG).show();
    }

}