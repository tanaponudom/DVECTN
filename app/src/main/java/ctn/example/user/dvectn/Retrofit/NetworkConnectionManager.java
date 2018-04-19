package ctn.example.user.dvectn.Retrofit;

import android.util.Log;

import ctn.example.user.dvectn.Fragment.Fragment_login;
import ctn.example.user.dvectn.POJO.POJOGetDaily;
import ctn.example.user.dvectn.POJO.POJO_AF_teacher;
import ctn.example.user.dvectn.POJO.POJO_Checkdaily;
import ctn.example.user.dvectn.POJO.POJO_DD_P1;
import ctn.example.user.dvectn.POJO.POJO_DD_P2;
import ctn.example.user.dvectn.POJO.POJO_DD_P3;
import ctn.example.user.dvectn.POJO.POJO_PJ_P1;
import ctn.example.user.dvectn.POJO.POJO_PJ_P2;
import ctn.example.user.dvectn.POJO.POJO_PJ_P3;
import ctn.example.user.dvectn.POJO.POJO_PJ_P4;
import ctn.example.user.dvectn.POJO.POJO_PJ_P5;
import ctn.example.user.dvectn.POJO.POJO_PJ_P6;
import ctn.example.user.dvectn.POJO.POJO_Stu_naja;
import ctn.example.user.dvectn.POJO.POJO_Stu_naja_gogo;
import ctn.example.user.dvectn.POJO.POJO_confirm_AG;
import ctn.example.user.dvectn.POJO.POJO_getstu;
import ctn.example.user.dvectn.POJO.POJO_getstuemp;
import ctn.example.user.dvectn.POJO.POJO_login;
import ctn.example.user.dvectn.POJO.POJO_row_teacher;
import ctn.example.user.dvectn.POJO.POJO_save_AG;
import ctn.example.user.dvectn.POJO.POJO_save_data_trainer;
import ctn.example.user.dvectn.POJO.POJO_test1_in_ag;
import ctn.example.user.dvectn.POJO.POJO_trainer;
import ctn.example.user.dvectn.POJO.POJO_trainer2;
import ctn.example.user.dvectn.POJO.ResPOJO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

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

    public NetworkConnectionManager() {

    }

    public void callServerLogin(final OnNetworkCallbackLoginListener listener, String username, String password) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.loginHandle(username, password);
        call.enqueue(new Callback<POJO_login>() {

            @Override
            public void onResponse(Call<POJO_login> call, Response<POJO_login> response) {

                try {

                    POJO_login loginRes = (POJO_login) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }


//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(loginRes);
                    }

                } catch (Exception e) {
                    Log.e("Network connect error", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_login> call, Throwable t) {
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }


    public void pushImage(

            final OnNetworkCallbackListener listener
            , MultipartBody.Part img
            , int user_id
            , String app_name
            , String app_detail
            , int dep_id

    ) {


        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APISERVER git = retrofit.create(APISERVER.class);
        Call call = git.updateImageProfile(img, user_id, app_name, app_detail , dep_id);
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
                    Log.e("ResNet", "" + res.getUrl());
                }

            }

            @Override
            public void onFailure(Call<ResPOJO> call, Throwable t) {
                listener.onFailure(t);
//                Log.e("NWMG",t.getMessage());
            }
        });

    }


    public void getStudentName(final OnNetworkCallBackGetStd listener, String depid) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getSTD(depid);


        call.enqueue(new Callback<List<POJO_getstu>>() {

            @Override
            public void onResponse(Call<List<POJO_getstu>> call, Response<List<POJO_getstu>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_getstu> stdRes = (List<POJO_getstu>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(stdRes);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_getstu>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }


    // get data std
    public void getDataStdDaily(final OnNetworkCallback_GetStdDaily listener, String depid , String date) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDatadaily(depid,date);


        call.enqueue(new Callback<List<POJOGetDaily>>() {

            @Override
            public void onResponse(Call<List<POJOGetDaily>> call, Response<List<POJOGetDaily>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJOGetDaily> stdRes =  response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(stdRes);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJOGetDaily>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void callServer_pj_p1(final OnNetworkCallback_PJ_P1 listener, int member_id, int ex11, int ex12) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataPJP1(member_id, ex11, ex12);
        call.enqueue(new Callback<POJO_PJ_P1>() {


            @Override
            public void onResponse(Call<POJO_PJ_P1> call, Response<POJO_PJ_P1> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_PJ_P1 assessmentstu1 = (POJO_PJ_P1) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(assessmentstu1);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_PJ_P1> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callServer_pj_p2(final OnNetworkCallback_PJ_P2 listener, int member_id, int ex21, int ex22, int ex23, int ex24, int ex25, int ex26, int ex27, int ex28) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataPJP2(member_id, ex21, ex22, ex23, ex24, ex25, ex26, ex27, ex28);
        call.enqueue(new Callback<POJO_PJ_P2>() {


            @Override
            public void onResponse(Call<POJO_PJ_P2> call, Response<POJO_PJ_P2> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_PJ_P2 assessmentstu2 = (POJO_PJ_P2) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(assessmentstu2);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_PJ_P2> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void callServer_pj_p3(final OnNetworkCallback_PJ_P3 listener, int member_id, int ex31, int ex32, int ex33, int ex34, int ex35, int ex36, int ex37) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataPJP3(member_id, ex31, ex32, ex33, ex34, ex35, ex36, ex37);
        call.enqueue(new Callback<POJO_PJ_P3>() {


            @Override
            public void onResponse(Call<POJO_PJ_P3> call, Response<POJO_PJ_P3> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_PJ_P3 assessmentstu3 = (POJO_PJ_P3) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(assessmentstu3);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_PJ_P3> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void callServer_pj_p4(final OnNetworkCallback_PJ_P4 listener, int member_id, int ex41, int ex42, int ex43, int ex44, int ex45, int ex46, int ex47) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataPJP4(member_id, ex41, ex42, ex43, ex44, ex45, ex46, ex47);
        call.enqueue(new Callback<POJO_PJ_P4>() {


            @Override
            public void onResponse(Call<POJO_PJ_P4> call, Response<POJO_PJ_P4> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_PJ_P4 assessmentstu4 = (POJO_PJ_P4) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(assessmentstu4);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_PJ_P4> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void callServer_pj_p5(final OnNetworkCallback_PJ_P5 listener, int member_id, int ex51, int ex52, int ex53, int ex54, int ex55, int ex56) {

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Fragment_login.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    APISERVER callapi = retrofit.create(APISERVER.class);

    Call call = callapi.getDataPJP5(member_id, ex51, ex52, ex53, ex54, ex55, ex56);
    call.enqueue(new Callback<POJO_PJ_P5>() {


        @Override
        public void onResponse(Call<POJO_PJ_P5> call, Response<POJO_PJ_P5> response) {
//                Log.e("onResponse",""+response.body());

            try {

                POJO_PJ_P5 assessmentstu5 = (POJO_PJ_P5) response.body();

                if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                    ResponseBody responseBody = response.errorBody();

                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else if (responseBody == null) {
                        listener.onBodyErrorIsNull();
                    }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                } else {
                    listener.onResponse(assessmentstu5);
                }

            } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
            }
        }

        @Override
        public void onFailure(Call<POJO_PJ_P5> call, Throwable t) {
            Log.e("NT", t.getMessage());
            try {

                listener.onFailure(t);

            } catch (Exception e) {

                listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
            }

        }
    });
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void callServer_pj_p6(final OnNetworkCallback_PJ_P6 listener, int member_id, int ex61, int ex62, int ex63, int ex64, int ex65, int ex66) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataPJP6(member_id, ex61, ex62, ex63, ex64, ex65, ex66);
        call.enqueue(new Callback<POJO_PJ_P6>() {


            @Override
            public void onResponse(Call<POJO_PJ_P6> call, Response<POJO_PJ_P6> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_PJ_P6 assessmentstu6 = (POJO_PJ_P6) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(assessmentstu6);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_PJ_P6> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public void callServer_bt_d1(final OnNetworkCallback_BT_D1 listener, int member_id, String  app_name, int app_date, String  app_detai) {
//
//    Gson gson = new GsonBuilder()
//            .setLenient()
//            .create();
//
//    final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(Fragment_login.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build();
//
//    APISERVER callapi = retrofit.create(APISERVER.class);
//
//    Call call = callapi.getDatadaily(member_id, app_name, app_date, app_detai);
//    call.enqueue(new Callback<POJO_Checkdaily>() {
//
//
//        @Override
//        public void onResponse(Call<POJO_Checkdaily> call, Response<POJO_Checkdaily> response) {
////                Log.e("onResponse",""+response.body());
//
//            try {
//
//                POJO_Checkdaily Checkdaily = (POJO_Checkdaily) response.body();
//
//                if (response.code() != 200) {
////                        Log.e("Network connected","Response code = "+response.code());
//
//                    ResponseBody responseBody = response.errorBody();
//
//                    if (responseBody != null) {
//                        listener.onBodyError(responseBody);
//                    } else if (responseBody == null) {
//                        listener.onBodyErrorIsNull();
//                    }
//
////                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
////                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
//                } else {
//                    listener.onResponse(Checkdaily);
//                }
//
//            } catch (Exception e) {
////                    Log.e("Network connect error",e.getMessage());
//            }
//        }
//
//        @Override
//        public void onFailure(Call<POJO_Checkdaily> call, Throwable t) {
//            Log.e("NT", t.getMessage());
//            try {
//
//                listener.onFailure(t);
//
//            } catch (Exception e) {
//
//                listener.onFailure(t);
////                    Log.e("Network connectLogin",t.getMessage());
//            }
//
//        }
//    });
//}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void callServer_test1_in_ag(final OnNetworkCallback_test1_in_ag listener, int member_id) {

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Fragment_login.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    APISERVER callapi = retrofit.create(APISERVER.class);

    Call call = callapi.getDatatest1(member_id);
    call.enqueue(new Callback<POJO_test1_in_ag>() {


        @Override
        public void onResponse(Call<POJO_test1_in_ag> call, Response<POJO_test1_in_ag> response) {
//                Log.e("onResponse",""+response.body());

            try {

                POJO_test1_in_ag test1 = (POJO_test1_in_ag) response.body();

                if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                    ResponseBody responseBody = response.errorBody();

                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else if (responseBody == null) {
                        listener.onBodyErrorIsNull();
                    }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                } else {
                    listener.onResponse(test1);
                }

            } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
            }
        }

        @Override
        public void onFailure(Call<POJO_test1_in_ag> call, Throwable t) {
            Log.e("NT", t.getMessage());
            try {

                listener.onFailure(t);

            } catch (Exception e) {

                listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
            }

        }
    });
}
/////////////////////////////////////////////////////////////////////////////////////////////////

    public  void  callServer_dd_p1(final OnNetworkCallback_DD_P1 listener, int member_id, int ex11, int ex12 , int ex13 , int ex14 , int ex15){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataDDP1(member_id,ex11,ex12,ex13,ex14,ex15);
        call.enqueue(new Callback <POJO_DD_P1>()   {


            @Override
            public void onResponse(Call<POJO_DD_P1> call, Response  <POJO_DD_P1> response ) {
//                Log.e("onResponse",""+response.body());

                try{

                    POJO_DD_P1 affective1 = (POJO_DD_P1) response.body();

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
                        listener.onResponse(affective1);
                    }

                }catch (Exception e){
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_DD_P1> call, Throwable t) {
                Log.e("NT",t.getMessage());
                try{

                    listener.onFailure(t);

                }catch (Exception e){

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public  void  callServer_dd_p2(final OnNetworkCallback_DD_P2 listener, int member_id, int ex22 , int ex23 , int ex24 , int ex25 , int ex26, int ex27, int ex28 , int ex29){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataDDP2(member_id,ex22,ex23,ex24,ex25,ex26,ex27,ex28,ex29);
        call.enqueue(new Callback <POJO_DD_P2>()   {


            @Override
            public void onResponse(Call<POJO_DD_P2> call, Response  <POJO_DD_P2> response ) {
//                Log.e("onResponse",""+response.body());

                try{

                    POJO_DD_P2 affective2 = (POJO_DD_P2) response.body();

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
                        listener.onResponse(affective2);
                    }

                }catch (Exception e){
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_DD_P2> call, Throwable t) {
                Log.e("NT",t.getMessage());
                try{

                    listener.onFailure(t);

                }catch (Exception e){

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


    public  void  callServer_dd_p3(final OnNetworkCallback_DD_P3 listener, int member_id, int ex31 , int ex32 , int ex33 , int ex34 , int ex35, int ex36, int ex37){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataDDP3(member_id,ex31,ex32,ex33,ex34,ex35,ex36,ex37);
        call.enqueue(new Callback <POJO_DD_P3>()   {


            @Override
            public void onResponse(Call<POJO_DD_P3> call, Response  <POJO_DD_P3> response ) {
//                Log.e("onResponse",""+response.body());

                try{

                    POJO_DD_P3 affective3 = (POJO_DD_P3) response.body();

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
                        listener.onResponse(affective3);
                    }

                }catch (Exception e){
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_DD_P3> call, Throwable t) {
                Log.e("NT",t.getMessage());
                try{

                    listener.onFailure(t);

                }catch (Exception e){

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void  callServer_Checkdaily(final OnNetworkCallback_Checkdaily_D1 listener, String name_std, int score ){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDatadaily(name_std,score);
        call.enqueue(new Callback <POJO_Checkdaily>()   {


            @Override
            public void onResponse(Call<POJO_Checkdaily> call, Response  <POJO_Checkdaily> response ) {
//                Log.e("onResponse",""+response.body());

                try{

                    POJO_Checkdaily Checkdaily = (POJO_Checkdaily) response.body();

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
                        listener.onResponse(Checkdaily);
                    }

                }catch (Exception e){
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_Checkdaily> call, Throwable t) {
                Log.e("NT",t.getMessage());
                try{

                    listener.onFailure(t);

                }catch (Exception e){

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void callServer_stu_naja (final OnNetworkCallback_Stu_naja listener, String member_id) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDatastunaja(member_id);
        call.enqueue(new Callback<List<POJO_Stu_naja>>() {


            @Override
            public void onResponse(Call<List<POJO_Stu_naja>> call, Response<List<POJO_Stu_naja>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_Stu_naja> stu_naja =  response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(stu_naja);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_Stu_naja>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void callSrever_AF_teacher(final OnNetworkCallback_AF_teacher listener, String member_id ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDataAF_teacher_company(member_id);


        call.enqueue(new Callback<List<POJO_AF_teacher>>() {

            @Override
            public void onResponse(Call<List<POJO_AF_teacher>> call, Response<List<POJO_AF_teacher>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_AF_teacher> getnite = (List<POJO_AF_teacher>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(getnite);
                    }

                } catch (Exception e) {
                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_AF_teacher>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void callServer_stu_naja_gogo (final OnNetworkCallback_Stu_naja_gogo listener, String dep_id , int suppervision) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.getDatastunajagogo(dep_id,suppervision);
        call.enqueue(new Callback<List<POJO_Stu_naja_gogo>>() {


            @Override
            public void onResponse(Call<List<POJO_Stu_naja_gogo>> call, Response<List<POJO_Stu_naja_gogo>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_Stu_naja_gogo> stu_naja_gogo = (List<POJO_Stu_naja_gogo>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(stu_naja_gogo);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_Stu_naja_gogo>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////  ////////////////////////////////////////////////////////////////////////////////////////////////
    public void callServer_row_teacher (final OnNetworkCallback_row_teacher listener, int member_id , String score,int spn) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_away_font_me(member_id,score,spn);
        call.enqueue(new Callback<POJO_row_teacher>() {


            @Override
            public void onResponse(Call<POJO_row_teacher> call, Response<POJO_row_teacher> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    POJO_row_teacher row_roi = (POJO_row_teacher) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(row_roi);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<POJO_row_teacher> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_suppervision(final OnNetworkCallback_AF_teacher listener, String member_id , int suppervision ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_dawae_now(member_id,suppervision);


        call.enqueue(new Callback<List<POJO_AF_teacher>>() {

            @Override
            public void onResponse(Call<List<POJO_AF_teacher>> call, Response<List<POJO_AF_teacher>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_AF_teacher> supervision = (List<POJO_AF_teacher>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(supervision);
                    }

                } catch (Exception e) {
                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_AF_teacher>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_trainer(final OnNetworkCallback_trainer listener ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_trainer();


        call.enqueue(new Callback<List<POJO_trainer>>() {

            @Override
            public void onResponse(Call<List<POJO_trainer>> call, Response<List<POJO_trainer>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_trainer> trainer = (List<POJO_trainer>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(trainer);
                    }

                } catch (Exception e) {
                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_trainer>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_trainer2(final OnNetworkCallback_trainer2 listener ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_trainer2();


        call.enqueue(new Callback<List<POJO_trainer2>>() {

            @Override
            public void onResponse(Call<List<POJO_trainer2>> call, Response<List<POJO_trainer2>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_trainer2> trainer = (List<POJO_trainer2>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(trainer);
                    }

                } catch (Exception e) {
                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_trainer2>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_getstuemp(final OnNetworkCallback_getstuemp listener , String dep_id ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_getstuemp(dep_id);


        call.enqueue(new Callback<List<POJO_getstuemp>>() {

            @Override
            public void onResponse(Call<List<POJO_getstuemp>> call, Response<List<POJO_getstuemp>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_getstuemp> getstuemp = (List<POJO_getstuemp>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(getstuemp);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_getstuemp>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_save_data_trainer(final OnNetworkCallback_save_data_trainer listener , int member_id , int score , int check_nited  ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_save_data_trainer(member_id , score ,check_nited);


        call.enqueue(new Callback<List<POJO_save_data_trainer>>() {

            @Override
            public void onResponse(Call<List<POJO_save_data_trainer>> call, Response<List<POJO_save_data_trainer>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_save_data_trainer> get_save_data = (List<POJO_save_data_trainer>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(get_save_data);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_save_data_trainer>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_confirm_AG(final OnNetworkCallback_confirm_AG listener , int dep_id ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_comfirm_ag(dep_id);


        call.enqueue(new Callback<List<POJO_confirm_AG>>() {

            @Override
            public void onResponse(Call<List<POJO_confirm_AG>> call, Response<List<POJO_confirm_AG>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_confirm_AG> get_confirm= (List<POJO_confirm_AG>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(get_confirm);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_confirm_AG>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void callSrever_save_AG(final OnNetworkCallback_save_AG listener , int member_id,int check_dep ) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Fragment_login.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APISERVER callapi = retrofit.create(APISERVER.class);

        Call call = callapi.get_save_ag(member_id,check_dep);


        call.enqueue(new Callback<List<POJO_save_AG>>() {

            @Override
            public void onResponse(Call<List<POJO_save_AG>> call, Response<List<POJO_save_AG>> response) {
//                Log.e("onResponse",""+response.body());

                try {

                    List<POJO_save_AG> get_confirm= (List<POJO_save_AG>) response.body();

                    if (response.code() != 200) {
//                        Log.e("Network connected","Response code = "+response.code());

                        ResponseBody responseBody = response.errorBody();

                        if (responseBody != null) {
                            listener.onBodyError(responseBody);
                        } else if (responseBody == null) {
                            listener.onBodyErrorIsNull();
                        }

//                        Toast.makeText(, ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//                        Log.e("Network connected","Response code = "+loginRes.getAccesstoken());
                    } else {
                        listener.onResponse(get_confirm);
                    }

                } catch (Exception e) {
//                    Log.e("Network connect error",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<POJO_save_AG>> call, Throwable t) {
                Log.e("NT", t.getMessage());
                try {

                    listener.onFailure(t);

                } catch (Exception e) {

                    listener.onFailure(t);
//                    Log.e("Network connectLogin",t.getMessage());
                }

            }
        });
    }
}