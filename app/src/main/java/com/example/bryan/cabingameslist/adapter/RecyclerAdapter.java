package com.example.bryan.cabingameslist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bryan.cabingameslist.GameDetailPage_Activity;
import com.example.bryan.cabingameslist.R;
import com.example.bryan.cabingameslist.model.CabinGamesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<CabinGamesModel> cabinGamesModelArrayList;
    ConstraintLayout gamesListLayout;

    public RecyclerAdapter(ArrayList<CabinGamesModel> cabinGamesModelArrayList) {
        super();
        this.cabinGamesModelArrayList = cabinGamesModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_row_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final CabinGamesModel cabinGamesModel = cabinGamesModelArrayList.get(position);

        TextView nameDisplay = holder.nameDisplay;
        nameDisplay.setText(cabinGamesModel.getName());

        TextView ownerDisplay = holder.ownerDisplay;
        ownerDisplay.setText("Provided by " + cabinGamesModel.getOwner());

        TextView playersDisplay = holder.playersDisplay;
        playersDisplay.setText(cabinGamesModel.getPlayers() + " players");

        TextView timeDisplay = holder.timeDisplay;
        timeDisplay.setText(cabinGamesModel.getTime());

        TextView descriptionDisplay = holder.descriptionDisplay;
        descriptionDisplay.setText(cabinGamesModel.getDescription());

      //Set the image using Picasso
        if (cabinGamesModel.getImageURL() != null || cabinGamesModel.getImageURL() != "") {

            Picasso.with(context)
                    .load(cabinGamesModel.getImageURL())
                    .error(R.drawable.ic_launcher_background)       //Handles 404, but not null
                    .into(holder.imageDisplay);
        }
        else {
            Picasso.with(context).load(R.drawable.ic_launcher_background).into(holder.imageDisplay);
        }

        //Setting listener for when user taps on a card
        ConstraintLayout constraintLayout = holder.constraintLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameDetailPage_Activity.class);

                intent.putExtra("name", cabinGamesModel.getName());
                intent.putExtra("imageURL", cabinGamesModel.getImageURL());
                intent.putExtra("description", cabinGamesModel.getDescription());
                intent.putExtra("tutorial", cabinGamesModel.getTutorial());
                intent.putExtra("manual", cabinGamesModel.getManual());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cabinGamesModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameDisplay;
        public TextView ownerDisplay;
        public TextView playersDisplay;
        public TextView timeDisplay;
        public TextView descriptionDisplay;
        public ImageView imageDisplay;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            nameDisplay = itemView.findViewById(R.id.nameText);
            ownerDisplay = itemView.findViewById(R.id.ownerText);
            playersDisplay = itemView.findViewById(R.id.playersText);
            timeDisplay = itemView.findViewById(R.id.timeText);
            descriptionDisplay = itemView.findViewById(R.id.descriptionText);
            imageDisplay = itemView.findViewById(R.id.gameImage);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

            context = itemView.getContext();
        }
    }

}
