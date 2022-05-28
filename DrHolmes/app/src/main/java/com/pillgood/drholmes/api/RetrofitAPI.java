package com.pillgood.drholmes.api;

import com.pillgood.drholmes.api.pill.Pharmacy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
    String baseURL = "http://apis.data.go.kr/B551182/";
    String getPharmacy = "pharmacyInfoService/getParmacyBasisList";

    @GET(getPharmacy)
    Call<Pharmacy> getPharmacyInfo(@Query("serviceKey") String serviceKey);
}