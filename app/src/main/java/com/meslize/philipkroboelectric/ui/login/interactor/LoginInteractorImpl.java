package com.meslize.philipkroboelectric.ui.login.interactor;

import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.repository.user.UserRepository;
import com.meslize.philipkroboelectric.repository.user.UserRepositoryImpl;
import com.meslize.philipkroboelectric.ui.login.listener.OnLoginListener;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class LoginInteractorImpl implements LoginInteractor {

    @Bean (UserRepositoryImpl.class) UserRepository mUserRepository;

    @Override
    public void login(String username, String password, OnLoginListener listener) {
        UserInfo userInfo = mUserRepository.remoteGetUser(username, password);

        if (userInfo == null) {
            listener.onLoginError();
            return;
        }

        listener.onLoginSuccess(userInfo);
    }
}
