package com.meslize.philipkroboelectric.ui.login.interactor;

import com.meslize.philipkroboelectric.ui.login.listener.OnLoginListener;

public interface LoginInteractor {
    void login(String username, String password, OnLoginListener listener);
}
