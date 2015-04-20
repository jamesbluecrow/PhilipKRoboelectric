package com.meslize.philipkroboelectric.ui.feed.interactor;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.repository.feed.FeedRepository;
import com.meslize.philipkroboelectric.repository.feed.FeedRepositoryImpl;
import com.meslize.philipkroboelectric.ui.feed.listener.OnLoadFeedListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class FeedInteractorImpl implements FeedInteractor {

    @Bean (FeedRepositoryImpl.class) FeedRepository mFeedRepository;

    @Override
    public void getFeed(OnLoadFeedListener listener) {
        List<FeedMessage> feedMessages = mFeedRepository.localGetFeed();
        listener.onLoadFeedSuccess(feedMessages);
    }
}
