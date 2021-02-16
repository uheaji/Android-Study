package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Button btnAdd, btnMinus;
    private TextView tvNum;
    private Integer num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = inflate

        init();
        initSetting();
        initListener();
    }

    private void init() {
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        tvNum = findViewById(R.id.tv_num);
    }

    private void initSetting() {
        num = 1;
        tvNum.setText(num.toString());
    }


    private void initListener() {
        btnAdd.setOnClickListener(v -> {
            Log.d(TAG, "initLister: ");
            num = num + 1;
            tvNum.setText(num.toString());
        });

        btnMinus.setOnClickListener(v -> {
            Log.d(TAG, "initLister: ");
            num = num -1;
            tvNum.setText(num.toString());
        });
    }
}

