package com.example.naqi.byline;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> mData;
    private List<String> mImage;
    private List<String> mDesc;
    private List<String> mChan;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ItemLongClickListener mLClickListener;

    public MainActivity main2;

    public static boolean webTrue;

    private Context context;

    Typeface typeface;
    Typeface typeFace2;
    Typeface typeFace3;
    Typeface typeFace4;
    Typeface typeFace5;
    Typeface typeFace6;
    int yellow;


    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data, List<String> mData, List<String>  desc, List<String> mChannelName) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mImage = mData;
        this.mDesc = desc;
        this.mChan = mChannelName;

        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/AbrilFatface-Regular.ttf");
        typeFace2 = Typeface.createFromAsset(context.getAssets(), "fonts/adam.otf");
        typeFace3 = Typeface.createFromAsset(context.getAssets(), "fonts/zebrazil.ttf");
        typeFace4 = Typeface.createFromAsset(context.getAssets(), "fonts/anson.otf");
        typeFace5 = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        typeFace6 = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");


        yellow = context.getResources().getColor(R.color.Yellow);
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
        String ani = mImage.get(position);
        String description = mDesc.get(position);

        holder.myTextView.setText(animal);
        holder.myDescription.setText(description);

        String channel = mChan.get(position);

        Log.d("val", "cannel is" + channel);

        if(channel.equals("Geo_Urdu")){
            Picasso.get()
                    .load(R.drawable.geourdu)
                    .into(holder.mChannel);
        }else if(channel.equals("Geo")){
            Picasso.get()
                    .load(R.drawable.geo)
                    .into(holder.mChannel);
        }else if(channel.equals("Tribune")){
            Picasso.get()
                    .load(R.drawable.tribune)
                    .into(holder.mChannel);
        }else if(channel.equals("Mango")){
            Picasso.get()
                    .load(R.drawable.mangobaaz)
                    .into(holder.mChannel);
        }else if(channel.equals("Dawn")){
            Picasso.get()
                    .load(R.drawable.dawn)
                    .into(holder.mChannel);
        }else{
            Picasso.get()
                    .load(R.drawable.dawn)
                    .into(holder.mChannel);
        }

        URI url = null;
        try {
            url = new URI(ani);
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Picasso.get()
                .load(String.valueOf(url))
                .into(holder.newImage);




//        try {
//            Bitmap bmp = null;
//            URL url = null;
//
//            try {
//                url = new URL(ani);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            try {
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setDoInput(true);
//                connection.connect();
//                InputStream input = connection.getInputStream();
//                Bitmap myBitmap = BitmapFactory.decodeStream(input);
//
//                holder.newImage.setImageBitmap(myBitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch(NullPointerException f){
//                f.printStackTrace();
//                Log.d("error", "Did not load");
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            Log.d("error", "Not");
//        }
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView newImage;
        CardView cd;

        CardView out;

        TextView myTextView;
        TextView myDescription;

        TextView byText;

        ImageView mChannel;

        ViewHolder(View itemView) {
            super(itemView);

            myTextView = itemView.findViewById(R.id.tvAnimalName);
            myDescription = itemView.findViewById(R.id.by);

            byText = itemView.findViewById(R.id.by);
            byText.setTypeface(typeFace2);

            myTextView.setTypeface(typeFace4);

            mChannel = itemView.findViewById(R.id.channel);

            cd = itemView.findViewById(R.id.card);

            newImage = (ImageView) itemView.findViewById(R.id.newsimage);
            out = itemView.findViewById(R.id.corn);

//            out.setBackgroundResource(R.drawable.cardbglighter);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (mLClickListener != null) mLClickListener.onItemLongClick(v, getAdapterPosition());
//            webTrue = true;
            Log.d("toast", "longgggggg");
            return true;
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

    // allows clicks events to be caught
    void setLongClickListener(ItemLongClickListener itemLongClickListener) {
        this.mLClickListener = itemLongClickListener;
    }


    // parent activity will implement this method to respond to click events
    public interface ItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
}
