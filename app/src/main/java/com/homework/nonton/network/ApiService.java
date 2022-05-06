package com.homework.nonton.network;

import com.homework.nonton.responses.TVDetailsResponse;
import com.homework.nonton.responses.TVResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("tv/popular")
    Call<TVResponse> getTVPopular(@Query("api_key") String API_KEY, @Query("page") int PAGE);

    @GET("tv/{id}")
    Call<TVDetailsResponse> getTVPopularDetails(@Path("id") String ID, @Query("api_key") String API_KEY);

}