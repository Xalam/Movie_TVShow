package com.xalam.movietvshow.detail;

import com.xalam.movietvshow.data.DataContent;
import com.xalam.movietvshow.data.MoviesEntity;
import com.xalam.movietvshow.data.TVShowsEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel detailViewModel;
    private MoviesEntity dummyMovie = DataContent.generateMovies().get(0);
    private TVShowsEntity dummyTvShow = DataContent.generateTVShows().get(0);
    private String movieId = dummyMovie.getMovieId();
    private String tvShowId = dummyTvShow.getTvId();

    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel();
        detailViewModel.getMovie(movieId);
        detailViewModel.getTvShow(tvShowId);
    }

    @Test
    public void getMovie() {
        detailViewModel.getMovie(movieId);
        MoviesEntity moviesEntity = detailViewModel.getMovie(movieId);
        assertNotNull(moviesEntity);
        assertEquals(dummyMovie.getMovieId(), moviesEntity.getMovieId());
        assertEquals(dummyMovie.getDate(), moviesEntity.getDate());
        assertEquals(dummyMovie.getCategory(), moviesEntity.getCategory());
        assertEquals(dummyMovie.getDuration(), moviesEntity.getDuration());
        assertEquals(dummyMovie.getUserScore(), moviesEntity.getUserScore());
        assertEquals(dummyMovie.getImagePath(), moviesEntity.getImagePath());
        assertEquals(dummyMovie.getGenre(), moviesEntity.getGenre());
        assertEquals(dummyMovie.getTitle(), moviesEntity.getTitle());
        assertEquals(dummyMovie.getDescription(), moviesEntity.getDescription());
        assertEquals(dummyMovie.getYear(), moviesEntity.getYear());
    }

    @Test
    public void getTvShow() {
        detailViewModel.getTvShow(tvShowId);
        TVShowsEntity tvShowsEntity = detailViewModel.getTvShow(tvShowId);
        assertNotNull(tvShowsEntity);
        assertEquals(dummyTvShow.getTvId(), tvShowsEntity.getTvId());
        assertEquals(dummyTvShow.getDate(), tvShowsEntity.getDate());
        assertEquals(dummyTvShow.getCategory(), tvShowsEntity.getCategory());
        assertEquals(dummyTvShow.getDuration(), tvShowsEntity.getDuration());
        assertEquals(dummyTvShow.getUserScore(), tvShowsEntity.getUserScore());
        assertEquals(dummyTvShow.getImagePath(), tvShowsEntity.getImagePath());
        assertEquals(dummyTvShow.getGenre(), tvShowsEntity.getGenre());
        assertEquals(dummyTvShow.getTitle(), tvShowsEntity.getTitle());
        assertEquals(dummyTvShow.getDescription(), tvShowsEntity.getDescription());
        assertEquals(dummyTvShow.getYear(), tvShowsEntity.getYear());
    }
}