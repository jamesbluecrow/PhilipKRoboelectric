package com.meslize.philipkroboelectric.repository.story;

import com.meslize.philipkroboelectric.model.Story;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class StoryRepositoryImpl implements StoryRepository {

    @Bean (LocalRepositoryImpl.class) LocalRepository mLocalRepository;

    @Override
    public Story localGetStory(String id) {
        return mLocalRepository.getStory(id);
    }
}
