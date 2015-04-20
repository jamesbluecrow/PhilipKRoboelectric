package com.meslize.philipkroboelectric.repository.user;

import com.meslize.philipkroboelectric.model.UserInfo;

interface RemoteRepository {
    UserInfo getUser(String username, String password);
}
