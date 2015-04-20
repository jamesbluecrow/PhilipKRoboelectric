package com.meslize.philipkroboelectric.ui.story.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.story.view.StoryView;

public interface StoryPresenter {
    void initialize(StoryView view);

    void loadStory(FeedMessage feedMessage);
}
