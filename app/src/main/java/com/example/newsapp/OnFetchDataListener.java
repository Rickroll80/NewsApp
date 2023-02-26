package com.example.newsapp;

import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;
/**
 * This is a listener that handle responses from the main activity.
 */
public interface OnFetchDataListener {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
