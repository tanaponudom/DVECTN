package ctn.example.user.dvectn.Retrofit;

import ctn.example.user.dvectn.POJO.POJO_Checkdaily;


import okhttp3.ResponseBody;

public interface OnNetworkCallback_Checkdaily_D1 {
    public void onResponse(POJO_Checkdaily Checkdaily);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
