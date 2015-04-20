package com.meslize.philipkroboelectric.ui.story.interactor;

import com.meslize.philipkroboelectric.model.Story;
import com.meslize.philipkroboelectric.repository.story.StoryRepository;
import com.meslize.philipkroboelectric.repository.story.StoryRepositoryImpl;
import com.meslize.philipkroboelectric.ui.story.listener.OnLoadStoryListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class StoryInteractorImpl implements StoryInteractor {

    @Bean (StoryRepositoryImpl.class) StoryRepository mStoryRepository;

    @Override
    public void getStory(String id, OnLoadStoryListener listener) {
        Story story = mStoryRepository.localGetStory(id);
        listener.onLoadStorySuccess(story);
    }
}
