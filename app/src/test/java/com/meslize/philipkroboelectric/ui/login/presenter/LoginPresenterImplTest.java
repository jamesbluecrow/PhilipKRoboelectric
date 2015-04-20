package com.meslize.philipkroboelectric.ui.login.presenter;

import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.ui.login.interactor.LoginInteractor;
import com.meslize.philipkroboelectric.ui.login.view.LoginView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class LoginPresenterImplTest {

    private LoginPresenterImpl mPresenter;

    @Before
    public void setUp() {
        mPresenter = new LoginPresenterImpl();
        mPresenter.mView = mock(LoginView.class);
        mPresenter.mInteractor = mock(LoginInteractor.class);
    }

    @Test
    public void testInitialize() {
        LoginView view = mock(LoginView.class);

        mPresenter.initialize(view);

        verifyNoMoreInteractionsWithMockObjects();

        assertEquals(view, mPresenter.mView);
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mPresenter.mView, mPresenter.mInteractor);
    }

    @Test
    public void testLogin() {
        String username = "USERNAME";
        String password = "PASSWORD";

        mPresenter.login(username, password);

        verify(mPresenter.mInteractor).login(eq(username), eq(password), eq(mPresenter));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testOnLoginSuccess() {
        UserInfo userInfo = mock(UserInfo.class);

        mPresenter.onLoginSuccess(userInfo);

        verify(mPresenter.mView).startFeedScreen(eq(userInfo));

        verifyNoMoreInteractionsWithMockObjects();
    }

    @Test
    public void testOnLoginError() {
        mPresenter.onLoginError();

        verify(mPresenter.mView).showLoginError();

        verifyNoMoreInteractionsWithMockObjects();
    }
}