package com.example.conne.a20180411_ss_nycschool.api;

import android.util.Log;

import com.example.conne.a20180411_ss_nycschool.listener.SchoolInfoListener;
import com.example.conne.a20180411_ss_nycschool.listener.SchoolsResponseListener;
import com.example.conne.a20180411_ss_nycschool.model.School;
import com.example.conne.a20180411_ss_nycschool.model.SchoolInfo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String TAG = ApiClient.class.getSimpleName();
    private static final String BASE_URL = "https://data.cityofnewyork.us/resource/";

    private static ApiClient apiClient;

    private ApiClient(){}

    public static ApiClient getInstance(){
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    private ApiInterface initClient(){
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();

        ApiInterface service = retrofit.create(ApiInterface.class);

        return service;

    }

    public void getSchools(final SchoolsResponseListener responseListener){

        Log.d(TAG, "Inside LoginPost");
        Call<List<School>> call = initClient().getSchools();

        call.enqueue(new Callback<List<School>>(){
            @Override
            public void onResponse(Call<List<School>> call, retrofit2.Response<List<School>> response) {
                Log.d(TAG, "onResponse = "+response.body().get(0).getSchoolName());
                responseListener.getResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d(TAG, "onFailure");
                responseListener.getError(t);

            }
        });
    }

    public void getSchoolDetailInfo(final SchoolInfoListener schoolInfoListener, String schoolName){
        Call<SchoolInfo> schoolInfoCall = initClient().getSchoolInfo(schoolName);
        schoolInfoCall.enqueue(new Callback<SchoolInfo>(){
            @Override
            public void onResponse(Call<SchoolInfo> call, retrofit2.Response<SchoolInfo> response) {
                Log.d(TAG, "onResponse::getSchoolDetailInfo = "+response.body().toString());
                schoolInfoListener.getResponse(response.body());
            }

            @Override
            public void onFailure(Call<SchoolInfo> call, Throwable t) {
                Log.d(TAG, "onFailure::getSchoolDetailInfo");
                schoolInfoListener.getError(t);

            }
        });
    }
}
