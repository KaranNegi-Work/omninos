package com.example.omninos;

import com.example.omninos.modelClasses.ResponseClass;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OmninosServiceClass {
    @GET("http://ominos.in/docWorldApplication/index.php/api/user/slider/")
    Call<ResponseClass> getResponse();
@GET("data.json")
    Call<Cat> getVideoData();
}
