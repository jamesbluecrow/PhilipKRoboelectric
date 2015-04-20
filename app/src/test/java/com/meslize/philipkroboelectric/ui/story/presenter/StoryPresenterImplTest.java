package com.meslize.philipkroboelectric.ui.story.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.model.Story;
import com.meslize.philipkroboelectric.ui.story.interactor.StoryInteractor;
import com.meslize.philipkroboelectric.ui.story.view.StoryView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class StoryPresenterImplTest {

    private StoryPresenterImpl mPresenter;

    @Before
    public void setUp() {
        mPresenter = new StoryPresenterImpl();
        mPresenter.mView = mock(StoryView.class);
        mPresenter.mInteractor = mock(StoryInteractor.class);
    }

    @Test
    public void testInitialize() {
        StoryView view = mock(StoryView.class);

        mPresenter.initialize(view);

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(view, mPresenter.mView);
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mPresenter.mView, mPresenter.mInteractor);
    }

    @Test
    public void testLoadStory() {
        FeedMessage feedMessage = mock(FeedMessage.class);
        when(feedMessage.getId()).thenReturn("ID");

        mPresenter.loadStory(feedMessage);

        verify(mPresenter.mInteractor).getStory(eq(feedMessage.getId()), eq(mPresenter));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testOnLoadStorySuccess() {
        Story story = mock(Story.class);
        when(story.getImage()).thenReturn(16);
        when(story.getTitle()).thenReturn("TITLE");
        when(story.getAuthor()).thenReturn("AUTHOR");
        when(story.getDate()).thenReturn("DATE");
        when(story.getContent()).thenReturn("CONTENT");

        mPresenter.onLoadStorySuccess(story);

        verify(mPresenter.mView).showImage(eq(story.getImage()));
        verify(mPresenter.mView).showTitle(eq(story.getTitle()));
        verify(mPresenter.mView).showAuthor(eq(story.getAuthor()));
        verify(mPresenter.mView).showDate(eq(story.getDate()));
        verify(mPresenter.mView).showContent(eq(story.getContent()));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testOnLoadStoryError() {
        mPresenter.onLoadStoryError();

        verify(mPresenter.mView).showLoadStoryError();

        verifyNoMoreInteractionsWithMockObjects();
    }
}