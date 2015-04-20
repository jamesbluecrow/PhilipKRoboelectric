package com.meslize.philipkroboelectric.repository.feed;

import com.meslize.philipkroboelectric.dummy.Dummy;
import com.meslize.philipkroboelectric.model.FeedMessage;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
class LocalRepositoryImpl implements LocalRepository {

    @Bean Dummy mDummy;

    @Override
    public List<FeedMessage> getFeed() {
        return mDummy.getFeed();
    }
}
