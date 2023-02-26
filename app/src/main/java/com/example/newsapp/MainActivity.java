package com.example.newsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsApiResponse;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // show dialog as news loads
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles...");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);



    }

    // create listener
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            // show news articles in recycler view
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            // show error message

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        // initialize recyclerView
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new CustomAdapter(this, list, this);
        // attach adapter to recyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        // create new activity showing the details of the particular news article clicked
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                .putExtra("data", headlines)); // headlines gets passed to the new activity with the name "data"


    }
}
