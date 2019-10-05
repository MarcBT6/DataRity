package com.example.datarity;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    String API_ROUTE = "character";

    @GET(API_ROUTE)
    Call<List<Header>> getHeader();

}
