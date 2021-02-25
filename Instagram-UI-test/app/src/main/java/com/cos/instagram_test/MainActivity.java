package com.cos.instagram_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvStrory, rvPost;
    private UserAdapter userAdapter;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        for (int i=1; i<10; i++) {
            users.add(new User(i, "user" + i));
        }

        LinearLayoutManager storymanager =  new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvStrory = findViewById(R.id.rv_story);
        rvStrory.setLayoutManager(storymanager);

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false); // 레이아웃 매니저 만들고 등록 하기
        rvPost = findViewById(R.id.rv_post);
        rvPost.setLayoutManager(manager);

        userAdapter = new UserAdapter(users); // 어댑터에 데이터 넘겨주기.
        postAdapter = new PostAdapter(users);

        rvStrory.setAdapter(userAdapter);
        rvPost.setAdapter(postAdapter);
    }
    }
