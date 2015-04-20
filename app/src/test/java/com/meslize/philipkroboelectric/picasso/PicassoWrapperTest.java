package com.meslize.philipkroboelectric.picasso;

import com.squareup.picasso.Picasso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class PicassoWrapperTest {

    @Test
    public void testGetPicasso() {
        PicassoWrapper picassoWrapper = new PicassoWrapper();
        picassoWrapper.mContext = Robolectric.application;

        Picasso result = picassoWrapper.getPicasso();

        assertNotNull(result);
    }
}