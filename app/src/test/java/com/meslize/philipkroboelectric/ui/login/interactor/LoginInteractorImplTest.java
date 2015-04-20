package com.meslize.philipkroboelectric.ui.login.interactor;

import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.repository.user.UserRepository;
import com.meslize.philipkroboelectric.ui.login.listener.OnLoginListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class LoginInteractorImplTest {

    private LoginInteractorImpl mInteractor;

    @Before
    public void setUp() {
        mInteractor = new LoginInteractorImpl();
        mInteractor.mUserRepository = mock(UserRepository.class);
    }

    @Test
    public void testLogin() {
        String username = "USERNAME";
        String password = "PASSWORD";
        OnLoginListener listener = mock(OnLoginListener.class);

        UserInfo userInfo = mock(UserInfo.class);
        when(mInteractor.mUserRepository.remoteGetUser(eq(username), eq(password))).thenReturn(userInfo);

        mInteractor.login(username, password, listener);

        InOrder inOrder = inOrder(listener, mInteractor.mUserRepository);
        inOrder.verify(mInteractor.mUserRepository).remoteGetUser(eq(username), eq(password));
        inOrder.verify(listener).onLoginSuccess(eq(userInfo));
        inOrder.verifyNoMoreInteractions();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mInteractor.mUserRepository);
    }
}