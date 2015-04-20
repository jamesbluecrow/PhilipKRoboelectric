package com.meslize.philipkroboelectric.ui.login;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.meslize.philipkroboelectric.R;
import com.meslize.philipkroboelectric.model.UserInfo;
import com.meslize.philipkroboelectric.ui.feed.FeedActivity_;
import com.meslize.philipkroboelectric.ui.login.presenter.LoginPresenter;
import com.meslize.philipkroboelectric.ui.login.presenter.LoginPresenterImpl;
import com.meslize.philipkroboelectric.ui.login.view.LoginView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_login)
public class LoginActivity extends Activity implements LoginView {

    @Bean (LoginPresenterImpl.class) LoginPresenter mPresenter;

    @ViewById (R.id.username) EditText mUsername;
    @ViewById (R.id.password) EditText mPassword;

    @AfterInject
    void afterInject() {
        mPresenter.initialize(this);
    }

    @Click (R.id.button_login)
    void clickLogin() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        mPresenter.login(username, password);
    }

    @Override
    public void startFeedScreen(UserInfo userInfo) {
        FeedActivity_.intent(this).start();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "User and password don't match", Toast.LENGTH_SHORT).show();
    }
}
