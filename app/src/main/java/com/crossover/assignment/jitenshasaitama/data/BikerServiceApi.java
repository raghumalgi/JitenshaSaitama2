package com.crossover.assignment.jitenshasaitama.data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface BikerServiceApi {

    @POST("/api/v1/register")
    Call<LoginResponse> getUser(@Body LoginCredentails user);
}