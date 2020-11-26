package com.longmt.lab3.services;

import com.longmt.lab3.model.RequestFavo;
import com.longmt.lab3.model.res.ResponsePhotoFavo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ListServices {
    @POST("/services/rest/")
    @FormUrlEncoded
    Call<ResponsePhotoFavo> getAllPhoto(@Field("method") String method,
                                        @Field("api_key") String api_key,
                                        @Field("user_id") String user_id,
                                        @Field("extras") String extras,
                                        @Field("per_page") String per_page,
                                        @Field("page") String page,
                                        @Field("format") String format,
                                        @Field("nojsoncallback") int nojsoncallback
    );

    @GET("https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=6f3c4406142208714992a9337af3fe3e&user_id=185894931%40N02&extras=description, views, media, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o&per_page=&page=&format=json&nojsoncallback=1")
    Call<ResponsePhotoFavo> getAll();
}
