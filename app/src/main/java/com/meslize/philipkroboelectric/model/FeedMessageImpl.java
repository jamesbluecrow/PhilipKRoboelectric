package com.meslize.philipkroboelectric.model;

import java.io.Serializable;

public class FeedMessageImpl implements FeedMessage, Serializable {

    String mId;
    int mThumbnail;
    String mTitle;
    String mDescription;

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public void setId(String id) {
        mId = id;
    }

    @Override
    public int getThumbnail() {
        return mThumbnail;
    }

    @Override
    public void setThumbnail(int thumbnail) {
        mThumbnail = thumbnail;
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
    public String getDescription() {
        return mDescription;
    }

    @Override
    public void setDescription(String description) {
        mDescription = description;
    }
}
