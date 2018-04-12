package com.example.conne.a20180411_ss_nycschool.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.conne.a20180411_ss_nycschool.R;
import com.example.conne.a20180411_ss_nycschool.model.School;
import com.example.conne.a20180411_ss_nycschool.utils.BundleKeys;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder>{

    private List<School> schoolList;
    private SchoolFragment context;

    public SchoolListAdapter(SchoolFragment context, List<School> schoolList) {
        this.schoolList = schoolList;
        this.context = context;
    }

    static class SchoolViewHolder extends RecyclerView.ViewHolder{
        TextView schoolName;
        View listItem;
        public SchoolViewHolder(View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.school_name);
            listItem = itemView.findViewById(R.id.list_item);
        }
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_list_item, parent,false);
        return new SchoolListAdapter.SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SchoolViewHolder holder, final int position) {
        holder.schoolName.setText(schoolList.get(position).getSchoolName());
        final Bundle bundle = new Bundle();
        bundle.putString(BundleKeys.SCHOOL_NAME, schoolList.get(position).getSchoolName());
        final SchoolDetailFragment schoolDetailFragment = new SchoolDetailFragment();
        schoolDetailFragment.setArguments(bundle);
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context.getActivity()).addFragment(schoolDetailFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }
}
