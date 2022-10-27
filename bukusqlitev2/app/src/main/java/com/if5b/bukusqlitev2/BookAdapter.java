package com.if5b.bukusqlitev2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private Context ctx;
    private ArrayList arrayId, arrayIsbn, arrayTitle, arrayCategory, arrayDescription, arrayPrice;

    public BookAdapter(Context ctx, ArrayList arrayId, ArrayList arrayIsbn, ArrayList arrayTitle, ArrayList arrayCategory, ArrayList arrayDescription, ArrayList arrayPrice) {
        this.ctx = ctx;
        this.arrayId = arrayId;
        this.arrayIsbn = arrayId;
        this.arrayTitle = arrayTitle;
        this.arrayCategory = arrayCategory;
        this.arrayDescription = arrayDescription;
        this.arrayPrice = arrayPrice;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.tvId.setText(arrayId.get(position).toString());
        holder.tvIsbn.setText(arrayIsbn.get(position).toString());
        holder.tvTitle.setText(arrayTitle.get(position).toString());
        holder.tvCategory.setText(arrayCategory.get(position).toString());
        holder.tvDescription.setText(arrayDescription.get(position).toString());
        holder.tvPrice.setText(arrayPrice.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayId.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private TextView tvId, tvIsbn, tvTitle, tvCategory, tvDescription, tvPrice;
        private CardView cvBuku;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvIsbn = itemView.findViewById(R.id.tvIsbn);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            cvBuku = itemView.findViewById(R.id.cvBuku);
        }
    }
}

