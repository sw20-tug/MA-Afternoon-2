package at.tugraz.ist.ma.games;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainUITest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityIntentsTestRule = new IntentsTestRule<>(MainActivity.class);


    @Test
    public void checkTextSources() {
        onView(withId(R.id.tvGameTitle)).check(matches(withText(R.string.app_name)));
        onView(withId(R.id.tvMainTicTacToe)).check(matches(withText(R.string.main_tictactoe)));
        onView(withId(R.id.tvMainHangman)).check(matches(withText(R.string.main_hangman)));
        onView(withId(R.id.tvMainWhiteTiles)).check(matches(withText(R.string.main_donttouch)));
        onView(withId(R.id.tvMainSettings)).check(matches(withText(R.string.main_othergames)));
    }


    @Test
    public void checkButtonsAndTextViewsVisible() {
        onView(withId(R.id.btnMainTicTacToe)).check(matches(isDisplayed()));
        onView(withId(R.id.btnMainHangman)).check(matches(isDisplayed()));
        onView(withId(R.id.btnMainWhiteTiles)).check(matches(isDisplayed()));
        onView(withId(R.id.btnMainSettings)).check(matches(isDisplayed()));

        onView(withId(R.id.tvGameTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMainTicTacToe)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMainHangman)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMainWhiteTiles)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMainSettings)).check(matches(isDisplayed()));

        onView(withId(R.id.tvMainPoints)).check(matches(isDisplayed()));
    }


    @Test
    public void checkButtonsClickable() {
        onView(withId(R.id.btnMainTicTacToe)).check(matches(isClickable()));
        onView(withId(R.id.btnMainHangman)).check(matches(isClickable()));
        onView(withId(R.id.btnMainWhiteTiles)).check(matches(isClickable()));
        onView(withId(R.id.btnMainSettings)).check(matches(isClickable()));
    }


    @Test
    public void checkMainToTicTacToeSettingActivitySwitch() {
        onView(withId(R.id.btnMainTicTacToe)).perform(click());
        intended(hasComponent(TicTacToeSettingsActivity.class.getName()));
    }


    @Test
    public void checkMainToHangmanActivitySwitch() {
        onView(withId(R.id.btnMainHangman)).perform(click());
        intended(hasComponent(HangmanActivity.class.getName()));
    }


    @Test
    public void checkMainToWhiteTilesActivitySwitch() {
        onView(withId(R.id.btnMainWhiteTiles)).perform(click());
        intended(hasComponent(WhiteTilesActivity.class.getName()));
    }


    @Test
    public void checkMainToSettingsActivitySwitch() {
        onView(withId(R.id.btnMainSettings)).perform(click());
    }


    @Test
    public void checkMainPoints() {
        onView(withId(R.id.tvMainPoints)).check(matches(withText(mainActivityIntentsTestRule.getActivity()
                .getString(R.string.main_yourpoints, ScoreHandler.getInstance().getScore()))));
    }

}
