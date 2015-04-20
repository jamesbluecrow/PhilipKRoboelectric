package com.meslize.philipkroboelectric.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoryImplTest {

    private static final String ID = "ID";
    private static final String AUTHOR = "AUTHOR";
    private static final int IMAGE = 16;
    private static final String TITLE = "TITLE";
    private static final String DATE = "DATE";
    private static final String CONTENT = "CONTENT";

    @Test
    public void testGetId() {
        StoryImpl story = new StoryImpl();
        story.mId = ID;

        assertEquals(ID, story.getId());
    }

    @Test
    public void testSetId() {
        StoryImpl story = new StoryImpl();
        story.setId(ID);

        assertEquals(ID, story.mId);
    }

    @Test
    public void testGetAuthor() {
        StoryImpl story = new StoryImpl();
        story.mAuthor = AUTHOR;

        assertEquals(AUTHOR, story.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        StoryImpl story = new StoryImpl();
        story.setAuthor(AUTHOR);

        assertEquals(AUTHOR, story.mAuthor);
    }

    @Test
    public void testGetImage() {
        StoryImpl story = new StoryImpl();
        story.mImage = IMAGE;

        assertEquals(IMAGE, story.getImage());
    }

    @Test
    public void testSetImage() {
        StoryImpl story = new StoryImpl();
        story.setImage(IMAGE);

        assertEquals(IMAGE, story.mImage);
    }

    @Test
    public void testGetTitle() {
        StoryImpl story = new StoryImpl();
        story.mTitle = TITLE;

        assertEquals(TITLE, story.getTitle());
    }

    @Test
    public void testSetTitle() {
        StoryImpl story = new StoryImpl();
        story.setTitle(TITLE);

        assertEquals(TITLE, story.mTitle);
    }

    @Test
    public void testGetDate() {
        StoryImpl story = new StoryImpl();
        story.mDate = DATE;

        assertEquals(DATE, story.getDate());
    }

    @Test
    public void testSetDate() {
        StoryImpl story = new StoryImpl();
        story.setDate(DATE);

        assertEquals(DATE, story.mDate);
    }

    @Test
    public void testGetContent() {
        StoryImpl story = new StoryImpl();
        story.mContent = CONTENT;

        assertEquals(CONTENT, story.getContent());
    }

    @Test
    public void testSetContent() {
        StoryImpl story = new StoryImpl();
        story.setContent(CONTENT);

        assertEquals(CONTENT, story.mContent);
    }
}