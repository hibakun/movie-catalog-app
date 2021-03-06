package com.homework.moviecatalog.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.homework.moviecatalog.R;
import com.homework.moviecatalog.databinding.TvItemListMoreBinding;
import com.homework.moviecatalog.models.TVModel;
import com.homework.moviecatalog.ui.listeners.TVListener;

import java.util.List;

public class TVAdapterMore extends RecyclerView.Adapter<TVAdapterMore.TVViewHolder> {

    private List<TVModel> tvModels;
    private LayoutInflater layoutInflater;
    private TVListener tvListener;

    public TVAdapterMore(List<TVModel> tvModels, TVListener tvListener) {
        this.tvModels = tvModels;
        this.tvListener = tvListener;
    }

    @NonNull
    @Override
    public TVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        TvItemListMoreBinding tvBinding = DataBindingUtil.inflate(layoutInflater, R.layout.tv_item_list_more, parent, false);
        return new TVViewHolder(tvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVViewHolder holder, int position) {
        holder.bindTVPopular(tvModels.get(position));
    }

    @Override
    public int getItemCount() {
        return tvModels.size();
    }

    class TVViewHolder extends RecyclerView.ViewHolder {

        private TvItemListMoreBinding tvItemListBinding;

        public TVViewHolder(TvItemListMoreBinding tvItemListBinding) {
            super(tvItemListBinding.getRoot());
            this.tvItemListBinding = tvItemListBinding;
        }

        public void bindTVPopular(TVModel tvModel) {
            tvItemListBinding.setTvModel(tvModel);
            tvItemListBinding.executePendingBindings();
            tvItemListBinding.getRoot().setOnClickListener(view -> tvListener.onTVClicked(tvModel));
        }

    }

}
