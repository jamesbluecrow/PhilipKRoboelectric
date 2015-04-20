package com.meslize.philipkroboelectric.navigator;

import com.meslize.philipkroboelectric.model.FeedMessage;

public interface Navigator {
    void finishScreen();

    void startFeedScreen();

    void startStoryScreen(FeedMessage feedMessage);
}
