package com.xalam.movietvshow.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xalam.movietvshow.R;
import com.xalam.movietvshow.data.TVShowsEntity;

import java.util.List;

public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTvShow = view.findViewById(R.id.rv_tv_show);
        progressBar = view.findViewById(R.id.progress_tv_show);

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            progressBar.setVisibility(View.GONE);

            TvShowViewModel tvShowViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvShowViewModel.class);
            List<TVShowsEntity> tvShowsEntities = tvShowViewModel.getTvShows();
            TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShowsEntities);

            rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvTvShow.setHasFixedSize(true);
            rvTvShow.setAdapter(tvShowAdapter);
        }
    }
}