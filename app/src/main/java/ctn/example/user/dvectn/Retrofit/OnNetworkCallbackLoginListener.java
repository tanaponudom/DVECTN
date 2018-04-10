package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_login;

import okhttp3.ResponseBody;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public interface OnNetworkCallbackLoginListener {

    public void onResponse(POJO_login loginRes);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);




}
