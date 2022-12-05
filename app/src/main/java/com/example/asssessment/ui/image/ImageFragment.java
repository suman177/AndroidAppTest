package com.example.asssessment.ui.image;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import  androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.asssessment.R;
import com.example.asssessment.models.GetUploadedImagesResponse;
import com.example.asssessment.models.GifResponseModel;
import com.example.asssessment.retrofit.ApiInterface;
import com.example.asssessment.retrofit.Retrofit;
import com.example.asssessment.ui.UploadedFiles;
import com.example.asssessment.ui.gif.GifFragment;
import com.example.asssessment.viewmodels.ShareViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageFragment extends Fragment {

    private ShareViewModel sharedViewModel;

    GridView gridView;
    List<Boolean> selectedImages = new ArrayList<Boolean>();
    Toolbar toolbar;
    private Button menuButton;
    List<String> totalImages;
    FloatingActionButton fab;


    private void getData() {
        System.out.println("Getting new Data");
        sharedViewModel = new ViewModelProvider(getActivity()).get(ShareViewModel.class);
          sharedViewModel.getUrl().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
              @RequiresApi(api = Build.VERSION_CODES.N)
              @Override
              public void onChanged(List<String> strings) {
                  ImageGridAdapter imageGridAdapter = new ImageGridAdapter(getContext(),strings);
                  strings.forEach((e) -> {
                        selectedImages.add(false);
                  });
                  toolbar.setTitle("Image");
                  menuButton.setVisibility(View.INVISIBLE);

                  totalImages = strings;

                  gridView.setAdapter(imageGridAdapter);
              }
          });

    }

    private void postData() {
        System.out.println("Uploading new Data");
        ApiInterface apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);

        for(int i = 0;i < selectedImages.size();i++){
            if(selectedImages.get(i)){
                String url = "https://snoo.gl/api/v2/method/account.insertimages";
                Call<GetUploadedImagesResponse> result = apiInterface.insertImage(url,totalImages.get(i));

                result.enqueue(new Callback<GetUploadedImagesResponse>() {
                    @Override
                    public void onResponse(Call<GetUploadedImagesResponse> call, Response<GetUploadedImagesResponse> response) {
                        Toast.makeText(getActivity(), "File Uploaded!",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<GetUploadedImagesResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Something went wrong!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
        getData();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        selectedImages.clear();
        View root = inflater.inflate(R.layout.fragment_image, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar = root.findViewById(R.id.image_toolbar);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("Image");
        }

        menuButton =  root.findViewById(R.id.upload_button);

        fab =  root.findViewById(R.id.floatingActionButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UploadedFiles.class);
                startActivity(intent);
            }
        });

        gridView = (GridView) root.findViewById(R.id.img_grid);

        getData();

        return root;
    }


    class ImageGridAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;
        List<String> list;
        public ImageGridAdapter(Context context, List<String> results) {
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

            CheckBox checkBox = (CheckBox) listitemView.findViewById(R.id.grid_item_checkbox);
            checkBox.setVisibility(View.VISIBLE);


            checkBox.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    CheckBox cb = (CheckBox) v;
                    System.out.println("Clicked CheckBox");
                    if ( selectedImages.get(i)){
                        cb.setChecked(false);
                        selectedImages.set(i,false);
                    } else {
                        cb.setChecked(true);
                        selectedImages.set(i,true);
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        selectedImages.forEach(e->System.out.println(e.toString()));
                    }


                    int count=0;
                    for(int i = 0;i<selectedImages.size();i++){
                        if(selectedImages.get(i)){
                            count++;
                        }
                    }

                    if(count > 0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            toolbar.setTitle(count + " item/s selected");
                            menuButton.setVisibility(View.VISIBLE);
                        }
                    }else{
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            toolbar.setTitle("Image");
                            menuButton.setVisibility(View.INVISIBLE);
                        }
                    }

                }
            });

            ImageView pic = listitemView.findViewById(R.id.grid_image);

            Glide.with(context)
                    .load(list.get(i))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(pic);
//            Picasso.get().load(list.get(i)).placeholder(R.drawable.ic_launcher_background).fit().into(pic);

            return listitemView;
        }
    }
}