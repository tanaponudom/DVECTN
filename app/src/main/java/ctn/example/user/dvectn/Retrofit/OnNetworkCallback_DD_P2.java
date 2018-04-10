package ctn.example.user.dvectn.Retrofit;


import ctn.example.user.dvectn.POJO.POJO_DD_P2;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_DD_P2 {

    public void onResponse(POJO_DD_P2 assessmentstu2);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
