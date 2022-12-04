package com.example.asssessment.retrofit;

import com.example.asssessment.models.GetUploadedImagesResponse;
import com.example.asssessment.models.GifResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("v1/search?key=X2918E9QRHPH&amp;q=trending&amp;")
    Call<GifResponseModel> getData(@Query("limit") String limit);

    @FormUrlEncoded
    @POST
    Call<GetUploadedImagesResponse> insertImage(@Url String url,@Field("images") String image);

    @GET
    Call<GetUploadedImagesResponse> getImages(@Url String url);

}
