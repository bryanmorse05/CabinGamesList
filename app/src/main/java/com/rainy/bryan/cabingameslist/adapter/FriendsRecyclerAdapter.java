package com.rainy.bryan.cabingameslist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainy.bryan.cabingameslist.R;
import com.rainy.bryan.cabingameslist.model.CabinFriendsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FriendsRecyclerAdapter extends RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<CabinFriendsModel> cabinFriendsModelArrayList;

    public FriendsRecyclerAdapter(ArrayList<CabinFriendsModel> cabinFriendsModelArrayList) {
        super();
        this.cabinFriendsModelArrayList = cabinFriendsModelArrayList;
    }

    @Override
    public FriendsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_row_item, parent, false);
        FriendsRecyclerAdapter.ViewHolder viewHolder = new FriendsRecyclerAdapter.ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final FriendsRecyclerAdapter.ViewHolder holder, int position) {

        final CabinFriendsModel cabinFriendsModel = cabinFriendsModelArrayList.get(position);

        TextView nameDisplay = holder.nameDisplay;
        nameDisplay.setText(cabinFriendsModel.getName());

        TextView yearDisplay = holder.yearDisplay;
        yearDisplay.setText(cabinFriendsModel.getYear());

        TextView cabinsDisplay = holder.cabinsDisplay;
        cabinsDisplay.setText(cabinFriendsModel.getCabins());

        //Set the image using Picasso
        if (cabinFriendsModel.getPictureID() != null || cabinFriendsModel.getPictureID() != "") {

            Picasso.with(context)
                    .load(cabinFriendsModel.getPictureID())
                    .error(R.drawable.cabin_logo_gold_for_mobile)       //Handles 404, but not null
                    .into(holder.imageDisplay);
        }
        else {
            Picasso.with(context).load(R.drawable.cabin_logo_gold_for_mobile).into(holder.imageDisplay);
        }
    }

    @Override
    public int getItemCount() {
        return cabinFriendsModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameDisplay;
        public TextView yearDisplay;
        public TextView cabinsDisplay;
        public ImageView imageDisplay;

        public ViewHolder(View itemView) {

            super(itemView);

            nameDisplay = itemView.findViewById(R.id.friendName);
            yearDisplay = itemView.findViewById(R.id.friendYears);
            cabinsDisplay = itemView.findViewById(R.id.friendCabins);
            imageDisplay = itemView.findViewById(R.id.friendImage);

            context = itemView.getContext();
        }
    }
}
