package com.example.user.dvectn.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public interface ApiLogin {

    @FormUrlEncoded
    @POST("login/")
    Call<Login> loginHandle(@Field("Username") String first, @Field("Password") String last);

}
