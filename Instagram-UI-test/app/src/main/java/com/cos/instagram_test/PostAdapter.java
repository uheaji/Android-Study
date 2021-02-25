package com.cos.instagram_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private final List<User> users;

    public PostAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 메인액티비티에 연결할 객체를 만들었다.
        View view = inflater.inflate(R.layout.user_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView userId, userId2, userLikeName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_id);
            userId2 = itemView.findViewById(R.id.user_id2);
            userLikeName = itemView.findViewById(R.id.user_like_name);

        }

        public void setItem(User user) {
            userId.setText(user.getUsername());
            userId.setText(user.getUsername());
            userLikeName.setText(user.getUsername());
        }
    }
}
