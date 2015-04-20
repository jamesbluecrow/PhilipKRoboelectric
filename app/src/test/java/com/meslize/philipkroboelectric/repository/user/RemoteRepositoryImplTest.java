package com.meslize.philipkroboelectric.repository.user;

import com.meslize.philipkroboelectric.dummy.Dummy;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class RemoteRepositoryImplTest {

    private RemoteRepositoryImpl mRepository;

    @Before
    public void setUp() {
        mRepository = new RemoteRepositoryImpl();
        mRepository.mDummy = mock(Dummy.class);
    }

    @Test
    public void testGetUser() {
        String username = "USERNAME";
        String password = "PASSWORD";

        mRepository.getUser(username, password);

        verify(mRepository.mDummy).getUser();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mRepository.mDummy);
    }
}