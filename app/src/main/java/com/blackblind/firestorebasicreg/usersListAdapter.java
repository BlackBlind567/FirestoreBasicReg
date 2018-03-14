package com.blackblind.firestorebasicreg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BlackBlind on 3/14/2018.
 */

public class usersListAdapter extends RecyclerView.Adapter<usersListAdapter.ViewHolder> {


    public List<users> usersList;
    public usersListAdapter(List<users> usersList){

        this.usersList = usersList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nameText.setText(usersList.get(position).getName());
        holder.emailText.setText(usersList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View mview;

        public TextView nameText;
        public TextView emailText;

        public ViewHolder(View itemView) {
            super(itemView);
            mview = itemView;

            nameText = (TextView) mview.findViewById(R.id.tv_name);
            emailText = (TextView) mview.findViewById(R.id.tv_email);
        }
    }
}
