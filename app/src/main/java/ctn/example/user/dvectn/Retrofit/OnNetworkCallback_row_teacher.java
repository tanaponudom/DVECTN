package ctn.example.user.dvectn.Retrofit;


import ctn.example.user.dvectn.POJO.POJO_row_teacher;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_row_teacher {


    public void onResponse(POJO_row_teacher save_nite);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
