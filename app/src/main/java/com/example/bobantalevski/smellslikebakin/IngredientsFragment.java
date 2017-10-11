package com.example.bobantalevski.smellslikebakin;

/**
 * Created by Boban Talevski on 10/12/2017.
 */

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
