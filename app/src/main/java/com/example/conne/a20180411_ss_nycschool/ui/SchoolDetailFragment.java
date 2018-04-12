package com.example.conne.a20180411_ss_nycschool.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conne.a20180411_ss_nycschool.R;
import com.example.conne.a20180411_ss_nycschool.api.ApiClient;
import com.example.conne.a20180411_ss_nycschool.listener.SchoolInfoListener;
import com.example.conne.a20180411_ss_nycschool.model.SchoolInfo;
import com.example.conne.a20180411_ss_nycschool.utils.BundleKeys;

public class SchoolDetailFragment extends Fragment implements SchoolInfoListener{
    private static final String TAG = SchoolDetailFragment.class.getSimpleName();
    private ApiClient apiClient;
    private String schoolName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.school_detail_fragment, container, false);
        getActivity().setTitle(R.string.school_detail_fragment);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if(bundle != null) {
            schoolName = this.getArguments().getString(BundleKeys.SCHOOL_NAME);
            Log.d(TAG, "SchoolDetailFragment::School Name = "+schoolName);
        }
        initComponents();

    }

    private void initComponents(){
        apiClient = ApiClient.getInstance();
        apiClient.getSchoolDetailInfo(this, "Tottenville High School");
    }

    @Override
    public void getResponse(SchoolInfo response) {

    }

    @Override
    public void getError(Throwable e) {

    }
}
