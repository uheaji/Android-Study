package com.cos.retrofit2movieapp.service;

import com.cos.retrofit2movieapp.model.Movie;
import com.cos.retrofit2movieapp.model.ResponseDto;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {

    // 다운받은 데이터가 실패 할 수 도 있기 때문에 옵션을 줘야한다! -> 콜백 처리하기위해 Call<>로 감싸기(문법)
    // 레퍼지토리는 외부에 있는 서버이다.
    @GET("api/movie")
    Call<ResponseDto<List<Movie>>> findAll();

    // 응답을 "ok"로 받는다 -> String
    @DELETE("api/movie/{id}")
    Call<ResponseDto> deleteById(@Path("id") long id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.3:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
