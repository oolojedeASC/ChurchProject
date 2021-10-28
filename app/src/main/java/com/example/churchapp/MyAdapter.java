package com.example.churchapp;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private CardData[] mylist;

    public MyAdapter(CardData[] mylist) {
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CardData myData = mylist[position];
        holder.textView.setText(mylist[position].getName());
        holder.imageView.setImageResource(mylist[position].getImages());

        //random background color
        Random random=new Random();
        int color= Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(256));
        holder.imageView.setBackgroundColor(color);
        holder.imageView.setPadding(20,20,20,20);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You are Click on" + myData.getName(), Toast.LENGTH_SHORT).show();
//background and text color change
                holder.itemView.setBackgroundColor(color);
                holder.textView.setTextColor(Color.WHITE);
                holder.imageView.setBackgroundColor(Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.picture);
            this.textView = (TextView) itemView.findViewById(R.id.church_text);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.card_layout);
        }
    }
}
