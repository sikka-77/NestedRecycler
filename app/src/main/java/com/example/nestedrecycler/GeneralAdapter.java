package com.example.nestedrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.GeneralHolder> {

    private Context mContext;
    private List<General> mlist;
    private int mExpandedPOsition=-1;

    public GeneralAdapter(Context context,List<General> list){
        this.mContext=context;
        this.mlist=list;
    }

    @NonNull
    @Override
    public GeneralHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater minflater=LayoutInflater.from(mContext);
        view=minflater.inflate(R.layout.display,parent,false);
        return new GeneralHolder(view);
    }

    @Override
    public void onBindViewHolder(GeneralHolder holder, int position) {
        holder.playerText.setText(mlist.get(position).getPlayer());
        holder.jobText.setText(mlist.get(position).getJob());

        final GeneralHolder vh=holder;
        final boolean isExpanded = position==mExpandedPOsition;
        holder.details.setVisibility((isExpanded) ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPOsition=isExpanded ? RecyclerView.NO_POSITION : vh.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

     class GeneralHolder extends RecyclerView.ViewHolder{

        TextView playerText;
        TextView jobText;
        LinearLayout details;

        public GeneralHolder(View itemView){
            super(itemView);
            playerText=itemView.findViewById(R.id.player_text);
            jobText=itemView.findViewById(R.id.job_text);
            details=itemView.findViewById(R.id.childLayout);
        }
    }
}
