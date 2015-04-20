package com.meslize.philipkroboelectric.ui.login.listener;

import com.meslize.philipkroboelectric.model.UserInfo;

public interface OnLoginListener {
    void onLoginSuccess(UserInfo userInfo);

    void onLoginError();
}
