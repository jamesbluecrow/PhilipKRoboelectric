package com.meslize.philipkroboelectric.ui.feed.listener;

import com.meslize.philipkroboelectric.model.FeedMessage;

import java.util.List;

public interface OnLoadFeedListener {
    void onLoadFeedSuccess(List<FeedMessage> feedMessages);

    void onLoadFeedError();
}
