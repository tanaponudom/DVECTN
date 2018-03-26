package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.POJO.ResPOJO;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by User on 26/3/2561.
 */

public interface OnNetworkCallBackGetStd {

    public void onResponse(List<POJO_getstu> getstu);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);


}
