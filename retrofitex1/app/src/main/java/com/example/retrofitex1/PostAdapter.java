package com.example.retrofitex1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(view); // view가 리스트뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUserId;
        private TextView tvId;
        private TextView tvTitle;
        private TextView tvText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tv_userId);
            tvId= itemView.findViewById(R.id.tv_Id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvText = itemView.findViewById(R.id.tv_text);
        }

        public void setItem(Post post) {
            tvUserId.setText(Integer.toString(post.getUserId()));
            tvId.setText(Integer.toString(post.getId()));
            tvTitle.setText(post.getTitle());
            tvText.setText(post.getText());
        }
    }
}
