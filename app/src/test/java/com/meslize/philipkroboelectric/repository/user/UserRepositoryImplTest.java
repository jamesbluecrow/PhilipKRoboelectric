package com.meslize.philipkroboelectric.repository.user;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class UserRepositoryImplTest {

    private UserRepositoryImpl mRepository;

    @Before
    public void setUp() {
        mRepository = new UserRepositoryImpl();
        mRepository.mRemoteRepository = mock(RemoteRepository.class);
    }

    @Test
    public void testRemoteGetUser() {
        String username = "USERNAME";
        String password = "PASSWORD";

        mRepository.remoteGetUser(username, password);

        verify(mRepository.mRemoteRepository).getUser(eq(username), eq(password));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mRepository.mRemoteRepository);
    }
}