package com.cst2335.rayk0001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cst2335.rayk0001.databinding.ActivityChatRoomBinding;
import com.cst2335.rayk0001.databinding.ReceiveMessageBinding;
import com.cst2335.rayk0001.databinding.SentMessageBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatRoom extends AppCompatActivity {
    ArrayList<ChatMessage> messages;

    ActivityChatRoomBinding binding;


    private RecyclerView.Adapter myAdapter;


    ChatMessage chat = new ChatMessage("", "", false);

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
    String currentDateandTime = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chat = new ViewModelProvider(this).get(ChatMessage.class);
        messages = chat.messages.getValue();

        if (messages == null) {
            chat.messages.postValue(messages = new ArrayList<ChatMessage>());
        }



        binding.sendButton.setOnClickListener(click -> {
            String message = binding.textInput.getText().toString();
            boolean sentButton = true;
            chat = new ChatMessage(message, currentDateandTime, sentButton);
            messages.add(chat);
            myAdapter.notifyItemInserted(messages.size() - 1);

            binding.textInput.setText("");
        });

        binding.receiveButton.setOnClickListener(click -> {
            String message = binding.textInput.getText().toString();
            boolean receiveButton = false;
            chat = new ChatMessage(message, currentDateandTime, receiveButton);
            messages.add(chat);
            myAdapter.notifyItemInserted(messages.size() - 1);

            binding.textInput.setText("");
        });


        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));

        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                if (viewType == 0) {

                    SentMessageBinding binding = SentMessageBinding.inflate(getLayoutInflater());
                    return new MyRowHolder(binding.getRoot());
                } else {
                    ReceiveMessageBinding binding = ReceiveMessageBinding.inflate(getLayoutInflater());
                    return new MyRowHolder(binding.getRoot());
                }

            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                ChatMessage obj = messages.get(position);
                holder.message.setText(obj.getMessage());
                holder.time.setText(obj.getTimeSent());


            }

            @Override
            public int getItemCount() {
                return messages.size();
            }

            public int getItemViewType(int position) {
                ChatMessage chat = messages.get(position);
                if (chat.isSentButton()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

    }

    class MyRowHolder extends RecyclerView.ViewHolder {
        TextView message;
        TextView time;

        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);

        }
    }

}