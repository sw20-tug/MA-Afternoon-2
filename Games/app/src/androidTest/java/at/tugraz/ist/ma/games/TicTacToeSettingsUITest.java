package at.tugraz.ist.ma.games;

import android.content.Context;
import android.widget.SeekBar;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class TicTacToeSettingsUITest {

    @Rule
    public IntentsTestRule<TicTacToeSettingsActivity> activityRule = new IntentsTestRule<>(TicTacToeSettingsActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("at.tugraz.ist.ma.games", appContext.getPackageName());
    }

    public void checkInitTextViews() {
        onView(withId(R.id.ttt_tv_PlayerOneSymbol)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tv_PlayerTwoSymbol)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tv_GameMode)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tv_TicTacToe)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tv_AIDifficulty)).check(matches(not(isDisplayed())));

        onView(withId(R.id.ttt_tv_PlayerOneSymbol)).check(matches(withText(R.string.player_one)));
        onView(withId(R.id.ttt_tv_PlayerTwoSymbol)).check(matches(withText(R.string.player_two)));
        onView(withId(R.id.ttt_tv_GameMode)).check(matches(withText(R.string.GameMode)));
        onView(withId(R.id.ttt_tv_TicTacToe)).check(matches(withText(R.string.GameMode_TicTacToe)));
        onView(withId(R.id.ttt_tv_AIDifficulty)).check(matches(withText(R.string.AIDifficulty)));
    }

    @Test
    public void InterfaceUITest()
    {
        checkInitTextViews();

        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_btn_play)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_sb_AIDifficulty)).check(matches(not(isDisplayed())));

        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvP)));

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_X)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_btn_play)).check(matches(isClickable()));
        onView(withId(R.id.ttt_btn_play)).check(matches(withText(R.string.play)));

        onView(withId(R.id.ttt_sb_AIDifficulty)).check(matches(isAssignableFrom(SeekBar.class)));
    }

    @Test
    public void performStartGame() {
        onView(withId(R.id.ttt_btn_play)).perform(click());
        intended(hasComponent(TicTacToeActivity.class.getName()));
    }

    @Test
    public void changeGameModeToPVE() {
        onView(withId(R.id.ttt_tb_GameMode)).perform(click());

        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvAI)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));
    }

    @Test
    public void changeGameModeMultipleTimes() {
        onView(withId(R.id.ttt_tb_GameMode)).perform(click());

        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvAI)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));

        onView(withId(R.id.ttt_tb_GameMode)).perform(click());

        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvP)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isDisplayed()));
    }

    @Test
    public void changePlayerOnePVP() {
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_X)));
    }

    @Test
    public void changePlayerTwoPVP() {
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_X)));
    }

    @Test
    public void changePlayerPVPMutipleTimes() {
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_X)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_X)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_O)));
    }

    @Test
    public void changePlayerOnePVE() {
        onView(withId(R.id.ttt_tb_GameMode)).perform(click());
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvAI)));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));
    }

    @Test
    public void changePlayerOnePVEMultipleTimes() {
        onView(withId(R.id.ttt_tb_GameMode)).perform(click());
        onView(withId(R.id.ttt_tb_GameMode)).check(matches(withText(R.string.GameModePvAI)));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_O)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_X)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));
    }

    @Test
    public void changeMultipleSettingProperties() {
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).perform(click());
        onView(withId(R.id.ttt_tb_GameMode)).perform(click());
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isClickable()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(isNotChecked()));
        onView(withId(R.id.ttt_tb_PlayerOneSymbol)).check(matches(withText(R.string.TTT_X)));

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(not(isDisplayed())));

        onView(withId(R.id.ttt_tb_GameMode)).perform(click());

        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(isDisplayed()));
        onView(withId(R.id.ttt_tb_PlayerTwoSymbol)).check(matches(withText(R.string.TTT_O)));
    }
}
