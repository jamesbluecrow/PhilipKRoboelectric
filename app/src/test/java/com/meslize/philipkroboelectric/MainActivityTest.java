package com.meslize.philipkroboelectric;

import com.meslize.philipkroboelectric.ui.login.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class MainActivityTest {

    @Test
    public void testSomething() throws Exception {
        assertTrue(Robolectric.buildActivity(LoginActivity.class).create().get() != null);
    }
}