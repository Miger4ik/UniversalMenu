package com.miger4ik.universalmenu.coreInterfaces;

import com.miger4ik.universalmenu.application.enums.ButtonEvents;

public interface MainContract {
    interface View {
        void showData(String data);
    }

    interface Presenter {
        void onCreateView();
        void setReplaceable(Replaceable replaceable);
        void onButtonWasClicked(ButtonEvents event);
        void onDestroy();
    }

    interface Repository {
        String loadData();
    }
}
