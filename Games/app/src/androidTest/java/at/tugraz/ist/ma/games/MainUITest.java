package at.tugraz.ist.ma.games;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;

@RunWith(AndroidJUnit4.class)
public class MainUITest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    // Test if you can access the Tic Tac Toe Setting screen from the home screen
    @Test
    public void openTTTView() {
        onView(withId(R.id.btnTicTacToe)).perform(click());
        onView(withId(R.id.tvTicTacToe)).check(matches(isDisplayed()));
        onView(withId(R.id.tvMode)).check(doesNotExist());
    }




}
