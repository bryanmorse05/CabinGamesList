package com.example.bryan.cabingameslist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bryan.cabingameslist.R;
import com.example.bryan.cabingameslist.activities.VideoPlayer_Activity;
import com.example.bryan.cabingameslist.model.CabinVideosModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideosRecyclerAdapter extends RecyclerView.Adapter<VideosRecyclerAdapter.ViewHolder>{

    Context context;
    ArrayList<CabinVideosModel> cabinVideosModelArrayList;

    public VideosRecyclerAdapter(ArrayList<CabinVideosModel> cabinVideosModelArrayList) {
        super();
        this.cabinVideosModelArrayList = cabinVideosModelArrayList;
    }

    @Override
    public VideosRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_row_item_view, parent, false);
        VideosRecyclerAdapter.ViewHolder viewHolder = new VideosRecyclerAdapter.ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final VideosRecyclerAdapter.ViewHolder holder, int position) {

        final CabinVideosModel cabinVideosModel = cabinVideosModelArrayList.get(position);

        TextView yearText = holder.yearText;
        yearText.setText(cabinVideosModel.getVideoYear());

        TextView titleText = holder.titleText;
        titleText.setText(cabinVideosModel.getVideoTitle());

        //Set the image using Picasso
        if (cabinVideosModel.getPictureID() != null || cabinVideosModel.getPictureID() != "") {

            Picasso.with(context)
                    .load(cabinVideosModel.getPictureID())
                    .error(R.drawable.cabin_logo_gold_for_mobile)       //Handles 404, but not null
                    .into(holder.groupPhotoImage);
        }
        else {
            Picasso.with(context).load(R.drawable.cabin_logo_gold_for_mobile).into(holder.groupPhotoImage);
        }

        //Setting listener for when user taps on a card
        ConstraintLayout constraintLayout = holder.constraintLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, VideoPlayer_Activity.class);
                intent.putExtra("year", cabinVideosModel.getVideoYear());
                intent.putExtra("title", cabinVideosModel.getVideoTitle());
                intent.putExtra("video_id", cabinVideosModel.getVideoID());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cabinVideosModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView yearText;
        public TextView titleText;
        public ImageView groupPhotoImage;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            yearText = itemView.findViewById(R.id.videoYearText);
            titleText = itemView.findViewById(R.id.videoTitleText);
            groupPhotoImage = itemView.findViewById(R.id.videoGroupPhoto);
            constraintLayout = itemView.findViewById(R.id.videoGridLayout);

            context = itemView.getContext();
        }
    }

}
