package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.mahersoua.andjokelib.JokeMainActivity;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private IdlingResource mIdlingResource;
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(mIdlingResource);
    }

    @Test
    public void useAppContextTest() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.udacity.gradle.builditbigger", appContext.getPackageName());
    }

    @Test
    public void loadJokeTest() {
        onView(withText(mActivityTestRule.getActivity().getString(R.string.button_text))).perform(click());
        String result = mActivityTestRule.getActivity().getResult();
        assertTrue(result.length() > 0);
    }

}
