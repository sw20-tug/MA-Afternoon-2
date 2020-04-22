package at.tugraz.ist.ma.games;

import android.content.Context;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public IntentsTestRule<TicTacToeActivity> activityRule = new IntentsTestRule<>(TicTacToeActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("at.tugraz.ist.ma.games", appContext.getPackageName());
    }

    @Test
    public void InterfaceUITest(){
        onView(withId(R.id.btn_field_0_0)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_0_0)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_0_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_0_1)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_0_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_0_2)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_1_0)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_1_0)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_1_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_1_1)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_1_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_1_2)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_2_0)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_2_0)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_2_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_2_1)).check(matches(isClickable()));
        onView(withId(R.id.btn_field_2_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_field_2_2)).check(matches(isClickable()));

        onView(withId(R.id.btn_play_again)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_play_again)).check(matches(isClickable()));
        onView(withId(R.id.btn_play_again)).check(matches(withText(activityRule.getActivity().getString(R.string.TTT_play_again))));
    }
}
