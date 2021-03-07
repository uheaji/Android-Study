package com.cos.phoneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private FloatingActionButton fabAdduser;
    private RecyclerView rvUserList;
    private UserAdpater userAdpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "user" + i, "phone" + i));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false); // 레이아웃 매니저 만들고 등록 하기
        rvUserList = findViewById(R.id.rv_userList);
        rvUserList.setLayoutManager(manager);

        userAdpater = new UserAdpater(users); // 어댑터에 데이터 넘겨주기.

        rvUserList.setAdapter(userAdpater);


        fabAdduser = findViewById(R.id.fab_addUser);
        fabAdduser.setOnClickListener(v -> {
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
        });

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);


    }
}