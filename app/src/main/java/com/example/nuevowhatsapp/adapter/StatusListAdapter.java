package com.example.nuevowhatsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nuevowhatsapp.R;
import com.example.nuevowhatsapp.model.StatusList;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class StatusListAdapter extends RecyclerView.Adapter<StatusListAdapter.Holder>{
    private List<StatusList> list;
    private Context context;

    public StatusListAdapter(List<StatusList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StatusListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_status_list,parent,false);

        return new StatusListAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusListAdapter.Holder holder, int position) {
        StatusList statusList = list.get(position);

        holder.tvName.setText(statusList.getUserName());
        holder.tvDate.setText(statusList.getDate());

        Glide.with(context).load(statusList.getUrlStatus()).into(holder.profilephoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView tvName, tvDate;
        private CircularImageView profilephoto;
        public Holder(@NonNull View itemView)
        {
            super(itemView);

            tvName = itemView.findViewById(R.id.txtStatuscontacto);
            tvDate = itemView.findViewById(R.id.txtstatusdate);
            profilephoto = itemView.findViewById(R.id.imagestatus);
        }
    }
}
