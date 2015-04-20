package com.meslize.philipkroboelectric.repository.user;

import com.meslize.philipkroboelectric.model.UserInfo;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class UserRepositoryImpl implements UserRepository {

    @Bean (RemoteRepositoryImpl.class) RemoteRepository mRemoteRepository;

    @Override
    public UserInfo remoteGetUser(String username, String password) {
        return mRemoteRepository.getUser(username, password);
    }
}
