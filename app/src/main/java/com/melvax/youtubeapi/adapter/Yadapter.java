package com.melvax.youtubeapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.melvax.youtubeapi.model.Example;
import com.melvax.youtubeapi.model.Item;
import com.melvax.youtubeapi.R;

import com.melvax.youtubeapi.viewholder.YviewHolder;

import java.util.List;

/**
 * Created by user on 17/03/2017.
 */

public class Yadapter extends RecyclerView.Adapter<YviewHolder> {
    private Example example;


    public Yadapter(Example example)
    {
        this.example=example;
    }
    @Override
    public YviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(YviewHolder holder, int position) {
        holder.bind(example.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return example.getItems()!=null?example.getItems().size():0;
    }
}
