package com.meslize.philipkroboelectric.ui.story.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.model.Story;
import com.meslize.philipkroboelectric.ui.story.interactor.StoryInteractor;
import com.meslize.philipkroboelectric.ui.story.interactor.StoryInteractorImpl;
import com.meslize.philipkroboelectric.ui.story.listener.OnLoadStoryListener;
import com.meslize.philipkroboelectric.ui.story.view.StoryView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class StoryPresenterImpl implements StoryPresenter, OnLoadStoryListener {

    StoryView mView;

    @Bean (StoryInteractorImpl.class) StoryInteractor mInteractor;

    @Override
    public void initialize(StoryView view) {
        mView = view;
    }

    @Override
    public void loadStory(FeedMessage feedMessage) {
        mInteractor.getStory(feedMessage.getId(), this);
    }

    @Override
    public void onLoadStorySuccess(Story story) {
        mView.showImage(story.getImage());
        mView.showTitle(story.getTitle());
        mView.showAuthor(story.getAuthor());
        mView.showDate(story.getDate());
        mView.showContent(story.getContent());
    }

    @Override
    public void onLoadStoryError() {
        mView.showLoadStoryError();
    }
}
