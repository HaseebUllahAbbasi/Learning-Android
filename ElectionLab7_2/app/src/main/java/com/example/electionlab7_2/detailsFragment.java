package com.example.electionlab7_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class detailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int position;
    int[] imagesArray;
    String[] description;
    public detailsFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        imagesArray = new int[]{R.drawable.clinton,R.drawable.sanders,R.drawable.omalley,R.drawable.chafee,R.drawable.trump,R.drawable.carson,R.drawable.rubio,R.drawable.bush};
        description = new String[]{"Former United States Secretary of State","Member of the United States Senate","Former Governor of Maryland","Former Governor of Rhode Island","45th U.S. President",
        "Former United States Secretary of Housing and Urban Development","Member of the United States Senate","Former Governor of Florida"};
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ImageView img = view.findViewById(R.id.imageView);
        TextView txt = view.findViewById(R.id.detail);
        img.setImageResource(imagesArray[position]);
        txt.setText(description[position]);
        return view;
    }
}