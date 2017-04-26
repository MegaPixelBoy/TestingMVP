package com.unaimasa.testingmvp.ui;


import android.widget.TextView;

import com.unaimasa.testingmvp.BasePresenter;
import com.unaimasa.testingmvp.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void setButtonText(final String text);
    }

    interface Presenter extends BasePresenter {
        void reverseTextViewVisibility(final TextView textView);
    }
}
