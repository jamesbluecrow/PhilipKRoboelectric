package com.meslize.philipkroboelectric.ui.feed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.adapter.view.FeedMessageView;
import com.meslize.philipkroboelectric.ui.feed.adapter.view.FeedMessageView_;
import com.meslize.philipkroboelectric.ui.feed.interactor.FeedInteractor;
import com.meslize.philipkroboelectric.ui.feed.interactor.FeedInteractorImpl;
import com.meslize.philipkroboelectric.ui.feed.listener.OnLoadFeedListener;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class FeedAdapter extends BaseAdapter implements OnLoadFeedListener {

    List<FeedMessage> mFeedMessages = new ArrayList<>();

    @RootContext Context mContext;

    @Bean (FeedInteractorImpl.class) FeedInteractor mInteractor;

    @AfterInject
    void afterInject() {
        mInteractor.getFeed(this);
    }

    @Override
    public int getCount() {
        return mFeedMessages.size();
    }

    @Override
    public FeedMessage getItem(int position) {
        return mFeedMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FeedMessageView feedMessageView = (FeedMessageView) convertView;

        if (convertView == null) {
            feedMessageView = FeedMessageView_.build(mContext);
        }

        feedMessageView.bind(getItem(position));

        return feedMessageView;
    }

    @Override
    public void onLoadFeedSuccess(List<FeedMessage> feedMessages) {
        mFeedMessages.clear();
        mFeedMessages.addAll(feedMessages);
    }

    @Override
    public void onLoadFeedError() {

    }
}