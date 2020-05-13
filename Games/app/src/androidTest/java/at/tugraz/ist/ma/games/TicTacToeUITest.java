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
public class TicTacToeUITest {

    @Rule
    public IntentsTestRule<TicTacToeActivity> activityRule = new IntentsTestRule<>(TicTacToeActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("at.tugraz.ist.ma.games", appContext.getPackageName());
    }

    void checkStartField()
    {
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

        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_0_1)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_0_2)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_1_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_1_1)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_1_2)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_2_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_2_1)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.btn_field_2_2)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
    }

    @Test
    public void InterfaceUITest(){
        checkStartField();

        onView(withId(R.id.btn_play_again)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_play_again)).check(matches(isClickable()));
        onView(withId(R.id.btn_play_again)).check(matches(withText(activityRule.getActivity().getString(R.string.play_again))));

        onView(withId(R.id.tvStatus)).check(matches(isDisplayed()));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));

    }

    @Test
    public void performMoveUITest()
    {
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));

        onView(withId(R.id.btn_field_0_0)).perform(click());
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_circle)));
    }

    @Test
    public void performWinUITest(){
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_none)))));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));

        onView(withId(R.id.btn_field_0_0)).perform(click());
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        onView(withId(R.id.btn_field_0_1)).perform(click());
        onView(withId(R.id.btn_field_0_1)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_circle)))));

        onView(withId(R.id.btn_field_1_0)).perform(click());
        onView(withId(R.id.btn_field_1_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        onView(withId(R.id.btn_field_0_2)).perform(click());
        onView(withId(R.id.btn_field_0_2)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_circle)))));

        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));
        onView(withId(R.id.btn_field_2_0)).perform(click());
        onView(withId(R.id.btn_field_2_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));

        // win
        onView(withId(R.id.btn_field_0_0)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_0_1)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_0_2)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_1_0)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_1_1)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_1_2)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_2_0)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_2_1)).check(matches(not(isClickable())));
        onView(withId(R.id.btn_field_2_2)).check(matches(not(isClickable())));
    }

    @Test
    public void performPlayAgain()
    {
        // perform some clicks
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));
        onView(withId(R.id.btn_field_0_0)).perform(click());
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        onView(withId(R.id.btn_field_0_1)).perform(click());
        onView(withId(R.id.btn_field_0_1)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_circle)))));

        onView(withId(R.id.btn_field_1_0)).perform(click());
        onView(withId(R.id.btn_field_1_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        onView(withId(R.id.btn_field_0_2)).perform(click());
        onView(withId(R.id.btn_field_0_2)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_circle)))));

        onView(withId(R.id.btn_field_2_0)).perform(click());
        onView(withId(R.id.btn_field_2_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        // play again
        onView(withId(R.id.btn_play_again)).perform(click());

        checkStartField();
    }

    @Test
    public void checkOccupiedField()
    {
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_cross)));

        onView(withId(R.id.btn_field_0_0)).perform(click());
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));

        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_circle)));
        onView(withId(R.id.btn_field_0_0)).perform(click());
        onView(withId(R.id.btn_field_0_0)).check(matches(withTagValue(is(activityRule.getActivity().getString(R.string.player_cross)))));
        onView(withId(R.id.tvStatus)).check(matches(withText(R.string.player_circle)));

    }

}
