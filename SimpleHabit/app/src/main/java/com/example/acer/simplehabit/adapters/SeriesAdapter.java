package com.example.acer.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.HomeScreenVO;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.TopicVO;
import com.example.acer.simplehabit.delegates.SeriesDelegate;
import com.example.acer.simplehabit.viewholders.AllTopicViewHolder;
import com.example.acer.simplehabit.viewholders.BaseViewHolder;
import com.example.acer.simplehabit.viewholders.CategoryViewHolder;
import com.example.acer.simplehabit.viewholders.StartHereViewHolder;

/**
 * Created by Acer on 5/23/2018.
 */

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder,HomeScreenVO> {
    private SeriesDelegate mDelegate;
    private static final int START_HERE = 0;
    private static final int CATEGORY=1;
    private static final int ALL_TOPIC = 2;

    public SeriesAdapter(Context context ,SeriesDelegate seriesDelegate)

    {
        super(context);
        mDelegate = seriesDelegate;



    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == START_HERE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_start_here, parent, false);
            return new StartHereViewHolder(view,mDelegate);
        } else if (viewType == CATEGORY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
            return new CategoryViewHolder(view,mDelegate);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_topics, parent, false);
            return new AllTopicViewHolder(view);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramVO){
            return START_HERE;
        }
        else if (mData.get(position) instanceof CategoriesProgramsVO)
        {
            return CATEGORY;
        }
        else if (mData.get(position) instanceof TopicVO){
            return ALL_TOPIC;
        }
        return position;
    }



}
