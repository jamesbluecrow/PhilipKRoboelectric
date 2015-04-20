package com.meslize.philipkroboelectric.repository.story;

import com.meslize.philipkroboelectric.model.Story;

interface LocalRepository {
    Story getStory(String id);
}
