package com.unaimasa.testingmvp.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unaimasa.testingmvp.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String ACTIVITY_TAG = "_main_activity";

    private MainContract.Presenter mMainContractPresenter;
    private MainPresenter mMainPresenter;
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.tv_hello_world);
        mButton = (Button) findViewById(R.id.btn_visibility);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainContractPresenter.reverseTextViewVisibility(mTextView);
            }
        });

        mMainPresenter = new MainPresenter(this);
    }

    // ----- Main Contract View Methods ----- //
    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mMainContractPresenter = checkNotNull(presenter, "MainContract.Presenter cannot be null!");
    }

    // ----- View Methods ----- //
    @Override
    public void setButtonText(final String text) {
        mButton.setText(text);
    }
}
