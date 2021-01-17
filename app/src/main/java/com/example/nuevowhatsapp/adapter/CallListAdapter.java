package com.example.nuevowhatsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nuevowhatsapp.R;
import com.example.nuevowhatsapp.model.CallList;
import com.example.nuevowhatsapp.model.Chatlist;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class CallListAdapter extends RecyclerView.Adapter<CallListAdapter.Holder> {
    private List<CallList> list;
    private Context context;

    public CallListAdapter(List<CallList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_call_list,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        CallList calllist = list.get(position);

        holder.tvName.setText(calllist.getUserName());
        holder.tvDate.setText(calllist.getDate());

        //Llamada entrante o saliente

        if (calllist.getInout().equals("in") && calllist.getAcceptordeclined().equals("accepted")) {
            holder.imgInOut.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_call_received_24));
            holder.imgInOut.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }else
        if (calllist.getInout().equals("in") && calllist.getAcceptordeclined().equals("declined"))
            {
            holder.imgInOut.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_call_received_24));
            holder.imgInOut.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_red_dark));
        }else
        if (calllist.getInout().equals("out"))
        {
            holder.imgInOut.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_call_made_24));
            holder.imgInOut.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }

        //Tipo de llamada

        if (calllist.getCallType().equals("voice")){
            holder.imgType.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_call_24));
            holder.imgType.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_call_24));
        }else
        {
            holder.imgType.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_videocam_24));
        }


        Glide.with(context).load(calllist.getUrlProfile()).into(holder.profilephoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView tvName, tvDate;
        private CircularImageView profilephoto;
        private ImageView imgType, imgInOut;
        public Holder(@NonNull View itemView)
        {
        super(itemView);

        tvName = itemView.findViewById(R.id.txtNamecontactocall);
        tvDate = itemView.findViewById(R.id.txtcalldate);
        profilephoto = itemView.findViewById(R.id.imageprofilecall);
        imgType = itemView.findViewById(R.id.calltype);
        imgInOut = itemView.findViewById(R.id.EntranteOSaliente);
        }
    }
}
