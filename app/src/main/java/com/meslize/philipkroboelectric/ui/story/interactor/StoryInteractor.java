package com.meslize.philipkroboelectric.ui.story.interactor;

import com.meslize.philipkroboelectric.ui.story.listener.OnLoadStoryListener;

public interface StoryInteractor {
    void getStory(String id, OnLoadStoryListener listener);
}
