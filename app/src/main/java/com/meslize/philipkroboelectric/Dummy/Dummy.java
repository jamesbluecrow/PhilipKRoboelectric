package com.meslize.philipkroboelectric.dummy;

import com.meslize.philipkroboelectric.R;
import com.meslize.philipkroboelectric.model.FeedMessage;
import com.meslize.philipkroboelectric.model.FeedMessageImpl;
import com.meslize.philipkroboelectric.model.Story;
import com.meslize.philipkroboelectric.model.StoryImpl;
import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.model.UserInfoImpl;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

@EBean (scope = EBean.Scope.Singleton)
public class Dummy {

    public UserInfo getUser() {
        UserInfo userInfo = new UserInfoImpl();
        userInfo.setEmail("philipkdick@gmail.com");
        userInfo.setName("Philip K. Dick");
        userInfo.setCity("Chicago");

        return userInfo;
    }

    public List<FeedMessage> getFeed() {
        List<FeedMessage> result = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            FeedMessage feedMessage = new FeedMessageImpl();
            feedMessage.setId("16");
            feedMessage.setThumbnail(R.drawable.ic_roboelectric);
            feedMessage.setTitle("Roboelectric");
            feedMessage.setDescription("Is something awesome!!!");

            result.add(feedMessage);
        }

        return result;
    }

    public Story getStory(String id) {
        Story story = new StoryImpl();
        story.setId(id);
        story.setAuthor("Philip K. Dick");
        story.setImage(R.drawable.ic_roboelectric_detail);
        story.setTitle("Roboelectric is something awesome!!!, Test-Drive Your Android Code");
        story.setDate("April 19th, 2015");
        story.setContent("Running tests on an Android emulator or device is slow! Building, deploying, and launching " +
                                 "the app often takes a minute or more. That's no way to do TDD. There must be a " +
                                 "better way.\n" +
                                 "\n" +
                                 "Wouldn't it be nice to run your Android tests directly from inside your IDE? " +
                                 "Perhaps you've tried, and been thwarted by the dreaded java.lang.RuntimeException: " +
                                 "Stub!?\n" +
                                 "\n" +
                                 "Robolectric is a unit test framework that de-fangs the Android SDK jar so you can " +
                                 "test-drive the development of your Android app. Tests run inside the JVM on your " +
                                 "workstation in seconds. With Robolectric you can write tests like this:");

        return story;
    }
}
