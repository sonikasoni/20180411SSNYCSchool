package com.example.conne.a20180411_ss_nycschool.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.conne.a20180411_ss_nycschool.R;
import com.example.conne.a20180411_ss_nycschool.api.ApiClient;
import com.example.conne.a20180411_ss_nycschool.listener.SchoolsResponseListener;
import com.example.conne.a20180411_ss_nycschool.model.School;

import java.util.List;

public class SchoolFragment extends Fragment implements SchoolsResponseListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    protected ProgressBar progressBar;
    private ApiClient apiClient;
    private SchoolListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.school_fragment, container, false);
        getActivity().setTitle(R.string.school_fragment);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        apiClient = ApiClient.getInstance();
        apiClient.getSchools(this);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void getResponse(List<School> response) {
        Log.d(TAG, "MainActivity::onResponse = "+response.size());

        progressBar.setVisibility(View.GONE);
        adapter = new SchoolListAdapter(this, response);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getError(Throwable e) {
        Log.d(TAG, "MainActivity::onFailure = "+e.toString());
    }
}
