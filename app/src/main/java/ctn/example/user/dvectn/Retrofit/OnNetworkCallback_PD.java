package ctn.example.user.dvectn.Retrofit;

import okhttp3.ResponseBody;

public interface OnNetworkCallback_PD {

    public void onResponse( );
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}
