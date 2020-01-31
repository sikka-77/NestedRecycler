package com.example.nestedrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildHolder> {

    private Context mContext;
    private List<General> mlist;

    public ChildAdapter(Context context,List<General> list){
        this.mContext=context;
        this.mlist=list;
    }

    @NonNull
    @Override
    public ChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view=inflater.inflate(R.layout.child_layout,parent,false);
        return new ChildAdapter.ChildHolder(view);
    }

    @Override
    public void onBindViewHolder( ChildHolder holder, int position) {
        holder.image.setImageResource(mlist.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ChildHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ChildHolder(View itemView){
            super(itemView);
            image=itemView.findViewById(R.id.childimage);
        }

    }
}
