package com.dot.dictionarydot;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import static android.content.ContentValues.TAG;

public class CustomDialog extends AppCompatDialogFragment
{
    TextView  word,desc ;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view =  inflater.inflate(R.layout.dialog,null);


        builder.setView(view).setTitle("Word Details ").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        word = (TextView) view.findViewById(R.id.word_dialog);
        desc = (TextView) view.findViewById(R.id.desc_dialog);



        word.setText(       getArguments().getString("word"));
        desc.setText(        getArguments().getString("desc"));


        return builder.create();


//        return super.onCreateDialog(savedInstanceState);

    }
}
