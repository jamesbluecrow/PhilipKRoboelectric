package com.meslize.philipkroboelectric.ui.login.view;

import com.meslize.philipkroboelectric.model.UserInfo;

public interface LoginView {
    void startFeedScreen(UserInfo userInfo);

    void showLoginError();
}
