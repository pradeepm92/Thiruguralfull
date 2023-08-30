package com.example.thirugural;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirugural.Model.Kural;
import com.example.thirugural.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class KuralAdapter extends RecyclerView.Adapter<KuralAdapter.viewholder> {
    Context context;
    ArrayList<Kural> kural = new ArrayList<>();
    Listener listener;

    public KuralAdapter(Context context, ArrayList<Kural> kural, Listener listener) {
        this.context = context;
        this.kural = kural;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KuralAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kural_row, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KuralAdapter.viewholder holder, int position) {
        int p = position;
        holder.line1.setText(kural.get(position).getLine1());
        holder.line2.setText(kural.get(position).getLine2());
        holder.listdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onclick(p);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kural.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView line1, line2;
        ImageView listdetail;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            line1 = itemView.findViewById(R.id.line1);
            line2 = itemView.findViewById(R.id.line2);
            listdetail = itemView.findViewById(R.id.detail);

        }
    }
}
