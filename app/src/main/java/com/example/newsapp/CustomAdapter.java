package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Class serves as a custom adapter for the news articles.
 * The adapter holds a data set representing all the news articles.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    // returns a CustomViewHolder when RecyclerView needs a RecyclerView.ViewHolder to represent the article
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.headline_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // get title of each headline
        holder.text_title.setText(headlines.get(position).getTitle());
        // get name of the source
        holder.text_source.setText(headlines.get(position).getSource().getName());
//        for (int i = 1; i < headlines.size(); i++) {
//            System.out.println(headlines.get(i).getSource().getName());
//        }
        // show image of the news article (ImageView)



        if (headlines.get(position).getUrlToImage() != null) {
            // There is an image URL inside the string
            // Load the URL inside the ImageView using Picasso
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        } // else { Toast.makeText(context, "Placeholder image", Toast.LENGTH_SHORT).show(); }

        // create onClickListener for the cardView
        holder.cardView.setOnClickListener(v -> listener.OnNewsClicked(headlines.get(position)));

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
