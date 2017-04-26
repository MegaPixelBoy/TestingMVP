package com.unaimasa.testingmvp;

import android.view.View;
import android.widget.TextView;

import com.unaimasa.testingmvp.ui.MainActivity;
import com.unaimasa.testingmvp.ui.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(Mockito.mock(MainActivity.class));
    }

    @Test
    public void reverseTextViewVisibilityFromVisibleToGone() throws Exception {
        final TextView textView = Mockito.mock(TextView.class);
        when(textView.isShown()).thenReturn(true);

        mainPresenter.reverseTextViewVisibility(textView);

        Mockito.verify(textView, Mockito.atLeastOnce()).setVisibility(View.GONE);
    }

    @Test
    public void reverseTextViewVisibilityFromGoneToVisible() throws Exception {
        final TextView textView = Mockito.mock(TextView.class);
        when(textView.isShown()).thenReturn(false);

        mainPresenter.reverseTextViewVisibility(textView);

        Mockito.verify(textView, Mockito.atLeastOnce()).setVisibility(View.VISIBLE);
    }
}
