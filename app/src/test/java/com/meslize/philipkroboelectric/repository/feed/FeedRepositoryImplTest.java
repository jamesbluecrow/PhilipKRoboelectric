package com.meslize.philipkroboelectric.repository.feed;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class FeedRepositoryImplTest {

    private FeedRepositoryImpl mRepository;

    @Before
    public void setUp() {
        mRepository = new FeedRepositoryImpl();
        mRepository.mLocalRepository = mock(LocalRepository.class);
    }

    @Test
    public void testLocalGetFeed() {
        mRepository.localGetFeed();

        verify(mRepository.mLocalRepository).getFeed();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mRepository.mLocalRepository);
    }
}