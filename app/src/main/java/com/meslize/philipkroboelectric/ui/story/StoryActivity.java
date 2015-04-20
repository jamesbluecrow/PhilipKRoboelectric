package com.meslize.philipkroboelectric.ui.story;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.meslize.philipkroboelectric.R;
import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.picasso.PicassoWrapper;
import com.meslize.philipkroboelectric.ui.story.presenter.StoryPresenter;
import com.meslize.philipkroboelectric.ui.story.presenter.StoryPresenterImpl;
import com.meslize.philipkroboelectric.ui.story.view.StoryView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_story)
public class StoryActivity extends Activity implements StoryView {

    @Extra FeedMessage mFeedMessage;

    @Bean (StoryPresenterImpl.class) StoryPresenter mPresenter;
    @Bean PicassoWrapper mPicassoWrapper;

    @ViewById (R.id.image) ImageView mImage;
    @ViewById (R.id.title) TextView mTitle;
    @ViewById (R.id.author) TextView mAuthor;
    @ViewById (R.id.date) TextView mDate;
    @ViewById (R.id.content) TextView mContent;

    @AfterInject
    void afterInject() {
        mPresenter.initialize(this);
    }

    @AfterViews
    void afterViews() {
        mPresenter.loadStory(mFeedMessage);
    }

    @Override
    public void showImage(int image) {
        mPicassoWrapper.getPicasso().load(image).into(mImage);
    }

    @Override
    public void showTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void showAuthor(String author) {
        mAuthor.setText(author);
    }

    @Override
    public void showDate(String date) {
        mDate.setText(date);
    }

    @Override
    public void showContent(String content) {
        mContent.setText(content);
    }

    @Override
    public void showLoadStoryError() {
        Toast.makeText(this, "Error loading the story!", Toast.LENGTH_SHORT).show();
    }
}
