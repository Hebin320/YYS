package com.hebin.yys.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hebin.yys.entity.DateEntity;
import com.hebin.yys.help.MyItemClickListener;
import com.hebin.yys.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<DateEntity.ResultsEntity> list = new ArrayList<>();
    private MyItemClickListener listener;

    public RecyclerAdapter(Context context, List<DateEntity.ResultsEntity> list) {
        this.context = context;
        this.list = list;
    }

    public void setListener(MyItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<DateEntity.ResultsEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, listener, list);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.get(position).getName() == null || list.get(position).getName().isEmpty()) {
            holder.tvTitle.setVisibility(View.GONE);
        } else {
            holder.tvTitle.setText(list.get(position).getName());
        }
        holder.tvInfo.setText(list.get(position).getInfo());
        if (list.get(position).getImg() == 0) {
            holder.ivMain.setVisibility(View.GONE);
        } else {
            holder.ivMain.setVisibility(View.VISIBLE);
            holder.ivMain.setImageResource(list.get(position).getImg());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @InjectView(R.id.tv_title)
        TextView tvTitle;
        @InjectView(R.id.tv_info)
        TextView tvInfo;
        @InjectView(R.id.iv_main)
        ImageView ivMain;

        MyItemClickListener listener;
        List<DateEntity.ResultsEntity> list = new ArrayList<>();

        ViewHolder(View view, MyItemClickListener listener, List<DateEntity.ResultsEntity> list) {
            super(view);
            ButterKnife.inject(this, view);
            this.listener = listener;
            this.list = list;
            if (list.size() > 0) {
                view.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}
