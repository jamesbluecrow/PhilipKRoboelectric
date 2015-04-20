package com.meslize.philipkroboelectric.ui.feed.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.view.FeedView;

public interface FeedPresenter {
    void initialize(FeedView view);

    void clickFeedMessage(FeedMessage feedMessage);
}
