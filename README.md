# NewsApp

This is an Android application that requests and displays news article data from the News API. 
In the main activity: 
- A recycler view displays each article obtained from the API. 
- A horizontal scroll view contains buttons to display specific news categories. 
- A keyword can be typed into the search bar to find specific news items. 

Clicking on a news article leads to a second activity with further details on the specific news article. 

The Retrofit Gson converter was used for JSON serialization. 
Picasso was used to load images by URL. 

NOTE: As of 2/26/23, the News API is returning null values for description, urlToImage, and content, resulting in missing data in the GIF. 

![NEWSAPP](https://user-images.githubusercontent.com/57027672/221445062-6588ae65-0c83-45a0-8b1e-8c006a1c767e.gif)

See: 
* News API – https://newsapi.org/
* Retrofit – https://github.com/square/retrofit/tree/master/retrofit-converters/gson
* Picasso – https://github.com/square/picasso

