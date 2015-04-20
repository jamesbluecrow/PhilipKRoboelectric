package com.meslize.philipkroboelectric.ui.feed.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.ui.feed.adapter.view.FeedMessageView;
import com.meslize.philipkroboelectric.ui.feed.interactor.FeedInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
@SuppressWarnings ("unchecked")
public class FeedAdapterTest {

    private FeedAdapter mAdapter;

    @Before
    public void setUp() {
        mAdapter = new FeedAdapter();
        mAdapter.mFeedMessages = mock(ArrayList.class);
        mAdapter.mContext = Robolectric.application;
        mAdapter.mInteractor = mock(FeedInteractor.class);
    }

    @Test
    public void testAfterInject() {
        mAdapter.afterInject();

        verify(mAdapter.mInteractor).getFeed(eq(mAdapter));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mAdapter.mInteractor);
    }

    @Test
    public void testGetCount() {
        int size = 16;
        when(mAdapter.mFeedMessages.size()).thenReturn(size);

        int result = mAdapter.getCount();

        verify(mAdapter.mFeedMessages).size();

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(size, result);
    }

    @Test
    public void testGetItem() {
        int position = 16;

        FeedMessage feedMessage = mock(FeedMessage.class);
        when(mAdapter.mFeedMessages.get(eq(position))).thenReturn(feedMessage);

        FeedMessage result = mAdapter.getItem(position);

        verify(mAdapter.mFeedMessages).get(eq(position));

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(feedMessage, result);
    }

    @Test
    public void testGetItemId() {
        int position = 16;

        long result = mAdapter.getItemId(position);

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(position, result);
    }

    @Test
    public void testGetView() {
        int position = 16;

        FeedMessageView feedMessageView = mock(FeedMessageView.class);

        ViewGroup parent = mock(ViewGroup.class);

        View result = mAdapter.getView(position, feedMessageView, parent);

        verify(mAdapter.mFeedMessages).get(eq(position));

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(feedMessageView, result);
    }

    @Test
    public void testOnLoadFeedSuccess() {
        FeedMessage feedMessage1 = mock(FeedMessage.class);
        FeedMessage feedMessage2 = mock(FeedMessage.class);

        List<FeedMessage> feedMessages = new ArrayList<>();
        feedMessages.add(feedMessage1);
        feedMessages.add(feedMessage2);

        mAdapter.onLoadFeedSuccess(feedMessages);

        verify(mAdapter.mFeedMessages).clear();
        verify(mAdapter.mFeedMessages).addAll(eq(feedMessages));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testOnLoadFeedError() {
        mAdapter.onLoadFeedError();

        verifyNoMoreInteractionsWithMockObjects();
    }
}