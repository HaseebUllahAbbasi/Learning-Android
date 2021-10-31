package com.dot.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity {

    String word_find;
    Integer corrected = 0;
    Integer roundLeft = 10;
    StringBuilder under_score_Text = new StringBuilder("");
    Integer index;
    private static final String TAG = "MSG";
    ArrayList<String> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        TextView roundLeft_TextView = findViewById(R.id.guess);
        roundLeft_TextView.setText( "Guesses Left :"+ roundLeft.toString());
        try {
            readWords();
//            TextView textView = findViewById(R.id.guess);
            int max = words.size();
            int min = 1;
            Random random = new Random();
            index = random.nextInt(max - min + 1) + min;
            int counter = 0;
            for (String w : words) {
                if (counter == index) {
                    word_find = w;
                }
                counter++;
            }
            for (char character : word_find.toCharArray()) {
                under_score_Text.append("_");
            }
            TextView word_textView = findViewById(R.id.word);
            word_textView.setText(under_score_Text);
            Log.d(TAG, "Word is  " + word_find);
//            Log.d(TAG, "onCreate: "+words.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(View view)
    {
        if(roundLeft>0 || corrected==word_find.length())
        {
            Button button = (Button) view;
            CharSequence text = button.getText();
            if (word_find.contains(text))
            {

                    Toast.makeText(this,"Well done talian honi chahiye",Toast.LENGTH_LONG);

                corrected++;
                int counter_index = 0;
                for (char character : word_find.toCharArray())
                {
                    if (character == text.charAt(0))
                        under_score_Text.setCharAt(counter_index,character);
                    counter_index++;
                }
                TextView word_textView = findViewById(R.id.word);
                word_textView.setText(under_score_Text);

                button.setBackgroundColor(getResources().getColor(R.color.teal_200));
                button.setClickable(false);

                if(corrected==word_find.length())
                {
                    Toast.makeText(this,"You have Lost",Toast.LENGTH_LONG);
                }
            }
            else

                {
                    roundLeft--;
                button.setVisibility(View.INVISIBLE);
                button.setClickable(false);
            }
            button.setClickable(false);
            TextView roundLeft_TextView = findViewById(R.id.guess);
            roundLeft_TextView.setText( "Guesses Left :"+ roundLeft.toString());
        }

        if(roundLeft==0)
        {
            Toast.makeText(this,"You have Lost",Toast.LENGTH_LONG);
        }
    }

    public void readWords() throws IOException {
        InputStream inputStream = getAssets().open("words.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String word = null;
        words = new ArrayList<>();
        while ((word = bufferedReader.readLine()) != null) {
            String word_clear = word.trim();
            words.add(word_clear);
        }

    }

}