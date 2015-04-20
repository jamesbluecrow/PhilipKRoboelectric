package com.meslize.philipkroboelectric.ui.feed;

import android.content.Intent;
import android.widget.AbsListView;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.model.FeedMessageImpl;
import com.meslize.philipkroboelectric.ui.feed.adapter.FeedAdapter;
import com.meslize.philipkroboelectric.ui.feed.presenter.FeedPresenter;
import com.meslize.philipkroboelectric.ui.story.StoryActivity_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class FeedActivityTest {

    private FeedActivity mActivity;

    @Before
    public void setUp() {
        mActivity = new FeedActivity();
        mActivity.mPresenter = mock(FeedPresenter.class);
        mActivity.mAdapter = mock(FeedAdapter.class);
        mActivity.mListView = mock(AbsListView.class);
    }

    @Test
    public void testAfterInject() {
        mActivity.afterInject();

        verify(mActivity.mPresenter).initialize(eq(mActivity));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mActivity.mPresenter, mActivity.mAdapter, mActivity.mListView);
    }

    @Test
    public void testAfterViews() {
        mActivity.afterViews();

        verify(mActivity.mListView).setAdapter(eq(mActivity.mAdapter));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testItemClickFeed() {
        FeedMessage feedMessage = mock(FeedMessage.class);

        mActivity.itemClickFeed(feedMessage);

        verify(mActivity.mPresenter).clickFeedMessage(eq(feedMessage));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testStartStoryScreen() {
        FeedMessage feedMessage = mock(FeedMessageImpl.class);

        FeedActivity_ activity = Robolectric.setupActivity(FeedActivity_.class);
        activity.startStoryScreen(feedMessage);

        Intent intent = Robolectric.shadowOf(activity).peekNextStartedActivity();
        assertEquals(StoryActivity_.class.getCanonicalName(), intent.getComponent().getClassName());
        assertEquals(feedMessage, intent.getExtras().get(StoryActivity_.M_FEED_MESSAGE_EXTRA));
    }
}