package com.sl.nyt_sl;

public class newsitem
{
    private String newsTitle;
    private String newsAbstract;
    private String newsDate;
    private String newsLink;

    public newsitem(String newsTitle, String newsAbstract, String newsDate, String newsLink)
    {
        this.newsTitle = newsTitle;
        this.newsAbstract = newsAbstract;
        this.newsDate = newsDate;
        this.newsLink = newsLink;
    }

    public String getNewsLink()
    {
        return newsLink;
    }

    public String getNewsDate()
    {
        return newsDate;
    }
/*
    public newsitem(String newsTitle, String newsAbstract, String newsDate)
    {
        this.newsTitle = newsTitle;
        this.newsAbstract = newsAbstract;
        this.newsDate = newsDate;
    }
*/
    public String getNewsTitle()
    {
        return newsTitle;
    }

    public String getNewsAbstract()
    {
        return newsAbstract;
    }
}
