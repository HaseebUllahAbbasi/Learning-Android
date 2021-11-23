package com.dot.lab_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Integer score_1 = 0 ;
    Integer score_2  = 0;

    int index = 0;
    boolean turn = true;
    Random random =   new Random();
    int[] imageView = {
            R.drawable.ace, R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight, R.drawable.nine,R.drawable.jack,R.drawable.queen,R.drawable.king,
            R.drawable.ace, R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight, R.drawable.nine,R.drawable.jack,R.drawable.queen,R.drawable.king,
            R.drawable.ace, R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight, R.drawable.nine,R.drawable.jack,R.drawable.queen,R.drawable.king,
            R.drawable.ace, R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight, R.drawable.nine,R.drawable.jack,R.drawable.queen,R.drawable.king
    };

    String user_1;
    String user_2;
    public void check()
    {
         if(score_1==21) {
            View view = findViewById(R.id.button);
            view.setEnabled(false);
            View view2 = findViewById(R.id.button2);
            view2.setEnabled(false);
            Toast.makeText(this, "User 1 Won", Toast.LENGTH_LONG).show();
        }
         else if(score_2==21)
         {
             View view = findViewById(R.id.button);
             view.setEnabled(false);
             View view2 = findViewById(R.id.button2);
             view2.setEnabled(false);
             Toast.makeText(this, "User 2 Won", Toast.LENGTH_LONG).show();

         }
        else if(score_1>21) {
            View view = findViewById(R.id.button);
            view.setEnabled(false);
            View view2 = findViewById(R.id.button2);
            view2.setEnabled(false);
            Toast.makeText(this, "User 2 Won", Toast.LENGTH_LONG).show();
        }
        else if(score_2>21) {
            View view = findViewById(R.id.button);
            view.setEnabled(false);
            View view2 = findViewById(R.id.button2);
            view2.setEnabled(false);
            Toast.makeText(this, "User 1 Won", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
         user_1 = intent.getStringExtra("user_1");
         user_2 = intent.getStringExtra("user_2");

        if(turn==true)
        {
            TextView view =  findViewById(R.id.turn_view);
            view.setText(user_1+" Turn");

        }
        if(turn==false)
        {
            TextView view =  findViewById(R.id.turn_view);
            view.setText(user_2+" Turn");
        }

        TextView textView_1 =  findViewById(R.id.user_1);
        TextView textView_2 =  findViewById(R.id.user_2);
        textView_1.setText(user_1+" Score : "+ score_1.toString());
        textView_2.setText(user_2+" Score : "+ score_2.toString());
    }

    public void HitMe(View view) {

        int index = random.nextInt(48) + 1;
         cal(imageView[index]);
        turn = !turn;
        if(turn==true)
        {

            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.user_2_cards);
            ImageView img = new ImageView(this);
            img.setImageResource(imageView[index++]);

            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(img,200,200);
            TextView view_1 =  findViewById(R.id.turn_view);
            view_1.setText(user_1+" Turn");
        }
        if(turn==false)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.user_1_cards);
            ImageView img = new ImageView(this);
            img.setImageResource(imageView[index++]);
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(img,200,200);

            TextView view_1 =  findViewById(R.id.turn_view);
            view_1.setText(user_2+" Turn");
        }
        check();

    }
    public void cal(int imgView)
    {
        if(turn==true)
        {
            switch (imgView)
            {
                case  R.drawable.ace:

                    score_1+= 10;
                    break;
                case  R.drawable.one:
                    score_1+= 1;
                    break;

                case  R.drawable.two:
                    score_1+= 2;
                    break;

                case  R.drawable.three:
                    score_1+= 3;
                    break;

                case  R.drawable.four:
                    score_1+= 4;
                    break;

                case  R.drawable.five:
                    score_1+= 5;
                    break;

                case  R.drawable.six:
                    score_1+= 6;
                    break;

                case  R.drawable.seven:
                    score_1+= 7;
                    break;

                case  R.drawable.eight:
                    score_1+= 8;
                    break;

                case  R.drawable.nine:
                    score_1+= 9;
                    break;

                case  R.drawable.jack:
                    score_1+= 10;
                    break;


                case  R.drawable.queen:
                    score_1+= 10;
                    break;

                case  R.drawable.king:
                    score_1+= 10;
                    break;




            }
        }
        if(turn==false)
        {
            switch (imgView)
            {
                case  R.drawable.ace:
                    score_2+= 10;
    break;
                case  R.drawable.one:
                    score_2+= 1;
                    break;

                case  R.drawable.two:
                    score_2+= 2;
                    break;

                case  R.drawable.three:
                    score_2+= 3;
                    break;

                case  R.drawable.four:
                    score_2+= 4;
                    break;

                case  R.drawable.five:
                    score_2+= 5;
                    break;

                case  R.drawable.six:
                    score_2+= 6;
                    break;

                case  R.drawable.seven:
                    score_2+= 7;
                    break;

                case  R.drawable.eight:
                    score_2+= 8;
                    break;


                case  R.drawable.nine:
                    score_2+= 9;
                    break;

                case  R.drawable.jack:
                    score_2+= 10;
                    break;


                case  R.drawable.queen:
                    score_2+= 10;
                    break;

                case  R.drawable.king:
                    score_2+= 10;
                    break;

            }
        }
        TextView textView_1 =  findViewById(R.id.user_1);
        TextView textView_2 =  findViewById(R.id.user_2);
        textView_1.setText(user_1+" Score : "+ score_1.toString());
        textView_2.setText(user_2+" Score : "+ score_2.toString());
    }
    public void Stand(View view)
    {
        turn = !turn;

        if(turn==true)
        {
            TextView view_1 =  findViewById(R.id.turn_view);
            view_1.setText(user_1+" Turn");
        }
        if(turn==false)
        {
            TextView view_1 =  findViewById(R.id.turn_view);
            view_1.setText(user_2+" Turn");
        }
        check();

    }

    public void reset(View view)
    {
        turn = true;
        LinearLayout linearLayout2 = (LinearLayout)findViewById(R.id.user_2_cards);
        linearLayout2.removeAllViews();
        LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.user_1_cards);
        linearLayout1.removeAllViews();
        score_2 = 0;
        score_1 = 0;
        TextView textView_1 =  findViewById(R.id.user_1);
        TextView textView_2 =  findViewById(R.id.user_2);
        textView_1.setText(user_1+" Score : "+ score_1.toString());
        textView_2.setText(user_2+" Score : "+ score_2.toString());
        View view_1 = findViewById(R.id.button);
        view_1.setEnabled(true);
        View view_2 = findViewById(R.id.button2);
        view_2.setEnabled(true);

    }
}