package com.pillgood.drholmes.map.hospital;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.pillgood.drholmes.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class MapHospitalDetailActivity extends Fragment {

    View view;
    String TAG = "MapHospitalDetailActivity";

    Button btnFindWay;
    View.OnClickListener cl;

    String hospitalName, hospitalAddress, hospitalTel;
    Double hospitalXPos, hospitalYPos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_map_hospital_detail, container, false);

        btnFindWay = view.findViewById(R.id.btnFindWayHospital);
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnFindWayHospital:
//                        인텐트 참고: https://www.mrlatte.net/code/2019/10/26/navigation-route-intent-android.html
//                        우선 네이버 지도로 연결되도록 구현함
//                        네이버 가이드: https://guide.ncloud-docs.com/docs/naveropenapiv3-maps-url-scheme-url-scheme
                        String url = null;
                        try {
                            url = String.format("nmap://route/public?dlat=%s&dlng=%s&dname=%s&appname=%s", hospitalYPos, hospitalXPos, URLEncoder.encode(hospitalName, "UTF-8"), "com.pillgood.drholmes");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        try {
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap"))); // 네이버 지도 설치하기 (다른 지도 띄우도록 수정)
                        }

                        break;
                }
            }
        };
        btnFindWay.setOnClickListener(cl);

        getParentFragmentManager().setFragmentResultListener("hospital_selected", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                hospitalName = bundle.getString("hospital_name");
                hospitalAddress = bundle.getString("hospital_address");
                hospitalTel = bundle.getString("hospital_tel");
                hospitalXPos = bundle.getDouble("hospital_XPos");
                hospitalYPos = bundle.getDouble("hospital_YPos");

                ((TextView) view.findViewById(R.id.hospital_detail_name)).setText(hospitalName);
                ((TextView) view.findViewById(R.id.hospital_detail_address)).setText(hospitalAddress);
                ((TextView) view.findViewById(R.id.hospital_detail_tel)).setText(hospitalTel);
            }
        });

        return view;
    }
}
