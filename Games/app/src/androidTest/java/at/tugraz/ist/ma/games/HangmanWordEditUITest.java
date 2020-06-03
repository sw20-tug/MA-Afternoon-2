package at.tugraz.ist.ma.games;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
public class HangmanWordEditUITest {

    @Rule
    public IntentsTestRule<HangmanWordActivity> hangmanActivityIntentsTestRule = new IntentsTestRule<>(HangmanWordActivity.class);


    @Test
    public void checkInterface()
    {
        onView(withId(R.id.sett_btn_delete)).check(matches(isDisplayed()));
        onView(withId(R.id.sett_btn_delete)).check(matches(isClickable()));
        onView(withId(R.id.sett_btn_add)).check(matches(isDisplayed()));
        onView(withId(R.id.sett_btn_add)).check(matches(isClickable()));
        onView(withId(R.id.sett_hangmanWord)).check(matches(isDisplayed()));
        onView(withId(R.id.sett_list_words)).check(matches(isDisplayed()));
    }

    @Test
    public void addWord()
    {
        onView(withId(R.id.sett_hangmanWord)).perform(click()).perform(typeText("test"));
        onView(withId(R.id.sett_btn_add)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("test")))
                .inAdapterView(withId(R.id.sett_list_words))
                .perform(click());
    }

    @Test
    public void removeWord()
    {
        onView(withId(R.id.sett_hangmanWord)).perform(click()).perform(typeText("test"));
        onView(withId(R.id.sett_btn_add)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("test")))
                .inAdapterView(withId(R.id.sett_list_words))
                .perform(click());

        onView(withId(R.id.sett_btn_delete)).perform(click());

        onView(withId(R.id.sett_list_words))
                .check(matches(not(hasDescendant(withText("test")))));
    }
}
