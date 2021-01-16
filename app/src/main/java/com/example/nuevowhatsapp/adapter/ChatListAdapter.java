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
import com.example.nuevowhatsapp.model.Chatlist;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {
    private List<Chatlist> list;
    private Context context;

    public ChatListAdapter(List<Chatlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chat_list,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Chatlist chatlist = list.get(position);

        holder.tvName.setText(chatlist.getUserName());
        holder.tvDesc.setText(chatlist.getDescription());
        holder.tvDate.setText(chatlist.getDate());

        Glide.with(context).load(chatlist.getUrlProfile()).into(holder.profilephoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView tvName, tvDesc, tvDate;
        private CircularImageView profilephoto;
        public Holder(@NonNull View itemView)
        {
        super(itemView);

        tvName = itemView.findViewById(R.id.txtNamecontacto);
        tvDesc = itemView.findViewById(R.id.txtMensajecontacto);
        tvDate = itemView.findViewById(R.id.txtHoraMensaje);
        profilephoto = itemView.findViewById(R.id.imageprofile);
        }
    }
}
