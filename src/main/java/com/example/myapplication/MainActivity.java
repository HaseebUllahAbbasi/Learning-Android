package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    }

    public void write(View view)
    {
        LinearLayout linearLayout =  findViewById(R.id.toDoTask);
        linearLayout.removeAllViews();
        File directory = this.getFilesDir();
        File file = new File(directory, "filename");
        String data = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String aLine = scanner.nextLine();
                data+=aLine+ "\n";
            }
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String filename = "filename";
        String fileContents = data;
        EditText editText =  findViewById(R.id.task_text);
        fileContents+= editText.getText().toString()+ "\n";

        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Log.d("MSG", "write: "+fileContents);
        String[] fileContent = fileContents.split("\n");
        Integer size = fileContent.length;
        Toast.makeText(this,size.toString(),Toast.LENGTH_LONG).show();

        int i =1;
         linearLayout =  findViewById(R.id.toDoTask);
        for (String oneLine: fileContent)
        {
            TextView textView = new TextView(this);
            textView.setText("Task " + i + " : \t" +oneLine);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(textView);
            i++;
        }
    }


    public void onClick(View view) {



        //Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    public void deleteTasks(View view) {
        File directory = this.getFilesDir();
        File file = new File(directory, "filename");
        boolean delete = file.delete();
        if(delete)
        {
            Toast.makeText(this,"deleted",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this," not deleted",Toast.LENGTH_LONG).show();

        }
        LinearLayout linearLayout =  findViewById(R.id.toDoTask);
        linearLayout.removeAllViews();


    }
}