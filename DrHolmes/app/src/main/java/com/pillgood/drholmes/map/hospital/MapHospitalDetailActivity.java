package com.pillgood.drholmes.map.hospital;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pillgood.drholmes.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MapHospitalDetailActivity extends AppCompatActivity {

    Button btnFindWay;
    View.OnClickListener cl;
//    double now_lng=127.100337, now_lat=37.513322, go_lng=127.169370, go_lat=37.447994; // 임시 좌표값 (지도API 연동 후 수정)
    String go_lng = "127.169370", go_lat = "37.447994";
    String go_name = "신구대학교남관";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_hospital_detail);

        btnFindWay = (Button) findViewById(R.id.btnFindWay);
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnFindWay:
//                        인텐트 참고: https://www.mrlatte.net/code/2019/10/26/navigation-route-intent-android.html
//                        우선 네이버 지도로 연결되도록 구현함
//                        네이버 가이드: https://guide.ncloud-docs.com/docs/naveropenapiv3-maps-url-scheme-url-scheme
                        String url = null;
                        try {
                            url = String.format("nmap://place?lat=%s&lng=%s&name=%s&appname=%s", go_lat, go_lng, URLEncoder.encode(go_name, "UTF-8"), "com.pillgood.drholmes");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

//                        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//                        if (list == null || list.isEmpty()) {
//                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap"))); // 네이버 지도 설치하기 (다른 지도 띄우도록 수정)
//                        } else {
//                            startActivity(intent);
//                        }
                        startActivity(intent);
                        break;
                }
            }
        };
        btnFindWay.setOnClickListener(cl);
    }
}
