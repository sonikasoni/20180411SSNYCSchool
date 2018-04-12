package com.example.conne.a20180411_ss_nycschool.listener;

import com.example.conne.a20180411_ss_nycschool.model.SchoolInfo;

import retrofit2.Response;

public interface SchoolInfoListener {
    void getResponse(SchoolInfo response);
    void getError(Throwable e);
}
