package com.example.asssessment.ui.gif;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.SharedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import android.widget.TextView;

import com.example.asssessment.MainActivity;
import com.example.asssessment.R;
import com.example.asssessment.models.GifResponseModel;
import com.example.asssessment.retrofit.ApiInterface;
import com.example.asssessment.retrofit.Retrofit;
import com.example.asssessment.viewmodels.ShareViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GifFragment extends Fragment {

    int paginateUpTo = 15;

    GridView gridView;
    Boolean isLoading = false;

    ShareViewModel sharedViewModel;

    List<String> selectedImage = new ArrayList<String>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getData() {
        System.out.println("Getting new Data");
        ApiInterface apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);

        Call<GifResponseModel> getImages = apiInterface.getData(Integer.toString(paginateUpTo));

        getImages.enqueue(new Callback<GifResponseModel>() {
            @Override
            public void onResponse(Call<GifResponseModel> call, Response<GifResponseModel> response) {
                GifGridAdapter gifGridAdapter = new GifGridAdapter(getContext(),response.body().getResults());
                gridView.setAdapter(gifGridAdapter);
            }


            @Override
            public void onFailure(Call<GifResponseModel> call, Throwable t) {
                System.out.println(t);
            }
        });
        isLoading = false;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gif, container, false);
        getActivity().setTitle("GIF");
        sharedViewModel = new ViewModelProvider(getActivity()).get(ShareViewModel.class);


        gridView = (GridView) root.findViewById(R.id.gif_grid);

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount > 0) {
                    int lastVisibleItem = firstVisibleItem + visibleItemCount;
                    if (!isLoading && (lastVisibleItem == totalItemCount)) {
                        isLoading = true;
                        paginateUpTo+=15;
                        System.out.println(paginateUpTo);
                        getData();
                    }
                }
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//             System.out.println(adapterView.getSelectedItem().toString());
//            selectedImage.add(adapterView.)
                GifResponseModel.Result result = (GifResponseModel.Result) adapterView.getItemAtPosition(position);
                System.out.println(result.getMedia().get(0).getGif().getUrl());
                selectedImage.add(result.getMedia().get(0).getGif().getUrl());
                sharedViewModel.setUrl(selectedImage);
            }
        });
        getData();
        return root;
    }

    class GifGridAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;
        List<GifResponseModel.Result> list;
        public GifGridAdapter(Context context, List<GifResponseModel.Result> results) {
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
            Picasso.get().load(list.get(i).getMedia().get(0).getGif().getUrl()).placeholder(R.drawable.ic_launcher_background).fit().into(pic);
            return listitemView;
        }
    }
}