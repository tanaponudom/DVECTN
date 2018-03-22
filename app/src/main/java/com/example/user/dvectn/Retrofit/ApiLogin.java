package com.example.user.dvectn.Retrofit;

import com.example.user.dvectn.POJO.POJO_Checkdaily;
import com.example.user.dvectn.POJO.POJO_PJ_P1;
import com.example.user.dvectn.POJO.POJO_PJ_P2;
import com.example.user.dvectn.POJO.POJO_PJ_P3;
import com.example.user.dvectn.POJO.POJO_getstu;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kritsanrongkaew on 12/3/2018 AD.
 */

public interface ApiLogin {

    @FormUrlEncoded
    @POST("login/")
    Call<Login> loginHandle(@Field("username") String first, @Field("password") String last);

    @FormUrlEncoded
    @POST("studata/")
    Call<POJO_getstu> getDataStd(@Field(""));

//    @FormUrlEncoded
//    @POST("Checkdaily/")
//    Call<POJO_Checkdaily> getDatadaily(@Field("member_id") int first , @Field("app_name") String Sec ,
//                                       @Field("app_date") int Thrir , @Field("app_detai") String Four
//                                       @Field("img") );

    @FormUrlEncoded
    @POST("assessmentstu-1/")
    Call<POJO_PJ_P1> getDataPJP1 (@Field("member_id") int first , @Field("ex11") int Sec ,
                                  @Field("ex12") int Thrir);

    @FormUrlEncoded
    @POST("assessmentstu-2")
    Call<POJO_PJ_P2> getDataPJP2 (@Field("member_id") int first ,@Field("ex21") int Sec ,
                                  @Field("ex22") int Thrir , @Field("ex23") int four ,
                                  @Field("ex24") int five , @Field("ex25") int six ,
                                  @Field("ex26") int seven , @Field("ex27") int eight ,
                                  @Field("ex28") int nine);

    @FormUrlEncoded
    @POST("assessmentstu-3")
    Call<POJO_PJ_P3> getDataPJP3 (@Field("member_id") int first , @Field("ex31") int Sec ,
                                  @Field("ex32") int Thrir , @Field("ex33") int four ,
                                  @Field("ex34") int five , @Field("ex35") int six ,
                                  @Field("ex36") int seven , @Field("ex37") int eight);

    
}
