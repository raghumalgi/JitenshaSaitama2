/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crossover.assignment.jitenshasaitama.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.crossover.assignment.jitenshasaitama.data.BikerServiceApi;
import com.crossover.assignment.jitenshasaitama.data.LoginCredentails;
import com.crossover.assignment.jitenshasaitama.data.LoginResponse;
import com.crossover.assignment.jitenshasaitama.data.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Listens to user actions from the UI ({@link LoginFragment}), retrieves the data and updates
 * the UI as required.
 */
public class LoginPresenter implements LoginContract.LoginInteractor {


    private final LoginContract.LoginView mLoginView;


    public LoginPresenter(@NonNull LoginContract.LoginView mLoginView) {
        this.mLoginView = mLoginView;


    }




    @Override
    public void validateCredentails(String username, String password) {
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mLoginView.passwordError();
            return;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            mLoginView.emailError();
            return;
        } else if (!isEmailValid(username)) {
            mLoginView.emailError();
            return;
        }

        BikerServiceApi stackOverflowAPI = ServiceGenerator.createService(BikerServiceApi.class);
        LoginCredentails creds = new LoginCredentails(username,password);

        Call<LoginResponse> call = stackOverflowAPI.getUser(creds);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                //Log.d("Test","Loing "+response.body().accessToken);
                mLoginView.onLoginSuccess(response.body().accessToken);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginView.onLoginError("");
            }




    });
    }

    @Override
    public void onLoginButtonClicked() {



    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}
