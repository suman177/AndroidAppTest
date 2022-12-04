package com.example.asssessment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.asssessment.databinding.ActivityMainBinding;
import com.example.asssessment.ui.audio.AudioFragment;
import com.example.asssessment.ui.gif.GifFragment;
import com.example.asssessment.ui.image.ImageFragment;
import com.example.asssessment.ui.video.VideoFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ImageFragment());

        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_image:
                    replaceFragment(new ImageFragment());
                    break;
                case R.id.navigation_video:
                    replaceFragment(new VideoFragment());
                    break;
                case R.id.navigation_audio:
                    replaceFragment(new AudioFragment());
                    break;
                case R.id.navigation_gif:
                    replaceFragment(new GifFragment());
                    break;
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment,fragment);
        fragmentTransaction.commit();
    }

}