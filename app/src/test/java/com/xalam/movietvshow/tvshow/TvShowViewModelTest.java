package com.xalam.movietvshow.tvshow;

import com.xalam.movietvshow.data.TVShowsEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel tvShowViewModel;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel();
    }

    @Test
    public void getTvShows() {
        List<TVShowsEntity> tvShowsEntities = tvShowViewModel.getTvShows();
        assertNotNull(tvShowsEntities);
        assertEquals(11, tvShowsEntities.size());
    }
}