package com.dot.scrim_dot;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    TextView turnLabel ;
    boolean user_1 = true;
    LinearLayout layout;
    Pile[] piles = new Pile[10];
    TextView[] views = new TextView[10];
    Pile pile_0;
    Pile pile_1;
    Pile pile_2;
    Pile pile_3;
    Pile pile_4;
    Pile pile_5;
    Pile pile_6;
    Pile pile_7;
    Pile pile_8;
    Pile pile_9;

    int attackerIndex;
    ArrayList<Card> player_one_cards;
    ArrayList<Card> player_two_cards;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        player_one_cards = intent.getParcelableArrayListExtra("player_one_cards");
        player_two_cards = intent.getParcelableArrayListExtra("player_two_cards");
        Log.d(TAG, "onCreate: player one cards "+player_one_cards.size());
        Log.d(TAG, "onCreate: player two cards "+player_two_cards.size());


        layout =  findViewById(R.id.layout);
        turnLabel =  findViewById(R.id.textView2);
        turnLabel.setText("Player 1 turn ");
        views[0] =  findViewById(R.id.textView4);
        views[1] =  findViewById(R.id.textView5);
        views[2] =  findViewById(R.id.textView6);
        views[3] =  findViewById(R.id.textView7);
        views[4] =  findViewById(R.id.textView8);

        views[5] =  findViewById(R.id.textView9);
        views[6] =  findViewById(R.id.textView10);
        views[7] =  findViewById(R.id.textView11);
        views[8] =  findViewById(R.id.textView12);
        views[9] =  findViewById(R.id.textView13);

        setGameData();
        setImagesOfGame();
        View.OnLongClickListener attack = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String s = v.getTag().toString();
                Integer index = Integer.parseInt(s);

                if(index>4 && user_1)
                {
                    Snackbar.make(layout, "user 2 can't play when user one has turn", Snackbar.LENGTH_LONG ).show();
                    return true;
                }
                else if(index<=4 && user_1)
                {
                    attackerIndex = Integer.parseInt(v.getTag().toString());
                    openDialog();
                }
                else if(index<4 && user_1 == false)
                {
                    Snackbar.make(layout, "user 1 can't play when user two has turn", Snackbar.LENGTH_LONG ).show();
                    return true;
                }
                else if(index>4 && user_1 == false)
                {
                    attackerIndex = Integer.parseInt(v.getTag().toString());
                    openDialog();
                }


//                String s = v.getTag().toString();
//                Integer index = Integer.parseInt(s);
//                piles[index].removeTop();
//
//                Toast.makeText(getApplicationContext(), "Attack", Toast.LENGTH_LONG).show();
                return true;
            }
        };
        findViewById(R.id.imageView).setOnLongClickListener(attack);
        findViewById(R.id.imageView2).setOnLongClickListener(attack);
        findViewById(R.id.imageView3).setOnLongClickListener(attack);
        findViewById(R.id.imageView4).setOnLongClickListener(attack);
        findViewById(R.id.imageView5).setOnLongClickListener(attack);
        findViewById(R.id.imageView6).setOnLongClickListener(attack);
        findViewById(R.id.imageView7).setOnLongClickListener(attack);
        findViewById(R.id.imageView8).setOnLongClickListener(attack);
        findViewById(R.id.imageView9).setOnLongClickListener(attack);
        findViewById(R.id.imageView10).setOnLongClickListener(attack);


    }
    CustomDialog dialog = new CustomDialog();

    private void openDialog() {
        dialog.show(getSupportFragmentManager(), "Select Pile ");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_1,menu);
    }
    private void setImagesOfGame()
    {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getTitle() == "Attack")
        {
        }
        return  true;
    }

    private void setGameData()
    {
        Card crown = new Card("crown",100,R.drawable.crown);
        Card archer = new Card("archer",10,R.drawable.archer);
        Card shield = new Card("shield",0,R.drawable.sheild);
        Card cover = new Card("cover",0,R.drawable.back_cover);
        Card dagger = new Card("dagger",1,R.drawable.one);
        Card sword = new Card("sword",2,R.drawable.two);
        Card star = new Card("star",3,R.drawable.three);
        Card axe = new Card("axe",4,R.drawable.four);
        Card halberd = new Card("halberd",5,R.drawable.five);
        Card longSword = new Card("longSword",6,R.drawable.six);


        int pilesCount = -1;
        int overAllIndex = 0;
        for (Card card: player_one_cards)
        {
            if((overAllIndex%5)==0)
            {

                pilesCount++;
                piles[pilesCount] = new Pile(pilesCount);
                Log.d(TAG, "setGameData: "+pilesCount+ " is created " );
            }
            piles[pilesCount].addCard(card);
            overAllIndex++;
        }
        overAllIndex = 0;
        for (Card card: player_two_cards)
        {
            if((overAllIndex%5)==0)
            {
                pilesCount++;
                piles[pilesCount] = new Pile(pilesCount);
                Log.d(TAG, "setGameData: "+pilesCount+ " is created " );
            }
            piles[pilesCount].addCard(card);
            overAllIndex++;
        }


        for (int i=0; i<10; i++)
        {
            views[i].setText(String.valueOf(piles[i].counter));
        }

//        pile_0 = new Pile(0);
//        pile_0.addCard(crown);
//        pile_0.addCard(dagger);
//        pile_0.addCard(sword);
//        pile_0.addCard(star);
//        pile_0.addCard(axe);


    }

    public void showImg(View view)
    {
        String s = view.getTag().toString();
        Integer index = Integer.parseInt(s);
        if(index>4 && user_1)
        {
//            Toast.makeText(getApplicationContext(),"user 2 can't see when user one has turn",Toast.LENGTH_LONG).show();
            Snackbar.make(layout, "user 2 can't see when user one has turn", Snackbar.LENGTH_LONG ).show();

        }
        else if(index<=4 && user_1)
        {



            ImageView imageView =  (ImageView) view;
            imageView.setImageResource(piles[index].showTop().picture);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    imageView.setImageResource(R.drawable.back_cover);
                }
            },1500);
        }
        else if(index<=4 && user_1 == false)
        {
            Snackbar.make(layout, "user 1 can't see when user two has turn", Snackbar.LENGTH_LONG ).show();

        }
        else if(index>4 && user_1 == false)
        {


            ImageView imageView =  (ImageView) view;
            imageView.setImageResource(piles[index].showTop().picture);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    imageView.setImageResource(R.drawable.back_cover);
                }
            },1500);
        }



    }


    public void attackOnPile(View view)
    {
        Button button = (Button)view;

        String s = button.getText().toString();
        Integer index = Integer.parseInt(s);

        if(user_1)
        {
            index+=5;
        }
//        Toast.makeText(this,"Clicked "+ button.getText().toString(),Toast.LENGTH_LONG).show();
//        piles[index - 1].attacked()
//        Snackbar.make(layout, "attacker  " +attackerIndex + " attacked on  "+ (index-1)   , Snackbar.LENGTH_LONG ).setAction("Close", new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        }).show();
        int attackedResult = piles[index - 1].attacked(piles[attackerIndex].showTop());
        switch (attackedResult)
        {
            case 1:
            case 0:
                piles[attackerIndex].removeTop();
                break;
            case -1:
                break;
            case -10:
                if(user_1)
                {
                    Toast.makeText(getApplicationContext(),"User 1 has won", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"User 2 has won", Toast.LENGTH_LONG).show();
                break;
        }
//            Card card = piles[index - 1].removeTop();

        views[attackerIndex].setText(String.valueOf(piles[attackerIndex].counter));
        views[index-1].setText(String.valueOf(piles[index-1].counter));
        dialog.dismiss();
//        if(card.getName()=="crown")
//        {
//
//            layout.setEnabled(false);
//        }

//            Snackbar.make(layout, "Clicked  "+ button.getText().toString(), Snackbar.LENGTH_LONG ).setAction("Close", new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        }).show();
        if(user_1)
            turnLabel.setText("Player 2 turn ");
        else
            turnLabel.setText("Player 1 turn ");
        user_1 = !user_1;
    }



}