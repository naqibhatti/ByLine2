package com.example.naqi.crictic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> mData;
    private List<Drawable> mImage;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Typeface typeface;
    Typeface typeFace2;
    Typeface typeFace3;
    Typeface typeFace4;


    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data, List<Drawable> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mImage = mData;

        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/AbrilFatface-Regular.ttf");
        typeFace2 = Typeface.createFromAsset(context.getAssets(), "fonts/adam.otf");
        typeFace3 = Typeface.createFromAsset(context.getAssets(), "fonts/zebrazil.ttf");
        typeFace4 = Typeface.createFromAsset(context.getAssets(), "fonts/anson.otf");
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        Drawable ani = mImage.get(position);

        holder.newImage.setImageDrawable(ani);
        holder.myTextView.setText(animal);

    //    if(position==0){
    //        holder.cd.setCardBackgroundColor(Color.parseColor("#673AB7"));
    //    }
    //    else if(position==1)
    //        holder.cd.setCardBackgroundColor(Color.parseColor("#ef6c00"));
    //    else if(position==2)
    //        holder.cd.setCardBackgroundColor(Color.parseColor("#2e7d32"));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView newImage;
        CardView cd;

        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);

            myTextView = itemView.findViewById(R.id.tvAnimalName);

            myTextView.setTypeface(typeFace4);

            cd = itemView.findViewById(R.id.card);
            newImage = (ImageView) itemView.findViewById(R.id.newsimage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
