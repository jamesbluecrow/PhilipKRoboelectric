package com.meslize.philipkroboelectric.model;

import java.io.Serializable;

public class UserInfoImpl implements UserInfo, Serializable {
    String mEmail;
    String mName;
    String mCity;

    @Override
    public String getEmail() {
        return mEmail;
    }

    @Override
    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }

    @Override
    public String getCity() {
        return mCity;
    }

    @Override
    public void setCity(String city) {
        mCity = city;
    }
}
