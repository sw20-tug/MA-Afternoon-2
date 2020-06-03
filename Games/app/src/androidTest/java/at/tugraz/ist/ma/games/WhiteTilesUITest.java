package at.tugraz.ist.ma.games;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class WhiteTilesUITest {

    @Rule
    public IntentsTestRule<WhiteTilesActivity> activityRule = new IntentsTestRule<>(WhiteTilesActivity.class);


    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("at.tugraz.ist.ma.games", appContext.getPackageName());
    }


    @Test
    public void InterfaceUITest()
    {
        checkButtonsAndTextDisplayedAndClickable();
        onView(withId(R.id.wt_btn_WhiteTilesRestart)).check(matches(withText((activityRule.getActivity().getString(R.string.play_again)))));
        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText((activityRule.getActivity().getString(R.string.WhiteTilesYour0Points)))));
        testBoardButtonColors();
    }


    @Test
    public void clickReload()
    {
        int black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);

        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).perform(click());
        String expected_points_string = activityRule.getActivity().getString(R.string.WhiteTilesYourPoints) + 4;
        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText(expected_points_string)));
        onView(withId(R.id.wt_btn_WhiteTilesRestart)).perform(click());
        onView(withId(R.id.wt_tv_WhiteTilesYourPoints))
                .check(matches(withText(activityRule.getActivity().getString(R.string.WhiteTilesYour0Points))));

        testBoardButtonColors();
    }


    @Test
    public void clickBlackFieldTest()
    {
        int black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());

        String expected_points_string = activityRule.getActivity().getString(R.string.WhiteTilesYourPoints) + 1;

        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText(expected_points_string)));
        testBoardButtonColors();
    }


    @Test
    public void clickBlackFieldMultipleTest()
    {
        int black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);

        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());

        String expected_points_string = activityRule.getActivity().getString(R.string.WhiteTilesYourPoints) + 3;
        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText(expected_points_string)));
    }


    @Test
    public void clickWhiteFieldTest()
    {
        WhiteTiles whiteTiles = activityRule.getActivity().getWhiteTiles();
        WhiteTiles newWhiteTiles = activityRule.getActivity().getWhiteTiles();
        assertEquals(whiteTiles , newWhiteTiles);

        int white_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.WHITE);
        onView(withId(white_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_white)));
        onView(withId(white_btn_id)).perform(click());
        assertEquals(whiteTiles , newWhiteTiles);
        onView(withId(white_btn_id)).perform(click());
        assertEquals(whiteTiles , newWhiteTiles);
        onView(withId(white_btn_id)).perform(click());
        assertEquals(whiteTiles , newWhiteTiles);
        onView(withId(white_btn_id)).perform(click());
        assertEquals(whiteTiles , newWhiteTiles);
    }


    @Test
    public void fullGameTest()
    {
        int black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);

        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());

        String expected_points_string = activityRule.getActivity().getString(R.string.WhiteTilesYourPoints) + 5;

        int white_id = getOneColoredButtonID(WhiteTiles.TileColor.WHITE);
        onView(withId(white_id)).check(matches(matchesBackgroundColor(R.color.color_wt_white)));
        onView(withId(white_id)).perform(click());

        black_btn_id = getOneColoredButtonID(WhiteTiles.TileColor.BLACK);
        onView(withId(black_btn_id)).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
        onView(withId(black_btn_id)).perform(click());
        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText(expected_points_string)));

        white_id = getOneColoredButtonID(WhiteTiles.TileColor.WHITE);
        onView(withId(white_id)).check(matches(matchesBackgroundColor(R.color.color_wt_white)));
        onView(withId(white_id)).perform(click());

        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(withText(expected_points_string)));
    }


    void checkButtonsAndTextDisplayedAndClickable()
    {
        onView(withId(R.id.wt_btn_whiteTilesGameButton1_1)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton1_1)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton1_2)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton1_2)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton1_3)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton1_3)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton1_4)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton1_4)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton2_1)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton2_1)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton2_2)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton2_2)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton2_3)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton2_3)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton2_4)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton2_4)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton3_1)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton3_1)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton3_2)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton3_2)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton3_3)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton3_3)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton3_4)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton3_4)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton4_1)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton4_1)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton4_2)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton4_2)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton4_3)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton4_3)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_whiteTilesGameButton4_4)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_whiteTilesGameButton4_4)).check(matches(isClickable()));

        onView(withId(R.id.wt_btn_WhiteTilesRestart)).check(matches(isDisplayed()));
        onView(withId(R.id.wt_btn_WhiteTilesRestart)).check(matches(isClickable()));

        onView(withId(R.id.wt_tv_WhiteTilesYourPoints)).check(matches(isDisplayed()));
    }

    public int getOneColoredButtonID( WhiteTiles.TileColor color )
    {
        WhiteTiles whiteTiles = activityRule.getActivity().getWhiteTiles();
        ArrayList<WhiteTiles.TileColor> button_state = whiteTiles.getButton_state();

        for(int i = 0; i < button_state.size();i++)
        {
            if(i >= whiteTiles.getButtons().size())
            {
                return -1;
            }
            if(button_state.get(i).equals(color))
            {
                return whiteTiles.getButtons().get(i).getId();
            }
        }
        return -1;
    }

    public void testBoardButtonColors()
    {
        int black_count = 0;
        WhiteTiles whiteTiles = activityRule.getActivity().getWhiteTiles();
        ArrayList<WhiteTiles.TileColor> button_state = whiteTiles.getButton_state();

        for(int i = 0; i < button_state.size();i++)
        {
            if(i >= whiteTiles.getButtons().size())
            {
                return;
            }
            if(button_state.get(i).equals(WhiteTiles.TileColor.WHITE))
            {
                onView(withId(whiteTiles.getButtons().get(i).getId())).check(matches(matchesBackgroundColor(R.color.color_wt_white)));
            }
            else
            {
                black_count++;
                onView(withId(whiteTiles.getButtons().get(i).getId())).check(matches(matchesBackgroundColor(R.color.color_wt_black)));
            }
        }
        assertEquals(whiteTiles.getNumberOfBlackTiles(), black_count);
    }


    // --------------------------------------------------------------------------------------------
    // source:https://stackoverflow.com/questions/28742495/testing-background-color-espresso-android
    // author: Nehemias G Miranda
    public static Matcher<View> matchesBackgroundColor(final int expectedResourceId) {
        return new BoundedMatcher<View, View>(View.class) {
            int actualColor;
            int expectedColor;
            String message;

            @Override
            protected boolean matchesSafely(View item) {
                if (item.getBackground() == null) {
                    message = item.getId() + " does not have a background";
                    return false;
                }
                Resources resources = item.getContext().getResources();
                expectedColor = ResourcesCompat.getColor(resources, expectedResourceId, null);

                try {
                    actualColor = ((ColorDrawable) item.getBackground()).getColor();
                }
                catch (Exception e) {
                    actualColor = ((GradientDrawable) item.getBackground()).getColor().getDefaultColor();
                }
                return actualColor == expectedColor;
            }
            @Override
            public void describeTo(final Description description) {
                if (actualColor != 0) { message = "Background color did not match: Expected "
                        +  String.format("#%06X", (0xFFFFFF & expectedColor))
                        + " was " + String.format("#%06X", (0xFFFFFF & actualColor));
                }
                description.appendText(message);
            }
        };
    }
    //----------------------------------------------------------------------------------------------
}
