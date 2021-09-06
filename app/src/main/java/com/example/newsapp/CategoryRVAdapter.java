package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
    private ArrayList<CategoryRVModal> categoryRVModals;
    private Context context;
    private CategoryclickInterface categoryClickInterface;

    public CategoryRVAdapter(ArrayList<CategoryRVModal> categoryRVModals , Context context , CategoryclickInterface categoryClickInterface)  {
        this.categoryRVModals = categoryRVModals;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }



    @NonNull

    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item , parent ,false);
       return  new CategoryRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryRVAdapter.ViewHolder holder, int position) {
        CategoryRVModal categoryRVModal = categoryRVModals.get(position);
        holder.categoryTV.setText(categoryRVModal.getCategory());
        Picasso.get().load(categoryRVModal.getCategoryImageurl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickInterface .onCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModals.size();
    }
    public interface CategoryclickInterface{
        void onCategoryClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView categoryTV;
        private ImageView categoryIV;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            categoryIV = itemView.findViewById(R.id.IVcategory);
            categoryTV  = itemView.findViewById(R.id.TVcategory);
        }
    }
}
