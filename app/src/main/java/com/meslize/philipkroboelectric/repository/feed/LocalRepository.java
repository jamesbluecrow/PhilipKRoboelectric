package com.meslize.philipkroboelectric.repository.feed;

import com.meslize.philipkroboelectric.model.FeedMessage;

import java.util.List;

interface LocalRepository {
    List<FeedMessage> getFeed();
}
