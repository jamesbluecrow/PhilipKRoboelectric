package com.meslize.philipkroboelectric.ui.story.interactor;

import com.meslize.philipkroboelectric.model.Story;
import com.meslize.philipkroboelectric.repository.story.StoryRepository;
import com.meslize.philipkroboelectric.ui.story.listener.OnLoadStoryListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class StoryInteractorImplTest {

    private StoryInteractorImpl mInteractor;

    @Before
    public void setUp() {
        mInteractor = new StoryInteractorImpl();
        mInteractor.mStoryRepository = mock(StoryRepository.class);
    }

    @Test
    public void testGetStory() {
        String id = "ID";
        OnLoadStoryListener listener = mock(OnLoadStoryListener.class);

        Story story = mock(Story.class);
        when(mInteractor.mStoryRepository.localGetStory(eq(id))).thenReturn(story);

        mInteractor.getStory(id, listener);

        InOrder inOrder = inOrder(listener, mInteractor.mStoryRepository);
        inOrder.verify(mInteractor.mStoryRepository).localGetStory(eq(id));
        inOrder.verify(listener).onLoadStorySuccess(eq(story));
        inOrder.verifyNoMoreInteractions();

        verifyNoMoreInteractionsWithMockObjects();
    }

    private void verifyNoMoreInteractionsWithMockObjects() {
        verifyNoMoreInteractions(mInteractor.mStoryRepository);
    }
}