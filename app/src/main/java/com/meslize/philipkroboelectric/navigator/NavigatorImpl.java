package com.meslize.philipkroboelectric.navigator;

import android.app.Activity;
import android.content.Intent;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.FeedActivity_;
import com.meslize.philipkroboelectric.ui.story.StoryActivity_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.Serializable;

@EBean
public class NavigatorImpl implements Navigator {

    @RootContext Activity mActivity;

    @Override
    public void finishScreen() {
        mActivity.finish();
    }

    @Override
    public void startFeedScreen() {
        Intent intent = new Intent(mActivity, FeedActivity_.class);

        mActivity.startActivity(intent);
    }

    @Override
    public void startStoryScreen(FeedMessage feedMessage) {
        Intent intent = new Intent(mActivity, StoryActivity_.class);
        intent.putExtra(StoryActivity_.M_FEED_MESSAGE_EXTRA, (Serializable) feedMessage);

        mActivity.startActivity(intent);
    }
}
