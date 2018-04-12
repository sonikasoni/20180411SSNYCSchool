package com.example.conne.a20180411_ss_nycschool.listener;

import com.example.conne.a20180411_ss_nycschool.model.School;

import java.util.List;

public interface SchoolsResponseListener {
    void getResponse(List<School> response);
    void getError(Throwable e);
}
