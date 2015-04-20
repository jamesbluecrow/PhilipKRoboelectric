package com.meslize.philipkroboelectric.model;

import java.io.Serializable;

public class StoryImpl implements Story, Serializable {

    String mId;
    String mAuthor;
    int mImage;
    String mTitle;
    String mDate;
    String mContent;

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public void setId(String id) {
        mId = id;
    }

    @Override
    public String getAuthor() {
        return mAuthor;
    }

    @Override
    public void setAuthor(String author) {
        mAuthor = author;
    }

    @Override
    public int getImage() {
        return mImage;
    }

    @Override
    public void setImage(int image) {
        mImage = image;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String getDate() {
        return mDate;
    }

    @Override
    public void setDate(String date) {
        mDate = date;
    }

    @Override
    public String getContent() {
        return mContent;
    }

    @Override
    public void setContent(String content) {
        mContent = content;
    }
}
