package com.example.retrofitex1;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface PostApi {

    // 다운받은 데이터가 실패 할 수 도 있기 때문에 옵션을 줘야한다! -> Call<>로 감싸기
    @GET("/posts")
    Call<List<Post>>  getPosts();

    public  static  final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
