package com.unaimasa.testingmvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.unaimasa.testingmvp.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHideShowTextView() {

        // Check the TextView is displayed with the right text
        onView(withId(R.id.tv_hello_world)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hello_world)).check(matches(withText("Hello World!")));

        // Check the button is displayed with the right initial text
        onView(withId(R.id.btn_visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_visibility)).check(matches(withText("HIDE")));

        // Click on the button
        onView(withId(R.id.btn_visibility)).perform(click());

        // Check that the TextView is now hidden
        onView(withId(R.id.tv_hello_world)).check(matches(not(isDisplayed())));

        // Check that the button has the proper text
        onView(withId(R.id.btn_visibility)).check(matches(withText("SHOW")));

        // Click on the button
        onView(withId(R.id.btn_visibility)).perform(click());

        // Check the TextView is displayed again with the right text
        onView(withId(R.id.tv_hello_world)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hello_world)).check(matches(withText("Hello World!")));

        // Check that the button has the proper text
        onView(withId(R.id.btn_visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_visibility)).check(matches(withText("HIDE")));
    }

}
