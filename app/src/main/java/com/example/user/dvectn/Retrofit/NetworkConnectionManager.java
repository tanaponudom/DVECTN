package com.example.user.dvectn.Retrofit;

import android.util.Log;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Student_save;
import com.example.user.dvectn.POJO.POJO_login;
import com.example.user.dvectn.POJO.ResPOJO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
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
        call.enqueue(new Callback<POJO_login>() {

            @Override
            public void onResponse(Call<POJO_login> call, Response<POJO_login> response) {

                try{

                    POJO_login loginRes = (POJO_login) response.body();

                    if(response.code() != 200)
                    {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if(responseBody != null){
                            listener.onBodyError(responseBody);
                        }else if(responseBody == null ) {
                            listener.onBodyErrorIsNull();
                        }


//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    }else {
                        listener.onResponse(loginRes);
                    }

                }catch (Exception e){
                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_login> call, Throwable t) {
                try{

                    listener.onFailure(t);

                }catch (Exception e){

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }


    public void pushImage(

            final OnNetworkCallbackListener listener
            , MultipartBody.Part img
            , String user_id
            , String app_name
            ,String app_detail
    ){


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiLogin git = retrofit.create(ApiLogin.class);
        Call call = git.updateImageProfile(img,user_id,app_name,app_detail);
        call.enqueue(new Callback<ResPOJO>() {

            @Override
            public void onResponse(Call<ResPOJO> call, Response<ResPOJO> response) {

                ResPOJO res = response.body();
//                Log.e("TAG",res.getStatus());
//
                if (res == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(response.body(), retrofit);
                    Log.e("ResNet",""+res.getUrl());
                }

            }

            @Override
            public void onFailure(Call<ResPOJO> call, Throwable t) {
                listener.onFailure(t);
//                Log.e("NWMG",t.getMessage());
            }
        });

    }
}
