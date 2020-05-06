package at.tugraz.ist.ma.games;

import android.content.Context;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class WhiteTilesUITest {

    @Rule
    public IntentsTestRule<WhiteTilesActivity> activityRule = new IntentsTestRule<>(WhiteTilesActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("at.tugraz.ist.ma.games", appContext.getPackageName());
    }

    void checkButtonsAndTextDisplayedAndClickable()
    {
        onView(withId(R.id.btnWhiteTilesGameButton1_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton1_1)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton1_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton1_2)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton1_3)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton1_3)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton1_4)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton1_4)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton2_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton2_1)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton2_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton2_2)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton2_3)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton2_3)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton2_4)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton2_4)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton3_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton3_1)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton3_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton3_2)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton3_3)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton3_3)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton3_4)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton3_4)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton4_1)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton4_1)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton4_2)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton4_2)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton4_3)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton4_3)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesGameButton4_4)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesGameButton4_4)).check(matches(isClickable()));

        onView(withId(R.id.btnWhiteTilesRestart)).check(matches(isDisplayed()));
        onView(withId(R.id.btnWhiteTilesRestart)).check(matches(isClickable()));

        onView(withId(R.id.tvWhiteTilesYourPoints)).check(matches(isDisplayed()));
    }

}
