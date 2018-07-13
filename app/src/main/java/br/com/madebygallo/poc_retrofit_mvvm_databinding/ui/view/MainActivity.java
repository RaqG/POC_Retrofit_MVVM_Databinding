package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter.CustomPagerAdapter;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.fragments.PopularMoviesTab;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.fragments.PopularTvShowsTab;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.fragments.UpcomingMoviesTab;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        CustomPagerAdapter adapter = new CustomPagerAdapter(getSupportFragmentManager());
        adapter.addTab(new PopularMoviesTab(), getString(R.string.pop_movies_title));
        adapter.addTab(new UpcomingMoviesTab(), getString(R.string.upcoming_title));
        adapter.addTab(new PopularTvShowsTab(), getString(R.string.pop_tv_show_title));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
