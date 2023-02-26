package com.example.newsapp.Models;

/**
 * Class handles each article (set of results) in the article array
 */
public class NewsHeadlines {

    /*
            "source": {
                "id": "google-news",
                "name": "Google News"
            },
            "author": "The Washington Post",
            "title": "China considers sending Russia artillery shells, U.S. officials say - The Washington Post",
            "description": null,
            "url": "https://news.google.com/rss/articles/CBMiW2h0dHBzOi8vd3d3Lndhc2hpbmd0b25wb3N0LmNvbS9uYXRpb25hbC1zZWN1cml0eS8yMDIzLzAyLzI0L2NoaW5hLXJ1c3NpYS1hcnRpbGxlcnktdWtyYWluZS_SAQA?oc=5",
            "urlToImage": null,
            "publishedAt": "2023-02-25T00:16:00Z",
            "content": null
     */
    Source source = null;
    String author = "";
    String title = "";
    String description = "";
    String url = "";
    String urlToImage = "";
    String publishedAt = "";
    String content = "";

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
