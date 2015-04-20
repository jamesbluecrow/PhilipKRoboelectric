package com.meslize.philipkroboelectric.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInfoImplTest {

    private static final String EMAIL = "EMAIL";
    private static final String NAME = "NAME";
    private static final String CITY = "CITY";

    @Test
    public void testGetEmail() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.mEmail = EMAIL;

        assertEquals(EMAIL, userInfo.getEmail());
    }

    @Test
    public void testSetEmail() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.setEmail(EMAIL);

        assertEquals(EMAIL, userInfo.mEmail);
    }

    @Test
    public void testGetName() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.mName = NAME;

        assertEquals(NAME, userInfo.getName());
    }

    @Test
    public void testSetName() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.setName(NAME);

        assertEquals(NAME, userInfo.mName);
    }

    @Test
    public void testGetCity() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.mCity = CITY;

        assertEquals(CITY, userInfo.getCity());
    }

    @Test
    public void testSetCity() {
        UserInfoImpl userInfo = new UserInfoImpl();
        userInfo.setCity(CITY);

        assertEquals(CITY, userInfo.mCity);
    }
}