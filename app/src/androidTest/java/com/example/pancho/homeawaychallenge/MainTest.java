package com.example.pancho.homeawaychallenge;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.example.pancho.homeawaychallenge.utils.RecyclerViewMatcher;
import com.example.pancho.homeawaychallenge.view.mainview.MainView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by FRANCISCO on 29/08/2017.
 */

public class MainTest {

    String search;

    @Rule
    public IntentsTestRule<MainView> intentsTestRule = new IntentsTestRule<>(MainView.class);

    @Before
    public void setup(){
        search = "Texas Rangers";
    }

    @Test
    public void doSearch() {

        //Enter search
        onView(withId(R.id.ettoolbar))
                .perform(typeText(String.valueOf(search)), ViewActions.closeSoftKeyboard());

        //Click search
        onView(withId(R.id.action_search))
                .perform(click());
    }

    @Test
    public void ClickElementRecycler() {

        //Enter search
        onView(withId(R.id.ettoolbar))
                .perform(typeText(String.valueOf(search)), ViewActions.closeSoftKeyboard());

        //Click search
        onView(withId(R.id.action_search))
                .perform(click());

        //Click first element recycler
        onView(withRecyclerView(R.id.recycler)
                .atPositionOnView(0, R.id.img))
                .perform(click());
    }

    @Test
    public void LikeElement() {

        //Enter search
        onView(withId(R.id.ettoolbar))
                .perform(typeText(String.valueOf(search)), ViewActions.closeSoftKeyboard());

        //Click search
        onView(withId(R.id.action_search))
                .perform(click());

        for (int i = 0; i < 2; i++) {

            //Click first element recycler
            onView(withRecyclerView(R.id.recycler)
                    .atPositionOnView(0, R.id.img))
                    .perform(click());

            //Click hearth
            onView(withId(R.id.hearth_button))
                    .perform(click());

            //Go back
            Espresso.pressBack();
        }
    }

    @Test
    public void ClickSettings() {
        //Enter search
        onView(withId(R.id.ettoolbar))
                .perform(typeText(String.valueOf(search)), ViewActions.closeSoftKeyboard());

        //Click search
        onView(withId(R.id.action_search))
                .perform(click());

        //Click first element recycler
        onView(withRecyclerView(R.id.recycler)
                .atPositionOnView(0, R.id.img))
                .perform(click());

        //Opens the overflow menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click search
        onView(withText(R.string.settings))
                .perform(click());

        //Go back
        Espresso.pressBack();

    }

    // Convenience helper
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
