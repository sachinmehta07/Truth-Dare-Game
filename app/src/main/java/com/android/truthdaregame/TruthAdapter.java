package com.android.truthdaregame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TruthAdapter extends RecyclerView.Adapter<TruthAdapter.TruthViewHolder> {

    private ArrayList<TruthItem> mTruthList;

    private int selectedPos = 0;
    private Context context;

    public static class TruthViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public TruthViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.bgTxt);
        }
    }

    public TruthAdapter(ArrayList<TruthItem> truthList, Context context) {
        this.context = context;
        mTruthList = truthList;
    }

    @NonNull
    @Override
    public TruthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_card, parent, false);
        TruthViewHolder truthViewHolder = new TruthViewHolder(view);
        return truthViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TruthViewHolder holder, int position) {
        TruthItem currentItem = mTruthList.get(position);
        holder.textView.setText(currentItem.getmText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPos = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
        if (selectedPos == holder.getAdapterPosition()) {
            holder.imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_option));
        } else {
            holder.imageView.setBackground(null);
        }
    }

    @Override
    public int getItemCount() {
        return mTruthList.size();
    }
}
