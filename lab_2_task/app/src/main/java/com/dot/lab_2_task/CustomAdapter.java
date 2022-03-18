package com.dot.lab_2_task;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Book>
{

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> objects)
    {

        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book book = (Book) getItem(position);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_view, parent, false);
        }
        TextView title = (TextView)convertView.findViewById(R.id.title_view);
        TextView author = (TextView)convertView.findViewById(R.id.authorView);
        TextView ISBN = (TextView)convertView.findViewById(R.id.isbn_view);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);

        title.setText(book.getTitle());

        author.setText(book.getAuthor());
        ISBN.setText(book.getISBN());
        imageView.setImageResource(book.getImg());

        return convertView;

    }
}
