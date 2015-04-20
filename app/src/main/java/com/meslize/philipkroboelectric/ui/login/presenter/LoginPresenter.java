package com.meslize.philipkroboelectric.ui.login.presenter;

import com.meslize.philipkroboelectric.ui.login.view.LoginView;

public interface LoginPresenter {
    void initialize(LoginView view);

    void login(String username, String password);
}
