package at.tugraz.ist.ma.games;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

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
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainUITest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityIntentsTestRule = new IntentsTestRule<>(MainActivity.class);
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    //Test if the UI from Main Screen shows the correct text contents
    @Test
    public void checkTextSources() {
        onView(withId(R.id.tvGameTitle)).check(matches(withText(R.string.app_name)));
        onView(withId(R.id.tvMainTicTacToe)).check(matches(withText(R.string.main_tictactoe)));
        onView(withId(R.id.tvMainHangman)).check(matches(withText(R.string.main_hangman)));
        onView(withId(R.id.tvMainWhiteTiles)).check(matches(withText(R.string.main_donttouch)));
        onView(withId(R.id.tvMainSettings)).check(matches(withText(R.string.main_settings)));
    }

    //Test if the Buttons and Text fields are visible
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

        //TODO remove the next line with the "not(isDisplayed())"-Check when Points display is available
        onView(withId(R.id.tvMainPoints)).check(matches(not(isDisplayed())));
        //TODO un-comment the next line when Points display is available
        //onView(withId(R.id.tvMainPoints)).check(matches(isDisplayed()));
    }

    //Test if the Buttons are clickable
    @Test
    public void checkButtonsClickable() {
        onView(withId(R.id.btnMainTicTacToe)).check(matches(isClickable()));
        onView(withId(R.id.btnMainHangman)).check(matches(isClickable()));
        onView(withId(R.id.btnMainWhiteTiles)).check(matches(isClickable()));
        onView(withId(R.id.btnMainSettings)).check(matches(isClickable()));
    }


    // Test, if the correct activities are opened when pressing buttons
    @Test
    public void checkMainToTicTacToeActivitySwitch() {
        // TODO: Change destination when Tic Tac Toe Settings page is implemented
        onView(withId(R.id.btnMainTicTacToe)).perform(click());
        intended(hasComponent(TicTacToeActivity.class.getName()));
    }

    // Test, if the correct activities are opened when pressing buttons
    @Test
    public void checkMainToHangmanActivitySwitch() {
        onView(withId(R.id.btnMainHangman)).perform(click());
        intended(hasComponent(HangmanActivity.class.getName()));
    }

    // Test, if the correct activities are opened when pressing buttons
    @Test
    public void checkMainToWhiteTilesActivitySwitch() {
        onView(withId(R.id.btnMainWhiteTiles)).perform(click());
        // TODO un-comment next line when White Tiles activity is available
        //intended(hasComponent(WhiteTilesSettingsActivity.class.getName()));
    }

    // Test, if the correct activities are opened when pressing buttons
    @Test
    public void checkMainToSettingsActivitySwitch() {
        onView(withId(R.id.btnMainSettings)).perform(click());
        // TODO un-comment next line when Settings activity is available
        // intended(hasComponent(SettingsActivity.class.getName()));
    }

}
