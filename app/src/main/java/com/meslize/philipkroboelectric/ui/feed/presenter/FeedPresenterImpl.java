package com.meslize.philipkroboelectric.ui.feed.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.view.FeedView;

import org.androidannotations.annotations.EBean;

@EBean
public class FeedPresenterImpl implements FeedPresenter {

    FeedView mView;

    @Override
    public void initialize(FeedView view) {
        mView = view;
    }

    @Override
    public void clickFeedMessage(FeedMessage feedMessage) {
        mView.startStoryScreen(feedMessage);
    }
}
