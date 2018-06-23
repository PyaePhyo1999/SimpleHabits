package com.example.acer.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.SimpleHabitApp;
import com.example.acer.simplehabit.adapters.SessionsAdapter;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.mvp.presenters.CurrentDetailSectionPresenter;
import com.example.acer.simplehabit.mvp.views.SeriesDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Acer on 5/27/2018.
 */

public class SimpleHabitDetailActivity extends BaseActivity implements SeriesDetailView {
    public static final String CURRENT_ID="programId";

    @BindView(R.id.tv_detail_simple_habit_starter)
    TextView tvTitle;

    @BindView(R.id.tv_detail_desc)
    TextView tvDetailDesc;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    private CurrentDetailSectionPresenter mPresenter;
    private SessionsAdapter mSessionsAdapter;
    private CurrentProgramVO currentProgram;
    private ProgramVO program;
    private CategoriesProgramsVO categoriesPrograms;

    public static Intent newIntentCategoryProgram(Context context,String categoryId,String categoryProgramId) {
        Intent intent = new Intent(context, SimpleHabitDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE,SimpleHabitApp.CATEGORY);
        intent.putExtra(SimpleHabitApp.CATEGORY_ID,categoryId);
        intent.putExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID,categoryProgramId);
        return intent;
    }

    public static Intent newIntentCurrentProgram(Context context) {
        Intent intent = new Intent(context, SimpleHabitDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE,SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_activity);
        ButterKnife.bind(this, this);
        mPresenter = new CurrentDetailSectionPresenter(this);

        mSessionsAdapter = new SessionsAdapter(this);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessions.setAdapter(mSessionsAdapter);
        rvSessions.setLayoutManager(linearLayoutManager);


        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            String programId = getIntent().getStringExtra(SimpleHabitApp.PROGRAM_ID);
            mPresenter.onFinishCurrentUIComponent(programId, currentProgram);
        }
         else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);
            mPresenter.onFinishCategoryUIComponent(categoryId,categoryProgramId,program);



        }
    }
    @OnClick(R.id.btn_back_press)
    public void onBackPress(View view) {
        onBackPressed();
    }

    @Override
    public void displayErrorMsg(String errorMsg) {

    }

    @Override
    public void displayCurrentDetail(String programId,CurrentProgramVO currents) {
             mSessionsAdapter.setNewData(currents.getSessions());
            tvTitle.setText(currents.getTitle());
            tvDetailDesc.setText(currents.getDescription());
    }

    @Override
    public void displayCategoryDetail(String categoryId, String programId, ProgramVO program) {
        mSessionsAdapter.setNewData(program.getSessions());
        tvTitle.setText(program.getTitle());
        tvDetailDesc.setText(program.getDescription());
    }
}

