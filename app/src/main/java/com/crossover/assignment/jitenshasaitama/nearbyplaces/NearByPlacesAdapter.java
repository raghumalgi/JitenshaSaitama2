package com.crossover.assignment.jitenshasaitama.nearbyplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crossover.assignment.jitenshasaitama.R;
import com.crossover.assignment.jitenshasaitama.data.Bikes;

import java.util.List;

public class NearByPlacesAdapter extends RecyclerView.Adapter<NearByPlacesAdapter.NearByPlacesViewHolders> {

    private List<Bikes> itemList;
    private Context context;
    private NearByPlacesFragment.BikeItemListener itemListener;

    public NearByPlacesAdapter(Context context, List<Bikes> itemList,NearByPlacesFragment.BikeItemListener itemListener) {
        this.itemList = itemList;
        this.context = context;
        this.itemListener = itemListener;
    }

    @Override
    public NearByPlacesViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        NearByPlacesViewHolders rcv = new NearByPlacesViewHolders(layoutView,itemListener);
        return rcv;
    }

    @Override
    public void onBindViewHolder(NearByPlacesViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
      //  holder.countryPhoto.setImageResource(itemList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
    public Bikes getItem(int position) {
        return itemList.get(position);
    }


    public class NearByPlacesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView countryName;
        public ImageView countryPhoto;

        public NearByPlacesViewHolders(View itemView, NearByPlacesFragment.BikeItemListener itemListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            countryName = (TextView)itemView.findViewById(R.id.country_name);
            countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Bikes note = getItem(position);
            //mItemListener.(note);
        }
    }
}