package com.pillgood.drholmes.map.pharmacy;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pillgood.drholmes.R;
import com.pillgood.drholmes.api.RetrofitAPI;
import com.pillgood.drholmes.api.pill.ItemClass;
import com.pillgood.drholmes.api.pill.Pharmacy;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MapPharmacyListActivity extends Fragment {

    View view;
    RecyclerView recyclerView;

    //retrofit 관련
    Retrofit retrofit;
    RetrofitAPI service;
    String serviceKey_origin = "J%2FS0JBdWnrQa9KR69M9AJHWjQwTch0%2F20l8%2BdpQ5wH8sMuKGfYlihZjIxwDCPjVBF9JUeaTeJr1xEhbDvcL%2BWw%3D%3D";
    String serviceKey;
    Pharmacy pharmacy;

    {
        try {
            serviceKey = URLDecoder.decode(serviceKey_origin, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_map_pharmacy_list, container, false);

        ArrayList<String> testDataSet = new ArrayList<>();

        //retrofit 시작
                try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitAPI.baseURL)
                    .addConverterFactory(TikXmlConverterFactory.create(new TikXml.Builder().exceptionOnUnreadXml(false).build()))
                    .build();
            service = retrofit.create(RetrofitAPI.class);

            service.getPharmacyInfo(serviceKey).enqueue(new Callback<Pharmacy>() {
                @Override
                public void onResponse(Call<Pharmacy> call, Response<Pharmacy> response) {
                    if (response.isSuccessful()) {
//                        Log.e("약국", "response raw=" + response.raw());
                          Log.e("약국", "response=" + response.code() + " Total=" + response.body().getBody().getTotalCount());
                        for(ItemClass item : response.body().getBody().getItems().getItem()) {
                            Log.e("약국", item.getYadmNm());
                            testDataSet.add(item.getYadmNm());
                        }
                    }
                }

                @Override
                public void onFailure(Call<Pharmacy> call, Throwable t) {
                    Log.e("약국", "ERROR=" + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("약국 Exception", e.getMessage());
        }
        //retrofit 끝

        //===== 테스트를 위한 더미 데이터 생성 ===================
//        ArrayList<String> testDataSet = new ArrayList<>();
//        for (int i = 0; i<20; i++) {
//            testDataSet.add("TEST DATA" + i);
//        }
        //========================================================
        recyclerView = view.findViewById(R.id.pharmacy_list_recycle);

        //--- LayoutManager는 아래 3가지중 하나를 선택하여 사용 ---
        // 1) LinearLayoutManager()
        // 2) GridLayoutManager()
        // 3) StaggeredGridLayoutManager()
        //---------------------------------------------------------

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정

        PharmacyListCustomAdapter hslistcustomAdapter = new PharmacyListCustomAdapter(testDataSet);
        recyclerView.setAdapter(hslistcustomAdapter); // 어댑터 설정

        return view;
    }
}
