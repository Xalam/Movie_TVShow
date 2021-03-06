package com.xalam.movietvshow.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.xalam.movietvshow.R;
import com.xalam.movietvshow.data.DataContent;
import com.xalam.movietvshow.data.MoviesEntity;
import com.xalam.movietvshow.data.TVShowsEntity;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    private List<MoviesEntity> dummyMovie = DataContent.generateMovies();
    private List<TVShowsEntity> dummyTvShow = DataContent.generateTVShows();

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadTvShow() {
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(dummyTvShow.size()));
    }

    @Test
    public void loadDetailMovies() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyMovie.get(0).getTitle(), dummyMovie.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyMovie.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyMovie.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyMovie.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyMovie.get(0).getDescription())));
    }

    @Test
    public void loadDetailTvShows() {
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyTvShow.get(0).getTitle(), dummyTvShow.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyTvShow.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyTvShow.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyTvShow.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyTvShow.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyTvShow.get(0).getDescription())));
    }
}