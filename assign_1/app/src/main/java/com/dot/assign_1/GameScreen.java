package com.dot.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity
{

    String word_find;
    String under_score_Text = "";
    Integer index ;
    private static final String TAG = "MSG";
    ArrayList<String> words ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        try {
            readWords();
            TextView textView = findViewById(R.id.guess);
            int max = words.size();
            int min = 1;
            Random random = new Random();
            index =  random.nextInt(max-min+1)+min;
            int counter = 0;
            for(String w: words)
            {
                if(counter==index)
                {
                    word_find = w;
                }
                counter++;
            }
            for(char character : word_find.toCharArray())
            {
                under_score_Text+="_ ";
            }
            TextView word_textView = findViewById(R.id.word);
            word_textView.setText(under_score_Text);
            Log.d(TAG, "Word is  "+ word_find );
//            Log.d(TAG, "onCreate: "+words.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void keyPressed (View view)
    {
        Button button = (Button)view;
        CharSequence text = button.getText();
        if(word_find.contains(text))
        {
            Log.d(TAG, "Matched Latter "+text);
            button.setBackgroundColor(Color.alpha(100));
            button.setClickable(false);
        }

        button.setClickable(false);
    }
    public void readWords() throws IOException
    {
        InputStream inputStream = getAssets().open("words.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String word = null;
        words = new ArrayList<>();
        while ((word = bufferedReader.readLine() )!=null)
        {
            String word_clear = word.trim();
            words.add(word_clear);
        }

    }

}