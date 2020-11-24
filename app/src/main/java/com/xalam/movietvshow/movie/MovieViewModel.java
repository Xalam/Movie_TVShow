package com.xalam.movietvshow.movie;

import androidx.lifecycle.ViewModel;

import com.xalam.movietvshow.data.DataContent;
import com.xalam.movietvshow.data.MoviesEntity;

import java.util.List;

public class MovieViewModel extends ViewModel {
    public List<MoviesEntity> getMovies() {
        return DataContent.generateMovies();
    }
}
