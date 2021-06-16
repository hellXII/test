package com.example.derevyanko;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class recipesAdapter extends RecyclerView.Adapter<recipesAdapter.RecipeHolder> {
    ArrayList<JSONObject> recipes;
    public recipesAdapter(ArrayList<JSONObject> list) {
        super();
        recipes = list;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_one, parent, false);
        RecipeHolder holder = new RecipeHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        try {
            JSONObject recipe = recipes.get(position);
            holder.txtName.setText(recipe.getString("label"));
            holder.txtCalories.setText(recipe.getString("calories"));
            holder.txtInfo.setText(recipe.getString("totalWeight"));
            Glide.with(holder.itemView).load(recipe.getString("image")).into(holder.imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtCalories;
        TextView txtInfo;
        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgFood);
            txtName = itemView.findViewById(R.id.txtFood_title);
            txtInfo = itemView.findViewById(R.id.txtFood_info);
            txtCalories = itemView.findViewById(R.id.txtFood_calories);
        }
    }
}
