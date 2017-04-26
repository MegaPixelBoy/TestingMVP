package com.unaimasa.testingmvp;

import android.view.View;

import com.unaimasa.testingmvp.utils.ViewUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ViewUtilsTest {

    @Test
    public void testShowView() throws Exception {
        final View view = Mockito.mock(View.class);

        ViewUtils.showView(view);

        Mockito.verify(view).setVisibility(View.VISIBLE);
    }

    @Test
    public void testHideView() throws Exception {
        final View view = Mockito.mock(View.class);

        ViewUtils.hideView(view);

        Mockito.verify(view).setVisibility(View.GONE);
    }

    @Test
    public void testShowViewWithNullView() throws Exception {
        ViewUtils.showView(null);
    }

    @Test
    public void testHideViewWithNullView() throws Exception {
        ViewUtils.hideView(null);
    }

}
