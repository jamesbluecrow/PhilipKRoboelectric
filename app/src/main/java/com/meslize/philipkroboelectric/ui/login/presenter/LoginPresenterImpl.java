package com.meslize.philipkroboelectric.ui.login.presenter;

import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.ui.login.interactor.LoginInteractor;
import com.meslize.philipkroboelectric.ui.login.interactor.LoginInteractorImpl;
import com.meslize.philipkroboelectric.ui.login.listener.OnLoginListener;
import com.meslize.philipkroboelectric.ui.login.view.LoginView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class LoginPresenterImpl implements LoginPresenter, OnLoginListener {

    LoginView mView;

    @Bean (LoginInteractorImpl.class) LoginInteractor mInteractor;

    @Override
    public void initialize(LoginView view) {
        mView = view;
    }

    @Override
    public void login(String username, String password) {
        mInteractor.login(username, password, this);
    }

    @Override
    public void onLoginSuccess(UserInfo userInfo) {
        mView.startFeedScreen(userInfo);
    }

    @Override
    public void onLoginError() {
        mView.showLoginError();
    }
}
