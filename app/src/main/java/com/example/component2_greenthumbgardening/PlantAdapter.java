package com.example.component2_greenthumbgardening;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder>{
    private static final String TAG = "PlantAdapter";
    private ArrayList<Plant> mPlants = new ArrayList<>();
    private OnPlantListener mOnPlantListener;
    private Context context;

    public PlantAdapter(ArrayList<Plant> mPlants, OnPlantListener onPlantListener){
        this.mPlants = mPlants;
        this.mOnPlantListener = onPlantListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(view, mOnPlantListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try{
            Plant plant = mPlants.get(position);
            String plantName = plant.getPlantName();
            String plantSciName = plant.getPlantSciName();
            String plantDesc = plant.getPlantDesc();


            holder.plantName.setText(plantName);
            holder.plantSciName.setText(plantSciName);
            holder.plantDesc.setText(plantDesc);

            Resources resources = context.getResources();
            final int resourceId = resources.getIdentifier(String.valueOf(plant.getPlantImage()), "drawable", context.getPackageName());
            holder.plantImage.setImageResource(resourceId);


        } catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mPlants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView plantName, plantSciName, plantDesc;
        ImageView plantImage;
        OnPlantListener onPlantListener;

        public ViewHolder(View itemView, OnPlantListener onPlantListener){
            super(itemView);
            plantName = itemView.findViewById(R.id.textView_plantName);
            plantSciName = itemView.findViewById(R.id.textView_plantSciName);
            plantImage = itemView.findViewById(R.id.plantitem_plantImage);

            this.onPlantListener = onPlantListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick:" + getAdapterPosition());
            mOnPlantListener.onPlantClick(getAdapterPosition());
        }
    }

    public interface OnPlantListener{
        void onPlantClick(int position);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }
}
