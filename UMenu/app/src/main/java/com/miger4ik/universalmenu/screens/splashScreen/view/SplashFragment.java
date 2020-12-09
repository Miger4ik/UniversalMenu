package com.miger4ik.universalmenu.screens.splashScreen.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miger4ik.universalmenu.R;

public class SplashFragment extends Fragment {

    private static SplashFragment splashFragment;

    private View view;

    private SplashFragment(){
        super();
    }

    public static SplashFragment getInstance() {
        if (splashFragment == null) {
            splashFragment = new SplashFragment();
        }
        return splashFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_splash, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}