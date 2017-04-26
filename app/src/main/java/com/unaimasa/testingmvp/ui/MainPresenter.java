package com.unaimasa.testingmvp.ui;


import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.TextView;

import com.unaimasa.testingmvp.utils.ViewUtils;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {

    private static final String PRESENTER_TAG = "_main_presenter";

    private final MainContract.View mMainContractView;

    public MainPresenter(@NonNull MainContract.View mainContractView) {
        mMainContractView = checkNotNull(mainContractView, "MainContract.View cannot be null!");
        mMainContractView.setPresenter(this);
    }

    // ----- Presenter Methods ----- //
    @Override
    public void reverseTextViewVisibility(TextView textView) {
        if (textView != null) {
            if (textView.isShown()) {
                ViewUtils.hideView(textView);

                setButtonText("SHOW");
            } else {
                ViewUtils.showView(textView);

                setButtonText("HIDE");
            }
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void setButtonText(final String text) {
        mMainContractView.setButtonText(text);
    }
}
