package com.meslize.philipkroboelectric.ui.feed.adapter.view;

import android.widget.ImageView;
import android.widget.TextView;

import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.picasso.PicassoWrapper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class FeedMessageViewTest {

    private FeedMessageView mView;

    @Before
    public void setUp() {
        mView = new FeedMessageView(Robolectric.application);
        mView.mPicassoWrapper = mock(PicassoWrapper.class);
        mView.mThumbnail = mock(ImageView.class);
        mView.mTitle = mock(TextView.class);
        mView.mDescription = mock(TextView.class);
    }

    @Test
    public void testBind() {
        FeedMessage feedMessage = mock(FeedMessage.class);
        when(feedMessage.getThumbnail()).thenReturn(16);
        when(feedMessage.getTitle()).thenReturn("Title");
        when(feedMessage.getDescription()).thenReturn("Description");

        Picasso picasso = mock(Picasso.class);
        when(mView.mPicassoWrapper.getPicasso()).thenReturn(picasso);

        RequestCreator requestCreator = mock(RequestCreator.class);
        when(picasso.load(eq(feedMessage.getThumbnail()))).thenReturn(requestCreator);

        mView.bind(feedMessage);

        InOrder inOrder = inOrder(picasso, requestCreator, mView.mPicassoWrapper, mView.mTitle, mView.mDescription);
        inOrder.verify(mView.mPicassoWrapper).getPicasso();
        inOrder.verify(picasso).load(eq(feedMessage.getThumbnail()));
        inOrder.verify(requestCreator).into(eq(mView.mThumbnail));
        inOrder.verify(mView.mTitle).setText(eq(feedMessage.getTitle()));
        inOrder.verify(mView.mDescription).setText(eq(feedMessage.getDescription()));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mView.mPicassoWrapper, mView.mTitle, mView.mDescription);
    }
}