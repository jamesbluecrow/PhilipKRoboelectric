package com.meslize.philipkroboelectric.ui.login;

import android.content.Intent;
import android.text.Editable;
import android.widget.EditText;

import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.model.UserInfoImpl;
import com.meslize.philipkroboelectric.ui.feed.FeedActivity_;
import com.meslize.philipkroboelectric.ui.login.presenter.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith (RobolectricTestRunner.class)
@Config (manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class LoginActivityTest {

    private LoginActivity mActivity;

    @Before
    public void setUp() {
        mActivity = new LoginActivity();
        mActivity.mPresenter = mock(LoginPresenter.class);
        mActivity.mUsername = mock(EditText.class);
        mActivity.mPassword = mock(EditText.class);
    }

    @Test
    public void testAfterInject() {
        mActivity.afterInject();

        verify(mActivity.mPresenter).initialize(eq(mActivity));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mActivity.mPresenter, mActivity.mUsername, mActivity.mPassword);
    }

    @Test
    public void testClickLogin() {
        String username = "USERNAME";
        String password = "PASSWORD";

        Editable editableUsername = mock(Editable.class);
        when(mActivity.mUsername.getText()).thenReturn(editableUsername);
        when(editableUsername.toString()).thenReturn(username);

        Editable editablePassword = mock(Editable.class);
        when(mActivity.mPassword.getText()).thenReturn(editablePassword);
        when(editablePassword.toString()).thenReturn(password);

        mActivity.clickLogin();

        InOrder inOrder = inOrder(mActivity.mUsername, mActivity.mPassword, mActivity.mPresenter);
        inOrder.verify(mActivity.mUsername).getText();
        inOrder.verify(mActivity.mPassword).getText();
        inOrder.verify(mActivity.mPresenter).login(eq(username), eq(password));
        inOrder.verifyNoMoreInteractions();

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testStartFeedScreen() {
        UserInfo userInfo = mock(UserInfoImpl.class);

        LoginActivity_ activity = Robolectric.setupActivity(LoginActivity_.class);
        activity.startFeedScreen(userInfo);

        Intent intent = Robolectric.shadowOf(activity).peekNextStartedActivity();
        assertEquals(FeedActivity_.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void testShowLoginError() {
        mActivity.showLoginError();

        verifyNoMoreInteractionsWithMockObjects();
    }
}