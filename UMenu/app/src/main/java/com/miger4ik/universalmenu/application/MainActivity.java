package com.miger4ik.universalmenu.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.miger4ik.universalmenu.R;
import com.miger4ik.universalmenu.application.enums.Views;
import com.miger4ik.universalmenu.coreInterfaces.Replaceable;
import com.miger4ik.universalmenu.screens.mainScreen.view.MainFragment;
import com.miger4ik.universalmenu.screens.splashScreen.view.SplashFragment;

public class MainActivity extends AppCompatActivity implements Replaceable {
    private int containerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerId = R.id.container;

        getSupportFragmentManager().beginTransaction().add(containerId, MainFragment.getInstance()).commit();
    }

    @Override
    public void replace(Views view) {
        switch (view) {
            case SPLASH_SCREEN: {
                getSupportFragmentManager().beginTransaction().replace(containerId, SplashFragment.getInstance()).addToBackStack("SplashFragment").commit();
                break;
            }

            case MAIN_SCREEN: {
                getSupportFragmentManager().beginTransaction().replace(containerId, MainFragment.getInstance()).addToBackStack("MainFragment").commit();
                break;
            }

            default: {
            }
        }
    }
}