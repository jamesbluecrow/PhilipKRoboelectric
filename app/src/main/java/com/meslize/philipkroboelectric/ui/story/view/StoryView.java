package com.meslize.philipkroboelectric.ui.story.view;

public interface StoryView {
    void showImage(int image);

    void showTitle(String title);

    void showAuthor(String author);

    void showDate(String date);

    void showContent(String content);

    void showLoadStoryError();
}
