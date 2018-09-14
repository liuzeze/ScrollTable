package com.lz.scrolltable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/9/14    16:55	    刘泽			    新增 类
 * 2018/9/14	16:55	    刘泽			    增加yyy属性
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ScrollViewHolder> {

    private final SynScrollerLayout mSynScrollerview;
    private final List<String> mData;

    public MainAdapter(@Nullable List<String> data, SynScrollerLayout synScrollerview) {
        mSynScrollerview = synScrollerview;
        mData = data;
    }


    @NonNull
    @Override
    public ScrollViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.item_scroll_layout, null);


        return new ScrollViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScrollViewHolder holder, final int position) {

        holder.mView.setText(mData.get(position));
        mSynScrollerview.setOnScrollListener(new SynScrollerLayout.OnItemScrollView() {
            @Override
            public void OnScroll(int l, int t, int oldl, int oldt) {
                holder.mSynScrollerLayout.smoothScrollTo(l, 0);
            }

        });

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mSynScrollerview.onTouchEvent(v, position, event);

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ScrollViewHolder extends RecyclerView.ViewHolder {

        public final TextView mView;
        public final SynScrollerLayout mSynScrollerLayout;
        public final LinearLayout mChildRoot;

        public ScrollViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.tv);
            mSynScrollerLayout = itemView.findViewById(R.id.synscrollerview);
            mChildRoot = itemView.findViewById(R.id.ll_child_root);
            for (int i = 0; i < 20; i++) {
                View inflate = View.inflate(itemView.getContext(), R.layout.item_child_layout, null);
                TextView name = inflate.findViewById(R.id.tv);
                name.setText("内容" + i);
                mChildRoot.addView(inflate);
            }
        }
    }
}
