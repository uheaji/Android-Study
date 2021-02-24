package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 3번. 상속받기
public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.MyViewHolder>  {

    // 4번. 컬렉션 생성
    private final List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    // 5번. addItem(), removeItem() 만들기
    public void addItem(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    public  void removeItem(int position) {
        users.remove(position);
        notifyDataSetChanged();
    }

    // 7번. getView()랑 똑같음!
    // 차이점이 있다면 ListView는 화면에 3개가 필요하면 최초로딩시에 3개를 그려야하니까 getView가 3번 호출되고,
    // 그 다음 스크롤을 해서 2개가 추가되야 될 때, 다시 getView를 호출 함.
    // 하지만, RecyclerView는 스크롤을 해서 2개가 추가되야 할 때  onBindViewHolder를 호출 함. (데이터만 바꿔치기 하면 됨.)
    // onCreateViewHolder는 해당 Activity 실행시에만 호출 됨.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // onCreateViewHolder는 최초 실행할 때만 호출

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 메인액티비티에 연결할 객체를 만들었다.
        View view = inflater.inflate(R.layout.user_item, parent,false);
        return new MyViewHolder(view); // view가 리스트뷰에 하나 그려짐.
    }

    // 데이터를 넣어주면 된다.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // 데이터만 change 한다.
    holder.setItem(users.get(position));
    }

    // 6번. 컬렉션 크기 알려주기 (화면에 몇개를 그려야될지 알아야하기 때문이다)
    @Override
    public int getItemCount() {
        return users.size();
    }

    // 1번. ViewHolder 만들기
    // ViewHolder란 하나의 View를 가지고 있는 Holder이다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 2번. user_item이 가지고 있는 위젯들을 선언하기
        private TextView tvId;
        private TextView tvUsername;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void setItem(User user) {
            tvId.setText(user.getId().toString());
            tvUsername.setText(user.getUsername());
        }
    }
}
