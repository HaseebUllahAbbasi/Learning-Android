package com.dot.simple_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int index = 0;
    int right = 0;
    int wrong = 0 ;
    TextView textView;
    List<Question> questions = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questions.add(new Question("Some cats are actually allergic to humans", true));
        questions.add(new Question("simple", true));
        questions.add(new Question("You can lead a cow down stairs but not up stairs.", false));
        questions.add(new Question("Approximately one quarter of human bones are in the feet.", true));
        questions.add(new Question("A slug blood is green.", true));
        questions.add(new Question("Some cats are actually allergic to humans", true));
        questions.add(new Question("simple", true));
        questions.add(new Question("You can lead a cow down stairs but not up stairs.", false));
        questions.add(new Question("Approximately one quarter of human bones are in the feet.", true));
        questions.add(new Question("A slug blood is green.", true));
        questions.add(new Question("Some cats are actually allergic to humans", true));
        questions.add(new Question("simple", true));
        questions.add(new Question("You can lead a cow down stairs but not up stairs.", false));
        questions.add(new Question("Approximately one quarter of human bones are in the feet.", true));
        questions.add(new Question("A slug blood is green.", true));


        textView =  findViewById(R.id.textView);
        Question question = questions.get(index);
        textView.setText(question.getQuestion());

    }
    public void check_true(View view)
    {

        if(index==14)
            return;
        Question question = questions.get(index);
        if(question.isAnswer() == true)
        {
            right++;
            index++;
            question = questions.get(index);
            textView.setText(question.getQuestion());

        }
        if(index==14)
        {
            Toast.makeText(this,"Wrong : "+wrong + "right : "+ right,Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(this,Result.class);
//            intent.putExtra("right",right);
//            intent.putExtra("wrong",wrong);
//
//
//            startActivity(intent);

        }

    }

    public void check_false(View view)
    {
        if(index==14)
            return;
        Question question = questions.get(index);
        if(question.isAnswer() == false)
        {
            wrong++;
            index++;

            question = questions.get(index);
            textView.setText(question.getQuestion());
        }
        if(index==14)
        {
            Toast.makeText(this,"Wrong : "+wrong + "right : "+ right,Toast.LENGTH_LONG).show();

////            Intent `intent = new Intent(this,Result.class);
////            intent.putExtra("right",right);
////            intent.putExtra("wrong",wrong);
//
//            startActivity(intent);

        }
    }

}