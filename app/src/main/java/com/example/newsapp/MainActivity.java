package com.example.newsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsApiResponse;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button b1, b2, b3, b4, b5, b6, b7;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // show dialog as news loads
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles...");
        dialog.show();

        // initialize search view
        searchView = findViewById(R.id.search_view);
        // Set text listener
        // Text is needed upon submission, not while it is being changed
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching " + query + " news articles...");
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener, "general", query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        // initialize buttons (horizontal scroll view)
        b1 = findViewById(R.id.btn_1);
        b2 = findViewById(R.id.btn_2);
        b3 = findViewById(R.id.btn_3);
        b4 = findViewById(R.id.btn_4);
        b5 = findViewById(R.id.btn_5);
        b6 = findViewById(R.id.btn_6);
        b7 = findViewById(R.id.btn_7);

        // set click listeners
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    // create listener
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if (list.isEmpty()) {
                Toast.makeText(MainActivity.this, "No data found!", Toast.LENGTH_SHORT).show();
            }

            // show news articles in recycler view
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            // show error message
            Toast.makeText(MainActivity.this, "Error occurred while attempting to fetch data.",
                    Toast.LENGTH_LONG).show();

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

    // When clicking a button, the RequestManager class's getNewsHeadlines method is called
    // with the category of the button instead of a "general" call
    @Override
    public void onClick(View v) {
        Button button = (Button) v; // downcast
        // obtain category of the button
        String category = button.getText().toString();
        dialog.setTitle("Fetching " + category + " news articles...");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, category, null);
    }
}
