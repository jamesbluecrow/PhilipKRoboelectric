package com.meslize.philipkroboelectric.repository.story;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class StoryRepositoryImplTest {

    private StoryRepositoryImpl mRepository;

    @Before
    public void setUp() {
        mRepository = new StoryRepositoryImpl();
        mRepository.mLocalRepository = mock(LocalRepository.class);
    }

    @Test
    public void testLocalGetStory() {
        String id = "ID";

        mRepository.localGetStory(id);

        verify(mRepository.mLocalRepository).getStory(eq(id));

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mRepository.mLocalRepository);
    }
}