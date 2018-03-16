package com.example.user.dvectn.Retrofit;

import android.util.Log;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public class NetworkConnectionManager {

    public NetworkConnectionManager(){

    }

    public void callServerLogin(final OnNetworkCallbackLoginListener listener, String username, String password) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiLogin callapi = retrofit.create(ApiLogin.class);

        Call call = callapi.loginHandle(username, password);
        call.enqueue(new Callback<Login>() {

            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                try{

                    if(response.code() == 200)
                    {
                        Log.e("Network connected","Response code = "+response.code());
                        Login loginRes = (Login) response.body();


                        ResponseBody responseBody = response.errorBody();

                        if(responseBody != null){
                            listener.onBodyError(responseBody);
                        }else if(responseBody == null ) {
                            listener.onBodyErrorIsNull();
                        }

                        listener.onResponse(loginRes);
//                        Toast.makeText(context, ""+loginRes.getToken(), Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                try{

                    listener.onFailure(t);
                }catch (Exception e){
                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
}
