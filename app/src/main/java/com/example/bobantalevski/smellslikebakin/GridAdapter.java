package com.example.bobantalevski.smellslikebakin;

/**
 * Created by Boban Talevski on 10/12/2017.
 */

class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnRecipeSelectedInterface listener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        listener.onGridRecipeSelected(index);
    }
}
