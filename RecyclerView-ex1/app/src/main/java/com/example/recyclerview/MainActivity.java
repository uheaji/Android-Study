package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUserList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        for (int i=0; i<50; i++) {
            users.add(new User(i, "user" + i));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false); // 레이아웃 매니저 만들고 등록 하기
        rvUserList = findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);

        userAdapter = new UserAdapter(users); // 어댑터에 데이터 넘겨주기.

        rvUserList.setAdapter(userAdapter);
    }
}