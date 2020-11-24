package com.xalam.movietvshow.detail;

import androidx.lifecycle.ViewModel;

import com.xalam.movietvshow.data.DataContent;
import com.xalam.movietvshow.data.MoviesEntity;
import com.xalam.movietvshow.data.TVShowsEntity;

import java.util.List;

public class DetailViewModel extends ViewModel {

    public MoviesEntity getMovie(String contentId) {
        MoviesEntity movies = null;
        List<MoviesEntity> moviesEntities = DataContent.generateMovies();
        for (MoviesEntity moviesEntity : moviesEntities) {
            if (moviesEntity.getMovieId().equals(contentId)) {
                movies = moviesEntity;
            }
        }
        return movies;
    }

    public TVShowsEntity getTvShow(String contentId) {
        TVShowsEntity tvShow = null;
        List<TVShowsEntity> tvShowsEntities = DataContent.generateTVShows();
        for (TVShowsEntity tvShowsEntity : tvShowsEntities) {
            if (tvShowsEntity.getTvId().equals(contentId)) {
                tvShow = tvShowsEntity;
            }
        }
        return tvShow;
    }
}
