package com.example.asssessment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.asssessment.R;
import com.example.asssessment.models.GetUploadedImagesResponse;
import com.example.asssessment.models.GifResponseModel;
import com.example.asssessment.retrofit.ApiInterface;
import com.example.asssessment.retrofit.Retrofit;
import com.example.asssessment.ui.gif.GifFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadedFiles
        extends AppCompatActivity {
    GridView gridView;


    private void getData() {
        System.out.println("Getting new Data");
        ApiInterface apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);
        Call<GetUploadedImagesResponse> getImages = apiInterface.getImages("https://snoo.gl/api/v2/method/account.getimages");

        getImages.enqueue(new Callback<GetUploadedImagesResponse>() {
            @Override
            public void onResponse(Call<GetUploadedImagesResponse> call, Response<GetUploadedImagesResponse> response) {
//                assert response.body() != null;
//                System.out.println(response.toString());
                UploadedImageAdapter gifGridAdapter = new UploadedImageAdapter(getApplicationContext(), response.body().getItems());
                gridView.setAdapter(gifGridAdapter);
            }


            @Override
            public void onFailure(Call<GetUploadedImagesResponse> call, Throwable t) {
                System.out.println(t);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaded_files);
        Toolbar toolbar = (Toolbar) findViewById(R.id.uploadedImageToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        gridView = (GridView) findViewById(R.id.upload_grid);
        getData();
    }


    class UploadedImageAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;
        List<GetUploadedImagesResponse.Item> list;
        public UploadedImageAdapter(Context context, List<GetUploadedImagesResponse.Item> results) {
            this.context = context;
            System.out.println(results.size());
            this.list = results;
        }

        @Override
        public int getCount() {
            return list
                    .size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View listitemView = view;
            if (listitemView == null) {
                // Layout Inflater inflates each item to be displayed in GridView.
                listitemView = inflater.from(context).inflate(R.layout.gridlayout,viewGroup, false);
            }

            ImageView pic = listitemView.findViewById(R.id.grid_image);
            Picasso.get().load(list.get(i).getUrl()).placeholder(R.drawable.ic_launcher_background).fit().into(pic);
            return listitemView;
        }
    }
}