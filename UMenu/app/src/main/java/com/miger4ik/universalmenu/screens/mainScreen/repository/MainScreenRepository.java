package com.miger4ik.universalmenu.screens.mainScreen.repository;

import android.util.Log;

import com.miger4ik.universalmenu.coreInterfaces.MainContract;

public class MainScreenRepository implements MainContract.Repository {
    private static final String TAG = "MainScreenRepository";
    private static MainScreenRepository mainScreenRepository;

    private MainScreenRepository() {
    }

    public static MainScreenRepository getInstance() {
        if (mainScreenRepository == null) {
            mainScreenRepository = new MainScreenRepository();
        }
        return mainScreenRepository;
    }

    @Override
    public String loadData() {
        Log.d(TAG, "loadData");
        return "load Data";
    }
}
