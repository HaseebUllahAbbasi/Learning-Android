package com.dot.lab_6_1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText etxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.text1);
        etxt = findViewById(R.id.editTextTextPersonName3);
    }

    public void write(View view) {
        String filename = "filename";
        String fileContents = etxt.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onClick(View view) {
        File directory = this.getFilesDir();
        File file = new File(directory, "filename");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String aLine = scanner.nextLine();
                txt.setText(aLine);
            }
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        //Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
