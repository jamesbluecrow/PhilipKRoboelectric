package com.meslize.philipkroboelectric.repository.story;

import com.meslize.philipkroboelectric.model.Story;

public interface StoryRepository {
    Story localGetStory(String id);
}
