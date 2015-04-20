package com.meslize.philipkroboelectric.ui.feed.interactor;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.repository.feed.FeedRepository;
import com.meslize.philipkroboelectric.ui.feed.listener.OnLoadFeedListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class FeedInteractorImplTest {

    private FeedInteractorImpl mInteractor;

    @Before
    public void setUp() {
        mInteractor = new FeedInteractorImpl();
        mInteractor.mFeedRepository = mock(FeedRepository.class);
    }

    @Test
    public void testGetFeed() {
        List<FeedMessage> feedMessages = new ArrayList<>();
        when(mInteractor.mFeedRepository.localGetFeed()).thenReturn(feedMessages);

        OnLoadFeedListener listener = mock(OnLoadFeedListener.class);

        mInteractor.getFeed(listener);

        InOrder inOrder = inOrder(listener, mInteractor.mFeedRepository);
        inOrder.verify(mInteractor.mFeedRepository).localGetFeed();
        inOrder.verify(listener).onLoadFeedSuccess(eq(feedMessages));
        inOrder.verifyNoMoreInteractions();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mInteractor.mFeedRepository);
    }
}