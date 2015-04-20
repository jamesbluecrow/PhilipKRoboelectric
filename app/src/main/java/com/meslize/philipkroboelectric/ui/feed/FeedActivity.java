package com.meslize.philipkroboelectric.ui.feed;

import android.app.Activity;
import android.widget.AbsListView;

import com.meslize.philipkroboelectric.R;
import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.adapter.FeedAdapter;
import com.meslize.philipkroboelectric.ui.feed.presenter.FeedPresenter;
import com.meslize.philipkroboelectric.ui.feed.presenter.FeedPresenterImpl;
import com.meslize.philipkroboelectric.ui.feed.view.FeedView;
import com.meslize.philipkroboelectric.ui.story.StoryActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_feed)
public class FeedActivity extends Activity implements FeedView {

    @Bean (FeedPresenterImpl.class) FeedPresenter mPresenter;
    @Bean FeedAdapter mAdapter;

    @ViewById (android.R.id.list) AbsListView mListView;

    @AfterInject
    void afterInject() {
        mPresenter.initialize(this);
    }

    @AfterViews
    void afterViews() {
        mListView.setAdapter(mAdapter);
    }

    @ItemClick (android.R.id.list)
    void itemClickFeed(FeedMessage feedMessage) {
        mPresenter.clickFeedMessage(feedMessage);
    }

    @Override
    public void startStoryScreen(FeedMessage feedMessage) {
        StoryActivity_.intent(this).mFeedMessage(feedMessage).start();
    }
}
