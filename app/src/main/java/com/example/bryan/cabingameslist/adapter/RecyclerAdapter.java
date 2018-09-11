package com.example.bryan.cabingameslist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bryan.cabingameslist.R;
import com.example.bryan.cabingameslist.model.CabinGamesModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<CabinGamesModel> cabinGamesModelArrayList;

    public RecyclerAdapter(ArrayList<CabinGamesModel> cabinGamesModelArrayList) {
        super();
        this.cabinGamesModelArrayList = cabinGamesModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final CabinGamesModel cabinGamesModel = cabinGamesModelArrayList.get(position);

        TextView nameDisplay = holder.nameDisplay;
        nameDisplay.setText(cabinGamesModel.getName());

        TextView ownerDisplay = holder.ownerDisplay;
        ownerDisplay.setText(cabinGamesModel.getOwner());

    }

    @Override
    public int getItemCount() {
        return cabinGamesModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameDisplay;
        public TextView ownerDisplay;

        public ViewHolder(View itemView) {

            super(itemView);

            nameDisplay = itemView.findViewById(R.id.nameText);
            ownerDisplay = itemView.findViewById(R.id.ownerText);

            context = itemView.getContext();
        }
    }

}

