package com.miger4ik.universalmenu.screens.mainScreen.presenter;

import android.util.Log;

import com.miger4ik.universalmenu.application.enums.ButtonEvents;
import com.miger4ik.universalmenu.application.enums.Views;
import com.miger4ik.universalmenu.coreInterfaces.MainContract;
import com.miger4ik.universalmenu.coreInterfaces.Replaceable;
import com.miger4ik.universalmenu.screens.mainScreen.repository.MainScreenRepository;

public class MainScreenPresenter implements MainContract.Presenter {
    private static final String TAG = "MainScreenPresenter";
    private Replaceable replaceable;

    private MainContract.View mView;
    private MainContract.Repository mRepository;

    public MainScreenPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepository = MainScreenRepository.getInstance();
        Log.d(TAG, "Constructor");
    }

    @Override
    public void onButtonWasClicked(ButtonEvents event) {
        switch (event) {
            case CREATE:

            case READ: {
                mView.showData(mRepository.loadData());
                break;
            }

            case UPDATE:

            case DELETE:

            case REPLACE_FRAGMENT: {
                replaceable.replace(Views.SPLASH_SCREEN);
                break;
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onCreateView() {
        Log.d(TAG, "onCreateView");
    }

    @Override
    public void setReplaceable(Replaceable replaceable) {
        this.replaceable = replaceable;
    }
}
