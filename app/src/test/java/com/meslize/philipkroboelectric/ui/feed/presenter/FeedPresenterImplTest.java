package com.meslize.philipkroboelectric.ui.feed.presenter;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.view.FeedView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class FeedPresenterImplTest {

    private FeedPresenterImpl mPresenter;

    @Before
    public void setUp() {
        mPresenter = new FeedPresenterImpl();
        mPresenter.mView = mock(FeedView.class);
    }

    @Test
    public void testInitialize() {
        FeedView view = mock(FeedView.class);

        mPresenter.initialize(view);

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(view, mPresenter.mView);
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mPresenter.mView);
    }

    @Test
    public void testClickFeedMessage() {
        FeedMessage feedMessage = mock(FeedMessage.class);

        mPresenter.clickFeedMessage(feedMessage);

        verify(mPresenter.mView).startStoryScreen(eq(feedMessage));

        verifyNoMoreInteractionsWithMockObjects();
    }
}