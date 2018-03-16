package com.example.user.dvectn.Retrofit;

import okhttp3.ResponseBody;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public interface OnNetworkCallbackLoginListener {

    public void onResponse(Login loginRes);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);


}
