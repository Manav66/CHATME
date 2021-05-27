package com.example.chatme.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.chatme.Models.Message;
import com.example.chatme.R;
import com.example.chatme.databinding.ItemReceiveBinding;
import com.example.chatme.databinding.ItemSentBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Message> messages;

    final int ITEM_SENT = 1;
    final int ITEM_RECEIVE =2;

    String senderRoom;
    String receiverRoom;

    public MessagesAdapter(Context context, ArrayList<Message> messages, String senderRoom, String receiverRoom){
        this.context = context;
        this.messages = messages;
        this.senderRoom = senderRoom;
        this.receiverRoom = receiverRoom;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ITEM_SENT){
            View view = LayoutInflater.from(context).inflate(R.layout.item_sent, parent, false);
            return new SentViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_receive, parent, false);
            return new RecieverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
         Message message = messages.get(position);
         if(FirebaseAuth.getInstance().getUid().equals(message.getSenderId())){
             return ITEM_SENT;
         } else {
                return ITEM_RECEIVE;
         }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Message message = messages.get(position);


        if(holder.getClass() == SentViewHolder.class){
            SentViewHolder viewHolder = (SentViewHolder)holder;
            viewHolder.binding.message.setText(message.getMessage());

            if(message.getMessage().equals("picture")){
                viewHolder.binding.image.setVisibility(View.VISIBLE);
                viewHolder.binding.message.setVisibility(View.GONE);
                 Glide.with(context).load(message.getImageUrl())
                         .placeholder(R.drawable.placeholder).into(viewHolder.binding.image);
            }

            viewHolder.binding.message.setText(message.getMessage());

        } else {
            RecieverViewHolder viewHolder = (RecieverViewHolder) holder;

            if(message.getMessage().equals("picture")){
                viewHolder.binding.image.setVisibility(View.VISIBLE);
                viewHolder.binding.message.setVisibility(View.GONE);
                Glide.with(context)
                        .load(message.getImageUrl())
                        .placeholder(R.drawable.placeholder)
                        .into(viewHolder.binding.image);
            }
            viewHolder.binding.message.setText(message.getMessage());



        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public  class SentViewHolder extends RecyclerView.ViewHolder{

        ItemSentBinding binding;
        public SentViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemSentBinding.bind(itemView);
        }
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder {

        ItemReceiveBinding binding;
        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReceiveBinding.bind(itemView);
        }
    }
}
