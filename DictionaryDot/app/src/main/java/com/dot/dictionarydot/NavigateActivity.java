package com.dot.dictionarydot;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

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

public class NavigateActivity extends AppCompatActivity {

    EditText word, desc;
    ContentValues values = new ContentValues();
    LinearLayout layout;

    private AppBarConfiguration mAppBarConfiguration;
    CustomDialog dialog = new CustomDialog();

    ArrayAdapter arrayAdapter;
    ArrayList<String> words;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        word = findViewById(R.id.word_text);
        desc = findViewById(R.id.word_desc);
         words = new ArrayList<>();
         arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);
                fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                openDialog();
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


    private void openDialog() {
        dialog.show(getSupportFragmentManager(), "Enter Word");
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

    public void saveWord(View view)
    {
        values.put("word",word.getText().toString());
        values.put("wordDesc",desc.getText().toString());
        Uri uri =  getContentResolver().insert(MyContentProvider.CONTENT_URI,values);

        dialog.dismiss();
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
            words.add(s1);
        }

        Snackbar.make(layout,builder.toString(),Snackbar.LENGTH_LONG).show();
    }

}