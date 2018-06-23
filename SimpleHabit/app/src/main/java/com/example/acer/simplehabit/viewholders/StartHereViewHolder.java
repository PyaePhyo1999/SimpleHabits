package com.example.acer.simplehabit.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.delegates.SeriesDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/23/2018.
 */

public class StartHereViewHolder extends BaseViewHolder<CurrentProgramVO>{
    @BindView(R.id.tv_simple_habit_starter)
    TextView tvSimpleHabitStarter;

    @BindView(R.id.tv_day)
    TextView tvDay;

    @BindView(R.id.tv_time_for_habit_starter)
    TextView tvTFHStarter;
    @BindView(R.id.rl_current)
    RelativeLayout rlCurrent;

    private SeriesDelegate mDelegate;
    private CurrentProgramVO current;


    public StartHereViewHolder(View itemView,SeriesDelegate currentProgramDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDelegate = currentProgramDelegate;

    }

    @Override
    public void setData(CurrentProgramVO data) {
        current=data;
        tvSimpleHabitStarter.setText(data.getTitle());
        tvDay.setText(data.getCurrentPeriod());
        String avgLength="";
        for(int length: data.getAverageLengths()){
            avgLength += length+",";
        }
        tvTFHStarter.setText(avgLength+" mins");
    }

    @Override
    public void onClick(View view) {
       mDelegate.onTapCurrent(current);

    }
}
