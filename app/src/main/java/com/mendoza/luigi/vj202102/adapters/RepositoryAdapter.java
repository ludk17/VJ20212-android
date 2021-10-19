package com.mendoza.luigi.vj202102.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.mendoza.luigi.vj202102.MapActivity;
import com.mendoza.luigi.vj202102.R;
import com.mendoza.luigi.vj202102.entities.Repository;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.NameViewHolder> {

    private List<Repository> data;

    public RepositoryAdapter(List<Repository> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name, parent, false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.NameViewHolder holder, int position) {
        TextView tvId = holder.itemView.findViewById(R.id.tvId);
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        Repository repo = data.get(position);
        tvId.setText(String.valueOf(repo.getId()));
        tvName.setText(repo.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
