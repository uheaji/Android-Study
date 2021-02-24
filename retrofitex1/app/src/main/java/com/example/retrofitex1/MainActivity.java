package com.example.retrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvPost;
    private PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPost = findViewById(R.id.rv_post);

        // 레트로핏
        PostApi postApi = PostApi.retrofit.create(PostApi.class);
        Call<List<Post>> call = postApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();

                // 어댑터에 던지기 + NotifyChange해야한다!!
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                rvPost.setLayoutManager(layoutManager);

                postAdapter = new PostAdapter(posts);
                postAdapter.notifyDataSetChanged();
                rvPost.setAdapter(postAdapter);
                Log.d(TAG, "onResponse: " + posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "실패 했습니다");
            }
        });
    }


}