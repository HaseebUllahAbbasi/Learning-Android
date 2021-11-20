package com.dot.lab_4_3_v2_mad_lib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int ansCount = 0;
    ArrayList<String> words;
    ArrayList<String> specialWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            readWords();
            TextView viewById = findViewById(R.id.textData);
            viewById.setText("left with "+ (specialWords.size()-ansCount));

            TextView textView =  findViewById(R.id.wordToAns);
            textView.setText(specialWords.get(ansCount));

//            viewById.setText(Arrays.toString(new ArrayList[]{specialWords}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readWords() throws IOException {
        InputStream inputStream = getAssets().open("madlib0.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String word = null;
        words = new ArrayList<>();
        specialWords = new ArrayList<>();
        while ((word = bufferedReader.readLine()) != null)
        {
            String word_clear = word.trim();
            if(word.contains("<") && word.contains(">"))
            {
                specialWords.add(word);
            }
            words.add(word_clear);
        }
        answers = new ArrayList<>();
    }
    ArrayList<String> answers ;

    public void changeWord(View view)
    {
        EditText editText = findViewById(R.id.addWordField);
        answers.add(editText.getText().toString());
        ansCount++;
        TextView viewById = findViewById(R.id.textData);
        viewById.setText("left with "+ (specialWords.size()-ansCount));
        if((ansCount-specialWords.size()) >= 0 )
        {
            Toast.makeText(this,"Answers Completed ",Toast.LENGTH_LONG).show();
        }
        TextView textView =  findViewById(R.id.wordToAns);
        textView.setText(specialWords.get(ansCount));

    }
}