package com.meslize.philipkroboelectric.repository.user;

import com.meslize.philipkroboelectric.dummy.Dummy;
import com.meslize.philipkroboelectric.model.UserInfo;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
class RemoteRepositoryImpl implements RemoteRepository {

    @Bean Dummy mDummy;

    @Override
    public UserInfo getUser(String username, String password) {
        return mDummy.getUser();
    }
}
