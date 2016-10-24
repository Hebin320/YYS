package com.hebin.yys;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.ViewHolder> {

    private Context context;
    private List<DateEntity.ResultsEntity> list = new ArrayList<>();

    public TotalAdapter(Context context, List<DateEntity.ResultsEntity> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     * @param list
     */
    public void updateListView(List<DateEntity.ResultsEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_total, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getName());
        if (position == 0){
            holder.viewTop.setVisibility(View.VISIBLE);
        }else {
            holder.viewTop.setVisibility(View.GONE);
        }
        if (position == list.size()-1){
            holder.viewBottom.setVisibility(View.GONE);
            holder.viewHint.setVisibility(View.VISIBLE);
        }else {
            holder.viewBottom.setVisibility(View.VISIBLE);
            holder.viewHint.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tv_title)
        TextView tvTitle;
        @InjectView(R.id.view_top)
        View viewTop;
        @InjectView(R.id.view_bottom)
        View viewBottom;
        @InjectView(R.id.view_hint)
        View viewHint;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
