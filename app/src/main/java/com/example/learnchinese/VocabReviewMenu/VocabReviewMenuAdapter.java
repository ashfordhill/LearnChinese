package com.example.learnchinese.VocabReviewMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.learnchinese.data.Categories;
import com.example.learnchinese.R;

import java.util.List;

/* Provides an adapter for the vocabulary selection menu */
public class VocabReviewMenuAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> categories;

    public VocabReviewMenuAdapter(Context context) {
        this.mContext = context;
        categories = Categories.GetCategories();
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.menu_options_row, parent, false);
        }

        // Get current category to be displayed
        String currentCategory= (String) getItem(position);

        // Get the TextView to set the category String
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.menu_option_text);

        textViewItemName.setText(currentCategory.toUpperCase());

        // returns the view for the current row
        return convertView;

    }
}

