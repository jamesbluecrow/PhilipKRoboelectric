package com.meslize.philipkroboelectric.ui.feed.interactor;

import com.meslize.philipkroboelectric.ui.feed.listener.OnLoadFeedListener;

public interface FeedInteractor {
    void getFeed(OnLoadFeedListener listener);
}
