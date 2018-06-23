package com.example.acer.simplehabit.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.activities.SimpleHabitDetailActivity;
import com.example.acer.simplehabit.adapters.SeriesAdapter;
import com.example.acer.simplehabit.data.vo.HomeScreenVO;
import com.example.acer.simplehabit.delegates.SeriesDelegate;
import com.example.acer.simplehabit.mvp.presenters.SeriesListPresenter;
import com.example.acer.simplehabit.mvp.views.SeriesView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/18/2018.
 */

public class SeriesFragment extends Fragment implements SeriesView{

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter ;
    private SeriesDelegate mDelegate;

    private SeriesListPresenter mPresenter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        mPresenter = new SeriesListPresenter(this);
        mPresenter.onCreate();
        mDelegate = mPresenter;

        mSeriesAdapter = new SeriesAdapter(getContext(),mDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeries.setLayoutManager(linearLayoutManager);
        rvSeries.setAdapter(mSeriesAdapter);




        return view;

    }



    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();

    }


    @Override
    public void displayErrorMsg(String errorMsg) {

    }

    @Override
    public void displaySeriesList(List<HomeScreenVO> mData) {

            mSeriesAdapter.appendNewData(mData);
        }

    @Override
    public void launchCurrentDetailScreen(String currentId) {
        Intent intent = SimpleHabitDetailActivity.newIntentCurrentProgram(getContext());
        startActivity(intent);
    }

    @Override
    public void launchCategoryDetailScreen(String categoryId,String programId) {
        Intent intent = SimpleHabitDetailActivity.newIntentCategoryProgram(getContext(),categoryId,programId);
        startActivity(intent);


    }

}
