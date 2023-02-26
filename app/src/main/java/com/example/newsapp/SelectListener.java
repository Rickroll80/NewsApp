package com.example.newsapp;

import com.example.newsapp.Models.NewsHeadlines;

/**
 * Listener for each news article (functional interface).
 */
public interface SelectListener {
    void OnNewsClicked(NewsHeadlines headlines);
}
