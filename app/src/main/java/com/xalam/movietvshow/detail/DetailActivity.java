package com.xalam.movietvshow.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xalam.movietvshow.R;
import com.xalam.movietvshow.data.MoviesEntity;
import com.xalam.movietvshow.data.TVShowsEntity;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_CATEGORY = "extra_category";

    private TextView tvTitle, tvDate, tvGenre, tvDuration, tvUserScore, tvDescription;
    private ImageView imgContent, imgBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_title_detail);
        tvDate = findViewById(R.id.tv_date_detail);
        tvGenre = findViewById(R.id.tv_genre_detail);
        tvDuration = findViewById(R.id.tv_duration_detail);
        tvUserScore = findViewById(R.id.tv_score_detail);
        tvDescription = findViewById(R.id.tv_description_detail);
        imgContent = findViewById(R.id.img_detail);
        imgBackground = findViewById(R.id.img_bg_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DetailViewModel detailViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String contentId = extras.getString(EXTRA_ID);
            String category = extras.getString(EXTRA_CATEGORY);

            assert category != null;
            if (category.equals(getString(R.string.cat_movie))) {
                getSupportActionBar().setTitle(R.string.movies);
                detailMovie(detailViewModel.getMovie(contentId));
            } else {
                getSupportActionBar().setTitle(R.string.tv_shows);
                detailTvShow(detailViewModel.getTvShow(contentId));
            }
        }
    }

    private void detailMovie(MoviesEntity moviesEntity) {

        tvTitle.setText(moviesEntity.getTitle() + " (" + moviesEntity.getYear() + ")");
        tvDate.setText(moviesEntity.getDate());
        tvGenre.setText(moviesEntity.getGenre());
        tvDuration.setText(moviesEntity.getDuration());
        tvUserScore.setText(moviesEntity.getUserScore());
        tvDescription.setText(moviesEntity.getDescription());

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(imgContent);

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(imgBackground);
    }

    private void detailTvShow(TVShowsEntity tvShowsEntity) {

        tvTitle.setText(tvShowsEntity.getTitle() + " (" + tvShowsEntity.getYear() + ")");
        tvDate.setText(tvShowsEntity.getDate());
        tvGenre.setText(tvShowsEntity.getGenre());
        tvDuration.setText(tvShowsEntity.getDuration());
        tvUserScore.setText(tvShowsEntity.getUserScore());
        tvDescription.setText(tvShowsEntity.getDescription());

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(imgContent);

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(imgBackground);
    }
}