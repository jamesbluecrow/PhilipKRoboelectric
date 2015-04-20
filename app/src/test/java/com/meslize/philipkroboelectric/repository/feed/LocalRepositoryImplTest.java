package com.meslize.philipkroboelectric.repository.feed;

import com.meslize.philipkroboelectric.dummy.Dummy;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class LocalRepositoryImplTest {

    private LocalRepositoryImpl mRepository;

    @Before
    public void setUp() {
        mRepository = new LocalRepositoryImpl();
        mRepository.mDummy = mock(Dummy.class);
    }

    @Test
    public void testGetFeed() {
        mRepository.getFeed();

        verify(mRepository.mDummy).getFeed();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mRepository.mDummy);
    }
}