package com.cos.instagram_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private final List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 메인액티비티에 연결할 객체를 만들었다.
        View view = inflater.inflate(R.layout.story_item, parent,false);
        return new MyViewHolder(view); // view가 리스트뷰에 하나 그려짐.
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

        private TextView storyName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           storyName = itemView.findViewById(R.id.story_name);
        }

        public void setItem(User user) {
            storyName.setText(user.getUsername());
        }
    }
}
