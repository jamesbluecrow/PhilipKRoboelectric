package com.meslize.philipkroboelectric.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class FeedMessageImplTest {

    private static final String ID = "ID";
    private static final int THUMBNAIL = 16;
    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "TITLE";

    @Test
    public void testGetId() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.mId = ID;

        assertEquals(ID, feedMessage.getId());
    }

    @Test
    public void testSetId() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.setId(ID);

        assertEquals(ID, feedMessage.mId);
    }

    @Test
    public void testGetThumbnail() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.mThumbnail = THUMBNAIL;

        assertEquals(THUMBNAIL, feedMessage.getThumbnail());
    }

    @Test
    public void testSetThumbnail() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.setThumbnail(THUMBNAIL);

        assertEquals(THUMBNAIL, feedMessage.mThumbnail);
    }

    @Test
    public void testGetTitle() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.mTitle = TITLE;

        assertEquals(TITLE, feedMessage.getTitle());
    }

    @Test
    public void testSetTitle() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.setTitle(TITLE);

        assertEquals(TITLE, feedMessage.mTitle);
    }

    @Test
    public void testGetDescription() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.mDescription = DESCRIPTION;

        assertEquals(DESCRIPTION, feedMessage.getDescription());
    }

    @Test
    public void testSetDescription() {
        FeedMessageImpl feedMessage = new FeedMessageImpl();
        feedMessage.setDescription(DESCRIPTION);

        assertEquals(DESCRIPTION, feedMessage.mDescription);
    }
}