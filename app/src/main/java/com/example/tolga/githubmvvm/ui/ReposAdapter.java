package com.example.tolga.githubmvvm.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.tolga.githubmvvm.R;
import com.example.tolga.githubmvvm.databinding.RowItemBinding;
import com.example.tolga.githubmvvm.model.Repos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tolga on 24.11.2017.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private final List<Repos> reposList = new ArrayList<>();

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RowItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_item,parent,false);
        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.binding.setRepo(reposList.get(position));

    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public void setReposList(List<Repos> repos){
        this.reposList.clear();
        this.reposList.addAll(repos);
        notifyDataSetChanged();

    }

    public class RepoViewHolder extends RecyclerView.ViewHolder{

        final RowItemBinding binding;

        public RepoViewHolder(RowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
