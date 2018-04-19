package ctn.example.user.dvectn.Retrofit;

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

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface APISERVER {

    @FormUrlEncoded
    @POST("login/")
    Call<POJO_login> loginHandle(@Field("username") String first, @Field("password") String last);


    @FormUrlEncoded
    @POST("getstu/")
    Call<List<POJO_getstu>> getSTD(@Field("dep_id") String dep_id);


    @FormUrlEncoded
    @POST("Checkdaily/")
    Call<POJO_Checkdaily> getDatadaily(@Field("name") String name, @Field("score") int score);


    @FormUrlEncoded
    @POST("getCheckdaily/")
    Call<List<POJOGetDaily>> getDatadaily(@Field("dep_id") String dep_id , @Field("date") String date);


    @FormUrlEncoded
    @POST("assessmentstu-1/")
    Call<POJO_PJ_P1> getDataPJP1(@Field("member_id") int first, @Field("ex11") int Sec,
                                 @Field("ex12") int Thrir);

    @FormUrlEncoded
    @POST("assessmentstu-2/")
    Call<POJO_PJ_P2> getDataPJP2(@Field("member_id") int first, @Field("ex21") int Sec,
                                 @Field("ex22") int Thrir, @Field("ex23") int four,
                                 @Field("ex24") int five, @Field("ex25") int six,
                                 @Field("ex26") int seven, @Field("ex27") int eight,
                                 @Field("ex28") int nine);

    @FormUrlEncoded
    @POST("assessmentstu-3/")
    Call<POJO_PJ_P3> getDataPJP3(@Field("member_id") int first, @Field("ex31") int Sec,
                                 @Field("ex32") int Thrir, @Field("ex33") int four,
                                 @Field("ex34") int five, @Field("ex35") int six,
                                 @Field("ex36") int seven, @Field("ex37") int eight);

    @FormUrlEncoded
    @POST("assessmentstu-4/")
    Call<POJO_PJ_P4> getDataPJP4(@Field("member_id") int first, @Field("ex41") int Sec,
                                 @Field("ex42") int Thrir, @Field("ex43") int four,
                                 @Field("ex44") int five, @Field("ex45") int six,
                                 @Field("ex46") int seven, @Field("ex47") int eight);

    @FormUrlEncoded
    @POST("assessmentstu-5/")
    Call<POJO_PJ_P5> getDataPJP5(@Field("member_id") int first, @Field("ex51") int Sec,
                                 @Field("ex52") int Thrir, @Field("ex53") int four,
                                 @Field("ex54") int five, @Field("ex55") int six,
                                 @Field("ex56") int seven);

    @FormUrlEncoded
    @POST("assessmentstu-6/")
    Call<POJO_PJ_P6> getDataPJP6(@Field("member_id") int first, @Field("ex61") int Sec,
                                 @Field("ex62") int Thrir, @Field("ex63") int four,
                                 @Field("ex64") int five, @Field("ex65") int six,
                                 @Field("ex66") int seven);

    @FormUrlEncoded
    @POST("getstu/")
    Call<POJO_getstu> getDataPJP5(@Field("member_id") int first,@Field("score") String score);

//    @FormUrlEncoded
//    @POST("getdata-ebs/")
//    Call<POJO_getdata_ebs> getData_ebs ();

    @FormUrlEncoded
    @POST("affective-1/")
    Call<POJO_DD_P1> getDataDDP1(@Field("member_id") int first, @Field("ex11") int Sec,
                                 @Field("ex12") int Thrir, @Field("ex13") int four,
                                 @Field("ex14") int five, @Field("ex15") int six);

    @FormUrlEncoded
    @POST("affective-2/")
    Call<POJO_DD_P2> getDataDDP2(@Field("member_id") int first, @Field("ex21") int Sec,
                                 @Field("ex22") int Thrir, @Field("ex23") int four,
                                 @Field("ex24") int five, @Field("ex25") int six,
                                 @Field("ex26") int seven, @Field("ex27") int eight,
                                 @Field("ex28") int nine);

    @FormUrlEncoded
    @POST("affective-3/")
    Call<POJO_DD_P3> getDataDDP3(@Field("member_id") int first, @Field("ex31") int Sec,
                                 @Field("ex32") int Thrir, @Field("ex33") int four,
                                 @Field("ex34") int five, @Field("ex35") int six,
                                 @Field("ex36") int seven, @Field("ex37") int eight);

    @FormUrlEncoded
    @POST("test1/")
    Call<POJO_test1_in_ag> getDatatest1(@Field("member_id ") int first);


    @Multipart
    @POST("upload/")
    Call<ResPOJO> updateImageProfile(@Part MultipartBody.Part image,
                                     @Part("member_id") int member_id,
                                     @Part("app_name") String name,
                                     @Part("app_detail") String detail,
                                     @Part("dep_id") int dep_id);

//    @FormUrlEncoded
//    @POST("Ag_Accept/")
//    Call<POJO_AG> getDatastuAG (@Field("member_id ") int first);

    @FormUrlEncoded
    @POST("stu/")
    Call<List<POJO_Stu_naja>> getDatastunaja(@Field("member_id") String first);


    @FormUrlEncoded
    @POST("getstu/")
    Call<List<POJO_Stu_naja_gogo>> getDatastunajagogo(@Field("dep_id") String first , @Field("supervision") int supvision);

    @FormUrlEncoded
    @POST("teacher-af/")
    Call<List<POJO_AF_teacher>> getDataAF_teacher_company(@Field("member_id") String first);


    @FormUrlEncoded
    @POST("getstu-supervision/")
    Call<List<POJO_AF_teacher>> get_dawae_now (@Field("dep_id") String first,@Field("supervision") int supervision);

    @FormUrlEncoded
    @POST("save-nite/")
    Call<POJO_row_teacher> get_away_font_me (@Field("member_id") int first , @Field("score") String sec,@Field("supervision") int supervision);


    @GET("em-api/")
    Call<List<POJO_trainer>> get_trainer ();


    @GET("apprentice/")
    Call<List<POJO_trainer2>> get_trainer2 ();

    @FormUrlEncoded
    @POST("apprentice/")
    Call<List<POJO_getstuemp>> get_getstuemp (@Field("dep_id") String first);


    @FormUrlEncoded
    @POST("save-data/")
    Call<List<POJO_save_data_trainer>> get_save_data_trainer (@Field("member_id") int first , @Field("score") int sec , @Field("check_dep") int check_nited);


    @FormUrlEncoded
    @POST("save-cf/")
    Call<List<POJO_confirm_AG>> get_comfirm_ag (@Field("dep_id") int first);

    @FormUrlEncoded
    @POST("save-ag/")
    Call<List<POJO_save_AG>> get_save_ag (@Field("member_id") int first, @Field("check_dep") int sec);
}


