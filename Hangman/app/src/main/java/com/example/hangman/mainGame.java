package com.example.hangman;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class mainGame extends AppCompatActivity {
    ArrayList<String> words;
    String GuessWord = "";
    StringBuilder under_score_string = new StringBuilder("");


    boolean won = false;
    private static final String TAG = "MESSAGE ";
    int guessleft = 0;
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        TextView guess = findViewById(R.id.guess);
        try {
            readWords();
            int max = words.size();
            int min = 1;
            Random random = new Random();
            int index = random.nextInt(max - min) + min;

            int counter = 0;
            for (String w : words) {
                if (counter == index) {
                    GuessWord = w;
                }
                counter++;
            }
            for (char character : GuessWord.toCharArray()) {

                under_score_string.append("_");
            }
            guess.setText(under_score_string);
            Log.d(TAG, "Guess Word: " + GuessWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(View view) {
        TextView left = findViewById(R.id.left);
        Button btn = (Button) view;
        ImageView img = findViewById(R.id.imageView);
        TextView lab = findViewById(R.id.label);


        if (guessleft < 6 && won==false)
        {
            if (GuessWord.contains(btn.getText()))
            {
                btn.setBackgroundColor(Color.alpha(300));
                TextView guess = findViewById(R.id.guess);
                int counterIndex = 0;
                for (char character : GuessWord.toCharArray()) {
                    if (btn.getText().charAt(0) == character) {
                        under_score_string.setCharAt(counterIndex, character);

                    }
                    counterIndex++;
                }
                guess.setText(under_score_string);
                Log.d(TAG, "under_score_string: "+under_score_string + " GuessWord : "+ GuessWord );
                if (under_score_string.toString().trim().equals(GuessWord.trim()))
                {
                    lab.setText("Yeah You son of ***** ,you Won!");
                    won = true;
                }
            } else {
                guessleft++;
                btn.setVisibility(View.INVISIBLE);
                img.setImageResource(images[guessleft]);
            }
            left.setText("Guess Left: "+(7-guessleft));
        }
        else {

            if(!won)
            {
                left.setText("Guess Left: "+(0));
                lab.setText("Ahh! Loss");

            }
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