package com.example.asssessment.ui.audio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AudioViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<String>> selectedURLs;

    public AudioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setUrl(List<String> value){
        selectedURLs.setValue(value);
    }

    public LiveData<List<String>> getUrl() {
        return selectedURLs;
    }
}