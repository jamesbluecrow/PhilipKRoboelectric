package com.meslize.philipkroboelectric.repository.user;

import com.meslize.philipkroboelectric.model.UserInfo;

public interface UserRepository {
    UserInfo remoteGetUser(String username, String password);
}
