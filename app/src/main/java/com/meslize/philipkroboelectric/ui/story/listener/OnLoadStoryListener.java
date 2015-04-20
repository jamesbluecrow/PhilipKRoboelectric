package com.meslize.philipkroboelectric.ui.story.listener;

import com.meslize.philipkroboelectric.model.Story;

public interface OnLoadStoryListener {
    void onLoadStorySuccess(Story story);

    void onLoadStoryError();
}
