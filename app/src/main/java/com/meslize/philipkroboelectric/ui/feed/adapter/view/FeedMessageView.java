package com.meslize.philipkroboelectric.ui.feed.adapter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meslize.philipkroboelectric.R;
import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.picasso.PicassoWrapper;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup (R.layout.view_feed_message)
public class FeedMessageView extends LinearLayout {

    @Bean PicassoWrapper mPicassoWrapper;

    @ViewById (R.id.thumbnail) ImageView mThumbnail;
    @ViewById (R.id.title) TextView mTitle;
    @ViewById (R.id.description) TextView mDescription;

    public FeedMessageView(Context context) {
        super(context);
    }

    public FeedMessageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FeedMessageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(FeedMessage feedMessage) {
        mPicassoWrapper.getPicasso().load(feedMessage.getThumbnail()).into(mThumbnail);
        mTitle.setText(feedMessage.getTitle());
        mDescription.setText(feedMessage.getDescription());
    }
}