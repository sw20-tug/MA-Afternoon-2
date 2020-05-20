package at.tugraz.ist.ma.games;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
public class HangmanUITest {

    @Rule
    public IntentsTestRule<HangmanActivity> hangmanActivityIntentsTestRule = new IntentsTestRule<>(HangmanActivity.class);


    @Test
    public void checkHangmanInterface()
    {
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));

        onView(withId(R.id.guessableWord)).check(matches(isDisplayed()));


        onView(withId(R.id.buttonA)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonA)).check(matches(isClickable()));

        onView(withId(R.id.buttonB)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonB)).check(matches(isClickable()));

        onView(withId(R.id.buttonC)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonC)).check(matches(isClickable()));

        onView(withId(R.id.buttonD)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonD)).check(matches(isClickable()));

        onView(withId(R.id.buttonE)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonE)).check(matches(isClickable()));

        onView(withId(R.id.buttonF)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonF)).check(matches(isClickable()));

        onView(withId(R.id.buttonG)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonG)).check(matches(isClickable()));

        onView(withId(R.id.buttonH)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonH)).check(matches(isClickable()));

        onView(withId(R.id.buttonI)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonI)).check(matches(isClickable()));

        onView(withId(R.id.buttonJ)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonJ)).check(matches(isClickable()));

        onView(withId(R.id.buttonK)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonK)).check(matches(isClickable()));

        onView(withId(R.id.buttonL)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonL)).check(matches(isClickable()));
        onView(withId(R.id.buttonM)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonM)).check(matches(isClickable()));

        onView(withId(R.id.buttonN)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonN)).check(matches(isClickable()));

        onView(withId(R.id.buttonO)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonO)).check(matches(isClickable()));

        onView(withId(R.id.buttonP)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonP)).check(matches(isClickable()));

        onView(withId(R.id.buttonQ)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonQ)).check(matches(isClickable()));

        onView(withId(R.id.buttonR)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonR)).check(matches(isClickable()));

        onView(withId(R.id.buttonS)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonS)).check(matches(isClickable()));

        onView(withId(R.id.buttonT)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonT)).check(matches(isClickable()));

        onView(withId(R.id.buttonU)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonU)).check(matches(isClickable()));

        onView(withId(R.id.buttonV)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonV)).check(matches(isClickable()));

        onView(withId(R.id.buttonW)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonW)).check(matches(isClickable()));

        onView(withId(R.id.buttonX)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonX)).check(matches(isClickable()));

        onView(withId(R.id.buttonY)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonY)).check(matches(isClickable()));

        onView(withId(R.id.buttonZ)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonZ)).check(matches(isClickable()));

        onView(withId(R.id.buttonHangmanPlayAgain)).check(matches(not(isDisplayed())));
        onView(withId(R.id.buttonHangmanPlayAgain)).check(matches(isClickable()));

        onView(withId(R.id.hangmanWinLoose)).check(matches(not(isDisplayed())));
    }


}
