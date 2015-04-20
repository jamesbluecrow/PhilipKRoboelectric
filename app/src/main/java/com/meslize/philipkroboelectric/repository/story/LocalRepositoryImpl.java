package com.meslize.philipkroboelectric.repository.story;

import com.meslize.philipkroboelectric.dummy.Dummy;
import com.meslize.philipkroboelectric.model.Story;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
class LocalRepositoryImpl implements LocalRepository {

    @Bean Dummy mDummy;

    @Override
    public Story getStory(String id) {
        return mDummy.getStory(id);
    }
}
