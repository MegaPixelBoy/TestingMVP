package com.unaimasa.testingmvp.utils;


import android.view.View;

public final class ViewUtils {

    /**
     * Suppress default constructor for noninstantiability
     */
    private ViewUtils() {
        throw new AssertionError();
    }

    /**
     * Makes a view visible
     * @param view - the view to set visible
     */
    public static void showView(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Makes a view invisible
     * @param view - the view to set hide
     */
    public static void hideView(View view) {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }
}
