package com.example.conne.a20180411_ss_nycschool.api;

import com.example.conne.a20180411_ss_nycschool.model.School;
import com.example.conne.a20180411_ss_nycschool.model.SchoolInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("97mf-9njv.json")
    Call<List<School>> getSchools();

    @GET("734v-jeq5.json")
    Call<SchoolInfo> getSchoolInfo(@Query("SCHOOL NAME")String schoolName);
}
