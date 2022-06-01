package com.pillgood.drholmes.noti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.pillgood.drholmes.R;

import java.util.ArrayList;

public class NotiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        //===== 테스트를 위한 더미 데이터 생성 ===================
        ArrayList<String> testDataSet = new ArrayList<>();
        for (int i = 0; i<20; i++) {
            testDataSet.add("TEST DATA" + i);
        }
        //========================================================

        RecyclerView recyclerView = findViewById(R.id.noti_recycle);

        //--- LayoutManager는 아래 3가지중 하나를 선택하여 사용 ---
        // 1) LinearLayoutManager()
        // 2) GridLayoutManager()
        // 3) StaggeredGridLayoutManager()
        //---------------------------------------------------------
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정

        NotiCustomAdapter noticustomAdapter = new NotiCustomAdapter(testDataSet);
        recyclerView.setAdapter(noticustomAdapter); // 어댑터 설정
    }
}