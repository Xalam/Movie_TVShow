package com.xalam.movietvshow.tvshow;

import androidx.lifecycle.ViewModel;

import com.xalam.movietvshow.data.DataContent;
import com.xalam.movietvshow.data.TVShowsEntity;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    public List<TVShowsEntity> getTvShows() {
        return DataContent.generateTVShows();
    }
}
