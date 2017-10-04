package com.example.bobantalevski.smellslikebakin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Boban Talevski on 10/3/2017.
 */

public class ListAdapter extends RecyclerView.Adapter {

    private final ListFragment.OnRecipeSelectedInterface listener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.itemText) TextView itemText;
        @BindView(R.id.itemImage) ImageView itemImage;
        private int index;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            itemText.setText(Recipes.names[position]);
            itemImage.setImageResource(Recipes.resourceIds[position]);
            this.index = position;
        }

        @Override
        public void onClick(View view) {
            listener.onListRecipeSelected(index);
        }
    }
}
