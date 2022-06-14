package com.pillgood.drholmes.map.hospital;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pillgood.drholmes.R;
import com.pillgood.drholmes.api.HospitalAPI;
import com.pillgood.drholmes.api.pharmacy.ItemClass;
import com.pillgood.drholmes.api.pharmacy.ResponseClass;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MapHospitalListActivity extends Fragment {

    Button mapButton;
    View.OnClickListener cl;
    FragmentManager fragmentManager;
    MapHospitalActivity hospitalActivity;
    MapHospitalDetailActivity hospitalDetailActivity;
    View view;
    RecyclerView recyclerView;
    HospitalAdapter adapter;

    //retrofit 관련
    Retrofit retrofit;
    HospitalAPI service;
    String serviceKey_origin = "J%2FS0JBdWnrQa9KR69M9AJHWjQwTch0%2F20l8%2BdpQ5wH8sMuKGfYlihZjIxwDCPjVBF9JUeaTeJr1xEhbDvcL%2BWw%3D%3D";
    String serviceKey;

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
        view = inflater.inflate(R.layout.activity_map_hospital_list, container, false);

        mapButton = (Button) view.findViewById(R.id.to_map_hospital_button);

        hospitalActivity = new MapHospitalActivity();

        fragmentManager = getParentFragmentManager();


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.to_map_hospital_button:
                        fragmentManager.beginTransaction().replace(R.id.fragment_tab_map, hospitalActivity).commit();
                        break;
                }
            }
        };
        mapButton.setOnClickListener(cl);

        hospitalDetailActivity = new MapHospitalDetailActivity();

        recyclerView = view.findViewById(R.id.hospital_list_recycle);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HospitalAdapter();

        adapter.setOnItemClickListener(new HospitalAdapter.OnPharmacyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Hospital pharmacy = adapter.getItem(position);

                Bundle bundle = new Bundle();
                bundle.putString("hospital_name", pharmacy.getName());
                bundle.putString("hospital_address", pharmacy.getAddress());
                bundle.putString("hospital_tel", pharmacy.getTel());
                bundle.putDouble("hospital_XPos", pharmacy.getXPos());
                bundle.putDouble("hospital_YPos", pharmacy.getYPos());

                fragmentManager.setFragmentResult("hospital_selected", bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_tab_map, hospitalDetailActivity).commit();
            }
        });

        recyclerView.setAdapter(adapter);

        //retrofit 시작
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(HospitalAPI.baseURL)
                    .addConverterFactory(TikXmlConverterFactory.create(new TikXml.Builder().exceptionOnUnreadXml(false).build()))
                    .build();
            service = retrofit.create(HospitalAPI.class);

            service.getPharmacyInfo(serviceKey).enqueue(new Callback<ResponseClass>() {
                @Override
                public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                    if (response.isSuccessful()) {
                        Log.e("병원", "response=" + response.code() + " Total=" + response.body().getBody().getTotalCount());
                        for(ItemClass item : response.body().getBody().getItems().getItem()) {
                            Log.e("병원", item.getYadmNm());
                            adapter.addItem(new Hospital(item.getYadmNm(), item.getClCdNm(),item.getAddr(), item.getTelno(), item.getXPos(), item.getYPos()));
                            adapter.notifyItemInserted(adapter.getItemCount());
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseClass> call, Throwable t) {
                    Log.e("병원", "ERROR=" + t.toString());
                }
            });
        } catch (Exception e) {
            Log.e("병원 Exception", e.getMessage());
        }
        //retrofit 끝
        return view;
    }
}