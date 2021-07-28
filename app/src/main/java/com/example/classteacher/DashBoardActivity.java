package com.example.classteacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    private ListView listView;
    private BaseAdapter adapter;
    private int counter;
    private Button btu;
    //教师查看的教室号
    private String room;
    private EditText input;
    private ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        listView = (ListView)findViewById(R.id.lv);
        btu = findViewById(R.id.feedback);

        final ArrayList<Integer> list = new ArrayList<>();
        counter = 0;
        int oldCounter = counter;
        for (counter = oldCounter; counter < oldCounter + 15; counter++) {
            list.add(counter);
        }
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem != 0) { // 不为0则表示有下拉动作
                    if ((firstVisibleItem + visibleItemCount) > totalItemCount - 2) { // 当前第一个完全可见的item再下拉一个页面长度，即变为倒数第二个时
                        // 在此加载数据
                        int oldCounter = counter;
                        for (counter = oldCounter; counter < oldCounter + 15; counter++) {
                            list.add(counter);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });


        //按钮监听，教师查看学生反馈
        btu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),FeedbackActivity.class);
                startActivity(intent);
            }
        });
    }
}