package com.longmt.lab3;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.longmt.lab3.model.res.Photo;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MyPhotoAdapter extends RecyclerView.Adapter<MyPhotoAdapter.ViewHolder> {

    private List<Photo> mListItems;

    private Context context;

    public MyPhotoAdapter(Context context) {
        this.context = context;
    }

    public void setListItem(List<Photo> listItem) {
        mListItems = listItem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Photo item = mListItems.get(position);

        //holder.bindData(item.getUrlC(), item.getTitle());

        holder.tvTitle.setText(item.getTitle());

        holder.tvViews.setText(item.getViews()+"");

        Picasso.get()
                .load(item.getUrlL())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgThumbai);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                View alert = LayoutInflater.from(context).inflate(R.layout.dialog_show_photo, null);

                builder.setView(alert);

                ImageView imageView;

                TextView tvTitle;

                tvTitle = alert.findViewById(R.id.tv_title);

                imageView = alert.findViewById(R.id.img_thumbai);

                tvTitle.setText(item.getTitle());

//                Glide
//                        .with(context)
//                        .load(item.getUrl())
//                        .into(imageView);


                Picasso.get()
                        .load(item.getUrlC())
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(imageView);

                builder.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imgThumbai;

        private TextView tvTitle, tvViews;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgThumbai = itemView.findViewById(R.id.img_thumbai);

            tvTitle = itemView.findViewById(R.id.tv_title);

            tvViews = itemView.findViewById(R.id.tv_view);

        }

        public void bindData(String title, String imgUrl) {
            tvTitle.setText(title);

            Picasso.get()
                    .load(imgUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imgThumbai);

        }


    }

}
