package com.xalam.movietvshow.movie;

import com.xalam.movietvshow.data.MoviesEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MoviesEntity> moviesEntities = movieViewModel.getMovies();
        assertNotNull(moviesEntities);
        assertEquals(11, moviesEntities.size());
    }
}