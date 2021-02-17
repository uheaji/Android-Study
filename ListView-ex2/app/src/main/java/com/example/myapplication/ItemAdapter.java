package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

// 1. 컬렉션 정보
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "itemAdapter";

    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    // 전체크기를 확인하기 위해서 필요 (나도, 어댑터도)
    @Override
    public int getCount() {
        return movies.size();
    }

    // 클릭하거나 어떤 이벤트가 발생할 때 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // LayoutInflater inflater2 = LayoutInflater.from(context);
    // 객체를 생성해서 그림을 그리는 함수!!
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView : " + position);
        if (convertView == null) {
            Log.d(TAG, "convertView가 null 입니다.");
        } else {
            Log.d(TAG, "convertView가 null이 아닙니다.");
        }

        // 1. 부모 컨텍스트 가져오기
        Context context = parent.getContext();
        // 인플레이터 객체 생성 완료 (xml을 자바 객체로 만들어 주는 도구)
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 강제성이 없어서!!
        View view = inflater.inflate(R.layout.list_item, parent, false);
        // 바인딩하기
        TextView tvTitle  = view.findViewById(R.id.tv_title);
        TextView tvSubTitle  = view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());

        view.setOnClickListener(v -> {
            // Toast.makeText(context, "클릭됨"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", movies.get(position).getTitle());
            context.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            movies.remove(position);
            this.notifyDataSetChanged(); // 데이터 변경 후 , UI동기화시 호출해야함.
            return true;
        });

        return view;
    }
}
