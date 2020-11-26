package com.longmt.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.longmt.lab3.model.RequestFavo;
import com.longmt.lab3.model.res.ResponsePhotoFavo;
import com.longmt.lab3.services.MyRetrofit;
import com.longmt.lab3.model.res.Photo;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyPhotoAdapter myPhotoAdapter;

    private RecyclerView rcPhoto;

    private ProgressDialog progressDialog;

    Type type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcPhoto = findViewById(R.id.rc_photo);

        myPhotoAdapter = new MyPhotoAdapter(this);

        type = new TypeToken<List<Photo>>() {
        }.getType();


        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Đang tải dữ liệu . . .");

        progressDialog.setIndeterminate(false);

        progressDialog.setCancelable(false);

        progressDialog.show();

        Retrofit();

    }


    // su dung thu vien RETROFIT
    private void Retrofit() {

        String method = "flickr.favorites.getList";
        String api_key = "6f3c4406142208714992a9337af3fe3e";
        String user_id = "185894931@N02";
        String extras = "description, views, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o";
        String per_page = "";
        String page = "";
        String format = "json";
        int nojsoncallback = 1;


        MyRetrofit.getInstanceProduct().getAllPhoto(method, api_key, user_id, extras, per_page, page, format, nojsoncallback).enqueue(new Callback<ResponsePhotoFavo>() {
            @Override
            public void onResponse(Call<ResponsePhotoFavo> call, Response<ResponsePhotoFavo> response) {
                if (response.code() == 200) {
                    Log.d("CheckHi", new Gson().toJson(response.body()));
                    onShowPhoto(response.body().getPhotos().getPhoto());
                } else {
                    Log.d("CheckHi", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ResponsePhotoFavo> call, Throwable t) {
                Log.d("CheckHi", t.toString());
            }
        });
    }

    private void onShowPhoto(List<Photo> mListPhoto) {

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        myPhotoAdapter.setListItem(mListPhoto);

        rcPhoto.setLayoutManager(linearLayoutManager);

        rcPhoto.setAdapter(myPhotoAdapter);


    }
}