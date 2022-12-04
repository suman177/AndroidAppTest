package com.example.asssessment.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<List<String>> selectedURLs = new MutableLiveData<>();

    public void setUrl(List<String> value){
        selectedURLs = new MutableLiveData<>();
        selectedURLs.setValue(value);
    }

    public LiveData<List<String>> getUrl() {
        return selectedURLs;
    }
}
