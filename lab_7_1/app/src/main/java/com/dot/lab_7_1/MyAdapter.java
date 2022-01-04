package com.dot.lab_7_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter  extends ArrayAdapter
{
    Context context ;
    int resource;
    List<User> list;
    public MyAdapter(@NonNull Context context, int resource, List<User> objects)
    {
        super(context,resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        User user = list.get(position);
        TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.email);
        TextView phone = convertView.findViewById(R.id.phone);

        name.setText(user.getName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        return convertView;
    }
}
