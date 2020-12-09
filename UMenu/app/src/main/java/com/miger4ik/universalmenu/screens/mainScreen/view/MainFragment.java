package com.miger4ik.universalmenu.screens.mainScreen.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.miger4ik.universalmenu.R;
import com.miger4ik.universalmenu.application.enums.ButtonEvents;
import com.miger4ik.universalmenu.coreInterfaces.MainContract;
import com.miger4ik.universalmenu.coreInterfaces.Replaceable;
import com.miger4ik.universalmenu.screens.mainScreen.presenter.MainScreenPresenter;

public class MainFragment extends Fragment implements MainContract.View {
    private static final String TAG = "MainFragment";
    private MainContract.Presenter mPresenter;
    private static MainFragment mainFragment;

    private View view;
    private Button readButton;
    private Button replaceButton;
    private TextView resultTextView;

    private MainFragment() {
        super();
    }

    public static MainFragment getInstance() {
        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        mPresenter = new MainScreenPresenter(this);
        mPresenter.setReplaceable((Replaceable) getContext());
        mPresenter.onCreateView();

        readButton = view.findViewById(R.id.readButton);
        replaceButton = view.findViewById(R.id.replaceButton);
        resultTextView = view.findViewById(R.id.resultTextView);

        readButton.setOnClickListener(v -> mPresenter.onButtonWasClicked(ButtonEvents.READ));
        replaceButton.setOnClickListener(v -> mPresenter.onButtonWasClicked(ButtonEvents.REPLACE_FRAGMENT));

        Log.d(TAG, "onCreateView");
        return view;
    }

    @Override
    public void showData(String data) {
        resultTextView.setText(data);
        Log.d(TAG, "showData");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onDestroy();
        Log.d(TAG, "onDestroyView");
    }
}