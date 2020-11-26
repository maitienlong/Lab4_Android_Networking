package com.longmt.lab3.services;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    private static ListServices listServices;

    private static String apiUrl = "https://www.flickr.com";

    public static final int CONNECT_TIMEOUT = 30 * 1000;

    public static ListServices getInstanceProduct() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(CONNECT_TIMEOUT, TimeUnit.MICROSECONDS)
                .writeTimeout(CONNECT_TIMEOUT, TimeUnit.MICROSECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MICROSECONDS)
                .retryOnConnectionFailure(true);
        if (listServices == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                   // .client(builder.build())
                    .build();

            listServices = retrofit.create(ListServices.class);
        }
        return listServices;
    }
}
