package com.meslize.philipkroboelectric.repository.feed;

import com.meslize.philipkroboelectric.model.FeedMessage;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class FeedRepositoryImpl implements FeedRepository {

    @Bean (LocalRepositoryImpl.class) LocalRepository mLocalRepository;

    @Override
    public List<FeedMessage> localGetFeed() {
        return mLocalRepository.getFeed();
    }
}
