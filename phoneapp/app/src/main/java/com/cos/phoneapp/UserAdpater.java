package com.cos.phoneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdpater extends RecyclerView.Adapter<UserAdpater.MyViewHolder>{

    private final List<User> users;

    public UserAdpater(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 메인액티비티에 연결할 객체를 만들었다.
        View view = inflater.inflate(R.layout.contact_item, parent,false);
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

        private TextView tvUserName;
        private  TextView tvUserEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tv_username);
            tvUserEmail = itemView.findViewById(R.id.tv_useremail);
        }

        public void setItem(User user) {
            tvUserName.setText(user.getUserName());
            tvUserEmail.setText(user.getUserEmail());
        }

    }
}
