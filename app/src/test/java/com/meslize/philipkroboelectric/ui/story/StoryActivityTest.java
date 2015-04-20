package com.meslize.philipkroboelectric.ui.story;

import android.widget.ImageView;
import android.widget.TextView;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.picasso.PicassoWrapper;
import com.meslize.philipkroboelectric.ui.story.presenter.StoryPresenter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class StoryActivityTest {

    private StoryActivity mActivity;

    @Before
    public void setUp() {
        mActivity = new StoryActivity();
        mActivity.mFeedMessage = mock(FeedMessage.class);
        mActivity.mPresenter = mock(StoryPresenter.class);
        mActivity.mPicassoWrapper = mock(PicassoWrapper.class);
        mActivity.mImage = mock(ImageView.class);
        mActivity.mTitle = mock(TextView.class);
        mActivity.mAuthor = mock(TextView.class);
        mActivity.mDate = mock(TextView.class);
        mActivity.mContent = mock(TextView.class);
    }

    @Test
    public void testAfterInject() {
        mActivity.afterInject();

        verify(mActivity.mPresenter).initialize(eq(mActivity));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mActivity.mFeedMessage,
                                 mActivity.mPresenter,
                                 mActivity.mPicassoWrapper,
                                 mActivity.mImage,
                                 mActivity.mTitle,
                                 mActivity.mAuthor,
                                 mActivity.mDate,
                                 mActivity.mContent);
    }

    @Test
    public void testAfterViews() {
        mActivity.afterViews();

        verify(mActivity.mPresenter).loadStory(eq(mActivity.mFeedMessage));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowImage() {
        int image = 16;

        Picasso picasso = mock(Picasso.class);
        when(mActivity.mPicassoWrapper.getPicasso()).thenReturn(picasso);

        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(eq(image))).thenReturn(requestCreator);

        mActivity.showImage(image);

        InOrder inOrder = inOrder(picasso, requestCreator, mActivity.mPicassoWrapper);
        inOrder.verify(mActivity.mPicassoWrapper).getPicasso();
        inOrder.verify(picasso).load(eq(image));
        inOrder.verify(requestCreator).into(eq(mActivity.mImage));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowTitle() {
        String title = "TITLE";

        mActivity.showTitle(title);

        verify(mActivity.mTitle).setText(eq(title));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowAuthor() {
        String author = "AUTHOR";

        mActivity.showAuthor(author);

        verify(mActivity.mAuthor).setText(eq(author));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowDate() {
        String date = "DATE";

        mActivity.showDate(date);

        verify(mActivity.mDate).setText(eq(date));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowContent() {
        String content = "CONTENT";

        mActivity.showContent(content);

        verify(mActivity.mContent).setText(eq(content));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testShowLoadStoryError() {
        mActivity.showLoadStoryError();

        verifyNoMoreInteractionsWithMockObjects();
    }
}