package com.meslize.philipkroboelectric.picasso;

import android.content.Context;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class PicassoWrapper {
    @RootContext Context mContext;

    public Picasso getPicasso() {
        return Picasso.with(mContext);
    }
}
