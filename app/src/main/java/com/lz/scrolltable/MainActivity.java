package com.lz.scrolltable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/9/14    16:55	    刘泽			    新增 类
 * 2018/9/14	16:55	    刘泽			    增加yyy属性
 */
public class MainActivity extends AppCompatActivity {
    private SynScrollerLayout mSynScrollerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        mSynScrollerview = findViewById(R.id.synscrollerview);
        LinearLayout linearLayout = findViewById(R.id.item_root);
        LinearLayout childRoot = findViewById(R.id.ll_child_root);
        linearLayout.setClickable(true);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("左侧条目" + i);
        }

        for (int i = 0; i < 20; i++) {
            View inflate = View.inflate(this, R.layout.item_child_layout, null);
            TextView name = inflate.findViewById(R.id.tv);
            name.setText("类别" + i);
            childRoot.addView(inflate);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new MainAdapter(strings, mSynScrollerview));
        recyclerView.setOnTouchListener(getListener());
        linearLayout.setOnTouchListener(getListener());

        mSynScrollerview.setOnItemClickListener(new SynScrollerLayout.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(view.getContext(), "条目" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @NonNull
    private View.OnTouchListener getListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mSynScrollerview.onTouchEvent(motionEvent);
                return false;
            }
        };
    }
}
