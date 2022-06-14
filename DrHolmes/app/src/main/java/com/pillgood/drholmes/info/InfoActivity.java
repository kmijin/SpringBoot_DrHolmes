package com.pillgood.drholmes.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.pillgood.drholmes.R;
import com.pillgood.drholmes.map.hospital.MapHospitalActivity;
import com.pillgood.drholmes.map.pharmacy.MapPharmacyActivity;

public class InfoActivity extends Fragment {

    InfoDiseaseActivity infoDiseaseActivity;
    InfoPillActivity infoPillActivity;
    View view;
    TabLayout tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_map, container, false);

        infoDiseaseActivity = new InfoDiseaseActivity();
        infoPillActivity = new InfoPillActivity();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tab_info, infoDiseaseActivity).commit();

        tabs = (TabLayout) view.findViewById(R.id.tabs_info);
        tabs.addTab(tabs.newTab().setText("질환"));
        tabs.addTab(tabs.newTab().setText("약품"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment selected = null;
                switch (tab.getPosition()) {
                    case 0:
                        selected = infoDiseaseActivity;
                        break;
                    case 1:
                        selected = infoPillActivity;
                        break;
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tab_info, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
